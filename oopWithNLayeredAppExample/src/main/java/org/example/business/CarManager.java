package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.CarDao;
import org.example.entities.Car;

public class CarManager {
    private CarDao carDao;
    private Logger[] loggers;

    public CarManager(CarDao carDao, Logger[] loggers){
        this.carDao = carDao;
        this.loggers = loggers;
    }

    public void add(Car car) throws Exception{
        // Business rules
        if(car.getGearType().isEmpty()){
            throw new Exception("Gear type can't be empty.");
        }

        if(car.getPrice() < 10000){
            throw new Exception("Price can't be less than 10000.");
        }
       carDao.add(car);

        for(Logger logger : loggers){
            logger.log(car.getBrand());
        }
    }
}
