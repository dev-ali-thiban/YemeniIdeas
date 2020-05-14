package com.dev_thiban.yemeniideas.Exam;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.dev_thiban.yemeniideas.R;

public class Exam_Activity extends AppCompatActivity {

    private int optionSelected = 4;
    private Exam_1 mFirstFragment;
    private Button btn_next;
    private ImageView img_number_1, img_number_2, img_number_3;
    ProgressDialog pds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        img_number_1 = findViewById(R.id.img_number_1);
        img_number_2 = findViewById(R.id.img_number_2);
        img_number_3 = findViewById(R.id.img_number_3);

        pds = new ProgressDialog(Exam_Activity.this);
        pds.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pds.setMessage("جاري ارسال الفحص .. ☺");
        pds.setIndeterminate(true);
        pds.setCancelable(false);
//        pds.show();

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_ok_1()) {
                    next_shop();
                }
            }
        });

        mFirstFragment = new Exam_1();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_place, mFirstFragment);
        fragmentTransaction.commit();

        img_number_1.setImageResource(R.drawable.img_number_1_fll);
    }

    public void next_shop() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {

            if (is_ok_1()) {
                Fragment secondFragment = new Exam_2();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended
                        (this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_place);
                fragmentTransactionExtended.addTransition(optionSelected);
                fragmentTransactionExtended.commit();
                btn_next.setText("النتيجة");
                img_number_2.setImageResource(R.drawable.img_number_2_fll);
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        next_shop();
                    }
                });

            }

        } else if (getFragmentManager().getBackStackEntryCount() == 1) {

            if (is_ok_2()){

                // الذهاب للتالي
                Fragment secondFragment = new Exam_3();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended
                        (this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_place);
                fragmentTransactionExtended.addTransition(optionSelected);
                fragmentTransactionExtended.commit();
                btn_next.setText("اغلاق");
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                img_number_3.setImageResource(R.drawable.img_number_3_fll);

            }


        } else {
//            getFragmentManager().popBackStack();
//            btn_next.setText("التاكيد");
//            Toast.makeText(this, "تم ارسال طلبك", Toast.LENGTH_SHORT).show();
//            send_data_shop();
        }
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            img_number_1.setImageResource(R.drawable.img_number_1);
            img_number_2.setImageResource(R.drawable.img_number_2);
            img_number_3.setImageResource(R.drawable.img_number_3);
            btn_next.setText("التالي");
        } else if (getFragmentManager().getBackStackEntryCount() == 1) {
            img_number_2.setImageResource(R.drawable.img_number_2);
            img_number_3.setImageResource(R.drawable.img_number_3);
            btn_next.setText("التالي");
        } else if (getFragmentManager().getBackStackEntryCount() == 2) {
            img_number_3.setImageResource(R.drawable.img_number_3);
            btn_next.setText("التالي");
        }
        super.onBackPressed();
    }

    // ارسال الطلب
    public void send_data_shop() {
        pds.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pds.cancel();
                Toast.makeText(Exam_Activity.this, "تم ارسال طلبك بنجاح", Toast.LENGTH_SHORT).show();
                finsh_class();
            }
        }, 3000);
    }

    // اغلاق
    public void finsh_class() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }


    // التحقق من معلومات الاستبان الاول
    public boolean is_ok_1() {
        boolean ok = false;

        if (Exam_1.ed_name.getText().toString().length() < 2) {
            Toast.makeText(this, "يجب كتابة الاسم", Toast.LENGTH_SHORT).show();
        } else if (Exam_1.ed_age.getText().toString().length() < 1) {
            Toast.makeText(this, "يجب كتابة العمر", Toast.LENGTH_SHORT).show();
        } else if (Exam_1.ed_number.getText().toString().length() < 9) {
            Toast.makeText(this, "يجب كتابة رقم الهاتف وبشكل صحيح", Toast.LENGTH_SHORT).show();
        } else if (Exam_1.ed_address.getText().toString().length() < 3) {
            Toast.makeText(this, "يجب كتابة عنوانك", Toast.LENGTH_SHORT).show();
        } else if (Exam_1.num_sex == 0) {
            Toast.makeText(this, "يجب تحديد نوع الجنس", Toast.LENGTH_SHORT).show();
        } else if (Exam_1.num_city == 0) {
            Toast.makeText(this, "يجب تحديد المحافظة", Toast.LENGTH_SHORT).show();
        }else {
            ok = true ;
        }

        return ok;
    }

    // التحقق من الاستبيان الثاني
    public boolean is_ok_2() {
        boolean ok = false;

        if (Exam_2.ex_num_a == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال درجة الحرارة !", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_b == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال السعال !", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_c == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال سيلان الانف !", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_d == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال فقدان حاسة التذوق والشم !", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_e == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال تواجد اسهال !", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_f == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال الشعور بالتعب والارهاق ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_g == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال الشعور ألم بالحلق ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_h == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال الشعور بأحتقان في الانف ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_i == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال اذا كنت خارج اليمن ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_j == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال اذا كنت قد سافرت من محافظة الى محافظة ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_k == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال ", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_l == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال اذا كنت قد خالطت حالة مصابة ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_m == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال هل قمت بزيارة مستشفى صحي ..!", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_n == 0) {
            Toast.makeText(this, "الرجاء الاجابة على سؤال هل تعاني من امراض مزمنة ..!", Toast.LENGTH_SHORT).show();

        } else if (Exam_2.ex_num_j == 1 && Exam_2.ed_q.getText().toString().length() <= 3) {
            Toast.makeText(this, "الرجاء كتابة المحافظة التي كنت فيها ؟", Toast.LENGTH_SHORT).show();
        } else if (Exam_2.ex_num_m == 1 && Exam_2.ed_o.getText().toString().length() <= 2) {
            Toast.makeText(this, "الرجاء كتابة الامراض المزمنة ؟", Toast.LENGTH_SHORT).show();

        }else {
            ok = true ;
        }

        return ok;
    }


}
