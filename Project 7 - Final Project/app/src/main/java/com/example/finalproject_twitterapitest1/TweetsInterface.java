package com.example.finalproject_twitterapitest1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

//https://api.twitter.com/1.1/search/tweets.json?q=from%3Atwitterdev&result_type=mixed&count=2
//https://api.twitter.com/1.1/search/tweets.json?q=%covid&geocode=37.781157,-122.398720,1km&result_type=recent
interface TweetsInterface {

    @GET("1.1/search/tweets.json")
    /*@Headers("Authorization: Bearer AAAAAAAAAAAAAAAAAAAAAIuxEgEAAAAAgBN3wXZQeMt%2F0HeV9xzgQ4lTLG4%3DgAd9vximWk7PzTZerSv2ScS9z8JX8BBkKTtnazcDfMrkiDQx27")*/
    Call<TweetsResults> getTweetResults(@Header("Authorization") String token,
                                        @Query("q") String Search_Key,
                                        @Query("geocode") String geocode,
                                        @Query("result_type") String result_type);

    @FormUrlEncoded
    @POST("oauth2/token")
    @Headers({
            "Authorization: Basic bWFUbnlucFpRdkFrMFBJMTFxYkp0VWtiMzpWVkFuYnlzY0FzWkJaU0p2Y3lIY3NHOWZBa0FwekppbndUVzZaWXJpMTY1SUx1SDNwVg==",
            "Content-Type: application/x-www-form-urlencoded;charset=UTF-8"
    })
    Call<AuthResponse> getAuthToken(@Field("grant_type") String grantType);

}
