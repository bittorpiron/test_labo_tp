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
                    <p>Études de premier cycle</p>
                </div>
            </header>
            <nav>
                <h2><label class="compteurDuFormulaire"></label></h2>
                <img id ="rightBannerScroller" src="img/rightBannerScroller.png" alt="fleche de droite"
                     onclick='formulaireSuivant();' 
                     onmouseover='changerImageDroite(this);' 
                     onmouseout='remettreImageDroite(this);'>

                <img id="leftBannerScroller" src="img/leftBannerScrollerDisable.png"  alt="fleche de gauche"
                     onclick='formulairePrecedent();'
                     onmouseover='changerImageGauche(this);' 
                     onmouseout='remettreImageGauche(this);'>
            </nav>
            <section>
                <div id="messerreur" class="boxUneLigne">                    
                    <pre></pre>
                </div>
                <form id="formulaire" name="admission" method="post" action="validerFormulaire.php">
                    <!-- Quatre parties seron montrées selon la progression du formulaire-->
                    <div id="partie1">
                        <br/>
                        <div id="rpbox1" class="colGauche">

                            <label for="nomFamille">* Nom de famille à la naissance</label><br/>
                            <input id="nomFamille" type="text" name="nom" required><br/>  

                            <label for="pnom">* Prénom usuel</label><br/>
                            <input type="text" id="pnom" name="prenom" required><br/>

                            <label for="codep">Code Permanent UQÀM</label><br/>
                            <input type="text" id="codep" name="cp" placeholder="Facultatif">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                <span>Code permanent (alphanumérique) si vouz avez.<br/>déjà
                                    étudié à l'UQÀM</span>
                            </a><br/>     

                            <label for="codemes">* Code Permanent du MES</label><br/>
                            <input type="text" id="codemes" name="cpmes" placeholder="Ex: ABCD12345678" required>
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                <span>Code permanent (alphanumérique) du<br/>
                                    ministère de l'Enseignement supérieur,<br/>
                                    de la Recherche et de la Science.<br/>
                                    Format: 4 lettres majuscules, 8 chiffres
                                </span>
                            </a><br/>

                        </div>
                        <div id="rpbox2" class="colDroite">
                            <label for="lejour">* Date de naissance</label><br/>
                            <input type="text" id="lejour" name="jour" size="1" maxlength="2" required onkeyup="changerDeBoite('lejour', 'lemois');"
                                   onblur="sauvegarderValeursDansChampCache('lejour', 'lemois', 'lannee', 'datenaissance');">
                            <input type="text" id="lemois" name="mois" size="1" maxlength="2" required onkeyup="changerDeBoite('lemois', 'lannee');"
                                   onblur="sauvegarderValeursDansChampCache('lejour', 'lemois', 'lannee', 'datenaissance');">
                            <input type="text" id="lannee" name="lannee" size="1" maxlength="2" required 
                                   onblur="sauvegarderValeursDansChampCache('lejour', 'lemois', 'lannee', 'datenaissance');" ><br/>
                            <input type="hidden" id="datenaissance" name="datenaissance" >
                            <p>
                                <label for="lejour">Jour</label>
                                <label for="lemois" style="padding-left: 10px;">Mois</label>
                                <label for="lannee" style="padding-left: 1px;">Année</label>
                            </p>
                            <br/>

                            <label for="sexe">Sexe</label><br/>
                            <select id="sexe"  name="sexe">
                                <option value="féminin">Féminin</option>
                                <option value="masculin">Masculin</option>
                            </select>
                            <br/><br/>

                            <label for="nas1">Numéro d'assurance sociale</label><br/>
                            <input type="text" id="nas1" name="nas1" size="1" maxlength="3" onkeyup="changerDeBoite('nas1', 'nas2');"
                                   onblur="sauvegarderValeursDansChampCache('nas1', 'nas2', 'nas3', 'NAS');">
                            <input type="text" id="nas2" name="nas2" size="1" maxlength="3" onkeyup="changerDeBoite('nas2', 'nas3');"
                                   onblur="sauvegarderValeursDansChampCache('nas1', 'nas2', 'nas3', 'NAS');">
                            <input type="text" id="nas3" name="nas3" size="1" maxlength="3"
                                   onblur="sauvegarderValeursDansChampCache('nas1', 'nas2', 'nas3', 'NAS');">
                            <input type="hidden" id="NAS" name="NAS" >
                            <a href="#" class="infobulle-droite">
                                <img class="help-img-droite" src="img/help-white.png" alt="aide">
                                <span>Le NAS n'est pas obligatoire.<br/>Il est requis si vous
                                    désirez recevoir<br/>un reçu pour les impôts.</span>
                            </a>

                        </div>

                        <div id="statusbox1" class="colGauche">                                                      

                            <label for="citoyennete">* Citoyenneté</label><br/>
                            <input type="text" id="citoyennete" name="citoyennete" required placeholder="Ex: Canadienne">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                <span>Autre citoyénneté? Précisez<br/>
                                    dans le champs de saisie                                           
                                </span>
                            </a><br/>

                            <label for="ville">* Lieu de naissance (ville)</label><br/>
                            <input type="text" id="ville" name="ville" required><br/>

                            <label for="nfpere">Nom de famille du père à la naissance</label><br/>
                            <input type="text" id="nfpere" name="nfpere" placeholder="Facultatif">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                <span>Le nom et le prénom doivent être remplis<br/>
                                    obligatoirement si le parent est connu.                                           
                                </span>
                            </a><br/>

                            <label for="prenompere">Prénom usuel du père</label><br/>
                            <input type="text" id="prenompere" name="prenompere"><br/>

                            <label for="nfmere">Nom de famille de la mère à la naissance</label><br/>
                            <input type="text" id="nfmere" name="nfmere" placeholder="Facultatif"><br/>

                            <label for="prenommere">Prénom usuel de la mère</label><br/>
                            <input type="text" id="prenommere" name="prenommere"><br/>

                        </div>

                        <div id="statusbox2" class="colDroite">

                            <label for="statut">Statut au Canada</label><br/>
                            <select id="statut"  name="status">
                                <option value="Citoyen Canadien">Citoyen Canadien</option>
                                <option value="Amérindien">Amérindien</option>
                                <option value="Résident permanent">Résident permanent</option>
                                <option value="Visa diplomatique">Visa diplomatique</option>
                                <option value="Permis d'études">Permis d'études</option>    
                                <option value="Permis de séjour temporaire">Permis de séjour temporaire</option>
                                <option value="Permis de travail">Permis de travail</option>
                                <option value="Réfugié">Réfugié</option>
                            </select><br/><br/>


                            <label for="langueusage">Langue d'usage</label><br/>
                            <select id="langueusage" name="lanusage" onchange='changerVisibilitee("langueusage");'>
                                <option value="français">Français</option>
                                <option value="anglais">Anglais</option>
                                <option value="inuktitut">Amérindien ou Inuktitut</option>
                                <option value="autre">Autre</option>
                            </select>                            
                            <a href="#" class="infobulle-droite">
                                <img class="help-img-droite" src="img/help-white.png" alt="aide">
                                <span>Langue parlée le plus souvent<br/> à la maison</span>
                            </a><br/>
                            <input type="text" style="display: none" id="autrelangue"  placeholder="Précisez"><br/>

                            <label for="languematernelle">Langue maternelle</label><br/>
                            <select id="languematernelle" name="languematernelle" onchange='changerVisibilitee("languematernelle");'>
                                <option value="français">Français</option>
                                <option value="anglais">Anglais</option>
                                <option value="inuktitut">Amérindien ou Inuktitut</option>
                                <option value="autre">Autre</option>
                            </select>                                                               
                            <a href="#" class="infobulle-droite">
                                <img class="help-img-droite" src="img/help-white.png" alt="aide">
                                <span>Première langue apprise<br/>et encore comprise</span>
                            </a><br/>                    
                            <input type="text" style="display: none" id="autrelanguematernelle"  placeholder="Précisez"><br/> 
                        </div>
                    </div>
                    <div id="partie2">
                        <div id="coords" class="boxUneLigne">
                            <br/>
                            <table id="tel">
                                <tr>
                                    <td>
                                        <label for="teldom">Téléphone à domicile</label><br/>
                                        <span>(</span><input type="text" id="teldom" name="teldom" maxlength="3" size="1" 
                                                             onkeyup="changerDeBoite('teldom', 'preteldom');"
                                                             onblur="sauvegarderValeursDansChampCache('teldom', 'preteldom', 'postteldom', 'teldomicile');"><span>)</span>
                                        <input type="text" id="preteldom" name="pretel" maxlength="3" size="1" 
                                               onkeyup="changerDeBoite('preteldom', 'postteldom');"
                                               onblur="sauvegarderValeursDansChampCache('teldom', 'preteldom', 'postteldom', 'teldomicile');"><span> - </span>
                                        <input type="text" id="postteldom" name="postel" maxlength="4" size="2" onblur="sauvegarderValeursDansChampCache('teldom', 'preteldom', 'postteldom', 'teldomicile');"><br/>
                                        <p>
                                            <label for="teldom">Ind. rég /</label>
                                            <label for="preteldom" style="padding-left: 5px;">Numéro</label>
                                        </p>
                                        <input type="hidden" id="teldomicile" name="teldomicile">
                                    </td>
                                    <td>
                                        <label for="teltrav">Téléphone au travail</label><br/>
                                        <span>(</span><input type="text" id="teltrav" name="teltrav" maxlength="3" size="1" 
                                                             onkeyup="changerDeBoite('teltrav', 'preteltrav');" 
                                                             onblur="sauvegarderValeursDansChampCache('teltrav', 'preteltrav', 'postteltrav', 'teltravail');"><span>)</span>
                                        <input type="text" id="preteltrav" name="pretel" maxlength="3" size="1" 
                                               onkeyup="changerDeBoite('preteltrav', 'postteltrav');" 
                                               onblur="sauvegarderValeursDansChampCache('teltrav', 'preteltrav', 'postteltrav', 'teltravail');"><span> - </span>
                                        <input type="text" id="postteltrav" name="postel" maxlength="4" size="2" 
                                               onkeyup="changerDeBoite('postteltrav', 'poste');" 
                                               onblur="sauvegarderValeursDansChampCache('teltrav', 'preteltrav', 'postteltrav', 'teltravail');">
                                        <input type="text" id="poste" name="poste" maxlength="4" size="2" placeholder="poste"><br/>
                                        <p>
                                            <label for="teltrav">Ind. rég /</label>
                                            <label for="preteltrav" style="padding-left: 5px;">Numéro</label>

                                        </p>
                                        <input type="hidden" id="teltravail" name="teltravail">
                                    </td>
                                    <td>
                                        <label for="cellulaire">Cellulaire</label><br/>
                                        <span>(</span><input type="text" id="cellulaire" name="cellulaire" maxlength="3" size="1" 
                                                             onkeyup="changerDeBoite('cellulaire', 'precel');" 
                                                             onblur="sauvegarderValeursDansChampCache('cellulaire', 'precel', 'postcel', 'telcellulaire');"><span>)</span>
                                        <input type="text" id="precel" name="precel" maxlength="3" size="1" 
                                               onkeyup="changerDeBoite('precel', 'postcel');" 
                                               onblur="sauvegarderValeursDansChampCache('cellulaire', 'precel', 'postcel', 'telcellulaire');"><span> - </span>
                                        <input type="text" id="postcel" name="postcel" maxlength="4" size="2" 
                                               onblur="sauvegarderValeursDansChampCache('cellulaire', 'precel', 'postcel', 'telcellulaire');"><br/>
                                        <p>
                                            <label for="cellulaire">Ind. rég /</label>
                                            <label for="precel" style="padding-left: 5px;">Numéro</label>
                                        </p>
                                        <input type="hidden" id="telcellulaire" name="telcellulaire">
                                    </td>
                                </tr>
                            </table><br/>

                            <div class="colGauche">
                                <label for="courriel">Courriel</label><br>
                                <input type="text" id="courriel" name="courriel" placeholder="Facultatif"><br/>
                            </div>

                            <div>
                                <label for="ncivique">Adresse de correspondance</label><br/>
                                <input type="text" id="ncivique" name="ncivique" maxlength="7" size="4" placeholder="No. civ." required>
                                <input type="text" id="nomrue" name="nomrue" style="width: 230px;" placeholder="Nom de la rue" required>
                                <input type="text" id="appartement" name="appartement" size="10" maxlength="7" placeholder="App (facultatif)"><br/>                               
                                <input type="text" id="municipalite" name="municipalite" size="38" placeholder="Municipalité" required><br/>
                                <input type="text" id="codepostal" name="codepostal" size="38" maxlength="7" placeholder="Code postal" required><br/>                           
                                <input type="text" id="pays" name="pays" size="38" placeholder="Pays (facultatif, si autre que le Canada)"><br/>                                                                
                                <a href='#' class='linkeffacer'
                                   onclick="viderChampsAdresse('ncivique', 'nomrue', 'appartement', 'municipalite', 'codepostal', 'pays');">
                                    Effacer adresse de correspondance
                                </a>
                                <br/>
                            </div>

                            <div style='margin-top: 90px;'>

                                <label for="nciv">Adresse où vous résidez actuellement<br/>(si différente de l'adresse de correspondance)</label><br/>                              
                                <input type="text" id="nciv" name="nciv" maxlength="7" size="4" placeholder="No. civ.">
                                <input type="text" id="nomrue2" name="nomrue2" style="width: 230px;" placeholder="Nom de la rue">
                                <input type="text" id="appartement2" name="appartement2" size="10" maxlength="6" placeholder="App (facultatif)"><br/>                              
                                <input type="text" id="municipalite2" name="municipalite2" size="38" placeholder="Municipalité"><br/>
                                <input type="text" id="codepostal2" name="codepostal2" size="38" maxlength="7" placeholder="Code postal"><br/>                                
                                <input type="text" id="pays2" name="pays2" size="38" placeholder="Pays (facultatif, si autre que le Canada)"><br/>
                                <a href='#' class='linkeffacer'
                                   onclick="viderChampsAdresse('nciv', 'nomrue2', 'appartement2', 'municipalite2', 'codepostal2', 'pays2');">
                                    Effacer adresse de résidence actuelle
                                </a>
                            </div>

                            <div style='margin-top: 60px;'>
                                <br/><label for="telparents">Téléphone des parents</label><br/>
                                <span>(</span><input type="text" id="telparents" name="telparents" maxlength="3" size="1"
                                                     onkeyup="changerDeBoite('telparents', 'pretelparents');" 
                                                     onblur="sauvegarderValeursDansChampCache('telparents', 'pretelparents', 'posttelparents', 'telephoneparents');"><span>)</span>
                                <input type="text" id="pretelparents" name="pretelparents" maxlength="3" size="1"
                                       onkeyup="changerDeBoite('pretelparents', 'posttelparents');" 
                                       onblur="sauvegarderValeursDansChampCache('telparents', 'pretelparents', 'posttelparents', 'telephoneparents');"><span> - </span>
                                <input type="text" id="posttelparents" name="postelparents" maxlength="4" size="2"
                                       onblur="sauvegarderValeursDansChampCache('telparents', 'pretelparents', 'posttelparents', 'telephoneparents');"><br/>
                                <input type="hidden" id="telephoneparents" name="telephoneparents">
                                <p>
                                    <label for="telparents">Ind. rég /</label>
                                    <label for="pretelparents" style="padding-left: 5px;">Numéro</label>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div id="partie3">
                        <div class="boxUneLigne">
                            <br/>
                            <label for="trimestre">Je désire entreprendre mes études au trimestre</label><br/>
                            <select id="trimestre" name="status1">
                                <option value="hiver">Hiver</option>
                                <option value="ete">Été</option> 
                                <option value="automne">Automne</option>
                            </select>
                            <select id="annee" name="annee">
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2016">2017</option>
                            </select>                            
                        </div>

                        <div class="box3col">
                            <label for="choixProgramme1">* Premier choix</label><br/>
                            <input id="choixProgramme1" type="text" name="choixProgramme1"><br/>  
                            <br/>
                            <label for="titreProgramme1">* Titre</label><br/>
                            <input id="titreProgramme1" type="text" name="titreProgramme1"><br/>  
                            <br/>
                            <select id="typeProgramme1" name="typeProgramme1">
                                <option value="baccalaureat">Baccalauréat</option>
                                <option value="majeure">Majeure</option>  
                                <option value="mimeure">Mineure</option>
                                <option value="certificat">Certificat</option>    
                                <option value="progCourt">Programme court</option>   
                            </select><br/>
                            <br/>
                            <select id="statusProgramme1" name="statusProgramme1">
                                <option value="tempComplet">Temp complet</option>
                                <option value="tempPartie">Temp partiel</option>                         
                            </select>
                        </div>

                        <div class="box3col">
                            <label for="choixProgramme2">Deuxième choix</label><br/>
                            <input id="choixProgramme2" type="text" name="choixProgramme2"><br/> 
                            <br/>
                            <label for="titreProgramme2">Titre</label><br/>
                            <input id="titreProgramme2" type="text" name="titreProgramme2"><br/>  
                            <br/>
                            <select id="typeProgramme2" name="typeProgramme2">
                                <option value="baccalaureat">Baccalauréat</option>
                                <option value="majeure">Majeure</option>  
                                <option value="mimeure">Mineure</option>
                                <option value="certificat">Certificat</option>    
                                <option value="progCourt">Programme court</option>   
                            </select><br/>
                            <br/>
                            <select id="statusProgramme2" name="statusProgramme2">
                                <option value="tempComplet">Temp complet</option>
                                <option value="tempPartiel">Temp partiel</option>                         
                            </select>    
                        </div>

                        <div class="box3col">
                            <label for="choixProgramme3">Troisième choix</label><br/>
                            <input id="choixProgramme3" type="text" name="choixProgramme3"><br/> 
                            <br/>
                            <label for="titreProgramme3">Titre</label><br/>
                            <input id="titreProgramme3" type="text" name="titreProgramme3">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                <span>(nous vous suggérons fortement un <br/>
                                    programme non contingenté)
                                </span>
                            </a><br/>
                            <br/>
                            <select id="typeProgramme3" name="typeProgramme3">
                                <option value="baccalaureat">Baccalauréat</option>
                                <option value="majeure">Majeure</option>  
                                <option value="mimeure">Mineure</option>
                                <option value="certificat">Certificat</option>    
                                <option value="progCourt">Programme court</option>   
                            </select><br/> 
                            <br/>
                            <select id="statusProgramme3" name="statusProgramme3">
                                <option value="tempComplet">Temp complet</option>
                                <option value="tempPartie">Temp partiel</option>                         
                            </select>
                        </div>
                        <div class="espacement"></div>
                        <div class="box2col1">
                            <label for="presence">Serez-vous au Québec au moment des test d'évaluation?</label><br/>
                            <select id="presence" name="presence" onchange='changerVisibilitee("presence");'>
                                <option value="oui">Oui</option>
                                <option value="non">Non</option>  
                            </select>            
                        </div>
                        <div class="box2col2">
                            <div  style="display: none;" id="cacheDateArrivee">
                                <label for="jourArrivee">Date d’arrivée</label><br/>
                                <input type="text" id="jourArrivee" name="jourArrivee" size="1" maxlength="2"
                                       onblur="sauvegarderValeursDansChampCache('jourArrivee', 'moisArrivee', 'anneeArrivee', 'datearrivee');"
                                       onkeyup="changerDeBoite('jourArrivee', 'moisArrivee');">
                                <input type="text" id="moisArrivee" name="jourArrivee" size="1" maxlength="2"
                                       onblur="sauvegarderValeursDansChampCache('jourArrivee', 'moisArrivee', 'anneeArrivee', 'datearrivee');"
                                       onkeyup="changerDeBoite('moisArrivee', 'anneeArrivee');">
                                <input type="text" id="anneeArrivee" name="jourArrivee" size="1" maxlength="2" 
                                       onblur="sauvegarderValeursDansChampCache('jourArrivee', 'moisArrivee', 'anneeArrivee', 'datearrivee');"><br/>
                                <p>
                                    <label for="jourArrivee">Jour</label>
                                    <label for="moisArrivee" style="padding-left: 18px;">Mois</label>
                                    <label for="anneeArrivee" style="padding-left: 9px;">Année</label>
                                </p>
                                <input type="hidden" id="datearrivee" name="datearrivee">
                            </div>
                        </div>
                        <div class="boxUneLigne">                            
                            <p style="font-style: italic; font-size: 0.80em"><br/>Certains programmes exigent des tests de sélection ou
                                comportent des exigences particulières.<br/>
                                Votre présence peut être obligatoire en mars, en avril ou en mai 
                                pour l’admission au trimestre d’automne.
                            </p></div>
                    </div>
                    <div id="partie4" class='etudessecondaires'>
                        <div class="boxUneLigne"><p><br/>
                                Veuillez indiquer tous les programmes d’études de niveaux
                                secondaire et collégial que vous avez entrepris ou complétés.<br/>
                            </p>
                        </div>
                        <div id= "secondaire" class="box3col">
                            <label for='anneesecondaire'>Dernière année du secondaire<br/> complétée au Québec</label>                        
                            <input type='text' id='anneesecondaire' name='anneesecondaire' placeholder='5' style='width: 30px;' maxlength='1'> <br/><br/>
                            <label for='fromyearsecondaire'>Période de fréquentation</label><br/>
                            <label for='fromyearsecondaire'>De </label>
                            <input type='text' id='fromyearsecondaire' name='fromyearsecondaire' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('fromyearsecondaire', 'toyearsecondaire', 0, 'frecsecondaire');"
                                   onkeyup="changerDeBoite('fromyearsecondaire', 'toyearsecondaire');">
                            <label for='toyearsecondaire'> à </label>
                            <input type='text' id='toyearsecondaire' name='toyearsecondaire' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('fromyearsecondaire', 'toyearsecondaire', 0, 'frecsecondaire');">
                            <input type="hidden" id="frecsecondaire" name="frecsecondaire">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                <span>De (année) à (année)<br/>deux chifffres seulement</span>
                            </a><br/> 
                        </div> 
                        <div id= "exterieursecondaire" class="box3col">
                            <input type='checkbox' id='extsecondaire' name='extsecondaire'  value="1">
                            <label for='extsecondaire'>Diplôme d’études secondaires <br/>poursuivies à l’extérieur du Québec</label><br/>                        
                            <br/><label for='extdiscipline'>Discipline ou spécialisation</label><br/>                        
                            <input type='text' id='extdiscipline' name='extdiscipline'>
                            <br/><br/>
                            <label for='extinstitution'>Institution où vous avez poursuivi vos études</label><br/>                        
                            <input type='text' id='extinstitution' name='extinstitution'>
                            <br/><br/>         

                            <label for='fromyearext'>Période de fréquentation</label><br/>
                            <label for='fromyearext'>De </label>
                            <input type='text' id='fromyearext' name='fromyearext' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('fromyearext', 'toyearext', 0, 'frecext');"
                                   onkeyup="changerDeBoite('fromyearext', 'toyearext');">
                            <label for='toyearext'> à </label>
                            <input type='text' id='toyearext' name='toyearext' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('fromyearext', 'toyearext', 0, 'frecext');">
                            <input type="hidden" id="frecext" name="frecext">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                <span>De (année) à (année)<br/>deux chifffres seulement</span>
                            </a><br/> 
                            <br/>
                            <label for='extmoisobtention'>Date d'obtention</label><br/>
                            <label for='extmoisobtention'>Mois </label>
                            <input type='text' id='extmoisobtention' name='extmoisobtention' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('extmoisobtention', 'extanneeobtention', 0, 'dateobtenuext');"
                                   onkeyup="changerDeBoite('extmoisobtention', 'extanneeobtention');">
                            <label for='extanneeobtention'> Année </label>
                            <input type='text' id='extanneeobtention' name='toyearext' style='width: 30px;' maxlength='2'
                                   onblur="sauvegarderValeursDansChampCache('extmoisobtention', 'extanneeobtention', 0, 'dateobtenuext');">
                            <input type="hidden" id="dateobtenuext" name="dateobtenuext">
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                <span>Mois et année d'obtention<br/>deux chifffres seulement</span>
                            </a><br/>           

                        </div>

                        <div id= "dec" class="box3col">
                            <input type='radio' id='diplomedec' name='radiodec' value="1">       
                            <label for='diplomedec' >DEC</label><br/> 
                            <input type='radio' id='diplomeaec' name='radiodec' value="2">
                            <label for='diplomeaec'>Autre diplôme de niveau collégial<br/>(AEC, CEC,...)</label><br/>  
                            <div id='donneescollege'>

                                <br/><label for='decdiplome'>Nom du diplôme</label><br/>                        
                                <input type='text' id='decdiplome' name='decdiplome'>
                                <br/><br/>
                                <label for='college'>Institution où vous avez poursuivi vos études</label><br/>                        
                                <input type='text' id='college' name='college'>
                                <br/><br/>    
                                <label for='decdiscipline'>Discipline ou spécialisation</label><br/>                        
                                <input type='text' id='decdiscipline' name='decdiscipline'>
                                <br/><br/>                                    
                                <select id="obtenudec" name="obtenudec">
                                    <option value="Obtenu">Obtenu</option>
                                    <option value="A Obtenir">À Obtenir</option>  
                                    <option value="Ne sera pas obtenu">Ne sera pas obtenu</option>
                                </select><br/><br/>
                                <label for='fromyeardec'>Période de fréquentation</label><br/>
                                <label for='fromyeardec'>De </label>
                                <input type='text' id='fromyeardec' name='fromyeardec' style='width: 30px;' maxlength='2'
                                       onblur="sauvegarderValeursDansChampCache('fromyeardec', 'toyeardec', 0, 'frecdec');"
                                       onkeyup="changerDeBoite('fromyeardec', 'toyeardec');">
                                <label for='toyearext'> à </label>
                                <input type='text' id='toyeardec' name='toyeardec' style='width: 30px;' maxlength='2'
                                       onblur="sauvegarderValeursDansChampCache('fromyeardec', 'toyeardec', 0, 'frecdec');">
                                <input type="hidden" id="frecdec" name="frecdec">
                                <a href="#" class="infobulle-gauche">
                                    <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                    <span>De (année) à (année)<br/>deux chifffres seulement</span>
                                </a><br/><br/>
                                <label for='moisobtentiondec'>Date d'obtention</label><br/>
                                <label for='moisobtentiondec'>Mois </label>
                                <input type='text' id='moisobtentiondec' name='moisobtentiondec' style='width: 30px;' maxlength='2'
                                       onblur="sauvegarderValeursDansChampCache('moisobtentiondec', 'anneeobtentiondec', 0, 'dateobtenudec');"
                                       onkeyup="changerDeBoite('moisobtentiondec', 'anneeobtentiondec');">
                                <label for='anneeobtentiondec'> Année </label>
                                <input type='text' id='anneeobtentiondec' name='anneeobtentiondec' style='width: 30px;' maxlength='2'
                                       onblur="sauvegarderValeursDansChampCache('moisobtentiondec', 'anneeobtentiondec', 0, 'dateobtenudec');">
                                <input type="hidden" id="dateobtenudec" name="dateobtenudec"> <a href="#" class="infobulle-gauche">
                                    <img class="help-img-3col" src="img/help-white.png" alt="aide">
                                    <span>Mois et année d'obtention<br/>deux chifffres seulement</span>
                                </a><br/>
                            </div>
                        </div>
                    </div>

                    <div id="partie5">
                        <div id='etudesUniversitaire' class='diplomesUniversitaires'>
                            <p>Les relevés de notes officiels portant les sceaux de l'établissement qui les ont émis
                                et mentionnant les notes obtenues pour les cours suivis doivent être expédiés 
                                directement au Registrariat - Admission de l'UQAM par ces établissements et ce, à votre 
                                demande.</p>

                            <p>Tout relevé de notes provenant d'un établissement d'enseignement hors Québec doit 
                                être accompagné d'un document émis par cet établissement permettant d'évaluer le niveau de 
                                la formation complétée, ainsi que la notation utilisée.</p>

                            <br/>
                            <input type='checkbox' id='diplome1' name='diplome1'>
                            <label for='diplome1'>Grade ou diplôme de niveau universitaire le plus récent entrepris ou complété</label>
                            <br/><br/>

                            <label for='nomdiplome1'>Nom du diplôme</label><br/>                        
                            <input type='text' id='nomdiplome1' name='nomdiplome1'>

                            <select id="obtenu1" name="obtenu1">
                                <option value="Obtenu">Obtenu</option>
                                <option value="A Obtenir">À Obtenir</option>  
                                <option value="Ne sera pas obtenu">Ne sera pas obtenu</option>
                            </select><br/>

                            <label for='nominstitut1'> Institution où vous avez poursuivi vos études en vue de l'obtention de ce diplôme</label><br/>
                            <input type='text' id='nominstitut1' name='nominstitut1'><br/>

                            <table>
                                <tr>
                                    <td>
                                        <label for='fromyear'>Période de fréquentation</label><br/>
                                        <label for='fromyear'>De </label>
                                        <input type='text' id='fromyear' name='fromyear' style='width: 30px;' maxlength='2' 
                                               onkeyup="changerDeBoite('fromyear', 'toyear');"
                                               onblur="sauvegarderValeursDansChampCache('fromyear', 'toyear', 0, 'periodefrequentation1');">
                                        <label for='toyear'> à </label>
                                        <input type='text' id='toyear' name='toyear' style='width: 30px;' maxlength='2' 
                                               onblur="sauvegarderValeursDansChampCache('fromyear', 'toyear', 0, 'periodefrequentation1');">
                                        <a href="#" class="infobulle-gauche">
                                            <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                            <span>De (année) à (année)<br/>Strictement deux chifffres. Ex: 01</span>
                                        </a><br/> 
                                        <input type="hidden" id="periodefrequentation1" name="periodefrequentation1">
                                    </td>
                                    <td>
                                        <label for='moisobtention'>Date d'obtention</label><br/>
                                        <label for='moisobtention'>Mois </label>
                                        <input type='text' id='moisobtention' name='moisobtention' style='width: 30px;' maxlength='2'
                                               onkeyup="changerDeBoite('moisobtention', 'anneeobtention');"
                                               onblur="sauvegarderValeursDansChampCache('moisobtention', 'anneeobtention', 0, 'dateobtention1');">
                                        <label for='anneeobtention'> Année </label>
                                        <input type='text' id='anneeobtention' name='anneeobtention' style='width: 30px;' maxlength='2'
                                               onblur="sauvegarderValeursDansChampCache('moisobtention', 'anneeobtention', 0, 'dateobtention1');">
                                        <a href="#" class="infobulle-gauche">
                                            <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                            <span>Mois et année d'obtention<br/>Strictement deux chifffres. Ex: 01</span>
                                        </a><br/>
                                        <input type="hidden" id="dateobtention1" name="dateobtention1">
                                    </td>
                                </tr>
                            </table>

                            <label for='discipline'>Discipline ou spécialisation</label><br/>
                            <input type='text' id='discipline' name='discipline'><br/>

                            <a href='#' class='linkeffacer'
                               onclick="viderDiplomeUniversitaire('diplome1', 'nomdiplome1', 'nominstitut1', 'fromyear', 'toyear', 'moisobtention', 'anneeobtention', 'discipline', 'periodefrequentation1', 'dateobtention1');">
                                Effacer
                            </a>   

                            <br/><br/><br/><br/><br/><br/>



                            <input type='checkbox' id='diplome2' name='diplome2'>
                            <label for='diplome2'>Grade ou diplôme de niveau universitaire le plus récent entrepris ou complété</label>
                            <br/><br/>

                            <label for='nomdiplome2'>Nom du diplôme</label><br/>                        
                            <input type='text' id='nomdiplome2' name='nomdiplome2'>

                            <select id="obtenu2" name="obtenu2">
                                <option value="Obtenu">Obtenu</option>
                                <option value="A Obtenir">À Obtenir</option>  
                                <option value="Ne sera pas obtenu">Ne sera pas obtenu</option>
                            </select><br/>

                            <label for='nominstitut2'> Institution où vous avez poursuivi vos études en vue de l'obtention de ce diplôme</label><br/>
                            <input type='text' id='nominstitut2' name='nominstitut2'><br/>

                            <table>
                                <tr>
                                    <td>
                                        <label for='fromyear2'>Période de fréquentation</label><br/>
                                        <label for='fromyear2'>De </label>
                                        <input type='text' id='fromyear2' name='fromyear2' style='width: 30px;' maxlength='2'
                                               onkeyup="changerDeBoite('fromyear2', 'toyear2');"
                                               onblur="sauvegarderValeursDansChampCache('fromyear2', 'toyear2', 0, 'periodefrequentation2');">
                                        <label for='toyear2'> à </label>
                                        <input type='text' id='toyear2' name='toyear2' style='width: 30px;' maxlength='2'
                                               onblur="sauvegarderValeursDansChampCache('fromyear2', 'toyear2', 0, 'periodefrequentation2');">
                                        <a href="#" class="infobulle-gauche">
                                            <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                            <span>De (année) à (année)<br/>Strictement deux chifffres. Ex: 01</span>
                                        </a><br/>
                                        <input type="hidden" id="periodefrequentation2" name="periodefrequentation2">
                                    </td>
                                    <td>
                                        <label for='moisobtention2'>Date d'obtention</label><br/>
                                        <label for='moisobtention2'>Mois </label>
                                        <input type='text' id='moisobtention2' name='moisobtention2' style='width: 30px;' maxlength='2'
                                               onkeyup="changerDeBoite('moisobtention2', 'anneeobtention2');"
                                               onblur="sauvegarderValeursDansChampCache('moisobtention2', 'anneeobtention2', 0, 'dateobtention2');">
                                        <label for='anneeobtention2'> Année </label>
                                        <input type='text' id='anneeobtention2' name='anneeobtention2' style='width: 30px;' maxlength='2'
                                               onblur="sauvegarderValeursDansChampCache('moisobtention2', 'anneeobtention2', 0, 'dateobtention2');">
                                        <a href="#" class="infobulle-gauche">
                                            <img class="help-img-gauche" src="img/help-white.png" alt="aide">
                                            <span>Mois et année d'obtention<br/>Strictement deux chifffres. Ex: 01</span>
                                        </a><br/>
                                        <input type="hidden" id="dateobtention2" name="dateobtention2">
                                    </td>
                                </tr>
                            </table>

                            <label for='discipline2'>Discipline ou spécialisation</label><br/>
                            <input type='text' id='discipline2' name='discipline2'><br/>                                                                                

                            <a href='#' class='linkeffacer'                                
                               onclick="viderDiplomeUniversitaire('diplome2', 'nomdiplome2', 'nominstitut2', 'fromyear2', 'toyear2', 'moisobtention2', 'anneeobtention2', 'discipline2', 'periodefrequentation2', 'dateobtention2');">
                                Effacer
                            </a>  

                        </div>
                    </div>    
                    <div id="partie6">    
                        <div id='emplois' class='emplois'>
                            <div class="boxUneLigne"><br/><p>(Si cette section ne s'applique pas à votre cas, passez à la denière page du formulaire)</p>
                                <p>Veuillez indiquer les emplois que vous avez occupés en commençant par le plus récent. Les
                                    expériences professionnelles et le bénévolat peuvent être considérés à l'admission.</p>
                                <p>Il est essentiel de joindre les attestations des employeurs ou des responsables. En plus de
                                    confirmer la durée et la nature des emplois occupés, les attestations doivent contenir une brève
                                    description des fonctions des tâches accomplies. Le curriculum vitae ne peut d'aucune manière
                                    être considéré comme une preuve d'emploi. L'absence d'attestation(s) peut entraîner le refus d'admission.</p>
                                <br/>
                            </div>

                            <table>
                                <tr>
                                    <td>
                                        <label for='nomemployeur1'>Nom de l'employeur</label><br/>
                                        <input type='text' id='nomemployeur1' name='nomemployeur1'>
                                    </td>
                                    <td>
                                        <label for='typeemploi1'>Type d'emploi</label><br/>
                                        <input type='text' id='typeemploi1' name='typeemploi1'>
                                    </td>
                                    <td>
                                        <label for='ajointe1'>Attestation - ex: 00-11-22</label><br/>
                                        <input type='radio' id='ajointe1' name='ajointe1' checked='checked' value='jointe' 
                                               onclick="$('#dateexp1').attr('disabled', 'disabled');
                                                       $('#dateexp1').val('');">
                                        <label for='ajointe1'>jointe </label>
                                        <input type='radio' id='avenir1' name='ajointe1' value='à venir' onclick="$('#dateexp1').removeAttr('disabled');"><label for='avenir1'>à venir</label>
                                        <input type='text' id='dateexp1' name='dateexp1' disabled='disabled' placeholder="Date d'expédition" style='width: 115px;'>
                                    </td>
                                    <td>
                                        <label for='demois1'>Durée de l'emploi (2 chiffres, ex: 01)</label><br/>
                                        <label for='demois1'>de </label>
                                        <input type='text' id='demois1' name='demois1' placeholder='mois' style='width: 40px;' maxlength='2' 
                                               onkeyup="changerDeBoite('demois1', 'deannee1');">
                                        <input type='text' id='deannee1' name='deannee1' placeholder='année' style='width: 40px;' maxlength='2' 
                                               onkeyup="changerDeBoite('deannee1', 'amois1');">
                                        <label for='amois1'> à </label>
                                        <input type='text' id='amois1' name='amois1' placeholder='mois' style='width: 40px;' maxlength='2' 
                                               onkeyup="changerDeBoite('amois1', 'aannee1');">
                                        <input type='text' id='aannee1' name='aannee1' placeholder='année' style='width: 40px;' maxlength='2'>

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <a href='#' class='linkeffacer'                                            
                                           onclick="viderChampsEmploi('nomemployeur1', 'typeemploi1', 'dateexp1', 'demois1', 'deannee1', 'amois1', 'aannee1', 'ajointe1');">
                                            Effacer emploi 1
                                        </a>                                        
                                    </td>
                                </tr>



                                <tr>
                                    <td>
                                        <label for='nomemployeur2'>Nom de l'employeur</label><br/>
                                        <input type='text' id='nomemployeur2' name='nomemployeur2'>
                                    </td>
                                    <td>
                                        <label for='typeemploi2'>Type d'emploi</label><br/>
                                        <input type='text' id='typeemploi2' name='typeemploi2'>
                                    </td>
                                    <td>
                                        <label for='ajointe2'>Attestation - ex: 00-11-22</label><br/>
                                        <input type='radio' id='ajointe2' name='ajointe2' checked='checked' value='jointe' 
                                               onclick="$('#dateexp2').attr('disabled', 'disabled');
                                                       $('#dateexp2').val('');">
                                        <label for='ajointe2'>jointe </label>
                                        <input type='radio' id='avenir2' name='ajointe2' value='à venir' onclick="$('#dateexp2').removeAttr('disabled');"><label for='avenir2'>à venir</label>
                                        <input type='text' id='dateexp2' name='dateexp2' disabled='disabled' placeholder="Date d'expédition" style='width: 115px;'>
                                    </td>
                                    <td>
                                        <label for='demois2'>Durée de l'emploi (2 chiffres, ex: 01)</label><br/>
                                        <label for='demois2'>de </label>
                                        <input type='text' id='demois2' name='demois2' placeholder='mois' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('demois2', 'deannee2');">
                                        <input type='text' id='deannee2' name='deannee2' placeholder='année' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('deannee2', 'amois2');">
                                        <label for='amois2'> à </label>
                                        <input type='text' id='amois2' name='amois2' placeholder='mois' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('amois2', 'aannee2');">
                                        <input type='text' id='aannee2' name='aannee2' placeholder='année' style='width: 40px;' maxlength='2'>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4" style="text-align: center;">
                                        <a href='#' class='linkeffacer'
                                           onclick="viderChampsEmploi('nomemployeur2', 'typeemploi2', 'dateexp2', 'demois2', 'deannee2', 'amois2', 'aannee2', 'ajointe2');">
                                            Effacer emploi 2
                                        </a>                                        
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label for='nomemployeur3'>Nom de l'employeur</label><br/>
                                        <input type='text' id='nomemployeur3' name='nomemployeur3'>
                                    </td>
                                    <td>
                                        <label for='typeemploi3'>Type d'emploi</label><br/>
                                        <input type='text' id='typeemploi3' name='typeemploi3'>
                                    </td>
                                    <td>
                                        <label for='ajointe3'>Attestation - ex: 00-11-22</label><br/>
                                        <input type='radio' id='ajointe3' name='ajointe3' checked='checked' value='jointe' 
                                               onclick="$('#dateexp3').attr('disabled', 'disabled');
                                                       $('#dateexp3').val('');">
                                        <label for='ajointe3'>jointe </label>
                                        <input type='radio' id='avenir3' name='ajointe3' value='à venir' onclick="$('#dateexp3').removeAttr('disabled');"><label for='avenir3'>à venir</label>
                                        <input type='text' id='dateexp3' name='dateexp3' disabled='disabled' placeholder="Date d'expédition" style='width: 115px;'>                                        
                                    </td>
                                    <td>
                                        <label for='demois3'>Durée de l'emploi (2 chiffres, ex: 01)</label><br/>
                                        <label for='demois3'>de </label>
                                        <input type='text' id='demois3' name='demois3' placeholder='mois' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('demois3', 'deannee3');">
                                        <input type='text' id='deannee3' name='deannee3' placeholder='année' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('deannee3', 'amois3');">
                                        <label for='amois3'> à </label>
                                        <input type='text' id='amois3' name='amois3' placeholder='mois' style='width: 40px;' maxlength='2' onkeyup="changerDeBoite('amois3', 'aannee3');">
                                        <input type='text' id='aannee3' name='aannee3' placeholder='année' style='width: 40px;' maxlength='2'>                                       
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <a href='#' class='linkeffacer'
                                           onclick="viderChampsEmploi('nomemployeur3', 'typeemploi3', 'dateexp3', 'demois3', 'deannee3', 'amois3', 'aannee3', 'ajointe3');">
                                            Effacer emploi 3
                                        </a>
                                    </td>
                                </tr>


                            </table>
                        </div>
                    </div>

                    <div id="partie7">
                        <div class="boxUneLigne">
                            <br/>
                            <p>Veuillez indiquer toute autre expérience, différente d’un emploi,
                                qui vous semble pertinente à votre demande d’admission.<br/>
                                Il peut s’agir de publications, de recherches, de contributions
                                intellectuelles ou professionnelles. 
                            </p><br/>
                        </div>
                        <div class="boxUneLigne">
                            <textarea name="commentaire" id="commentaire" placeholder="Votre texte..."></textarea>
                        </div>

                        <div class="boxUneLigne">
                            <br/>
                            <input type='checkbox' id='signature1' name='signature1'>
                            <label for='signature1'>J’ai pris connaissance des renseignements ci-joints concernant la Loi sur l’accès aux documents des organismes
                                publics et sur la protection des renseignements personnels. Je consens à ce que l’UQAM transmette aux parties énumérées dans les instructions
                                d’admission les informations qui y sont décrites.</label>
                            <a href="#" class="infobulle-gauche">
                                <img class="help-img-gauche" src="img/help-white.png" alt="aide"><span>En cas d’opposition, remplir, signer<br/>et envoyer une déclaration d’opposition</span>
                            </a><br/><br/>
                            <input type='checkbox' id='signature2' name='signature2'>
                            <label for='signature2'> J’autorise les établissements d’enseignement collégial que j’ai fréquentés, ainsi que le ministère l’Enseignement supérieur, de la
                                Recherche et de la Science (MESRS) à communiquer à l’UQAM, par l’entremise du Bureau de coopération interuniversitaire (BCI),
                                les relevés de notes nécessaires à l’évaluation de mon dossier. J’autorise, en tout temps, les établissements d’enseignement que
                                j’ai fréquentés, au Québec ou ailleurs, à transmettre à l’UQAM, copie officielle des documents nécessaires à l’évaluation de mon
                                dossier en vue d’une admission, d’une inscription ou d’une reconnaissance d’acquis, ou de tout autre document versé à mon
                                dossier à ces fins et ce, même si les documents qui ont déjà été déposés à mon dossier étaient des originaux.
                                J’autorise l’UQAM à transmettre au BCI les renseignements nécessaires à la gestion des admissions et à la production de statistiques
                                qui pourraient requérir le couplage des fichiers d’établissements. En vertu d’une entente autorisée par la Commission d’accès
                                à l’information, les renseignements nécessaires à la création et à la validation du code permanent seront transmis au MESRS;
                                j’autorise l’UQAM à obtenir du MESRS ces renseignements. J’autorise aussi que les renseignements nécessaires à la gestion des
                                admissions relatifs à l’établissement fréquenté, et ceux sur la citoyenneté pour établir mes droits de scolarité, puissent faire l’objet
                                d’une validation auprès du MESRS. J’autorise également le ministère de l’Immigration, de la Diversité et de l’Inclusion (MIDI) à
                                transmettre à l’UQAM la confirmation de l’émission, le cas échéant, d’un Certificat d’acceptation du Québec (CAQ) à mon nom.
                                Je déclare que les renseignements donnés dans ce formulaire sont exacts et je m’engage à respecter les règlements de l’UQAM. 
                            </label>
                        </div>
                        <div class="boxUneLigne">
                            <br/>
                            <input id="submitbouton" type="submit" value="Envoyer"/>
                            <input id="resetbouton" type="reset" value="Vider"/>

                        </div>
                    </div>
                </form>
            </section>
            <footer>  
                <img id="leftBannerScrollerfooter" src="img/leftBannerScrollerDisable.png"  alt="fleche de gauche"
                     onclick='formulairePrecedent();'
                     onmouseover='changerImageGauche(this);' 
                     onmouseout='remettreImageGauche(this);'>

                <img id ="rightBannerScrollerfooter" src="img/rightBannerScroller.png" alt="fleche de droite"
                     onclick='formulaireSuivant();' 
                     onmouseover='changerImageDroite(this);' 
                     onmouseout='remettreImageDroite(this);' >                
            </footer>
        </article>
    </body>

</html>