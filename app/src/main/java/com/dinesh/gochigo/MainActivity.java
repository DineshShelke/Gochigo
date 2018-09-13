package com.dinesh.gochigo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.dinesh.gochigo.Activity.CartActivity;
import com.dinesh.gochigo.Activity.WishListActivity;
import com.dinesh.gochigo.Adapter.RecyclerAdapter;
import com.dinesh.gochigo.Data.CaptainAmerica;
import com.dinesh.gochigo.Data.CaptainAmericaData;
import com.dinesh.gochigo.Model.ServiceHelper;
import com.dinesh.gochigo.Utils.Global;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Global global;

    List<CaptainAmericaData> list;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().clearFocus();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        recyclerView = findViewById(R.id.recyclerview);
       // layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setData();

        global = new Global();



    }

    private void setData() {

        ServiceHelper.getInstance().getContactData().enqueue(new Callback<CaptainAmerica>() {
            @Override
            public void onResponse(retrofit2.Call<CaptainAmerica> call, Response<CaptainAmerica> response) {
//                Log.i(TAG, "onResponse: " + response);
                list = new ArrayList<>();
                CaptainAmerica res = response.body();

                if (res != null) {
                    list = res.getContacts();
                    adapter = new RecyclerAdapter(MainActivity.this,list);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<CaptainAmerica> call, Throwable t) {
                Log.i(TAG, "onResponse: " + t);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.home: {
                global.AlertDialog(this);
               return true;
            }
            case R.id.exit: {
                //global.AlertDialog(this);
                exitDialog(this,getString(R.string.exit));
                return true;
            }
            case R.id.action_notifications: {
                startActivity(new Intent(this, CartActivity.class));
                return true;
            }
            case R.id.wish: {
                Intent intent = new Intent(this, WishListActivity.class);
                startActivity(intent);
                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.favorite);
        MenuItem menuItem1 = menu.findItem(R.id.home);
        menuItem.setVisible(false);
        menuItem1.setVisible(false);
        return super.onPrepareOptionsMenu(menu);

    }

    public void exitDialog(Context context, String message){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.dialog_layout);
        TextView textTitle = dialog.findViewById(R.id.title);
        textTitle.setText(message);
        //dialog.setTitle(message);
        dialog.setCancelable(true);

        (dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
                //dialog.dismiss();
            }
        });

        (dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}