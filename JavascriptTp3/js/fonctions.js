$(document).ready(function() {
    initialiser();
    permetUncheckRadio('radiodec');
    $("pre").hide();
    $('input,select').keypress(function(event) {
        return event.keyCode !== 13;
    });
    montrerFormulaire();
    sauterTabIndexDesImages();
});

function permetUncheckRadio(name) {
    var allRadios = document.getElementsByName(name);
    var booRadio;
    var x = 0;
    for (x = 0; x < allRadios.length; x++) {
        allRadios[x].onclick = function() {
            if (booRadio == this) {
                this.checked = false;
                booRadio = null;
            } else {
                booRadio = this;
            }
        };
    }
}

function verifierUnchecked(name) {
    var allRadios = document.getElementsByName(name);
    var x = 0;
    for (x = 0; x < allRadios.length; x++) {
        if (allRadios[x].checked)
            return true;
    }
}

function changerVisibilitee(champ) {

    if (champ === "presence") {
        valeurShow = "Non";
        champShow = "#cacheDateArrivee";
    } else if (champ === "langueusage") {
        valeurShow = "Autre";
        champShow = "#autrelangue";
    } else if (champ === "languematernelle") {
        valeurShow = "Autre";
        champShow = "#autrelanguematernelle";
    }

    var inx = document.getElementById(champ).selectedIndex;
    var option = document.getElementById(champ).options;
    if (option[inx].text === valeurShow) {
        $(champShow).show();
    }
    else {
        $(champShow).hide();
    }

}

/* global index, nbpages, nomsPage regex (tableau) */
function initialiser() {
    index = 1;
    nomsPage = ["Identification", "Coordonées", "Programmes Demandés", "Reinseignements sur le études secondaires et collégiales", "Reinseignements sur les études universitaires", "Emplois", "Reinseignements supplémentaires"];
    nbpages = nomsPage.length;
    regex = {
// nomx: nom famille, prenom, nom ville, citoyennete 
        nomx: /^[a-zA-ZÀ-ÿ\s\-\']+$/,
        codemes: /^[A-Z]{4}[0-9]{8}$/,
        longformatdate: /^(\d{1,2})\-(\d{1,2})\-(\d{2})$/,
        shortformatdate: /^(\d{1,2})$/,
        strictement2chiffres: /^(\d{2})$/,
        nas: /^(\d{3})\-(\d{3})\-(\d{3})$/,
        tel: /^(\d{3})\-(\d{3})\-(\d{4})$/,
        poste: /^[0-9]{4}$/,
        email: /^[a-z0-9\.\-\_]+@[a-z0-9\.]+\.[a-z]{2,3}$/,
        nociv: /^[0-9]+$/,
        codepostal: /[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]/
    };
}

function actualiserBoutonsVersLaDroite() {
    if (index === nbpages) {
        $('#rightBannerScroller').attr('src', 'img/rightBannerScrollerDisable.png');
        $('#rightBannerScrollerfooter').attr('src', 'img/rightBannerScrollerDisable.png');
    } else if (index > 1) {
        $('#leftBannerScroller').attr('src', 'img/leftBannerScroller.png');
        $('#leftBannerScrollerfooter').attr('src', 'img/leftBannerScroller.png');
    }
}

function actualiserBoutonsVersLaGauche() {
    if (index === nbpages - 1) {
        $('#rightBannerScroller').attr('src', 'img/rightBannerScroller.png');
        $('#rightBannerScrollerfooter').attr('src', 'img/rightBannerScroller.png');
    } else if (index === 1) {
        $('#leftBannerScroller').attr('src', 'img/leftBannerScrollerDisable.png');
        $('#leftBannerScrollerfooter').attr('src', 'img/leftBannerScrollerDisable.png');
    }
}

function formulaireSuivant() {
    if (validerElements(index)) {
        changerIndexDroite(); // incrémenter l'index
        montrerFormulaire(index); // montrer la pochaine page
        actualiserBoutonsVersLaDroite();
    } else
        montrerFormulaire(index); // rester à la même place
}

function formulairePrecedent() {
    changerIndexGauche();
    montrerFormulaire(index);
    actualiserBoutonsVersLaGauche();
}

function changerIndexDroite() {
    if (index < nbpages) {
        index++;
    }
}

function changerIndexGauche() {
    if (index > 1) {
        $("pre").hide();
        index--;
    }
}

function montrerFormulaire() {
    for (var i = 1; i < nbpages + 1; i++) {
        if (index === i) {
            $("#partie" + i).show();
            document.querySelector('.compteurDuFormulaire').innerHTML = nomsPage[index - 1] + ' - partie ' + index + '/' + nbpages;
        } else {
            $("#partie" + i).hide();
        }
    }
}

function changerImageDroite(elem) {
    if (index < nbpages) {
        $(elem).attr('src', 'img/rightBannerScrollerHover.png');
    }
}


function remettreImageDroite(elem) {
    if (index < nbpages) {
        $(elem).attr('src', 'img/rightBannerScroller.png');
    }
}


function changerImageGauche(elem) {
    if (index > 1) {
        $(elem).attr('src', 'img/leftBannerScrollerHover.png');
    }
}


function remettreImageGauche(elem) {
    if (index > 1) {
        $(elem).attr('src', 'img/leftBannerScroller.png');
    }
}


function sauterTabIndexDesImages() {
    images = document.getElementsByTagName('a');
    len = images.length;
    var i = 0;
    while (i < len) {
        document.getElementsByTagName('a')[i].setAttribute("tabindex", '-1');
        i++;
    }
}


function validerChampTexte(id, regex) {
    var fieldValue = document.getElementById(id).value;
    if (!regex.test(fieldValue)) {
        document.getElementById(id).value = "Entrée invalide";
        return false;
    } else {
        return true;
    }
}


function verifierNomParent(id1, id2) {
    var nom = document.getElementById(id1).value;
    var prenom = document.getElementById(id2).value;

    if (nom === "" && prenom === "") {
        return true;
    } else if (nom && prenom) {
        if (validerChampTexte(id1, regex.nomx) && validerChampTexte(id2, regex.nomx)) {
            return true;
        }
    }
    else {
        if (validerChampTexte(id1, regex.nomx) && validerChampTexte(id2, regex.nomx)) {
            return false;
        }
    }
}


/* id1 = nom de la liste. id2 = le champ "autre" */
function validerListe(id1, id2, regex) {
    var liste = document.getElementById(id1);
    listeValue = liste.options[liste.selectedIndex].text;

    if (listeValue !== "Autre") {
        document.getElementById(id2).value = "";
        return true;
    }

    if (listeValue === "Autre" && document.getElementById(id2).text !== "") {
        if (validerChampTexte(id2, regex)) {
            return true;
        }
    } else
        return false;
}


/* Author: Jacques berger */
function changerDeBoite(currentId, nextId) {
    var textBox = document.getElementById(currentId);
    if (textBox.value.length == textBox.getAttribute("maxlength")) {
        document.getElementById(nextId).focus();
    }
}

function recupererValeursDesBoites(id1, id2, id3) {

    var valeur1 = id1;
    var valeur2 = id2;
    var valeur3 = id3;
    var valeurDesBoites = "";

    if (typeof valeur3 === 'undefined') {
        valeurDesBoites = document.getElementById(valeur1).value + "-" + document.getElementById(valeur2).value;
    } else {
        valeurDesBoites = document.getElementById(valeur1).value + "-" + document.getElementById(valeur2).value + "-" + document.getElementById(valeur3).value;
    }
    return valeurDesBoites;
}

function sauvegarderValeursDansChampCache(id1, id2, id3, champCache) {
// id3 = 0 desactive le parametre id3
    if (id3 === 0) {
        var tempVal = recupererValeursDesBoites(id1, id2);
        document.getElementById(champCache).value = tempVal;
    } else {
        var tempVal = recupererValeursDesBoites(id1, id2, id3);
        document.getElementById(champCache).value = tempVal;
    }
}

function viderChampsTel(id1, id2, id3) {
    document.getElementById(id1).value = "";
    document.getElementById(id2).value = "";
    document.getElementById(id3).value = "";
}

function viderDiplomeUniversitaire(id1, id2, id3, id4, id5, id6, id7, id8, id9, id10) {
    document.getElementById(id1).checked = false;
    document.getElementById(id2).value = "";
    document.getElementById(id3).value = "";
    document.getElementById(id4).value = "";
    document.getElementById(id5).value = "";
    document.getElementById(id6).value = "";
    document.getElementById(id7).value = "";
    document.getElementById(id8).value = "";
    document.getElementById(id9).value = "";
    document.getElementById(id10).value = "";
}

function viderChampsEmploi(id1, id2, id3, id4, id5, id6, id7, id8) {
    document.getElementById(id1).value = "";
    document.getElementById(id2).value = "";
    document.getElementById(id3).value = "";
    document.getElementById(id4).value = "";
    document.getElementById(id5).value = "";
    document.getElementById(id6).value = "";
    document.getElementById(id7).value = "";
    document.getElementById(id8).checked = true;
}


function viderChampsAdresse(id1, id2, id3, id4, id5, id6) {
    document.getElementById(id1).value = "";
    document.getElementById(id2).value = "";
    document.getElementById(id3).value = "";
    document.getElementById(id4).value = "";
    document.getElementById(id5).value = "";
    document.getElementById(id6).value = "";
}


function validerElements(partie) {
    var messageErreur = "";
    var erreurs = [];
    $("pre").hide();
    switch (partie) {
        case 1:
            // partie 1/7 du formulaire

            // s'il y a un erreur dans le champs de saissie, le sauvegarder
            if (!validerChampTexte("nomFamille", regex.nomx)) {
                erreurs.push("Nom de famille");
            } else
            // Si on trouve la chaine "Entrée invalide" dans le champs, le traiter comme un erreur    
            if (document.getElementById("nomFamille").value === "Entrée invalide") {
                erreurs.push("Nom de famille");
            }

            if (!validerChampTexte("pnom", regex.nomx)) {
                erreurs.push("Prénom");
            } else if (document.getElementById("pnom").value === "Entrée invalide") {
                erreurs.push("Prénom");
            }

            if (document.getElementById("codep").value !== "") {
                if (!validerChampTexte("codep", regex.codemes))
                    erreurs.push("Code permanent UQAM - facultatif");
            } // le code permanent peut etre vide (facultatif)

            if (!validerChampTexte("codemes", regex.codemes)) {
                erreurs.push("Code permanent du MES");
            }

            if (!validerChampTexte("datenaissance", regex.longformatdate)) {
                erreurs.push("Date de naissance");
            }

            // NAS est facultatif, accepter vide ou chaine valide
            if (document.getElementById("NAS").value !== "") {
                if (document.getElementById("NAS").value === "--") {
                    document.getElementById("NAS").value = "";
                } else
                if (!validerChampTexte("NAS", regex.nas)) {
                    erreurs.push("NAS");
                }
            }

            if (!validerChampTexte("citoyennete", regex.nomx)) {
                erreurs.push("Citoyenneté");
            } else if (document.getElementById("citoyennete").value === "Entrée invalide") {
                erreurs.push("Citoyenneté");
            }

            if (!validerChampTexte("ville", regex.nomx)) {
                erreurs.push("Ville");
            } else if (document.getElementById("ville").value === "Entrée invalide") {
                erreurs.push("Ville");
            }

            if (!verifierNomParent("nfpere", "prenompere")) {
                erreurs.push("Le nom ou le prénom du père");
            } else if (document.getElementById("nfpere").value === "Entrée invalide" || document.getElementById("prenompere").value === "Entrée invalide") {
                erreurs.push("Le nom ou le prénom du père");
            }

            if (!verifierNomParent("nfmere", "prenommere")) {
                erreurs.push("Le nom ou le prénom de la mère");
            } else if (document.getElementById("nfmere").value === "Entrée invalide" || document.getElementById("prenommere").value === "Entrée invalide") {
                erreurs.push("Le nom ou le prénom de la mère");
            }

            if (!validerListe("langueusage", "autrelangue", regex.nomx)) {
                erreurs.push("Langue d'usage");
            } else if (document.getElementById("autrelangue").value === "Entrée invalide") {
                erreurs.push("Langue d'usage");
            }

            if (!validerListe("languematernelle", "autrelanguematernelle", regex.nomx)) {
                erreurs.push("Langue maternelle");
            } else if (document.getElementById("autrelanguematernelle").value === "Entrée invalide") {
                erreurs.push("Langue maternelle");
            }


            if (erreurs.length > 0) {
                messageErreurs = "* ";
                for (var i = 0; i < erreurs.length; i++) {
                    if (i + 1 === erreurs.length) {
                        messageErreurs += erreurs[i] + "";
                    } else
                        messageErreurs += erreurs[i] + "\n* ";
                }

                $("pre").text("Veuillez corriger les erreurs des champs:\n\n" + messageErreurs).show();

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });

                return false;
            } else
                return true;
            break;
        case 2:
            // partie 2/7 du formulaire

            // si au moins un des 3 tels est valide 
            if (validerChampTexte("teldomicile", regex.tel) || validerChampTexte("teltravail", regex.tel) || validerChampTexte("telcellulaire", regex.tel)) {

                if (!validerChampTexte("teldomicile", regex.tel)) {
                    viderChampsTel("teldom", "preteldom", "postteldom");
                }

                if (!validerChampTexte("teltravail", regex.tel)) {
                    viderChampsTel("teltrav", "preteltrav", "postteltrav");
                }

                if (!validerChampTexte("telcellulaire", regex.tel)) {
                    viderChampsTel("cellulaire", "precel", "postcel");
                }
                // si les 3 tels sont faux, recommencer
            } else {
                viderChampsTel("teldom", "preteldom", "postteldom");
                viderChampsTel("teltrav", "preteltrav", "postteltrav");
                viderChampsTel("cellulaire", "precel", "postcel");
                document.getElementById("poste").value = "";
                erreurs.push("Vous devez entrer au moins un téléphone valide. Format: 514-123-4567 ");
            }


            if (document.getElementById("poste").value !== "") {
                if (!validerChampTexte("poste", regex.poste)) {
                    erreurs.push("Poste, téléphone au travail - 4 chiffres");
                    document.getElementById("poste").value = "";
                }
            }


            if (document.getElementById("courriel").value !== "") {
                if (!validerChampTexte("courriel", regex.email)) {
                    erreurs.push("Courriel");
                }
            }

            if (!validerChampTexte("ncivique", regex.nociv)) {
                erreurs.push("No. civique - seulement des chiffres");
            }

            if (!validerChampTexte("nomrue", regex.nomx)) {
                erreurs.push("Nom de la rue - seulement des lettres");
            } else if (document.getElementById("nomrue").value === "Entrée invalide") {
                erreurs.push("Nom de la rue - seulement des lettres");
            }

            if (document.getElementById("appartement").value !== "") {
                if (!validerChampTexte("appartement", regex.nociv)) {
                    erreurs.push("Appartement - seulement des chiffres");
                }
            } else if (document.getElementById("appartement").value === "Entrée invalide") {
                erreurs.push("Appartement - seulement des chiffres");
            }

            if (!validerChampTexte("municipalite", regex.nomx)) {
                erreurs.push("Municipalité");
            } else if (document.getElementById("municipalite").value === "Entrée invalide") {
                erreurs.push("Municipalité");
            }

            if (!validerChampTexte("codepostal", regex.codepostal)) {
                erreurs.push("Code postal - Format: X9X 9X9");
            } else if (document.getElementById("codepostal").value === "Entrée invalide") {
                erreurs.push("Code postal");
            }

            // facultatif
            if (document.getElementById("pays").value !== "") {
                if (!validerChampTexte("pays", regex.nomx)) {
                    erreurs.push("Pays");
                }
            } else if (document.getElementById("pays").value === "Entrée invalide") {
                erreurs.push("Pays");
            } else
                document.getElementById("pays").value = "Canada";


            // Si un champ est rempli, les autres doivent être aussi remplis
            if (document.getElementById("nciv").value !== "" ||
                    document.getElementById("nomrue2").value !== "" ||
                    document.getElementById("appartement2").value !== "" ||
                    document.getElementById("municipalite2").value !== "" ||
                    document.getElementById("codepostal2").value !== "" ||
                    document.getElementById("pays2").value !== "") {

                if (document.getElementById("nciv").value !== "") {
                    if (!validerChampTexte("nciv", regex.nociv)) {
                        erreurs.push("No. civique (adresse actuelle)");
                    } else if (document.getElementById("nciv").value === "Entrée invalide") {
                        erreurs.push("No. civique (adresse actuelle)");
                    }
                } else if (!validerChampTexte("nciv", regex.nociv)) {
                    erreurs.push("No. civique (adresse actuelle)");
                }

                // si champ remplie
                if (document.getElementById("nomrue2").value !== "") {
                    // verifie ce qui a dedans
                    if (!validerChampTexte("nomrue2", regex.nomx)) {
                        erreurs.push("Nom de la rue"); // erreur si entrée invalide
                    }
                    // si entrée valide
                    else if (document.getElementById("nomrue2").value === "Entrée invalide") {
                        erreurs.push("Nom de la rue");
                    }
                    // si champ vide
                } else if (!validerChampTexte("nomrue2", regex.nomx)) {
                    erreurs.push("Nom de la rue");
                }

                // regex.nociv  valide aussi numero appartement en supposant
                // que les appartements sont juste des chiffres
                if (document.getElementById("appartement2").value !== "") {
                    if (!validerChampTexte("appartement2", regex.nociv)) {
                        erreurs.push("Appartement (adresse actuelle)");
                    } else if (document.getElementById("appartement2").value === "Entrée invalide") {
                        erreurs.push("Appartement (adresse actuelle)");
                    }
                } else if (!validerChampTexte("nciv", regex.nociv)) {
                    erreurs.push("Appartement (adresse actuelle)");
                }

                if (document.getElementById("municipalite2").value !== "") {
                    if (!validerChampTexte("municipalite2", regex.nomx)) {
                        erreurs.push("Municipalité (adresse actuelle)");
                    } else if (document.getElementById("municipalite2").value === "Entrée invalide") {
                        erreurs.push("Municipalité (adresse actuelle)");
                    }
                } else if (!validerChampTexte("municipalite2", regex.nomx)) {
                    erreurs.push("Municipalité (adresse actuelle)");
                }


                if (document.getElementById("codepostal2").value !== "") {
                    if (!validerChampTexte("codepostal2", regex.codepostal)) {
                        erreurs.push("Code Postal (adresse actuelle)");
                    } else if (document.getElementById("codepostal2").value === "Entrée invalide") {
                        erreurs.push("Code Postal (adresse actuelle)");
                    }
                } else if (!validerChampTexte("codepostal2", regex.codepostal)) {
                    erreurs.push("Code Postal (adresse actuelle)");
                }



                if (document.getElementById("pays2").value !== "") {
                    if (!validerChampTexte("pays2", regex.nomx)) {
                        erreurs.push("Pays (adresse actuelle)"); // erreur si entrée invalide
                    }
                    // si entrée valide
                    else if (document.getElementById("pays2").value === "Entrée invalide") {
                        erreurs.push("Pays (adresse actuelle)");
                    }
                    // si champ vide
                } else if (!validerChampTexte("pays2", regex.nomx)) {
                    document.getElementById("pays2").value = "Canada";
                }
            }

            // facultatif
            if (document.getElementById("telephoneparents").value !== "") {
                if (!validerChampTexte("telephoneparents", regex.tel)) {
                    viderChampsTel("telparents", "pretelparents", "posttelparents");
                    erreurs.push("Téléphone des parents ou laisser vide");
                    document.getElementById('telephoneparents').value = "";
                }
            } else if (document.getElementById("telephoneparents").value === "Entrée invalide") {
                erreurs.push("Téléphone des parents ou laisser vide");
                document.getElementById('telephoneparents').value = "";
            }

            if (erreurs.length > 0) {
                messageErreurs = "* ";
                for (var i = 0; i < erreurs.length; i++) {
                    if (i + 1 === erreurs.length) {
                        messageErreurs += erreurs[i] + "";
                    } else
                        messageErreurs += erreurs[i] + "\n* ";
                }
                $("pre").text("Veuillez corriger les erreurs des champs:\n\n" + messageErreurs).show().fadeIn(1000);

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });

                return false;
            } else
                return true;
            break;
        case 3:
            if (!validerChampTexte("choixProgramme1", regex.nomx)) {
                messageErreur += "\nPremier choix est invalide.\n";
            } else if (document.getElementById("choixProgramme1").value === "Entrée invalide") {
                messageErreur += "\nPremier choix est invalide.\n";
            }
            if (!validerChampTexte("titreProgramme1", regex.nomx)) {
                messageErreur += "Titre du premier choix est invalide.\n";
            } else if (document.getElementById("titreProgramme1").value === "Entrée invalide") {
                messageErreur += "Titre du premier choix est invalide.\n";
            }
            if (document.getElementById("choixProgramme2").value !== "") {
                if (!validerChampTexte("choixProgramme2", regex.nomx)) {
                    messageErreur += "Choix 2 est invalide.\n";
                } else if (document.getElementById("choixProgramme2").value === "Entrée invalide") {
                    messageErreur += "Choix 2 est invalide..\n";
                }
                if (!validerChampTexte("titreProgramme2", regex.nomx)) {
                    document.getElementById("titreProgramme2").value !== "";
                } else if (document.getElementById("titreProgramme2").value === "Entrée invalide") {
                    messageErreur += "Titre est invalide (Deuxième choix).\n";
                }
                if (document.getElementById("choixProgramme3").value !== "") {
                    if (!validerChampTexte("choixProgramme3", regex.nomx)) {
                        messageErreur += "Choix 3 est invalide.\n";
                    } else if (document.getElementById("choixProgramme3").value === "Entrée invalide") {
                        messageErreur += "Choix 3 est invalide.\n";
                    }
                    if (document.getElementById("choixProgramme3").value !== "") {
                        if (!validerChampTexte("titreProgramme3", regex.nomx)) {
                            messageErreur += "Titre 3 est invalide.\n";
                        } else if (document.getElementById("titreProgramme2").value === "Entrée invalide") {
                            messageErreur += "Titre est invalide (Troixième choix).\n";
                        }
                    } else {
                        document.getElementById("titreProgramme3").value = "";
                    }
                }
            } else {
                if (document.getElementById("titreProgramme2").value !== "") {
                    messageErreur += "Pas de choix 2!\n";
                }
                if (document.getElementById("choixProgramme3").value !== "" ||
                        document.getElementById("titreProgramme3").value !== "") {
                    messageErreur += "Pas de Choix 3 sans Choix 2!\n";
                }
                document.getElementById("titreProgramme2").value = "";
                document.getElementById("choixProgramme3").value = "";
                document.getElementById("titreProgramme3").value = "";
            }
            if (messageErreur === "") {
                return true;
            } else {
                $("pre").text("Veuillez corriger les erreurs:\n" + messageErreur).show().fadeIn(20000);

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });

                return false;
            }
            break;
        case 4:
            if (document.getElementById("anneesecondaire").value !== "") {
                if (document.getElementById("fromyearsecondaire").value === "" ||
                        document.getElementById("toyearsecondaire").value === "") {
                    messageErreur += "Veuillez remplir TOUS les dates pour Études Secondaires.\n";
                } else {
                    if (!validerChampTexte("anneesecondaire", regex.shortformatdate)) {
                        messageErreur += "\nLe dernier année secondaires est invalide.\n";
                    } else {
                        if (document.getElementById("anneesecondaire").value > 5 ||
                                document.getElementById("anneesecondaire").value < 1) {
                            messageErreur += "Dernier année secondaire hors des limites [1..5]\n";
                        }
                    }
                    if (!validerChampTexte("fromyearsecondaire", regex.shortformatdate) || !validerChampTexte("toyearsecondaire", regex.shortformatdate)) {
                        messageErreur += "La date de frécuentation d'études sécondaires est invalide.\n";
                    } else {
                        if (document.getElementById("toyearsecondaire").value < document.getElementById("fromyearsecondaire").value) {
                            messageErreur += "La date de fin d'études sécondaire doit être après celle du commencement.\n";
                        }
                    }
                }
            }
            else {
                document.getElementById("anneesecondaire").value = "";
                document.getElementById("fromyearsecondaire").value = "";
                document.getElementById("toyearsecondaire").value = "";
            }

            if (document.getElementById("extsecondaire").checked) {
                if (document.getElementById("extdiscipline").value === "" ||
                        document.getElementById("extinstitution").value === "" ||
                        document.getElementById("fromyearext").value === "" ||
                        document.getElementById("toyearext").value === "" ||
                        document.getElementById("extmoisobtention").value === "" ||
                        document.getElementById("extanneeobtention").value === "") {
                    messageErreur += "Veuillez remplir TOUS les champs pour Études Secondaires porsuivis à l'Extérieur.\n";
                } else {
                    if (!validerChampTexte("choixProgramme1", regex.nomx)) {
                        messageErreur += "\nPremier choix est invalide.\n";
                    }
                    if (!validerChampTexte("fromyearext", regex.shortformatdate) || !validerChampTexte("toyearext", regex.shortformatdate)) {
                        messageErreur += "La date de frécuentation d'études sécondaire est invalide.\n";
                    } else {
                        if (document.getElementById("toyearext").value < document.getElementById("fromyearext").value) {
                            messageErreur += "La date de fin d'études sécondaire doit être après celle du commencement.\n";
                        }
                        if (!validerChampTexte("extmoisobtention", regex.shortformatdate)) {
                            messageErreur += "La date d'obtention pour les études sécondaire est invalide.\n";
                        } else {
                            if (document.getElementById("extmoisobtention").value > 12 ||
                                    document.getElementById("extmoisobtention").value < 1) {
                                messageErreur += "Mois obtention Études Sécondaires hors des limites [1..12]\n";
                            }
                            if (document.getElementById("extanneeobtention").value < document.getElementById("toyearext").value) {
                                messageErreur += "La date d'obtention ne peut pas être inférieur à la fin de fréquentation.\n";
                            }
                        }
                    }
                }
            } else {
                document.getElementById("extdiscipline").value = "";
                document.getElementById("extinstitution").value = "";
                document.getElementById("fromyearext").value = "";
                document.getElementById("toyearext").value = "";
                document.getElementById("extmoisobtention").value = "";
                document.getElementById("extanneeobtention").value = "";
            }
            //collège
            if (verifierUnchecked("radiodec")) {
                if (document.getElementById("decdiplome").value === "" ||
                        document.getElementById("decdiscipline").value === "" ||
                        document.getElementById("college").value === "" ||
                        document.getElementById("fromyeardec").value === "" ||
                        document.getElementById("toyeardec").value === "" ||
                        document.getElementById("moisobtentiondec").value === "" ||
                        document.getElementById("anneeobtentiondec").value === "") {
                    messageErreur += "Veuillez remplir TOUS les champs pour Études Collègiales.\n";
                } else {
                    if (!validerChampTexte("fromyeardec", regex.shortformatdate) || !validerChampTexte("toyeardec", regex.shortformatdate)) {
                        messageErreur += "La date de frécuentation pour Études Sécondaires est invalide.\n";
                    } else {
                        if (document.getElementById("toyeardec").value < document.getElementById("fromyeardec").value) {
                            messageErreur += "La date de fin d'études collègiales doit être après celle du commencement.\n";
                        }
                        if (!validerChampTexte("moisobtentiondec", regex.shortformatdate)) {
                            messageErreur += "La date d'obtention pour diplôme collegial est invalide.\n";
                        } else {
                            if (document.getElementById("moisobtentiondec").value > 12 ||
                                    document.getElementById("moisobtentiondec").value < 1) {
                                messageErreur += "Mois obtention diplôme collégial hors des limites [1..12]\n";
                            }
                            if (document.getElementById("anneeobtentiondec").value < document.getElementById("toyeardec").value) {
                                messageErreur += "La date d'obtention diplôme collègial ne peut pas être inférieur à la fin de fréquentation.\n";
                            }
                        }
                    }
                }
            } else {
                document.getElementById("decdiplome").value = "";
                document.getElementById("college").value = "";
                document.getElementById("decdiscipline").value = "";
                document.getElementById("fromyeardec").value = "";
                document.getElementById("toyeardec").value = "";
                document.getElementById("moisobtentiondec").value = "";
                document.getElementById("anneeobtentiondec").value = "";
            }
            if (messageErreur === "") {
                return true;
            } else {
                $("pre").text("Veuillez corriger les erreurs:\n" + messageErreur).show().fadeIn(20000);

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });

                return false;
            }
            break;
        case 5:
            // premier diplome
            if (document.getElementById("diplome1").checked ||
                    document.getElementById("nomdiplome1").value !== "" ||
                    document.getElementById("nominstitut1").value !== "" ||
                    document.getElementById("fromyear").value !== "" ||
                    document.getElementById("toyear").value !== "" ||
                    document.getElementById("moisobtention").value !== "" ||
                    document.getElementById("anneeobtention").value !== "" ||
                    document.getElementById("discipline").value !== "") {

                if (!document.getElementById("diplome1").checked) {
                    document.getElementById("diplome1").checked = true;
                }

                if (document.getElementById("nomdiplome1").value !== "") {
                    if (!validerChampTexte("nomdiplome1", regex.nomx)) {
                        erreurs.push("Nom du diplôme");
                    } else if (document.getElementById("nomdiplome1").value === "Entrée invalide") {
                        erreurs.push("Nom du diplôme");
                    }
                } else if (!validerChampTexte("nomdiplome1", regex.nomx)) {
                    erreurs.push("Nom du diplôme");
                }

                if (document.getElementById("nominstitut1").value !== "") {
                    if (!validerChampTexte("nominstitut1", regex.nomx)) {
                        erreurs.push("Nom de l'institut");
                    } else if (document.getElementById("nominstitut1").value === "Entrée invalide") {
                        erreurs.push("Nom de l'institut");
                    }
                } else if (!validerChampTexte("nominstitut1", regex.nomx)) {
                    erreurs.push("Nom de l'institut");
                }


                if (document.getElementById("fromyear").value !== "") {
                    if (!validerChampTexte("fromyear", regex.strictement2chiffres)) {
                        erreurs.push("Période de fréquentation, de année...");
                    } else if (document.getElementById("fromyear").value === "Entrée invalide") {
                        erreurs.push("Période de fréquentation, de année...");
                    }
                } else if (!validerChampTexte("fromyear", regex.strictement2chiffres)) {
                    erreurs.push("Période de fréquentation, de année...");
                }

                if (document.getElementById("toyear").value !== "") {
                    if (!validerChampTexte("toyear", regex.strictement2chiffres)) {
                        erreurs.push("Période de fréquentation, à année...");
                    } else if (document.getElementById("toyear").value === "Entrée invalide") {
                        erreurs.push("Période de fréquentation, à année...");
                    } else {
                        if (document.getElementById("fromyear").value > document.getElementById("toyear").value) {
                            erreurs.push("La première année de la période de fréquentation ne peut pas être supérieure à la deuxième année de la période de fréquentation");
                        }
                    }
                } else if (!validerChampTexte("toyear", regex.strictement2chiffres)) {
                    erreurs.push("Période de fréquentation, à année...");
                }


                if (document.getElementById("moisobtention").value !== "") {
                    if (!validerChampTexte("moisobtention", regex.strictement2chiffres)) {
                        erreurs.push("Mois d'obtention");
                    } else if (document.getElementById("moisobtention").value === "Entrée invalide") {
                        erreurs.push("Mois d'obtention");
                    }
                } else if (!validerChampTexte("moisobtention", regex.strictement2chiffres)) {
                    erreurs.push("Mois d'obtention");
                }


                if (document.getElementById("anneeobtention").value !== "") {
                    if (!validerChampTexte("anneeobtention", regex.strictement2chiffres)) {
                        erreurs.push("Année d'obtention");
                    } else if (document.getElementById("anneeobtention").value === "Entrée invalide") {
                        erreurs.push("Année d'obtention");
                    } else {
                        if (document.getElementById("moisobtention").value > 12 ||
                                document.getElementById("moisobtention").value < 1) {
                            erreurs.push("Le mois obtention diplôme universitaire est hors des limites [1..12]");
                        }
                        if (document.getElementById("toyear").value > document.getElementById("anneeobtention").value) {
                            erreurs.push("L'année de la période de fréquentation ne peut pas être supérieure à l'année de la date d'obtention");
                        }
                    }
                } else if (!validerChampTexte("anneeobtention", regex.strictement2chiffres)) {
                    erreurs.push("Année d'obtention");
                }


                if (document.getElementById("discipline").value !== "") {
                    if (!validerChampTexte("discipline", regex.nomx)) {
                        erreurs.push("Discipline");
                    } else if (document.getElementById("discipline").value === "Entrée invalide") {
                        erreurs.push("Discipline");
                    }
                } else if (!validerChampTexte("discipline", regex.nomx)) {
                    erreurs.push("Discipline");
                }

            } // fin premier diplome





            // deuxieme diplome
            if (document.getElementById("diplome2").checked ||
                    document.getElementById("nomdiplome2").value !== "" ||
                    document.getElementById("nominstitut2").value !== "" ||
                    document.getElementById("fromyear2").value !== "" ||
                    document.getElementById("toyear2").value !== "" ||
                    document.getElementById("moisobtention2").value !== "" ||
                    document.getElementById("anneeobtention2").value !== "" ||
                    document.getElementById("discipline2").value !== "") {

                if (!document.getElementById("diplome2").checked) {
                    document.getElementById("diplome2").checked = true;
                }

                if (document.getElementById("nomdiplome2").value !== "") {
                    if (!validerChampTexte("nomdiplome2", regex.nomx)) {
                        erreurs.push("Nom du diplôme (deuxième diplôme)");
                    } else if (document.getElementById("nomdiplome2").value === "Entrée invalide") {
                        erreurs.push("Nom du diplôme (deuxième diplôme)");
                    }
                } else if (!validerChampTexte("nomdiplome2", regex.nomx)) {
                    erreurs.push("Nom du diplôme (deuxième diplôme)");
                }

                if (document.getElementById("nominstitut2").value !== "") {
                    if (!validerChampTexte("nominstitut2", regex.nomx)) {
                        erreurs.push("Nom de l'institut (deuxième diplôme)");
                    } else if (document.getElementById("nominstitut2").value === "Entrée invalide") {
                        erreurs.push("Nom de l'institut (deuxième diplôme)");
                    }
                } else if (!validerChampTexte("nominstitut2", regex.nomx)) {
                    erreurs.push("Nom de l'institut (deuxième diplôme)");
                }


                if (document.getElementById("fromyear2").value !== "") {
                    if (!validerChampTexte("fromyear2", regex.strictement2chiffres)) {
                        erreurs.push("Période de fréquentation, de année... (deuxième diplôme)");
                    } else if (document.getElementById("fromyear2").value === "Entrée invalide") {
                        erreurs.push("Période de fréquentation, de année... (deuxième diplôme)");
                    }
                } else if (!validerChampTexte("fromyear2", regex.strictement2chiffres)) {
                    erreurs.push("Période de fréquentation, de année... (deuxième diplôme)");
                }

                if (document.getElementById("toyear2").value !== "") {
                    if (!validerChampTexte("toyear2", regex.strictement2chiffres)) {
                        erreurs.push("Période de fréquentation, à année... (deuxième diplôme)");
                    } else if (document.getElementById("toyear2").value === "Entrée invalide") {
                        erreurs.push("Période de fréquentation, à année... (deuxième diplôme)");
                    } else {
                        if (document.getElementById("fromyear2").value > document.getElementById("toyear2").value) {
                            erreurs.push("La première année de la période de fréquentation ne peut pas être supérieure à la deuxième année de la période de fréquentation");
                        }
                    }
                } else if (!validerChampTexte("toyear2", regex.strictement2chiffres)) {
                    erreurs.push("Période de fréquentation, à année... (deuxième diplôme)");
                }


                if (document.getElementById("moisobtention2").value !== "") {
                    if (!validerChampTexte("moisobtention2", regex.strictement2chiffres)) {
                        erreurs.push("Mois d'obtention (deuxième diplôme)");
                    } else if (document.getElementById("moisobtention2").value === "Entrée invalide") {
                        erreurs.push("Mois d'obtention (deuxième diplôme)");
                    }
                } else if (!validerChampTexte("moisobtention2", regex.strictement2chiffres)) {
                    erreurs.push("Mois d'obtention (deuxième diplôme)");
                }


                if (document.getElementById("anneeobtention2").value !== "") {
                    if (!validerChampTexte("anneeobtention2", regex.strictement2chiffres)) {
                        erreurs.push("Année d'obtention (deuxième diplôme)");
                    } else if (document.getElementById("anneeobtention2").value === "Entrée invalide") {
                        erreurs.push("Année d'obtention (deuxième diplôme)");
                    } else {
                        if (document.getElementById("moisobtention2").value > 12 ||
                                document.getElementById("moisobtention2").value < 1) {
                            erreurs.push("Le mois obtention diplôme universitaire est hors des limites [1..12]");
                        }
                        if (document.getElementById("toyear2").value > document.getElementById("anneeobtention2").value) {
                            erreurs.push("L'année de la période de fréquentation ne peut pas être supérieure à l'année de la date d'obtention");
                        }
                    }
                } else if (!validerChampTexte("anneeobtention2", regex.strictement2chiffres)) {
                    erreurs.push("Année d'obtention (deuxième diplôme)");
                }



                if (document.getElementById("discipline2").value !== "") {
                    if (!validerChampTexte("discipline2", regex.nomx)) {
                        erreurs.push("Discipline (deuxième diplôme)");
                    } else if (document.getElementById("discipline2").value === "Entrée invalide") {
                        erreurs.push("Discipline (deuxième diplôme)");
                    }
                } else if (!validerChampTexte("discipline2", regex.nomx)) {
                    erreurs.push("Discipline (deuxième diplôme)");
                }
            } // fin deuxieme diplome

            if (erreurs.length > 0) {
                messageErreurs = "* ";
                for (var i = 0; i < erreurs.length; i++) {
                    if (i + 1 === erreurs.length) {
                        messageErreurs += erreurs[i] + "";
                    } else
                        messageErreurs += erreurs[i] + "\n* ";
                }
                $("pre").text("Veuillez corriger les erreurs des champs:\n\n" + messageErreurs).show().fadeIn(1000);

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });
                return false;
            } else
                return true;
            break;
        case 6:
            // emploi 1      
            if (document.getElementById("nomemployeur1").value !== "" ||
                    document.getElementById("typeemploi1").value !== "" ||
                    document.getElementById("dateexp1").value !== "" ||
                    document.getElementById("demois1").value !== "" ||
                    document.getElementById("deannee1").value !== "" ||
                    document.getElementById("amois1").value !== "" ||
                    document.getElementById("aannee1").value !== "") {


                if (document.getElementById("dateexp1").value === "") {
                    if (document.getElementById("avenir1").checked) {
                        alert("Vous devez entrer un date d'expédition");
                        erreurs.push("Date d'explédition à venir");
                    }
                }
                else {
                    if (document.getElementById("dateexp1").value !== "") {
                        if (!validerChampTexte("dateexp1", regex.longformatdate)) {
                            erreurs.push("Date d'explédition");
                        } else if (document.getElementById("dateexp1").value === "Entrée invalide") {
                            erreurs.push("Date d'explédition");
                        }
                    } else if (!validerChampTexte("dateexp1", regex.longformatdate)) {
                        erreurs.push("Date d'explédition");
                    }
                }


                if (document.getElementById("nomemployeur1").value !== "") {
                    if (!validerChampTexte("nomemployeur1", regex.nomx)) {
                        erreurs.push("Nom de l'employeur");
                    } else if (document.getElementById("nomemployeur1").value === "Entrée invalide") {
                        erreurs.push("Nom de l'employeur");
                    }
                } else if (!validerChampTexte("nomemployeur1", regex.nomx)) {
                    erreurs.push("Nom de l'employeur");
                }

                if (document.getElementById("typeemploi1").value !== "") {
                    if (!validerChampTexte("typeemploi1", regex.nomx)) {
                        erreurs.push("Type d'emploi");
                    } else if (document.getElementById("typeemploi1").value === "Entrée invalide") {
                        erreurs.push("Type d'emploi");
                    }
                } else if (!validerChampTexte("typeemploi1", regex.nomx)) {
                    erreurs.push("Type d'emploi");
                }


                if (document.getElementById("demois1").value !== "") {
                    if (!validerChampTexte("demois1", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de mois...");
                    } else if (document.getElementById("demois1").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de mois...");
                    }
                    else {
                        if (document.getElementById("demois1").value > 12 ||
                                document.getElementById("demois1").value < 1) {
                            erreurs.push("Le premier mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 1]");
                        }
                    }
                } else if (!validerChampTexte("demois1", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de mois...");
                }

                if (document.getElementById("deannee1").value !== "") {
                    if (!validerChampTexte("deannee1", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de année...");
                    } else if (document.getElementById("deannee1").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de année...");
                    }
                } else if (!validerChampTexte("deannee1", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de année...");
                }


                if (document.getElementById("amois1").value !== "") {
                    if (!validerChampTexte("amois1", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à mois...");
                    } else if (document.getElementById("amois1").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à mois...");
                    }
                    else {
                        if (document.getElementById("amois1").value > 12 ||
                                document.getElementById("amois1").value < 1) {
                            erreurs.push("Le deuxième mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 1]");
                        }
                    }
                } else if (!validerChampTexte("amois1", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à mois...");
                }

                if (document.getElementById("aannee1").value !== "") {
                    if (!validerChampTexte("aannee1", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à année...");
                    } else if (document.getElementById("aannee1").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à année...");
                    } else {
                        if (document.getElementById("deannee1").value > document.getElementById("aannee1").value) {
                            erreurs.push("La première année de la durée de l'emploi doit être inférieure à la deuxième année de la durée d'emploi [section emploi 1]");
                        }
                    }
                } else if (!validerChampTexte("aannee1", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à année...");
                }


            }
            // fin emploi 1
            // emploi 2      
            if (document.getElementById("nomemployeur2").value !== "" ||
                    document.getElementById("typeemploi2").value !== "" ||
                    document.getElementById("dateexp2").value !== "" ||
                    document.getElementById("demois2").value !== "" ||
                    document.getElementById("deannee2").value !== "" ||
                    document.getElementById("amois2").value !== "" ||
                    document.getElementById("aannee2").value !== "") {


                if (document.getElementById("dateexp2").value === "") {
                    if (document.getElementById("avenir2").checked) {
                        alert("Vous devez entrer un date d'expédition");
                        erreurs.push("Date d'expédition à vernir (deuxième emploi)");
                    }
                }
                else {
                    if (document.getElementById("dateexp2").value !== "") {
                        if (!validerChampTexte("dateexp2", regex.longformatdate)) {
                            erreurs.push("Date d'expédition (deuxième emploi)");
                        } else if (document.getElementById("dateexp2").value === "Entrée invalide") {
                            erreurs.push("Date d'expédition (deuxième emploi)");
                        }
                    } else if (!validerChampTexte("dateexp2", regex.longformatdate)) {
                        erreurs.push("Date d'expédition (deuxième emploi)");
                    }
                }


                if (document.getElementById("nomemployeur2").value !== "") {
                    if (!validerChampTexte("nomemployeur2", regex.nomx)) {
                        erreurs.push("Nom de l'employeur (deuxième emploi)");
                    } else if (document.getElementById("nomemployeur2").value === "Entrée invalide") {
                        erreurs.push("Nom de l'employeur (deuxième emploi)");
                    }
                } else if (!validerChampTexte("nomemployeur2", regex.nomx)) {
                    erreurs.push("Nom de l'employeur (deuxième emploi)");
                }

                if (document.getElementById("typeemploi2").value !== "") {
                    if (!validerChampTexte("typeemploi2", regex.nomx)) {
                        erreurs.push("Type d'emploi (deuxième emploi)");
                    } else if (document.getElementById("typeemploi2").value === "Entrée invalide") {
                        erreurs.push("Type d'emploi (deuxième emploi)");
                    }
                } else if (!validerChampTexte("typeemploi2", regex.nomx)) {
                    erreurs.push("Type d'emploi (deuxième emploi)");
                }


                if (document.getElementById("demois2").value !== "") {
                    if (!validerChampTexte("demois2", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de mois...(deuxième emploi)");
                    } else if (document.getElementById("demois2").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de mois...(deuxième emploi)");
                    } else {
                        if (document.getElementById("demois2").value > 12 ||
                                document.getElementById("demois2").value < 1) {
                            erreurs.push("Le premier mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 2]");
                        }
                    }
                } else if (!validerChampTexte("demois2", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de mois...(deuxième emploi)");
                }

                if (document.getElementById("deannee2").value !== "") {
                    if (!validerChampTexte("deannee2", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de année...(deuxième emploi)");
                    } else if (document.getElementById("deannee2").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de année...(deuxième emploi)");
                    }
                } else if (!validerChampTexte("deannee2", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de année...(deuxième emploi)");
                }


                if (document.getElementById("amois2").value !== "") {
                    if (!validerChampTexte("amois2", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à mois...(deuxième emploi)");
                    } else if (document.getElementById("amois2").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à mois...(deuxième emploi)");
                    }
                    else {
                        if (document.getElementById("amois2").value > 12 ||
                                document.getElementById("amois2").value < 1) {
                            erreurs.push("Le deuxième mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 2]");
                        }
                    }
                } else if (!validerChampTexte("amois2", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à mois...(deuxième emploi)");
                }

                if (document.getElementById("aannee2").value !== "") {
                    if (!validerChampTexte("aannee2", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à année...(deuxième emploi)");
                    } else if (document.getElementById("aannee2").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à année...(deuxième emploi)");
                    } else {
                        if (document.getElementById("deannee2").value > document.getElementById("aannee2").value) {
                            erreurs.push("La première année de la durée de l'emploi doit être inférieure à la deuxième année de la durée d'emploi [section emploi 2]");
                        }
                    }
                } else if (!validerChampTexte("aannee2", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à année...(deuxième emploi)");
                }

            }
            // fin emploi 2
            // emploi 3      
            if (document.getElementById("nomemployeur3").value !== "" ||
                    document.getElementById("typeemploi3").value !== "" ||
                    document.getElementById("dateexp3").value !== "" ||
                    document.getElementById("demois3").value !== "" ||
                    document.getElementById("deannee3").value !== "" ||
                    document.getElementById("amois3").value !== "" ||
                    document.getElementById("aannee3").value !== "") {


                if (document.getElementById("dateexp3").value === "") {
                    if (document.getElementById("avenir3").checked) {
                        erreurs.push("Date d'expédition à venir (troisième emploi)");
                    }
                }
                else {
                    if (document.getElementById("dateexp3").value !== "") {
                        if (!validerChampTexte("dateexp3", regex.longformatdate)) {
                            erreurs.push("Date d'expédition (troisième emploi)");
                        } else if (document.getElementById("dateexp3").value === "Entrée invalide") {
                            erreurs.push("Date d'expédition (troisième emploi)");
                        }
                    } else if (!validerChampTexte("dateexp3", regex.longformatdate)) {
                        erreurs.push("Date d'expédition (troisième emploi)");
                    }
                }


                if (document.getElementById("nomemployeur3").value !== "") {
                    if (!validerChampTexte("nomemployeur3", regex.nomx)) {
                        erreurs.push("Nom de l'employeur (troisième emploi)");
                    } else if (document.getElementById("nomemployeur3").value === "Entrée invalide") {
                        erreurs.push("Nom de l'employeur (troisième emploi)");
                    }
                } else if (!validerChampTexte("nomemployeur3", regex.nomx)) {
                    erreurs.push("Nom de l'employeur (troisième emploi)");
                }

                if (document.getElementById("typeemploi3").value !== "") {
                    if (!validerChampTexte("typeemploi3", regex.nomx)) {
                        erreurs.push("Type d'emploi (troisième emploi)");
                    } else if (document.getElementById("typeemploi3").value === "Entrée invalide") {
                        erreurs.push("Type d'emploi (troisième emploi)");
                    }
                } else if (!validerChampTexte("typeemploi3", regex.nomx)) {
                    erreurs.push("Type d'emploi (troisième emploi)");
                }


                if (document.getElementById("demois3").value !== "") {
                    if (!validerChampTexte("demois3", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de mois...(troisième emploi)");
                    } else if (document.getElementById("demois3").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de mois...(troisième emploi)");
                    } else {
                        if (document.getElementById("demois3").value > 12 ||
                                document.getElementById("demois3").value < 1) {
                            erreurs.push("Le premier mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 3]");
                        }
                    }
                } else if (!validerChampTexte("demois3", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de mois...(troisième emploi)");
                }

                if (document.getElementById("deannee3").value !== "") {
                    if (!validerChampTexte("deannee3", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, de année...(troisième emploi)");
                    } else if (document.getElementById("deannee3").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, de année...(troisième emploi)");
                    }
                } else if (!validerChampTexte("deannee3", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, de année...(troisième emploi)");
                }


                if (document.getElementById("amois3").value !== "") {
                    if (!validerChampTexte("amois3", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à mois...(troisième emploi)");
                    } else if (document.getElementById("amois3").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à mois...(troisième emploi)");
                    }
                    else {
                        if (document.getElementById("amois3").value > 12 ||
                                document.getElementById("amois3").value < 1) {
                            erreurs.push("Le deuxième mois de la durée de l'emploi est hors des limites [1..12]. [section emploi 3]");
                        }
                    }
                } else if (!validerChampTexte("amois3", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à mois...(troisième emploi)");
                }

                if (document.getElementById("aannee3").value !== "") {
                    if (!validerChampTexte("aannee3", regex.strictement2chiffres)) {
                        erreurs.push("Durée de l'emploi, à année...(troisième emploi)");
                    } else if (document.getElementById("aannee3").value === "Entrée invalide") {
                        erreurs.push("Durée de l'emploi, à année...(troisième emploi)");
                    } else {
                        if (document.getElementById("deannee3").value > document.getElementById("aannee3").value) {
                            erreurs.push("La première année de la durée de l'emploi doit être inférieure à la deuxième année de la durée d'emploi [section emploi 3]");
                        }
                    }
                } else if (!validerChampTexte("aannee3", regex.strictement2chiffres)) {
                    erreurs.push("Durée de l'emploi, à année...(troisième emploi)");
                }


            }
            // fin emploi 3

            if (erreurs.length > 0) {
                messageErreurs = "* ";
                for (var i = 0; i < erreurs.length; i++) {
                    if (i + 1 === erreurs.length) {
                        messageErreurs += erreurs[i] + "";
                    } else
                        messageErreurs += erreurs[i] + "\n* ";
                }
                $("pre").text("Veuillez corriger les erreurs des champs:\n\n" + messageErreurs).show().fadeIn(1000);

                $(":input").each(function() {
                    var champ = $(this).val();
                    if (champ === "Entrée invalide") {
                        $(this).val("");
                    }
                });

                return false;
            } else
                return true;
            break;
        case 7:
            return true;
            break;
        default:
            break;
    }
}