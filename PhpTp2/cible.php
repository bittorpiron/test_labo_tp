<!DOCTYPE html>
<html>
    <header> 
        <meta charset="UTF-8">
        <title>Gû Traitement Commande</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="author" content="Victor Piron Mardones">
    </header>
    <body>
        <div id="page">
            <div id="ligne"></div>
            <header>
                <div id="entete_gauche">
                    <h2>Réponse Commande</h2>
                    <h1>Services de Traiteur GÛ</h1>
                </div>
                <div id="entete_droite">
                    <img src="ressources/toque.png" alt="Txapela Buruan...">
                </div>        
            </header>
            <div id="centre">  
                <nav>
                    <nav>
                        <a class="active" href="#">Réponse</a> 
                        <a href="index.html">Accueil</a>   
                        <a href="commande.html">Commande</a> 
                    </nav>
                </nav>
                <section>
                <article id="contenue">

                    <h2>Bonjour <?php echo htmlspecialchars($_GET['parent']); ?>,</h2>

                    <?php
                    header('UTF-8');
                    $nomParent = filter_input(INPUT_GET, 'parent');
                    $nomEnfant = filter_input(INPUT_GET, 'enfant');
                    $nomEcole = filter_input(INPUT_GET, 'ecole');
                    $ageEnfant = filter_input(INPUT_GET, 'age');
                    $choixLundi = filter_input(INPUT_GET, 'lundi');
                    $choixMardi = filter_input(INPUT_GET, 'mardi');
                    $choixMercredi = filter_input(INPUT_GET, 'mercredi');
                    $choixJeudi = filter_input(INPUT_GET, 'jeudi');
                    $choixVendredi = filter_input(INPUT_GET, 'vendredi');

                    $reponseErreur = '';
                    $reponseErreur .= validerChampTexte($nomParent, '\'Nom du parent\'');
                    $reponseErreur .= validerChampTexte($nomEnfant, '\'Nom de l\'enfant\'');
                    $reponseErreur .= validerChampTexte($nomEcole, '\'École\'');
                    $reponseErreur .= validerChampAge($ageEnfant, '\'Âge de l\'enfant\'');
                    $reponseErreur .= validerChoixMenu($choixLundi, '\'Lundi\'');
                    $reponseErreur .= validerChoixMenu($choixMardi, '\'Mardi\'');
                    $reponseErreur .= validerChoixMenu($choixMercredi, '\'Mercredi\'');
                    $reponseErreur .= validerChoixMenu($choixJeudi, '\'Jeudi\'');
                    $reponseErreur .= validerChoixMenu($choixVendredi, '\'Vendredi\'');

                    if ($reponseErreur == '') {
                        echo '<p>Confirmation de commande réussite:</p>';
                        $ligne = "Parent:" . $nomParent .
                                ", Enfant:" . $nomEnfant .
                                ", Age:" . $ageEnfant .
                                ", Ecole:" . $nomEcole .
                                ", Lundi:" . $choixLundi .
                                ", Mardi:" . $choixMardi .
                                ", Mercredi:" . $choixMercredi .
                                ", Jeudi:" . $choixJeudi .
                                ", Vendredi:" . $choixVendredi . "\n";
                        
                        file_put_contents('fichier.txt',  utf8_encode($ligne), FILE_APPEND | LOCK_EX);
                        
                        echo '<p>' . str_replace(",", "<br>", $ligne) . '</p>';
                                                mb_internal_encoding('UTF-8');
                                                
                        $ecriture=fopen("fichier2.txt","a+"); 
                        fwrite($ecriture,utf8_encode($ligne)); 
                        fclose($ecriture); 


                    } else {
                        echo '<p>Erreurs dans votre commande:</p>' . $reponseErreur;
                    }

                    function validerChampTexte($valeur, $champ) {
                        if ($valeur) {
                            if (strstr($valeur, ',')) {
                                return '<p>Le champ ' . $champ . ' ( virgules non permis ).</p>';
                            }
                        } else {
                            return '<p>Le champ ' . $champ . ' est vide.</p>';
                        }
                        return '';
                    }

                    function validerChampAge($valeur, $champ) {
                        if ($valeur) {
                            if (is_numeric($valeur)) {
                                return validerLimits($valeur, $champ, 4, 12);
                            } else {
                                return '<p>Erreur' . $champ . ' non numérique</p>';
                            }
                        } else {
                            return '<p>Le champ ' . $champ . ' est Vide.</p>';
                        }
                        return '';
                    }

                    function validerLimits($valeur, $champ, $inferieur, $superieur) {
                        if ($valeur < $inferieur or $valeur > $superieur) {
                            return '<p> ' . $champ . ' = ' . $valeur .
                                    ' hors limites( de ' . $inferieur . ' à ' . $superieur . ')</p>';
                        }
                        return '';
                    }

                    function validerChoixMenu($valeur, $champ) {
                        if (!$valeur) {
                            return '<p>Vous n\'avez pas fait un choix pour' . $champ . '.</p>';
                        } else {
                            return '';
                        }
                    }

                    function ecrireFichier($ligne) {
                        file_put_contents('commmandes.txt', $ligne, FILE_APPEND | LOCK_EX);
                    }
                    ?>
                </article>    
                </section>    
                <div id="lignebas"></div>
                <footer>
                    <a href="mailto:bittorpiron@gmail.com">@Copyright 2015 Orhy | Une production Victor Piron</a>
                </footer>

            </div>
        </div>
    </body>
</html>

