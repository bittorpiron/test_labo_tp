<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
            <title>Démonstration 6 - PHP</title>
            <link rel="stylesheet" type="text/css" href="style.css">
                <meta name="author" content="Jonathan Des Rosiers">
                    
    </head>
    <body>
        
        <div id="page">
            
            <header>
                <h1><a href="#">Laboratoire #6</a></h1>
            </header>
            
            <nav>
                <ul>
                    <li><a href="index.php">Accueil</a></li>
                    <li><a href="login.php">Administration</a></li></ul>
            </nav>
            
            <article id="content">
                
                <h2>Page d'administration</h2>


                <?php
                    //Un code HTTP 500 pourrait être retourné pour une meilleur gestion des erreurs
                    $fileLogin = fopen("login.txt", "r") or die("Impossible d'ouvrir le fichier login.");
                    $loginReussit = false;
                    while(!feof($fileLogin)){
                           $login = fgets($fileLogin);
                           $tabLogin = explode(";",$login);
                        
                        
                           $userName = explode("$",$tabLogin[0]);
                        
                           $password = explode("$",$tabLogin[1]);
                           $password[1]=str_replace("\n","",$password[1]);
                        
                           if($userName[1] === $_POST["user"] && $password[1] === $_POST["password"]){
                               
                                echo "<p>Bonjour " .  $userName[1] . "<br>";
                                echo "Votre mot de passe est : " . $password[1] . "</p>";
                                fclose($fileLogin);
                               
                                echo "<h3>Modification de la page d'accueil</h3>";
                                echo "<form method=\"post\" action=\"modifier.php\">";
                                echo "<label for=\"contenu\">Texte de la page principale :</label>";
                                echo "<textarea cols=\"40\" rows=\"20\" id=\"contenu\" name=\"contenu\" type=\"text\">";
                               
                                $fileAccueil = fopen("accueil.txt", "r") or die("Impossible d'ouvrir le fichier accueil.");
                                $text = fread($fileAccueil,filesize("accueil.txt"));
                                echo $text;
                                fclose($fileAccueil);
                               
                                echo "</textarea><br>";
                                echo "<input type=\"submit\" value=\"Modifier\">";
                                echo "</form>";
                           
                                echo "<h3>Ajout d'un utilisateur</h3>";
                                echo "<form method=\"post\" action=\"ajouter.php\">";
                                echo "<label for=\"username\">Nom d'utilisateur :</label><input id=\"username\" name=\"username\" type=\"text\">";
                                echo "<br>";
                                echo "<label for=\"password\">Mot de passe :</label><input id=\"password\" name=\"password\" type=\"text\">";
                                echo "<br>";
                                echo "<input type=\"submit\" value=\"Ajouter\"></form>";
                            
                                $loginReussit = true;
                                break;
                           }
                    }
                if(!$loginReussit){
                    echo "<p>nom d'utilisateur ou mot de passe incorrect</p>";
                }
                    
                ?>
                
                

                
                
            </article>
            
            <aside>
                
                <h3>Lien vers d'autres articles</h3>
                <ul>
                    <li><a href="#">Proin at</a></li>
                    <li><a href="#">Class aptent taciti</a></li>
                    <li><a href="#">Morbi in dolor</a></li>
                    <li><a href="#">Praesent ultricies</a></li>
                    <li><a href="#">Aenean euismod</a></li>
                    <li><a href="#">Donec sempe</a></li>
                    <li><a href="#">Suspendisse potenti</a></li>
                </ul>
                
                
            </aside>
            
            <div class="espacement"> </div>
            
            <div id="columns">
                
                <article id="column1">
                    <h3>Blog #1</h3>
                    <p>Suspendisse potenti. Aliquam hendrerit elit in leo tempor eu molestie orci molestie. Morbi in dolor dolor, eget aliquet turpis. Praesent ultricies velit ac ipsum tristique blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                </article>
                
                <article id="column2">
                    <h3>Blog #2</h3>
                    <p>
                    Suspendisse potenti. Aliquam hendrerit elit in leo tempor eu molestie orci molestie. Morbi in dolor dolor, eget aliquet turpis. Praesent ultricies velit ac ipsum tristique blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    </p>
                </article>
                
                <article id="column3">
                    <h3>Blog #3</h3>
                    <p>
                    Suspendisse potenti. Aliquam hendrerit elit in leo tempor eu molestie orci molestie. Morbi in dolor dolor, eget aliquet turpis. Praesent ultricies velit ac ipsum tristique blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    </p>
                </article>
                
                <div class="espacement"> </div>
            </div>
            
            <footer>
                <p> Exercice css </p>
            </footer>
            
        </div>
        
    </body>
</html>
