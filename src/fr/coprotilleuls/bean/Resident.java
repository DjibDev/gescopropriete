package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Resident {
	
	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String login;
	private String mot_de_passe;
	private Date date_inscription;
	private String type_res;
	private boolean actif;
	private Role role;
	private Appartement appartement;
	
	public Resident() {}
		
	public Resident(int id, String nom, String prenom, String tel,
			String email, String login, String mot_de_passe,
			Date date_inscription, String type_res, boolean actif, Role role,
			Appartement appartement) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.mot_de_passe = mot_de_passe;
		this.date_inscription = date_inscription;
		this.type_res = type_res;
		this.actif = actif;
		this.role = role;
		this.appartement = appartement;
	}

	public Resident(String nom, String prenom, String tel, String email,
			String login, String mot_de_passe, Date date_inscription,
			String type_res, boolean actif, Role role, Appartement appartement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.login = login;
		this.mot_de_passe = mot_de_passe;
		this.date_inscription = date_inscription;
		this.type_res = type_res;
		this.actif = actif;
		this.role = role;
		this.appartement = appartement;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getDate_inscription() {
		String pattern = "dd/MM/yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("fr", "FR"));
		return format.format(date_inscription);
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}
	public String getType_res() {
		return type_res;
	}
	public void setType_res(String type_res) {
		this.type_res = type_res;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	public Appartement getAppartement() {
		return appartement;
	}


	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}

	
}
