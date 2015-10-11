/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.python;

import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgField���\�[�X�R�[�h�ւƓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgFieldPythonSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JAVA;

    /**
     * �����Ńt�B�[���h��W�J���܂��B
     * 
     * @param cgField
     *            �����ΏۂƂȂ�t�B�[���h�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     * @param argIsInterface
     *            �C���^�t�F�[�X���ǂ����B�N���X�̏ꍇ�ɂ�false�B�C���^�t�F�[�X�̏ꍇ�ɂ�true�B
     */
    public void transformField(final BlancoCgField cgField,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines,
            final boolean argIsInterface) {
        if (BlancoStringUtil.null2Blank(cgField.getName()).length() == 0) {
            throw new IllegalArgumentException("�t�B�[���h�̖��O�ɓK�؂Ȓl���ݒ肳��Ă��܂���B");
        }

        // Python�ł̓t�B�[���h�̌^��ݒ肷��K�v�͂�܂���B
        // if (BlancoStringUtil.null2Blank(cgField.getType().getName()).length()
        // == 0) {
        // throw new IllegalArgumentException("�t�B�[���h[" + cgField.getName()
        // + "]�̌^���K�؂Ȓl���ݒ肳��Ă��܂���B");
        // }

        // �L�������킳�����s��t�^���܂��B
        argSourceLines.add("");

        // �ŏ��Ƀt�B�[���h����LangDoc�ɓW�J�B
        if (cgField.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgField.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgField.getLangDoc().getTitle() == null) {
            cgField.getLangDoc().setTitle(cgField.getDescription());
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocPythonSourceExpander().transformLangDoc(cgField
                .getLangDoc(), argSourceLines);

        final StringBuffer buf = new StringBuffer();

        // if (BlancoStringUtil.null2Blank(cgField.getAccess()).length() > 0) {
        // if (argIsInterface && cgField.getAccess().equals("public")) {
        // // �C���^�t�F�[�X����public�̏ꍇ�ɂ͏o�͂�}�����܂��B
        // // �����Checkstyle�΍�ƂȂ�܂��B
        // } else {
        // buf.append(cgField.getAccess() + " ");
        // }
        // }
        // if (cgField.getStatic()) {
        // buf.append("static ");
        // }
        // if (cgField.getFinal()) {
        // buf.append("final ");
        // }

        // import���Ɍ^��ǉ��B
        argSourceFile.getImportList().add(cgField.getType().getName());

        // �t�B�[���h�����̖{�̕�����W�J���܂��B
        // buf.append(BlancoCgTypeJavaSourceExpander.toTypeString(cgField
        // .getType())
        // + " ");
        buf.append(cgField.getName());

        // �f�t�H���g�l�̎w�肪����ꍇ�ɂ͂����W�J���܂��B
        if (BlancoStringUtil.null2Blank(cgField.getDefault()).length() > 0) {
            buf.append(" = " + cgField.getDefault());
        }
        // buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
        argSourceLines.add(buf.toString());
    }
}
