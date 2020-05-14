package com.dev_thiban.yemeniideas.Exam;

import android.app.Activity;

import java.util.List;

public class Exam_Data {

    // -----------------------------| اسناد بيانات المستخدم الى المتغيرات |-----------------------
    public static String user_name, user_address;
    public static int user_age, user_number, user_sex, user_city;
//    public static void user_data_save(String name, String age, String number, String address,
//                                      int sex, int city) {
//        user_name=name;
//        user_age=age;
//        user_number=number;
//        user_address=address;
//        user_sex=sex;
//        user_city=city;
//    }

    // -----------------------------| حفظ بيانات الاستبيان |-----------------------
    public static int ex_point;
//    public static int ex_a,ex_b,ex_c,ex_d,ex_e,ex_f,ex_g,ex_h,ex_i,ex_j,ex_k,ex_l,ex_m,ex_n;
//    public static void exam_data_save() {
//
//    }

    // --------------------- Test End Point ------------------- //
    public static int exam_data_save(List<Integer> list, Activity a) {
//        Toast.makeText(a, "A "+ list.get(0), Toast.LENGTH_SHORT).show();
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = num + list.get(i);
        }
//        Toast.makeText(a, "عدد الاسئلة " + list.size(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(a, "مجموع النقاط" + num , Toast.LENGTH_SHORT).show();

        return num ;
    }

}
