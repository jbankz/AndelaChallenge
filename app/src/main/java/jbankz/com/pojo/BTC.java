package jbankz.com.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by King Jaycee on 18/10/2017.
 */

public class BTC {

    @SerializedName("USD")
    private String usd;
    @SerializedName("EUR")
    private String eur;
    @SerializedName("GBP")
    private String gbp;
    @SerializedName("NGN")
    private String ngn;
    @SerializedName("CAD")
    private String cad;
    @SerializedName("SGD")
    private String sgd;
    @SerializedName("CHF")
    private String chf;
    @SerializedName("MYR")
    private String myr;
    @SerializedName("JPY")
    private String jpy;
    @SerializedName("CNY")
    private String cny;
    @SerializedName("BRL")
    private String brl;
    @SerializedName("EGP")
    private String egp;
    @SerializedName("GHS")
    private String ghs;
    @SerializedName("KRW")
    private String krw;
    @SerializedName("MXN")
    private String mxn;
    @SerializedName("QAR")
    private String qar;
    @SerializedName("RUB")
    private String rub;
    @SerializedName("SAR")
    private String sar;
    @SerializedName("ZAR")
    private String zar;

    private String name;
    private String rate;


    public BTC(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getGbp() {
        return gbp;
    }

    public void setGbp(String gbp) {
        this.gbp = gbp;
    }

    public String getNgn() {
        return ngn;
    }

    public void setNgn(String ngn) {
        this.ngn = ngn;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getChf() {
        return chf;
    }

    public void setChf(String chf) {
        this.chf = chf;
    }

    public String getMyr() {
        return myr;
    }

    public void setMyr(String myr) {
        this.myr = myr;
    }

    public String getJpy() {
        return jpy;
    }

    public void setJpy(String jpy) {
        this.jpy = jpy;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }

    public String getBrl() {
        return brl;
    }

    public void setBrl(String brl) {
        this.brl = brl;
    }

    public String getEgp() {
        return egp;
    }

    public void setEgp(String egp) {
        this.egp = egp;
    }

    public String getGhs() {
        return ghs;
    }

    public void setGhs(String ghs) {
        this.ghs = ghs;
    }

    public String getKrw() {
        return krw;
    }

    public void setKrw(String krw) {
        this.krw = krw;
    }

    public String getMxn() {
        return mxn;
    }

    public void setMxn(String mxn) {
        this.mxn = mxn;
    }

    public String getQar() {
        return qar;
    }

    public void setQar(String qar) {
        this.qar = qar;
    }

    public String getRub() {
        return rub;
    }

    public void setRub(String rub) {
        this.rub = rub;
    }

    public String getSar() {
        return sar;
    }

    public void setSar(String sar) {
        this.sar = sar;
    }

    public String getZar() {
        return zar;
    }

    public void setZar(String zar) {
        this.zar = zar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "BTC{" +
                "usd=" + usd +
                ", eur=" + eur +
                ", gbp=" + gbp +
                ", ngn=" + ngn +
                ", cad=" + cad +
                ", sgd=" + sgd +
                ", chf=" + chf +
                ", myr=" + myr +
                ", jpy=" + jpy +
                ", cny=" + cny +
                ", brl=" + brl +
                ", egp=" + egp +
                ", ghs=" + ghs +
                ", krw=" + krw +
                ", mxn=" + mxn +
                ", qar=" + qar +
                ", rub=" + rub +
                ", sar=" + sar +
                ", zar=" + zar +
                '}';
    }


}
