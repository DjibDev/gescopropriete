package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Batiment {
	
	private String code;
	private String adresse;
	
	public Batiment() {}

	public Batiment(String code, String adresse) {
		super();
		this.code = code;
		this.adresse = adresse;
	}

	public Batiment(String adresse) {
		super();
		this.adresse = adresse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
