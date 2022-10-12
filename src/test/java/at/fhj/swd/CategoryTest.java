package at.fhj.swd;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {
    private Category books;

    @BeforeEach
    public void setUp() {
        books = new Category("Books");
        Product p1 = new Product("Programming C", 1790);
        Product p2 = new Product("Java Programming", 3450);

        books.addProduct(p1);
        p1.setCategory(books);

        books.addProduct(p2);
        p2.setCategory(books);

        System.out.println(books.getProducts().size());

    }

    @Test
    public void testNavigationCategoryProduct() {
        final String EXPECTED = "Programming C";
        assertNotNull(books);
        String title = books.getProducts().get(0).getTitle();
        assertEquals(EXPECTED, title);
    }


    @Test
    public void testNavigationXXX() {
        final String EXPECTED = "Java Programming";
        assertNotNull(books);
        assertNotNull(books.getProducts());
        assertEquals(2, books.getProducts().size());

        Product p1 = books.getProducts().get(0);
        assertNotNull(p1);
        System.out.println(p1.getTitle());


        Category c = p1.getCategory();
        assertNotNull(c);
        Product p2 = c.getProducts().get(1);
        String title = p2.getTitle();

        assertEquals(EXPECTED, title);
    }
}
