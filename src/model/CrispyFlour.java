package model;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private double quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(getExpiryDate())&&(
                today.isAfter(getExpiryDate().minusMonths(2)) ||
                        today.isEqual(getExpiryDate().minusMonths(2)))){
//            System.out.println("Giam 50%");
            return getAmount()*0.6;
        }
        else
        if(today.isBefore(getExpiryDate().minusMonths(2)) &&
                (today.isAfter(getExpiryDate().minusMonths(4))||
                        today.isEqual(getExpiryDate().minusMonths(4)))){
            return getAmount()*0.8;
        }
        else
        if(today.isBefore(getExpiryDate().minusMonths(4))&&
                (today.isEqual(getManufacturingDate())||
                        today.isAfter(getManufacturingDate())
                )){
            System.out.println("Giam 10%");
            return getAmount()*0.95;
        }
        else {
            System.out.println("Dữ liệu lỗi");
        }
        return 0;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}