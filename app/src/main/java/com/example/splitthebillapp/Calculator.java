package com.example.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {
    double tip = 0.18;
    double billAmount;
    int numberOfPeople;
    double tipAmount;
    double individualAmount;
    String qualityChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final EditText people = (EditText)findViewById(R.id.txtPeople);
        final Spinner serviceQuality = (Spinner)findViewById(R.id.txtServiceQuality);
        Button split = (Button)findViewById(R.id.btnSplit);
        split.setOnClickListener(new View.OnClickListener() {
            final TextView tipCost = ((TextView)findViewById(R.id.txtTipAmount));
            final TextView individualCost = ((TextView)findViewById(R.id.txtIndividualAmount));
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                billAmount = Double.parseDouble(bill.getText().toString());
                numberOfPeople = Integer.parseInt(people.getText().toString());
                tipAmount = billAmount * tip;
                individualAmount = (billAmount + tipAmount) / numberOfPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                qualityChoice = serviceQuality.getSelectedItem().toString();
                tipCost.setText("The 18% tip for " + qualityChoice + " service comes out to " + currency.format(tipAmount));
                individualCost.setText("Each person has to pay " + String.format("$%.2f", individualAmount));
            }
        });
    }
}
