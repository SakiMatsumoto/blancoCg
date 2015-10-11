/*
 * blanco Framework
 * Copyright (C) 2004-2013 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.cpp11;

import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.util.BlancoCgSourceUtil;
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgEnumElement;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgEnum���\�[�X�R�[�h�ւƓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgEnumCpp11SourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JAVA;

    /**
     * �����ŗ񋓑̂�W�J���܂��B
     * 
     * @param cgEnum
     *            �����ΏۂƂȂ�񋓑́B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     * @param argIsInterface
     *            �C���^�t�F�[�X���ǂ����B�N���X�̏ꍇ�ɂ�false�B�C���^�t�F�[�X�̏ꍇ�ɂ�true�B
     */
    public void transformEnum(final BlancoCgEnum cgEnum,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (BlancoStringUtil.null2Blank(cgEnum.getName()).length() == 0) {
            throw new IllegalArgumentException("�񋓑̖̂��O�ɓK�؂Ȓl���ݒ肳��Ă��܂���B");
        }

        // �L�������킳�����s��t�^���܂��B
        argSourceLines.add("");

        // �ŏ��Ƀt�B�[���h����LangDoc�ɓW�J�B
        if (cgEnum.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgEnum.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgEnum.getLangDoc().getTitle() == null) {
            cgEnum.getLangDoc().setTitle(cgEnum.getDescription());
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocCpp11SourceExpander().transformLangDoc(cgEnum
                .getLangDoc(), argSourceLines);

        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgEnum.getAccess()).length() > 0) {
            buf.append(cgEnum.getAccess() + ": ");
        }

        // �񋓑̐����̖{�̕�����W�J���܂��B
        buf.append("enum " + cgEnum.getName());

        // �v�f��W�J���܂��B
        buf.append("{");
        boolean isFirstElement = true;
        for (BlancoCgEnumElement element : cgEnum.getElementList()) {
            if (isFirstElement) {
                isFirstElement = false;
            } else {
                buf.append(", ");
            }
            buf.append(element.getName());

            // �f�t�H���g�l���o�́B
            if (BlancoStringUtil.null2Blank(element.getDefault()).length() > 0) {
                buf.append(" = " + element.getDefault());
            }

            if (BlancoStringUtil.null2Blank(element.getDescription()).length() > 0) {
                buf.append(" /* "
                        + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                                element.getDescription()) + " */");
            }
        }
        buf.append("}");

        buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
        argSourceLines.add(buf.toString());
    }
}
