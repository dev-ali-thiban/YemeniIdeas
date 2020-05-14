package com.dev_thiban.yemeniideas.Guidance;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

public class Guid_List extends AppCompatActivity {

    RecyclerView recyclerview;
    Guid_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guid_list);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("نصائح الوقاية");

        recyclerview = findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Guid_Adapter(Guid_Data.lists(), Guid_List.this);
        recyclerview.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Guid_List.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
