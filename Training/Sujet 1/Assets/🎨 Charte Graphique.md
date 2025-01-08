### **1. Palette de couleurs**

- **Couleurs principales** :
    
    - 🟠 **Orange vif** (#FF6F00) : Dynamisme et énergie, utilisé pour les boutons, les éléments interactifs.
    - 🔵 **Bleu profond** (#1E88E5) : Sérénité et technologie, utilisé pour les en-têtes et les menus.
- **Couleurs secondaires** :
    
    - 🟢 **Vert doux** (#43A047) : Éléments de confirmation ou succès.
    - 🔴 **Rouge clair** (#E53935) : Erreurs ou suppressions.
- **Couleurs neutres** :
    
    - ⚪ **Blanc pur** (#FFFFFF) : Fond principal pour maintenir une bonne lisibilité.
    - ⚫ **Gris foncé** (#212121) : Texte principal et éléments non prioritaires.
    - 🟤 **Gris clair** (#E0E0E0) : Bordures, séparateurs, et fonds secondaires.

---

### **2. Typographie**

- **Police principale** : [Roboto](https://fonts.google.com/specimen/Roboto)
    - Style : Sans-serif, moderne, lisible.
    - Poids :
        - **Bold** : Titres et boutons.
        - **Regular** : Texte descriptif et contenu.
        - **Light** : Labels ou placeholders.

---

### **3. Icônes et illustrations**

- **Style d'icônes** : Matérial Design ([Material Icons](https://fonts.google.com/icons)).
    
    - Consistants avec l'environnement Android.
    - Exemples :
        - 📋 Liste : `list_alt`.
        - 🗺️ Carte : `map`.
        - ➕ Ajout : `add_circle_outline`.
- **Illustrations** : Simples et minimalistes pour ne pas surcharger l'interface. Utilisation possible de [unDraw](https://undraw.co/) pour des éléments visuels.
    

---

### **4. Boutons et interactions**

- **Boutons primaires** :
    
    - Fond : 🟠 Orange vif (#FF6F00).
    - Texte : ⚪ Blanc (#FFFFFF).
    - Forme : Coins légèrement arrondis (4dp).
    - Effet : Élévation (ombre) et changement de teinte à l'appui.
- **Boutons secondaires** :
    
    - Bordure : 🟠 Orange vif (#FF6F00).
    - Texte : 🟠 Orange vif (#FF6F00).
    - Fond : Transparent.
    - Effet : Opacité réduite à l'appui.

---

### **5. Mise en page**

- **Structure** :
    
    - Navigation intuitive avec **Bottom Navigation Bar** :
        - 🏠 Accueil.
        - 📋 Liste des POI.
        - 🗺️ Carte.
        - ➕ Ajouter.
- **Espacements** :
    
    - Marges : 16dp pour assurer un aspect aéré.
    - Padding : 8dp entre les éléments.
- **Cards pour RecyclerView** :
    
    - Fond : ⚪ Blanc (#FFFFFF).
    - Ombre : Léger effet pour un aspect moderne.
    - Contenu : Photo en haut, nom en gras, description en texte simple.

---

### **6. États d'éléments interactifs**

- **Boutons :**
    
    - Normal : Couleur principale.
    - Appuyé : Couleur légèrement plus foncée.
    - Désactivé : Gris clair (#E0E0E0).
- **Champs de texte :**
    
    - Normal : Bordure grise (#E0E0E0).
    - Focus : Bordure bleue (#1E88E5).

---

### **7. Cartographie**

- **Style de la carte** : Thème clair par défaut.
- **Marqueurs POI** :
    - Couleur par défaut : 🟠 Orange vif (#FF6F00).
    - Icône : 🎯 (ou une icône de localisation).
    - Animation légère (rebond) lors de l'ajout d'un POI.

---

### **8. Animation et transition**

- **Transition entre fragments** :
    - Effet de glissement latéral (slide).
- **Chargement (loader)** :
    - Spinner circulaire aux couleurs principales (orange et bleu).

---