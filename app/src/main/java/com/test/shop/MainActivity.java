package com.test.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Shop shop = new Shop();
        Log.d(LOG, shop.orderDescription(3, 0, "ru"));
        Log.d(LOG, shop.orderDescription(3, 1, "ru"));
        Log.d(LOG, shop.orderDescription(2, 2, "ru"));
        Log.d(LOG, shop.orderDescription(11, 0, "ru"));
        Log.d(LOG, shop.orderDescription(1, 1, "en"));
    }
}
