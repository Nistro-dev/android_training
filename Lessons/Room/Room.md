
# Ajout de la dépendance
```java
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

### @Insert

L'annotation `@Insert` de `androidx.room.Insert` est utilisée pour indiquer une fonction d'insertion d'une ou plusieurs entrées dans une table de la base de données.

Cas utiles :
- Ajouter une nouvelle entité ou une liste d'entités dans une table.

Exemple :

```java
@Insert
void insertPerson(Person person); // Insère une seule entrée
```

---

### @Update

L'annotation `@Update` de `androidx.room.Update` est utilisée pour indiquer une fonction de mis à jour de lignes existantes dans une table.

Cas utiles :
- Mettre à jour une entité ou une liste d'entités dans une table.

Exemple :

```java
@Update
void updatePerson(Person person); // Met à jour une seule personne

@Update
void updatePersons(List<Person> persons); // Met à jour plusieurs entrées
```

---

### @Delete

L'annotation `@Delete` de `androidx.room.Delete` est utilisée pour indiquer une fonction de suppression d'une ou plusieurs entrées dans une table.

Cas utiles :
- Supprimer une entité spécifique ou une liste d'entités.

Exemple :

```java
@Delete
void deletePerson(Person person); // Supprime une personne

@Delete
void deletePersons(List<Person> persons); // Supprime plusieurs entrées
```

---

### @Query

L'annotation `@Query` de `androidx.room.Query` est utilisée pour exécuter des requêtes SQL personnalisées sur une table de la base de données.

Cas utiles :

- Récupérer des données spécifiques en utilisant une requête SQL.
- Effectuer des actions complexes non couvertes par les annotations `@Insert`, `@Update` ou `@Delete`.
- Passer des paramètres dynamiques aux requêtes SQL.

Exemple :

```java
@Query("SELECT * FROM Person")
List<Person> getAllPersons(); // Récupère toutes les personnes

@Query("SELECT * FROM Person WHERE id = :personId")
Person getPersonById(int personId); // Récupère une personne par son ID

@Query("DELETE FROM Person WHERE id = :personId")
void deletePersonById(int personId); // Supprime une personne par son ID
```

---
### @Database

L'annotation `@Database` de `androidx.room.Database` est utilisée pour définir la classe qui représente la base de données Room. Cette classe est une abstraction au-dessus de la base de données SQLite.

Cas utiles :
- Configurer les entités (tables) gérées par Room.
- Définir la version de la base de données.

#### Attributs principaux :
- `entities` : Liste des classes marquées avec `@Entity` représentant les tables.
- `version` : Numéro de version de la base de données, utilisé pour les migrations.
- `exportSchema` : Indique si Room doit exporter le schéma de la base de données (utile pour les tests ou la documentation).

#### Exemple :

```java
@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    // Définit un DAO pour accéder à la table "Person"
    public abstract PersonDao personDao();
}
```

#### Explications supplémentaires :

- **Classe abstraite** : La classe marquée avec `@Database` doit hériter de `RoomDatabase` et être abstraite.
- **Builder Room** : Utilisez la méthode `Room.databaseBuilder()` pour créer une instance de la base de données.

Exemple de création de la base de données dans une application Android :

```java
AppDatabase db = Room.databaseBuilder(
    context.getApplicationContext(),
    AppDatabase.class,
    "app_database"
).build();
```

---
### @Dao

L'annotation `@Dao` de `androidx.room.Dao` est utilisée pour marquer une interface ou une classe comme un **Data Access Object** (DAO). 

Cas utiles :
- Définir les opérations CRUD (Create, Read, Update, Delete).
- Exécuter des requêtes SQL personnalisées via `@Query`.

#### Exemple :

```java
@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person); // Ajoute une personne

    @Query("SELECT * FROM Person WHERE id = :personId")
    Person getPersonById(int personId); // Récupère une personne par ID

    @Update
    void updatePerson(Person person); // Met à jour une personne

    @Delete
    void deletePerson(Person person); // Supprime une personne
}
```

---
## DAO

### Version non générique
Création d'une interface pour l'entité avec l'implémentation des méthodes CRUD