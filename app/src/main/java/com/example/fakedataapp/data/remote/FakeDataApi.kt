package com.example.fakedataapp.data.remote

import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.utils.Constants
import retrofit2.http.GET

/**
 * Interface that contains a method to get the fake data from the api.
 *
 * It uses a GET annotation along with the corresponding endpoint to make the call.
 */
interface FakeDataApi {
    @GET(Constants.FAKE_POST)
    suspend fun getFakePost() : List<PostFakeDataItem>
}
