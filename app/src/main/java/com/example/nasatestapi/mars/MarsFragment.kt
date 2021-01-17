package com.example.nasatestapi.mars

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nasatestapi.R
import com.example.nasatestapi.base.BaseFragment
import com.example.nasatestapi.databinding.FragmentMarsBinding

class MarsFragment: BaseFragment<MarsViewModel, FragmentMarsBinding>(R.layout.fragment_mars) {
    override val binding: FragmentMarsBinding by viewBinding(FragmentMarsBinding::bind)
    override val viewModel: MarsViewModel by viewModels()

    override fun setupView() {

    }

    override fun bindViewModel() {

    }
}