package com.dev_thiban.yemeniideas.Exam;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev_thiban.yemeniideas.R;


public class Exam_3 extends Fragment {

    public Exam_3() { }

    TextView txt_ex_end;
    ImageView img_ex_end ;
    Button btn_ex_end ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.exam_view_3, container, false);
        setRetainInstance(true);

        txt_ex_end = view.findViewById(R.id.txt_ex_end);

        img_ex_end = view.findViewById(R.id.img_ex_end);

        btn_ex_end = view.findViewById(R.id.btn_ex_end);
        btn_ex_end.setVisibility(View.GONE);
        btn_ex_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), ".....", Toast.LENGTH_SHORT).show();
            }
        });

        if (Exam_Data.ex_point < 5 ){
            txt_ex_end.setText("التزم بالبيت (عزل ذاتي)");

        }else if (Exam_Data.ex_point < 7 ){
            txt_ex_end.setText("استشير الطبيب هاتفيا");

        }else if (Exam_Data.ex_point < 1000){
            txt_ex_end.setText("تواصل مع الجهات المعنية");

        }
        return view;
    }


}
