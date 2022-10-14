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
        this.id = getNextId();
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

    @Override
    public String toXml() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<category id=\"")
                .append(this.id)
                .append("\" name=\"")
                .append(this.name)
                .append("\">\n");
        if(!this.children.isEmpty()){
            for (Category category : this.children) {
                stringBuilder.append(category.toXml());
            }
        }

        if(!products.isEmpty()){
            for (Product product : this.products) {
                stringBuilder.append(product.toXml())
                        .append("\n");
            }
        }

        stringBuilder.append("</category>")
                .append(parent == null ? "" : "\n");
        return stringBuilder.toString();
    }
}
