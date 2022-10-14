package at.fhj.swd;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private int taxrate;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.taxrate = 20;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(int taxRate) {
        this.taxrate = taxRate;
    }

    public long calculateTotalSum(){
        return products.stream().mapToLong(Product::getPrice).sum();
    }

    public long calculateTax(){
        return calculateTotalSum() * taxrate /100;
    }
}
