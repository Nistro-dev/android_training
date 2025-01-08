Ajouter les dépendances dans gradle.
https://developer.android.com/jetpack/androidx/releases/room?hl=fr#groovy
Ajout de : 
```kts
dependencies {
	val room_version = "2.6.1"  
	  
	implementation("androidx.room:room-runtime:$room_version")  
	// optional - Kotlin Extensions and Coroutines support for Room  
	implementation("androidx.room:room-ktx:$room_version")  
	  
	// If this project only uses Java source, use the Java annotationProcessor  
	// No additional plugins are necessary  
	annotationProcessor("androidx.room:room-compiler:$room_version")
}
```


Pour voir la bdd :
- App Inspection
- Select Process -> Process de l'app


# Création des classes

*New Java Class* -> *Nom de la classe*

## Annotations
### @Entity

L'annotation `@Entity` de `androidx.room.Entity` est utilisée pour indiquer qu'une classe Java représente une table dans la base de données.

Cas utiles :

- Définir une classe comme entité de base de données.
- Spécifier des informations comme le nom de la table avec l'attribut `tableName`.

Exemple :

```java
@Entity(tableName = "Person")
public class Person {
    // Cette classe représente une table nommée "Person"
}
```

---

### @ColumnInfo

L'annotation `@ColumnInfo` de `androidx.room.ColumnInfo` est utilisée pour spécifier les informations liées à une colonne dans une table.

Cas utiles :

- Personnaliser le nom de la colonne dans la base de données (différent du nom du champ).
- Ajouter des métadonnées supplémentaires comme `typeAffinity`, `defaultValue`, etc.

Exemple :

```java
@ColumnInfo(name = "person_name")
String name; // Le champ "name" sera stocké dans la colonne "person_name"
```

---

### @PrimaryKey

L'annotation `@PrimaryKey` de `androidx.room.PrimaryKey` est utilisée pour identifier un champ comme étant la clé primaire d'une table.

Cas utiles :

- Définir un champ qui servira d'identifiant unique pour chaque ligne de la table.
- Utiliser l'attribut `autoGenerate` pour générer automatiquement les valeurs de la clé primaire.

Exemple :

```java
@PrimaryKey(autoGenerate = true)
int id; // Ici, la clé primaire sera générée automatiquement
```

---

### @Ignore

L'annotation `@Ignore` de `androidx.room.Ignore` est utilisée pour indiquer à Room d'ignorer certains champs ou constructeurs lors de la génération de la base de données.

Cas utiles :

- Exclure un champ d'une classe d'entité qui n'a pas besoin d'être stocké en base de données.
- Ignorer un constructeur spécifique lors de la génération d'une table.

Exemple :

```java
@Ignore
public Person() {
    // Ce constructeur sera ignoré par Room
}
```

---

## DAO

### Version non générique
Création d'une interface pour l'entité avec l'implémentation des méthodes CRUD