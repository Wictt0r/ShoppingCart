package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shoppingCart.Product;
import shoppingCart.ShoppingCart;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingCartTest
{
    ShoppingCart shoppingCart;

    public ShoppingCartTest()
    {
        shoppingCart = new ShoppingCart();
    }

    @BeforeEach
    void setUp()
    {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void discountOnManyItems()
    {
        Product apple = new Product(1, "apple", 1);
        shoppingCart.addProduct(apple);
        shoppingCart.addProduct(apple);
        assertEquals(shoppingCart.getTotalPrice(),2.0);
        shoppingCart.addProduct(apple);
        assertEquals(shoppingCart.getTotalPrice(),2.7);
    }

    @Test
    void discountTotalPrice()
    {
        Product apple = new Product(1, "apple", 1);
        Product banana = new Product(2, "banana", 105);
        shoppingCart.addProduct(apple);
        assertEquals(shoppingCart.getTotalPrice(),1);
        shoppingCart.addProduct(banana);
        assertEquals(shoppingCart.getTotalPrice(),95.4);
        shoppingCart.addProduct(banana);
        shoppingCart.addProduct(banana);
        assertEquals(shoppingCart.getTotalPrice(),256.05);
    }

    @Test
    void removeProduct()
    {
        Product apple = new Product(1, "apple", 1);
        Product banana = new Product(2, "banana", 105);
        shoppingCart.addProduct(apple);
        assertEquals(shoppingCart.getTotalPrice(),1);
        shoppingCart.removeProduct(1);
        assertEquals(shoppingCart.getTotalPrice(),0);
        shoppingCart.addProduct(banana);
        shoppingCart.addProduct(banana);
        assertEquals(shoppingCart.getTotalPrice(),189);
        shoppingCart.removeProduct(2);
        assertEquals(shoppingCart.getTotalPrice(),94.5);
    }
}
