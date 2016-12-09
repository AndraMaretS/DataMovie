package id.sch.smktelkommalang.learn.datamovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowMoviesDetails extends AppCompatActivity {

    private TextView textViewMovieId;
    private TextView textViewMovieName;
    private TextView textViewMoviePrice;
    private TextView textViewMovieInStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies_details);

        textViewMovieId = (TextView) findViewById(R.id.textViewMovieId);
        textViewMovieName = (TextView) findViewById(R.id.textViewMovieName);
        textViewMoviePrice = (TextView) findViewById(R.id.textViewMoviePrice);
        textViewMovieInStock = (TextView) findViewById(R.id.textViewMovieStock);

        Intent intent = getIntent();

        textViewMovieId.setText(String.valueOf(intent.getIntExtra(MainActivity.KEY_MOVIE_ID, 0)));
        textViewMovieName.setText(intent.getStringExtra(MainActivity.KEY_MOVIE_NAME));
        textViewMoviePrice.setText(intent.getStringExtra(MainActivity.KEY_MOVIE_PRICE));
        textViewMovieInStock.setText(String.valueOf(intent.getIntExtra(MainActivity.KEY_MOVIE_STOCK, 0)));
    }
}
