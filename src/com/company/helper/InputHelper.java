package com.company.helper;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static int getValidIntegerInput(){
            try {
                return scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Invalid Input!");
                System.exit(0);
                return -1;
            }
    }

}
