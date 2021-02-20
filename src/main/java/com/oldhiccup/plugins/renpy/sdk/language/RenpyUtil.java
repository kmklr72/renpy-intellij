// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyFile;
import com.oldhiccup.plugins.renpy.sdk.language.psi.RenpyProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RenpyUtil {

  /**
   * Searches the entire project for Renpy language files with instances of the Renpy property with the given key.
   *
   * @param project current project
   * @param key     to check
   * @return matching properties
   */
  public static List<RenpyProperty> findProperties(Project project, String key) {
    List<RenpyProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(RenpyFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      RenpyFile renpyFile = (RenpyFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (renpyFile != null) {
        RenpyProperty[] properties = PsiTreeUtil.getChildrenOfType(renpyFile, RenpyProperty.class);
        if (properties != null) {
          for (RenpyProperty property : properties) {
            if (key.equals(property.getKey())) {
              result.add(property);
            }
          }
        }
      }
    }
    return result;
  }

  public static List<RenpyProperty> findProperties(Project project) {
    List<RenpyProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(RenpyFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      RenpyFile renpyFile = (RenpyFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (renpyFile != null) {
        RenpyProperty[] properties = PsiTreeUtil.getChildrenOfType(renpyFile, RenpyProperty.class);
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }

}
