package com.example.ecommerceshopping.Fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.MenuAdapter;
import com.example.ecommerceshopping.databinding.FragmentSearchBinding;
import com.example.ecommerceshopping.Model.MenuItem;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private MenuAdapter menuAdapter;
    private List<MenuItem> filterMenuItems = new ArrayList<>();
    private List<MenuItem> allMenuItems = new ArrayList<>();

    private DatabaseEcommerceShopingOnline db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            binding = FragmentSearchBinding.inflate(inflater, container, false);

            db = new DatabaseEcommerceShopingOnline(getContext());

            db.insertOrderDetails(
                    1,                      // userId
                    "Burger",               // itemName
                    5.0,                    // itemPrice
                    "paid",                 // status
                    drawableToByteArray(R.drawable.menu2) // image dưới dạng byte[]
            );
            menuAdapter = new MenuAdapter(filterMenuItems);
            binding.MenuRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.MenuRecycleView.setAdapter(menuAdapter);
            loadMenuItems();

            showAllMenu();

            setUpSearchView();

            return binding.getRoot();

        } catch (Exception e) {
            Log.e("SearchFragment", "Error in onCreateView", e);
            return null;
        }
    }
    private byte[] drawableToByteArray(int drawableId) {
        BitmapDrawable drawable = (BitmapDrawable) requireContext().getDrawable(drawableId);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
    private void loadMenuItems() {
        try {
            allMenuItems = db.getMenuItems();
            Log.d("SearchFragment", "Menu items loaded: " + allMenuItems.size());
        } catch (Exception e) {
            Log.e("SearchFragment", "Error loading menu items from database", e);
        }
    }

    private void showAllMenu() {
        try {
            filterMenuItems.clear();
            filterMenuItems.addAll(allMenuItems); // Show all items initially
            menuAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e("SearchFragment", "Error showing all menu items", e);
        }
    }

    private void setUpSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItem(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItem(newText);
                return true;
            }
        });
    }

    private void filterMenuItem(String query) {
        try {
            filterMenuItems.clear();
            // Ensure the query is not empty
            if (query != null && !query.trim().isEmpty()) {
                for (MenuItem item : allMenuItems) {
                    if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                        filterMenuItems.add(item); // Add the filtered item to the list
                    }
                }
            } else {
                filterMenuItems.addAll(allMenuItems);
            }
            menuAdapter.notifyDataSetChanged(); // Notify the adapter to update the RecyclerView
        } catch (Exception e) {
            Log.e("SearchFragment", "Error filtering menu items", e);
        }
    }
}
