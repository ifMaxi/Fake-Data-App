package com.example.fakedataapp.data.remote

import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.utils.Constants
import retrofit2.http.GET

interface FakeDataApi {
    @GET(Constants.FAKE_POST)
    suspend fun getFakePost() : List<PostFakeDataItem>
}
