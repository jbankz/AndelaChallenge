package jbankz.com.act;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import jbankz.com.R;
import jbankz.com.pojo.BTC;

public class ConversionScreen extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private String receivedDataRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_screen);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExchange = (EditText) findViewById(R.id.et_number);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        BTC btc = getIntent().getParcelableExtra("data");

        mName.setText(btc.getName());

        receivedDataRate = btc.getRate();

        mRate.setText("Rate: " + receivedDataRate);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnConvert(View view) {
        performCalc();
    }

    void performCalc() {
        String value = mExchange.getText().toString().trim();

        if (value.isEmpty() || value.length() == 0 || value.equals("") || value == null) {
            return;
        }else {
            double userValue = Double.parseDouble(value);
            double rate = Double.parseDouble(receivedDataRate);
            mNewRate.setText(String.valueOf(userValue * rate));
        }
    }
}
