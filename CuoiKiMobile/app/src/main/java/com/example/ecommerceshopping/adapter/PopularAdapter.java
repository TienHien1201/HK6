package com.example.ecommerceshopping.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.PopularItem;
import com.example.ecommerceshopping.databinding.PopulerItemBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private List<PopularItem> items;

    public PopularAdapter(List<PopularItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PopulerItemBinding binding = PopulerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PopularViewHolder(binding, items);
    }


    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        PopularItem item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        private PopulerItemBinding binding;

        public PopularViewHolder(PopulerItemBinding binding, List<PopularItem> items) {
            super(binding.getRoot());
            this.binding = binding;
            binding.AddToCartPupoler.setOnClickListener(v -> {
                PopularItem item = items.get(getAdapterPosition());
                addToCart(item);
            });
        }

        public void bind(PopularItem item) {
            binding.foodNamePupoler.setText(item.getName());
            binding.pricePopular.setText("$" + item.getPrice());

            Bitmap bitmap = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
            binding.imagePopuler.setImageBitmap(bitmap);
        }

        private void addToCart(PopularItem item) {
            int menuId = item.getId();
            String name = item.getName();
            int price = item.getPrice();
            byte[] image = item.getImage();
            int quality = 1;

            DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());

            int currentQuality = db.getCartItemQualityByName(name);

            if (currentQuality > 0) {
                db.updateCartQuality(name, currentQuality + quality);
                Toast.makeText(binding.getRoot().getContext(), "Increased item quantity in cart", Toast.LENGTH_SHORT).show();
            } else {
                db.insertCart(menuId, name, price, image, quality);
                Toast.makeText(binding.getRoot().getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        }
    }

    }
