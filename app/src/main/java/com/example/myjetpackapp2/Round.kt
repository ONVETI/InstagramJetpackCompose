package com.example.myjetpackapp2

class Round {
    var name: String? = null
    var img: Int? = null
    var post: Int? = null
    var likeCount: Int? = null
    var commentCount: Int? = null
    var putTime: Int? = null

    constructor()

    constructor(name: String?, img: Int?) {
        this.name = name
        this.img = img
    }

    constructor(
        name: String?,
        img: Int?,
        post: Int?,
        likeCount: Int?,
        commentCount: Int?,
        putTime: Int?,
    ) {
        this.name = name
        this.img = img
        this.post = post
        this.likeCount = likeCount
        this.commentCount = commentCount
        this.putTime = putTime
    }


}