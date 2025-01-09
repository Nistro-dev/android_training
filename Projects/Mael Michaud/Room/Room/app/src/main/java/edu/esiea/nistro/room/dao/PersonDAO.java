package edu.esiea.nistro.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.esiea.nistro.room.Person;

@Dao
public interface PersonDAO {

    @Insert
    public void addPerson(Person person);

    @Update
    public void updatePerson(Person person);

    @Delete
    public void deletePerson(Person person);

    @Query("Select * From Person")
    public List<Person> getAllPersons();

    @Query("Select * From Person Where personId ==:personId")
    public Person getPersonById(int personId);

}