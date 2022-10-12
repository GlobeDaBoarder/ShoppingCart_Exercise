package at.fhj.swd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    /*
     * Association: ---[1]-> p:Product
     */
    private Product p;

    @BeforeEach
    public void setup() {
        p = new Product(3, "Java Programming", 3550);

        Entity.setNextId(1);
    }

    @Test
    public void testProduct() {
        out.println("@Test testProduct");
        String s = p.toString();
        assertEquals("3,Java Programming,35.5", s);
    }

    @Test
    public void testTitleNull() {
        assertThrows(NullPointerException.class, () -> {
            new Product(3, null, 3550);
        });
    }

    @Test
    public void testPriceNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(3, "Java Programming", -3550);
        });
    }


    @Test
    public void testNextId() {
        Product p1 = new Product("Java Programming", 3550);
        assertEquals(1, p1.getId());

        Product p2 = new Product("Programming C", 1790);
        assertEquals(2, p2.getId());
    }

    @Test
    public void testDefaultConstructor() {
        Product p = new Product();
        p.setId(7).setTitle("").setPrice(1210);
    }


    @Test
    public void testToXml() {
        final String EXPECTED =
                "<product id=\"3\" title=\"Java Programming\" price=\"35.5\"/>";
        String xml = p.toXml();
        assertEquals(EXPECTED, xml);
        System.out.println(xml);

    }
}
