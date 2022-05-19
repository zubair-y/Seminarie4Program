package se.kh.iv1350.pointofsale.integration.productFactory;

import se.kh.iv1350.pointofsale.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private Meatball meatball;
    private Pringles pringles;
    private List <Product> products = new ArrayList<Product>();

    /**
     * The class constructor
     */
    public Factory () {
        meatball = new Meatball("Meatball", 1, "Food", 50, 5);
        pringles = new Pringles("Pringles", 2, "Food", 20, 2);
        products.add(meatball);
        products.add(pringles);
    }

    /**
     * Searches for the product's DTO with matching id
     * @param id the searched products id
     * @return the product's DTO with matching id as id parameter
     */
    public ItemDTO getProduct(int id){
        for (int i = 0; i < products.size(); i++)
        {
            if (getIDOfCurrentCheckedItem(i) == id)
                return products.get(i).getDTO();
        }
        return null;
    }

    private int getIDOfCurrentCheckedItem(int i)
    {
        return products.get(i).getDTO().getId();
    }
}
