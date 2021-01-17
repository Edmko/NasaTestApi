package com.example.nasatestapi.base

import androidx.lifecycle.ViewModel
import com.example.domain.interactor.UseCase
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    enum class State {
        INITIAL, LOADING, SUCCESS, FAILURE
    }
    protected val disposable = CompositeDisposable()

    protected fun <T> asyncSingle(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    protected fun Disposable.autoDispose() {
        addTo(disposable)
    }

    protected fun <T : Any, Params> UseCase<Params, T>.subscribe(
        consumer: Consumer<UseCase.Status<T>>? = null
    ): Disposable {
        return if (consumer != null) {
            subscribe(asyncSingle(), consumer)
        } else {
            subscribe(asyncSingle(), Consumer { })
        }
    }

    private fun <T> UseCase.Status<T>.explodeTo(
        data: BehaviorRelay<T>,
        state: BehaviorRelay<State>
    ) {
        when (this) {
            is UseCase.Status.Loading -> state.accept(State.LOADING)
            is UseCase.Status.Success -> {
                state.accept(State.SUCCESS)
                data.accept(this.data)
            }
            is UseCase.Status.Failure -> {
                state.accept(State.FAILURE)
            }
        }
    }

    protected fun <T> explodeTo(result: UseCaseResult<T>): Consumer<UseCase.Status<T>> {
        return explodeTo(result.data, result.error, result.state)
    }

    inner class UseCaseResult<T> {
        fun consume(success: UseCase.Status.Success<T>) {
            success.explodeTo(data, state)
        }

        val data: BehaviorRelay<T> = BehaviorRelay.create()
        val error: BehaviorRelay<String> = BehaviorRelay.create()
        val state: BehaviorRelay<State> = BehaviorRelay.createDefault(State.INITIAL)
    }

    private fun <T> explodeTo(
        data: BehaviorRelay<T>,
        error: BehaviorRelay<String>,
        state: BehaviorRelay<State>
    ): Consumer<UseCase.Status<T>> {
        return Consumer {
            it.explodeTo(data, state)
            if (it is UseCase.Status.Failure) {
                Timber.e(it.e)
            }
        }
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}