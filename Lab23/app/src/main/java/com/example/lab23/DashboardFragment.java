package com.example.lab23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    GridView gridView;
    ArrayList<Categories> arrayList;
    FurnitureAdapterGrid furnitureAdapterGrid;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.gridView);
        arrayList = getMockData();
        furnitureAdapterGrid = new FurnitureAdapterGrid(getContext(), arrayList);

        furnitureAdapterGrid.setOnItemClickListener(position -> {
            Categories clickedCategory = arrayList.get(position);
            Toast.makeText(getContext(), "Category đã chọn: " + clickedCategory.getName(), Toast.LENGTH_SHORT).show();

            // Thêm vào lịch sử (nếu cần)
            Utils.furnitureHistory.add(new Furniture(clickedCategory.getName(), "", clickedCategory.getImage()));

            // Chuyển đến NotificationsFragment
            Fragment notificationsFragment = new NotificationsFragment();
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, notificationsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        gridView.setAdapter(furnitureAdapterGrid);
    }

    public ArrayList<Categories> getMockData() {
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories("Bedroom", new ArrayList<>(), R.drawable.bed_room));
        tmp.add(new Categories("Living Room", new ArrayList<>(), R.drawable.living_room));
        tmp.add(new Categories("Meeting Room", new ArrayList<>(), R.drawable.meeting_room));
        tmp.add(new Categories("Accessories", new ArrayList<>(), R.drawable.accessories));
        return tmp;
    }
}
