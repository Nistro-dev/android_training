package edu.esiea.nistro.room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.esiea.nistro.room.dao.APersonDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit;
    EditText ageEdit;
    Button saveButton,getDataButton;

    APersonDatabase PersonDatabase;

    List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        ageEdit = findViewById(R.id.ageEdit);

        saveButton = findViewById(R.id.saveButton);
        getDataButton = findViewById(R.id.getDataButton);

        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        PersonDatabase = Room.databaseBuilder(getApplicationContext(), APersonDatabase.class, "PersonDB")
                .addCallback(callback)
                .build();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                String age = ageEdit.getText().toString();

                Person person = new Person(name, age);
                addPersonInBackgreound(person);
            }
        });

        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPersonListInBackground();
            }
        });
    }

    public void addPersonInBackgreound(Person person) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Background operation
                PersonDatabase.getPersonDAO().addPerson(person);

                // On Finish
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Person Added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void getPersonListInBackground() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Background operation
                persons = PersonDatabase.getPersonDAO().getAllPersons();

                // On Finish
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        for (Person person : persons) {
                            sb.append(person.getName() + " : " + person.getAge() + "\n");
                            System.out.println(person.getName() + " " + person.getAge());
                        }
                        String finalData = sb.toString();
                        Toast.makeText(MainActivity.this, finalData, Toast.LENGTH_SHORT).show();                    }
                });
            }
        });
    }
}