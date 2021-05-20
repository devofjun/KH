package com.kh.listviewcustomadapterex;

public class MovieVo {
    private int imgResource;
    private String movieName;
    private String director;

    public MovieVo(int imgResource, String movieName, String director){
        this.imgResource = imgResource;
        this.movieName = movieName;
        this.director = director;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }
}
