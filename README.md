# ProjetTutoreJavaS6PolytechToursPointeuse

## Présentation 

Projet de programmation d'un système de pointeuse. Projet réalisé dans le cadre du projet tutoré Java du sixième semestre du cycle ingénieur de Polytech Tours.

### Contenu

Le projet est composé de deux applications :

- **Une application centrale** : Permettant de superviser les pointages ainsi que les employés
- **Un émulateur de pointeuse** : Permettant d'effectuer des pointages

Les deux applications indépendantes communiquent via le réseau par le protocole TCP, l'émulateur de pointeuse étant le client qui envoie les pointages à l'application centrale étant le serveur qui les réceptionne et les stocke.

Pour les interfaces graphiques, c'est la librairie JavaFX qui aura été utilisée, les architectures de ces interfaces ont été faites en FXML et les styles en CSS.

### Structure

Le projet est composé d'un package principal ```fr.univtours.polytech.ptjavapointeuse``` séparé en trois packages qui délimitent les deux applications ainsi que leurs ressources communes. Les deux applications sont ensuite séparées en trois sous-packages modèle, vue et controleur conformément à l'architecture MVC.

Nous avons donc les trois packages suivants :

- ```fr.univtours.polytech.ptjavapointeuse.centralapp``` : L'application centrale
- ```fr.univtours.polytech.ptjavapointeuse.emulatorapp``` : L'émulateur de pointeuse
- ```fr.univtours.polytech.ptjavapointeuse.common``` : Les ressources communes aux deux applications (pour la communication réseau par exemple)

Dans les packages fr.univtours.polytech.ptjavapointeuse.centralapp et fr.univtours.polytech.ptjavapointeuse.emulatorapp nous trouvons donc des sous-packages :

- ```model``` : Les modèles, les classes correspondantantes à des entités tangibles qui peuvent donner lieu à des objets
- ```view``` : Les vues, les fichiers correspondants aux interfaces graphiques qui vont d'afficher à  l'écran ainsi que les ressources associées
- ```controller``` : Les controleurs, qui ne font pas partie des modèles ou des vues, permettant d'intéragir avec l'interface graphique et d'éffectuer d'autres opérations

L'arborescence est la suivante :

```
PT_JAVA_Pointeuse
│   .classpath
│   .project
│   build.fxbuild
│   Enterprise1.dat
│
├───doc
│   └─── ...
│
├───lib
│   └───javafx-sdk-12
│       └─── ...
│
└───src
    │   module-info.java
    │
    └───fr
        └───univtours
            └───polytech
                └───ptjavapointeuse
                    ├───centralapp
                    │   ├───controller
                    │   │       ACCheckInOutHistoryController.java
                    │   │       ACCreateDepartmentController.java
                    │   │       ACCreateEmployeeController.java
                    │   │       ACManageEmployeeController.java
                    │   │       ACParametersController.java
                    │   │       ACStaffManagementController.java
                    │   │       ACTodayCheckInOutHistoryController.java
                    │   │       CentralApplication.java
                    │   │       CentralApplicationController.java
                    │   │       CentralApplicationSerialization.java
                    │   │       TCPServerBuilder.java
                    │   │       TCPServerMessage.java
                    │   │       TestClass.java
                    │   │
                    │   ├───model
                    │   │       Check.java
                    │   │       Department.java
                    │   │       Employee.java
                    │   │       EmployeeCheck.java
                    │   │       EmployeeDept.java
                    │   │       Enterprise.java
                    │   │
                    │   └───view
                    │           ACCheckInOutHistoryView.fxml
                    │           ACCreateDepartmentView.fxml
                    │           ACCreateEmployeeView.fxml
                    │           ACManageEmployeeView.fxml
                    │           ACParametersView.fxml
                    │           ACStaffManagementView.fxml
                    │           ACTodayCheckInOutHistoryView.fxml
                    │           CentralApplicationView.fxml
                    │
                    ├───common
                    │       TCPBuffer.java
                    │       TCPMessage.java
                    │
                    └───emulatorapp
                        ├───controller
                        │       AEParametersController.java
                        │       ClockEmulator.java
                        │       ClockEmulatorController.java
                        │       ClockEmulatorLive.java
                        │       TCPClientBuilder.java
                        │       TCPClientMessage.java
                        │
                        ├───model
                        └───view
                                AEParametersView.fxml
                                application.css
                                background-clock.jpg
                                EmulatorApplicationView.fxml
```

## Manuel de l’utilisateur

### Lancer le programme

Voici les étapes à suivre afin de mettre en oeuvre le système de pointeuse :

1. Ouvrir Eclipse IDE
2. Ouvrir le projet avec Eclipse (Aller dans File > Open Projects from File System, sélectionner le répertoire ou l'archive et cliquer sur le bouton Finish)
3. Développer l'arborescence et ouvrir l'application centrale (```fr.univtours.polytech.ptjavapointeuse.centralapp.controller``` > ```CentralApplication.java``` > Clic droit > Run As > Java Application)
4. Développer l'arborescence et ouvrir l'émulateur de pointeuse (```fr.univtours.polytech.ptjavapointeuse.emulatorapp.controller``` > ```ClockEmulator.java``` > Clic droit > Run As > Java Application)

### Utiliser le programme

Voici les étapes afin d'utiliser le programme pour la première fois:

1. Aller dans l'application centrale et créer un employé (et si nécessaire un département)
2. Aller dans l'émulateur de pointeuse et saisir l'identifiant de l'employé pour lequel on veut pointer
3. Toutes les données sont sauvegardées à la fermeture du programme et récupérées à la réouverture

### Liste des fonctionnalités

- Créer/Visualiser/Mettre à jour/Supprimer un employé
- Créer un département dans l'entreprise
- Consulter la liste des employés de l'entreprise
- Consulter la liste des pointages
- Consulter la liste des pointages du jour
- Visualiser les paramètres réseau
- Créer un pointage pour un employé
