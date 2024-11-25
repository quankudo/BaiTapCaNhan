package com.example.baitapcanhan.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baitapcanhan.Adapter.Adapter;
import com.example.baitapcanhan.Domain.Item;
import com.example.baitapcanhan.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Item> itemList;
    RecyclerView rcv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rcv = v.findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemList = new ArrayList<>();
        getData();
        Adapter adapter = new Adapter(itemList);
        rcv.setAdapter(adapter);

        return v;
    }

    private void getData() {
        itemList.add(new Item(R.drawable.books, "Title 1", "Description for item 1"));
        itemList.add(new Item(R.drawable.books, "Title 2", "Description for item 2"));
        itemList.add(new Item(R.drawable.books, "Title 3", "Description for item 3"));
        itemList.add(new Item(R.drawable.books, "Title 4", "Description for item 4"));
        itemList.add(new Item(R.drawable.books, "Title 5", "Description for item 5"));
    }
}