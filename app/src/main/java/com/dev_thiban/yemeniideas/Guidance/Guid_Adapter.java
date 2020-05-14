package com.dev_thiban.yemeniideas.Guidance;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dev_thiban.yemeniideas.R;

import java.util.List;

public class Guid_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Guid_Model> posts;
    private Context context;

    public Guid_Adapter(List<Guid_Model> posts, Context ctx) {
        this.posts = posts;
        this.context = ctx;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0: {
                View v1 = inflater.inflate(R.layout.guid_model, parent, false);
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

        final Guid_Model post = posts.get(holder.getAdapterPosition());

        switch (holder.getItemViewType()) {
            case 0: {

                PostHolder postHolder = (PostHolder) holder;

                postHolder.txt_title.setText(post.getTitle());
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
        private CardView card_adapter;
        private TextView txt_title;
        private ImageView img;


        public PostHolder(final View itemView) {
            super(itemView);
            card_adapter = itemView.findViewById(R.id.card_adapter);
            txt_title = itemView.findViewById(R.id.txt_title);
            img = itemView.findViewById(R.id.img);

            card_adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Guid_Model post = posts.get(getAdapterPosition());

                    context.startActivity(new Intent(context, Guid_Activity.class)
                            .putExtra("id", post.getId())
                            .putExtra("title", post.getTitle())
                            .putExtra("body", post.getBody())
                            .putExtra("type", post.getBody())
                            .putExtra("img", post.getImg())
                            .putExtra("link", post.getLink()));
                }
            });


        }
    }
}