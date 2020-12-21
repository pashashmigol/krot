package me.pashashmigol.androidApp

import Client
import android.app.Application
import me.pashashmigol.androidApp.BuildConfig.ENDPOINT

@Suppress("EXPERIMENTAL_API_USAGE")
class DemoApplication : Application() {
    lateinit var client: Client
    override fun onCreate() {
        super.onCreate()

        client = Client(
            root = ENDPOINT,
            tellTime = { System.currentTimeMillis() }
        )
    }
}