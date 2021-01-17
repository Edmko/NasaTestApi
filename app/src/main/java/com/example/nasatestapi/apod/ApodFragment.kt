package com.example.nasatestapi.apod

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.domain.entities.APOD
import com.example.nasatestapi.R
import com.example.nasatestapi.base.BaseFragment
import com.example.nasatestapi.databinding.FragmentApodBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.functions.Consumer
import timber.log.Timber

@AndroidEntryPoint
class ApodFragment: BaseFragment<ApodViewModel, FragmentApodBinding> (R.layout.fragment_apod) {

    override val binding: FragmentApodBinding by viewBinding(FragmentApodBinding::bind)
    override val viewModel: ApodViewModel by viewModels()

    override fun setupView() {
    }

    override fun bindViewModel() {
        viewModel.imageResult.data.observeOn(AndroidSchedulers.mainThread())
            .subscribe(imageConsumer)
    }
    private val imageConsumer = Consumer<APOD>{
        binding.apply {
            Timber.tag("getImage").d("seting")
            Glide.with(imgTitle).load(it.image).into(imgTitle)
        }


    }
}