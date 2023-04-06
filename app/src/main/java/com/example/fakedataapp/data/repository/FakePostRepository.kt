package com.example.fakedataapp.data.repository

import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.data.remote.FakeDataApi

/**
 * Repository class that will expose the data to the app.
 */
interface FakePostRepository {
    suspend fun obtainPost(): List<PostFakeDataItem>
}

/**
 * Implementation of the repository.
 */
class FakePostRepositoryImpl(
    private val postApiService: FakeDataApi
) : FakePostRepository {
    override suspend fun obtainPost(): List<PostFakeDataItem> =
        postApiService.getFakePost()
}
