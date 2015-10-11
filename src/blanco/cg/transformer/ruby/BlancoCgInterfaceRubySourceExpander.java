/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.ruby;

import java.util.List;

import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.cg.valueobject.BlancoCgType;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgInterface���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgInterfaceRubySourceExpander {

    /**
     * ������interface��W�J���܂��B
     * 
     * @param cgInterface
     *            �����ΏۂƂȂ�C���^�t�F�[�X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    public void transformInterface(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        // �C���^�t�F�[�X�̏ꍇ�ɂ� �t�B�[���h�⃁�\�b�h����public�����O����܂��B

        // �ŏ��ɃC���^�t�F�[�X����LangDoc�ɓW�J�B
        if (cgInterface.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgInterface.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgInterface.getLangDoc().getTitle() == null) {
            cgInterface.getLangDoc().setTitle(cgInterface.getDescription());
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocRubySourceExpander().transformLangDoc(cgInterface
                .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgInterface, argSourceLines);

        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgInterface.getAccess()).length() > 0) {
            buf.append(cgInterface.getAccess() + " ");
        }
        // static��final�͓W�J���܂���B
        buf.append("interface " + cgInterface.getName());

        // �����Őe�N���X��W�J�B
        expandExtendClassList(cgInterface, buf);

        // ���|�C���g: �e�C���^�t�F�[�X�W�J�� interface�ɂ͑��݂��܂���B

        buf.append(" {");

        argSourceLines.add(buf.toString());

        // �����Ńt�B�[���h��W�J�B
        expandFieldList(cgInterface, argSourceFile, argSourceLines);

        // �����Ń��\�b�h��W�J�B
        expandMethodList(cgInterface, argSourceFile, argSourceLines);

        argSourceLines.add("}");
    }

    /**
     * �A�m�e�[�V������W�J���܂��B
     * 
     * @param cgInterface
     *            �C���^�t�F�[�X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    private void expandAnnotationList(final BlancoCgInterface cgInterface,
            final List<java.lang.String> argSourceLines) {
        for (int index = 0; index < cgInterface.getAnnotationList().size(); index++) {
            final String strAnnotation = cgInterface.getAnnotationList().get(
                    index);

            // Java�����Annotation�� @ ����L�q���܂��B
            argSourceLines.add("@" + strAnnotation);
        }
    }

    /**
     * �e�N���X��W�J���܂��B
     * 
     * @param cgClass
     * @param buf
     */
    private void expandExtendClassList(final BlancoCgInterface cgClass,
            final StringBuffer buf) {
        for (int index = 0; index < cgClass.getExtendClassList().size(); index++) {
            final BlancoCgType type = cgClass.getExtendClassList().get(index);

            if (index == 0) {
                buf.append(" extends "
                        + BlancoCgTypeRubySourceExpander.toTypeString(type));
            } else {
                throw new IllegalArgumentException("Java����ł͌p���͈�񂵂����{�ł��܂���B");
            }
        }
    }

    /**
     * �܂܂��e�X�̃t�B�[���h��W�J���܂��B
     * 
     * @param cgInterface
     * @param argSourceFile
     * @param argSourceLines
     */
    private void expandFieldList(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgInterface.getFieldList() == null) {
            // �t�B�[���h�̃��X�g��null���^�����܂����B
            // ���Ȃ炸�t�B�[���h�̃��X�g�ɂ�List���Z�b�g���Ă��������B
            throw new IllegalArgumentException("�t�B�[���h�̃��X�g��null���^�����܂����B");
        }

        for (int index = 0; index < cgInterface.getFieldList().size(); index++) {
            final BlancoCgField cgField = cgInterface.getFieldList().get(index);

            new BlancoCgFieldRubySourceExpander().transformField(cgField,
                    argSourceFile, argSourceLines, true);
        }
    }

    /**
     * �܂܂��e�X�̃��\�b�h��W�J���܂��B
     * 
     * @param cgInterface
     * @param argSourceFile
     * @param argSourceLines
     */
    private void expandMethodList(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgInterface.getMethodList() == null) {
            throw new IllegalArgumentException("���\�b�h�̃��X�g��null���^�����܂����B");
        }
        for (int index = 0; index < cgInterface.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgInterface.getMethodList().get(
                    index);

            new BlancoCgMethodRubySourceExpander().transformMethod(cgMethod,
                    argSourceFile, argSourceLines, true);
        }
    }
}
