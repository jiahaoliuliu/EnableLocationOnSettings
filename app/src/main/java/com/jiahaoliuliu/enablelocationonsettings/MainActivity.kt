package com.jiahaoliuliu.enablelocationonsettings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.LocationRequest
import com.jiahaoliuliu.enablelocationonsettings.GpsUtils.GPS_REQUEST
import android.app.Activity
import android.content.Intent



class MainActivity : AppCompatActivity() {

    private var isGPS = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GpsUtils(this).turnGPSOn { isGPSEnable ->
            // turn on GPS
            isGPS = isGPSEnable
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GPS_REQUEST) {
                isGPS = true // flag maintain before get location
            }
        }
    }

}
