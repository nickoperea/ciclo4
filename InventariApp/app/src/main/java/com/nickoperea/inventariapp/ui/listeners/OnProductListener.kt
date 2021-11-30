package com.nickoperea.inventariapp.ui.listeners

import com.nickoperea.inventariapp.data.models.Product

interface OnProductListener {
    fun onClick(item: Product);
}