package com.example.finalproject_twitterapitest1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://api.twitter.com/1.1/search/tweets.json?q=from%3Atwitterdev&result_type=mixed&count=2
//https://api.twitter.com/1.1/search/tweets.json?q=%covid&geocode=37.781157,-122.398720,1km&result_type=recent

class TweetsClient {

    private static final String BASE_URL = "https://api.twitter.com/";
    public static int PAGE = 1;
    private static final String MIDDLE_URL1 = "tweets.json?q=from%";
    private static final String MIDDLE_URL2 = "&geocode=37.781157,-122.398720,1km&";
    private static final String MIDDLE_URL3 = "&geocode=";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
