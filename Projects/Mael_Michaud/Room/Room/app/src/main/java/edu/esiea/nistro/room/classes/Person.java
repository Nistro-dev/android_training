package edu.esiea.nistro.room.classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Person")
public class Person {

    @ColumnInfo(name = "personId")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "age")
    String age;

    @Ignore
    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
