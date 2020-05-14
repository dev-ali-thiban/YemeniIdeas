package com.dev_thiban.yemeniideas.Reports;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.dev_thiban.yemeniideas.R;

public class Report_Activity extends AppCompatActivity {

    Spinner spinner;
    TextView txt_main, txt_a, txt_b;
    Resources res;
    LinearLayout linr_coll_a, linr_coll_b;
    CardView card_report_coll ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_activity);

        txt_main = findViewById(R.id.txt_main);
        txt_a = findViewById(R.id.txt_a);
        txt_b = findViewById(R.id.txt_b);

        card_report_coll = findViewById(R.id.card_report_coll);
        card_report_coll.setVisibility(View.GONE);

        linr_coll_a = findViewById(R.id.linr_coll_a);
        linr_coll_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + txt_a.getText().toString()));
                startActivity(i);
            }
        });
        linr_coll_b = findViewById(R.id.linr_coll_b);
        linr_coll_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + txt_b.getText().toString()));
                startActivity(i);
            }
        });

        res = getResources();
        final String[] number_phones_city_1 = res.getStringArray(R.array.number_phones_city_1);
        final String[] number_phones_city_2 = res.getStringArray(R.array.number_phones_city_2);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 != 0) {
                    card_report_coll.setVisibility(View.VISIBLE);

                    txt_a.setText(number_phones_city_1[arg2]);
                    txt_b.setText(number_phones_city_2[arg2]);

                    if (number_phones_city_1[arg2].length() == 0
                            || number_phones_city_2[arg2].compareTo("") == 0) {
                        txt_main.setText("لا يوجد رقم للمحافظة اتصل على 01255952 للاستعلام");
                        txt_a.setText(number_phones_city_1[0]);
                        txt_b.setText(number_phones_city_2[0]);
                    } else if (number_phones_city_2[arg2].length() == 0
                            || number_phones_city_2[arg2].compareTo("") == 0) {
                        txt_main.setText("لا يوجد رقم للمحافظة اتصل على 01255952 للاستعلام");
                        txt_a.setText(number_phones_city_1[0]);
                        txt_b.setText(number_phones_city_2[0]);
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
}
