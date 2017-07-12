package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Agenda {
	
	private int id;
	private String libelle;
    private int annee;
    private boolean actif;
    private Activite activite;
        
	public Agenda() {
		super();
	}

	public Agenda(String libelle, int annee, boolean actif, Activite activite) {
		super();
		this.libelle = libelle;
		this.annee = annee;
		this.actif = actif;
		this.activite = activite;
	}

	public Agenda(int id, String libelle, int annee,  boolean actif, Activite activite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.annee = annee;
		this.actif = actif;
		this.activite = activite;
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

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
    
	
}
