// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.oldhiccup.plugins.renpy.sdk.language.RenpyFileType;
import com.oldhiccup.plugins.renpy.sdk.language.RenpyLanguage;
import org.jetbrains.annotations.NotNull;

public class RenpyFile extends PsiFileBase {

  public RenpyFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, RenpyLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return RenpyFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Renpy File";
  }

}
