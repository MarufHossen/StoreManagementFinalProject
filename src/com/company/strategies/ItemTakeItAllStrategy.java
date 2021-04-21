package com.company.strategies;

public class ItemTakeItAllStrategy extends ItemWithDiscountStrategy{
    private int minimumNumberOfItemToPurchase;
    private int discountForTakeItAll;

    public ItemTakeItAllStrategy(double discount, int minimumNumberOfItemToPurchase, int discountForTakeItAll) {
        super(discount);
        this.minimumNumberOfItemToPurchase = minimumNumberOfItemToPurchase;
        this.discountForTakeItAll = discountForTakeItAll;
    }

    public int getMinimumNumberOfItemToPurchase() {
        return minimumNumberOfItemToPurchase;
    }

    public void setMinimumNumberOfItemToPurchase(int minimumNumberOfItemToPurchase) {
        this.minimumNumberOfItemToPurchase = minimumNumberOfItemToPurchase;
    }

    public int getDiscountForTakeItAll() {
        return discountForTakeItAll;
    }

    public void setDiscountForTakeItAll(int discountForTakeItAll) {
        this.discountForTakeItAll = discountForTakeItAll;
    }

    @Override
    public double calculateDiscount() {
        return super.getDiscount()+ this.discountForTakeItAll;
    }
}
