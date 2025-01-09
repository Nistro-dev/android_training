# Configuration et utilisation des ViewModels

---
## 1. Ajout des dépendances

### `build.gradle.kts (:app)`
Ajoutez la dépendance pour les ViewModels et LiveData dans votre fichier `build.gradle.kts` :

```Kotlin
dependencies {
    implementation(libs.lifecycle.viewmodel.ktx)
}
```
> [!info] À propos des dépendances La bibliothèque `lifecycle-viewmodel-ktx` inclut les fonctionnalités des ViewModels ainsi que le support des coroutines Kotlin.

---

## 2. Création du ViewModel

Créez une classe `MainViewModel` qui hérite de `ViewModel` pour gérer les données de l'interface utilisateur.

### Exemple : `MainViewModel.java`

```java
public class MainViewModel extends ViewModel {  

    public MutableLiveData<Integer> score;  

    public MainViewModel() {  
        score = new MutableLiveData<>();  
        score.setValue(0);  
    }

    public void increment() {  
        if (score.getValue() != null) {  
            score.setValue(score.getValue() + 1);  
        }
    }

    public void decrement() {  
        if (score.getValue() != null) {  
            score.setValue(score.getValue() - 1);  
        }
    }
}
```

> [!note] Explications :
> 
> - `MutableLiveData<Integer>` est une classe observable qui permet de notifier les changements de données aux observateurs.
> - Les méthodes `increment()` et `decrement()` mettent à jour la valeur de `score` tout en notifiant automatiquement les observateurs.

---

## 3. Initialisation du ViewModel dans une Activity

Pour utiliser le ViewModel dans une Activity, créez une instance via `ViewModelProvider`.

### Exemple : Déclaration

Ajoutez une variable pour le ViewModel dans votre `MainActivity` :

```java
private MainViewModel mainViewModel;
```

### Exemple : Initialisation

Initialisez le ViewModel dans la méthode `onCreate` :

```java
mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
```

> [!tip] Pourquoi utiliser `ViewModelProvider` ? `ViewModelProvider` garantit que le ViewModel est conservé en mémoire tant que l'Activity ou le Fragment existe, même en cas de rotation de l'écran.

---

## 4. Observation des données

Pour réagir aux changements de données dans votre ViewModel, utilisez un observateur sur le `LiveData`.

### Exemple :

Ajoutez un observateur dans votre `MainActivity` :

```java
mainViewModel.score.observe(this, new Observer<Integer>() {
    @Override
    public void onChanged(Integer newScore) {
        // Mettez à jour l'UI avec le score actuel
        textViewScore.setText(String.valueOf(newScore));
    }
});
```

> [!important] Observation des LiveData L'observateur est automatiquement détaché lorsque l'Activity ou le Fragment est détruit, évitant ainsi les fuites de mémoire.

---

## 5. Exemple complet

### `MainActivity.java`

Voici un exemple complet intégrant le ViewModel et son observation :

```java
public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private TextView textViewScore;
    private Button buttonIncrement, buttonDecrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des vues
        textViewScore = findViewById(R.id.textViewScore);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        buttonDecrement = findViewById(R.id.buttonDecrement);

        // Initialisation du ViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observation des données
        mainViewModel.score.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newScore) {
                textViewScore.setText(String.valueOf(newScore));
            }
        });

        // Gestion des clics
        buttonIncrement.setOnClickListener(v -> mainViewModel.increment());
        buttonDecrement.setOnClickListener(v -> mainViewModel.decrement());
    }
}
```

---

## 6. Avantages des ViewModels

> [!success] Pourquoi utiliser les ViewModels ?
> 
> - **Conservation de l'état** : Les ViewModels préservent les données même lors des changements de configuration comme la rotation de l'écran.
> - **Séparation des responsabilités** : Les ViewModels séparent la logique métier de l'interface utilisateur.
> - **Compatibilité avec LiveData** : Les ViewModels s'intègrent parfaitement avec LiveData pour des mises à jour réactives et automatiques.

--- 