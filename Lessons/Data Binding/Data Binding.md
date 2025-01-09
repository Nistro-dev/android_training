

# Configuration de Data Binding

---

## 1. Activation dans `build.gradle (:app)`

Ajoutez la configuration suivante dans la section `android` du fichier `build.gradle (:app)` pour activer le **Data Binding** :

```Java
android {
    ...
    dataBinding {
        enable = true
    }
}
```

> ⚠️ **Note** : Assurez-vous que votre projet utilise au minimum la version `3.1.0` de Gradle pour que le **Data Binding** soit pris en charge.

---

## 2. Structure de `activity_main.xml`

Pour utiliser **Data Binding**, vous devez encapsuler votre `ConstraintLayout` (ou tout autre ViewGroup) dans une balise `<layout>` et déplacer les propriétés `xmlns` vers celle-ci.

### Avant :

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
</androidx.constraintlayout.widget.ConstraintLayout>
```

### Après :

```xml
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <androidx.constraintlayout.widget.ConstraintLayout>
    </androidx.constraintlayout.widget.ConstraintLayout>

</layout>
```

---

## 3. Mise en place dans `MainActivity.java`

Pour accéder aux éléments de l'interface via **Data Binding**, déclarez une variable privée et liez-la au layout dans la méthode `onCreate`.

### Déclaration de la variable :

Le type correspond au nom de votre fichier de layout en PascalCase avec le suffixe `Binding`. Par exemple, si votre layout est `activity_main.xml`, le type sera `ActivityMainBinding`.

```java
private ActivityMainBinding binding;
```

### Initialisation dans `onCreate` :

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    // Exemple : Accès aux éléments du layout
    binding.textViewExample.setText("Bienvenue !");
}
```

> 💡 **Astuce** : Utilisez `binding` pour éviter les appels répétitifs à `findViewById`.

---

## 4. Liaison des données dans `activity_main.xml`

Vous pouvez directement lier des données dans votre fichier XML avec des expressions **Data Binding**. Voici un exemple simple avec une variable `user`.

### Exemple :

#### `activity_main.xml`

```xml
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
        <variable
            name="user"
            type="com.example.User" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout>
        <TextView
            android:id="@+id/textViewExample"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.name}" />
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

#### `MainActivity.java`

```java
User user = new User("Maël");
binding.setUser(user);
```

---

## 5. Gestion des clics avec Data Binding

Vous pouvez lier directement des actions dans votre XML grâce à des expressions **Data Binding**.

### Exemple :

#### `activity_main.xml`

```xml
<Button
    android:id="@+id/buttonExample"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="@{() -> handler.onButtonClick()}" />
```

#### `MainActivity.java`

```java
binding.setHandler(new Handler());
```

#### `Handler.java`

```java
public class Handler {
    public void onButtonClick() {
        Log.d("DataBinding", "Bouton cliqué !");
    }
}
```

---
