package me.pashashmigol.androidApp

import Client
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import core.Player
import core.Res
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.pashashmigol.androidApp.databinding.ActivityMainBinding

@Suppress("EXPERIMENTAL_API_USAGE", "EXPERIMENTAL_OVERRIDE")
class MainActivity : AppCompatActivity(), Client.Listener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client = (application as DemoApplication).client

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        binding.enterGame.setOnClickListener { enterGame() }
        binding.clearLogs.setOnClickListener { binding.logsContainer.removeAllViews() }
        binding.sendAnswer.setOnClickListener { sendAnswer() }

        client.addListener(this)
    }

    override fun onPause() {
        super.onPause()
        client.removeListener(this)
    }

    private fun sendAnswer() {
        val answer = binding.answer.text.toString()

        if (answer.isBlank()) {
            addErrorLog("answer can't be blank")
            return
        }
        GlobalScope.launch {
            when (val res = client.submitAnswer(answer)) {
                is Res.Success -> addLog(res.data)
                is Res.Error -> addErrorLog(res.message)
            }
        }
    }

    private fun enterGame() {
        val token = TokenKeeper.getToken(context = this) ?: "no token"
        val id = binding.nickname.text.toString()

        if (id.isBlank()) {
            addErrorLog("Player name can't be blank")
            return
        }

        val player = Player(
            id = id,
            nickName = id.capitalize(),
            lat = 0.0f, long = 0.0f, radius = 0.0f,
            fcmToken = token
        )

        GlobalScope.launch {
            when (val res = client.enterGame(player)) {
                is Res.Success -> addLog(res.data)
                is Res.Error -> addErrorLog(res.message)
            }
        }
    }

    override fun onAnyEvent(event: String, data: Map<String, String?>?) {
        addLog(" ")
        addLog("===event: $event ============")
        if (data.isNullOrEmpty()) return

        addLog("data:")
        data.forEach {
            addLog("${it.key} : ${it.value}")
        }
        addLog("=============================")
    }

    override fun onGameStarted(message: String) {
        addLog("===onGameStarted(): $message")
    }

    override fun onChallenge(question: String) {
        addLog("===onChallenge(): $question")
    }

    override fun onGameEnded(message: String) {
        addLog("===onGameEnded(): $message")
    }

    override fun onError(message: String) {
        addLog("onError(): $message")
    }

    private fun addErrorLog(log: String) = addLog(log, Color.RED)

    private fun addLog(log: String, textColor: Int = Color.BLACK) {
        val textView = TextView(this).apply {
            text = log
            setTextColor(textColor)
        }
        binding.logsContainer.post {
            logsContainer.addView(textView)
        }
        binding.scrollView.postDelayed({
            binding.scrollView.scrollBy(0, textView.height)
        }, 10)
    }
}
