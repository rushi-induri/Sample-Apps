package com.example.indurirushyendra.movie_app;

/**
 * Created by indurirushyendra on 13/03/16.
 */
public class MovieDataProvider  {

    private int movie_poster_resource;
    private String movie_tite;
    private String movie_rating;


    public MovieDataProvider(int movie_poster_resource,String movie_tite,String movie_rating){
        this.setMovie_poster_resource(movie_poster_resource);
        this.setMovie_tite(movie_tite);
        this.setMovie_rating(movie_rating);

    }

    public String getMovie_rating(){
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating){
        this.movie_rating = movie_rating;
    }


    public String getMovie_tite(){
        return movie_tite;
    }

    public void setMovie_tite(String movie_tite){
        this.movie_tite = movie_tite;
    }

    public int getMovie_poster_resource(){
        return movie_poster_resource;
    }

    public void setMovie_poster_resource(int movie_poster_resource){
        this.movie_poster_resource=movie_poster_resource;
    }
}
