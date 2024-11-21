package com.example.ecommerceshopping.Fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecommerceshopping.Model.CartItem;
import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.UserSession;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.CartAdapter;
import com.example.ecommerceshopping.databinding.FragmentCartBinding;

import java.io.ByteArrayOutputStream;
import java.util.List;
public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private UserSession userSession;
    private Button btnPay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);

        userSession = UserSession.getInstance();

        Integer userId = userSession.getUserId();
        String username = userSession.getUsername();
        String role = userSession.getRole();


        DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(requireContext());
        List<CartItem> cartItems = db.getCart();

        btnPay = binding.BtnPay;


        if (cartItems.isEmpty()) {
            binding.emptyCartMessage.setVisibility(View.VISIBLE);
        } else {
            binding.emptyCartMessage.setVisibility(View.GONE);

            CartAdapter adapter = new CartAdapter(cartItems, btnPay, userSession);  // Truyền userSession vào CartAdapter
            binding.CartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            binding.CartRecyclerView.setAdapter(adapter);
        }
        btnPay.setOnClickListener(v -> {
            if (!cartItems.isEmpty()) {

                db.clearCart();
                Toast.makeText(requireContext(),
                        "Thanh toán thành công! Hãy vào lịch sử để xem chi tiết!",
                        Toast.LENGTH_LONG).show();

                binding.CartRecyclerView.getAdapter().notifyDataSetChanged();
                binding.emptyCartMessage.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(requireContext(),
                        "Giỏ hàng của bạn đang trống!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

}

