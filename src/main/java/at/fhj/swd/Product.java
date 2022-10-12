package at.fhj.swd;

public class Product extends Entity{
    private int id;
    private String title;
    private long price;
    private Category category;

    protected Product() {
    }

    public Product(int id, String title, long price) {
        this.id = id;
        this.price = price;
        setTitle(title);
    }

    public Product(String title, long price) {
        this.id = getNextId();
        this.price = price;
        this.title = title;
    }

    public Product(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.title = product.getTitle();
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        return new Product(id, this.title, this.price);
    }

    public long getPrice() {
        return price;
    }

    public Product setPrice(long price) {
        return new Product(this.title, price);
    }

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        if (title == null)
            throw new NullPointerException();

        return new Product(title, this.price);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public String toXml() {
        return "<product id=\"" + this.getId() + "\" title=\"" + this.getTitle()
                + "\" price=\"" + this.getPrice() +  "\"/>";
    }
}
