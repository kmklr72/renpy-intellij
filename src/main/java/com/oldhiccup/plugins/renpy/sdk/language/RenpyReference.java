// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RenpyReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

  private final String key;

  public RenpyReference(@NotNull PsiElement element, TextRange textRange) {
    super(element, textRange);
    key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
  }

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    Project project = myElement.getProject();
    final List<RenpyProperty> properties = com.oldhiccup.plugins.renpy.sdk.language.RenpyUtil.findProperties(project, key);
    List<ResolveResult> results = new ArrayList<>();
    for (RenpyProperty property : properties) {
      results.add(new PsiElementResolveResult(property));
    }
    return results.toArray(new ResolveResult[results.size()]);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    ResolveResult[] resolveResults = multiResolve(false);
    return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    Project project = myElement.getProject();
    List<RenpyProperty> properties = com.oldhiccup.plugins.renpy.sdk.language.RenpyUtil.findProperties(project);
    List<LookupElement> variants = new ArrayList<>();
    for (final RenpyProperty property : properties) {
      if (property.getKey() != null && property.getKey().length() > 0) {
        variants.add(LookupElementBuilder
                .create(property).withIcon(RenpyIcons.FILE)
                .withTypeText(property.getContainingFile().getName())
        );
      }
    }
    return variants.toArray();
  }

}
