## 📝 Contexte
Vous devez développer une application Android nommée **TaskTracker** permettant aux utilisateurs de gérer leurs tâches quotidiennes avec une dimension géographique. Chaque tâche doit inclure :
- 🏷️ Un titre,
- 📝 Une description,
- 🗓️ Une date limite,
- 📍 Une localisation (latitude et longitude) optionnelle.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
   - L'application doit comporter un menu principal permettant d'accéder aux fonctionnalités suivantes :
     - 📋 Liste des tâches.
     - 🗺️ Carte pour visualiser les tâches géolocalisées.
     - ➕ Ajout d'une nouvelle tâche.

2. **📋 RecyclerView** :
   - Affichez les tâches dans une liste utilisant une `RecyclerView`. Chaque élément doit inclure le titre, la description, et la date limite.
   - Permettez à l'utilisateur de cliquer sur une tâche pour voir ses détails dans une autre page.

3. **🔄 Navigation entre fragments** :
   - Utilisez plusieurs fragments pour gérer la navigation :
     - **Fragment de liste** : Affiche la liste des tâches.
     - **Fragment de détails** : Affiche les informations détaillées d’une tâche sélectionnée.
     - **Fragment d’ajout/modification** : Permet d’ajouter ou de modifier une tâche.

4. **🗺️ Cartographie (OpenStreetMap)** :
   - Ajoutez une carte dans l'application pour afficher toutes les tâches avec une localisation sous forme de marqueurs.
   - Permettez à l'utilisateur de cliquer sur un marqueur pour afficher les détails de la tâche.

5. **📊 ViewModel et LiveData** :
   - Gérez les données des tâches en utilisant un `ViewModel` et `LiveData`.
   - Assurez que la liste des tâches et la carte se mettent à jour automatiquement lorsque les données changent.

6. **💾 Persistance avec Room** :
   - Sauvegardez les tâches dans une base de données locale en utilisant Room.
   - Implémentez les opérations suivantes :
     - ➕ Ajouter une nouvelle tâche.
     - ✏️ Modifier une tâche existante.
     - ❌ Supprimer une tâche.
     - ✅ Marquer une tâche comme terminée.

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

- 🔔 Ajoutez une notification pour rappeler à l'utilisateur les tâches proches de leur date limite.
- 🌐 Permettez de filtrer les tâches par proximité géographique ou par date.
- 📸 Ajoutez une option pour associer une image à chaque tâche.
- 📂 Exportez la liste des tâches sous forme de fichier CSV.

---

## 📂 Livrables
- Un fichier `.apk` fonctionnel.
- Un dossier ZIP contenant le code source.
- Une brève documentation expliquant le fonctionnement de l'application et les choix techniques.
