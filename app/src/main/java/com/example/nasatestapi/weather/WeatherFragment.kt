package com.example.nasatestapi.weather

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nasatestapi.R
import com.example.nasatestapi.base.BaseFragment
import com.example.nasatestapi.databinding.FragmentWeatherBinding

class WeatherFragment: BaseFragment<WeatherViewModel, FragmentWeatherBinding>(R.layout.fragment_weather) {
    override val binding: FragmentWeatherBinding by viewBinding(FragmentWeatherBinding::bind)
    override val viewModel: WeatherViewModel by viewModels()

    override fun setupView() {
    }

    override fun bindViewModel() {
    }
}