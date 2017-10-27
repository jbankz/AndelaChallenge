package jbankz.com;

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

import jbankz.com.pojo.ETH;

public class EthConversionScreen extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private Spinner spinner;
    private String convertTo[] = {"USD", "EUR", "GBP", "NGN", "CAD", "SGD"
            , "CHF", "MYR", "JPY", "CNY", "BRL", "EGP", "GHS", "KRW", "MXN", "QAR", "RUB", "SAR", "ZAR"};
    private String sp, receivedDataRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth_conversion_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mExchange = (EditText) findViewById(R.id.et_number);
        spinner = (Spinner) findViewById(R.id.spinner);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        ETH eth = getIntent().getParcelableExtra("data");

        mName.setText(eth.getName());

        receivedDataRate = eth.getRate();

        mRate.setText("Rate: " + receivedDataRate);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, convertTo);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sp = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void btnConvert(View view) {
        performCalc();
    }

    void performCalc() {
        try {
            String value = mExchange.getText().toString().trim();

            if (value.isEmpty() || value.length() == 0 || value.equals("") || value == null) {
                return;
            }
            if (value == sp) {
                Toast.makeText(getApplicationContext(), "Sorry, unable convert to the same currency.", Toast.LENGTH_SHORT).show();
            } else {
                double userValue = Double.parseDouble(value);
                double rate = Double.parseDouble(receivedDataRate);
                double gottenRate = userValue * rate;
                String newRate = String.valueOf(gottenRate);
                mNewRate.setText(newRate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
