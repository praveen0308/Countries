package com.jmm.brsap.countries.di;

import com.jmm.brsap.countries.network.ApiService;
import com.jmm.brsap.countries.repository.CountryRepository;
import com.jmm.brsap.countries.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public static ApiService provideApiService(){

        return  new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    public CountryRepository provideCountryRepository(ApiService apiService){
        return new CountryRepository(apiService);
    }
}
