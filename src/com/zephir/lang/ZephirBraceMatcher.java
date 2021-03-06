package com.zephir.lang;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.zephir.psi.ZephirTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Nikita Gusakov
 */
public class ZephirBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] BRACE_PAIRS = {
            new BracePair(ZephirTypes.BRACKET_OPEN, ZephirTypes.BRACKET_CLOSE, true),
            new BracePair(ZephirTypes.SBRACKET_OPEN, ZephirTypes.SBRACKET_CLOSE, false),
            new BracePair(ZephirTypes.PARENTHESES_OPEN, ZephirTypes.PARENTHESES_CLOSE, false)
    };

    @Override
    public BracePair[] getPairs() {
        return BRACE_PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType braceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
