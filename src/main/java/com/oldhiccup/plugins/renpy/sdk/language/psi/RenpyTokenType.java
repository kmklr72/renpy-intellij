// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.oldhiccup.plugins.renpy.sdk.language.RenpyLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RenpyTokenType extends IElementType {

  public RenpyTokenType(@NotNull @NonNls String debugName) {
    super(debugName, RenpyLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "RenpyTokenType." + super.toString();
  }

}
