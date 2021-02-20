// This is a generated file. Not intended for manual editing.
package com.oldhiccup.plugins.renpy.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyTypes.*;
import com.oldhiccup.plugins.renpy.sdk.language.psi.*;
import com.intellij.navigation.ItemPresentation;

public class RenpyPropertyImpl extends RenpyNamedElementImpl implements RenpyProperty {

  public RenpyPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RenpyVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RenpyVisitor) accept((RenpyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return RenpyPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return RenpyPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return RenpyPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return RenpyPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return RenpyPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return RenpyPsiImplUtil.getPresentation(this);
  }

}
