package com.example.lab23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {

    private TextView nameTextView;
    private TextView emailTextView;
    private TextView phoneTextView;
    private ImageView avatarImageView;
    private Button logoutButton;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize views
        nameTextView = view.findViewById(R.id.account_name);
        emailTextView = view.findViewById(R.id.account_email);
        phoneTextView = view.findViewById(R.id.account_phone);
        avatarImageView = view.findViewById(R.id.account_avatar);
        logoutButton = view.findViewById(R.id.logout_button);

        // Set data (In a real-world app, this data might come from a user model or API)
        nameTextView.setText("John Doe");
        emailTextView.setText("john.doe@example.com");
        phoneTextView.setText("123-456-7890");

        // You can set the avatar with a specific image (example here)
        avatarImageView.setImageResource(R.drawable.ic_launcher_foreground); // Replace with your image

        // Handle logout button click
        logoutButton.setOnClickListener(v -> {
            // Logic to log out the user (e.g., clearing session data, redirecting to login screen)
            logoutUser();
        });

        return view;
    }

    private void logoutUser() {
        // Example logic to log out user
        // For example, clear saved user data and navigate back to login screen

        // Assuming you want to switch to LoginFragment or a login activity:
        // Example: getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).commit();

        // Or if it's an Activity-based app:
        // startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
