package jbankz.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jbankz.com.Conversion;
import jbankz.com.pojo.BTC;
import jbankz.com.R;
import jbankz.com.pojo.ETH;

import static android.content.ContentValues.TAG;

/**
 * Created by King Jaycee on 24/10/2017.
 */

public class BtcAdapter extends RecyclerView.Adapter<BtcAdapter.AdapterViewHolder> {

    ArrayList<BTC> btcArrayList;
    private String name, rate;
    BTC btc;


    public BtcAdapter(ArrayList<BTC> btcArrayList) {
        this.btcArrayList = btcArrayList;
    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coinlist_layout, parent, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        btc = btcArrayList.get(position);

        name = btc.getName();
        rate = btc.getRate();

        holder.mName.setText(name);
        holder.mRate.setText(rate);
    }

    @Override
    public int getItemCount() {
        return btcArrayList.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mName, mRate;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.currency_symbol);
            mRate = (TextView) itemView.findViewById(R.id.currency_price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, Conversion.class);
            intent.putExtra("name", "BTC");
            intent.putExtra("rate", btc.getRate());
            context.startActivity(intent);


        }
    }
}
