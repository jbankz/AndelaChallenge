package jbankz.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Conversion extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate;
    private Spinner spinner;
    private String convertTo[] = {"USD", "EUR", "GBP", "NGN", "CAD", "SGD"
            , "CHF", "MYR", "JPY", "CNY", "BRL", "EGP", "GHS", "KRW", "MXN", "QAR", "RUB", "SAR", "ZAR"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExchange = (EditText) findViewById(R.id.et_enter_value);
        spinner = (Spinner) findViewById(R.id.spinner);
        mRate = (TextView) findViewById(R.id.rate_indicator);
        mName = (TextView) findViewById(R.id.from);

        receiveData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, convertTo);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Conversion.this, "Clicked " + String.valueOf(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void receiveData() {
        Intent intent = getIntent();
        if ((intent.hasExtra("name")) || (intent.hasExtra("rate"))) {
            String name = intent.getStringExtra("name");
            String rate = intent.getStringExtra("rate");

            mName.setText(name);
            mRate.setText(rate);
        }

    }

}
