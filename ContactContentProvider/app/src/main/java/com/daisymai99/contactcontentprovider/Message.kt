package com.daisymai99.contactcontentprovider

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Telephony
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat

class Message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,Array(1){android.Manifest.permission.READ_SMS},111)

        }
        else {
            readSms()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
            readSms()
    }


    private fun readSms() {

        var list = ArrayList<String>()

        // tham số thứ 3 là chọn cột để select, thứ 4 là điều kiện của cột đó, thứ 5 là sắp xếp theo tên hoặc id ...
        var cursor = contentResolver.query(Uri.parse("content://sms/inbox"),  arrayOf("_id","address","body","person"),null,null,null)


        if(cursor!= null && cursor.moveToFirst()){
            do {

                var number = cursor.getString(cursor.getColumnIndex("_id"))
                var person = cursor.getString(cursor.getColumnIndex("address"))
                var body = cursor.getString(cursor.getColumnIndex("body"))

                list.add(number + "\t"+person+"\n"+body)
                Log.d("add","aloo")
            }
                while (cursor.moveToNext())
            Log.d("next","đmmmmmmm")
                    cursor.close()
        }

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        findViewById<ListView>(R.id.listView2).adapter = adapter


    }
}