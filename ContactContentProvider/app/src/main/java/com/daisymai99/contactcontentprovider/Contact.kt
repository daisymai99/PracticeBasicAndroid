package com.daisymai99.contactcontentprovider

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat

class Contact : AppCompatActivity() {


    var col = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone.CONTACT_ID).toTypedArray()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // nếu như việc đọc danh bạ chưa được user cấp quyền thì ta sẽ requset đến user bằng viết lại hàm request

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,Array(1){android.Manifest.permission.READ_CONTACTS},111)

        }
        else {
            reactContact()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
            reactContact()
    }

    private fun reactContact() {


        // tham số thứ 2 là array để đổ data vào
        var list = ArrayList<String>();
        var result = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            col,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)


//        if(result?.moveToNext()!!){
//            Toast.makeText(this,result.getString(2),Toast.LENGTH_SHORT).show()
//        }

        if(result != null && result.moveToFirst()){

            do {
                val number = result.getString(result.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                val name = result.getString(result.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                list.add(name+ " \n\n"+number+"\n")

            }
                while (result.moveToNext())
                result.close()

        }

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        findViewById<ListView>(R.id.listView1).adapter = adapter


    }
}