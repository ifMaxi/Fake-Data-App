package com.example.fakedataapp.fake

import com.example.fakedataapp.data.repository.FakePostRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkPostDataRepositoryTest {
    @Test
    fun networkPostDataRepository_getFakeData_verifyDataList() =
        runTest {
            val repository = FakePostRepositoryImpl(
                postApiService = FakePostApiService()
            )
            assertEquals(FakeDataSource.postList, repository.obtainPost())
        }
}
