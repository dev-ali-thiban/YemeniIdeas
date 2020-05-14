package com.dev_thiban.yemeniideas.Exam;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dev_thiban.yemeniideas.R;

public class Exam_Test extends Fragment {

    public Exam_Test() {
    }

    public static EditText ed_exam;
    TextView txt_exam;
    RadioGroup rg_exam;
    ImageView img_exam;

    int num_point ;
//    public static int num_checke_ex ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.exam_test, container, false);
        setRetainInstance(true);

        txt_exam = view.findViewById(R.id.txt_exam);
        img_exam = view.findViewById(R.id.img_exam);
        ed_exam = view.findViewById(R.id.ed_exam);
        ed_exam.setVisibility(View.GONE);

        rg_exam = view.findViewById(R.id.rg_exam);
        rg_exam.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_exam.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_exam_1:
                        Exam_Activity_2.num_checke_ex = num_point ;
                        break;
                    case R.id.rb_exam_2:
                        Exam_Activity_2.num_checke_ex = 0;
                        break;
                }
            }
        });

        add_exam_data();

        return view;
    }


    public void add_exam_data() {
        if (Exam_Activity_2.num_slid_exam == 1) {
            txt_exam.setText("هل تشكو من حمى أو درجة حرارة مرتفعة أكثر من (37.8) درجة مئوية ؟");
            img_exam.setImageResource(R.drawable.ex_img_1);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 2 ;

        } else if (Exam_Activity_2.num_slid_exam == 2) {
            txt_exam.setText("هل تشكو من السعال الجاف أو السعال الشديد المستمر؟");
            img_exam.setImageResource(R.drawable.ex_img_2);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 2 ;

        } else if (Exam_Activity_2.num_slid_exam == 3) {
            txt_exam.setText("هل لديك سيلان من الأنف؟");
            img_exam.setImageResource(R.drawable.ex_img_3);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 1 ;

        } else if (Exam_Activity_2.num_slid_exam == 4) {
            txt_exam.setText("هل تشعر انك فقدت حاسة الذوق او الشم؟");
            img_exam.setImageResource(R.drawable.ex_img_4);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 2 ;

        } else if (Exam_Activity_2.num_slid_exam == 5) {
            txt_exam.setText("هل لديك اسهال؟");
            img_exam.setImageResource(R.drawable.ex_img_5);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 0 ;

        } else if (Exam_Activity_2.num_slid_exam == 6) {
            txt_exam.setText("هل تشكو من تعب أو إرهاق عام أو أوجاع أو آلام في العضلات أو المفاصل حديثه؟");
            img_exam.setImageResource(R.drawable.ex_img_6);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 1 ;

        } else if (Exam_Activity_2.num_slid_exam == 7) {
            txt_exam.setText("هل تشعر بآلام في الحلق؟");
            img_exam.setImageResource(R.drawable.ex_img_7);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 1 ;

        } else if (Exam_Activity_2.num_slid_exam == 8) {
            txt_exam.setText("هل تشعر احتقان في الأنف؟");
            img_exam.setImageResource(R.drawable.ex_img_8);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 1 ;

        } else if (Exam_Activity_2.num_slid_exam == 9) {
            txt_exam.setText("هل عدت أو أي أحد من اقاربك من سفر خارج اليمن خلال الشهر الماضي ؟");
            img_exam.setImageResource(R.drawable.ex_img_9);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 4 ;

        } else if (Exam_Activity_2.num_slid_exam == 10) {
            txt_exam.setText("هل قمت بالسفر داخل اليمن؟");
            img_exam.setImageResource(R.drawable.ex_img_10);
            ed_exam.setHint("اذكر المحافظة التي كنت فيها ؟");
            ed_exam.setVisibility(View.VISIBLE);
            num_point = 3 ;

        } else if (Exam_Activity_2.num_slid_exam == 11) {
            txt_exam.setText("هل قمت بمخالطة لحالة إلتهاب تنفسي حاد؟");
            img_exam.setImageResource(R.drawable.ex_img_11);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 4 ;

        } else if (Exam_Activity_2.num_slid_exam == 12) {
            txt_exam.setText("هل قمت بزيارة مستشفى صحي ثبت فيه حالة كورونا موجبة ؟");
            img_exam.setImageResource(R.drawable.ex_img_12);
            ed_exam.setHint("");
            ed_exam.setVisibility(View.GONE);
            num_point = 4 ;

        } else if (Exam_Activity_2.num_slid_exam == 13) {
            txt_exam.setText("هل تعاني من أمراض مزمنة كالـ قلب - ضغط - سكر ...الخ او لديك مرض قديم ؟");
            img_exam.setImageResource(R.drawable.ex_img_13);
            ed_exam.setHint("اذكر ذلك المرض ؟");
            ed_exam.setVisibility(View.VISIBLE);
            num_point = 3 ;

        } else if (Exam_Activity_2.num_slid_exam == 14) {
            txt_exam.setText("هل انت مدخن؟");
            img_exam.setImageResource(R.drawable.ex_img_14);
            ed_exam.setVisibility(View.GONE);
            num_point = 1 ;

        } else if (Exam_Activity_2.num_slid_exam == 15) {
            txt_exam.setText("هل لديك اي ملاحظة اخرى ؟");
            img_exam.setVisibility(View.GONE);
            rg_exam.setVisibility(View.GONE);
            ed_exam.setHint("اكتب ملاحظتك اذا اردت ...");
            ed_exam.setVisibility(View.VISIBLE);

        }

    }

//    @Override
//    public void onStart() {
//        if (Exam_Data.ex_a != 0) {rg_a.check(R.id.rb_a_1);
//            ed_name_shop_2.setText(Shop_Data_List.user_name);
//        }
//        if (Shop_Data_List.user_number != 0) {
//            ed_phone_shop_2.setText(String.valueOf(Shop_Data_List.user_number));
//        }
//        if (Shop_Data_List.user_addriss != null) {
//            ed_adress_shop_2.setText(Shop_Data_List.user_addriss);
//        }
//        if (Shop_Data_List.user_note != null) {
//            ed_note_shop_2.setText(Shop_Data_List.user_note);
//        }
//        if (Shop_Data_List.time_way_slid != null) {
//            txt_time.setText(Shop_Data_List.time_way_slid);
//        }
//        if (Shop_Data_List.range_way_slid != null) {
//            txt_range.setText(Shop_Data_List.range_way_slid);
//        }
//        super.onStart();
//    }
//
    @Override
    public void onDestroy() {
////        if (ed_name_shop_2.getText().toString().length() != 0) {
////            Shop_Data_List.user_name = ed_name_shop_2.getText().toString();
////        }
////        if (ed_phone_shop_2.getText().toString().length() != 0) {
////            Shop_Data_List.user_number = Integer.valueOf(ed_phone_shop_2.getText().toString());
////        }
////        if (ed_adress_shop_2.getText().toString().length() != 0) {
////            Shop_Data_List.user_addriss = ed_adress_shop_2.getText().toString();
////        }
////        if (ed_note_shop_2.getText().toString().length() != 0) {
////            Shop_Data_List.user_note = ed_note_shop_2.getText().toString();
////        }
////        if (txt_time.getText().toString().length() != 0) {
////            Shop_Data_List.time_way_slid = txt_time.getText().toString();
////        }
////        if (txt_range.getText().toString().length() != 0) {
////            Shop_Data_List.range_way_slid = txt_range.getText().toString();
////        }
        super.onDestroy();
    }

}
