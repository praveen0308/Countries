package com.jmm.brsap.countries.repository;

import com.jmm.brsap.countries.model.ApiResponse;
import com.jmm.brsap.countries.model.Country;
import com.jmm.brsap.countries.network.ApiService;

import java.util.List;

import javax.inject.Inject;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class CountryRepository {


    private ApiService apiService;

    @Inject
    public CountryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<Country>> getCountries(String region){
        return apiService.getCountries(region);
    }
}
