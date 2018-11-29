package restapi.retrofit.com.retrofitforrest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DOLPHIN on 11/29/2018.
 */

public class PhotoList {
    @SerializedName("data")
    private List<Photo> musics;
}
