/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.js;

import java.util.List;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgClass;
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
class BlancoCgFieldJsSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JS;

    /**
     * �����Ńt�B�[���h��W�J���܂��B
     * 
     * @param cgClass
     *            �����ΏۂƂȂ�N���X�B
     * @param cgField
     *            �����ΏۂƂȂ�t�B�[���h�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     */
    public void transformField(final BlancoCgClass cgClass,
            final BlancoCgField cgField,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (BlancoStringUtil.null2Blank(cgField.getName()).length() == 0) {
            throw new IllegalArgumentException("�t�B�[���h�̖��O�ɓK�؂Ȓl���ݒ肳��Ă��܂���B");
        }
        if (BlancoStringUtil.null2Blank(cgField.getType().getName()).length() == 0) {
            throw new IllegalArgumentException("�t�B�[���h[" + cgField.getName()
                    + "]�̌^���K�؂Ȓl���ݒ肳��Ă��܂���B");
        }

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

        if (BlancoStringUtil.null2Blank(cgField.getAccess()).equals("private")
                || BlancoStringUtil.null2Blank(cgField.getAccess()).equals(
                        "protected")) {
            // protected �܂��� private �̏ꍇ�ɂ̂݃X�R�[�v�\����W�J���܂��B
            cgField.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            cgField.getAccess(), null, ""));
        }

        if (BlancoStringUtil.null2Blank(cgField.getType().getName()).length() > 0
                || BlancoStringUtil.null2Blank(cgField.getType().getName())
                        .equals("void") == false) {
            cgField.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            "type", null, cgField.getType().getName()));
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocJsSourceExpander().transformLangDoc(cgField
                .getLangDoc(), argSourceLines);

        final StringBuffer buf = new StringBuffer();

        if (cgField.getStatic()) {
            // �N���X�t�B�[���h (static�ȃt�B�[���h)�́A���L�̂悤�ɃN���X��.�t�B�[���h���Œ��ړW�J����܂��B
            buf.append(cgClass.getName() + ".");
        } else {
            // �ʏ�̃t�B�[���h�ϐ��� this.�t�B�[���h�� �̂悤�ɓW�J���܂��B
            buf.append("this.");
        }

        // �t�B�[���h�����̖{�̕�����W�J���܂��B
        buf.append(cgField.getName());

        // �f�t�H���g�l�̎w�肪����ꍇ�ɂ͂����W�J���܂��B
        if (BlancoStringUtil.null2Blank(cgField.getDefault()).length() > 0) {
            buf.append(" = " + cgField.getDefault()
                    + BlancoCgLineUtil.getTerminator(TARGET_LANG));
        } else {
            buf.append(" = null" + BlancoCgLineUtil.getTerminator(TARGET_LANG));
        }

        argSourceLines.add(buf.toString());

        // import���Ɍ^��ǉ��B
        argSourceFile.getImportList().add(cgField.getType().getName());
    }
}
