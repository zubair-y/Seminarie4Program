package se.kh.iv1350.pointofsale.integration.productFactory;

import se.kh.iv1350.pointofsale.dto.ItemDTO;

public class Pringles implements Product{
    private ItemDTO pringlesDTO;

    /**
     * The constructor for the class
     * @param name Name of item.
     * @param id identification number of number/barcode.
     * @param description Description of item.
     * @param price Price of item excluding tax.
     * @param tax Tax for item.
     */
    public Pringles(String name, int id, String description, int price, int tax) {
        pringlesDTO = new ItemDTO(name, id, description, price, tax);
    }


    /**
     * Gets the DTO for the class
     * @return DTO for the class
     */
    @Override
    public ItemDTO getDTO() {
        return pringlesDTO;
    }
}
