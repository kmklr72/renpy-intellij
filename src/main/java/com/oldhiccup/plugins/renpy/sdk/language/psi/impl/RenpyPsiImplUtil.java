// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.oldhiccup.plugins.renpy.sdk.language.RenpyIcons;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyElementFactory;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyProperty;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RenpyPsiImplUtil {

  public static String getKey(RenpyProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(RenpyTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to simple spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(RenpyProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(RenpyTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

  public static String getName(RenpyProperty element) {
    return getKey(element);
  }

  public static PsiElement setName(RenpyProperty element, String newName) {
    ASTNode keyNode = element.getNode().findChildByType(RenpyTypes.KEY);
    if (keyNode != null) {
      RenpyProperty property = RenpyElementFactory.createProperty(element.getProject(), newName);
      ASTNode newKeyNode = property.getFirstChild().getNode();
      element.getNode().replaceChild(keyNode, newKeyNode);
    }
    return element;
  }

  public static PsiElement getNameIdentifier(RenpyProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(RenpyTypes.KEY);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public static ItemPresentation getPresentation(final RenpyProperty element) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return element.getKey();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = element.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Override
      public Icon getIcon(boolean unused) {
        return RenpyIcons.FILE;
      }
    };
  }

}
