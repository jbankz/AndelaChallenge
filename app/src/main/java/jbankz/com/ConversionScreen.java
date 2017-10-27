package jbankz.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import jbankz.com.pojo.BTC;

public class ConversionScreen extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private Spinner spinner;
    private String convertTo[] = {"USD", "EUR", "GBP", "NGN", "CAD", "SGD"
            , "CHF", "MYR", "JPY", "CNY", "BRL", "EGP", "GHS", "KRW", "MXN", "QAR", "RUB", "SAR", "ZAR"};
    private String sp, receivedDataRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_screen);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExchange = (EditText) findViewById(R.id.et_number);
        spinner = (Spinner) findViewById(R.id.spinner);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        BTC btc = getIntent().getParcelableExtra("data");

        mName.setText(btc.getName());

        receivedDataRate = btc.getRate();

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
