package com.company;

import com.company.basket.EmployeeBasket;
import com.company.basket.LoyalCustomerBasket;
import com.company.basket.StoreBasket;
import com.company.discount.Coupon;
import com.company.helper.InputHelper;
import com.company.item.*;
import com.company.language.Language;
import com.company.user.User;
import com.company.user.customer.EmployeeAsCustomer;
import com.company.user.customer.LoyalCustomer;
import com.company.user.employee.Cashier;
import com.company.user.employee.Manager;
import com.company.store.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Language language = new Language();

        Scanner scanner = new Scanner(System.in);


        Item item1 = new Item("CocaCola", 10); // 100001
        ItemWithDiscount item2 = new ItemWithDiscount("Pepsi", 20); // 100002
        DiscountIndependence item3 = new DiscountIndependence("Fanta", 30); // 100003
        BuyMorePayLess item4 = new BuyMorePayLess("Lays Chips", 40); // 100004
        ItemTakeItAll item5 = new ItemTakeItAll("Onion Chips", 25); // 100005

        LoyalCustomer loyalCustomer = new LoyalCustomer("Maruf","Hossen","maruf1234", "abcd1234","Liivamae 3","53633471", 0);
        EmployeeAsCustomer employeeAsCustomer = new EmployeeAsCustomer("Maksim","Gio","max124", "abc12345","Tina 3","53636356", 0);
        User user = new User("Marek","Ivan","marek124", "abc12345","Tina 3","53636356");

        Cashier cashier1 = new Cashier("Amirul", "Islam", "amirul1234", "123456", "Ulemeste", "5561331345", "6553133", 1000 );
        Cashier cashier2 = new Cashier("John", "Doe", "amirul123", "123456", "Ulemeste 2", "5561331345", "6553133", 1200 );
        Cashier cashier3 = new Cashier("Monika", "Raun", "monika1234", "123456", "Mustamae 3", "554637636", "6555333", 900 );
        Cashier cashier4 = new Cashier("Ahmed", "Madani", "ahmed1234", "123456", "Ulemeste 4", "5546633636", "6553133", 1100 );
        Cashier cashier5 = new Cashier("Dimitri", "Costa", "dimitri1234", "123456", "Ulemeste 5", "5561331345", "6556133", 1500 );
        Manager manager = new Manager("Sergey", "Malaysev", "sergey1234", "123456", "Suur Sojamae 10", "54513131","56214653","4220", 2000);

        ArrayList<Cashier> cashiers = new ArrayList<>();
        cashiers.add(cashier1);
        cashiers.add(cashier2);
        cashiers.add(cashier3);
        cashiers.add(cashier4);
        cashiers.add(cashier5);

        ArrayList<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(item1);
        itemArrayList.add(item2);
        itemArrayList.add(item3);
        itemArrayList.add(item4);
        itemArrayList.add(item5);

//        Add item to store

        Store store = new Store(cashiers,manager);
        store.setAllStoreItems(itemArrayList);
//        System.out.println(store.toString());
        HashMap<Integer,String> menus = new HashMap<>();
        menus.put(1, "NEW_BASKET");
        menus.put(2, "INSERT_ITEM_IN_BASKET");
        menus.put(3, "REMOVE_ITEM_IN_BASKET");
        menus.put(4, "PRINT_INFORMATION_FOR_BASKET_WITH_A_CERTAIN_ID");
        menus.put(5, "APPLY_DISCOUNT_TO_BASKET_WITH_10%_FOR_CHRISTMAS_PROMOTION");
        menus.put(6, "COUPON_DISCOUNT");
        menus.put(7, "PURCHASE");
        menus.put(8, "EXIT");

        System.out.println("Languages:");
        System.out.println("\t 1 - English");
        System.out.println("\t 2 - German");
        System.out.print("Select one language: ");
//        int selectedLanguage = InputHelper.getValidIntegerInput();
        int selectedLanguage = InputHelper.getValidIntegerInput();

        if (selectedLanguage == 2 ){
            language.changeLanguage("ge","GE");
        }

        System.out.println(language.translate("LOGIN_AS_MANAGER_TO_START_THE_SYSTEM"));
//        int option = InputHelper.getValidIntegerInput();

        boolean isCashierLoggedIn = false;
        Cashier loggedCashier = null;
        boolean hasStarted = false;

        while (!hasStarted){
            System.out.print(language.translate("ENTER_USERNAME")+": ");
            String username = scanner.next();
            System.out.print(language.translate("ENTER_PASSWORD")+": ");
            String password = scanner.next();

            if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())){
                System.out.print(language.translate("ENTER_PIN_TO_START")+": ");
                if (scanner.next().equals(manager.getPin())){
                    hasStarted = true;
                    System.out.println(language.translate("SYSTEM_STARTED"));
                    while (true){
                        System.out.println("\t 1 - "+language.translate("SET_REGULAR_DISCOUNT"));
                        System.out.println("\t 2 - "+language.translate("SET_DISCOUNT_INDEPENDENCE"));
                        System.out.println("\t 3 - "+language.translate("SET_N_FOR_TAKEITALL_ITEM"));
                        System.out.println("\t 4 - "+language.translate("SET_BUY_MORE_PAY_LESS_DISCOUNT_ITEM"));
                        System.out.println("\t 5 - "+language.translate("GENERATE_COUPON"));
                        System.out.println("\t 6 - "+language.translate("EXIT"));
                        System.out.print(language.translate("SELECT_ONE")+": ");
                        int selectedMenu = InputHelper.getValidIntegerInput();
                        if (selectedMenu == 1){
                            System.out.print(language.translate("ENTER_ITEM_ID_TO_SET_DISCOUNT")+": ");
                            int itemIdForRegularDiscount = InputHelper.getValidIntegerInput();
                            Item itemForRegularDiscount = store.getItemById(itemIdForRegularDiscount);
                            if (itemForRegularDiscount != null){
                                if (itemForRegularDiscount instanceof ItemWithDiscount){
                                    System.out.print(language.translate("ENTER_DISCOUNT_AMOUNT")+": ");
                                    double regularDiscountAmount = scanner.nextDouble();
                                    ((ItemWithDiscount) itemForRegularDiscount).setDiscountAmount(regularDiscountAmount);
                                    store.updateItemById(itemIdForRegularDiscount, itemForRegularDiscount);
                                    System.out.println(language.translate("DISCOUNT_SET_SUCCESSFULLY"));
                                }else{
                                    System.out.println(language.translate("THIS_IS_NOT_ITEM_WITH_DISCOUNT"));
                                }
                            }else{
                                System.out.println(language.translate("NO_ITEM_FOUND_WITH_THIS_ID_IN_STORE"));
                            }
                        }
                        else if (selectedMenu == 2){
                            System.out.print(language.translate("ENTER_ITEM_ID_TO_SET_DISCOUNT_INDEPENDENCE")+": ");
                            int itemIdForDiscountIndependence = InputHelper.getValidIntegerInput();
                            Item itemForDiscountIndependence = store.getItemById(itemIdForDiscountIndependence);
                            if (itemForDiscountIndependence != null){
                                if (itemForDiscountIndependence instanceof DiscountIndependence){
                                    System.out.print(language.translate("ENTER_DISCOUNT_AMOUNT")+": ");
                                    double discountIndependenceAmount = scanner.nextDouble();
                                    ((DiscountIndependence) itemForDiscountIndependence).setDiscountIndependence(discountIndependenceAmount);
                                    store.updateItemById(itemIdForDiscountIndependence, itemForDiscountIndependence);
                                    System.out.println(language.translate("DISCOUNT_SET_SUCCESSFULLY"));
                                }else{
                                    System.out.println(language.translate("THIS_IS_NOT_ITEM_WITH_DISCOUNT_INDEPENDENCE"));
                                }
                            }else{
                                System.out.println(language.translate("NO_ITEM_FOUND_WITH_THIS_ID_IN_STORE"));
                            }
                        }
                        else if (selectedMenu == 3){
                            System.out.print(language.translate("ENTER_ITEM_ID_TO_SET_DISCOUNT_FOR_TAKEITALL")+": ");
                            int itemIdForTakeItAll = InputHelper.getValidIntegerInput();
                            Item itemForTakeItAll = store.getItemById(itemIdForTakeItAll);
                            if (itemForTakeItAll != null){
                                if (itemForTakeItAll instanceof ItemTakeItAll){
                                    System.out.println(language.translate("ENTER_MINIMUM_ITEMS_TO_PURCHASE")+": ");
                                    int minimumItemForTakeItAllItem = InputHelper.getValidIntegerInput();
                                    System.out.print(language.translate("ENTER_DISCOUNT_AMOUNT")+": ");
                                    double itemForTakeItAllDiscount = scanner.nextDouble();
                                    ((ItemTakeItAll) itemForTakeItAll).setDiscountAmount(itemForTakeItAllDiscount);
                                    ((ItemTakeItAll) itemForTakeItAll).setMinimumItemsToPurchase(minimumItemForTakeItAllItem);
                                    store.updateItemById(itemIdForTakeItAll, itemForTakeItAll);
                                    System.out.println(language.translate("DISCOUNT_SET_SUCCESSFULLY"));
                                }else{
                                    System.out.println(language.translate("THIS_IS_NOT_ITEM_TAKE_IT_ALL"));
                                }
                            }else{
                                System.out.println(language.translate("NO_ITEM_FOUND_WITH_THIS_ID_IN_STORE"));
                            }
                        }
                        else if (selectedMenu == 4){
                            System.out.print(language.translate("ENTER_ITEM_ID_TO_SET_PROPERTY_FOR_BUY_MORE_PAY_LESS_ITEM")+": ");
                            int itemIdForByMorePayLessItem = InputHelper.getValidIntegerInput();
                            Item itemForBuyMorePayLess = store.getItemById(itemIdForByMorePayLessItem);
                            if (itemForBuyMorePayLess != null){
                                if (itemForBuyMorePayLess instanceof BuyMorePayLess){
                                    System.out.println(language.translate("ENTER_BUYING_QUANTITY")+": ");
                                    int buyingQuantity = InputHelper.getValidIntegerInput();
                                    System.out.println(language.translate("ENTER_PAY_FOR_QUANTITY")+": ");
                                    int payForQuantity = InputHelper.getValidIntegerInput();
                                    ((BuyMorePayLess) itemForBuyMorePayLess).setBuyQuantity(buyingQuantity);
                                    ((BuyMorePayLess) itemForBuyMorePayLess).setPayForQuantity(payForQuantity);
                                    store.updateItemById(itemIdForByMorePayLessItem, itemForBuyMorePayLess);
                                    System.out.println(language.translate("DISCOUNT_SET_SUCCESSFULLY"));
                                }else{
                                    System.out.println(language.translate("THIS_IS_NOT_BUY_MORE_PAY_LESS_ITEM"));
                                }
                            }else{
                                System.out.println(language.translate("NO_ITEM_FOUND_WITH_THIS_ID_IN_STORE"));
                            }
                        }
                        else if (selectedMenu == 5 ){
                            System.out.println(language.translate("ENTER_COUPON_CODE")+": ");
                            int couponCode = InputHelper.getValidIntegerInput();
                            System.out.println(language.translate("ENTER_COUPON_DISCOUNT_AMOUNT")+": ");
                            int couponDiscountAmount = InputHelper.getValidIntegerInput();
                            Coupon generatedCoupon = new Coupon(couponDiscountAmount,couponCode);
                            store.addCoupon(generatedCoupon);
                            System.out.println(language.translate("COUPON_GENERATED"));
                        }
                        else if (selectedMenu == 6 ){
                            break;
                        }
                        else{
                            System.out.println(language.translate("INCORRECT_MENU_SELECTED"));
                        }
                    }
                    break;
                }else {
                    hasStarted = false;
                    System.out.println(language.translate("WRONG_PIN_TRY_AGAIN"));
                }
            }else{
                System.out.println(language.translate("WRONG_USERNAME_OR_PASSWORD"));
            }
        }

        while ( !isCashierLoggedIn ) {
            System.out.println(language.translate("LOGIN_AS_CASHIER_TO_USE_THE_SYSTEM"));
            System.out.print(language.translate("ENTER_USERNAME")+": ");
            String username = scanner.next();
            System.out.print(language.translate("ENTER_PASSWORD")+": ");
            String password = scanner.next();
            for (Cashier cashier :
                    cashiers ) {

                if (username.equals(cashier.getUsername()) && password.equals(cashier.getPassword())){
                    isCashierLoggedIn = true;
                    loggedCashier = cashier;
                    loggedCashier.setLastLoginTime();
                    store.updateCashierById(loggedCashier.getId(), loggedCashier);
                    break;
                }
            }
            if (!isCashierLoggedIn){
                System.out.println(language.translate("WRONG_USERNAME_OR_PASSWORD"));
            }
        }

        while (isCashierLoggedIn && hasStarted){
            for (int i: menus.keySet()){
                System.out.println(i + " - " + language.translate(menus.get(i)));
            }
            System.out.print(language.translate("SELECT_ONE_MENU_TO_PROCEED")+": ");
            int menuNumber = InputHelper.getValidIntegerInput();
            switch (menuNumber){
                case 1:
                    System.out.println(language.translate("SELECT_ONE")+":");
                    System.out.println("\t 1 - "+language.translate("LOYAL_BASKET"));
                    System.out.println("\t 2 - "+language.translate("EMPLOYEE_BASKET"));
                    System.out.println("\t 3 - "+language.translate("REGULAR_BASKET"));
                    System.out.print(language.translate("ENTER_YOUR_CHOICE")+": ");
                    int selectedMenuNumber = InputHelper.getValidIntegerInput();
                    if (selectedMenuNumber == 1){
                        LoyalCustomerBasket loyalCustomerBasket = new LoyalCustomerBasket(20, "Suur Sojamae 4", "Michael", loyalCustomer);
                        store.addBasket(loyalCustomerBasket);
                    }else if (selectedMenuNumber == 2){
                        EmployeeBasket employeeBasket = new EmployeeBasket(20, "Suur Sojamae 4", "Michael", employeeAsCustomer);
                        store.addBasket(employeeBasket);
                    }else if (selectedMenuNumber == 3){
                        StoreBasket storeBasket = new StoreBasket(20, "Suur Sojamae 4", "Michael");
                        store.addBasket(storeBasket);
                    }
                    break;

                case 2:
                    System.out.print(language.translate("ENTER_BASKET_ID")+": ");
                    int basketId = InputHelper.getValidIntegerInput();
                    System.out.print(language.translate("ENTER_ITEM_ID")+": ");
                    int itemId = InputHelper.getValidIntegerInput();
                    StoreBasket basket = store.getBasketById(basketId);
                    Item item = store.getItemById(itemId);
                    if (basket != null && item != null) {
                        basket.insertNewItem(item);
                        basket.calculatePayment();
                        System.out.println(language.translate("INSERTED_ITEM_SUCCESSFULLY!"));
                    }else{
                        System.out.println(language.translate("BASKET_OR_ITEM_NOT_FOUND!!_ENTER_CORRECT_BASKET_AND_ITEM_ID"));
                    }
                    break;

                case 3:
                    System.out.print(language.translate("ENTER_BASKET_ID")+": ");
                    int basketNumber = InputHelper.getValidIntegerInput();
                    System.out.print(language.translate("ENTER_ITEM_ID")+": ");
                    int itemNumber = InputHelper.getValidIntegerInput();
                    StoreBasket oldBasket = store.getBasketById(basketNumber);
                    Item oldItem = store.getItemById(itemNumber);
                    if (oldBasket != null && oldItem != null) {
                        oldBasket.removeItem(oldItem);
                        oldBasket.calculatePayment();
                        store.updateBasketById(basketNumber, oldBasket);
                        System.out.println(language.translate("REMOVED_ITEM_SUCCESSFULLY!!"));
                    }else{
                        System.out.println(language.translate("BASKET_NOT_FOUND_WITH_THIS_ID!!_ENTER_CORRECT_BASKET_ID"));
                    }
                    break;

                case 4:
                    System.out.print(language.translate("ENTER_BASKET_ID")+": ");
                    int basketIdCase2 = InputHelper.getValidIntegerInput();
                    StoreBasket basketForInfo = store.getBasketById(basketIdCase2);
                    System.out.println(basketForInfo instanceof LoyalCustomerBasket);
                    System.out.println(basketForInfo.getClass().getName());
                    if (basketForInfo != null ) {
                        System.out.println("Basket ID: "+ basketForInfo.getId());
                        System.out.println("Cashier Name: "+ basketForInfo.getCashierName());
                        System.out.println("Store Address: "+ basketForInfo.getStoreAddress());
                        System.out.println("Purchase Time: "+ basketForInfo.getPurchaseTime());
                        System.out.println("Vat: "+ basketForInfo.getVat());
                        System.out.println("Net Amount: "+ basketForInfo.getNetAmount());
                        System.out.println("Additional Discount: "+ basketForInfo.getAdditionalDiscount());
                        System.out.println("Total Amount to pay with vat: "+ basketForInfo.calculatePayment());
                        System.out.println("Items: ");
                        System.out.println("====================================================");
                        for (Item itemForInfo :
                                basketForInfo.getItems()) {
                            itemForInfo.printInfo();
                            System.out.println("====================================================");
                        }


                    }else{
                        System.out.println(language.translate("BASKET_NOT_FOUND_WITH_THIS_ID!!_ENTER_CORRECT_BASKET_ID"));                  }
                    break;

                case 5:
                    System.out.println(language.translate("ENTER_BASKET_ID_FOR_DISCOUNT")+": ");
                    int basketIdForDiscount = InputHelper.getValidIntegerInput();
                    StoreBasket basketForChristmasDiscount = store.getBasketById(basketIdForDiscount);
                    if (basketForChristmasDiscount != null){
                        basketForChristmasDiscount.applyDiscount(10);
                        store.updateBasketById(basketIdForDiscount, basketForChristmasDiscount);
                        System.out.println(language.translate("10%_CHRISTMAS_DISCOUNT_APPLIED"));
                    }else{
                        System.out.println(language.translate("BASKET_NOT_FOUND._DISCOUNT_CAN_NOT_BE_ADDED"));
                    }
                    break;

                case 6:
                    System.out.println(language.translate("ENTER_BASKET_ID_FOR_DISCOUNT")+": ");
                    int basketIdForCoponDiscount = InputHelper.getValidIntegerInput();
                    StoreBasket basketForCouponDiscount = store.getBasketById(basketIdForCoponDiscount);
                    if (basketForCouponDiscount != null){
                        System.out.print(language.translate("ENTER_COUPON_CODE")+": ");
                        int couponCode = InputHelper.getValidIntegerInput();
                        Coupon coupon = store.getCouponByCouponCode(couponCode);
                        if (coupon != null){
                            basketForCouponDiscount.applyCouponDiscount(coupon.getDiscountAmount());
                            store.updateBasketById(basketIdForCoponDiscount, basketForCouponDiscount);
                            System.out.println(language.translate("COUPON_DISCOUNT_APPLIED"));
                        }
                        else{
                            System.out.println(language.translate("COUPON_INVALID"));
                        }

                    }else{
                        System.out.println(language.translate("BASKET_NOT_FOUND._DISCOUNT_CAN_NOT_BE_ADDED"));
                    }
                    break;

                case 7:
                    System.out.println(language.translate("ENTER_BASKET_ID_FOR_PURCHASE")+": ");
                    int basketIdForPurchase = InputHelper.getValidIntegerInput();
                    StoreBasket storeBasketForPurchase = store.getBasketById(basketIdForPurchase);
                    if (storeBasketForPurchase!= null){
                        if (storeBasketForPurchase instanceof LoyalCustomerBasket) {
                            System.out.println("Total Paid with vat:" + ((LoyalCustomerBasket) storeBasketForPurchase).calculatePayment());
                            ((LoyalCustomerBasket) storeBasketForPurchase).completePayment();
                        }
                        else if (storeBasketForPurchase instanceof EmployeeBasket) {
                            System.out.println("Total Paid with vat:" + ((EmployeeBasket) storeBasketForPurchase).calculatePayment());
                            ((EmployeeBasket) storeBasketForPurchase).completePayment();
                        }
                        else
                        {
                            System.out.println("Total Paid with vat:" + storeBasketForPurchase.calculatePayment());
                        }
                        storeBasketForPurchase.completePayment();
                        store.updateBasketById(basketIdForPurchase, storeBasketForPurchase);
                        System.out.println(language.translate("PURCHASED_COMPLETED"));
                    }else{
                        System.out.println(language.translate("BASKET_NOT_FOUND._DISCOUNT_CAN_NOT_BE_ADDED"));
                    }
                    break;

                case 8:
                    isCashierLoggedIn = false;
                    loggedCashier.calculateExtraHours();
                    store.updateCashierById(loggedCashier.getId(), loggedCashier);
                    System.out.println(language.translate("LOG_OUT_SUCCESSFULLY"));
                    break;
                default:
                    System.out.println(language.translate("SELECT_CORRECT_MENU"));
            }
        }


    }


}
