package com.example.fakedataapp.data.remote

import com.example.fakedataapp.data.repository.FakePostRepository
import com.example.fakedataapp.data.repository.FakePostRepositoryImpl
import com.example.fakedataapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * App container, uses dependency injection to facilitate code reuse and help with testing.
 */
interface AppContainer {
    val postRepository : FakePostRepository
}

class DefaultAppContainer : AppContainer {
    /**
     * Retrofit implementation that will handle the api calls.
     */
    private val fakeRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService : FakeDataApi by lazy {
        fakeRetrofit.create(FakeDataApi::class.java)
    }

    override val postRepository: FakePostRepository by lazy {
        FakePostRepositoryImpl(retrofitService)
    }
}
