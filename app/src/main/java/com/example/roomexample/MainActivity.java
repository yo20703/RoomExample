package com.example.roomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.roomexample.room.AppDataBase;
import com.example.roomexample.room.User;
import com.example.roomexample.room.UserDao;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataBase();
    }

    private void initDataBase(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AppDataBase appDataBase = AppDataBase.getInstance(getApplicationContext());
                UserDao userDao = appDataBase.getDataUao();

                User user = new User();
                user.firstName = "Z";
                user.lastName = "ZZ";

                userDao.insert(user);

                User users = userDao.findByName("Z", "ZZ");
                Log.i(TAG, "User: " + users.uid + "," + users.firstName + "," + users.lastName);

            }
        });

        thread.start();
    }
}