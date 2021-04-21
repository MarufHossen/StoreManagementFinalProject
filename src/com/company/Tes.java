package com.company;

import com.company.helper.InputHelper;
import com.company.language.Language;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Tes {
    public static void main(String[] args) {
//        Date date = new Date();
//        long time = date.getTime();
//        System.out.println(date.getTime());
//        Scanner scanner = new Scanner(System.in);
//        scanner.next();
//
//        Date date1 = new Date();
//        long time2 = date1.getTime();
//        System.out.println(time2);
//        System.out.println((double)(time2-time)/(1000*60*60));
        Language language = new Language();

        System.out.println(language.translate("hello"));
        language.changeLanguage("ge","GE");
        System.out.println(language.translate("hello"));

        int test = InputHelper.getValidIntegerInput();
        System.out.println(test);
    }
}
