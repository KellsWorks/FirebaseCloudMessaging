package com.example.firebasecloudmessaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("weather")
            .addOnCompleteListener { task ->
                var msg = "subscribed"
                if (!task.isSuccessful) {
                    msg = "not subscribed"
                }
                Log.d("TAG", msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
    }
}