/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.vb;

import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgSourceUtil;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgParameter;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgLangDoc(����h�L�������g)���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B<br>
 * �N���X�A���\�b�h�A�t�B�[���h�ȂǁA�e�팾��h�L�������g��W�J���鋤�ʏ����ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgLangDocVbSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.VB;

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
        // �J�n�E�I���������{�̂�W�J���܂��B
        transformLangDocBody(langDoc, argSourceLines, false);
    }

    /**
     * ����h�L�������g�̂����A�{�̕�����W�J���܂��B
     * 
     * ���̃��\�b�h�̓\�[�X�t�@�C���̃t�@�C���w�b�_�[�W�J��������p����Ă��܂��B
     * 
     * @param langDoc
     * @param argSourceLines
     * @param isFileHeader
     *            �t�@�C���w�b�_���ǂ����B
     */
    public void transformLangDocBody(final BlancoCgLangDoc langDoc,
            final List<java.lang.String> argSourceLines,
            final boolean isFileHeader) {
        boolean isLangDocTitleStarted = false;

        String commentString = "''' ";
        if (isFileHeader) {
            commentString = "''' ";
        }

        if (BlancoStringUtil.null2Blank(langDoc.getTitle()).length() > 0) {
            isLangDocTitleStarted = true;
            argSourceLines.add(commentString
                    + "<summary>"
                    + BlancoCgSourceUtil.escapeStringAsLangDoc(TARGET_LANG,
                            langDoc.getTitle()) + "</summary>");
        }

        // ��s���}���ς݂��ǂ������`�F�b�N���邽�߂̃t���O�B
        boolean isLangDocDescriptionStarted = false;

        for (int indexDescription = 0; indexDescription < langDoc
                .getDescriptionList().size(); indexDescription++) {
            final String strDescrption = langDoc.getDescriptionList().get(
                    indexDescription);

            if (isLangDocDescriptionStarted == false) {
                if (isLangDocTitleStarted == false) {
                    isLangDocTitleStarted = true;
                    argSourceLines.add(commentString
                            + "<summary>"
                            + BlancoCgSourceUtil.escapeStringAsLangDoc(
                                    TARGET_LANG, strDescrption) + "</summary>");
                } else {
                    isLangDocDescriptionStarted = true;
                    argSourceLines.add(commentString + "<remarks>");
                    argSourceLines.add(commentString + "<newpara>"
                            + strDescrption + "</newpara>");
                }
            } else {
                argSourceLines.add(commentString + "<newpara>" + strDescrption
                        + "</newpara>");
            }
        }

        if (isLangDocDescriptionStarted) {
            argSourceLines.add(commentString + "</remarks>");
        }

        // TODO author��W�J�B

        // TODO author�ȊO�̓W�J���������邱�ƁB

        // ���\�b�h�p�����[�^��W�J�B
        for (int indexParameter = 0; indexParameter < langDoc
                .getParameterList().size(); indexParameter++) {
            final BlancoCgParameter cgParameter = langDoc.getParameterList()
                    .get(indexParameter);

            final StringBuffer bufParameter = new StringBuffer();
            bufParameter.append(commentString + "<param name=\""
                    + cgParameter.getName() + "\">");
            if (BlancoStringUtil.null2Blank(cgParameter.getDescription())
                    .length() > 0) {
                bufParameter.append(BlancoCgSourceUtil.escapeStringAsLangDoc(
                        TARGET_LANG, cgParameter.getDescription()));
            }
            bufParameter.append("</param>");
            argSourceLines.add(bufParameter.toString());
        }

        if (langDoc.getReturn() != null
                && langDoc.getReturn().getType().getName().equals("void") == false) {

            final StringBuffer bufReturn = new StringBuffer();
            bufReturn.append(commentString + "<returns>");
            if (BlancoStringUtil.null2Blank(
                    langDoc.getReturn().getDescription()).length() > 0) {
                bufReturn.append(BlancoCgSourceUtil.escapeStringAsLangDoc(
                        TARGET_LANG, langDoc.getReturn().getDescription()));
            }
            bufReturn.append("</returns>");
            argSourceLines.add(bufReturn.toString());
        }

        // ��throws���X�g�W�J�� C#.NET�ɂ͑��݂��܂���B
        // TODO throw���X�g�W�J�ɂ��āA����h�L�������g�̐��������ւƓW�J���邱�ƁB
    }
}
