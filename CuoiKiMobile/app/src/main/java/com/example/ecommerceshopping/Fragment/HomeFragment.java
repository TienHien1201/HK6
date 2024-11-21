package com.example.ecommerceshopping.Fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.PopularItem;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.PopularAdapter;
import com.example.ecommerceshopping.databinding.FragmentHomeBinding;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

//Bắt sự kiện xem menu
        binding.ViewAllMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuBootomSheetFragment bottomSheetDialog = new MenuBootomSheetFragment();
                bottomSheetDialog.show(getParentFragmentManager(), "Test");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.baner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(imageList);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int i) {
            }
            @Override
            public void onItemSelected(int position) {
                String itemMessage = "Select Image " + position;
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(requireContext());
        if (db.getPopularItems().isEmpty()) {
            db.insertPopularItem("Burger", 5, drawableToByteArray(R.drawable.menu1));
            db.insertPopularItem("Sandwich", 7, drawableToByteArray(R.drawable.menu2));
            db.insertPopularItem("Momo", 8, drawableToByteArray(R.drawable.menu3));
            db.insertPopularItem("Phoenix Rolls", 10, drawableToByteArray(R.drawable.menu4));
        }
        List<PopularItem> popularItems = db.getPopularItems();

        PopularAdapter adapter = new PopularAdapter(popularItems);
        binding.PopulerRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.PopulerRecycleView.setAdapter(adapter);
    }

    private byte[] drawableToByteArray(int drawableId) {
        BitmapDrawable drawable = (BitmapDrawable) requireContext().getDrawable(drawableId);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
