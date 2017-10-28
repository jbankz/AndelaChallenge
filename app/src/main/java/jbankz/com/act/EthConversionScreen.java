package jbankz.com.act;

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

import jbankz.com.R;
import jbankz.com.pojo.ETH;

public class EthConversionScreen extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private String receivedDataRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth_conversion_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mExchange = (EditText) findViewById(R.id.et_number);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        ETH eth = getIntent().getParcelableExtra("data");

        mName.setText(eth.getName());

        receivedDataRate = eth.getRate();

        mRate.setText("Rate: " + receivedDataRate);

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
            mNewRate.setText(String.valueOf(userValue * rate));
        }
    }
}