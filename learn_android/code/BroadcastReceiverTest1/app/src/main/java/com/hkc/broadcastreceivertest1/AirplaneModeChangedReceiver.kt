package com.hkc.broadcastreceivertest1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state",false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode Enabled 飛航模式開啟",Toast.LENGTH_LONG).show()


        }else{
            Toast.makeText(context,"Airplane Mode Disabled \n" +
                    "飛航模式關閉",Toast.LENGTH_LONG).show()

        }
    }


}