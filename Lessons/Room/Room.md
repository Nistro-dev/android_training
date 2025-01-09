# Configuration de Room

Apprenez à configurer et utiliser **Room** dans un projet Android pour gérer une base de données SQLite avec une interface moderne.

---

## 1. Ajout de la dépendance

Ajoutez les dépendances nécessaires dans votre fichier `build.gradle (:app)` :

```java
dependencies {
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    // Extensions Kotlin et support des coroutines
    implementation("androidx.room:room-ktx:$room_version")
    
    // Pour Java uniquement : annotationProcessor
    annotationProcessor("androidx.room:room-compiler:$room_version")
}
```

> [!tip] **Pour les utilisateurs Kotlin** Si vous utilisez Kotlin, appliquez le plugin `kapt` dans votre `build.gradle` :
> 
> ```kotlin
> apply plugin: 'kotlin-kapt'
> ```

---

## 2. Création des classes et annotations

### @Entity

L'annotation `@Entity` transforme une classe en table dans la base de données.

```java
@Entity(tableName = "Person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "person_name")
    public String name;
}
```

> [!info] À propos de @Entity
> 
> - Utilisez l'attribut `tableName` pour définir le nom de la table.
> - Si aucun nom n'est spécifié, Room utilise le nom de la classe par défaut.

---

### @PrimaryKey

Définit la clé primaire d'une table. Avec `autoGenerate`, les valeurs sont automatiquement incrémentées.

```java
@PrimaryKey(autoGenerate = true)
public int id;
```

> [!tip] Conseils pour les clés primaires Toujours définir une clé primaire pour éviter les erreurs de structure dans la base de données.

---

### @ColumnInfo

Personnalise les informations de la colonne.

```java
@ColumnInfo(name = "person_name")
public String name;
```

> [!warning] Utilisation de noms de colonnes Si vous changez le nom d'une colonne après le déploiement, pensez à effectuer une **migration**.

---

### @Ignore

Exclut des champs ou constructeurs de la base de données.

```java
@Ignore
public String tempData;
```

> [!info] Cas d'usage
> 
> - Exclure des champs temporaires.
> - Ignorer des constructeurs secondaires.

---

### Exemple complet d'une entité :

```java
@Entity(tableName = "Person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "person_name")
    public String name;

    @ColumnInfo(defaultValue = "Unknown")
    public String city;

    @Ignore
    public String tempData;
}
```

> [!example] Exemple d'utilisation de Room Cet exemple montre une entité complète avec clé primaire, colonnes personnalisées et champs ignorés.

---

## 3. DAO (Data Access Object)

Un DAO permet de gérer les opérations sur la base de données : ajout, mise à jour, suppression, requêtes personnalisées.

### Exemple :

```java
@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person WHERE id = :personId")
    Person getPersonById(int personId);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
```

> [!tip] Astuce Combinez plusieurs annotations comme `@Insert` et `@Query` pour des opérations complexes.

---

## 4. Création de la base de données

La classe de base de données est marquée avec `@Database` et doit hériter de `RoomDatabase`.

```java
@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
```

> [!info] À propos de la version La version de la base de données est utilisée pour gérer les migrations.

---

## 5. Instanciation de la base de données

Utilisez le builder Room pour créer une instance de votre base de données.

```java
AppDatabase db = Room.databaseBuilder(
    context.getApplicationContext(),
    AppDatabase.class,
    "app_database"
).build();
```

> [!warning] Thread principal Room ne permet pas d'effectuer des opérations sur le **thread principal** par défaut. Utilisez un thread séparé ou les coroutines.

---

## 6. Requêtes personnalisées avec @Query

Exécutez des requêtes SQL personnalisées avec l'annotation `@Query`.

#### Exemple :

```java
@Query("SELECT * FROM Person")
List<Person> getAllPersons();

@Query("SELECT * FROM Person WHERE name LIKE :searchName")
List<Person> findByName(String searchName);
```

> [!tip] Passage de paramètres Utilisez `:` pour passer des paramètres dynamiques dans vos requêtes SQL.

---

## 7. Exemple complet d'utilisation

### Entité `Person` :

```java
@Entity(tableName = "Person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "person_name")
    public String name;
}
```

### DAO `PersonDao` :

```java
@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person WHERE id = :personId")
    Person getPersonById(int personId);

    @Delete
    void deletePerson(Person person);
}
```

### Base de données `AppDatabase` :

```java
@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
```

### Utilisation dans `MainActivity` :

```java
AppDatabase db = Room.databaseBuilder(
    context.getApplicationContext(),
    AppDatabase.class,
    "app_database"
).build();

PersonDao dao = db.personDao();

// Ajouter une personne
Person person = new Person();
person.name = "Maël";
dao.insertPerson(person);

// Récupérer une personne
Person retrievedPerson = dao.getPersonById(1);
Log.d("RoomExample", "Nom : " + retrievedPerson.name);
```