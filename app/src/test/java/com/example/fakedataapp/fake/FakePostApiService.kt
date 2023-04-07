package com.example.fakedataapp.fake

import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.data.remote.FakeDataApi

class FakePostApiService : FakeDataApi {
    override suspend fun getFakePost(): List<PostFakeDataItem> = FakeDataSource.postList
}
