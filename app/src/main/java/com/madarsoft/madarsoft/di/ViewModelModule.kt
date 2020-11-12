package com.madarsoft.madarsoft.di

import com.madarsoft.madarsoft.ui.first.FirstViewModel
import com.madarsoft.madarsoft.ui.second.SecondViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { FirstViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}