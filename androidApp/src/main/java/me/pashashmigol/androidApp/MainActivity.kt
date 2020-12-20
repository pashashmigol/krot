package me.pashashmigol.androidApp

import Client
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import core.*

@Suppress("EXPERIMENTAL_API_USAGE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val response = findViewById<TextView>(R.id.response)
        val client = Client()

        val enterGame = findViewById<Button>(R.id.enterGame)
        enterGame.setOnClickListener {
            val token = TokenKeeper.getToken(context = this) ?: "ooo"
            Log.d("###", "MainActivity.onResume(); token = $token")

            val id = System.currentTimeMillis().toString()
            val player = Player(
                id = id,
                nickName = "pasha $id",
                lat = 0.0f, long = 0.0f, radius = 0.0f,
                fcmToken = token
            )

            GlobalScope.launch {
                val status = client.enterGame(player)
                Log.d("###", "status = $status")
                response.post {
                    response.text = status
                }
            }
        }
    }
}
