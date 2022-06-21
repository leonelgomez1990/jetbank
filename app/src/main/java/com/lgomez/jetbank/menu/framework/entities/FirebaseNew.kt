package com.lgomez.jetbank.menu.framework.entities

import com.lgomez.jetbank.menu.domain.News

class FirebaseNew(
    var uid: String?,
    var enabled: Boolean?,
    var title: String,
    var content: String?,
    var author: String?,
    var url: String,
    var urlToImage: String

) {
    constructor() : this("", true, "", "", "", "", "")
}

fun FirebaseNew.toNews(): News = News(uid, enabled, title, content, author, url, urlToImage)
fun News.toFirebaseNew(): FirebaseNew =
    FirebaseNew(uid, enabled, title, content, author, url ?: "", urlToImage ?: "")
