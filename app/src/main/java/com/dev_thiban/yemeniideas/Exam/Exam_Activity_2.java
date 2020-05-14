package com.dev_thiban.yemeniideas.Exam;

import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;
import com.dev_thiban.yemeniideas.R;

import java.util.ArrayList;
import java.util.List;

public class Exam_Activity_2 extends AppCompatActivity {

    private int optionSelected = 4;
    public static int num_slid_exam;
    private Exam_1 mFirstFragment;
    private Button btn_next;
    private ImageView img_number_1, img_number_2, img_number_3;
    ProgressDialog pds;

    List<Integer> list_exam = new ArrayList<>();
    String s_10, s_13, s_15;

    public static int num_checke_ex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);

        img_number_1 = findViewById(R.id.img_number_1);
        img_number_2 = findViewById(R.id.img_number_2);
        img_number_3 = findViewById(R.id.img_number_3);

        pds = new ProgressDialog(Exam_Activity_2.this);
        pds.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pds.setMessage("جاري ارسال الفحص .. ☺");
        pds.setIndeterminate(true);
        pds.setCancelable(false);
//        pds.show();

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_shop();

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
                num_slid_exam = getFragmentManager().getBackStackEntryCount() + 1;
                Fragment secondFragment = new Exam_Test();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended
                        (this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_place);
                fragmentTransactionExtended.addTransition(optionSelected);
                fragmentTransactionExtended.commit();
                btn_next.setText("التالي");
                img_number_2.setImageResource(R.drawable.img_number_2_fll);
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        next_shop();
                    }
                });

            }

        } else if (getFragmentManager().getBackStackEntryCount() == 15) {

            // الذهاب للنتيجة
            Toast.makeText(this, "يتم عرض النتيجة", Toast.LENGTH_SHORT).show();

//            btn_next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                }
//            });

        } else {
            if (is_ok_2()) {
                num_slid_exam = getFragmentManager().getBackStackEntryCount() + 1;
                Fragment secondFragment = new Exam_Test();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended
                        (this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_place);
                fragmentTransactionExtended.addTransition(optionSelected);
                fragmentTransactionExtended.commit();
                btn_next.setText("التالي");
                img_number_2.setImageResource(R.drawable.img_number_2_fll);
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        next_shop();
                    }
                });
                if (getFragmentManager().getBackStackEntryCount() == 14) {
                    btn_next.setText("النتيجة");
                    btn_next.setBackgroundResource(R.drawable.btn_no);
                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Exam_Data.exam_data_save(list_exam, Exam_Activity_2.this);
                            startActivity(new Intent(Exam_Activity_2.this, Exam_End.class)
                                    .putExtra("sum_point", Exam_Data.exam_data_save(list_exam, Exam_Activity_2.this))
                                    .putExtra("is_hot", list_exam.get(0)));
                            out_this();
                        }
                    });
                } else {
                    btn_next.setText("التالي");
                    img_number_2.setImageResource(R.drawable.img_number_2_fll);
                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            next_shop();
                        }
                    });

                }

            }
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Exam_Activity_2.this);
        builder.setMessage("لم تكمل الافحص بعد ، هل تريد الخروج ؟"); //Message
        builder.setIcon(android.R.drawable.ic_dialog_alert); //Icon
        builder.setPositiveButton("الخروج", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                out_this();
            }
        });
        builder.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

//        super.onBackPressed();
    }

    public void out_this(){
        num_checke_ex = -1;
        num_slid_exam = 0;
        finish();
    }
    // ارسال الطلب
    public void send_data_shop() {
        pds.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pds.cancel();
                Toast.makeText(Exam_Activity_2.this, "تم ارسال طلبك بنجاح", Toast.LENGTH_SHORT).show();
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
        } else {
            ok = true;
        }

        return ok;
    }

    // التحقق من الاستبيان الثاني
    public boolean is_ok_2() {
        boolean ok = false;

        if (num_checke_ex == -1) {
            Toast.makeText(this, "الرجاء اخيار الاجابة", Toast.LENGTH_SHORT).show();
        } else if (getFragmentManager().getBackStackEntryCount() == 10
                || getFragmentManager().getBackStackEntryCount() == 13
                && Exam_Test.ed_exam.getText().toString().length() < 3) {
            if (num_checke_ex == 0) {
                ok = true;
                num_checke_ex = -1;
            } else {
                Toast.makeText(this, "يجب كتابة المطلوب", Toast.LENGTH_SHORT).show();
                Exam_Test.ed_exam.setBackgroundResource(R.drawable.ed_layout_error);
            }

        } else {
            //TODO
            // حفظ بيانات الاتصال
            list_exam.add(num_checke_ex);
//            Toast.makeText(this,
//                    "" + list_exam.get(list_exam.size()),
//                    Toast.LENGTH_SHORT).show();
            if (getFragmentManager().getBackStackEntryCount() == 10) {
                s_10 = Exam_Test.ed_exam.getText().toString();
                Toast.makeText(this, "تم الحفظ", Toast.LENGTH_SHORT).show();
            } else if (getFragmentManager().getBackStackEntryCount() == 13) {
                s_13 = Exam_Test.ed_exam.getText().toString();
                Toast.makeText(this, "تم الحفظ", Toast.LENGTH_SHORT).show();
            } else if (getFragmentManager().getBackStackEntryCount() == 15) {
                s_15 = Exam_Test.ed_exam.getText().toString();
                Toast.makeText(this, "تم الحفظ", Toast.LENGTH_SHORT).show();
            }
            ok = true;
            num_checke_ex = -1;
        }

        return ok;
    }


}
