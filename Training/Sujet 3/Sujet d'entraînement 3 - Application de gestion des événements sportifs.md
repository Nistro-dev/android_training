## 📝 Contexte
Créez une application Android nommée **SportManager** qui permet aux utilisateurs de suivre et d’organiser des événements sportifs locaux (matches, tournois, entraînements, etc.). Chaque événement doit inclure :
- 🏷️ Un nom,
- 📅 Une date et une heure,
- 🏟️ Un lieu,
- 🏆 Une description.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
   - Une page d'accueil qui liste les événements sportifs à venir.
   - Un menu permettant de naviguer entre :
     - 📋 Liste des événements.
     - 🗺️ Carte pour visualiser les lieux des événements.
     - ➕ Ajout d'un événement.

2. **📋 RecyclerView** :
   - Affichez les événements dans une liste avec le nom, la date et le lieu.
   - Permettez de cliquer sur un événement pour en voir les détails ou le modifier.

3. **🔄 Navigation entre fragments** :
   - Fragments pour :
     - **Liste des événements.**
     - **Détails d'un événement.**
     - **Ajout/Modification d'un événement.**

4. **🗺️ Cartographie** :
   - Utilisez une carte pour localiser les événements.
   - Ajoutez une option pour afficher uniquement les événements dans un rayon de 10 km.

5. **💾 Persistance avec Room** :
   - Sauvegardez les événements localement.
   - Implémentez les fonctionnalités CRUD (ajouter, modifier, supprimer).

6. **📊 ViewModel et LiveData** :
   - Gérez les données avec ViewModel et LiveData.

---

## ⚙️ Contraintes techniques
- Utilisez **OpenStreetMap** 🗺️ pour la cartographie (via un outil comme [osmdroid](https://github.com/osmdroid/osmdroid)).
- Utilisez les composants modernes de l'architecture Android :
  - 🧭 Navigation Component.
  - 📊 ViewModel et LiveData.
- Implémentez une persistance locale avec Room.

---

## ✨ Suggestions pour aller plus loin (bonus)
- 🔔 Ajoutez des notifications pour rappeler les événements à venir.
- 🏆 Intégrez un système de gestion des équipes pour les compétitions.
- 📸 Ajoutez une photo ou un logo pour chaque événement.

---

## 📂 Livrables
- Un fichier `.apk` fonctionnel.
- Un dossier ZIP contenant le code source.
- Une brève documentation expliquant le fonctionnement de l'application et les choix techniques.
