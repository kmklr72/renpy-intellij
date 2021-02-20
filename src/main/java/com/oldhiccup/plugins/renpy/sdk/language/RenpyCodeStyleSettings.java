// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.oldhiccup.plugins.renpy.sdk.language;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class RenpyCodeStyleSettings extends CustomCodeStyleSettings {

  public RenpyCodeStyleSettings(CodeStyleSettings settings) {
    super("RenpyCodeStyleSettings", settings);
  }

}
