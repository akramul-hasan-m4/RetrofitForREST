package restapi.retrofit.com.retrofitforrest;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import restapi.retrofit.com.retrofitforrest.model.Photo;
import restapi.retrofit.com.retrofitforrest.retrofitConfig.DataService;
import restapi.retrofit.com.retrofitforrest.retrofitConfig.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllPhotos();

    }

    private void getAllPhotos(){
        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);

        Call<List<Photo>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
              //  int statusCode = response.code();
              //  List<Photo> photos = response.body();
               // init(photos);
                System.out.println(response.body());
                //Log.d("ttt","111111111111"+statusCode);
              //  Log.d("tag",photos.toString());

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d("error",t.getMessage());
                Toast.makeText(MainActivity.this, "Error = "+t.getMessage(), Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

   private void init(List<Photo> photos) {
        TableLayout table = (TableLayout) findViewById(R.id.table_main);
        TableRow headerRow = new TableRow(this);
        Field[] photo = Photo.class.getDeclaredFields();
        String albumId = photo[0].getName();
        String id = photo[1].getName();
        String title = photo[2].getName();
        String url = photo[3].getName();
        String thumbnailUrl = photo[4].getName();

        TextView header1 = new TextView(this);
        header1.setText(albumId);
        header1.setTextColor(Color.WHITE);
        header1.setTypeface(header1.getTypeface(), Typeface.BOLD);


        headerRow.addView(header1);

        TextView header2 = new TextView(this);
        header2.setText(id);
        header2.setTextColor(Color.WHITE);
        header2.setTypeface(header2.getTypeface(), Typeface.BOLD);

        headerRow.addView(header2);

        TextView header3 = new TextView(this);
        header3.setText(title);
        header3.setTextColor(Color.WHITE);
        header3.setTypeface(header3.getTypeface(), Typeface.BOLD);

        headerRow.addView(header3);

        TextView header4 = new TextView(this);
        header4.setText(url);
        header4.setTextColor(Color.WHITE);
        header4.setTypeface(header4.getTypeface(), Typeface.BOLD);

        headerRow.addView(header4);

        table.addView(headerRow);

        for (Photo p : photos) {
            Log.d("fff", p.getTitle());
            String alId = p.getAlbumId().toString();
            String iid = p.getId().toString();
            String title1 = p.getTitle();
            String url1 = p.getUrl();

            TableRow row = new TableRow(this);

            TextView firstColumnData = new TextView(this);
            firstColumnData.setText(alId);
            firstColumnData.setTextColor(Color.WHITE);
            firstColumnData.setGravity(Gravity.CENTER);
            row.addView(firstColumnData);

           TextView secondColumnData = new TextView(this);
            secondColumnData.setText(iid);
            secondColumnData.setTextColor(Color.WHITE);
            secondColumnData.setGravity(Gravity.CENTER);
            row.addView(secondColumnData);

            TextView thirdColumnData = new TextView(this);
            thirdColumnData.setText(title1);
            thirdColumnData.setTextColor(Color.WHITE);
            thirdColumnData.setGravity(Gravity.CENTER);
            row.addView(thirdColumnData);

            TextView fourColumnData = new TextView(this);
            fourColumnData.setText(url1);
            fourColumnData.setTextColor(Color.WHITE);
            fourColumnData.setGravity(Gravity.CENTER);
            row.addView(fourColumnData);

            table.addView(row);
        }

    }


}
