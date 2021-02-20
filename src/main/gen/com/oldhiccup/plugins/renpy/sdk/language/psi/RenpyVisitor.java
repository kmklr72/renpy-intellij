// This is a generated file. Not intended for manual editing.
package com.oldhiccup.plugins.renpy.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class RenpyVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull RenpyProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull RenpyNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
