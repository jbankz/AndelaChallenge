package jbankz.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import jbankz.com.ConversionScreen;
import jbankz.com.EthConversionScreen;
import jbankz.com.pojo.BTC;
import jbankz.com.pojo.ETH;
import jbankz.com.R;

/**
 * Created by King Jaycee on 24/10/2017.
 */

public class EthAdapter extends RecyclerView.Adapter<EthAdapter.AdapterViewHolder> {

    ArrayList<ETH> ethArrayList;

    public EthAdapter(ArrayList<ETH> btcArrayList) {
        this.ethArrayList = btcArrayList;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coinlist_layout, parent, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        ETH eth = ethArrayList.get(position);
        holder.mName.setText(eth.getName());
        holder.mRate.setText(eth.getRate());

    }

    @Override
    public int getItemCount() {
        return ethArrayList.size();
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
            Intent intent = new Intent(context, EthConversionScreen.class);
            ETH eth = ethArrayList.get(getLayoutPosition());
            intent.putExtra("data", eth);
            context.startActivity(intent);
        }
    }
}
