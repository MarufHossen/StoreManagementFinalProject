package com.company.language;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private String lang;
    private String country;
    private Locale locale;
    private ResourceBundle resourceBundle;
    public Language() {
        this.lang = "en";
        this.country = "US";
        this.locale = new Locale(lang,country);
        resourceBundle = ResourceBundle.getBundle("com.company.resources.translation",locale);
    }

    public String translate(String text){
        return resourceBundle.getString(text);
    }
    public void changeLanguage(String lang, String country){
        this.lang = lang;
        this.country = country;
        this.locale = new Locale(lang,country);
        this.resourceBundle = ResourceBundle.getBundle("com.company.resources.translation",locale);
    }
}
