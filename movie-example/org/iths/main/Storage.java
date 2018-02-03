package org.iths.main;

import java.util.List;

import org.iths.domain.Actor;
import org.iths.domain.Movie;

public interface Storage {
  
  public List<Movie>getMoviesByActorName(String actorName);

  public List<Actor>getActorsByMovieTitle(String title);

  public List<Movie>getAllMovies();

  public List<Actor>getAllActors();

}
