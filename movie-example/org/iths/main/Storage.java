package org.iths.main;
import java.util.List;

import org.iths.domain.Movie;
import org.iths.domain.Actor;

public interface Storage{
  public List<Movie>getMoviesByActorName(String actorName);
  public List<Actor>getActorsByMovieTitle(String title);
  public List<Movie>getAllMovies();
  public List<Actor>getAllActors();
}
