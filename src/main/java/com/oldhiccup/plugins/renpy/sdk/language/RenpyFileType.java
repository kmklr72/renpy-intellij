package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RenpyFileType extends LanguageFileType {

    public static final RenpyFileType INSTANCE = new RenpyFileType();

    private RenpyFileType() {
        super(RenpyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Renpy File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Renpy language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "Renpy";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return RenpyIcons.FILE;
    }

}