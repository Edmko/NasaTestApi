package com.example.nasatestapi.earth

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nasatestapi.R
import com.example.nasatestapi.base.BaseFragment
import com.example.nasatestapi.databinding.FragmentEarthBinding

class EarthFragment: BaseFragment<EarthViewModel, FragmentEarthBinding>(R.layout.fragment_earth) {
    override val binding: FragmentEarthBinding by viewBinding(FragmentEarthBinding::bind)
    override val viewModel: EarthViewModel by viewModels()

    override fun setupView() {
    }

    override fun bindViewModel() {
    }
}