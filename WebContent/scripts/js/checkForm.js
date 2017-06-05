function encode(s) {
  return unescape(encodeURIComponent(s));
}

function decode(s) {
  return decodeURIComponent(escape(s));
}

// fonction qui s"assure que la formulaire d'inscription est correctement rempli
function validFormInscription(){
	var valide = true;
	var msgErreurs = new Array();
	var regexEmail=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;	
	var regexTel =/^[0-9]{10}$/;
	var regexLoginMdP = /^[a-zA-Z0-9_@&]{4,10}$/

	var i = 0;

	var divErreur = $('#erreurs');
	var nom = $('#nom').val().trim().length;
	var prenom = $('#nom').val().trim().length;
	var email = $('#email').val().trim();
	var tel =  $('#telephone').val().trim();
	var porte = $('#porte').val();
	var etage = $('#etage').val();
	var batiment = $('#batiment').val();
	var login = $('#identifiant').val().trim();
	var mdp = $('#password').val().trim();
	var Vmdp = $('#Vpassword').val().trim();
	
	
	if (nom == 0 ){
		valide = false;
		msgErreurs[i] ="* Veuillez saisir votre nom.";
		i++;
	}
	
	if (prenom == 0 ){
		valide = false;
		msgErreurs[i] ="* Veuillez saisir votre prénom.";
		i++;
	}
	
	if (email.length == 0){
		valide = false;
		msgErreurs[i] ="* Veuillez saisir votre email.";
		i++;
	}
	

	if (!email.match(regexEmail)){
		valide = false;
		msgErreurs[i] ="* Email au format invalide.";
		i++;
	}
	
	if (!tel.match(regexTel)){
		valide = false;
		msgErreurs[i] ="* Téléphone au format invalide.";
		i++;
	}
	
	if (" " == (porte)){
		valide = false;
		msgErreurs[i] ="* Veuillez sélectionner une porte.";
		i++;
	}
	
	if (" " == (etage)){
		valide = false;
		msgErreurs[i] ="* Veuillez sélectionner un étage.";
		i++;
	}
	
	if (" " == (batiment)){
		valide = false;
		msgErreurs[i] ="* Veuillez sélectionner un bâtiment.";
		i++;
	}
	
	if (!login.match(regexLoginMdP)){
		valide = false;
		msgErreurs[i] ="* L'identifiant ne respecte pas les règles.";
		i++;
	}
	
	if (!mdp.match(regexLoginMdP)){
		valide = false;
		msgErreurs[i] ="* Le mot de passe ne respecte pas les règles.";
		i++;
	}
	
	if (mdp != Vmdp ){
		valide = false;
		msgErreurs[i] ="* Le mot de passe de confirmation est différent du premier mot passe.";
		i++;
	}
		
	
	divErreur.text('');
	
	
	if (!valide) {
		for (var cpt = 0; cpt < msgErreurs.length; cpt++) {
			var msg = msgErreurs[cpt];
			divErreur.append(decode(msg)+"<br />");
		}
	}
	
	return valide;
}


// fonction qui s'assure de la bonne formulation du nouveau mot de passe
function validChangePassword(){
	var valide = true;
	var msgErreurs = new Array();
	var i = 0;

	if (document.formChangePassword.password.value.length < 6
			|| document.formChangePassword.password.value.length > 10) {
		valide = false;
		msgErreurs[i] = "Le mot de passe doit comporter 6 à 10 caractères maximum.";
		i++;
		document.formChangePassword.password.focus();
	}

	if (document.formChangePassword.password.value != document.formChangePassword.confirmPassword.value) {
		valide = false;
		msgErreurs[i] = "Le mot de passe saisi n'est pas identique au premier !";
		i++;
		document.formChangePassword.confirmPassword.focus();
	}

	var regexPassword = /^[a-zA-Z0-9_@&]+$/;
	if (!document.formChangePassword.password.value.match(regexPassword)) {
		valide = false;
		msgErreurs[i] = "Le mot de passe comporte des caractères spéciaux non autorisés !";
		i++;
		document.formChangePassword.password.focus();
	}

	/*réinitialisation la zone erreur*/
	document.getElementById("erreurs").innerHTML = "";

	if (!valide) {
		for (var cpt = 0; cpt < msgErreurs.length; cpt++) {
			var msg = msgErreurs[cpt];
			/*créer une balise div par erreur à afficher*/
			var div = document.createElement("div");
			div.innerHTML = msg.decode();
			/*insérer la balise div créée dans la div erreurs*/
			document.getElementById("erreurs").appendChild(div);
		}
	}

	return valide;
}