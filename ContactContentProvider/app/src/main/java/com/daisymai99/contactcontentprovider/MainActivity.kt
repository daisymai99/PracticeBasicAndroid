package com.daisymai99.contactcontentprovider

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_message).setOnClickListener { v ->
            startActivity( Intent(applicationContext,Message::class.java))

        }

        findViewById<Button>(R.id.btn_Contact).setOnClickListener { v ->
            startActivity( Intent(applicationContext,Contact::class.java))

        }


    }


}