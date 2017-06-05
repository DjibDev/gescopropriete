/**
 * 
 */

// fonction qui s"assure que la formulaire d'inscription est correctement rempli
function validFormInscription(){


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