package br.com.mezzanotte.demoorderedbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var receiver : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEnviar.setOnClickListener ({
            sendBroadcast(Intent("MeuOrderdBroadcast"))
        })

        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        receiver = object : BroadcastReceiver () {
            override fun onReceive(context: Context?, intent: Intent?) {
                // Análogo ao switch do java
                when (intent?.action) {
                    Intent.ACTION_POWER_CONNECTED -> tvUSBStatus.text = "Cabo USB conetado"
                    Intent.ACTION_POWER_DISCONNECTED -> tvUSBStatus.text = "Cabo USB desconetado"
                }
            }
        }
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}
