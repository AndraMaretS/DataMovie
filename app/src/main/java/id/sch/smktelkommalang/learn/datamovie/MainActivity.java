package id.sch.smktelkommalang.learn.datamovie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    public static final String ROOT_URL = "http://www.delaroystudios.com/";

    public static final String KEY_MOVIE_ID = "key_movie_id";
    public static final String KEY_MOVIE_NAME = "key_movie_name";
    public static final String KEY_MOVIE_PRICE = "key_movie_price";
    public static final String KEY_MOVIE_STOCK = "key_movie_stock";

    private ListView listView;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewMovies);

        getMovies();

        listView.setOnItemClickListener(this);
    }

    private void getMovies() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        MoviesAPI api = adapter.create(MoviesAPI.class);

        api.getMovies(new Callback<List<Movie>>() {
            @Override
            public void success(List<Movie> list, Response response) {
                loading.dismiss();

                movies = list;

                showList();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void showList() {
        String[] items = new String[movies.size()];

        for (int i = 0; i < movies.size(); i++) {
            items[i] = movies.get(i).getName();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.simple_list, items);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, ShowMoviesDetails.class);

        Movie movie = movies.get(i);

        intent.putExtra(KEY_MOVIE_ID, movie.getMovieId());
        intent.putExtra(KEY_MOVIE_NAME, movie.getName());
        intent.putExtra(KEY_MOVIE_PRICE, movie.getPrice());
        intent.putExtra(KEY_MOVIE_STOCK, movie.getInStock());

        startActivity(intent);
    }
}
