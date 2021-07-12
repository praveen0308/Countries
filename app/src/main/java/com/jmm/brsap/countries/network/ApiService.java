package com.jmm.brsap.countries.network;


import com.jmm.brsap.countries.model.ApiResponse;
import com.jmm.brsap.countries.model.Country;


import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("region/{region}")
    Single<List<Country>> getCountries(
            @Path("region") String region
    );

}
