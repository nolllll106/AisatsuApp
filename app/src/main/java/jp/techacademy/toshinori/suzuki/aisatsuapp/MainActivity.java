package jp.techacademy.toshinori.suzuki.aisatsuapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI-PARTS", "push");
                showTimePickerDialog();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(message);
            }
        });

        mTextView = (TextView) findViewById(R.id.textView);
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay >= 2 && (hourOfDay <= 9 && minute <= 59)) {
                    message = "おはよう";
                } else if (hourOfDay >= 10 && (hourOfDay <= 17 && minute <= 59)) {
                    message = "こんにちは";
                } else {
                    message = "こんばんは";
                }
            }
        },
                13,
                0,
                true);
        timePickerDialog.show();
    }

}
