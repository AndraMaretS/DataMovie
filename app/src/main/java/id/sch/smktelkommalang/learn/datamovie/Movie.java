package id.sch.smktelkommalang.learn.datamovie;

/**
 * Created by Andra Maret on 09/12/2016.
 */
public class Movie {

    private int movieId;
    private String name;
    private String price;
    private int inStock;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
