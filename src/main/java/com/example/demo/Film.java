package com.example.demo;

public class Film {
	private String id;
	private String titolo;

	public Film(String id, String titolo) {
		setId(id);
		setTitolo(titolo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
