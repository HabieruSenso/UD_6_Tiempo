package com.utad.ud_6_tiempo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utad.ud_6_tiempo.genres.TiempoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()?.replace(R.id.container, TiempoFragment())
            ?.commit()
    }
}