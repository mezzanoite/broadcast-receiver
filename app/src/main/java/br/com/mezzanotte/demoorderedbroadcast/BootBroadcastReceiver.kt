package br.com.mezzanotte.demoorderedbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by logonrm on 17/02/2018.
 */
class BootBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Terminei a inicialização", Toast.LENGTH_LONG).show()
    }
}