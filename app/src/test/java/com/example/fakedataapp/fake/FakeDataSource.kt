package com.example.fakedataapp.fake

import com.example.fakedataapp.data.model.PostFakeDataItem

object FakeDataSource {
    const val userOne = 1
    const val userTwo = 2
    const val idOne = 1
    const val idTwo = 2
    const val textOne = "textOne"
    const val textTwo = "textTwo"
    const val bodyOne = "bodyOne"
    const val bodyTwo = "bodyTwo"

    val postList = listOf(
        PostFakeDataItem(
            userId = userOne,
            id = idOne,
            title = textOne,
            body = bodyOne
        ),
        PostFakeDataItem(
            userId = userTwo,
            id = idTwo,
            title = textTwo,
            body = bodyTwo
        )
    )
}
