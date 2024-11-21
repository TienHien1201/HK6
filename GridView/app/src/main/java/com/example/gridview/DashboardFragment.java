package com.example.gridview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    GridView gridView;
    ArrayList<Categories> arrayList;
        FurnitureAdapterGrid  furnitureAdapterGrid;
    public DashboardFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridview);
        arrayList = getMockData();
//        furnitureAdapterGrid = new FurnitureAdapterGrid(getContext(),arrayList);
//        gridView.setAdapter(furnitureAdapterGrid);
    }
    public ArrayList<Categories> getMockData(){
        ArrayList<Furniture> arrayListBed = new ArrayList<>();
        ArrayList<Furniture> arrayListLiving = new ArrayList<>();
        ArrayList<Furniture> arrayListMeeting = new ArrayList<>();
        ArrayList<Furniture> arrayListAccessories = new ArrayList<>();
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories("BedRoom", arrayListBed,
                Categories.convertStringToBitmapFromAccess(getContext(), "bed_room.png")));
        tmp.add(new Categories("LivingRoom", arrayListLiving,
                Categories.convertStringToBitmapFromAccess(getContext(), "living_room.png")));
        tmp.add(new Categories("MeetingRoom", arrayListMeeting,
                Categories.convertStringToBitmapFromAccess(getContext(), "meeting_room.png")));
        tmp.add(new Categories("Accessories", arrayListAccessories,
                Categories.convertStringToBitmapFromAccess(getContext(), "accessories.png")));
        return tmp;
    }
}