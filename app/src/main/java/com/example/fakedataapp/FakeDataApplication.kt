package com.example.fakedataapp

import android.app.Application
import com.example.fakedataapp.data.remote.AppContainer
import com.example.fakedataapp.data.remote.DefaultAppContainer

class FakeDataApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
