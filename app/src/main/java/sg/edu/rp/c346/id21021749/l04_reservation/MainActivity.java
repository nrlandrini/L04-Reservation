package sg.edu.rp.c346.id21021749.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPax;
    EditText etPhone;
    RadioGroup rgArea;
    DatePicker dp;
    TimePicker tp;
    Button btnConfirm;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPax = findViewById(R.id.etPax);
        etPhone = findViewById(R.id.etPhone);
        rgArea = findViewById(R.id.radioGroupArea);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnConfirm = findViewById(R.id.bConfirm);
        btnReset = findViewById(R.id.bReset);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkRadio = rgArea.getCheckedRadioButtonId();
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String date = String.format ("Selected Date is %d/%d/%a", day, month, year) ;
                String time = String.format ("Selected timing is %d:%d", hour, minute);
                String nameEnter = "Name " + etName.getText().toString();
                String paxEnter="No of Pax: " + etPax.getText().toString();
                String numberEnter="Mobile Number: "+ etPhone.getText().toString();
                if (etName.getText().length() != 0 && etPhone.getText().length() != 0 && etPax.getText().length() != 0) {
                    if (checkRadio == R.id.rbNonSmoking) {
                        Toast.makeText(MainActivity.this, nameEnter + "\n" + paxEnter + " \n" + numberEnter + "\n" + date + " \n" + time + "\n" + "Table area: Non-Smoking",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, nameEnter + "\n" + paxEnter + " \n" + numberEnter + "\n"+date + "\n" + time + "\n" + "Table area: Smoking",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please fill up those empty fields",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tp.setCurrentHour(07);
                tp.setCurrentMinute(30);

                dp.updateDate(2020, 5, 01);
            }
        });
    }
}