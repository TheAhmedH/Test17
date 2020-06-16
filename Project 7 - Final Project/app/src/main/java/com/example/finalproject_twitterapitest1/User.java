package com.example.finalproject_twitterapitest1;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
 /*   @SerializedName("entities")
    @Expose
    private Entities_ entities;*/
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("friends_count")
    @Expose
    private Integer friendsCount;
    @SerializedName("listed_count")
    @Expose
    private Integer listedCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favourites_count")
    @Expose
    private Integer favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    private Object utcOffset;
    @SerializedName("time_zone")
    @Expose
    private Object timeZone;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("statuses_count")
    @Expose
    private Integer statusesCount;
    @SerializedName("lang")
    @Expose
    private Object lang;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("is_translation_enabled")
    @Expose
    private Boolean isTranslationEnabled;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("profile_banner_url")
    @Expose
    private String profileBannerUrl;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("has_extended_profile")
    @Expose
    private Boolean hasExtendedProfile;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("following")
    @Expose
    private Object following;
    @SerializedName("follow_request_sent")
    @Expose
    private Object followRequestSent;
    @SerializedName("notifications")
    @Expose
    private Object notifications;
    @SerializedName("translator_type")
    @Expose
    private String translatorType;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5420124344513791767L;

    protected User(Parcel in) {
        this.id = ((Long) in.readValue((Integer.class.getClassLoader())));
        this.idStr = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.screenName = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        /*this.entities = ((Entities_) in.readValue((Entities_.class.getClassLoader())));*/
        this._protected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.followersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.friendsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.listedCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.favouritesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.utcOffset = ((Object) in.readValue((Object.class.getClassLoader())));
        this.timeZone = ((Object) in.readValue((Object.class.getClassLoader())));
        this.geoEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.verified = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.statusesCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lang = ((Object) in.readValue((Object.class.getClassLoader())));
        this.contributorsEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isTranslator = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isTranslationEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileBackgroundColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBackgroundTile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.profileImageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileImageUrlHttps = ((String) in.readValue((String.class.getClassLoader())));
        this.profileBannerUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.profileLinkColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileSidebarBorderColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileSidebarFillColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileTextColor = ((String) in.readValue((String.class.getClassLoader())));
        this.profileUseBackgroundImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hasExtendedProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.defaultProfile = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.defaultProfileImage = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.following = ((Object) in.readValue((Object.class.getClassLoader())));
        this.followRequestSent = ((Object) in.readValue((Object.class.getClassLoader())));
        this.notifications = ((Object) in.readValue((Object.class.getClassLoader())));
        this.translatorType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

 /*   public Entities getEntities() {
        return entities;
    }
*/
/*    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }*/

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Integer getListedCount() {
        return listedCount;
    }

    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Object getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Object utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Object getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Object getLang() {
        return lang;
    }

    public void setLang(Object lang) {
        this.lang = lang;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public Boolean getIsTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
        this.isTranslationEnabled = isTranslationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public void setHasExtendedProfile(Boolean hasExtendedProfile) {
        this.hasExtendedProfile = hasExtendedProfile;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Object getFollowing() {
        return following;
    }

    public void setFollowing(Object following) {
        this.following = following;
    }

    public Object getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Object followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Object getNotifications() {
        return notifications;
    }

    public void setNotifications(Object notifications) {
        this.notifications = notifications;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(idStr);
        dest.writeValue(name);
        dest.writeValue(screenName);
        dest.writeValue(location);
        dest.writeValue(description);
        dest.writeValue(url);
/*        dest.writeValue(entities);*/
        dest.writeValue(_protected);
        dest.writeValue(followersCount);
        dest.writeValue(friendsCount);
        dest.writeValue(listedCount);
        dest.writeValue(createdAt);
        dest.writeValue(favouritesCount);
        dest.writeValue(utcOffset);
        dest.writeValue(timeZone);
        dest.writeValue(geoEnabled);
        dest.writeValue(verified);
        dest.writeValue(statusesCount);
        dest.writeValue(lang);
        dest.writeValue(contributorsEnabled);
        dest.writeValue(isTranslator);
        dest.writeValue(isTranslationEnabled);
        dest.writeValue(profileBackgroundColor);
        dest.writeValue(profileBackgroundImageUrl);
        dest.writeValue(profileBackgroundImageUrlHttps);
        dest.writeValue(profileBackgroundTile);
        dest.writeValue(profileImageUrl);
        dest.writeValue(profileImageUrlHttps);
        dest.writeValue(profileBannerUrl);
        dest.writeValue(profileLinkColor);
        dest.writeValue(profileSidebarBorderColor);
        dest.writeValue(profileSidebarFillColor);
        dest.writeValue(profileTextColor);
        dest.writeValue(profileUseBackgroundImage);
        dest.writeValue(hasExtendedProfile);
        dest.writeValue(defaultProfile);
        dest.writeValue(defaultProfileImage);
        dest.writeValue(following);
        dest.writeValue(followRequestSent);
        dest.writeValue(notifications);
        dest.writeValue(translatorType);
    }}
