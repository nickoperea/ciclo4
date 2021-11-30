package com.nickoperea.inventariapp.data.models

import java.util.*

class Comment(
    var id: Long,
    var description: String,
    var author: String,
    var image: String,
    var date: Calendar
)