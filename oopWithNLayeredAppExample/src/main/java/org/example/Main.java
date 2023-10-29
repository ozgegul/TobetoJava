package org.example;

import org.example.business.CarManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.core.logging.MailLogger;
import org.example.dataAccess.JdbcCarDao;
import org.example.entities.Car;


public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("Jeep", "Renegade", "Graphite Gray", 1000000);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        CarManager carManager = new CarManager(new JdbcCarDao(), loggers);
        carManager.add(car1);
    }
}