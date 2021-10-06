package com.shopping.models;

import com.shopping.services.inputOutPut.Print;

public class Product extends Model implements Print {



    private final  String name;
    private final  String describtion;
    private final  String category;
    private final  double price;
    private final  double amount;

    public Product(
            String name,
            String describtion,
            String category,
            double price,
            double amount
    ) {
        super(0);
        this.name = name;
        this.describtion = describtion;
        this.category = category;
        this.price = price;
        this.amount = amount;


    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescribtion() {
        return describtion;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", describtion='" + describtion + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


    public void toFormattedString(int n) {
        print("\n");
        line();
        printTab(n + "\tname :" + name);
        line2();
        printTab("category : " + category);
        printTab("describtion : " + describtion);
        line2();
        printTab("price : " + price +"$\t\tamount : x" + (int) amount);

    }

}
