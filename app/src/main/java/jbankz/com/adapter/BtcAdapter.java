package jbankz.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import jbankz.com.details.BtcConversion;
import jbankz.com.pojo.BTC;
import jbankz.com.R;

/**
 * Created by King Jaycee on 24/10/2017.
 */

public class BtcAdapter extends RecyclerView.Adapter<BtcAdapter.AdapterViewHolder> {

    private static final String TAG = "BtcAdapter";

    private ArrayList<BTC> btcArrayList;

    public BtcAdapter(ArrayList<BTC> btcArrayList) {
        this.btcArrayList = btcArrayList;
    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coinlist_layout, parent, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, final int position) {
        BTC btc = btcArrayList.get(position);
        holder.mName.setText(btc.getName());
        holder.mRate.setText(btc.getRate());
        holder.mImage.setImageResource(btc.getImages());
    }

    @Override
    public int getItemCount() {
        return btcArrayList.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mName, mRate;
        ImageView mImage;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.currency_symbol);
            mRate = (TextView) itemView.findViewById(R.id.currency_price);
            mImage = (ImageView) itemView.findViewById(R.id.image_poster);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, BtcConversion.class);
            BTC btc = btcArrayList.get(getLayoutPosition());
            intent.putExtra("data", btc);
            context.startActivity(intent);
        }
    }
}
