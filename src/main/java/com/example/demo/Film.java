package com.example.demo;

public class Film {
	private int id;
	private String titolo;

	public Film(int id, String titolo) {
		setId(id);
		setTitolo(titolo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
