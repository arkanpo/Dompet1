package com.example.dompet1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ArtikelTablayout extends Fragment {

    TextView judul_donasi,jumlah_donasi,total_donasi,deskripsi_donasi;
    ImageView image_donasi;

    private String intent_id = "",intent_judul = "",intent_banner = "",intent_deskripsi = "",intent_totaldonasi = "",intent_jumlah_donasi = "";

    public ArtikelTablayout() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_artikel_tablayout, container, false);

        judul_donasi = v.findViewById(R.id.judul_donasi);
        jumlah_donasi = v.findViewById(R.id.jumlah_donasi);
        total_donasi = v.findViewById(R.id.total_donasi);
        deskripsi_donasi = v.findViewById(R.id.deskripsi_donasi);
        image_donasi = v.findViewById(R.id.image_donasi);

        intent_id = getActivity().getIntent().getStringExtra("intent_id");
        intent_judul = getActivity().getIntent().getStringExtra("intent_nama");
        intent_banner = getActivity().getIntent().getStringExtra("intent_banner");
        intent_deskripsi = getActivity().getIntent().getStringExtra("intent_deskripsi");
        intent_totaldonasi = getActivity().getIntent().getStringExtra("intent_jumlah_donatur");
        intent_jumlah_donasi = getActivity().getIntent().getStringExtra("intent_jumlah_donasi");

        Detaildata();

        return v;
    }

    private void Detaildata(){
        judul_donasi.setText(intent_judul);
        jumlah_donasi.setText("Rp." + intent_jumlah_donasi);
        total_donasi.setText(intent_totaldonasi + "  Donatur");
        deskripsi_donasi.setText(Html.fromHtml(intent_deskripsi));
       // Glide.with(getActivity()).load(intent_banner).into(intent_banner);

    }

}
