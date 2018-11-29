package restapi.retrofit.com.retrofitforrest.retrofitConfig;

import java.util.List;

import restapi.retrofit.com.retrofitforrest.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DOLPHIN on 11/28/2018.
 */

public interface DataService {

    @GET("/photos")
    Call<List<Photo>> getAllPhotos();
}
