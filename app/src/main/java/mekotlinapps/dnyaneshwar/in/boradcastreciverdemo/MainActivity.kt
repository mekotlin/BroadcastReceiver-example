package mekotlinapps.dnyaneshwar.`in`.boradcastreciverdemo

import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import org.jetbrains.anko.alert

class MainActivity : AppCompatActivity() {

    val permssoinCode: Int = 200


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermssion()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {

            permssoinCode -> if (grantResults.size > 0) {

                var locationPermissions = grantResults[0] === PackageManager.PERMISSION_GRANTED

                if (!locationPermissions) {
                    alert("Please grant permissoins ") {
                        positiveButton("OK") { }

                    }.show()
                }
            }
        }
    }

    fun requestPermssion() {
        ActivityCompat.requestPermissions(this, arrayOf("android.permission.READ_SMS", "android.permission.RECEIVE_SMS", "android.permission.SEND_SMS"), permssoinCode);
    }
}
