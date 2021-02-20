// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyTypes;
import org.jetbrains.annotations.NotNull;

public class RenpyCompletionContributor extends CompletionContributor {

  public RenpyCompletionContributor() {
    extend(CompletionType.BASIC, PlatformPatterns.psiElement(RenpyTypes.VALUE),
            new CompletionProvider<CompletionParameters>() {
              public void addCompletions(@NotNull CompletionParameters parameters,
                                         @NotNull ProcessingContext context,
                                         @NotNull CompletionResultSet resultSet) {
                resultSet.addElement(LookupElementBuilder.create("Hello"));
              }
            }
    );
  }

}
