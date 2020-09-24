package com.example.cattylibrary.modal

data class All(
    val _id: String,
    val text: String,
    val type: String,
    val upvotes: Int,
    val user: User,
    val userUpvoted: Any
)