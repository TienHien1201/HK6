package com.example.ecommerceshopping.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.databinding.BuyAgainItemBinding;

import java.util.List;
public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyViewHolder> {
    private List<String> BuyAgainFoodName;
    private List<String> BuyAgainPrice;
    private List<byte[]> BuyAgainImage;

    public BuyAgainAdapter(List<byte[]> buyAgainImage, List<String> buyAgainPrice, List<String> buyAgainFoodName) {
        this.BuyAgainImage = buyAgainImage;
        this.BuyAgainPrice = buyAgainPrice;
        this.BuyAgainFoodName = buyAgainFoodName;
    }

    @NonNull
    @Override
    public BuyAgainAdapter.BuyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuyAgainItemBinding binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BuyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainAdapter.BuyViewHolder holder, int position) {
        String item = BuyAgainFoodName.get(position);
        String price = BuyAgainPrice.get(position);
        byte[] image = BuyAgainImage.get(position);
        holder.bind(item, price, image);
    }

    @Override
    public int getItemCount() {
        return BuyAgainFoodName.size();
    }

    public class BuyViewHolder extends RecyclerView.ViewHolder {
        private final BuyAgainItemBinding binding;

        public BuyViewHolder(@NonNull BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, byte[] image) {
            binding.BuyAgainFood.setText(item);
            binding.BuyAgainPrice.setText(price);

            // Chuyển đổi byte[] thành Bitmap
            if (image != null && image.length > 0) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                binding.BuyAgainImae.setImageBitmap(bitmap); // Hiển thị hình ảnh
            } else {
                binding.BuyAgainImae.setImageResource(R.drawable.more); // Hình ảnh mặc định
            }
        }

    }
}

