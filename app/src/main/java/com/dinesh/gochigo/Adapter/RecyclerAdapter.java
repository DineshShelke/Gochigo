package com.dinesh.gochigo.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dinesh.gochigo.Activity.DetailActivity;
import com.dinesh.gochigo.Data.CaptainAmericaData;
import com.dinesh.gochigo.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<CaptainAmericaData> arrayList;

    public RecyclerAdapter(Context context, List<CaptainAmericaData> list) {
        this.context=context;
        this.arrayList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_orientation,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // holder.id.setText(arrayList.get(position).getId());
        holder.name.setText(arrayList.get(position).getName());
        holder.email.setText(arrayList.get(position).getEmail());
        holder.address.setText(arrayList.get(position).getAddress());
      //  holder.gender.setText(arrayList.get(position).getGender());
        holder.office.setText(arrayList.get(position).getPhone().getOffice());
       // holder.home.setText(arrayList.get(position).getPhone().getHome());
      //  holder.mobile.setText(arrayList.get(position).getPhone().getMobile());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView id,name,email,address,gender,mobile,home,office;
        private LinearLayout linear;
        public ViewHolder(View itemView) {
            super(itemView);

//            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);
//            gender = itemView.findViewById(R.id.gender);
//            mobile = itemView.findViewById(R.id.mobile);
          //  home = itemView.findViewById(R.id.home);
            office = itemView.findViewById(R.id.office);
//            linear = itemView.findViewById(R.id.inrLinear);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
             int itemPosition = getAdapterPosition();
            Toast.makeText(context, String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, DetailActivity.class));
        }
    }
}
