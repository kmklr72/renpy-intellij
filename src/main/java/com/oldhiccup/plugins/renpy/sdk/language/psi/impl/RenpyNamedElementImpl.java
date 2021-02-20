// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class RenpyNamedElementImpl extends ASTWrapperPsiElement implements RenpyNamedElement {

  public RenpyNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

}
