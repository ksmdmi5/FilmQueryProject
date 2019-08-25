package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private static final String URL = "jdb:mysql://localhost:3306/sdvid?useSSL=false";
	DatabaseAccessor db = new DatabaseAccessorObject();
	boolean appClosed = false;
	
public FilmQueryApp() throws ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
}
	
	public static void main(String[] args) throws ClassNotFoundException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		List<Film> films = ((DatabaseAccessorObject) db).findFilmsByActorId(4);
//		System.out.println(film.getActors().size());
//		System.out.println("Film ID: " + 1);
//		System.out.println(film);
//		Actor actor = db.findActorById(10);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner kb = new Scanner(System.in);
		while (!appClosed) {
			try {
				startUserInterface(kb);
			} catch (Exception e) {
				System.out.println();
				invalidInput(kb);
				System.out.println();
				kb.nextLine();
			}
	
	}
		kb.close();
	}
	private void invalidInput(Scanner kb) {
	System.out.println("Invalid. Try again.");
	
}

	private void startUserInterface(Scanner kb) throws Exception {
		System.out.println("Welcome to Film Query. Make your selection below.");
		boolean display = true;
		int choice = 0;
		int filmId = 0;
		String key = "";
			System.out.println("1: Find a film by its ID\n" + "(This must be a whole number).\n"
					+ "2: Find a film by a searching for\n" + "title or description.\n" + "3: Exit program");
			choice = kb.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter films id: ");
				filmId = kb.nextInt();
				displayFilmTitle(filmId);
				break;
			case 2:
				System.out.print("Enter a keyword to search by: ");
				key = kb.next();
				key = key.toUpperCase();
				searchFilmByKey(key);
				break;
			case 3:
				System.out.println("Exiting");
				appClosed = true;
				break;
			default:
				invalidInput(kb);
				break;
			}
		}

	

	private void searchFilmByKey(String key) {
		List<Film> films = null;
		if ((films = ((DatabaseAccessorObject) db).findFilmsByKey(key)) != null) {
			for (Film film : films) {
				printFilm(film);
			}
			int numFilms = films.size();
			if (numFilms == 0) {
				System.out.println("Keyword not found.\n");
			} else {
				System.out.println("Total number: " + films.size() + "\n");
			}
		}

	}

	private void displayFilmTitle(int filmId) {
		Film film = null;
		if ((film = db.findFilmById(filmId)) != null) {
			printFilm(film);
		} else {
			System.out.println("Film not found.\n");
		}

	}

	private void printFilm(Film film) {
		System.out.println("Film ID: " + film.getFilmId());
		System.out.println("Film Title: " + film.getTitle());
		System.out.println("Relased In: " + film.getReleaseYr());
		System.out.println("Rating: " + film.getRating());
		System.out.println("Description: " + film.getDescription());
		boolean first = true;
		System.out.println("Cast: ");
		for (Actor actor : film.getActors()) {
			if (first) {
				System.out.print(actor.getFirstName() + " " + actor.getLastName());
				first = false;
			} else {
				System.out.print(", " + actor.getFirstName() + " " + actor.getLastName());
			}
		}
	}

	

}