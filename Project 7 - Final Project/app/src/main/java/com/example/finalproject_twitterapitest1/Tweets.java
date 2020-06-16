package com.example.finalproject_twitterapitest1;


import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

    public class Tweets implements Serializable {

        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("id_str")
        @Expose
        private String idStr;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("truncated")
        @Expose
        private Boolean truncated;
   /*     @SerializedName("entities")
        @Expose
        private Entities entities;
        @SerializedName("metadata")
        @Expose
        private Metadata metadata;
        @SerializedName("source")*/
        @Expose
        private String source;
        @SerializedName("in_reply_to_status_id")
        @Expose
        private Long inReplyToStatusId;
        @SerializedName("in_reply_to_status_id_str")
        @Expose
        private String inReplyToStatusIdStr;
        @SerializedName("in_reply_to_user_id")
        @Expose
        private Long inReplyToUserId;
        @SerializedName("in_reply_to_user_id_str")
        @Expose
        private String inReplyToUserIdStr;
        @SerializedName("in_reply_to_screen_name")
        @Expose
        private String inReplyToScreenName;
        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("geo")
        @Expose
        private Object geo;
        @SerializedName("coordinates")
        @Expose
        private Object coordinates;
        @SerializedName("place")
       /* @Expose
        private Place place;
        @SerializedName("contributors")*/
        @Expose
        private Object contributors;
        @SerializedName("is_quote_status")
        @Expose
        private Boolean isQuoteStatus;
        @SerializedName("retweet_count")
        @Expose
        private Integer retweetCount;
        @SerializedName("favorite_count")
        @Expose
        private Integer favoriteCount;
        @SerializedName("favorited")
        @Expose
        private Boolean favorited;
        @SerializedName("retweeted")
        @Expose
        private Boolean retweeted;
        @SerializedName("lang")
        @Expose
        private String lang;
        /*public final static Parcelable.Creator<Status> CREATOR = new Creator<Status>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Status createFromParcel(Parcel in) {
                return new Status(in);
            }

            public Status[] newArray(int size) {
                return (new Status[size]);
            }

        }*/
                ;
        private final static long serialVersionUID = 5781972890327250688L;

      /*  protected Status(Parcel in) {
            this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.idStr = ((String) in.readValue((String.class.getClassLoader())));
            this.text = ((String) in.readValue((String.class.getClassLoader())));
            this.truncated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.entities = ((Entities) in.readValue((Entities.class.getClassLoader())));
            this.metadata = ((Metadata) in.readValue((Metadata.class.getClassLoader())));
            this.source = ((String) in.readValue((String.class.getClassLoader())));
            this.inReplyToStatusId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.inReplyToStatusIdStr = ((String) in.readValue((String.class.getClassLoader())));
            this.inReplyToUserId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.inReplyToUserIdStr = ((String) in.readValue((String.class.getClassLoader())));
            this.inReplyToScreenName = ((String) in.readValue((String.class.getClassLoader())));
            this.user = ((User) in.readValue((User.class.getClassLoader())));
            this.geo = ((Object) in.readValue((Object.class.getClassLoader())));
            this.coordinates = ((Object) in.readValue((Object.class.getClassLoader())));
            this.place = ((Place) in.readValue((Place.class.getClassLoader())));
            this.contributors = ((Object) in.readValue((Object.class.getClassLoader())));
            this.isQuoteStatus = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.retweetCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.favoriteCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.favorited = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.retweeted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.lang = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Status() {
        }*/

        protected Tweets(Parcel in) {
            createdAt = in.readString();
            if (in.readByte() == 0) {
                id = null;
            } else {
                id = in.readLong();
            }
            idStr = in.readString();
            text = in.readString();
            byte tmpTruncated = in.readByte();
            truncated = tmpTruncated == 0 ? null : tmpTruncated == 1;
            source = in.readString();
            if (in.readByte() == 0) {
                inReplyToStatusId = null;
            } else {
                inReplyToStatusId = in.readLong();
            }
            inReplyToStatusIdStr = in.readString();
            if (in.readByte() == 0) {
                inReplyToUserId = null;
            } else {
                inReplyToUserId = in.readLong();
            }
            inReplyToUserIdStr = in.readString();
            inReplyToScreenName = in.readString();
            user = in.readParcelable(User.class.getClassLoader());
            byte tmpIsQuoteStatus = in.readByte();
            isQuoteStatus = tmpIsQuoteStatus == 0 ? null : tmpIsQuoteStatus == 1;
            if (in.readByte() == 0) {
                retweetCount = null;
            } else {
                retweetCount = in.readInt();
            }
            if (in.readByte() == 0) {
                favoriteCount = null;
            } else {
                favoriteCount = in.readInt();
            }
            byte tmpFavorited = in.readByte();
            favorited = tmpFavorited == 0 ? null : tmpFavorited == 1;
            byte tmpRetweeted = in.readByte();
            retweeted = tmpRetweeted == 0 ? null : tmpRetweeted == 1;
            lang = in.readString();
        }

       /* public static final Creator<Tweets> CREATOR = new Creator<Tweets>() {
            @Override
            public Tweets createFromParcel(Parcel in) {
                return new Tweets(in);
            }

            @Override
            public Tweets[] newArray(int size) {
                return new Tweets[size];
            }
        }*/;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getIdStr() {
            return idStr;
        }

        public void setIdStr(String idStr) {
            this.idStr = idStr;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Boolean getTruncated() {
            return truncated;
        }

        public void setTruncated(Boolean truncated) {
            this.truncated = truncated;
        }

        /*public Entities getEntities() {
            return entities;
        }

        public void setEntities(Entities entities) {
            this.entities = entities;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }*/

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Long getInReplyToStatusId() {
            return inReplyToStatusId;
        }

        public void setInReplyToStatusId(Long inReplyToStatusId) {
            this.inReplyToStatusId = inReplyToStatusId;
        }

        public String getInReplyToStatusIdStr() {
            return inReplyToStatusIdStr;
        }

        public void setInReplyToStatusIdStr(String inReplyToStatusIdStr) {
            this.inReplyToStatusIdStr = inReplyToStatusIdStr;
        }

        public Long getInReplyToUserId() {
            return inReplyToUserId;
        }

        public void setInReplyToUserId(Long inReplyToUserId) {
            this.inReplyToUserId = inReplyToUserId;
        }

        public String getInReplyToUserIdStr() {
            return inReplyToUserIdStr;
        }

        public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
            this.inReplyToUserIdStr = inReplyToUserIdStr;
        }

        public String getInReplyToScreenName() {
            return inReplyToScreenName;
        }

        public void setInReplyToScreenName(String inReplyToScreenName) {
            this.inReplyToScreenName = inReplyToScreenName;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public Object getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Object coordinates) {
            this.coordinates = coordinates;
        }

     /*   public Place getPlace() {
            return place;
        }

        public void setPlace(Place place) {
            this.place = place;
        }*/

        public Object getContributors() {
            return contributors;
        }

        public void setContributors(Object contributors) {
            this.contributors = contributors;
        }

        public Boolean getIsQuoteStatus() {
            return isQuoteStatus;
        }

        public void setIsQuoteStatus(Boolean isQuoteStatus) {
            this.isQuoteStatus = isQuoteStatus;
        }

        public Integer getRetweetCount() {
            return retweetCount;
        }

        public void setRetweetCount(Integer retweetCount) {
            this.retweetCount = retweetCount;
        }

        public Integer getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(Integer favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public Boolean getFavorited() {
            return favorited;
        }

        public void setFavorited(Boolean favorited) {
            this.favorited = favorited;
        }

        public Boolean getRetweeted() {
            return retweeted;
        }

        public void setRetweeted(Boolean retweeted) {
            this.retweeted = retweeted;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }


//Constructor for Tweets/Status
        public Tweets(String idStr, String text, User user) {
            this.idStr = idStr;
            this.text = text;
            this.user = user;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(createdAt);
            dest.writeValue(id);
            dest.writeValue(idStr);
            dest.writeValue(text);
            dest.writeValue(truncated);
         /*   dest.writeValue(entities);
            dest.writeValue(metadata);*/
            dest.writeValue(source);
            dest.writeValue(inReplyToStatusId);
            dest.writeValue(inReplyToStatusIdStr);
            dest.writeValue(inReplyToUserId);
            dest.writeValue(inReplyToUserIdStr);
            dest.writeValue(inReplyToScreenName);
            dest.writeValue(user);
            dest.writeValue(geo);
            dest.writeValue(coordinates);
      /*      dest.writeValue(place);*/
            dest.writeValue(contributors);
            dest.writeValue(isQuoteStatus);
            dest.writeValue(retweetCount);
            dest.writeValue(favoriteCount);
            dest.writeValue(favorited);
            dest.writeValue(retweeted);
            dest.writeValue(lang);
        }

        public int describeContents() {
            return 0;
        }}

