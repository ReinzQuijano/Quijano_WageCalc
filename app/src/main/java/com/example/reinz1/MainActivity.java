package com.example.reinz1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtRPH;
    EditText txtHours;
    Button btnWeekly;
    Button btnYearly;
    Button btnMonthly;
    TextView txtResults;
    private int YearlyEarnings = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtRPH = findViewById(R.id.txtRPH);
        txtHours = findViewById(R.id.txtHours);
        btnWeekly = findViewById(R.id.btnWeekly);
        btnYearly = findViewById(R.id.btnYearly);
        btnMonthly = findViewById(R.id.btnMontly);
        txtResults = findViewById(R.id.txtResults);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double myRPH = Double.parseDouble(txtRPH.getText().toString());
                double myHours = Double.parseDouble(txtHours.getText().toString());
                double Results = myRPH * myHours;

                txtResults.setText(String.valueOf(Results));
            }
        });
        btnYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double myRPH = Double.parseDouble(txtRPH.getText().toString());
                double myHours = Double.parseDouble(txtHours.getText().toString());
                txtResults.setText(String.valueOf(myRPH * myHours * 52));
            }
        });
        btnMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double myRPH = Double.parseDouble(txtRPH.getText().toString());
                double myHours = Double.parseDouble(txtHours.getText().toString());
                txtResults.setText(String.valueOf((myRPH * myHours * 52)/12));
            }
        });
    }
}