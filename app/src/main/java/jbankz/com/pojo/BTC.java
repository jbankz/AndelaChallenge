package jbankz.com.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by King Jaycee on 18/10/2017.
 */

public class BTC implements Parcelable{

    @SerializedName("USD")
    @Expose
    private String usd;
    @SerializedName("EUR")
    @Expose
    private String eur;
    @SerializedName("GBP")
    @Expose
    private String gbp;
    @SerializedName("NGN")
    @Expose
    private String ngn;
    @SerializedName("CAD")
    @Expose
    private String cad;
    @SerializedName("SGD")
    @Expose
    private String sgd;
    @SerializedName("CHF")
    @Expose
    private String chf;
    @SerializedName("MYR")
    @Expose
    private String myr;
    @SerializedName("JPY")
    @Expose
    private String jpy;
    @SerializedName("CNY")
    @Expose
    private String cny;
    @SerializedName("BRL")
    @Expose
    private String brl;
    @SerializedName("EGP")
    @Expose
    private String egp;
    @SerializedName("GHS")
    @Expose
    private String ghs;
    @SerializedName("KRW")
    @Expose
    private String krw;
    @SerializedName("MXN")
    @Expose
    private String mxn;
    @SerializedName("QAR")
    @Expose
    private String qar;
    @SerializedName("RUB")
    @Expose
    private String rub;
    @SerializedName("SAR")
    @Expose
    private String sar;
    @SerializedName("ZAR")
    @Expose
    private String zar;

    private String name;
    private String rate;
    private int images;

    public BTC(){}

    public BTC(int images, String name, String rate) {
        this.images = images;
        this.name = name;
        this.rate = rate;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    protected BTC(Parcel in) {
        usd = in.readString();
        eur = in.readString();
        gbp = in.readString();
        ngn = in.readString();
        cad = in.readString();
        sgd = in.readString();
        chf = in.readString();
        myr = in.readString();
        jpy = in.readString();
        cny = in.readString();
        brl = in.readString();
        egp = in.readString();
        ghs = in.readString();
        krw = in.readString();
        mxn = in.readString();
        qar = in.readString();
        rub = in.readString();
        sar = in.readString();
        zar = in.readString();
        name = in.readString();
        rate = in.readString();
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(usd);
        parcel.writeString(eur);
        parcel.writeString(gbp);
        parcel.writeString(ngn);
        parcel.writeString(cad);
        parcel.writeString(sgd);
        parcel.writeString(chf);
        parcel.writeString(myr);
        parcel.writeString(jpy);
        parcel.writeString(cny);
        parcel.writeString(brl);
        parcel.writeString(egp);
        parcel.writeString(ghs);
        parcel.writeString(krw);
        parcel.writeString(mxn);
        parcel.writeString(qar);
        parcel.writeString(rub);
        parcel.writeString(sar);
        parcel.writeString(zar);
        parcel.writeString(name);
        parcel.writeString(rate);
    }

    public static final Creator<BTC> CREATOR = new Creator<BTC>() {
        @Override
        public BTC createFromParcel(Parcel in) {
            return new BTC(in);
        }

        @Override
        public BTC[] newArray(int size) {
            return new BTC[size];
        }
    };
}
