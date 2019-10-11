package com.sty.ne.paint.colorfilter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tian on 2019/10/11.
 */

public class ColorFilterDemoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ColorFilterAdapter mColorFilterAdapter;
    private List<float[]> filters = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initFilters();
        recyclerView = findViewById(R.id.recycler_view);
        mColorFilterAdapter = new ColorFilterAdapter(getLayoutInflater(), filters);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mColorFilterAdapter);
    }

    private void initFilters() {
        filters.add(ColorFilterUtils.colormatrix_heibai);
        filters.add(ColorFilterUtils.colormatrix_fugu);
        filters.add(ColorFilterUtils.colormatrix_gete);
        filters.add(ColorFilterUtils.colormatrix_chuan_tong);
        filters.add(ColorFilterUtils.colormatrix_danya);
        filters.add(ColorFilterUtils.colormatrix_guangyun);
        filters.add(ColorFilterUtils.colormatrix_fanse);
        filters.add(ColorFilterUtils.colormatrix_hepian);
        filters.add(ColorFilterUtils.colormatrix_huajiu);
        filters.add(ColorFilterUtils.colormatrix_jiao_pian);
        filters.add(ColorFilterUtils.colormatrix_landiao);
        filters.add(ColorFilterUtils.colormatrix_langman);
        filters.add(ColorFilterUtils.colormatrix_ruise);
        filters.add(ColorFilterUtils.colormatrix_menghuan);
        filters.add(ColorFilterUtils.colormatrix_qingning);
        filters.add(ColorFilterUtils.colormatrix_yese);
    }
}
