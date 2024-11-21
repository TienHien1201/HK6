package com.example.ecommerceshopping.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.NotificationAdapter;
import com.example.ecommerceshopping.databinding.FragmentNotifactionBottomBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Notifaction_Bottom_Fragment extends BottomSheetDialogFragment {
    private FragmentNotifactionBottomBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotifactionBottomBinding.inflate(inflater, container, false);

        List<String> notificationText = Arrays.asList(
                "Your order has been Canceled Successfully",
                "Order has been taken by the driver",
                "Congrats Your Order Placed"
        );
        List<Integer> notificationImages = Arrays.asList(
                R.drawable.emojisad,
                R.drawable.delivery,
                R.drawable.check
        );

        NotificationAdapter adapter = new NotificationAdapter(
                new ArrayList<>(notificationText),
                new ArrayList<>(notificationImages)
        );

        binding.RecyclerNotification.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.RecyclerNotification.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
