package me.pashashmigol.androidApp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import me.pashashmigol.androidApp.TokenKeeper.saveToken


class FCMService : FirebaseMessagingService() {
    companion object {
        private const val TAG = "###"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate()")
    }

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")

            handleNow(remoteMessage.data)
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }
    }

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        saveToken(context = this, token)
    }

    private fun handleNow(data: Map<String, String>) {
        Log.d(TAG, "handleNow(); data = $data")
        Toast.makeText(this, "handleNow(); data = $data", Context.MODE_PRIVATE).show()
    }

}
