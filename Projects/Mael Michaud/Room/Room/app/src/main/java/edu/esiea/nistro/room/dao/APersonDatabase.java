package edu.esiea.nistro.room.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.esiea.nistro.room.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class APersonDatabase extends RoomDatabase {
    public abstract PersonDAO getPersonDAO();
}
