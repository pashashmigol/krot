package me.pashashmigol.androidApp

import Client
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val textView = findViewById<TextView>(R.id.testText)
        val client = Client()
        GlobalScope.launch {
            val status = client.enterGame()
            textView.post {
                textView.text = status
            }
        }
    }
}
