package com.jmm.brsap.countries.adapter;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.jmm.brsap.countries.model.Country;

import java.util.List;

public class MyDiffUtilCallback extends DiffUtil.Callback{

    List<Country> oldCountries;
    List<Country> newCountries;

    public MyDiffUtilCallback(List<Country> newCountries, List<Country> oldCountries) {
        this.newCountries = newCountries;
        this.oldCountries = oldCountries;
    }

    @Override
    public int getOldListSize() {
        return oldCountries.size();
    }

    @Override
    public int getNewListSize() {
        return newCountries.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCountries.get(oldItemPosition).getName().equals(newCountries.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCountries.get(oldItemPosition).equals(newCountries.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}