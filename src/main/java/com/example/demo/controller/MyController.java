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
		movies.add(new Film("1", "Titanic"));
		movies.add(new Film("2", "The Lion King"));
		movies.add(new Film("3", "Tarzan"));
		return movies;
	}

	private List<Canzone> fetchBestCanzoni() {
		List<Canzone> songs = new ArrayList<>();
		songs.add(new Canzone("1", "Rose Rosse"));
		songs.add(new Canzone("2", "Uno su mille ce la fa"));
		songs.add(new Canzone("3", "Sarò con te"));
		return songs;
	}

	@GetMapping("/films")
	public String getBestFilms(Model model) {
		List<Film> films = fetchBestFilms();
		List<String> filmTitles = new ArrayList<>();
		for (Film film : films) {
			filmTitles.add(film.getTitolo());
		}
		String filmTitleString = String.join(", ", filmTitles);
		model.addAttribute("titoli", filmTitleString);
		return "films";
	}

	@GetMapping("/canzoni")
	public String getBestCanzoni(Model model) {
		List<Canzone> canzoni = fetchBestCanzoni();
		List<String> canzoneTitles = new ArrayList<>();
		for (Canzone canzone : canzoni) {
			canzoneTitles.add(canzone.getTitolo());
		}
		String canzoneTitlesString = String.join(", ", canzoneTitles);

		model.addAttribute("titoli", canzoneTitlesString);
		return "canzoni";
	}

	 @GetMapping("/films/{id}")
	    public String titoloSingoloFilm(Model model, @PathVariable("id") int id) {
	        String titolo = fetchFilmTitleById(id);
	        model.addAttribute("titolo", titolo);
	        return "films";
	    }

	    private String fetchFilmTitleById(int id) {
	        List<Film> films = fetchBestFilms();
	        for (Film film : films) {
	            if (film.getId().equals(String.valueOf(id))) {
	                return film.getTitolo();
	            }
	        }
	        return "Film non trovato";
	    }
	    
	    @GetMapping("/canzoni/{id}")
	    public String titoloSingolaCanzone(Model model, @PathVariable("id") int id) {
	        String titolo = fetchCanzoneTitleById(id);
	        model.addAttribute("titolo", titolo);
	        return "canzoni";
	    }
	    private String fetchCanzoneTitleById(int id) {
	        List<Canzone> canzoni = fetchBestCanzoni();
	        for (Canzone canzone : canzoni ) {
	            if (canzone.getId().equals(String.valueOf(id))) {
	                return canzone.getTitolo();
	            }
	        }
	        return "Canzone non trovata";
	    }
	}
