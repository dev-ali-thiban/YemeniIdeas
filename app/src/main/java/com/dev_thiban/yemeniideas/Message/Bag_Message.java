package com.dev_thiban.yemeniideas.Message;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Bag_Message extends AppCompatActivity {

    RecyclerView recyclerview;
    PostAdapter_message_bag adapter;
    List<Model_Message> postList_bag_message = new ArrayList<>();

    ImageView img_send ;
    EditText edit_send ;

    int id , is_admin  , number_message  , id_get_user;
    String  user_img_other ,type;
    String user_name_other =" ";
    int user_id_other  ;
    String name , message , phone ,title;

    Runnable runnable_a  , runnable_b , runnable_txt;
    Handler handler = new Handler();
    int int_try , int_try_send;

    TextView txt_conn ;
    String user_data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bag_message);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        db = new DatabaseHelper(this);
//        Login_Singin.Get_share_save(this);

        setTitle("الدردشة المباشرة");
        recyclerview =  findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Bag_Message.this ,
                1 , true) ;
        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this, 1, true));


        img_send = (ImageView) findViewById(R.id.img_send);
        edit_send = (EditText) findViewById(R.id.edit_send);

        txt_conn = (TextView) findViewById(R.id.txt_conn);

//        runnable_a = new Runnable() {
//            @Override
//            public void run() {
//                conn_message();
//            }
//        };
        runnable_b = new Runnable() {
            @Override
            public void run() {
                send_message();
            }
        };

        Intent intent = getIntent();
        number_message = intent.getIntExtra("number_message" ,0) ;
        user_data = intent.getStringExtra("user_data");

//        if (number_message==1) {
//        }else if (number_message==10){
//            Intent intent_10 = getIntent();
//            id = intent_10.getIntExtra("id" ,0) ;
//            is_admin = intent_10.getIntExtra("is_admin" ,0) ;
//            id_get_user = intent_10.getIntExtra("id_get_user",0);
//            user_id_other = intent_10.getIntExtra("user_id_other" ,0) ;
//            user_name_other = intent_10.getStringExtra("user_name_other") ;
//            user_img_other = intent_10.getStringExtra("user_img_other") ;
//            number_message = intent_10.getIntExtra("number_message" ,0) ;
////            type = intent_10.getIntExtra("type" ,0) ;
//
//        }else {
//            title = intent.getStringExtra("title") ;
//            name = intent.getStringExtra("name") ;
//            phone = intent.getStringExtra("phone") ;
//            type = intent.getStringExtra("type") ;
//            message = intent.getStringExtra("message") ;
//            edit_send.setText( "الطلب : " + title + "\n" +
//                    "الاسم : " + name + "\n" +
//                    "الرقم : " + phone + "\n" +
//                    " الكمية : " + type + "\n" +
//                    "رسالة : " + message + "\n");
//        }
        img_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_send.getText().toString().length() <= 1){
                    Toast.makeText(Bag_Message.this, "اكمل كتابة الرسالة", Toast.LENGTH_SHORT).show();
                }else {
                    // تبع التاكد من بيانات المستخدم المرسل
//                    if (User_Save_Data.user_phone==0){
//                        final Dialog dialogd_admin = new Dialog(Bag_Message.this);
//                        dialogd_admin.setTitle("اكتب بياناتك لارسالها");
//                        dialogd_admin.setContentView(R.layout.messaage_log_in);
//                        dialogd_admin.setCancelable(true);
//                        final EditText ed_name = dialogd_admin.findViewById(R.id.ed_name);
//                        final EditText ed_phone = dialogd_admin.findViewById(R.id.ed_phone);
//                        Button b_ad = dialogd_admin.findViewById(R.id.b_ad);
//
//                        b_ad.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (ed_name.getText().toString().length() <= 2 ) {
//                                    Toast.makeText(Bag_Message.this, "اكتب اسم المستخدم", Toast.LENGTH_SHORT).show();
//                                    dialogd_admin.cancel();
//                                }else if (ed_phone.getText().toString().length()<= 8){
//                                    Toast.makeText(Bag_Message.this, "اكتب رقم هاتفك المكون من 9 ارقام", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    User_Save_Data.Set_Data_Share_Save(Bag_Message.this,
//                                            Integer.valueOf(ed_phone.getText().toString()),
//                                            ed_name.getText().toString());
////                                    send_message();
//                                    add_itme_message(1,"2020/2/22");
//                                    dialogd_admin.cancel();
//                                }
//                            }
//                        });
//                        dialogd_admin.show();
//                    }else {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmssSSS-dd-MM-yyyy", Locale.US);
                    String td = simpleDateFormat.format(date) ;

                    add_itme_message(1,td);
//                    }
                }
            }
        });

        example_conn_Message();

        if (user_data.compareTo("")==0 || user_data.length()==0){

        }else {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmssSSS-dd-MM-yyyy", Locale.US);
            String td = simpleDateFormat.format(date) ;
            edit_send.setText(user_data);
            add_itme_message(1,td);
        }

    }


    // مثال تجريبي
    public void example_conn_Message() {
        postList_bag_message = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmssSSS-dd-MM-yyyy", Locale.US);
        String td = simpleDateFormat.format(date) ;

        for (int i = 0; i < 1; i++) {
            final Model_Message model_message = new Model_Message();
            model_message.id = i;
            model_message.id_user_get = 2;
            model_message.id_user_post = 1;
            model_message.date = td;
            model_message.message = "مرحبا .. يمكنك مراسلتنا وطلب المشورة من هنا مباشرة ";
            model_message.type = 1;

            postList_bag_message.add(model_message);
            adapter = new PostAdapter_message_bag(postList_bag_message, Bag_Message.this);
            recyclerview.setAdapter(adapter);
        }

//        conn_message();
    }

    // الاتصال وجلب الرسائل
//    public void conn_message(){
//        txt_set_data(false,View.VISIBLE ,"#fff449" , "جاري الاتصال ...");
//
//        final Model_Message model_message = new Model_Message();
//        model_message.id_user_get = User_Save_Data.user_phone ;
//        model_message.id_user_post = Integer.valueOf(getString(R.string.app_phone)) ;
//
//        WebService.getInstance().getApi().message_user(model_message).enqueue(new Callback<List<Model_Message>>() {
//            @Override
//            public void onResponse(Call<List<Model_Message>> call, Response<List<Model_Message>> response) {
//                postList_bag_message = response.body();
//                if (postList_bag_message == null || postList_bag_message.size() <= 0 ){
//                    txt_set_data(false,View.VISIBLE ,"#fff449" , "لا توجد اي رسائل");
//                }else {
//                    adapter = new PostAdapter_message_bag(postList_bag_message, Bag_Message.this);
//                    recyclerview.setAdapter(adapter);
//                    txt_set_data(true,View.VISIBLE ,"#00ed00" , "تم الاتصال");
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Model_Message>> call, Throwable t) {
//                if (int_try == 5){
//                    txt_set_data(false,View.VISIBLE ,"#ff342a" , "فشل الاتصال بالشبكة ...!");
//                    int_try = 0 ;
//                }else {
//                    int_try ++ ;
//                    try_conn_Message();
//                }
//            }
//        });
//
//    }

//    // المحاولة مجددا
//    public void try_conn_Message(){
//        handler.removeCallbacks(runnable_a);
//        handler.postDelayed(runnable_a,1000);
//    }

    // ارسال الرسالة
    public void send_message(){
        img_send.setVisibility(View.INVISIBLE);

        final Model_Message model_message = new Model_Message();
        model_message.is_admin = 2 ;
        model_message.id_user_get = 2;
        model_message.id_user_post = 1 ;
        model_message.post_name = name  ;
        model_message.post_img = "face_a" ;
        model_message.get_name = user_name_other ;
        model_message.get_img = "face_b"  ;
        model_message.number_message = 1 ;
        model_message.message = edit_send.getText().toString() ;
        model_message.type = 1 ;

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmssSSS-dd-MM-yyyy", Locale.US);
        String td = simpleDateFormat.format(date) ;

        add_itme_message(1, td);
        img_send.setVisibility(View.VISIBLE);

//        WebService.getInstance().getApi().send_message(model_message).enqueue(new Callback<Model_Message>() {
//            @Override
//            public void onResponse(Call<Model_Message> call, Response<Model_Message> response) {
//                if (response.body().type==100){
//                    Toast.makeText(Bag_Message.this, response.body().message, Toast.LENGTH_SHORT).show();
//                }else {
////                 نجاح الاتصال والرجوع برقم الرسالة
//                    add_itme_message(response.body().id, response.body().date);
//                    img_send.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Model_Message> call, Throwable t) {
//                // فشل الاتصال
//                if (int_try_send == 5){
//                    img_send.setVisibility(View.VISIBLE);
//                    Toast.makeText(Bag_Message.this , "فشل الارسال ... تأكد من اتصالك بالشبكة", Toast.LENGTH_SHORT).show();
//                    int_try_send = 1 ;
//                }else {
//                    int_try_send ++ ;
//                    try_send_message();
//                }
//
//            }
//        });

    }

//    // اعادة ارسالة الرسالة
//    public void try_send_message(){
//        handler.removeCallbacks(runnable_b);
//        handler.postDelayed(runnable_b,1000);
//    }
//
//
//    // بيانات النص المعرف للاتصال
//    public void txt_set_data(Boolean b ,int visibility ,String color , String txt ){
//        txt_conn.setVisibility(visibility);
//        txt_conn.setText(txt);
//        txt_conn.setBackgroundColor(Color.parseColor(color));
//
//        if (b){
//            runnable_txt = new Runnable() {
//                @Override
//                public void run() {
//                    txt_conn.setVisibility(View.GONE);
//                }
//            };
//            handler.removeCallbacks(runnable_txt);
//            handler.postDelayed(runnable_txt,10000);
//        }
//
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable_a);
        handler.removeCallbacks(runnable_b);
        handler.removeCallbacks(runnable_txt);
    }

    // اضافة الرسالة الى الايتيمز
    public void add_itme_message(int id_message , String time_day) {
        Model_Message message = new Model_Message();
        message.id = id_message ;
        message.id_user_get = 1 ;
        message.id_user_post = 2 ;
        message.date = time_day ;
        message.message = edit_send.getText().toString();
        message.type = 1;
        postList_bag_message.add(0,message);
        adapter.notifyDataSetChanged();

        edit_send.setText("");
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Bag_Message.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}