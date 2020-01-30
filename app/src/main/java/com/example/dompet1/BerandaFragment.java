package com.example.dompet1;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dompet1.API.DaftarAPI;
import com.example.dompet1.API.UtilsAPI;
import com.example.dompet1.Adapter.DonasiAdapter;
import com.example.dompet1.Model.DonasiList;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {
    TextView tes,tes2;
    RecyclerView recyclerview_donasi;
    ArrayList<DonasiList> lists;
    DonasiAdapter donasiAdapter;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.banjir1, R.drawable.banjir2, R.drawable.banjir3, R.drawable.banjir4, R.drawable.banjir5};

    private String[] mImageTittle= new String[]{
            "SlideOne","SlideTwo","SlideThree","SlideFour","SlideFive"
    };

    private DaftarAPI daftarAPI;


    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);

        daftarAPI = UtilsAPI.getdaftarAPI();
        lists = new ArrayList<DonasiList>();
        recyclerview_donasi = v.findViewById(R.id.recyclerview_donasi);
        recyclerview_donasi.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        tes = v.findViewById(R.id.tes);
        tes2 = v.findViewById(R.id.tes2);

        tes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abc = new Intent(getActivity(),LoginActivity.class);
                startActivity(abc);
            }
        });

        tes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abc = new Intent(getActivity(),RegisterActivity.class);
                startActivity(abc);
            }
        });


        carouselView = v.findViewById(R.id.carousel);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(),mImageTittle[position], Toast.LENGTH_SHORT).show();
            }
        });




        ReadDonasi();


        return v;
    }

    private void ReadDonasi(){
        Call<List<DonasiList>> call = daftarAPI.viewDonasi();
        call.enqueue(new Callback<List<DonasiList>>() {
            @Override
            public void onResponse(Call<List<DonasiList>> call, Response<List<DonasiList>> response) {
                Toast.makeText(getActivity(), "Berhaasil!", Toast.LENGTH_SHORT).show();
                lists = new ArrayList<>(response.body());
                donasiAdapter = new DonasiAdapter(getActivity(),lists);
                recyclerview_donasi.setAdapter(donasiAdapter);
            }

            @Override
            public void onFailure(Call<List<DonasiList>> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal!", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
