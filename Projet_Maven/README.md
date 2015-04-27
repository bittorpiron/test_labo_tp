# equipe21 - Projet Session INF2015
# Refund v1.2

Logiciel qui calcule des remboursements de réclamations d'assurances de soins de santé.

Le logiciel ne possède pas d'interface utilisateur car il est destiné à être invoqué à partir d'une
application web (pas du "back-end").

##Technologies utilisées
- Logiciel développé avec le langage de programmation Java (JDK8).
- Environnement de développement intégré NetBeans 8.0 ou plus.
- Les fichiers d'entrées et de sorties sont des documents JSON.
- Les sources entreposées dans un ce dépôt GIT sous github.
- La construction de ce projet est maintenue par Maven.

##Commande principale

 - java -jar Refund.jar inputfile.json refunds.json

	Ce programme prend comme argument un fichier d'entrée contenant les demandes de réclamations d'assurances de soins de santé et calcule les montants à rembourser. Le fichier de sortie devra également être spécifié à la console.

##Commandes pour les statistiques

 - java Refund.jar -S 

	Pour l'affichage des statistiques.

 - java Refund.jar -SR

	Pour la réinitialisation des statistiques.

Voici un exemple de fichier à utiliser:
 ```
{
    "dossier": "A123456",
    "mois": "2015-01",
    "reclamations": [
        {
            "soin": 100,
            "date": "2015-01-11",
            "montant": "100.00$"
        },
        {
            "soin": 175,
            "date": "2015-02-14",
            "montant": "130.00$"
        }
    ]
}
