package jbankz.com.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import jbankz.com.utils.APiService;
import jbankz.com.pojo.CoinResponse;
import jbankz.com.R;
import jbankz.com.utils.RetrofitUtil;
import jbankz.com.adapter.EthAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by King Jaycee on 23/10/2017.
 */

public class EthFragment extends Fragment{

    private static final String TAG = "BtcFragment";
    APiService aPiService;
    String fsyms = "ETH";
    String tsyms = "USD" + "," + "EUR" + "," + "GBP" + "," + "NGN" + "," +
            "CAD" + "," + "SGD" + "," + "CHF" + "," + "MYR" + "," + "JPY" +
            "," + "CNY" + "," + "BRL" + "," + "EGP" + "," + "GHS" + "," + "KRW" +
            "," + "MXN" + "," + "QAR" + "," + "RUB" + "," + "SAR" + "," + "ZAR";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private TextView mErrorMessage;
    private ProgressBar mPb;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private final String KEY_RECYCLER_STATE_LAND = "recycler_state_land";
    private static Parcelable mBundleRecyclerViewState;
    private static Parcelable mBundleRecyclerLan;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        setHasOptionsMenu(true);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);
        mErrorMessage = (TextView) view.findViewById(R.id.error_message);
        mPb = (ProgressBar) view.findViewById(R.id.pb);

        layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        testForNetwork();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            testForNetwork();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save list state
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mBundleRecyclerViewState = layoutManager.onSaveInstanceState();
            outState.putParcelable(KEY_RECYCLER_STATE, mBundleRecyclerViewState);
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mBundleRecyclerLan = layoutManager.onSaveInstanceState();
            outState.putParcelable(KEY_RECYCLER_STATE_LAND, mBundleRecyclerLan);
        }

    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // Retrieve list state and list/item positions
        if (savedInstanceState != null) {
            if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                mBundleRecyclerViewState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
            } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                mBundleRecyclerLan = savedInstanceState.getParcelable(KEY_RECYCLER_STATE_LAND);
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBundleRecyclerViewState != null) {
            if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                layoutManager.onRestoreInstanceState(mBundleRecyclerViewState);
            } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager.onRestoreInstanceState(mBundleRecyclerLan);
            }

        }
    }

    private void testForNetwork() {
        if (RetrofitUtil.isConnected(getContext())) {
            mPb.setVisibility(View.VISIBLE);
            mErrorMessage.setVisibility(View.INVISIBLE);
            fetchBtc();
        } else {
            mErrorMessage.setVisibility(View.VISIBLE);
            mPb.setVisibility(View.INVISIBLE);
        }
    }


    public void fetchBtc() {
        RetrofitUtil retrofitUtil = new RetrofitUtil(getContext());
        aPiService = retrofitUtil.provideRetrofit().create(APiService.class);
        aPiService.getPrice(fsyms, tsyms).enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                if (response.isSuccessful()) {
                    mPb.setVisibility(View.INVISIBLE);
                    CoinResponse coinResponse = response.body();
                    mRecyclerView.setAdapter(new EthAdapter(coinResponse.getCurrencyEthList()));
                }
            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                mPb.setVisibility(View.INVISIBLE);
                mErrorMessage.setVisibility(View.VISIBLE);
                Log.e("MainActivity", t.getMessage().toString());
            }
        });

    }
}
