package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Film;
import java.util.List;
import com.skilldistillery.filmquery.entities.*;

public interface DatabaseAccessor {

	public Film findFilmById(int filmId);
	public Actor findActorById(int actorId);
	public List<Actor> findActorsByFilmId(int filmId);
}
