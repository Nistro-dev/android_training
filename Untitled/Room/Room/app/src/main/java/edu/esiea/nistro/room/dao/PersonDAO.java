package edu.esiea.nistro.room.dao;

import java.util.List;

import edu.esiea.nistro.room.Person;

public interface PersonDAO {

    public void addPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

    public List<Person> getAllPersons();

    public Person getPersonById(int id);

}