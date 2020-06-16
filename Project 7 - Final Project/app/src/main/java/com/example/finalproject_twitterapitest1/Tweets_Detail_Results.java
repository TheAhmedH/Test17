package com.example.finalproject_twitterapitest1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class Tweets_Detail_Results extends AppCompatActivity {

    private Serializable mTweetsList;
    private TweetsAdapter mTweetsAdapter;
    private RecyclerView mTweetsRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets__detail__results);

        mTweetsRecyclerview = findViewById(R.id.Tweets_Display_RecyclerView);
        mTweetsRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        /*mTweetsList = getIntent().getParcelableExtra("tweets_list");*/
        mTweetsList = getIntent().getExtras().getSerializable("tweets_list_serial");
        mTweetsAdapter = new TweetsAdapter(Tweets_Detail_Results.this, (List<Tweets>) mTweetsList);

        mTweetsRecyclerview.setAdapter(mTweetsAdapter);



        TextView TweetText = findViewById(R.id.User_Tweet_Textview);
        TextView TweetName = findViewById(R.id.User_Name_ID_Textview);
        TextView TweetPlace = findViewById(R.id.User_Place_Textview);
        TextView TweetDate = findViewById(R.id.User_Date_Textview);




    }


}