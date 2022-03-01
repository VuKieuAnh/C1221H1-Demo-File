package model;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate())&&(
                today.isAfter(getExpiryDate().minusDays(3)) ||
                today.isEqual(getExpiryDate().minusDays(3)))){
//            System.out.println("Giam 50%");
            return getAmount()*0.5;
        }
        else
            if(today.isBefore(getExpiryDate().minusDays(3)) &&
                (today.isAfter(getExpiryDate().minusDays(5))||
                today.isEqual(getExpiryDate().minusDays(5)))){
            return getAmount()*0.7;
            }
            else
                if(today.isBefore(getExpiryDate().minusDays(5))&&
                        (today.isEqual(getManufacturingDate())||
                        today.isAfter(getManufacturingDate())
                                )){
                    System.out.println("Giam 10%");
                    return getAmount()*0.9;
                }
                else {
                    System.out.println("Dữ liệu lỗi");
                }
        return 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "weight=" + weight +
                '}';
    }
}