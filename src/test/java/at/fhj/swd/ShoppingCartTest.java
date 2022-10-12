package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    /*
     * Association: ----[1]-> card:ShoppingCard
     */
    private ShoppingCart cart;

    @BeforeEach
    public void setup() {
        cart = new ShoppingCart();

        Product p1 = new Product(3, "Java Programming", 3590);
        Product p2 = new Product(7, "Exile on Main St", 1450);

        cart.addProduct(p1);
        cart.addProduct(p2);
    }

    @Test
    public void testShoppingCardSize() {
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    public void testShoppingProducts() {
        Product p1 = cart.getProducts().get(0);
        assertEquals("Java Programming", p1.getTitle());

        Product p2 = cart.getProducts().get(1);
        assertEquals("Exile on Main St", p2.getTitle());
    }


    @Test
    public void testCalculateTotalSum() {
        long sum = 3590 + 1450;
        long result = cart.calculateTotalSum();

        assertEquals(sum, result);
    }

    @Test
    public void testCalculateTax() {
        long sum = 3590 + 1450;
        long tax = sum * 20 / 100;
        long result = cart.calculateTax();

        assertEquals(tax, result);
    }

    @Test
    public void testCalculateTax25() {
        final int TAXRATE = 25;
        cart.setTaxrate(TAXRATE);

        long sum = 3590 + 1450;
        long tax = sum * TAXRATE / 100;
        long result = cart.calculateTax();

        assertEquals(tax, result);
    }

}