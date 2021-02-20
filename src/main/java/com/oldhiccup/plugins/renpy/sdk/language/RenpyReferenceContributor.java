// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class RenpyReferenceContributor extends PsiReferenceContributor {

  @Override
  public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
    registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
            new PsiReferenceProvider() {
              @NotNull
              @Override
              public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                           @NotNull ProcessingContext context) {
                PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                String value = literalExpression.getValue() instanceof String ?
                        (String) literalExpression.getValue() : null;
                if ((value != null && value.startsWith(RenpyAnnotator.RENPY_PREFIX_STR + RenpyAnnotator.RENPY_SEPARATOR_STR))) {
                  TextRange property = new TextRange(RenpyAnnotator.RENPY_PREFIX_STR.length() + RenpyAnnotator.RENPY_SEPARATOR_STR.length() + 1,
                          value.length() + 1);
                  return new PsiReference[]{new RenpyReference(element, property)};
                }
                return PsiReference.EMPTY_ARRAY;
              }
            });
  }

}
