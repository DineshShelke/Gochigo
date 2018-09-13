package com.dinesh.gochigo.Utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;

import com.dinesh.gochigo.R;

public class Global  {

    Context context;

    public void AlertDialog(Context context){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before

        dialog.setContentView(R.layout.dialog_layout);
        dialog.setTitle("Title");
        dialog.setCancelable(true);

        (dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
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


    public void ExitDialog(Context context,String message){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before

        dialog.setContentView(R.layout.dialog_layout);
        dialog.setTitle(message);
        dialog.setCancelable(true);

        (dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
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
