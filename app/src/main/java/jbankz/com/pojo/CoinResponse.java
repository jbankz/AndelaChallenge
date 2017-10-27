package jbankz.com.pojo;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by King Jaycee on 18/10/2017.
 */

public class CoinResponse {

    @SerializedName("BTC")
    private BTC btc;
    @SerializedName("ETH")
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

        currencyBtcList.add(new BTC("USD", getBtc().getUsd()));
        currencyBtcList.add(new BTC("EUR", getBtc().getEur()));
        currencyBtcList.add(new BTC("GBP", getBtc().getGbp()));
        currencyBtcList.add(new BTC("NGN", getBtc().getNgn()));
        currencyBtcList.add(new BTC("CAD", getBtc().getCad()));
        currencyBtcList.add(new BTC("SGD", getBtc().getSgd()));
        currencyBtcList.add(new BTC("CHF", getBtc().getChf()));
        currencyBtcList.add(new BTC("MYR", getBtc().getMyr()));
        currencyBtcList.add(new BTC("JPY", getBtc().getJpy()));
        currencyBtcList.add(new BTC("CNY", getBtc().getCny()));
        currencyBtcList.add(new BTC("BRL", getBtc().getBrl()));
        currencyBtcList.add(new BTC("EGP", getBtc().getEgp()));
        currencyBtcList.add(new BTC("GHS", getBtc().getGhs()));
        currencyBtcList.add(new BTC("KRW", getBtc().getKrw()));
        currencyBtcList.add(new BTC("MXN", getBtc().getMxn()));
        currencyBtcList.add(new BTC("QAR", getBtc().getQar()));
        currencyBtcList.add(new BTC("RUB", getBtc().getRub()));
        currencyBtcList.add(new BTC("SAR", getBtc().getSar()));
        currencyBtcList.add(new BTC("ZAR", getBtc().getZar()));

        return currencyBtcList;
    }

    public ArrayList<ETH> getCurrencyEthList() {
        ArrayList<ETH> currencyEthList = new ArrayList<>();

        currencyEthList.add(new ETH("USD", getEth().getUsd()));
        currencyEthList.add(new ETH("EUR", getEth().getEur()));
        currencyEthList.add(new ETH("GBP", getEth().getGbp()));
        currencyEthList.add(new ETH("NGN", getEth().getNgn()));
        currencyEthList.add(new ETH("CAD", getEth().getCad()));
        currencyEthList.add(new ETH("SGD", getEth().getSgd()));
        currencyEthList.add(new ETH("CHF", getEth().getChf()));
        currencyEthList.add(new ETH("MYR", getEth().getMyr()));
        currencyEthList.add(new ETH("JPY", getEth().getJpy()));
        currencyEthList.add(new ETH("CNY", getEth().getCny()));
        currencyEthList.add(new ETH("BRL", getEth().getBrl()));
        currencyEthList.add(new ETH("EGP", getEth().getEgp()));
        currencyEthList.add(new ETH("GHS", getEth().getGhs()));
        currencyEthList.add(new ETH("KRW", getEth().getKrw()));
        currencyEthList.add(new ETH("MXN", getEth().getMxn()));
        currencyEthList.add(new ETH("QAR", getEth().getQar()));
        currencyEthList.add(new ETH("RUB", getEth().getRub()));
        currencyEthList.add(new ETH("SAR", getEth().getSar()));
        currencyEthList.add(new ETH("ZAR", getEth().getZar()));

        return currencyEthList;
    }


}
