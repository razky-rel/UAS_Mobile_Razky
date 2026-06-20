package com.example.uas_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager; // Biar grid 2 kolom
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HewanFragment extends Fragment {

    private RecyclerView rvHewan;
    private AppDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hewan, container, false);

        rvHewan = view.findViewById(R.id.rvHewan);
        db = AppDatabase.getInstance(getContext());

        List<EndemikModel> allData = db.endemikDao().getAllEndemik();

        List<EndemikModel> listHewan = new ArrayList<>();
        for (EndemikModel item : allData) {
            if ("Hewan".equalsIgnoreCase(item.getTipe())) {
                listHewan.add(item);
            }
        }

        rvHewan.setLayoutManager(new GridLayoutManager(getContext(), 2));
        EndemikAdapter adapter = new EndemikAdapter(getContext(), listHewan);
        rvHewan.setAdapter(adapter);

        return view;
    }
}