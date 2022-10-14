package at.fhj.swd;

public class Product extends Entity{
    private int id;
    private String title;
    private long price;
    private Category category;

    protected Product() {
        this.title = "";
    }

    public Product(int id, String title, long price) {
        this.id = id;

        if(price < 0)
            throw new IllegalArgumentException();
        this.price = price;

        if (title == null)
            throw new NullPointerException();
        this.title = title;
    }

    public Product(String title, long price) {
        this(getNextId(), title, price);
    }

    public Product(Product product) {
        this(product.title, product.price);
        this.category = product.category;
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
        return getId() + "," + getTitle() + "," + (double)getPrice()/100;
    }

    @Override
    public String toXml() {
        return "<product id=\"" + this.getId() + "\" title=\"" + this.getTitle()
                + "\" price=\"" + ((double) this.getPrice())/100 +  "\"/>";
    }
}
