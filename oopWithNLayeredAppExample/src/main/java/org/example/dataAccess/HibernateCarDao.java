package org.example.dataAccess;

import org.example.entities.Car;
public class HibernateCarDao implements CarDao{
    public void add(Car car){
        System.out.println("Added to database with Hibernate");
    }
}
