package com.grocery.app;

public class OrderItem {
    String productname;
    String fullnames;
    String location;
    String phone;
    String amount;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public OrderItem(String productname, String fullnames, String location, String phone, String amount) {
        this.productname = productname;
        this.fullnames = fullnames;
        this.location = location;
        this.phone = phone;
        this.amount = amount;
    }


}
