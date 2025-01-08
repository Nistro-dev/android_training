## 📝 Contexte
Créez une application Android nommée **HabitTracker** permettant aux utilisateurs de créer et de suivre leurs habitudes quotidiennes ou hebdomadaires. Chaque habitude inclut :
- 🏷️ Un titre,
- 🕒 Une fréquence (quotidienne, hebdomadaire, etc.),
- 📈 Un suivi de progression.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
   - Une page d'accueil affichant les habitudes en cours.
   - Un menu permettant de naviguer entre :
     - 📋 Liste des habitudes.
     - ➕ Ajout d'une nouvelle habitude.
     - 📊 Statistiques de progression.

2. **📋 RecyclerView** :
   - Liste des habitudes avec leur titre et leur statut (en cours/complétée).
   - Possibilité de marquer une habitude comme accomplie.

3. **🔄 Navigation entre fragments** :
   - Fragments pour :
     - **Liste des habitudes.**
     - **Détails d'une habitude.**
     - **Ajout/Modification d'une habitude.**

4. **📊 Statistiques** :
   - Affichez des graphiques pour visualiser la progression des habitudes.

5. **💾 Persistance avec Room** :
   - Sauvegardez les habitudes localement.
   - Implémentez les fonctionnalités CRUD.

---

## ⚙️ Contraintes techniques
- Utilisez une architecture moderne (Navigation Component, ViewModel, LiveData).
- Gérez les données des habitudes avec Room.
- Implémentez un graphique simple (par exemple, avec MPAndroidChart).

---

## ✨ Suggestions pour aller plus loin (bonus)
- 🔔 Ajoutez des rappels pour chaque habitude.
- 🎯 Proposez des récompenses pour motiver l'utilisateur à accomplir ses habitudes.
- 🏆 Intégrez un système de points pour les habitudes accomplies.

---

## 📂 Livrables
- Un fichier `.apk` fonctionnel.
- Le code source organisé dans un dossier ZIP.
- Une documentation avec captures d’écran.
