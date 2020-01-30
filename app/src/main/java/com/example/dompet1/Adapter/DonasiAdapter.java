package com.example.dompet1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dompet1.DetailBeritaActivity;
import com.example.dompet1.DetailDonasiActivity;
import com.example.dompet1.Model.DonasiList;
import com.example.dompet1.R;

import java.util.ArrayList;

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.MyViewHolder> {

    Context context;
    ArrayList<DonasiList> profiles;

    public DonasiAdapter(Context c, ArrayList<DonasiList> p)
    {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_donasi,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.judul_donasi.setText(profiles.get(position).getNama());
        holder.jumlah_donasi.setText("Rp." + profiles.get(position).getJumlah_donasi());
        holder.total_donasi.setText(profiles.get(position).getJumlah_donatur());
        Glide.with(context).load(profiles.get(position).getBanner()).into(holder.image_donasi);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Detailberita = new Intent(context, DetailDonasiActivity.class);
                Detailberita.putExtra("intent_id",profiles.get(position).getId());
                Detailberita.putExtra("intent_id_sedekah",profiles.get(position).getId_sedekah());
                Detailberita.putExtra("intent_nama",profiles.get(position).getNama());
                Detailberita.putExtra("intent_banner",profiles.get(position).getBanner());
                Detailberita.putExtra("intent_concat_banner",profiles.get(position).getContact_banner());
                Detailberita.putExtra("intent_asal",profiles.get(position).getAsal());
                Detailberita.putExtra("intent_deskripsi",profiles.get(position).getDeskripsi());
                Detailberita.putExtra("intent_jumlah_donasi",profiles.get(position).getJumlah_donatur());
                Detailberita.putExtra("intent_jumlah_donatur",profiles.get(position).getJumlah_donatur());
                Detailberita.putExtra("intent_jumlah_link",profiles.get(position).getLink_share());
                Detailberita.putExtra("intent_jumlah_enable",profiles.get(position).getStatus_enale());
                context.startActivity(Detailberita);
            }
        });



    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView total_donasi,jumlah_donasi,judul_donasi;
        ImageView image_donasi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            total_donasi = (TextView) itemView.findViewById(R.id.total_donasi);
            jumlah_donasi = (TextView) itemView.findViewById(R.id.jumlah_donasi);
            judul_donasi = (TextView) itemView.findViewById(R.id.judul_donasi);
            image_donasi = (ImageView) itemView.findViewById(R.id.image_donasi);
        }
    }

}
