package com.example.finalproject_twitterapitest1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

class TweetsResults implements Serializable,Parcelable {
    @SerializedName("statuses")
    @Expose
    private List<Tweets> statuses = null;
/*    @SerializedName("search_metadata")
    @Expose
    private SearchMetadata searchMetadata;*/
    public final static Parcelable.Creator<TweetsResults> CREATOR = new Parcelable.Creator<TweetsResults>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TweetsResults createFromParcel(Parcel in) {
            return new TweetsResults(in);
        }

        public TweetsResults[] newArray(int size) {
            return (new TweetsResults[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6910522845908522157L;

    protected TweetsResults(Parcel in) {
        in.readList(this.statuses, (Tweets.class.getClassLoader()));
      /*  this.searchMetadata = ((SearchMetadata) in.readValue((SearchMetadata.class.getClassLoader())));*/
    }

    public TweetsResults() {
    }

    public List<Tweets> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Tweets> statuses) {
        this.statuses = statuses;
    }
//Creating the constructor
    public TweetsResults(List<Tweets> statuses) {
        this.statuses = statuses;
    }
/*    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }*/

 /*   public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }*/

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(statuses);
/*        dest.writeValue(searchMetadata);*/}

    public int describeContents() {
        return 0; }
}
