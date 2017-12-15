package mekotlinapps.dnyaneshwar.`in`.boradcastreciverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import org.jetbrains.anko.longToast

/**
 * Created by Dnyaneshwar Dalvi on 15/12/17.
 */
class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent!!.extras

        try {
            if (bundle != null) {

                val objectArray = bundle.get("pdus") as Array<Any>

                for (i in 0 until objectArray.size) {

                    val smsMessage = SmsMessage.createFromPdu(objectArray[i] as ByteArray) as SmsMessage
                    val senderPhoneNumber = smsMessage.displayOriginatingAddress
                    val message = smsMessage.displayMessageBody

                    if (context != null) {
                        context.longToast("Sender Number :" + senderPhoneNumber + "\n" + "Message :" + message)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("MyBroadcastReceiver_", e.toString())
        }
    }
}
