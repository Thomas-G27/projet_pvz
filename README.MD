# Projet PvZ Thomas GOMBERT

## Objectif du projet

L'objectif de ce projet etait de nous familiariser avec les technologies suivantes
- **Spring MVC**
- **JdbcTemplate**
- **MySQL**
- **Maven**
- **tomcat**
- **jakarta**
Ce sont donc les technologies que j'ai utiliser lors du développement de ce projet


L'application est déployable via un fichier `.war` sur un serveur **Apache Tomcat**.

---

## 📁 Structure de l'arborescence

```plaintext
src/main/java/com/oxyl/coursepfback/
|➔ controller/             # Contrôleurs REST (Spring MVC)
|➔ dao/
|   |➔ interfaces/         # Interfaces DAO (contrats)
|   └➔ implémentations DAO (accès base de données)
|➔ services/
|   |➔ interfaces/         # Interfaces Service (contrats)
|   └➔ implémentations Service (logique métier)
|➔ dto/
|   |➔ mapper/             # Mappers pour les conversion Entity ⇄ DTO
|➔ model/                  # Entities du projet (modèles Java)
|➔ config/                 # Configuration globale (CORS, etc)
```

Cette organisation permet un fonctionnement en couche.
Elle se sépare clairement :
- Les **contrôleurs** (interface utilisateur / API)
- La **logique métier** (services)
- L'**accès aux données** (DAO)
- Les **modèles** (entités) et leurs **DTOs**

---

##  Choix technologiques

| Technologie | Justification |
|:---|:---|
| **Java 21** | Version moderne, LTS, meilleures performances et syntaxe enrichie |
| **Spring MVC** | Framework robuste pour créer des API REST rapidement |
| **JDBC Template** | Léger pour les opérations de base sur MySQL sans ORM lourd |
| **MySQL 8** | Base de données relationnelle très populaire et performante |
| **Maven** | Gestionnaire de dépendances classique, bien intégré à Java |
| **Tomcat 10** | Serveur d’applications compatible Jakarta EE 10, stable pour WAR deployment |
| **Mockito** | Pour les test sans casser la base de données

---

## Les endpoints réalisé sont les suivants

- `GET /plantes`, `GET /zombies`, `GET /maps`
- `GET /plantes/{id}`, `GET /zombies/{id}`, `GET /maps/{id}`
- `POST /plantes`, `POST /zombies`, `POST /maps`
- `PUT /plantes/{id}`, `PUT /zombies/{id}`, `PUT /maps/{id}`
- `DELETE /plantes/{id}`, `DELETE /zombies/{id}`, `DELETE /maps/{id}`

Les Endpoints sont testé via les fonctions test des controller

---

## 🔗 Déploiement

- `mvn clean install` pour générer `CoursEpfBack.war`
- Déployer le WAR sur Tomcat dans le répertoire `webapps/`
- Accéder aux différentes adresse GET via : `http://localhost:8080/CoursEpfBack/` + l'adressage donné ci dessus

---

## Points d'attention

- Une "incompatibilité" avec le front a lieu sur la page de gestion des plantes. Bien que les plantes ne posent aucun problème sur les endpoints ou dans le jeu, je n'ai pas trouver de solution a ce problème, Zombie fonctionne parfaitement avec une structure identique.
- Un point similaire est à noté sur la création de map depuis l'appli (les endpoints fonctionnent). Également lors de la partie, la map n'apparait pas

---

## 📅 Plan d'évolution

- Ajout d'une vérification d'entrée (validation DTO)
- Sécurisation des endpoints avec un auth simple (JWT ou Basic Auth)

---