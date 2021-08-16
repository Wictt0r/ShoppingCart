package shoppingCart;

import java.util.HashMap;

public class ShoppingCart
{
    //the key is the id of the product
    //and the value is the quantity of the product
    private  HashMap<Integer, Integer> quantities;
    private  HashMap<Integer, Product> products;

    public ShoppingCart()
    {
        quantities = new HashMap<>();
        products = new HashMap<>();
    }

    public double getTotalPrice()
    {
        double total = 0;

        for (Integer key : quantities.keySet())
        {
            total += getProductTotalPrice(key);
        }
        if (total > 100)
            total -= total / 10;
        return total;
    }

    private double getProductTotalPrice(int id)
    {
        double value = quantities.get(id) * products.get(id).getPrice();
        if (quantities.get(id) > 2)
        {
            value -= value / 10;
        }
        return value;
    }

    public void addProduct(Product product)
    {
        Integer id = product.getId();
        quantities.merge(id, 1, Integer::sum);
        if (!products.containsKey(id))
            products.put(id, product);

    }

    public void removeProduct(int id)
    {
        if (!quantities.containsKey(id))
            return;
        if (quantities.get(id) - 1 <= 0)
        {
            quantities.remove(id);
            products.remove(id);
        } else
        {
            quantities.replace(id, quantities.get(id) - 1);
        }
    }

}
