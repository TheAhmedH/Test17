package com.example.finalproject_twitterapitest1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private EditText mSearchEditText;
    private Button mSearchButton;
    private Button mGetLocationButton;
    private String mSavedEditTextValue;
    private List<Tweets> tweetsList;
    private String mRadius = "1000km";
    Location mlocation;
    private double mLatitude;
    private double mLongitude;
    private static String authTokenString;
    GoogleMap mMap;
    private Call<TweetsResults> tweetCall;
    private MapsActivity mMapsActivity;
    private Call<AuthResponse> authTokenCall;
    private TweetsInterface tweetsInterface;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final String TAG = "MainActivity";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Shared Preferences for the Token
        mSharedPreferences = getSharedPreferences("com.example.finalproject_twitterapitest1", Context.MODE_PRIVATE);


        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        //Location Button
        mGetLocationButton = findViewById(R.id.Tweet_Get_Location_Button);
        mGetLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getUserLocation();
/*                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);*/

                    SupportMapFragment mapFragment = SupportMapFragment.newInstance();
                    FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.map, mapFragment);
                    fragmentTransaction.commit();

                    mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MainActivity.this);
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

        mSharedPreferencesEditor = mSharedPreferences.edit();
        mSearchEditText = (EditText) findViewById(R.id.Tweet_Search_Edit_Text);
        mSearchButton = (Button) findViewById(R.id.Tweet_Search_Button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSavedEditTextValue = mSearchEditText.getText().toString();
                tweetsInterface = TweetsClient.getClient().create(TweetsInterface.class);
                authTokenCall = tweetsInterface.getAuthToken("client_credentials");
                CheckForNetworkConnection();


            }
        });
    }

    public void CheckForNetworkConnection() {
        if (!isNetworkAvailable(this)) {
            Toast toast = Toast.makeText(this, "Network is not Available", Toast.LENGTH_LONG);
            toast.show();
        } else {
            CheckForSharedPreferencesToken();
        }
    }

    private void CallForTokenAndGetTweets() {
        authTokenCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> authResponse) {
                if (authResponse.isSuccessful()) {
                    authTokenString = authResponse.body().getAccessToken();
                    mSharedPreferencesEditor.putString("Token Key", authTokenString);
                    tweetCall = tweetsInterface.getTweetResults("Bearer " + authTokenString, mSavedEditTextValue, "37.781157,-122.398720,1000km", "recent");
                    GetTweets();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: failed");
            }
        });
    }

    private void GetTweets() {
        if (authTokenString != null) {
            CallForTweets();
        }
    }

    //Check for Shared Preferences Token
    private void CheckForSharedPreferencesToken() {
        String TokenFromSP = mSharedPreferences.getString("Token Key", "");
        if (TokenFromSP.isEmpty()) {
            CallForTokenAndGetTweets();
        } else {
            CallForTweets();
        }
    }


    private void CallForTweets() {
        tweetCall = tweetsInterface.getTweetResults("Bearer " + authTokenString, mSavedEditTextValue, mLatitude + "," + mLongitude + "," + mRadius, "recent");

        tweetCall.enqueue(new Callback<TweetsResults>() {
            @Override
            public void onResponse(Call<TweetsResults> call, Response<TweetsResults> response) {
                if (response.isSuccessful()) {
                    tweetsList = response.body().getStatuses();
                    Intent intent = new Intent(MainActivity.this, Tweets_Detail_Results.class);

                    /*     intent.putParcelableArrayListExtra("tweets_list", (ArrayList<? extends Parcelable>) tweetsList);*/
                    intent.putExtra("tweets_list_serial", (Serializable) tweetsList);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<TweetsResults> call, Throwable t) {
                Log.d(TAG, "onFailure: Failed");
            }
        });
    }

    //Refence: https://stackoverflow.com/questions/57277759/getactivenetworkinfo-is-deprecated-in-api-29
    //Method to check for network
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) return false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        return true;
                    }
                }
            } else {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        Log.i("update_status", "Network is available : true");
                        return true;
                    }
                } catch (Exception e) {
                    Log.i("update_statut", "" + e.getMessage());
                }
            }
        }
        Log.i("update_statut", "Network is available : FALSE ");
        return false;
    }

    public void getUserLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        List<Address> userAddress = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        mLatitude = userAddress.get(0).getLatitude();
                        mLongitude = userAddress.get(0).getLongitude();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
       mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

