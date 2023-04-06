package com.example.fakedataapp.data.model

/**
 * Data model that will store the data it receives from the API.
 */
data class PostFakeDataItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
