
## 📝 Contexte

Développez une application Android nommée **DataKeeper** permettant aux utilisateurs de gérer des enregistrements personnels. Chaque enregistrement contient :

- 🏷️ Un titre,
- 📝 Une description,
- 📆 Une date de création,
- 📂 Une catégorie.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
    
    - Une page d'accueil affichant une liste d'enregistrements triés par date de création.
    - Un menu permettant d'accéder aux fonctionnalités suivantes :
        - 📋 Liste complète des enregistrements.
        - ➕ Ajout d'un nouvel enregistrement.
        - 🔍 Recherche d'enregistrements par catégorie.
2. **📋 RecyclerView** :
    
    - Affichez les enregistrements dans une liste avec leur titre, catégorie, et date de création.
    - Permettez à l'utilisateur de cliquer sur un enregistrement pour voir ses détails ou le modifier.
3. **🔄 Navigation entre fragments** :
    
    - Fragments pour :
        - **Liste des enregistrements.**
        - **Détails d'un enregistrement.**
        - **Ajout/Modification d'un enregistrement.**
4. **💾 Persistance avec Room** :
    
    - Implémentez une base de données locale pour stocker les enregistrements avec les opérations suivantes :
        - ➕ Ajouter un nouvel enregistrement.
        - ✏️ Modifier un enregistrement existant.
        - ❌ Supprimer un enregistrement.
5. **📊 ViewModel et LiveData** :
    
    - Gérez les données avec un `ViewModel` et `LiveData` pour une mise à jour automatique de l'interface utilisateur.

---

## ⚙️ Contraintes techniques

- Utilisez une architecture moderne d'Android :
    - 🧭 Navigation Component.
    - 📊 ViewModel et LiveData.
- Gérez les opérations CRUD avec Room.
- Ajoutez une validation pour éviter les enregistrements avec des champs vides.

---

## ✨ Suggestions pour aller plus loin (bonus)

- 🔔 Ajoutez une notification pour rappeler à l'utilisateur de consulter ses enregistrements après une période définie.
- 📊 Ajoutez des statistiques sur le nombre d'enregistrements par catégorie.
- 🌈 Ajoutez la possibilité de personnaliser les catégories avec des couleurs.

---

## 📂 Livrables

- Un fichier `.apk` fonctionnel.
- Un dossier ZIP contenant le code source.
- Une documentation expliquant le fonctionnement de l'application et les choix techniques.

---