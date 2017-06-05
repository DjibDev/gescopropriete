package fr.coprotilleuls.test;

import fr.coprotilleuls.utils.Outils;

public class AppTest {

	public static void main(String[] args) {
	
		String logGenere="";
		String mdpGenere="";
		
		Outils o = new Outils();
		
		for (int i = 0; i < 10 ; i++) {

			logGenere= o.GenererLogin();
			mdpGenere = o.GenererPassword();
			System.out.println(i+1);
			System.out.println("identifiant généré: " + logGenere);
			System.out.println("mot de passe généré: " + mdpGenere);
			System.out.println("----------------------------------------");
		}

	}

}
