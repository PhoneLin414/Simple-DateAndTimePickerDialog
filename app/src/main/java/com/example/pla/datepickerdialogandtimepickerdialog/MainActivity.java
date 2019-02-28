package com.example.pla.datepickerdialogandtimepickerdialog;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_getDateTime;
    TextView txt_DateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn_getDateTime = findViewById(R.id.btn_getDateTime);
         txt_DateTime = findViewById(R.id.txt_DateTime);


        btn_getDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent getDateTime = new Intent(MainActivity.this,SecondActivity.class);

                startActivityForResult(getDateTime,1);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode != RESULT_CANCELED && requestCode == 1){

            DateTime dateTime = (DateTime) data.getSerializableExtra("KEY");

            txt_DateTime.setText(dateTime.getYear() + " " + dateTime.getMonth() + " " + dateTime.getDay() + " " + dateTime.getHour() + ":" + dateTime.getMinute());


        }

    }
}
