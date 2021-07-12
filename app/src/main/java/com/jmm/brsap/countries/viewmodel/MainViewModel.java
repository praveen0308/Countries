package com.jmm.brsap.countries.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jmm.brsap.countries.model.ApiResponse;
import com.jmm.brsap.countries.model.Country;
import com.jmm.brsap.countries.repository.CountryRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


@HiltViewModel
public class MainViewModel extends ViewModel {

    private CountryRepository repository;
    private CompositeDisposable disposable;
    public MutableLiveData<List<Country>> countries = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> isError = new MutableLiveData<>(false);

    public LiveData<List<Country>> getCountryList() {
        return countries;
    }

    @Inject
    public MainViewModel(CountryRepository repository) {
        this.repository = repository;
        disposable = new CompositeDisposable();
    }

    public void getCountries(String region){
        isLoading.postValue(true);
        disposable.add(repository.getCountries(region).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        countries.postValue(value);
                        isLoading.postValue(false);
                        isError.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoading.postValue(false);
                        isError.postValue(true);
                        Log.e("ERROR", "getCountries: " + e.getMessage());
                    }
                }));

    }
}
