package me.pashashmigol.androidApp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log

object TokenKeeper {
    private const val STORAGE_KEY = "TokenKeeper"
    private const val TOKEN_KEY = "TokenK"

    fun saveToken(context: Context, token: String) {
        Log.v(STORAGE_KEY, "saveToken(); token = $token")
        context.getSharedPreferences(STORAGE_KEY, MODE_PRIVATE)
            .edit()
            .putString(TOKEN_KEY, token)
            .apply()
    }

    fun getToken(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(STORAGE_KEY, MODE_PRIVATE)
        val token = sharedPreferences.getString(TOKEN_KEY, "")
        Log.v(STORAGE_KEY, "getToken(); token = $token")
        return token
    }
}