package com.dev_thiban.yemeniideas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended_Main;
import com.dev_thiban.yemeniideas.About.About;
import com.dev_thiban.yemeniideas.Exam.Exam_Activity_2;
import com.dev_thiban.yemeniideas.Guidance.Guid_List;
import com.dev_thiban.yemeniideas.Message.Bag_Message;
import com.dev_thiban.yemeniideas.Reports.Report_Activity;
import com.dev_thiban.yemeniideas.Slids.Slid_Main;

public class MainActivity extends AppCompatActivity {

    boolean BackToExit = false;

    int optionSelected = 13;
    public static int num_slid;
    Handler handler = new Handler();
    Runnable runnable_;

    private Slid_Main mFirstFragment;
    FragmentTransaction fragmentTransaction;

    RelativeLayout img_main_go_exam, img_main_go_message, img_main_go_guid, img_main_go_report;
    ImageView img_main_about ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_main_about = findViewById(R.id.img_main_about);
        img_main_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
                overridePendingTransition(R.anim.move_top, R.anim.move_null);
            }
        });

        img_main_go_report = findViewById(R.id.img_main_go_report);
        img_main_go_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Report_Activity.class));
            }
        });

        img_main_go_guid = findViewById(R.id.img_main_go_guid);
        img_main_go_guid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Guid_List.class));
            }
        });

        img_main_go_message = findViewById(R.id.img_main_go_message);
        img_main_go_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Bag_Message.class)
                        .putExtra("number_message", 1)
                        .putExtra("user_data",""));
            }
        });

        img_main_go_exam = findViewById(R.id.img_main_go_exam);
        img_main_go_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Exam_Activity_2.class));
            }
        });

        mFirstFragment = new Slid_Main();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home_slid, mFirstFragment);
        fragmentTransaction.commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selecte_slid_main();
            }
        }, 1000);

//        SlidingRelativeLayout slid_hom = view.findViewById(R.id.fragment_home_slid);
//        slid_hom.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(getActivity(), "L", Toast.LENGTH_SHORT).show();
//                handler.removeCallbacks(runnable_);
//                if (num_slid==0){
//                    selecte_slid_main();
//                }else {
//                    num_slid--;
//                    getFragmentManager().popBackStack();
//                    handler.postDelayed(runnable_ = new Runnable() {
//                        @Override
//                        public void run() {
//                            selecte_slid_main();
//                        }
//                    }, 3000);
//
//                }
//            }
//
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(getActivity(), "R", Toast.LENGTH_SHORT).show();
//                handler.removeCallbacks(runnable_);
//                selecte_slid_main();
//            }
//            @Override
//            public void onSwipeUp() {
//                Toast.makeText(getActivity(), "U", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeDown() {
//                Toast.makeText(getActivity(), "D", Toast.LENGTH_SHORT).show();
//            }
//
//        });

    }


    public void selecte_slid_main() {
//        if (getFragmentManager().getBackStackEntryCount() == 0 ){num_slid++;
//            go_slid_main();
//        }else if (getFragmentManager().getBackStackEntryCount() == 1 ){num_slid++;
//            go_slid_main();
//        }else if (getFragmentManager().getBackStackEntryCount() == 2 ){num_slid++;
//            go_slid_main();
//        }else if (getFragmentManager().getBackStackEntryCount() == 3 ){num_slid++;
//            go_slid_main();
//        }else if (getFragmentManager().getBackStackEntryCount() == 4 ){num_slid++;
//            go_slid_main();
//        }else {num_slid=1;
//            go_slid_main();
////            handler.removeCallbacks(runnable_);
////            getFragmentManager().popBackStack(null,1);
//        }

        if (num_slid == 4) {
            num_slid = 0;
        }
        handler.postDelayed(runnable_ = new Runnable() {
            @Override
            public void run() {
                selecte_slid_main();
            }
        }, 3000);
        go_slid_main();
    }

    public void go_slid_main() {
        num_slid++;
        Fragment secondFragment = new Slid_Main();
        FragmentManager fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        FragmentTransactionExtended_Main fragmentTransactionExtended = new FragmentTransactionExtended_Main
                (this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_home_slid);
        fragmentTransactionExtended.addTransition(optionSelected);
        fragmentTransactionExtended.commit();
    }

    @Override
    protected void onRestart() {
        selecte_slid_main();
        super.onRestart();
    }

//    @Override
//    public void onStart() {
////        selecte_slid_main();
//        super.onStart();
//    }

    @Override
    public void onPause() {
        handler.removeCallbacks(runnable_);
        super.onPause();
    }

    @Override
    public void onStop() {
        handler.removeCallbacks(runnable_);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable_);
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        if (BackToExit) {
            finish();
            super.onBackPressed();
            return;
        }
        BackToExit = true;
        Toast.makeText(this, "اضغط مفتاح العودة مرة اخرئ للخروج", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackToExit = false;
            }
        }, 2000);
    }

}
