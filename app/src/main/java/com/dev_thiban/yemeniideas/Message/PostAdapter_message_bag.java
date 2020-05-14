package com.dev_thiban.yemeniideas.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

import java.util.List;


public class PostAdapter_message_bag extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model_Message> posts;
    private Context context;

    public PostAdapter_message_bag(List<Model_Message> posts, Context ctx) {
        this.posts = posts;
        this.context = ctx;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0: {
                View v1 = inflater.inflate(R.layout.item_message_bag, parent, false);
                viewHolder = new PostHolder(v1);
                break;
            }
//            case 2: {
//                View v2 = inflater.inflate(R.layout.ads_row, parent, false);
//                viewHolder = new PostsAdapter_News.AdsHolder(v2);
//                break;
//            }
//            case 3: {
//                View v3 = inflater.inflate(R.layout.ads_row2, parent, false);
//                viewHolder = new PostsAdapter_News.AdsBag(v3);
//                break;
//            }
        }
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {

        final Model_Message post = posts.get(holder.getAdapterPosition());

        switch (holder.getItemViewType()) {
            case 0: {

                PostHolder postHolder = (PostHolder) holder;

                // حساب التاريخ
//                postHolder.txt_date.setText(Text_Set.Date_Now(post.getDate()));

                // ازاحة النص بحسب المرسل او المستقبل
                if (post.getId_user_get() != 1 ){
                    postHolder.linr_a.setVisibility(View.GONE);
                    postHolder.linr_b.setVisibility(View.VISIBLE);
                    postHolder.postLayout.setBackgroundResource(R.drawable.message_a);
                }else {
                    postHolder.linr_a.setVisibility(View.VISIBLE);
                    postHolder.linr_b.setVisibility(View.GONE);
                    postHolder.postLayout.setBackgroundResource(R.drawable.message_b);
                }

                if (post.getType() == 1 ){
                    // نص
                    postHolder.txt_message.setText(post.getMessage());

                }else if (post.getType() == 2 ){
                    // صورة


                }else if (post.getType() == 3 ){
                    // ملصق

                }else {
                    // اي شيء اخر


                }

//                // الاضافة الى قاعدة البيانات
//                if (postHolder.db.add_new_raw_message
//                        (DatabaseHelper.TABLE_MESSAGE_USER,post.getId(),post.getIs_admin(),post.getId_user_get()
//                                ,post.getId_user_post(),post.getPost_name(),post.getPost_img()
//                                ,post.getGet_name(),post.getGet_img(),post.getDate()
//                                ,post.getNumber_message(),post.getMessage(),post.getType())){
////                    Toast.makeText(context, "تم اضافة الرسالة بنجاح", Toast.LENGTH_SHORT).show();
//                }else {
////                    Toast.makeText(context, "فشلت المزامنة", Toast.LENGTH_SHORT).show();
//                }

            }
            break;

//            case 2: {
//                //ADS
//            }
//            break;
//            case 3: {
//                //ADS
//            }
//            break;
        }
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return posts.get(position).getViewType();
    }

//    public class AdsHolder extends RecyclerView.ViewHolder {
////        private NativeExpressAdView asdView;
//
//        public AdsHolder(View itemView) {
//            super(itemView);
////            asdView = (NativeExpressAdView) itemView.findViewById(R.id.adView);
////
////            AdRequest request = new AdRequest.Builder()
////                    .build();
////            asdView.loadAd(request);
//
//        }
//    }
//
//    public class AdsBag extends RecyclerView.ViewHolder{
////        private NativeExpressAdView adsView2;
//
//        public AdsBag(View itemView){
//            super(itemView);
////            adsView2 = (NativeExpressAdView) itemView.findViewById(R.id.adView2);
////
////            AdRequest request = new AdRequest.Builder()
////                    .build();
////            adsView2.loadAd(request);
////
//        }
//    }

    public class PostHolder extends RecyclerView.ViewHolder {
        private LinearLayout postLayout , linr_a , linr_b ;
        private TextView txt_date , txt_message ;
//        private GifImageView gif_iew ;

//        private DatabaseHelper db;

        public PostHolder(final View itemView) {
            super(itemView);
            postLayout = (LinearLayout) itemView.findViewById(R.id.line1);
            linr_a = (LinearLayout) itemView.findViewById(R.id.linr_a);
            linr_b = (LinearLayout) itemView.findViewById(R.id.linr_b);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_message = (TextView) itemView.findViewById(R.id.txt_message);
//            gif_iew = (GifImageView) itemView.findViewById(R.id.gif_v);
//            db = new DatabaseHelper(context);

            postLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // تكملة معرفة كيف نفعل بمكتبة الصور المتحركة
//                    try {
//                        GifDrawable gifFromResource = new GifDrawable( context.getResources(), R.drawable.img_gif );
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    gif_iew.setImageDrawable(gifFromResource);
                    //                    Model_Message post = posts.get(getAdapterPosition());
//                    Intent i = new Intent(context, Bag_Message.class);
//                    i.putExtra("id", post.getId());
//                    context.startActivity(i);
                }
            });

        }
    }
}