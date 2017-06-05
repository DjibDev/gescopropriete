package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UserTemp {
	
	private int id;
	private String champs1;
	private String champs2;
	private boolean used;
	
	public UserTemp() {}


	public UserTemp(String champs1, String champs2, boolean used) {
		super();
		this.champs1 = champs1;
		this.champs2 = champs2;
		this.used = used;
	}




	public UserTemp(int id, String champs1, String champs2, boolean used) {
		super();
		this.id = id;
		this.champs1 = champs1;
		this.champs2 = champs2;
		this.used = used;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getChamps1() {
		return champs1;
	}



	public void setChamps1(String champs1) {
		this.champs1 = champs1;
	}



	public String getChamps2() {
		return champs2;
	}



	public void setChamps2(String champs2) {
		this.champs2 = champs2;
	}



	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
			
	
}
