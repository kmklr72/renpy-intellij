// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.oldhiccup.plugins.renpy.sdk.language.RenpyFileType;

public class RenpyElementFactory {

  public static RenpyProperty createProperty(Project project, String name) {
    final RenpyFile file = createFile(project, name);
    return (RenpyProperty) file.getFirstChild();
  }

  public static RenpyFile createFile(Project project, String text) {
    String name = "dummy.renpy";
    return (RenpyFile) PsiFileFactory.getInstance(project).createFileFromText(name, RenpyFileType.INSTANCE, text);
  }

  public static RenpyProperty createProperty(Project project, String name, String value) {
    final RenpyFile file = createFile(project, name + " = " + value);
    return (RenpyProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final RenpyFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

}
