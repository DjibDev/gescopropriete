package fr.coprotilleuls.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Appartement {
	
	private int num;
	private String num_syndic;
	private int porte;
	private int etage;
	private Batiment batiment;
		
	public Appartement() {}

	public Appartement(int num, String num_syndic, int porte, int etage,
			Batiment batiment) {
		super();
		this.num = num;
		this.num_syndic = num_syndic;
		this.porte = porte;
		this.etage = etage;
		this.batiment = batiment;
	}

	public Appartement(String num_syndic, int porte, int etage,
			Batiment batiment) {
		super();
		this.num_syndic = num_syndic;
		this.porte = porte;
		this.etage = etage;
		this.batiment = batiment;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNum_syndic() {
		return num_syndic;
	}

	public void setNum_syndic(String num_syndic) {
		this.num_syndic = num_syndic;
	}

	public int getPorte() {
		return porte;
	}

	public void setPorte(int porte) {
		this.porte = porte;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}
	
	
	
	
	
	
}
