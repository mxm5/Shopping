package com.shopping.services;

public class Amount<P> {

    private final P product;
    private int count;


    Amount(P product, int count) {
        this.product = product;
        this.count = count;
    }

    public P getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        ++count;
    }

    public void subCount() {
        --count;
    }
}
