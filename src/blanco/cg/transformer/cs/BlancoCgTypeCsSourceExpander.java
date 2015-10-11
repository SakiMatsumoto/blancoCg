/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.cs;

import blanco.cg.valueobject.BlancoCgType;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgType���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgTypeCsSourceExpander {
    /**
     * �v���O���~���O����̗\���ꗗ�B
     */
    private static final String[] LANGUAGE_RESERVED_KEYWORD = { "void", "byte",
            "short", "int", "long", "char", "float", "double", "decimal",
            "bool", "string" };

    /**
     * blancoCg�^���A��̓I�ȕ�����ւƕϊ����܂��B
     * 
     * �z���\��[]��W�F�l���N�X���W�J���܂��B<br>
     * TODO �����p�b�P�[�W�Ԃł̓���N���X��(��:java.util.Date��java.sql.Date�Ȃ�)�͍l�����Ă��܂���B
     * �����p�b�P�[�W�̓���N���X������̃\�[�X�t�@�C�����ŗ��p����ׂ̏��@�\�͖��񋟂ł��B
     * 
     * @param argType
     *            blancoCg��̌^�B
     * @return �v���O���~���O����ɂ�����^������������B
     */
    public static String toTypeString(final BlancoCgType argType) {
        final StringBuffer buf = new StringBuffer();
        buf.append(BlancoNameUtil.trimJavaPackage(argType.getName()));

        // �z���W�J���܂��B
        if (argType.getArray()) {
            buf.append("[");
            for (int dimension = 1; dimension < argType.getArrayDimension(); dimension++) {
                buf.append(",");
            }
            buf.append("]");
        }

        // �W�F�l���N�X��W�J���܂��B
        if (BlancoStringUtil.null2Blank(argType.getGenerics()).length() > 0) {
            // TODO C#.NET�̃W�F�l���N�X���ēx��������K�v������܂��B
            buf.append(argType.getGenerics());
        }

        return buf.toString();
    }

    /**
     * �^����ꂽ�����񂪃v���O���~���O����̗\���ł��邩�ǂ������`�F�b�N���܂��B
     * 
     * @param argCheck
     *            �`�F�b�N������������B
     * @return �v���O���~���O����̗\���ɊY���������ǂ����B
     */
    public static boolean isLanguageReservedKeyword(final String argCheck) {
        for (int index = 0; index < LANGUAGE_RESERVED_KEYWORD.length; index++) {
            if (LANGUAGE_RESERVED_KEYWORD[index].equals(argCheck)) {
                // ���̕�����̓v���O���~���O����̗\���ł��B
                return true;
            }
        }

        // �L�[���[�h�Ƀq�b�g���܂���ł����B���̕�����̓v���O���~���O����̗\���ł͂���܂���B
        return false;
    }
}
