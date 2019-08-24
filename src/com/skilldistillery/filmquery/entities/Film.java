package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private int releaseYr; 
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replaceCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	
	public Film() {}
	
	public Film(int filmId, String title, String description, int releaseYr, int languageId, int rentalDuration,
			double rentalRate, int length, double replaceCost, String rating, String specialFeatures,
			List<Actor> actors) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYr = releaseYr;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	public int getFilmId() {
		return filmId;
	}
	
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	
	public int getLanguageId() {
		return languageId;
	}
	
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReleaseYr() {
		return releaseYr;
	}
	public void setReleaseYr(int releaseYr) {
		this.releaseYr = releaseYr;
	}
	public int getLangId() {
		return languageId;
	}
	public void setLangId(int languageId) {
		this.languageId = languageId;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplaceCost() {
		return replaceCost;
	}
	public void setReplaceCost(double replaceCost) {
		this.replaceCost = replaceCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + filmId;
		result = prime * result + languageId;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYr;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replaceCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmId != other.filmId)
			return false;
		if (languageId != other.languageId)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYr != other.releaseYr)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replaceCost) != Double.doubleToLongBits(other.replaceCost))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
