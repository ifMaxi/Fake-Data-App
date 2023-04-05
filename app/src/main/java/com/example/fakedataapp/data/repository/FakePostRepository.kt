package com.example.fakedataapp.data.repository

import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.data.remote.FakeDataApi

interface FakePostRepository {
    suspend fun obtainPost(): List<PostFakeDataItem>
}

class FakePostRepositoryImpl(
    private val postApiService: FakeDataApi
) : FakePostRepository {
    override suspend fun obtainPost(): List<PostFakeDataItem> =
        postApiService.getFakePost()
}
