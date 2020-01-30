package com.example.dompet1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText ed_tanggal_lahir;
    Button btn_tanggal;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed_tanggal_lahir = findViewById(R.id.ed_tanggal_lahir);
        btn_tanggal = findViewById(R.id.btn_tanggal);

        btn_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

       ed_tanggal_lahir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               c = Calendar.getInstance();
               int day = c.get(Calendar.DAY_OF_MONTH);
               int month = c.get(Calendar.MONTH);
               int year = c.get(Calendar.YEAR);

               dpd = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                       ed_tanggal_lahir.setText(mDay + "/" +(mMonth+1) + "/" + mYear);
                   }
               },day,month,year);
               dpd.show();

           }
       });


    }
}
