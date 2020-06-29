package com.github.kitwtnb.learningandroid

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(
    val appHash: String
) : ViewModel()
