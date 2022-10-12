package at.fhj.swd;

import java.util.ArrayList;
import java.util.List;

public class Category extends Entity{
    private int id;
    private String name;
    private List<Product> products;
    private List<Category> children;
    private Category parent;

    public Category(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Category> getChildren() {
        return children;
    }

    public void addChild(Category category){
        this.children.add(category);
    }
}
