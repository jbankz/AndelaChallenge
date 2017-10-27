package jbankz.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jbankz.com.utils.APiService;
import jbankz.com.pojo.CoinResponse;
import jbankz.com.R;
import jbankz.com.utils.RetrofitUtil;
import jbankz.com.adapter.BtcAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by King Jaycee on 23/10/2017.
 */

public class BtcFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "BtcFragment";
    APiService aPiService;
    String fsyms = "BTC";
    String tsyms = "USD" + "," + "EUR" + "," + "GBP" + "," + "NGN" + "," + "CAD" + "," + "SGD" + "," + "CHF" + "," + "MYR" + "," + "JPY" + "," + "CNY" + "," + "BRL" + "," + "EGP" + "," + "GHS" + "," + "KRW" + "," + "MXN" + "," + "QAR" + "," + "RUB" + "," + "SAR" + "," + "ZAR";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView mText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        mText = (TextView) view.findViewById(R.id.currency_price);

        layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                testForNetwork();
            }
        });

        fetchBtc();
        return view;
    }

    private void testForNetwork() {
        if (RetrofitUtil.isConnected(getContext())) {
            fetchBtc();
        } else {
            Toast.makeText(getContext(), "Unable to Connect", Toast.LENGTH_SHORT).show();
        }
    }


    public void fetchBtc() {
        swipeRefreshLayout.setRefreshing(true);
        RetrofitUtil retrofitUtil = new RetrofitUtil(getContext());
        aPiService = retrofitUtil.provideRetrofit().create(APiService.class);
        aPiService.getPrice(fsyms, tsyms).enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                if (response.isSuccessful()) {
                    swipeRefreshLayout.setRefreshing(false);
                    CoinResponse coinResponse = response.body();
                    mRecyclerView.setAdapter(new BtcAdapter(coinResponse.getCurrencyBtcList()));
                }
            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("MainActivity", t.getMessage().toString());
            }
        });

    }


    @Override
    public void onRefresh() {
        testForNetwork();
    }

}