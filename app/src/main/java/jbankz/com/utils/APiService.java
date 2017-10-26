package jbankz.com.utils;

import jbankz.com.pojo.CoinResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by King Jaycee on 18/10/2017.
 */

public interface APiService {
    @GET("data/pricemulti?")
    Call<CoinResponse> getPrice(@Query("fsyms") String coins, @Query("tsyms") String currency);

}
