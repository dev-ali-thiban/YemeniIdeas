package com.dev_thiban.yemeniideas.Slids;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.dev_thiban.yemeniideas.Guidance.Guid_Activity;
import com.dev_thiban.yemeniideas.Guidance.Guid_Data;
import com.dev_thiban.yemeniideas.Guidance.Guid_Model;
import com.dev_thiban.yemeniideas.MainActivity;
import com.dev_thiban.yemeniideas.R;
import com.dev_thiban.yemeniideas.Reports.Report_Activity;

import java.util.List;


public class Slid_Main extends Fragment {

    public Slid_Main() {
    }

    public static Button btn_view;
    public static ImageView img_slid_main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.slid_main, container, false);

        btn_view = view.findViewById(R.id.btn_view);
        img_slid_main = view.findViewById(R.id.img_slid_main);

        if (MainActivity.num_slid == 0) {
            img_slid_main.setImageResource(R.drawable.guid_img_c);
            btn_view.setText("تعرف على المزيد");
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<Guid_Model> list_guid = Guid_Data.lists();
                    getActivity().startActivity(new Intent(getActivity(), Guid_Activity.class)
                            .putExtra("id", 2)
                            .putExtra("title", list_guid.get(2).getTitle())
                            .putExtra("body", list_guid.get(2).getBody())
                            .putExtra("type", list_guid.get(2).getType())
                            .putExtra("img", list_guid.get(2).getImg())
                            .putExtra("link",list_guid.get(2).getLink()));
                }
            });
        } else if (MainActivity.num_slid == 1) {
            btn_view.setText("تعرف على المزيد");
            img_slid_main.setImageResource(R.drawable.guid_img_a);
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Guid_Activity.class)
                            .putExtra("id", 0)
                            .putExtra("title", Guid_Data.lists().get(0).getTitle())
                            .putExtra("body", Guid_Data.lists().get(0).getBody())
                            .putExtra("type", Guid_Data.lists().get(0).getType())
                            .putExtra("img", Guid_Data.lists().get(0).getImg())
                            .putExtra("link",Guid_Data.lists().get(0).getLink()));
                }
            });

        } else if (MainActivity.num_slid == 2) {
            btn_view.setText("عرض الارقام");
            img_slid_main.setImageResource(R.drawable.img_slid_2);
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(), Report_Activity.class));
//                    final Dialog dialogd_u = new Dialog(getActivity());
//                    dialogd_u.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    dialogd_u.setContentView(R.layout.report_activity);
//                    dialogd_u.setCancelable(true);
//
//                    Spinner spinner;
//                    final TextView txt_main, txt_a, txt_b;
//                    Resources res;
//                    LinearLayout linr_coll_a, linr_coll_b;
//                    final CardView card_report_coll ;
//
//                    txt_main = dialogd_u.findViewById(R.id.txt_main);
//                    txt_a = dialogd_u.findViewById(R.id.txt_a);
//                    txt_b = dialogd_u.findViewById(R.id.txt_b);
//
//                    card_report_coll = dialogd_u.findViewById(R.id.card_report_coll);
//                    card_report_coll.setVisibility(View.GONE);
//
//                    linr_coll_a = dialogd_u.findViewById(R.id.linr_coll_a);
//                    linr_coll_a.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent i = new Intent(Intent.ACTION_DIAL);
//                            i.setData(Uri.parse("tel:" + txt_a.getText().toString()));
//                            getActivity().startActivity(i);
//                        }
//                    });
//                    linr_coll_b = dialogd_u.findViewById(R.id.linr_coll_b);
//                    linr_coll_b.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent i = new Intent(Intent.ACTION_DIAL);
//                            i.setData(Uri.parse("tel:" + txt_b.getText().toString()));
//                            getActivity().startActivity(i);
//                        }
//                    });
//
//                    res = getResources();
//                    final String[] number_phones_city_1 = res.getStringArray(R.array.number_phones_city_1);
//                    final String[] number_phones_city_2 = res.getStringArray(R.array.number_phones_city_2);
//
//                    spinner = dialogd_u.findViewById(R.id.spinner);
//                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                            if (arg2 != 0) {
//                                card_report_coll.setVisibility(View.VISIBLE);
//
//                                txt_a.setText(number_phones_city_1[arg2]);
//                                txt_b.setText(number_phones_city_2[arg2]);
//
//                                if (number_phones_city_1[arg2].length() == 0
//                                        || number_phones_city_2[arg2].compareTo("") == 0) {
//                                    txt_main.setText("لا يوجد رقم للمحافظة اتصل على 01255952 للاستعلام");
//                                    txt_a.setText(number_phones_city_1[0]);
//                                    txt_b.setText(number_phones_city_2[0]);
//                                } else if (number_phones_city_2[arg2].length() == 0
//                                        || number_phones_city_2[arg2].compareTo("") == 0) {
//                                    txt_main.setText("لا يوجد رقم للمحافظة اتصل على 01255952 للاستعلام");
//                                    txt_a.setText(number_phones_city_1[0]);
//                                    txt_b.setText(number_phones_city_2[0]);
//                                }
//                            }
//                        }
//
//                        public void onNothingSelected(AdapterView<?> arg0) {
//                        }
//                    });
//
//                    dialogd_u.show();

                }
            });
        } else if (MainActivity.num_slid == 3) {
            btn_view.setText("تعرف على المزيد");
            img_slid_main.setImageResource(R.drawable.guid_img_b);
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Guid_Activity.class)
                            .putExtra("id", 1)
                            .putExtra("title", Guid_Data.lists().get(1).getTitle())
                            .putExtra("body", Guid_Data.lists().get(1).getBody())
                            .putExtra("type", Guid_Data.lists().get(1).getType())
                            .putExtra("img", Guid_Data.lists().get(1).getImg())
                            .putExtra("link",Guid_Data.lists().get(1).getLink()));
                }
            });

        } else if (MainActivity.num_slid == 4) {

            img_slid_main.setImageResource(R.drawable.guid_img_c);
            btn_view.setText("تعرف على المزيد");
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Guid_Activity.class)
                            .putExtra("id", 2)
                            .putExtra("title", Guid_Data.lists().get(2).getTitle())
                            .putExtra("body", Guid_Data.lists().get(2).getBody())
                            .putExtra("type", Guid_Data.lists().get(2).getType())
                            .putExtra("img", Guid_Data.lists().get(2).getImg())
                            .putExtra("link",Guid_Data.lists().get(2).getLink()));

                }
            });

        } else {
            img_slid_main.setImageResource(R.drawable.guid_img_c);
            btn_view.setText("تعرف على المزيد");
            btn_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<Guid_Model> list_guid = Guid_Data.lists();
                    getActivity().startActivity(new Intent(getActivity(), Guid_Activity.class)
                            .putExtra("id", 2)
                            .putExtra("title", list_guid.get(2).getTitle())
                            .putExtra("body", list_guid.get(2).getBody())
                            .putExtra("type", list_guid.get(2).getType())
                            .putExtra("img", list_guid.get(2).getImg())
                            .putExtra("link",list_guid.get(2).getLink()));
                }
            });

//            btn_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//
//            img_slid_main.setImageResource(R.drawable.img_slid_2);
        }

        return view;
    }

}