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

package com.linecorp.android.featureflag.ij.plugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.linecorp.android.featureflag.ij.plugin.FeatureFlagLanguage
import com.linecorp.android.featureflag.ij.plugin.lexer.FeatureFlagLexer
import com.linecorp.android.featureflag.ij.plugin.psi.FeatureFlagFile
import com.linecorp.android.featureflag.ij.plugin.psi.FeatureFlagTokenSets
import com.linecorp.android.featureflag.ij.plugin.psi.FeatureFlagTypes

/**
 * An implementation of [ParserDefinition] for feature flag language.
 */
class FeatureFlagParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = FeatureFlagLexer()

    override fun getCommentTokens(): TokenSet = FeatureFlagTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createParser(project: Project?): PsiParser = FeatureFlagParser()

    override fun getFileNodeType(): IFileElementType = FILE_ELEMENT_TYPE

    override fun createFile(viewProvider: FileViewProvider): PsiFile =
        FeatureFlagFile(viewProvider)

    override fun createElement(node: ASTNode?): PsiElement =
        FeatureFlagTypes.Factory.createElement(node)

    companion object {
        private val FILE_ELEMENT_TYPE: IFileElementType = IFileElementType(FeatureFlagLanguage)
    }
}
