<!DOCTYPE html>
<html>
    <head> 
        <meta charset="UTF-8">
        <title>Gû Traitement Commande</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <meta name="author" content="Victor Piron Mardones">
    </head>
    <body>
        <div id="page">
            <div id="ligne"></div>
            <header>
                <div id="entete_gauche">
                    <h2>Réponse Commande</h2>
                    <h1>Services de Traiteur GÛ</h1>
                </div>
                <div id="entete_droite">
                    <img src="../ressources/toque.png" alt="Txapela Buruan...">
                </div>        
            </header>
            <div id="centre">  
                <nav>
                    <a class="active" href="#">Réponse</a> 
                    <a href="../index.html">Accueil</a>   
                    <a href="commande.html">Commande</a> 
                </nav>
                <div id="corps">
                    <article id="reponse">
                        <?php
                        header('UTF-8');
                        $champs = array('Nom du parent',
                            'Nom de l\'enfant',
                            'École',
                            'Âge de l\'enfant',
                            'Lundi',
                            'Mardi',
                            'Mercredi',
                            'Jeudi',
                            'Vendredi');
                        $valeurs = array(filter_input(INPUT_GET, 'parent'),
                            filter_input(INPUT_GET, 'enfant'),
                            filter_input(INPUT_GET, 'ecole'),
                            filter_input(INPUT_GET, 'age'),
                            filter_input(INPUT_GET, 'lundi'),
                            filter_input(INPUT_GET, 'mardi'),
                            filter_input(INPUT_GET, 'mercredi'),
                            filter_input(INPUT_GET, 'jeudi'),
                            filter_input(INPUT_GET, 'vendredi')
                        );
                        
                        $reponseErreur = validerChamps($valeurs, $champs);
                        if ($reponseErreur == '') {
                            echo '<h2>Confirmation de commande réussie:</h2>';
                            enregistrerCommande($valeurs);
                            echo editerTableConfirmation($champs, $valeurs);
                        } else {
                            echo '<h3>Erreur dans votre commande:</h3>';
                            echo $reponseErreur ;
                        }
                        
                        function enregistrerCommande($valeurs) {
                             $ligne = "Parent:" . $valeurs[0] .
                                    ", Enfant:" . $valeurs[1] .
                                    ", Age:" . $valeurs[3] .
                                    ", Ecole:" . $valeurs[2] .
                                    ", Lundi:" . $valeurs[4] .
                                    ", Mardi:" . $valeurs[5] .
                                    ", Mercredi:" . $valeurs[6] .
                                    ", Jeudi:" . $valeurs[7] .
                                    ", Vendredi:" . $valeurs[8] . "\n";

                            $file = fopen('../commandes/commandes.txt', "c") or die("Impossible d'ouvrir le fichier.");
                            fseek($file, 0, SEEK_END);
                            fwrite($file, $ligne);
                            fclose($file);
                        }
                        
                        function validerChamps($valeurs, $champs) {
                            $reponseErreur = '';
                            for ($index = 0; $index < count($champs); $index++) {
                                if ($index < 3) {
                                    $reponseErreur .= validerChampTexte($valeurs[$index], $champs[$index]);
                                } elseif ($index == 3) {
                                    $reponseErreur .= validerChampAge($valeurs[$index], $champs[$index]);
                                } else {
                                    $reponseErreur .= validerChoixMenu($valeurs[$index], $champs[$index]);
                                }
                            }
                            return $reponseErreur;
                        }

                        function validerChampTexte($valeur, $champ) {
                            if ($valeur) {
                                if (strstr($valeur, ',')) {
                                    return '<p>Le champ [' . $champ . '] contient des virgules.</p>';
                                }
                            } else {
                                return '<p>Le champ [' . $champ . '] est vide.</p>';
                            }
                            return '';
                        }

                        function validerChampAge($valeur, $champ) {
                            if ($valeur) {
                                if (is_numeric($valeur)) {
                                    return validerLimits($valeur, $champ, 4, 12);
                                } else {
                                    return '<p>Le champ [' . $champ . '] n\'est pas numérique</p>';
                                }
                            } else {
                                return '<p>Le champ [' . $champ . '] est vide.</p>';
                            }
                            return '';
                        }

                        function validerLimits($valeur, $champ, $inferieur, $superieur) {
                            if ($valeur < $inferieur or $valeur > $superieur) {
                                return '<p>Le champ [' . $champ . ' = ' . $valeur . ' ] se trouve hors des limites [' . $inferieur . ', ' . $superieur . ']</p>';
                            }
                            return '';
                        }

                        function validerChoixMenu($valeur, $champ) {
                            if (!$valeur) {
                                return '<p>Vous n\'avez pas fait de choix pour le [' . $champ . '].</p>';
                            } else {
                                return '';
                            }
                        }

                        function editerTableConfirmation($champs, $valeurs) {
                            $table = '<table>';
                            for ($index = 0; $index < count($champs); $index++) {
                                $table .= '<tr>';
                                $table .= '    <td>';
                                $table .= $champs[$index];
                                $table .= '</td>';
                                $table .= '    <td>:&nbsp;';
                                $table .= $valeurs[$index];
                                $table .='</td>';
                                $table .= '</tr>';
                            }
                            $table .= '</table>';
                            return $table;
                        }
                        ?>
                    </article>    
                    <div class="espacement"> </div>
                </div>    
                <div id="lignebas"></div>
                <footer>
                    <a href="mailto:bittorpiron@gmail.com">@Copyright 2015 Orhy | Une production Victor Piron</a>
                </footer>

            </div>
        </div>
    </body>
</html>

