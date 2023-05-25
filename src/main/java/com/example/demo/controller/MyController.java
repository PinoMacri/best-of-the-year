package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Canzone;
import com.example.demo.Film;

@Controller
public class MyController {
	@GetMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("name", "Pino");
		return "index";
	}

	private List<Film> fetchBestFilms() {
		List<Film> movies = new ArrayList<>();
		movies.add(new Film(1, "Titanic"));
		movies.add(new Film(2, "The Lion King"));
		movies.add(new Film(3, "Tarzan"));
		return movies;
	}

	private List<Canzone> fetchBestCanzoni() {
		List<Canzone> songs = new ArrayList<>();
		songs.add(new Canzone(1, "Rose Rosse"));
		songs.add(new Canzone(2, "Uno su mille ce la fa"));
		songs.add(new Canzone(3, "Sarò con te"));
		return songs;
	}

	@GetMapping("/films")
	public String getBestFilms(Model model) {
		List<Film> films = fetchBestFilms();
		model.addAttribute("films", films);
		return "films";
	}

	@GetMapping("/canzoni")
	public String getBestCanzoni(Model model) {
		List<Canzone> canzoni = fetchBestCanzoni();
		model.addAttribute("canzoni", canzoni);
		return "canzoni";
	}
	

	 @GetMapping("/films/{id}")
	    public String getFilm(Model model, @PathVariable("id") int id) {
	        Film film = getFilmById(id);
	        model.addAttribute("film", film);
	        return "film";
	    }

	    private Film getFilmById(int id) {
	        Film singoloFilm = null;
	        for (Film film : fetchBestFilms()) 
	        	if (film.getId() == id) singoloFilm = film;
	        	return singoloFilm;
	        }
	    
	    
	    @GetMapping("/canzoni/{id}")
	    public String getCanzone(Model model, @PathVariable("id") int id) {
	        Canzone canzone = getCanzoneById(id);
	        model.addAttribute("canzone", canzone);
	        return "canzone";
	    }

	    private Canzone getCanzoneById(int id) {
	        Canzone singolaCanzone = null;
	        for (Canzone canzone : fetchBestCanzoni()) 
	        	if (canzone.getId() == id) singolaCanzone = canzone;
	        	return singolaCanzone;
	        }
	}
