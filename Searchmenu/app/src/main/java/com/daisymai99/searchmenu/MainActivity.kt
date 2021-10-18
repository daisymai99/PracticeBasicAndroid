package com.daisymai99.searchmenu

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import com.daisymai99.searchmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val user = arrayOf("Mai","Ngọc","Giang Trinh","Quyên","Quỳnh","Am")
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,user)

        binding.listView1.adapter = adapter

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if(user.contains(query)){
                    adapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu);
        menuInflater.inflate(R.menu.nav_manu,menu)
        return true

    }

    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.color1 ->{ Toast.makeText(this,"Aloo",Toast.LENGTH_SHORT).show()

                Log.d("menu","1")
                binding.listView1.setBackgroundColor(Color.CYAN)
                return true}
            R.id.color2 ->{ Toast.makeText(this,"thứ 2",Toast.LENGTH_SHORT).show()
                binding.listView1.setBackgroundColor(Color.DKGRAY)

                Log.d("menu","2")
                return true}
            R.id.color3 -> {Toast.makeText(this,"thứ 4",Toast.LENGTH_SHORT).show()
                Log.d("menu","3")
                binding.listView1.setBackgroundColor(Color.MAGENTA)

                return true}
        }
        return super.onOptionsItemSelected(item)
    }
}