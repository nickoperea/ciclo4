package com.nickoperea.inventariapp.utils

import android.util.Patterns

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

