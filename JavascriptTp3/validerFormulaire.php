<?php

function verifierTelephone($tel) {
    if ($tel == "Entrée invalide") {
        $tel = "";
    }
    return $tel;
}

function verifierCourriel($courriel) {

    $pa = '.@';
    $ap = '@.';
    $papos = strpos($courriel, $pa);
    $appos = strpos($courriel, $ap);

    // si la chaine de caractères ".@" est dans le courriel
    if ($papos !== false) {
        return false; // courriel invalide.
    } else if ($appos !== false) {
        return false;
    }
    else
        return true;
}

function verifierCodePostal($codePostal) {

    $espace = " ";

    //$cp recois true s'il y a un espace
    $cp = strpos($codePostal, $espace);

    if ($cp) {
        return true;
    }
    else
        return false;
}

header('UTF-8');
$erreurs = "";
$lignesFichier = "";
//$listeDonnees = "";


// partie 1

$donnees['Nom'] = $_POST['nom'];
$donnees['Prénom'] = $_POST['prenom'];
$donnees['Code permanent UQAM'] = $_POST['cp'];
$donnees['Code permanent MES'] = $_POST['cpmes'];

// Verifier date valide
$datenaissance = $_POST['datenaissance'];
$date = explode("-", $datenaissance);
$jour = intval($date[0]);
$mois = intval($date[1]);
$annee = intval($date[2]);

if (!checkdate($mois, $jour, $annee)) {
    $erreurs = "La date de naissance " . $jour . "-" . $mois . "-" . "$annee" . " est invalide. (formulaire partie 1/7)<br/>";
} else {
    $donnees['Date de naissance'] = $_POST['datenaissance'];
}

$donnees['Sexe'] = $_POST['sexe'];
$donnees['NAS'] = $_POST['NAS'];
$donnees['Citoyenneté'] = $_POST['citoyennete'];
$donnees['Ville'] = $_POST['ville'];
$donnees['Nom de famille du père'] = $_POST['nfpere'];
$donnees['Prénom du père'] = $_POST['prenompere'];
$donnees['Nom de famille de la mère'] = $_POST['nfmere'];
$donnees['Prénom de la mère'] = $_POST['prenommere'];
$donnees['Status'] = $_POST['status'];
$donnees['Langue d\' usage'] = $_POST['lanusage'];
$donnees['Langue maternelle'] = $_POST['languematernelle'];



// partie 2

$donnees['Téléphone au domicile'] = verifierTelephone($_POST['teldomicile']);
$donnees['Téléphone au travail'] = verifierTelephone($_POST['teltravail']) . "-" . $_POST['poste'];
$donnees['Téléphone cellulaire'] = verifierTelephone($_POST['telcellulaire']);

if (verifierCourriel($_POST['courriel'])) {
    $donnees['Courriel'] = $_POST['courriel'];
} else {
    $donnees['Courriel'] = "";
    $erreurs .= "Le courriel est invalide (formulaire partie 2/7)<br/>";
}

$donnees['No. civique'] = $_POST['ncivique'];
$donnees['Nom de la rue'] = $_POST['nomrue'];
$donnees['Appartement'] = $_POST['appartement'];
$donnees['Municipalité'] = $_POST['municipalite'];

if (verifierCodePostal($_POST['codepostal'])) {
    $donnees['Code Postal'] = $_POST['codepostal'];
} else {
    $donnees['Code Postal'] = "";
    $erreurs .= "Le code postal doit contenir un espace (formulaire partie 2/7)<br/>";
}

$donnees['Pays'] = $_POST['pays'];

$donnees['No. civique (adresse actuelle)'] = $_POST['nciv'];
$donnees['Nom de la rue (adresse actuelle)'] = $_POST['nomrue2'];
$donnees['Appartement (adresse actuelle)'] = $_POST['appartement2'];
$donnees['Municipalité (adresse actuelle)'] = $_POST['municipalite2'];

if (verifierCodePostal($_POST['codepostal2'])) {
    $donnees['Code postal (adresse actuelle)'] = $_POST['codepostal2'];
} else if ($_POST['codepostal2'] === "") {
    $donnees['Code postal (adresse actuelle)'] = $_POST['codepostal2'];
} else {
    $donnees['Code postal (adresse actuelle)'] = "";
    $erreurs .= "Le code postal 2 doit contenir un espace (formulaire partie 2/7)<br/>";
}

$donnees['Pays (adresse actuelle)'] = $_POST['pays2'];
$donnees['Téléphone des parents'] = verifierTelephone($_POST['telephoneparents']);



// donnees page3
$donnees['Session'] = $_POST['status1'];
$donnees['Premier choix'] = $_POST['choixProgramme1'];
$donnees['Titre du programme 1'] = $_POST['titreProgramme1'];
$donnees['Type du programme 1'] = $_POST['typeProgramme1'];
$donnees['Status du programme 1'] = $_POST['statusProgramme1'];
$donnees['Deuxième choix'] = $_POST['choixProgramme2'];
$donnees['Titre du programme 2'] = $_POST['titreProgramme2'];
$donnees['Type du programme 2'] = $_POST['typeProgramme2'];
$donnees['Status du programme 2'] = $_POST['statusProgramme2'];
$donnees['Troisième choix'] = $_POST['choixProgramme3'];
$donnees['Titre du programme 3'] = $_POST['titreProgramme3'];
$donnees['Type du programme 3'] = $_POST['typeProgramme3'];
$donnees['Status du programme 3'] = $_POST['statusProgramme3'];
$donnees['Presence au Québec'] = $_POST['presence'];


// Verifier date arrivée

if (isset($_POST['datearrivee'])) {

    $dateArrivee = $_POST['datearrivee'];
    $date = explode("-", $dateArrivee);

    if ($date[0] !== "" && $date[0] !== "" && $date[0] !== "") {

        $jour = intval($date[0]);
        $mois = intval($date[1]);
        $annee = intval($date[2]);

        if (checkdate($mois, $jour, $annee)) {
            $donnees['Jour d\'arrivé'] = $_POST['datearrivee'];
        } else {
            $erreurs .= "La date d'arrivée " . $jour . "-" . $mois . "-" . "$annee" . " est invalide. (formulaire partie 3/7)<br/>";
        }
    }
} else {
    $donnees['Jour d\'arrivé'] = "date invalide";
}


// donnees page 4
$donnees['Dernière année du secondaire'] = $_POST['anneesecondaire'];
$donnees['Période de fréquentation Secondaire'] = $_POST['frecsecondaire'];

if (isset($_POST['Secondaire Extérieur coché=1'])) {
    $donnees['Secondaire Extérieur coché=1'] = $_POST['extsecondaire'];
} else {
    $donnees['Secondaire Extérieur coché=1'] = "0";
}

$donnees['Secondaire Extérieur discipline'] = $_POST['extdiscipline'];
$donnees['Secondaire Extérieur institution'] = $_POST['extinstitution'];
$donnees['Période de fréquentation Secondaire extérieur'] = $_POST['frecext'];
$donnees['Date Obtention Secondaire extérieur'] = $_POST['dateobtenuext'];

$donnees['Nom Diplôme Collégial'] = $_POST['decdiplome'];
$donnees['Discipline  Collégial'] = $_POST['decdiscipline'];
$donnees['Nom Intitution Collégial'] = $_POST['college'];
$donnees['Collégial Obtenue'] = $_POST['obtenudec'];
$donnees['Période de fréquentation Collégial'] = $_POST['frecdec'];
$donnees['Date Obtention Collégial'] = $_POST['dateobtenudec'];

if (isset($_POST['DEC-1 AUTRE-2'])) {
    $donnees['DEC-1 AUTRE-2'] = $_POST['radiodec'];
} else {
    $donnees['DEC-1 AUTRE-2'] = "0";
}

// Partie 5

if (isset($_POST['diplome1'])) {
    $donnees['Grade coche 1'] = $_POST['diplome1'];
}

$donnees['Nom du premier diplôme'] = $_POST['nomdiplome1'];
$donnees['Status du premier diplôme'] = $_POST['obtenu1'];
$donnees['Nom de l\'institution du premier diplôme'] = $_POST['nominstitut1'];
$donnees['Période de fréquentation'] = $_POST['periodefrequentation1'];
$donnees['Date d\'obtention'] = $_POST['dateobtention1'];
$donnees['Première Discipline'] = $_POST['discipline'];

if (isset($_POST['diplome2'])) {
    $donnees['Grade coche 1'] = $_POST['diplome2'];
}
$donnees['Nom du deuxième diplôme'] = $_POST['nomdiplome2'];
$donnees['Status du deuxième diplôme'] = $_POST['obtenu2'];
$donnees['Nom de l\'institution du deuxième diplôme'] = $_POST['nominstitut2'];
$donnees['Période de fréquentation du deuxième diplôme'] = $_POST['periodefrequentation2'];
$donnees['Date d\'obtention du deuxième diplôme'] = $_POST['dateobtention2'];
$donnees['Deuxième Discipline'] = $_POST['discipline2'];


$donnees['Nom de l\'employeur'] = $_POST['nomemployeur1'];
$donnees['Type d\'emploi'] = $_POST['typeemploi1'];
$donnees['Attestation'] = $_POST['ajointe1'];



if (isset($_POST['avenir1'])) {
    $donnees['Attestation à venir'] = $_POST['avenir1'];
}

// Verifier date expédition 1
if (isset($_POST['dateexp1'])) {
    $dateexp = $_POST['dateexp1'];
    $date = explode("-", $dateexp);

    if ($date[0] !== "" && $date[0] !== "" && $date[0] !== "") {

        $jour = intval($date[0]);
        $mois = intval($date[1]);
        $annee = intval($date[2]);

        if (checkdate($mois, $jour, $annee)) {
            $donnees['Date d\'expedition'] = $_POST['dateexp1'];
        } else {
            $erreurs .= "La date d'expédition " . $jour . "-" . $mois . "-" . "$annee" . " est invalide. (formulaire partie 6/7)<br/>";
        }
    }
} else {
    $donnees['Date d\'expedition'] = "date invalide";
}

$donnees['Durée du premier emploi'] = "de " . $_POST['demois1'] . "-" . $_POST['deannee1'] . " à " . $_POST['amois1'] . "-" . $_POST['aannee1'];

$donnees['Nom du deuxième employeur'] = $_POST['nomemployeur2'];
$donnees['Deuxième type d\'emploi'] = $_POST['typeemploi2'];
$donnees['Deuxième attestation'] = $_POST['ajointe2'];



if (isset($_POST['avenir2'])) {
    $donnees['Deuxième attestation à venir'] = $_POST['avenir2'];
}

// Verifier date expédition 2    
if (isset($_POST['dateexp2'])) {

    $dateexp = $_POST['dateexp2'];
    $date = explode("-", $dateexp);

    if ($date[0] !== "" && $date[0] !== "" && $date[0] !== "") {

        $jour = intval($date[0]);
        $mois = intval($date[1]);
        $annee = intval($date[2]);

        if (checkdate($mois, $jour, $annee)) {
            $donnees['Deuxième date d\'expedition'] = $_POST['dateexp2'];
        } else {
            $erreurs .= "La deuxième date d'expédition" . $jour . "-" . $mois . "-" . "$annee" . " est invalide. (formulaire partie 6/7)<br/>";
        }
    }
} else {
    $donnees['Deuxième date d\'expedition'] = "date invalide";
}

$donnees['Durée du deuxième emploi'] = "de " . $_POST['demois2'] . "-" . $_POST['deannee2'] . " à " . $_POST['amois2'] . "-" . $_POST['aannee2'];

$donnees['Nom de troisième employeur'] = $_POST['nomemployeur3'];
$donnees['Troisième Type d\'emploi'] = $_POST['typeemploi3'];
$donnees['Troisième attestation'] = $_POST['ajointe3'];



if (isset($_POST['avenir3'])) {
    $donnees['Troisième attestation à venir'] = $_POST['avenir3'];
}

// Verifier date expédition 3    
if (isset($_POST['dateexp3'])) {

    $dateexp = $_POST['dateexp3'];
    $date = explode("-", $dateexp);

    if ($date[0] !== "" && $date[0] !== "" && $date[0] !== "") {

        $jour = intval($date[0]);
        $mois = intval($date[1]);
        $annee = intval($date[2]);

        if (checkdate($mois, $jour, $annee)) {
            $donnees['Troisième date d\'expedition'] = $_POST['dateexp3'];
        } else {
            $erreurs .= "La troisième date d'expédition" . $jour . "-" . $mois . "-" . "$annee" . " est invalide. (formulaire partie 6/7)<br/>";
        }
    }
} else {
    $donnees['Troisième date d\'expedition'] = "date invalide";
}

$donnees['Durée du troisième emploi'] = "de " . $_POST['demois3'] . "-" . $_POST['deannee3'] . " à " . $_POST['amois3'] . "-" . $_POST['aannee3'];
$donnees['Commentaire'] = $_POST['commentaire'];

if (isset($_POST['signature1'])) {
    $donnees['signature1'] = $_POST['signature1'];
}
if (isset($_POST['signature2'])) {
    $donnees['signature2'] = $_POST['signature2'];
}
?>


<!doctype html>
<html>

    <head>
        <meta charset="utf-8">
        <title>Formulaire d'incription</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/elemHTML.css">
        <link rel="stylesheet" type="text/css" href="css/infobulle.css">
        <script src="js/jquery-2.1.3.min.js"></script>
        <script type="text/javascript" src="js/fonctions.js"></script>
    </head>

    <body>
        <article>
            <header>
                <h1><a href='http://www.uqam.ca/' style='color:white; text-decoration: none;'>UQÀM</a></h1>
                <div id="header-right">
                    <h2>Formulaire de demande d'admission</h2>   
                    <p>Validation de vos données</p>
                </div>
            </header>

            <?php
            if ($erreurs !== "") {
                echo "<nav style= 'background-color: red;'>";
                echo "<h2>Erreurs Détectés</h2>";
            } else {
                echo "<nav style= 'background-color: green;'>";
                echo "<h2>Confirmation d'Inscription</h2>";
            }
            echo "</nav>";
            ?>
            <section style='padding: 20px; width: 96%;'>

                <?php
                if ($erreurs !== "") {
                    echo "<h2>Erreur</h2><br/>";
                    echo "<p>Il y a eu des erreur dans certains champs:</p><br/>";
                    echo $erreurs;
                } else {
                    foreach ($donnees as $name => $value) {
                        $lignesFichier .= "$name : $value\r\n";
                    }
                    // sauvegarder ligne sur fichier texte
                    // Il faut configurer le serveurweb pour accepter d'écrire sur le repertoire
                    $fichier = fopen("inscriptions/" . $donnees['Code permanent MES'] . ".txt", "a+") or die("Erreur de fichier!");
                    fwrite($fichier, $lignesFichier);
                    fclose($fichier);
                    echo "<h2>Succèss</h2><br/>";
                    echo "<p>Les données on été sauvegardés avec succèss pour " . $donnees['Code permanent MES'] . ".</p><br/>";
                                       
                    // echo "<p>Voir fichier: " . $donnees['Code permanent MES'] . ".txt</p><br/>";                    
                    // echo "Merci!<br/><br/><hr/><br/>";                    
                     
                    /* Envoyer les données à l'écran 
                     * 
                      foreach ($donnees as $name => $value) {
                      $listeDonnees .= "$name : $value\r\n<br/>";
                      }
                      echo $listeDonnees;
                     * 
                     */
                }
                ?>

            </section>

            <footer style="color:white;">  
                <p style="padding-top:15px; padding-left: 15px;">
                    TP3 par Leonardo Hernández (HERL16027606) et Víctor Pirón (PIRV11026606)</p>                
            </footer>

        </article>

    </body>

</html>