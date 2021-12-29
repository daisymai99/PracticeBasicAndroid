package com.example.sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;

    TabHost tabHost;

    ListView lstViewSong, lstViewFavouriteSong;
    SongAdapter adapterSong, adapterFavouriteSong;
    List<BaiHat> lstSong =new ArrayList<>(), lstFavouriteSong = new ArrayList<>();

    String Db_Name ="Arirang.sqlite";
    private String DB_Path ="/databases/";
    SQLiteDatabase sqLiteDatabase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        checkDb();


        createTab();

        createListView();



        showDatabase();
    }

    private void createTab() {
        // Tab
        tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("tab1");
        tabSpec1.setContent(R.id.tab1);
        tabSpec1.setIndicator("Songs");
        tabHost.addTab(tabSpec1);

        // Tab Favourite
        TabHost.TabSpec tabSpec2;
        tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("Favoutite");
        tabHost.addTab(tabSpec2);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Karaoke");
        return super.onCreateOptionsMenu(menu);
    }


    private void showDatabase() {
        sqLiteDatabase = openOrCreateDatabase(Db_Name,MODE_PRIVATE,null);

        Cursor cursor = sqLiteDatabase.query("ArirangSongList",null,null,null,null,null,null);

        lstSong.clear();
        while (cursor.moveToNext()){
            String ma = cursor.getString(0);
            String ten = cursor.getString(1);
            String casi = cursor.getString(3);
            String theLoai = cursor.getString(4);

            BaiHat baiHat = new BaiHat();
            baiHat.setMaBH(ma);
            baiHat.setTeBH(ten);
            baiHat.setCasi(casi);
            baiHat.setTheLoai(theLoai);
            lstSong.add(baiHat);
            Log.d("read",baiHat.getTeBH());
        }
        Log.d("read",String.valueOf(lstSong.size()));
        cursor.close();
        adapterSong.notifyDataSetChanged();
//        Log.d("read",adapter.);
    }

    private void createListView() {
        lstViewSong = findViewById(R.id.lstViewSong);
        lstViewFavouriteSong = findViewById(R.id.lstViewFavouriteSong);

        adapterSong = new SongAdapter(MainActivity.this, R.layout.list_item, lstSong);
        lstViewSong.setAdapter(adapterSong);

        adapterFavouriteSong = new SongAdapter(MainActivity.this, R.layout.list_item, lstFavouriteSong);
        lstViewFavouriteSong.setAdapter(adapterFavouriteSong);
    }



    private void checkDb() {
        // xem dbFile tồn tại chưa, nếu có rồi thì xóa đi copy lại
        File dbFile = getDatabasePath(Db_Name);

        if(!dbFile.exists()){
            copyDatabase();
        }
        else {
            dbFile.delete();
            copyDatabase();
        }

    }

    private void copyDatabase() {
        // Lấy file sqlite -> chuyển sang byte ở OutPutStream rồi tương tác vs app
        try {
            InputStream myInput = getAssets().open(Db_Name);
            String ourFileName = getApplicationInfo().dataDir+DB_Path+Db_Name;

            File f = new File(getApplicationInfo().dataDir+DB_Path);

            if(!f.exists()){
                f.mkdir();
            }

            OutputStream myOutput = new FileOutputStream(ourFileName);

            byte[] buffer = new byte[1024];
            int length ;

            // đọc từng mảng ở sqlite rồi cho vào output
            while ((length= myInput.read(buffer))>0){
                myOutput.write(buffer,0,length);
            }

            // xóa hết rồi đóng
            myOutput.flush();
            myInput.close();
            myOutput.close();
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("Sql",e.toString());
        }
    }


}