/*
 * Copyright 2024 LY Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linecorp.android.featureflag.ij.plugin.linemarker

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiIdentifier
import com.intellij.psi.PsiReferenceExpression

/**
 * An implementation of [FeatureFlagLineMarkerProvider] for Java.
 */
class FeatureFlagJavaLineMarkerProvider : FeatureFlagLineMarkerProvider() {

    override fun isFeatureFlagPropertyIdentifier(element: PsiElement): Boolean {
        if (element !is PsiIdentifier) {
            return false
        }
        val parent = element.parent as? PsiReferenceExpression ?: return false
        val resolvedField = parent.resolve() as? PsiField ?: return false
        return isFeatureFlagField(resolvedField)
    }
}
