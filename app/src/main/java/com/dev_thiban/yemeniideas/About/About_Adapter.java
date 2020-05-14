package com.dev_thiban.yemeniideas.About;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

import java.util.List;

public class About_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<About_Model> posts;
    private Context context;

    public About_Adapter(List<About_Model> posts, Context ctx) {
        this.posts = posts;
        this.context = ctx;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0: {
                View v1 = inflater.inflate(R.layout.about_model, parent, false);
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

        final About_Model post = posts.get(holder.getAdapterPosition());

        switch (holder.getItemViewType()) {
            case 0: {

                PostHolder postHolder = (PostHolder) holder;

                postHolder.txt_name.setText(post.getName());
                postHolder.img.setImageResource(post.getImg());

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


    public class PostHolder extends RecyclerView.ViewHolder {
        private LinearLayout lin_go_user;
        private TextView txt_name;
        private ImageView img;


        public PostHolder(final View itemView) {
            super(itemView);
            lin_go_user = itemView.findViewById(R.id.lin_go_user);
            txt_name = itemView.findViewById(R.id.txt_name);
            img = itemView.findViewById(R.id.img);

            lin_go_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final About_Model post = posts.get(getAdapterPosition());

                    final Dialog dialogd_u = new Dialog(context);
                    dialogd_u.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogd_u.setContentView(R.layout.about_show_user);
                    dialogd_u.setCancelable(true);

                    ImageView user_img = dialogd_u.findViewById(R.id.user_img);
                    TextView txt_user_name = dialogd_u.findViewById(R.id.txt_user_name);
                    TextView txt_user_grop = dialogd_u.findViewById(R.id.txt_user_grop);
                    TextView txt_user_about = dialogd_u.findViewById(R.id.txt_user_about);

                    user_img.setImageResource(post.getImg());
                    txt_user_name.setText(post.getName());
                    txt_user_grop.setText("القسم : " + post.getGrop() + "\n");
                    txt_user_about.setText("نبذة : "+post.getAbout());

                    dialogd_u.show();

                }
            });


        }
    }
}