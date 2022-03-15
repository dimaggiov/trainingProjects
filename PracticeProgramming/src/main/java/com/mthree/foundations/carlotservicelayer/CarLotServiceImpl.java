package com.mthree.foundations.carlotservicelayer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarLotServiceImpl implements CarLotService{

    CarLotDAO dao;

    public CarLotServiceImpl(CarLotDAO dao) {
        this.dao = dao;
    }

    @Override
    public Car getACar(String VIN) {
       return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> allCars = dao.getCars();
        List<Car> carsOfColor = new ArrayList<>();

        for(Car c : allCars)
            if(c.getColor().equalsIgnoreCase(color))
                carsOfColor.add(c);

        return carsOfColor;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> allCars = dao.getCars();
        List<Car> carsInBudget = new ArrayList<>();

        for(Car c : allCars)
            if(c.getPrice().compareTo(maxPrice) < 0)
                carsInBudget.add(c);

        return carsInBudget;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> allCars = dao.getCars();
        List<Car> carsWithMakeAndModel = new ArrayList<>();

        for(Car c : allCars)
            if(c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model))
                carsWithMakeAndModel.add(c);

        return carsWithMakeAndModel;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) {
        Car carToUpdate = dao.getCar(VIN);
        if(carToUpdate == null) {
            //throw carNotFoundException
        }
        carToUpdate.setPrice(carToUpdate.getPrice().multiply(percentDiscount));
        dao.editCar(VIN, carToUpdate);

        return carToUpdate.getPrice();
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) {
        Car carToBuy = dao.getCar(VIN);
        if(carToBuy == null){
            //throw carNotFoundException
        }
        if(carToBuy.getPrice().compareTo(cashPaid) == 0) {
            dao.removeCar(VIN);
            return carToBuy.getKey();
        }
        else if(carToBuy.getPrice().compareTo(cashPaid) < 1){
            //throw underpaidPriceException
        }

        //throw overpaidPriceException
        return null;
    }
}
