package com.dev_thiban.yemeniideas.Guidance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev_thiban.yemeniideas.R;

public class Guid_Activity extends AppCompatActivity {

    int id, imgs, type;
    String title, body, link;
    TextView txt_title_activity, txt_body_activity;
    ImageView img_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guid_acivity);

        setTitle("نصائح الوقاية");

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        title = intent.getStringExtra("title");
        body = intent.getStringExtra("body");
        type = intent.getIntExtra("type", 0);
        imgs = intent.getIntExtra("img", 0);
        link = intent.getStringExtra("link");

        txt_title_activity = findViewById(R.id.txt_title_activity);
        txt_title_activity.setText(title);
        txt_body_activity = findViewById(R.id.txt_body_activity);
        txt_body_activity.setText(body);
        img_activity = findViewById(R.id.img_activity);
        img_activity.setImageResource(imgs);

    }

}
