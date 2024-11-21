package com.example.lab23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        arrayList = getMockData();
        furnitureAdapter = new FurnitureAdapter(getContext(), arrayList);
        listView.setAdapter(furnitureAdapter);

        // Set OnItemClickListener for the adapter
        furnitureAdapter.setOnItemClickListener(position -> {
            try {
                // Get clicked item
                Furniture clickedItem = arrayList.get(position);

                // Display Toast message
                Toast.makeText(getContext(), "Item đã chọn: " + clickedItem.getName(), Toast.LENGTH_SHORT).show();

                // Add item to history
                Utils.furnitureHistory.add(clickedItem);

                // Navigate to NotificationsFragment
                Fragment notificationsFragment = new NotificationsFragment();
                //Giúp thêm sửa xóa, thay thế Fragment tức có thể thao tác đc với fragment
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, notificationsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            } catch (Exception e) {
                // Catch any exception and show message to the user
                Toast.makeText(getContext(), "Không thể chuyển đến trang thông báo: " + e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
    }

    public ArrayList<Furniture> getMockData() {
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(getString(R.string.name_product_one),
                getString(R.string.product_one), R.drawable.hinh_1));
        tmp.add(new Furniture(getString(R.string.name_product_two),
                getString(R.string.product_tow), R.drawable.hinh_2));
        tmp.add(new Furniture(getString(R.string.name_product_three),
                getString(R.string.product_three), R.drawable.hinh_3));
        tmp.add(new Furniture(getString(R.string.name_product_four),
                getString(R.string.product_four), R.drawable.hinh_4));
        tmp.add(new Furniture(getString(R.string.name_product_five),
                getString(R.string.product_five), R.drawable.hinh_5));
        return tmp;
    }
}
