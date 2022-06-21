package com.lgomez.jetbank.menu.domain

data class News(
    var uid: String? = "",
    var enabled: Boolean? = true,
    var title: String = "",
    var content: String? = "",
    var author: String? = null,
    var url: String? = "",
    var urlToImage: String? = "",
)