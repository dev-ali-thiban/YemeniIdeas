package com.dev_thiban.yemeniideas.Exam;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.dev_thiban.yemeniideas.R;


public class Exam_2 extends Fragment {

    public Exam_2() { }

    public static EditText ed_o, ed_p, ed_q;
    RadioGroup rg_a, rg_b, rg_c, rg_d, rg_e, rg_f, rg_g, rg_h, rg_i, rg_j, rg_k, rg_l, rg_m, rg_n;

    public static int ex_num_a ,ex_num_b, ex_num_c, ex_num_d, ex_num_e, ex_num_f, ex_num_g, ex_num_h, ex_num_i, ex_num_j,
            ex_num_k, ex_num_l, ex_num_m, ex_num_n;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.exam_view_2, container, false);
        setRetainInstance(true);

//        Exam_1 mFirstFragment = new Exam_1();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.add(R.id.fragment_place, mFirstFragment);
//        fragmentTransaction.commit();

        ed_o = view.findViewById(R.id.ed_o);
        ed_o.setVisibility(View.GONE);

        ed_p = view.findViewById(R.id.ed_p);

        ed_q = view.findViewById(R.id.ed_q);
        ed_q.setVisibility(View.GONE);

        rg_a = view.findViewById(R.id.rg_a);
        rg_a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_a.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_a_1:
                        ex_num_a = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+2;
                        break;
                    case R.id.rb_a_2:
                        ex_num_a = 2;
                        break;
                }
            }
        });
        rg_b = view.findViewById(R.id.rg_b);
        rg_b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_b.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_b_1:
                        ex_num_b = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+2;
                        break;
                    case R.id.rb_b_2:
                        ex_num_b = 2;
                        break;
                }
            }
        });
        rg_c = view.findViewById(R.id.rg_c);
        rg_c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_c.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_c_1:
                        ex_num_c = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+1;
                        break;
                    case R.id.rb_c_2:
                        ex_num_c = 2;
                        break;
                }
            }
        });
        rg_d = view.findViewById(R.id.rg_d);
        rg_d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_d.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_d_1:
                        ex_num_d = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+2;
                        break;
                    case R.id.rb_d_2:
                        ex_num_d = 2;
                        break;
                }
            }
        });
        rg_e = view.findViewById(R.id.rg_e);
        rg_e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_e.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_e_1:
                        ex_num_e = 1;
                        break;
                    case R.id.rb_e_2:
                        ex_num_e = 2;
                        break;
                }
            }
        });
        rg_f = view.findViewById(R.id.rg_f);
        rg_f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_f.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_f_1:
                        ex_num_f = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+1;
                        break;
                    case R.id.rb_f_2:
                        ex_num_f = 2;
                        break;
                }
            }
        });
        rg_g = view.findViewById(R.id.rg_g);
        rg_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_g.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_g_1:
                        ex_num_g = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+1;
                        break;
                    case R.id.rb_g_2:
                        ex_num_g = 2;
                        break;
                }
            }
        });
        rg_h = view.findViewById(R.id.rg_h);
        rg_h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_h.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_h_1:
                        ex_num_h = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+1;
                        break;
                    case R.id.rb_h_2:
                        ex_num_h = 2;
                        break;
                }
            }
        });
        rg_i = view.findViewById(R.id.rg_i);
        rg_i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_i.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_i_1:
                        ex_num_i = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+4;
                        break;
                    case R.id.rb_i_2:
                        ex_num_i = 2;
                        break;
                }
            }
        });
        rg_j = view.findViewById(R.id.rg_j);
        rg_j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_j.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_j_1:
                        ex_num_j = 1;
                        ed_q.setVisibility(View.VISIBLE);
                        Exam_Data.ex_point = Exam_Data.ex_point+3;
                        break;
                    case R.id.rb_j_2:
                        ex_num_j = 2;
                        ed_q.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rg_k = view.findViewById(R.id.rg_k);
        rg_k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_k.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_k_1:
                        ex_num_k = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+4;
                        break;
                    case R.id.rb_k_2:
                        ex_num_k = 2;
                        break;
                }
            }
        });
        rg_l = view.findViewById(R.id.rg_l);
        rg_l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_l.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_l_1:
                        ex_num_l = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+4;
                        break;
                    case R.id.rb_l_2:
                        ex_num_l = 2;
                        break;
                }
            }
        });
        rg_m = view.findViewById(R.id.rg_m);
        rg_m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_m.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_m_1:
                        ex_num_m = 1;
                        ed_o.setVisibility(View.VISIBLE);
                        Exam_Data.ex_point = Exam_Data.ex_point+3;
                        break;
                    case R.id.rb_m_2:
                        ex_num_m = 2;
                        ed_o.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rg_n = view.findViewById(R.id.rg_n);
        rg_n.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = rg_n.getCheckedRadioButtonId();
                switch (position) {
                    case R.id.rb_n_1:
                        ex_num_n = 1;
                        Exam_Data.ex_point = Exam_Data.ex_point+1;
                        break;
                    case R.id.rb_n_2:
                        ex_num_n = 2;
                        break;
                }
            }
        });

        return view;
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
//    @Override
//    public void onDestroy() {
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
//        super.onDestroy();
//    }
}
