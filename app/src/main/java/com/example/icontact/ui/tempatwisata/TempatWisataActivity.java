package com.example.icontact.ui.tempatwisata;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icontact.IntroActivity;
import com.example.icontact.MapActivity;
import com.example.icontact.R;
import com.example.icontact.data.TempatWisata;
import com.example.icontact.views.SplashActivity;

import java.util.ArrayList;
import java.util.List;

public class TempatWisataActivity extends AppCompatActivity implements TempatWisataAdapter.OnClickListner {

    private RecyclerView rvTempatWisata;
    private TempatWisataAdapter adapter;
    private MapActivity mapactivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daftar_tempat_wisata);
        rvTempatWisata = findViewById(R.id.rv_tempat_wisata);

        setupWidgets();
    }

    private void setupWidgets() {
        if(rvTempatWisata.getAdapter() == null) {
            adapter = new TempatWisataAdapter(getTempatWisataDummy(100), this);
//            rvTempatWisata.setLayoutManager(new LinearLayoutManager(this));
            rvTempatWisata.setLayoutManager(new GridLayoutManager(this, 2));
            rvTempatWisata.setAdapter(adapter);
        }
    }

    private List<TempatWisata> getTempatWisataDummy(int size) {
        ArrayList<TempatWisata> tempatWisataDummy = new ArrayList<>();

        for(int i=1; i<= size; i++) {
            tempatWisataDummy.add(new TempatWisata("Tempat Wisata ke " + i, "Jalan Kebon Kopi no " + i, -7.166707, 107.357501));
        }

        return tempatWisataDummy;
    }

    @Override
    public void onClick(int position) {
        TempatWisata tw = adapter.getItem(position);
        Intent map = new Intent(TempatWisataActivity.this, MapActivity.class);
        map.putExtra("data", tw);
        startActivity(map);
    }
}
