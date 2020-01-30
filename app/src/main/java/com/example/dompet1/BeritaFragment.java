package com.example.dompet1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dompet1.API.DaftarAPI;
import com.example.dompet1.API.UtilsAPI;
import com.example.dompet1.Adapter.BeritaAdapter;
import com.example.dompet1.Adapter.DonasiAdapter;
import com.example.dompet1.Model.BeritaList;
import com.example.dompet1.Model.DonasiList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BeritaFragment extends Fragment {

    RecyclerView recyclerview_berita;
    ArrayList<BeritaList> lists;
    BeritaAdapter donasiAdapter;
    private DaftarAPI daftarAPI;


    public BeritaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_berita, container, false);

        daftarAPI = UtilsAPI.getdaftarAPI();
        lists = new ArrayList<BeritaList>();

        recyclerview_berita = v.findViewById(R.id.recyclerview_berita);
        recyclerview_berita.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        ReadBerita();

        return v;
    }

    private void ReadBerita() {

        Call<List<BeritaList>> call = daftarAPI.viewBerita();
        call.enqueue(new Callback<List<BeritaList>>() {
            @Override
            public void onResponse(Call<List<BeritaList>> call, Response<List<BeritaList>> response) {
                Toast.makeText(getActivity(), "Berhaasil!", Toast.LENGTH_SHORT).show();
                lists = new ArrayList<>(response.body());
                donasiAdapter = new BeritaAdapter(getActivity(),lists);
                recyclerview_berita.setAdapter(donasiAdapter);
            }

            @Override
            public void onFailure(Call<List<BeritaList>> call, Throwable t) {

            }
        });


    }


}
