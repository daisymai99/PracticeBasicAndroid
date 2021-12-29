package com.daisymai99.searchmenu

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isInvisible
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

        binding.listView1.choiceMode = ListView.CHOICE_MODE_SINGLE

        registerForContextMenu(binding.listView1)
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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when( item.itemId){
            R.id.font1 -> {
                Toast.makeText(this,"thứ 4",Toast.LENGTH_SHORT).show()
                Log.d("menu","lôlo")

                return true}

            R.id.fontStyle -> {
                Toast.makeText(this,"thứ 4",Toast.LENGTH_SHORT).show()
                Log.d("menu","2")

                return true}

            R.id.txtColor -> {Toast.makeText(this,"thứ 4",Toast.LENGTH_SHORT).show()
                Log.d("menu","3")

                return true}

            else -> return super.onContextItemSelected(item)
            }

    }
}