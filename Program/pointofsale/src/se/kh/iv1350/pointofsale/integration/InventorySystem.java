package se.kh.iv1350.pointofsale.integration;

import se.kh.iv1350.pointofsale.exceptions.ItemNotFoundException;
import se.kh.iv1350.pointofsale.exceptions.ServerConnectionFailException;
import se.kh.iv1350.pointofsale.dto.ItemDTO;
import se.kh.iv1350.pointofsale.integration.productFactory.Factory;
import se.kh.iv1350.pointofsale.model.Sale;


import java.util.ArrayList;

/**
 * Class that makes call to an external inventory system,
 * for this application subsequent information will be hardcoded.
 */
public class InventorySystem {
    private int meatballsLeft = 100;
    private int pringlesLeft = 100;
    private Factory factory;

    private static final InventorySystem onlyInstanceOfInventorySystem = new InventorySystem();

    private InventorySystem() {
        factory = new Factory();
    }

    public static InventorySystem getInstance() {
        return onlyInstanceOfInventorySystem;
    }

    public int getMeatballsLeft() {
        return meatballsLeft;
    }

    public int getPringlesLeft() {
        return pringlesLeft;
    }
    /**
     * Database of hardcoded items in the shop, method return an itemDTO.
     * @param scannedItemId Barcode for item, this will be a pre-set integer.
     * @return ItemDTO
     */
    public ItemDTO retrieveItemInformation(int scannedItemId) throws ItemNotFoundException, ServerConnectionFailException {
        String name;
        int id;
        String description;
        int price;
        int tax;
        ItemDTO itemDTO;

        switch(scannedItemId)
        {
            case 1:
                itemDTO = factory.getProduct(1);
            break;


            case 2:
                itemDTO = factory.getProduct(2);
            break;

            case 3: throw new ServerConnectionFailException("The server is currently not running, please try again later");

            default: throw new ItemNotFoundException("Item with itemID: "+ scannedItemId + " does not exist");

        }
        return  itemDTO;
    }

    /**
     * Updates the made-up inventory system
     * @param sale the current sale
     */
    public void updateInventorySystem(Sale sale, int paymentAmount)
    {
        if (sale.getTotalPriceAndTaxForEntirePurchase() <= paymentAmount)
        {
            ArrayList <ItemDTO> NamesOfItemsInTheSale = sale.getCopyOfItemDTOList();

            for (int i = 0; i < NamesOfItemsInTheSale.size(); i++)
            {
                if (NamesOfItemsInTheSale.get(i).getName().equals("Meatball"))
                    meatballsLeft--;
                if (NamesOfItemsInTheSale.get(i).getName().equals("Pringles"))
                    pringlesLeft--;
            }
        }

    }
}
