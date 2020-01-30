package com.example.dompet1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dompet1.DetailBeritaActivity;
import com.example.dompet1.Model.BeritaList;
import com.example.dompet1.R;

import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.MyViewHolder2> {

    Context context;
    ArrayList<BeritaList> arrayList;

    public BeritaAdapter(Context c, ArrayList<BeritaList> p)
    {
        context = c;
        arrayList = p;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.cardview_berita,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, final int position) {

        holder.judul_berita.setText(arrayList.get(position).getJudul());
        holder.deskripsi_berita.setText(Html.fromHtml(arrayList.get(position).getDeskripsi()));
        holder.tanggal_berita.setText(arrayList.get(position).getTanggal());
        Glide.with(context).load(arrayList.get(position).getBanner()).into(holder.image_berita);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Detailberita = new Intent(context, DetailBeritaActivity.class);
                Detailberita.putExtra("intent_id",arrayList.get(position).getId());
                Detailberita.putExtra("intent_id_donasi",arrayList.get(position).getId_donasi());
                Detailberita.putExtra("intent_id_kategori",arrayList.get(position).getId_kategori());
                Detailberita.putExtra("intent_judul",arrayList.get(position).getJudul());
                Detailberita.putExtra("intent_banner",arrayList.get(position).getBanner());
                Detailberita.putExtra("intent_bannerconcat",arrayList.get(position).getConcat_banner());
                Detailberita.putExtra("intent_deskripsi",arrayList.get(position).getDeskripsi());
                Detailberita.putExtra("intent_linkshare",arrayList.get(position).getLink_share());
                Detailberita.putExtra("intent_tanggal",arrayList.get(position).getTanggal());
                Detailberita.putExtra("intent_kategori",arrayList.get(position).getKategori());
                context.startActivity(Detailberita);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView judul_berita,deskripsi_berita,tanggal_berita;
        ImageView image_berita;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            judul_berita = (TextView) itemView.findViewById(R.id.judul_berita);
            deskripsi_berita = (TextView) itemView.findViewById(R.id.deskripsi_berita);
            tanggal_berita = (TextView) itemView.findViewById(R.id.tanggal_berita);
            image_berita = (ImageView) itemView.findViewById(R.id.image_berita);


        }
    }

}
