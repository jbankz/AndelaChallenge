package jbankz.com.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jbankz.com.R;

/**
 * Created by King Jaycee on 18/10/2017.
 */

public class CoinResponse {

    @SerializedName("BTC")
    @Expose
    private BTC btc;
    @SerializedName("ETH")
    @Expose
    private ETH eth;

    public BTC getBtc() {
        return btc;
    }

    public void setBtc(BTC btc) {
        this.btc = btc;
    }

    public ETH getEth() {
        return eth;
    }

    public void setEth(ETH eth) {
        this.eth = eth;
    }

    public ArrayList<BTC> getCurrencyBtcList() {
        ArrayList<BTC> currencyBtcList = new ArrayList<>();

        currencyBtcList.add(new BTC(R.drawable.usd, "USD", getBtc().getUsd()));
        currencyBtcList.add(new BTC(R.drawable.gbp, "GBP", getBtc().getGbp()));
        currencyBtcList.add(new BTC(R.drawable.ngn, "NGN", getBtc().getNgn()));
        currencyBtcList.add(new BTC(R.drawable.cad, "CAD", getBtc().getCad()));
        currencyBtcList.add(new BTC(R.drawable.sgd, "SGD", getBtc().getSgd()));
        currencyBtcList.add(new BTC(R.drawable.chf, "CHF", getBtc().getChf()));
        currencyBtcList.add(new BTC(R.drawable.myr, "MYR", getBtc().getMyr()));
        currencyBtcList.add(new BTC(R.drawable.jpy, "JPY", getBtc().getJpy()));
        currencyBtcList.add(new BTC(R.drawable.eur, "EUR", getBtc().getEur()));
        currencyBtcList.add(new BTC(R.drawable.brl, "BRL", getBtc().getBrl()));
        currencyBtcList.add(new BTC(R.drawable.egp, "EGP", getBtc().getEgp()));
        currencyBtcList.add(new BTC(R.drawable.ghs, "GHS", getBtc().getGhs()));
        currencyBtcList.add(new BTC(R.drawable.krw, "KRW", getBtc().getKrw()));
        currencyBtcList.add(new BTC(R.drawable.mxn, "MXN", getBtc().getMxn()));
        currencyBtcList.add(new BTC(R.drawable.qar, "QAR", getBtc().getQar()));
        currencyBtcList.add(new BTC(R.drawable.rub, "RUB", getBtc().getRub()));
        currencyBtcList.add(new BTC(R.drawable.cny, "CNY", getBtc().getCny()));
        currencyBtcList.add(new BTC(R.drawable.sar, "SAR", getBtc().getSar()));
        currencyBtcList.add(new BTC(R.drawable.zar, "ZAR", getBtc().getZar()));
        currencyBtcList.add(new BTC(R.drawable.xof, "XOF", getBtc().getXof()));
        return currencyBtcList;
    }

    public ArrayList<ETH> getCurrencyEthList() {
        ArrayList<ETH> currencyEthList = new ArrayList<>();

        currencyEthList.add(new ETH(R.drawable.myr, "MYR", getEth().getMyr()));
        currencyEthList.add(new ETH(R.drawable.jpy, "JPY", getEth().getJpy()));
        currencyEthList.add(new ETH(R.drawable.brl, "BRL", getEth().getBrl()));
        currencyEthList.add(new ETH(R.drawable.usd, "USD", getEth().getUsd()));
        currencyEthList.add(new ETH(R.drawable.gbp, "GBP", getEth().getGbp()));
        currencyEthList.add(new ETH(R.drawable.ngn, "NGN", getEth().getNgn()));
        currencyEthList.add(new ETH(R.drawable.cad, "CAD", getEth().getCad()));
        currencyEthList.add(new ETH(R.drawable.sgd, "SGD", getEth().getSgd()));
        currencyEthList.add(new ETH(R.drawable.chf, "CHF", getEth().getChf()));
        currencyEthList.add(new ETH(R.drawable.egp, "EGP", getEth().getEgp()));
        currencyEthList.add(new ETH(R.drawable.ghs, "GHS", getEth().getGhs()));
        currencyEthList.add(new ETH(R.drawable.krw, "KRW", getEth().getKrw()));
        currencyEthList.add(new ETH(R.drawable.cny, "CNY", getEth().getCny()));
        currencyEthList.add(new ETH(R.drawable.mxn, "MXN", getEth().getMxn()));
        currencyEthList.add(new ETH(R.drawable.qar, "QAR", getEth().getQar()));
        currencyEthList.add(new ETH(R.drawable.eur, "EUR", getEth().getEur()));
        currencyEthList.add(new ETH(R.drawable.rub, "RUB", getEth().getRub()));
        currencyEthList.add(new ETH(R.drawable.sar, "SAR", getEth().getSar()));
        currencyEthList.add(new ETH(R.drawable.zar, "ZAR", getEth().getZar()));
        currencyEthList.add(new ETH(R.drawable.xof, "XOF", getEth().getXof()));

        return currencyEthList;
    }


}
