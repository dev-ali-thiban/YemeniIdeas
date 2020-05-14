package com.dev_thiban.yemeniideas.Exam;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.dev_thiban.yemeniideas.R;

public class Exam_1 extends Fragment {

    public static EditText ed_address, ed_number, ed_age, ed_name;
    RadioGroup rg_a;
    Spinner spinner1;

    public static int num_sex, num_city;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.exam_view_1, container, false);

        ed_address = view.findViewById(R.id.ed_address);
        ed_number = view.findViewById(R.id.ed_number);
        ed_age = view.findViewById(R.id.ed_age);
        ed_name = view.findViewById(R.id.ed_name);

        rg_a = view.findViewById(R.id.radioGroup1);
        spinner1 = view.findViewById(R.id.spinner3);

        rg_a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_a.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.radio1:
                        num_sex = 1;
                        break;
                    case R.id.radio2:
                        num_sex = 2;
                        break;
                }
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                num_city = arg2;
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        if (Exam_Data.user_name != null) {
            ed_name.setText(Exam_Data.user_name);
        }
        if (Exam_Data.user_number != 0) {
            ed_number.setText(String.valueOf(Exam_Data.user_number));
        }
        if (Exam_Data.user_age != 0) {
            ed_age.setText(String.valueOf(Exam_Data.user_age));
        }
        if (Exam_Data.user_address != null) {
            ed_address.setText(Exam_Data.user_address);
        }
        if (Exam_Data.user_sex == 1) {
            rg_a.check(R.id.radio1);
        }else if (Exam_Data.user_sex == 2){
            rg_a.check(R.id.radio2);
        }
        if (Exam_Data.user_city != 0) {
            spinner1.setSelection(Exam_Data.user_city);
        }
        super.onStart();
    }

    @Override
    public void onDestroy() {
//        if (ed_name.getText().toString().length() != 0) {
//            Exam_Data.user_name = ed_name.getText().toString();
//        }
//        if (ed_age.getText().toString().length() != 0) {
//            Exam_Data.user_age = Integer.valueOf(ed_age.getText().toString());
//        }
//        if (ed_number.getText().toString().length() != 0) {
//            Exam_Data.user_number = Integer.valueOf(ed_number.getText().toString());
//        }
//        if (ed_address.getText().toString().length() != 0) {
//            Exam_Data.user_address = ed_address.getText().toString();
//        }
//        if (num_sex != 0) {Exam_Data.user_sex=num_sex;
//        }
//        if (num_city != 0) {Exam_Data.user_city=num_city;
//        }
        super.onDestroy();
    }


}
