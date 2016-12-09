package id.sch.smktelkommalang.learn.datamovie;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Andra Maret on 09/12/2016.
 */

public interface MoviesAPI {

    @GET("/retrofit/movies.json")
    void getMovies(Callback<List<Movie>> response);

}
