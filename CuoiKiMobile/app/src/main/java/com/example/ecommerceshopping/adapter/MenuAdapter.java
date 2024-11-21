package com.example.ecommerceshopping.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.MenuItem;
import com.example.ecommerceshopping.databinding.MenuItemBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;
    private Context context;

    // Constructor nhận vào danh sách menu items
    public MenuAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding binding = MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new MenuViewHolder(binding, menuItems); // Truyền menuItems vào đây
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final MenuItemBinding binding;
        private final List<MenuItem> menuItems;
        public MenuViewHolder(MenuItemBinding binding, List<MenuItem> menuItems) {
            super(binding.getRoot());
            this.binding = binding;
            this.menuItems = menuItems;

            binding.AddToCartPupoler.setOnClickListener(v -> {
                MenuItem item = menuItems.get(getAdapterPosition());
                addToCart(item);
            });
        }

        public void bind(MenuItem item) {
            binding.FoodNameMenu.setText(item.getName());
            binding.priceMenu.setText("$" + item.getPrice());

            Bitmap bitmap = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
            binding.imaggMenu.setImageBitmap(bitmap);
        }
        private void addToCart(MenuItem item) {
            int menuId = item.getId();
            String name = item.getName();
            int price = item.getPrice();
            byte[] image = item.getImage();
            int quality = 1;

            DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());
            db.clearDatabase();
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
