// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RenpyFormattingModelBuilder implements FormattingModelBuilder {

  private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
    return new SpacingBuilder(settings, RenpyLanguage.INSTANCE)
            .around(RenpyTypes.SEPARATOR)
            .spaceIf(settings.getCommonSettings(RenpyLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
            .before(RenpyTypes.PROPERTY)
            .none();
  }

  @NotNull
  @Override
  public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
    return FormattingModelProvider
            .createFormattingModelForPsiFile(element.getContainingFile(),
                    new RenpyBlock(element.getNode(),
                            Wrap.createWrap(WrapType.NONE, false),
                            Alignment.createAlignment(),
                            createSpaceBuilder(settings)),
                    settings);
  }

  @Nullable
  @Override
  public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
    return null;
  }

}
