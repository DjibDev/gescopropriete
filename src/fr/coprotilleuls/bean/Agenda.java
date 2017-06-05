package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Agenda {
	
	private int id;
	private String libelle;
    private int annee;
    
	public Agenda() {
		super();
	}

	public Agenda(String libelle, int annee) {
		super();
		this.libelle = libelle;
		this.annee = annee;
	}

	public Agenda(int id, String libelle, int annee) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.annee = annee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
    
	
}
