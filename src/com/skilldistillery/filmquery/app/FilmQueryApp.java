package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//    app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Film Query. Make your selection below.");
		boolean display = true;
		int choice = 0;
		int filmId = 0;
		String key = "";
		while (display = true) {
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
				display = false;
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid. Pick again.");
			}
		}
		startUserInterface(kb);

		kb.close();
	}

	private void searchFilmByKey(String key) {
		// TODO Auto-generated method stub

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
		System.out.println("\nFilm ID: "+film.getId());
		
	}

	private void startUserInterface(Scanner kb) {}

}
