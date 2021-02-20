// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RenpyAnnotator implements Annotator {

  // Define strings for the Renpy language prefix - used for annotations, line markers, etc.
  public static final String RENPY_PREFIX_STR = "renpy";
  public static final String RENPY_SEPARATOR_STR = ":";

  @Override
  public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
    // Ensure the Psi Element is an expression
    if (!(element instanceof PsiLiteralExpression)) {
      return;
    }

    // Ensure the Psi element contains a string that starts with the prefix and separator
    PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
    String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
    if ((value == null) || !value.startsWith(RENPY_PREFIX_STR + RENPY_SEPARATOR_STR)) {
      return;
    }

    // Define the text ranges (start is inclusive, end is exclusive)
    // "renpy:key"
    //  01234567890
    TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset(), RENPY_PREFIX_STR.length() + 1);
    TextRange separatorRange = TextRange.from(prefixRange.getEndOffset(), RENPY_SEPARATOR_STR.length());
    TextRange keyRange = new TextRange(separatorRange.getEndOffset(), element.getTextRange().getEndOffset() - 1);

    // highlight "renpy" prefix and ":" separator
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create();
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(separatorRange).textAttributes(com.oldhiccup.plugins.renpy.sdk.language.RenpySyntaxHighlighter.SEPARATOR).create();


    // Get the list of properties for given key
    String key = value.substring(RENPY_PREFIX_STR.length() + RENPY_SEPARATOR_STR.length());
    List<RenpyProperty> properties = com.oldhiccup.plugins.renpy.sdk.language.RenpyUtil.findProperties(element.getProject(), key);
    if (properties.isEmpty()) {
      holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
              .range(keyRange)
              .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
              // ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
              .withFix(new RenpyCreatePropertyQuickFix(key))
              .create();
    } else {
      // Found at least one property, force the text attributes to Renpy syntax value character
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
              .range(keyRange).textAttributes(com.oldhiccup.plugins.renpy.sdk.language.RenpySyntaxHighlighter.VALUE).create();
    }
  }

}
