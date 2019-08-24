package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String userName = "student";
	private final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String userName = "student";
		String password = "password";
		try {
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setActorId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
				actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		int actorId = 0;
		Actor actor = null;
		String user = "student";
		String password = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name"
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " 
					+ " WHERE actor_id = ?";
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				actor = new Actor();
				actor.setActorId(actorResult.getInt("actor.id"));
				actor.setFirstName(actorResult.getString("actor.first_name"));
				actor.setLastName(actorResult.getString("actor.last_name"));
				actor.setFilms(findFilmsByActorId(actorId));
				actors.add(actor);
			}
			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pass = "student";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year," + "language_id, rental_duration, rental_rate,"
					+ "length, replacement_cost, rating, special_features" + " FROM film WHERE id = ?";
			java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int fId = rs.getInt("id"); // film id
				String title = rs.getString("title"); // title
				String description = rs.getString("description"); // description
				int releaseYear = rs.getInt("release_year"); // release year
				int languageId = rs.getInt("language_id"); // language id
				int rentalDuration = rs.getInt("rental_duration"); // rental duration
				double rate = rs.getDouble("rate"); // rental_rate
				int length = rs.getInt("length"); // length
				double replaceCost = rs.getDouble("replacement_cost"); // replacement_cost
				String rating = rs.getString("rating"); // rating
				String specialFeatures = rs.getString("special_features"); // special features
				List<Actor> actors = findActorsByFilmId(fId);
				film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rate, length, replaceCost, rating,
								specialFeatures, actors);
			}
			rs.close();
			stmt.close();
			conn.close();
		
//			Connection conn = DriverManager.getConnection(URL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

}
