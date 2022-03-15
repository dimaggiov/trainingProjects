package com.mthree.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class VendingMachineItem {

    private int id;
    private int stock;
    private BigDecimal price;
    private String itemName;


    public VendingMachineItem(int id) {
        this.id = id;
    }

    public void sell() {
        stock--;
    }

    public int getId() { return id; }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineItem that = (VendingMachineItem) o;
        return id == that.id && Objects.equals(price, that.price) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stock, price, itemName);
    }


}


