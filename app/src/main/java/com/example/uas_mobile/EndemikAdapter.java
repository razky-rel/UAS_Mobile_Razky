package com.example.uas_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class EndemikAdapter extends RecyclerView.Adapter<EndemikAdapter.ViewHolder> {
    private List<EndemikModel> dataList;
    private Context context;

    public EndemikAdapter(Context context, List<EndemikModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_endemik, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EndemikModel item = dataList.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvLokasi.setText(item.getLokasi());
        Glide.with(context).load(item.getFoto()).into(holder.imgEndemik);
    }

    @Override
    public int getItemCount() { return dataList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvLokasi;
        ImageView imgEndemik;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvLokasi = itemView.findViewById(R.id.tvLokasi);
            imgEndemik = itemView.findViewById(R.id.imgEndemik);
        }
    }
}