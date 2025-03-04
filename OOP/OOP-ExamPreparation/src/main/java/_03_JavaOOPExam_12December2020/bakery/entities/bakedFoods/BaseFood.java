package _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods;

import _03_JavaOOPExam_12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;

import static _03_JavaOOPExam_12December2020.bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements BakedFood {

    private String name;
    private double portion;
    private double price;

    protected BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }

        this.portion = portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.getName(), this.getPortion(), this.getPrice());
    }
}