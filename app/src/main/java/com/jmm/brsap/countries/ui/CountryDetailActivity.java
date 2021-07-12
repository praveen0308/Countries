package com.jmm.brsap.countries.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.jmm.brsap.countries.R;
import com.jmm.brsap.countries.databinding.ActivityCountryDetailBinding;
import com.jmm.brsap.countries.databinding.ActivityMainBinding;
import com.jmm.brsap.countries.model.Country;

public class CountryDetailActivity extends AppCompatActivity {

    private ActivityCountryDetailBinding binding;
    private Country country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        country = (Country)getIntent().getParcelableExtra("Country");
        GlideToVectorYou.init().with(this).load(Uri.parse(country.getFlag()),binding.imgFlag);
        binding.tvCountryName.setText(country.getName());
        binding.tvRegion.setText(country.getRegion());
        binding.tvSubregion.setText(country.getSubregion());
        binding.tvCapital.setText(country.getCapital());
        binding.tvPopulation.setText(String.valueOf(country.getPopulation()));
//        binding.tvLanguages.setText(country.getLanguages().toString());
//        binding.tvCountryName.setText(country.getName());;

        StringBuilder sbBorders = new StringBuilder();
        for(int i=0;i<country.getBorders().size()-1;i++){
            if (i==country.getBorders().size()-1){
                sbBorders.append(country.getBorders().get(i));
            }
            else {
                sbBorders.append(country.getBorders().get(i)).append(",");
            }

        }
        binding.tvBorders.setText(sbBorders.toString());

        StringBuilder sbLanguages = new StringBuilder();
        for(int i=0;i<country.getLanguages().size()-1;i++){
            if (i==country.getLanguages().size()-1){
                sbLanguages.append(country.getLanguages().get(i).getName());
            }
            else {
                sbLanguages.append(country.getLanguages().get(i).getName()).append(",");
            }

        }
        binding.tvLanguages.setText(sbLanguages.toString());

    }
}