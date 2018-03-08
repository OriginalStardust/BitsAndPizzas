package com.example.bitsandpizzas;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class PizzaFragment extends ListFragment {


    public PizzaFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1, this.getResources().getStringArray(R.array.pizzas));
        this.setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
