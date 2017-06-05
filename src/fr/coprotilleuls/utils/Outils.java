package fr.coprotilleuls.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Outils {
	
	private static String[] lettres = {"abcdefghijklm"};
	

	// hachage du mot de passe en SHA-256
	public String Chiffrer(String password) {
		
		String result="";
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes()); 
			byte byteData[] = md.digest(); 
			StringBuffer sb = new StringBuffer(); 
			
			for (int i = 0; i < byteData.length; i++) { 
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); 
				} 
			
			result = sb.toString(); 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
		
	}
	
	// fonction qui genere un identifiant aleatoire de longueur 8= log + 5 chars aleatoires 
	// on retire volontairement les 'o' et 'O' pour ne pas confondre avec 0, ainsi que le "l" pour ne pas confondre avec 1
	public String GenererLogin() {
		
			String chars = "abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ1234567890"; 
			String result="log";
			
		    for(int x=0; x < 6 ;x++)
		    {
		       int i = (int)Math.floor(Math.random() * 59); 
		       result += chars.charAt(i);
		    }
		
		return result;
	}
	
	// fonction qui genere mot de passe aleatoire de longueur 8 = mdp + 5 chars aleatoires 
	// on retire volontairement les 'o' et 'O' pour ne pas confondre avec 0, ainsi que le "l" pour ne pas confondre avec 1
	public String GenererPassword() {
		

		String chars = "abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ1234567890"; 
		String result="mdp";
		
	    for(int x=0; x < 6 ;x++)
	    {
	       int i = (int)Math.floor(Math.random() * 59); 
	       result += chars.charAt(i);
	    }
	
	    return result;

	}
}
