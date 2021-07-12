package com.jmm.brsap.countries.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jmm.brsap.countries.adapter.CountriesAdapter;
import com.jmm.brsap.countries.databinding.ActivityMainBinding;
import com.jmm.brsap.countries.model.Country;
import com.jmm.brsap.countries.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements CountriesAdapter.CountriesInterface {

    private ActivityMainBinding binding;
    private CountriesAdapter countriesAdapter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setupRvCountries();
        subscribeObservers();
        viewModel.getCountries("Asia");
    }


    private void setupRvCountries() {
        countriesAdapter = new CountriesAdapter(this);
        binding.rvCountries.setHasFixedSize(true);
        binding.rvCountries.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCountries.setAdapter(countriesAdapter);
    }

    private void subscribeObservers() {
        viewModel.countries.observe(this, countries -> {
            if (countries != null) countriesAdapter.setCountryList(countries);
        });

        viewModel.isError.observe(this, isError -> {

        });

        viewModel.isLoading.observe(this, isLoading -> {
            if (isLoading != null) {
                showLoading(isLoading);
            }
        });
    }

    @Override
    public void onCountryClick(Country country) {
        Intent intent = new Intent(this,CountryDetailActivity.class);
        intent.putExtra("Country",country);
        startActivity(intent);
    }

    private void showLoading(boolean isVisible) {
        if (isVisible)
            binding.progressBar.setVisibility(View.VISIBLE);
        else
            binding.progressBar.setVisibility(View.GONE);
    }
}