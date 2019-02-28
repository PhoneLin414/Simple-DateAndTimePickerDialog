package com.example.pla.datepickerdialogandtimepickerdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class SecondActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button btn_Date, btn_Time, btn_Confirm;

    Calendar calendar;

    int year,month,day,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_Date = findViewById(R.id.btn_Date);
        btn_Time = findViewById(R.id.btn_Time);
        btn_Confirm = findViewById(R.id.btn_Confirm);


        calendar = Calendar.getInstance();


        btn_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 year = calendar.get(Calendar.YEAR);
                 month = calendar.get(Calendar.MONTH);
                 day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SecondActivity.this, R.style.DatePickerDialogTheme, SecondActivity.this, year, month, day);

                datePickerDialog.show();
            }
        });


        btn_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 hour = calendar.get(Calendar.HOUR_OF_DAY);
                 minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(SecondActivity.this, R.style.TimePickerDialogTheme, SecondActivity.this, hour, minute, false);

                timePickerDialog.show();

            }
        });


        btn_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateTime dateTime = new DateTime(year,month,day,hour,minute);

                Intent resultDateTime = new Intent();

                resultDateTime.putExtra("KEY",dateTime);

                setResult(1,resultDateTime);

                finish();

            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        this.year = year;
        this.month = month;
        this.day = dayOfMonth;

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        this.hour = hourOfDay;
        this.minute = minute;

    }
}
