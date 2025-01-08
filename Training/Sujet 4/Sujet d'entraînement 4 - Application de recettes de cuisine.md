## 📝 Contexte
Créez une application Android nommée **CookBook** qui permet aux utilisateurs de rechercher, sauvegarder et organiser des recettes de cuisine. Chaque recette inclut :
- 🍽️ Un titre,
- 📝 Une liste d’ingrédients,
- 📖 Des étapes de préparation,
- 📸 Une photo de présentation.

---

## 🚀 Fonctionnalités attendues

1. **🏠 Accueil et navigation** :
   - Une page d'accueil affichant les recettes récemment ajoutées.
   - Un menu pour naviguer entre :
     - 📋 Liste des recettes.
     - ➕ Ajout d'une recette.
     - 🌟 Recettes favorites.

2. **📋 RecyclerView** :
   - Liste des recettes avec leur titre et leur photo.
   - Possibilité de marquer une recette comme favorite.

3. **🔄 Navigation entre fragments** :
   - Fragments pour :
     - **Liste des recettes.**
     - **Détails d'une recette.**
     - **Ajout/Modification d'une recette.**

4. **🔍 Recherche et filtres** :
   - Recherchez des recettes par nom ou par ingrédient.
   - Filtrez par catégorie (entrée, plat, dessert).

5. **💾 Persistance avec Room** :
   - Sauvegardez les recettes localement.
   - Implémentez les fonctionnalités CRUD.

---

## ⚙️ Contraintes techniques
- Utilisez une architecture moderne avec :
  - 🧭 Navigation Component.
  - 📊 ViewModel et LiveData.
- Implémentez Room pour gérer les recettes.
- Ajoutez des validations pour empêcher les recettes incomplètes.

---

## ✨ Suggestions pour aller plus loin (bonus)
- ⏲️ Ajoutez un minuteur intégré pour suivre les étapes de préparation.
- 🧑‍🍳 Proposez des recettes suggérées en fonction des ingrédients disponibles.
- 🔖 Ajoutez une option de partage de recettes via les réseaux sociaux.

---

## 📂 Livrables
- Un fichier `.apk` fonctionnel.
- Un dossier ZIP contenant le code source.
- Une documentation expliquant les fonctionnalités principales.
