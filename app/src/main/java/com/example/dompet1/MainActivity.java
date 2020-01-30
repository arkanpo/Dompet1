package com.example.dompet1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;


    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.home_menu:
                    setTitle("Home Activity");
                    BerandaFragment fragmenthome = new BerandaFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragmenthome, "FragmentName");
                    fragmentTransaction.commit();

                    return true;

                case R.id.riwayat_menu:
                    setTitle("Riwayat");
                    RiwayatFragment fragmentriwayat = new RiwayatFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content, fragmentriwayat, "FragmentName");
                    fragmentTransaction2.commit();

                    return true;

                case R.id.berita_menu:
                    setTitle("Berita");
                    BeritaFragment fragmentberita = new BeritaFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.content, fragmentberita, "FragmentName");
                    fragmentTransaction3.commit();

                    return true;

                case R.id.akun_menu:
                    setTitle("Akun");
                    AkunFragment fragmentakun = new AkunFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.content, fragmentakun, "FragmentName");
                    fragmentTransaction4.commit();

                    return true;


            }

            return false;

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.menu_ini);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        myDialog = new Dialog(this);

        //page home
        setTitle("Home Page");
        BerandaFragment fragment2 = new BerandaFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment2, "FragmentName");
        fragmentTransaction.commit();

    }

    public void ShowPopUp(View v){
        ImageView close;
        myDialog.setContentView(R.layout.popup_register);
        close =(ImageView) myDialog.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        }); myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }


}
