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

public class TumbuhanFragment extends Fragment {

    private RecyclerView rvTumbuhan;
    private AppDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tumbuhan, container, false);

        rvTumbuhan = view.findViewById(R.id.rvTumbuhan);
        db = AppDatabase.getInstance(getContext());

        // Ambil semua data
        List<EndemikModel> allData = db.endemikDao().getAllEndemik();

        // Filter cuma yang "Tipe" nya "Tumbuhan"
        List<EndemikModel> listTumbuhan = new ArrayList<>();
        for (EndemikModel item : allData) {
            if ("Tumbuhan".equalsIgnoreCase(item.getTipe())) {
                listTumbuhan.add(item);
            }
        }

        // Pasang Adapter ke RecyclerView
        rvTumbuhan.setLayoutManager(new GridLayoutManager(getContext(), 2));
        EndemikAdapter adapter = new EndemikAdapter(getContext(), listTumbuhan);
        rvTumbuhan.setAdapter(adapter);

        return view;
    }
}