package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Evenement {
	
	private int id;
	private Date date_event;
	private Date date_creation;
	private String sujet;
	private String details;
	private Boolean archive;
	private Agenda agenda;
	private Resident createur;
	
	
	public Evenement() {
		super();
	}

	public Evenement(Date date_event, Date date_creation, String sujet,
			String details, Boolean archive, Agenda agenda, Resident createur) {
		super();
		this.date_event = date_event;
		this.date_creation = date_creation;
		this.sujet = sujet;
		this.details = details;
		this.archive = archive;
		this.agenda = agenda;
		this.createur = createur;
	}
	
	public Evenement(int id, Date date_event, Date date_creation, String sujet,
			String details, Boolean archive, Agenda agenda, Resident createur) {
		super();
		this.id = id;
		this.date_event = date_event;
		this.date_creation = date_creation;
		this.sujet = sujet;
		this.details = details;
		this.archive = archive;
		this.agenda = agenda;
		this.createur = createur;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_event() {
		return date_event;
	}
	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public Resident getCreateur() {
		return createur;
	}
	public void setCreateur(Resident createur) {
		this.createur = createur;
	}
	
	
	
}