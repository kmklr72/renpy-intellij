// This is a generated file. Not intended for manual editing.
package com.oldhiccup.plugins.renpy.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.oldhiccup.plugins.renpy.sdk.language.psi.impl.*;

public interface RenpyTypes {

  IElementType PROPERTY = new RenpyElementType("PROPERTY");

  IElementType COMMENT = new RenpyTokenType("COMMENT");
  IElementType CRLF = new RenpyTokenType("CRLF");
  IElementType KEY = new RenpyTokenType("KEY");
  IElementType SEPARATOR = new RenpyTokenType("SEPARATOR");
  IElementType VALUE = new RenpyTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new RenpyPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
