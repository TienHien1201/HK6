package com.example.lab23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        listView = view.findViewById(R.id.listView);
        arrayList = new ArrayList<>();

        if (Utils.furnitureHistory != null) {
            arrayList.addAll(Utils.furnitureHistory);
        }

        furnitureAdapter = new FurnitureAdapter(getContext(), arrayList);
        listView.setAdapter(furnitureAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Utils.furnitureHistory != null) {
            arrayList.clear();
            arrayList.addAll(Utils.furnitureHistory);
            furnitureAdapter.notifyDataSetChanged();
        }
    }
}
