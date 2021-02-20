// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyProperty;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RenpyFindUsagesProvider implements FindUsagesProvider {

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new com.oldhiccup.plugins.renpy.sdk.language.RenpyLexerAdapter(),
            TokenSet.create(RenpyTypes.KEY),
            TokenSet.create(RenpyTypes.COMMENT),
            TokenSet.EMPTY);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiNamedElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof RenpyProperty) {
      return "renpy property";
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof RenpyProperty) {
      return ((RenpyProperty) element).getKey();
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof RenpyProperty) {
      return ((RenpyProperty) element).getKey() + RenpyAnnotator.RENPY_SEPARATOR_STR + ((RenpyProperty) element).getValue();
    } else {
      return "";
    }
  }

}
