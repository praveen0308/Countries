package com.jmm.brsap.countries.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.jmm.brsap.countries.databinding.TemplateCountryBinding;
import com.jmm.brsap.countries.model.Country;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    private static List<Country> countryList = new ArrayList<>();
    private final CountriesInterface countriesInterface;
    public CountriesAdapter(CountriesInterface countriesInterface) {
        this.countriesInterface = countriesInterface;
    }

    @NonNull
    @NotNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CountriesViewHolder(TemplateCountryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false),countriesInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CountriesViewHolder holder, int position) {
        holder.bindCountry(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void setCountryList(List<Country> mList){
        countryList.clear();
        countryList.addAll(mList);
        notifyDataSetChanged();
//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCallback(CountriesAdapter.countryList, countryList));
//        diffResult.dispatchUpdatesTo(this);
    }

    protected static class CountriesViewHolder extends RecyclerView.ViewHolder {

        private TemplateCountryBinding binding;
        private CountriesInterface mListener;
        public CountriesViewHolder(TemplateCountryBinding binding,CountriesInterface mListener){
            super(binding.getRoot());
            this.binding = binding;
            this.mListener = mListener;

            itemView.setOnClickListener(v -> {
                mListener.onCountryClick(countryList.get(getAbsoluteAdapterPosition()));
            });

        }


        public void bindCountry(Country country){
            binding.textView.setText(country.getName());
//            Glide.with(itemView.getContext())
//                    .load(country.getFlag())
//                    .error(R.drawable.ic_baseline_error_24)
//                    .into(binding.imageView);

            GlideToVectorYou.init().with(itemView.getContext()).load(Uri.parse(country.getFlag()),binding.imageView);
        }
    }


    public interface CountriesInterface{
        void onCountryClick(Country country);
    }
}
