package com.dev_thiban.yemeniideas.Exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dev_thiban.yemeniideas.Message.Bag_Message;
import com.dev_thiban.yemeniideas.R;
import com.dev_thiban.yemeniideas.Reports.Report_Activity;

public class Exam_End extends AppCompatActivity {

    TextView txt_end;
    ImageView img_end;
    Button btn_end;
    int sum_point, is_hot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_end);

        Intent intent = getIntent();
        sum_point = intent.getIntExtra("sum_point", 0);
        is_hot = intent.getIntExtra("is_hot", 0);

        txt_end = findViewById(R.id.txt_end);
        img_end = findViewById(R.id.img_end);
        btn_end = findViewById(R.id.btn_end);

        end_point();
    }

    public void end_point() {
        if (sum_point <= 1) {
            txt_end.setText("ولا فيك شي ..! ☺" + getString(R.string.ex_end_1));
            img_end.setImageResource(R.drawable.ex_end_img_1);

        } else if (sum_point == 4) {
            img_end.setImageResource(R.drawable.ex_end_img_2);
            txt_end.setText("التزم بالبيت ( عزل ذاتي )" + getString(R.string.ex_end_2));

        } else if (sum_point == 5) {
            txt_end.setText("قم باستشارة طبيب او راسلنا مباشرة للاطلاع " + getString(R.string.ex_end_4));
            img_end.setVisibility(View.GONE);
            btn_end.setVisibility(View.VISIBLE);
            btn_end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Exam_End.this, Bag_Message.class)
                            .putExtra("number_message", 1)
                            .putExtra("user_data",
                                    "الاسم : " + Exam_Data.user_name + "\n\n"
                                            + "المحافظة : " + Exam_Data.user_city + "...." + "العنوان : " + Exam_Data.user_address + "\n\n"
                                            + "رقم الهاتف :" + String.valueOf(Exam_Data.user_number) + "\n"));
                }
            });

        } else if (sum_point > 5) {
            txt_end.setText("اتصل على الارقام الساخنة الان بالضغط على الزر بالاسفل ، واتبع النصائح التالية بعد تنفيذ الاتصال : " +
                    "\n\n"+ getString(R.string.ex_end_4));
            btn_end.setVisibility(View.VISIBLE);
            btn_end.setText("اتصل الان");
            btn_end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Exam_End.this, Report_Activity.class));
                }
            });
            img_end.setImageResource(R.drawable.ex_end_img_3);
            img_end.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Exam_End.this, Report_Activity.class));
                }
            });

        }

        if (is_hot == 2) {
            txt_end.setText(txt_end.getText().toString() + "\n" + getString(R.string.ex_end_3));
        }

    }
}
