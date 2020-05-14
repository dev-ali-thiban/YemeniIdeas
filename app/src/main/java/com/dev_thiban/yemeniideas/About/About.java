package com.dev_thiban.yemeniideas.About;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

public class About extends AppCompatActivity {

    RecyclerView recy_it, recy_doctors, recy_makanik, recy_runs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        recy_it = findViewById(R.id.recy_it);
        recy_it.setLayoutManager(new GridLayoutManager(this, 4));
        recy_doctors = findViewById(R.id.recy_doctors);
        recy_doctors.setLayoutManager(new GridLayoutManager(this, 4));
        recy_makanik = findViewById(R.id.recy_makanik);
        recy_makanik.setLayoutManager(new GridLayoutManager(this, 4));
        recy_runs = findViewById(R.id.recy_runs);
        recy_runs.setLayoutManager(new GridLayoutManager(this, 4));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                go();
            }
        },1000);
    }

    public void go (){
        About_Adapter adapter = new About_Adapter(About_Data.about_list("التقنية"), this);
        recy_it.setAdapter(adapter);

        About_Adapter adapter_2 = new About_Adapter(About_Data.about_list("طب"), this);
        recy_doctors.setAdapter(adapter_2);

        About_Adapter adapter_3 = new About_Adapter(About_Data.about_list("هندسة"), this);
        recy_makanik.setAdapter(adapter_3);

        About_Adapter adapter_4 = new About_Adapter(About_Data.about_list("التنفيذ والادارة المدانية"), this);
        recy_runs.setAdapter(adapter_4);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_null, R.anim.move_bottom);
    }

}
