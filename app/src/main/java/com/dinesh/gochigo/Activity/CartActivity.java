package com.dinesh.gochigo.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.dinesh.gochigo.R;

public class CartActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                //exitDialog(this,getString(R.string.exit));
                finish();
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
        MenuItem menuItem1 = menu.findItem(R.id.action_notifications);
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
