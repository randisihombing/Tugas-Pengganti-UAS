package com.example.icontact.ui.tempatwisata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icontact.R;
import com.example.icontact.data.TempatWisata;

import java.util.ArrayList;
import java.util.List;

public class TempatWisataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    interface OnClickListner {

        public void onClick(int position);

    }

    private ArrayList<TempatWisata> data;
    private OnClickListner listener;

    public TempatWisataAdapter() {
        data = new ArrayList<>();
    }

    public TempatWisataAdapter(List<TempatWisata> initalData) {
        data = new ArrayList<>();
        data.addAll(initalData);
    }

    public TempatWisataAdapter(List<TempatWisata> initalData, OnClickListner listener) {
        data = new ArrayList<>();
        data.addAll(initalData);
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_list2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void replaceData(List<TempatWisata> _data) {
        this.data.clear();
        this.data.addAll(_data);
        notifyDataSetChanged();
    }

    public TempatWisata getItem(int position) {
        return data.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private TextView tvNamaTempat;
        private TextView tvAlamat;
        private ImageView ivTempatWisata;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            tvNamaTempat = view.findViewById(R.id.tv_nama_tempat);
            tvAlamat = view.findViewById(R.id.tv_alamat);
            ivTempatWisata = view.findViewById(R.id.iv_tempat_wisata);

        }

        public void bind(TempatWisata item, final OnClickListner listener) {
            tvNamaTempat.setText(item.getNama());
            tvAlamat.setText(item.getAlamat());
            ivTempatWisata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) listener.onClick(getAdapterPosition());
                }
            });
        }

    }

}
