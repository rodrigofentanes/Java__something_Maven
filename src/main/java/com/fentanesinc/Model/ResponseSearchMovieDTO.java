package com.fentanesinc.Model;

import java.util.ArrayList;
import com.google.gson.Gson;

public class ResponseSearchMovieDTO {
  public int page;
  public ArrayList<Result> results;
  public int total_pages;
  public int total_results;

  public class Result{
    public boolean adult;
    public String backdrop_path;
    public ArrayList<Integer> genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;
  }

  public ResponseSearchMovieDTO parse(String json) {
    ResponseSearchMovieDTO data = new Gson().fromJson(json, ResponseSearchMovieDTO.class);
    return (ResponseSearchMovieDTO) data;
  }
}
