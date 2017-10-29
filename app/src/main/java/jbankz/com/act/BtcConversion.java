package jbankz.com.act;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jbankz.com.R;
import jbankz.com.pojo.BTC;

public class BtcConversion extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private String receivedDataRate;
    private BTC btc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btc_conversion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExchange = (EditText) findViewById(R.id.et_number);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        btc = getIntent().getParcelableExtra("data");

        mName.setText(btc.getName());

        receivedDataRate = btc.getRate();

        mRate.setText("1 " + btc.getName() + " = " + receivedDataRate);

    }

    public void btnConvert(View view) {
        performCalc();
    }

    void performCalc() {
        String value = mExchange.getText().toString().trim();

        if (value.isEmpty() || value.length() == 0 || value.equals("") || value == null) {
            return;
        } else {
            double userValue = Double.parseDouble(value);
            double rate = Double.parseDouble(receivedDataRate);
            mNewRate.setText(String.valueOf(btc.getName() + " " + userValue * rate));
        }
    }

}
