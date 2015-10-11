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

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgSourceUtil;
import blanco.cg.valueobject.BlancoCgException;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgLangDocTag;
import blanco.cg.valueobject.BlancoCgParameter;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgLangDoc(����h�L�������g)���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B<br>
 * �N���X�A���\�b�h�A�t�B�[���h�ȂǁA�e�팾��h�L�������g��W�J���鋤�ʏ����ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgLangDocRubySourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JAVA;

    /**
     * ����h�L�������g�������Ƀ\�[�X�R�[�h��W�J���܂��B
     * 
     * @param langDoc
     *            ����h�L�������g���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    public void transformLangDoc(final BlancoCgLangDoc langDoc,
            final List<java.lang.String> argSourceLines) {
        argSourceLines.add("#");

        // �J�n�E�I���������{�̂�W�J���܂��B
        transformLangDocBody(langDoc, argSourceLines);

        argSourceLines.add("#");
    }

    /**
     * ����h�L�������g�̂����A�{�̕�����W�J���܂��B
     * 
     * ���̃��\�b�h�̓\�[�X�t�@�C���̃t�@�C���w�b�_�[�W�J��������p����Ă��܂��B
     * 
     * @param langDoc
     * @param argSourceLines
     */
    public void transformLangDocBody(final BlancoCgLangDoc langDoc,
            final List<java.lang.String> argSourceLines) {
        boolean isLangDocTitleStarted = false;

        if (BlancoStringUtil.null2Blank(langDoc.getTitle()).length() > 0) {
            isLangDocTitleStarted = true;
            argSourceLines.add("# "
                    + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                            langDoc.getTitle()));
        }

        // ��s���}���ς݂��ǂ������`�F�b�N���邽�߂̃t���O�B
        boolean isLangDocDescriptionStarted = false;

        for (int indexDescription = 0; indexDescription < langDoc
                .getDescriptionList().size(); indexDescription++) {
            final String strDescrption = langDoc.getDescriptionList().get(
                    indexDescription);

            // ��s�}���B
            if (isLangDocDescriptionStarted == false) {
                isLangDocDescriptionStarted = true;
                if (isLangDocTitleStarted) {
                    argSourceLines.add("#");
                }
            }

            argSourceLines.add("# " + strDescrption);
        }

        // ��s���}���ς݂��ǂ������`�F�b�N���邽�߂̃t���O�B
        boolean isLangDocTagStarted = false;

        // author�ȂǕt������W�J�B
        if (langDoc.getTagList() != null) {
            for (int index = 0; index < langDoc.getTagList().size(); index++) {
                final BlancoCgLangDocTag langDocTag = langDoc.getTagList().get(
                        index);

                // ��s�}���B
                if (isLangDocTagStarted == false) {
                    isLangDocTagStarted = true;
                    argSourceLines.add("#");
                }

                if (langDocTag.getName() == null) {
                    throw new IllegalArgumentException(
                            "BlancoCgLangDocTag��name��null���^�����܂����B"
                                    + langDocTag.toString());
                }
                if (langDocTag.getValue() == null) {
                    throw new IllegalArgumentException(
                            "BlancoCgLangDocTag��value��null���^�����܂����B"
                                    + langDocTag.toString());
                }

                final StringBuffer buf = new StringBuffer();
                buf.append("#" + langDocTag.getName() + ":: ");
                if (BlancoStringUtil.null2Blank(langDocTag.getKey()).length() > 0) {
                    buf.append(langDocTag.getKey() + " ");
                }
                buf.append(BlancoCgSourceUtil.escapeStringAsLangDoc(
                        TARGET_LANG, langDocTag.getValue()));
                argSourceLines.add(buf.toString());
            }
        }

        // ���\�b�h�p�����[�^��W�J�B
        for (int indexParameter = 0; indexParameter < langDoc
                .getParameterList().size(); indexParameter++) {
            final BlancoCgParameter cgParameter = langDoc.getParameterList()
                    .get(indexParameter);

            // ��s�}���B
            if (isLangDocTagStarted == false) {
                isLangDocTagStarted = true;
                argSourceLines.add("#");
            }

            final StringBuffer bufParameter = new StringBuffer();
            bufParameter.append("# param " + cgParameter.getName());
            if (BlancoStringUtil.null2Blank(cgParameter.getDescription())
                    .length() > 0) {
                bufParameter.append(" "
                        + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                                cgParameter.getDescription()));
            }
            argSourceLines.add(bufParameter.toString());
        }

        if (langDoc.getReturn() != null
                && langDoc.getReturn().getType().getName().equals("void") == false) {

            // ��s�}���B
            if (isLangDocTagStarted == false) {
                isLangDocTagStarted = true;
                argSourceLines.add("#");
            }

            final StringBuffer bufReturn = new StringBuffer();
            bufReturn.append("# return");
            if (BlancoStringUtil.null2Blank(
                    langDoc.getReturn().getDescription()).length() > 0) {
                bufReturn.append(" "
                        + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                                langDoc.getReturn().getDescription()));
            }
            argSourceLines.add(bufReturn.toString());
        }

        // throws���X�g��W�J�B
        for (int indexThrow = 0; indexThrow < langDoc.getThrowList().size(); indexThrow++) {
            final BlancoCgException cgException = langDoc.getThrowList().get(
                    indexThrow);

            // ��s�}���B
            if (isLangDocTagStarted == false) {
                isLangDocTagStarted = true;
                argSourceLines.add("#");
            }

            final StringBuffer bufThrow = new StringBuffer();

            // ����h�L�������g�����ɂ����ẮAblancoCg��Type�Ɋւ��鋤�ʏ����𗘗p���邱�Ƃ͂ł��܂���B
            // �ʂɋL�q���s���܂��B
            bufThrow.append("# @throws "
                    + BlancoNameUtil.trimJavaPackage(cgException.getType()
                            .getName()));
            if (BlancoStringUtil.null2Blank(cgException.getDescription())
                    .length() > 0) {
                bufThrow.append(" "
                        + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                                cgException.getDescription()));
            }
            argSourceLines.add(bufThrow.toString());
        }
    }
}
