package com.example.ecommerceshopping.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceshopping.Model.CartItem;
import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.UserSession;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.databinding.CartItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<CartItem> cartItems;
    private Button btnPay;
    private UserSession userSession;
    private DatabaseEcommerceShopingOnline db;
    public CartAdapter(List<CartItem> cartItems, Button btnPay, UserSession userSession) {
        this.cartItems = new ArrayList<>(cartItems);
        this.btnPay = btnPay;
        this.userSession = userSession;
        setPayButtonListener();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.bind(cartItem);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
    private void setPayButtonListener() {
        btnPay.setOnClickListener(v -> {
            if (!cartItems.isEmpty()) {
                 db = new DatabaseEcommerceShopingOnline(btnPay.getContext());
                for (CartItem item : cartItems) {
                    int userId = userSession.getUserId();

                    byte[] imageBytes = item.getImage();
                    db.insertOrderDetails(
                            userId,
                            item.getName(),
                            item.getPrice() * item.getQuality(),
                            "paid",
                            imageBytes
                    );
                }

                // Xóa toàn bộ giỏ hàng
                db.clearCart();


                // Cập nhật giao diện RecyclerView
                cartItems.clear();
                notifyDataSetChanged();

                Log.d("CartAdapter", "Thanh toán thành công và giỏ hàng đã được xóa!");
            } else {
                Log.d("CartAdapter", "Giỏ hàng rỗng, không thể thanh toán.");
            }
        });
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private final CartItemBinding binding;

        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CartItem cartItem) {
            binding.CartFoodname.setText(cartItem.getName());
            binding.CartPrice.setText(String.format("$", cartItem.getPrice()));

            // Chuyển đổi byte[] thành Bitmap
            byte[] imageBytes = cartItem.getImage();
            if (imageBytes != null && imageBytes.length > 0) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                binding.CartImage.setImageBitmap(bitmap);
            } else {
                binding.CartImage.setImageResource(R.drawable.more); // Hình mặc định
            }

            // Hiển thị số lượng
            binding.quality.setText(String.valueOf(cartItem.getQuality()));

            binding.minusBtn.setOnClickListener(v -> {
                int quantity = cartItem.getQuality();

                if (quantity > 1) {
                    cartItem.setQuality(quantity - 1);
                    binding.quality.setText(String.valueOf(cartItem.getQuality()));

                    // Cập nhật cơ sở dữ liệu
                    DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());
                    db.updateCartQuality(cartItem.getName(), cartItem.getQuality());
                } else {
                    DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());
                    db.deleteCartItem(cartItem.getCartId());

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        cartItems.remove(position);
                        notifyItemRemoved(position);
                    }
                }
            });

            binding.plusbtn.setOnClickListener(v -> {
                int quantity = cartItem.getQuality();

                if (quantity < 10) { // Giới hạn số lượng tối đa là 10
                    cartItem.setQuality(quantity + 1);
                    binding.quality.setText(String.valueOf(cartItem.getQuality()));

                    DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());
                    db.updateCartQuality(cartItem.getName(), cartItem.getQuality());
                }
            });

            binding.deleteCart.setOnClickListener(v -> {
                DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(binding.getRoot().getContext());
                db.deleteCartItem(cartItem.getCartId());

                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    cartItems.remove(position);
                    notifyItemRemoved(position);
                }
            });

        }

    }


}
