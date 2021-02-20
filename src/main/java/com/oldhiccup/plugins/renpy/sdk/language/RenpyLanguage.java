package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.lang.Language;

public class RenpyLanguage extends Language {
    public static final RenpyLanguage INSTANCE = new RenpyLanguage();

    private RenpyLanguage() {
        super("Renpy");
    }

}
