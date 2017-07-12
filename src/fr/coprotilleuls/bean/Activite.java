package fr.coprotilleuls.bean;

public class Activite {
	private int id;
	private String libelle;
    private boolean actif;
    
	public Activite() {
		super();
	}

		
	public Activite(String libelle, boolean actif) {
		super();
		this.libelle = libelle;
		this.actif = actif;
	}


	public Activite(int id, String libelle, boolean actif) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.actif = actif;
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


	public boolean isActif() {
		return actif;
	}


	public void setActif(boolean actif) {
		this.actif = actif;
	}
    
	
    
}
