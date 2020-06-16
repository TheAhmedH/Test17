package com.example.finalproject_twitterapitest1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.TweetsViewHolder> {

    private static final String TAG = "TweetsAdapter";
    private Context mContext;
    private List<Tweets> mTweetsList;
    private TweetsViewHolder.ListItemClickListener mListItemClickListener;


    public TweetsAdapter(Context mContext, List<Tweets> mTweetsList, TweetsViewHolder.ListItemClickListener mListItemClickListener) {
        this.mContext = mContext;
        this.mTweetsList = mTweetsList;
        this.mListItemClickListener = mListItemClickListener;
    }

    public TweetsAdapter(Context mContext, List<Tweets> mTweetsList) {
        this.mContext = mContext;
        this.mTweetsList = mTweetsList;
    }

    @NonNull
    @Override
    public TweetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweets_list_item, parent, false);
        TweetsViewHolder holder = new TweetsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TweetsViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: isCalled");
        Tweets currentTweet = mTweetsList.get(position);
        String tweetText = currentTweet.getText();
        String tweetDate = currentTweet.getUser().getCreatedAt();
        String tweetUserID = currentTweet.getUser().getIdStr();
        String tweetPlace = currentTweet.getUser().getLocation();

        holder.Tweets_Place.setText(tweetPlace);
        holder.Tweets_Tweet.setText(tweetText);
        holder.Tweets_Date.setText(tweetDate);
        holder.Tweets_Name.setText(tweetUserID);
    }

    @Override
    public int getItemCount() {
        return mTweetsList.size();
    }

    public static class TweetsViewHolder extends ViewHolder implements View.OnClickListener {
        TextView Tweets_Name;
        TextView Tweets_Date;
        TextView Tweets_Tweet;
        TextView Tweets_Place;
        FrameLayout Tweets_List_Layout;
        ListItemClickListener listItemClickListener;

        public TweetsViewHolder(@NonNull View itemView) {
            super(itemView);
            Tweets_Name   =  itemView.findViewById(R.id.User_Name_ID_Textview);
            Tweets_Date   =  itemView.findViewById(R.id.User_Date_Textview);
            Tweets_Tweet  =  itemView.findViewById(R.id.User_Tweet_Textview);
            Tweets_Place  =  itemView.findViewById(R.id.User_Place_Textview);
            Tweets_List_Layout = itemView.findViewById(R.id.Tweets_List_Layout);
        }

        @Override
        public void onClick(View v) {
            listItemClickListener.onTweetClickListener(getAdapterPosition());
        }

        public interface ListItemClickListener{
            void onTweetClickListener(int itemClicked);
        }
    }
}
