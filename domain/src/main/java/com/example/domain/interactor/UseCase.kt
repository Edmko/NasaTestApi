package com.example.domain.interactor

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer

abstract class UseCase<Params, T> where T : Any {
    sealed class Status<T> {
        data class Success<T>(val data: T) : Status<T>()
        class Loading<T> : Status<T>()
        data class Failure<T>(val e: Throwable) : Status<T>()
    }

    var params: Params? = null

    fun params(params: Params? = null): UseCase<Params, T> {
        this.params = params
        return this
    }

    fun subscribe(
        composer: SingleTransformer<T, T>,
        consumer: Consumer<Status<T>>
    ): Disposable {
        consumer.accept(Status.Loading())
        return createSingle(params).compose(composer)
            .subscribe({
                consumer.accept(Status.Success(it))
            }, {
                consumer.accept(Status.Failure(it))
            })
    }

    abstract fun createSingle(params: Params? = null): Single<T>
}