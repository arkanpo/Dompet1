package com.example.dompet1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailBeritaActivity extends AppCompatActivity {

    TextView judul_berita,deskripsi_berita,tanggal_berita;
    ImageView image_berita;

    private String intent_id = "",intent_judul = "",intent_banner = "",intent_deskripsi = "",intent_tanggal = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        judul_berita = findViewById(R.id.judul_berita);
        deskripsi_berita = findViewById(R.id.deskripsi_berita);
        tanggal_berita = findViewById(R.id.tanggal_berita);
        image_berita = findViewById(R.id.image_berita);

        intent_id= getIntent().getStringExtra("intent_id");
        intent_judul= getIntent().getStringExtra("intent_judul");
        intent_banner= getIntent().getStringExtra("intent_banner");
        intent_deskripsi= getIntent().getStringExtra("intent_deskripsi");
        intent_tanggal= getIntent().getStringExtra("intent_tanggal");


        Detaildata();

    }

    private void Detaildata(){
        judul_berita.setText(intent_judul);
        deskripsi_berita.setText(Html.fromHtml(intent_deskripsi));
        tanggal_berita.setText(intent_tanggal);
        Glide.with(DetailBeritaActivity.this).load(intent_banner).into(image_berita);

    }
}
