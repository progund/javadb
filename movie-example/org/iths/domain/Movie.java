package org.iths.domain;
public class Movie{
  private String title;
  
  private Movie(MovieBuilder mb){
    this.title = mb.title;
  }
  public static class MovieBuilder{
    private String title;
    public MovieBuilder(){      
    }
    public MovieBuilder title(String title){
      this.title = title;
      return this;
    }
    public Movie build(){
      return new Movie(this);
    }
  }
  @Override
  public String toString(){
    return title;
  }
}
