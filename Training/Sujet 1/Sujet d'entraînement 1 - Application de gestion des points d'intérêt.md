## 📝 Contexte
Vous devez développer une application Android nommée **ExploreApp** permettant aux utilisateurs de gérer une liste de points d'intérêt (POI) qu'ils souhaitent visiter. Chaque POI doit inclure :
- 🏷️ Un nom,
- 📝 Une description,
- 📍 Une localisation (latitude et longitude),
- 🖼️ Une photo optionnelle.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
   - L'application doit comporter une page d'accueil avec un menu permettant d'accéder aux fonctionnalités suivantes :
     - 📋 Liste des points d'intérêt.
     - 🗺️ Carte pour afficher les POI.
     - ➕ Ajout d'un nouveau POI.

2. **📋 RecyclerView** :
   - Affichez les POI dans une liste utilisant une `RecyclerView`. Chaque élément doit inclure le nom, la description, et un aperçu de la photo.
   - Permettez à l'utilisateur de cliquer sur un POI pour voir ses détails dans une autre page.

3. **🔄 Navigation entre fragments** :
   - Utilisez plusieurs fragments pour gérer la navigation :
     - **Fragment de liste** : Affiche la liste des POI.
     - **Fragment de détails** : Affiche les informations détaillées d’un POI sélectionné.
     - **Fragment d’ajout** : Permet d’ajouter un nouveau POI.

4. **🗺️ Cartographie (OpenStreetMap)** :
   - Ajoutez une carte dans l'application pour afficher tous les POI sous forme de marqueurs.
   - Permettez à l'utilisateur de cliquer sur un marqueur pour afficher les détails du POI.

5. **📊 ViewModel et LiveData** :
   - Gérez les données des POI en utilisant un `ViewModel` et `LiveData`.
   - Assurez la mise à jour automatique de l'interface utilisateur lorsque les données changent.

6. **💾 Persistance avec Room** :
   - Sauvegardez les POI dans une base de données locale en utilisant Room.
   - Implémentez les opérations suivantes :
     - ➕ Ajouter un nouveau POI.
     - ✏️ Modifier un POI existant.
     - ❌ Supprimer un POI.

---

## ⚙️ Contraintes techniques
- Utilisez **OpenStreetMap** 🗺️ pour la cartographie (via un outil comme [osmdroid](https://github.com/osmdroid/osmdroid)).
- Utilisez des composants modernes de l'architecture Android :
  - 🧭 Navigation Component.
  - 📊 ViewModel.
  - 🔄 LiveData.
- Gérez les opérations CRUD avec Room.

---

## ✨ Suggestions pour aller plus loin (bonus)

- 📸 Ajoutez une fonctionnalité pour prendre une photo avec la caméra ou la sélectionner dans la galerie lors de l’ajout d’un POI.
- 🔍 Implémentez une recherche par nom ou description dans la liste des POI.
- ✅ Ajoutez une validation pour empêcher l’enregistrement de POI avec des champs vides.

---

## 📂 Livrables
- Un fichier `.apk` fonctionnel.
- Un dossier ZIP contenant le code source.
- Une brève documentation expliquant le fonctionnement de l'application et les choix techniques.
