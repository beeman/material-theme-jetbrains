/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.idea.actions;

import com.chrisrm.idea.MTAnalytics;
import com.chrisrm.idea.MTConfig;
import com.chrisrm.idea.MTThemeManager;
import com.chrisrm.idea.messages.MaterialThemeBundle;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public final class MTMaterialFontsAction extends ToggleAction {


  @Override
  public boolean isSelected(@NotNull final AnActionEvent e) {
    return MTConfig.getInstance().isUseMaterialFont();
  }

  @Override
  public void setSelected(@NotNull final AnActionEvent e, final boolean state) {

    if (state) {
      Messages.showWarningDialog(
          MaterialThemeBundle.message("mt.useMaterialFonts2.message"),
          MaterialThemeBundle.message("mt.useMaterialFonts2.title")
      );
    }

    MTThemeManager.getInstance().toggleMaterialFonts();
    MTAnalytics.getInstance().track(MTAnalytics.MATERIAL_FONTS, state);

  }

  /**
   * Disable Contrast Mode if Material Theme is disabled
   *
   * @param e event
   */
  @Override
  public void update(@NotNull final AnActionEvent e) {
  }
}
