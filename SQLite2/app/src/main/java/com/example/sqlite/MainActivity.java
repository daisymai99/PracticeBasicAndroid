package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.sqlite.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    ArrayList<String> danhBa ;
    ArrayAdapter<String> adapter;

    String Db_Name ="DbContact.db";
    private String DB_Path ="/databases/";
    SQLiteDatabase sqLiteDatabase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        checkDb();


        danhBa = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,danhBa);
        binding.listView.setAdapter(adapter);


        
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put("ma","3");
                values.put("ten"," Giang Trinh ");
                values.put("phone","xxxxxxx");

                long r = sqLiteDatabase.insert("contact",null,values);
                showDatabase();

                Toast.makeText(MainActivity.this,"Add contact success",Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("ten","Mai Hồng Ngọc ");
                sqLiteDatabase.update("contact",values,"ma=?",new String[]{"0"});
                showDatabase();
            }
        });
        
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sqLiteDatabase.delete("contact","ma=?",new String[]{"0"});
               showDatabase();
            }
        });

        showDatabase();
    }

    private void showDatabase() {
        sqLiteDatabase = openOrCreateDatabase(Db_Name,MODE_PRIVATE,null);

        Cursor cursor = sqLiteDatabase.query("contact",null,null,null,null,null,null);

        danhBa.clear();
        while (cursor.moveToNext()){
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String phone = cursor.getString(2);
            danhBa.add(ma+" - "+ten+" - "+phone);
        }

        adapter.notifyDataSetChanged();

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