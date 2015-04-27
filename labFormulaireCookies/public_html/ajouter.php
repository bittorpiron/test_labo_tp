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
                    <li><a href="login.php">Administration</a></li>
                </ul>
            </nav>
            
            <article id="content">
                
                <h2>Message de confirmation</h2>
                
                <p>
                    <?php
                        $user = $_POST["user"];
                        $password = $_POST["password"];
                        if(strpos($user,'$') !== false || strpos($user,';')!== false || strpos($password,'$') !== false|| strpos($password,';') !== false){
                            echo "L'utilisateur ou le mot de passe ne doit pas contenir de $ ou de ;";
                        }
                        else if($user === "" || $password === ""){
                            echo "L'utilisateur ou le mot de passe ne doit pas être vide";
                        }
                        else{
                        $stringToAdd = PHP_EOL . "Login$" . $user . "; " . "password$" . $password ;
                        echo "Utilisateur ajouté : " . $user . "<br>";
                        echo "Mot de passe : " . $password  ;
                        //Un code HTTP 500 pourrait être retourné pour une meilleur gestion des erreurs
                        $file = fopen('login.txt', "c") or die("Impossible d'ouvrir le fichier login.");
                        fseek($file, 0, SEEK_END);
                        fwrite($file, $stringToAdd);
                        fclose($file);
                        }
                    ?>
                </p>
                
                
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
