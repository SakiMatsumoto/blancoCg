/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.php;

import java.util.ArrayList;
import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgException;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgParameter;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgMethod���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgMethodPhpSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.PHP;

    /**
     * �����Ń��\�b�h��W�J���܂��B
     * 
     * @param strClassName
     *            �N���X���B
     * @param cgMethod
     *            �����ΏۂƂȂ郁�\�b�h�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     * @param argIsInterface
     *            �C���^�t�F�[�X���ǂ����B�N���X�̏ꍇ�ɂ�false�B�C���^�t�F�[�X�̏ꍇ�ɂ�true�B
     */
    public void transformMethod(final String strClassName,
            final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines,
            final boolean argIsInterface) {
        if (BlancoStringUtil.null2Blank(cgMethod.getName()).length() == 0) {
            throw new IllegalArgumentException("���\�b�h�̖��O�ɓK�؂Ȓl���ݒ肳��Ă��܂���B");
        }
        if (cgMethod.getReturn() == null) {
            // ����͂��肦�܂��Bvoid�̏ꍇ�ɂ�null���w�肳���̂ł��B
        }

        // ���s��t�^�B
        argSourceLines.add("");

        prepareExpand(cgMethod, argSourceFile);

        // ��񂪈ꎮ��������̂ŁA�\�[�X�R�[�h�̎��ۂ̓W�J���s���܂��B

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocPhpSourceExpander().transformLangDoc(cgMethod
                .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgMethod, argSourceLines);

        // ���\�b�h�̖{�̕�����W�J�B
        expandMethodBody(strClassName, cgMethod, argSourceFile, argSourceLines,
                argIsInterface);
    }

    /**
     * �\�[�X�R�[�h�W�J�ɐ旧���A�K�v�ȏ��̎��W���s���܂��B
     * 
     * @param cgMethod
     *            ���\�b�h�I�u�W�F�N�g�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     */
    private void prepareExpand(final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile) {
        // �ŏ��Ƀ��\�b�h����LangDoc�ɓW�J�B
        if (cgMethod.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgMethod.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgMethod.getLangDoc().getParameterList() == null) {
            cgMethod.getLangDoc().setParameterList(
                    new ArrayList<blanco.cg.valueobject.BlancoCgParameter>());
        }
        if (cgMethod.getLangDoc().getThrowList() == null) {
            cgMethod.getLangDoc().setThrowList(
                    new ArrayList<blanco.cg.valueobject.BlancoCgException>());
        }
        if (cgMethod.getLangDoc().getTitle() == null) {
            cgMethod.getLangDoc().setTitle(cgMethod.getDescription());
        }

        for (int indexParameter = 0; indexParameter < cgMethod
                .getParameterList().size(); indexParameter++) {
            final BlancoCgParameter cgParameter = cgMethod.getParameterList()
                    .get(indexParameter);

            // import���Ɍ^��ǉ��B
            argSourceFile.getImportList().add(cgParameter.getType().getName());

            // ����h�L�������g�Ƀp�����[�^��ǉ��B
            cgMethod.getLangDoc().getParameterList().add(cgParameter);
        }

        if (cgMethod.getReturn() != null) {
            // import���Ɍ^��ǉ��B
            argSourceFile.getImportList().add(
                    cgMethod.getReturn().getType().getName());

            // ����h�L�������g��return��ǉ��B
            cgMethod.getLangDoc().setReturn(cgMethod.getReturn());
        }

        // ��O�ɂ���LangDoc�\���̂ɓW�J
        for (int index = 0; index < cgMethod.getThrowList().size(); index++) {
            final BlancoCgException cgException = cgMethod.getThrowList().get(
                    index);

            // import���Ɍ^��ǉ��B
            argSourceFile.getImportList().add(cgException.getType().getName());

            // ����h�L�������g�ɗ�O��ǉ��B
            cgMethod.getLangDoc().getThrowList().add(cgException);
        }
    }

    /**
     * ���\�b�h�̖{�̕�����W�J���܂��B
     * 
     * @param strClassName
     *            �N���X���B
     * @param cgMethod
     *            ���\�b�h�I�u�W�F�N�g�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     * @param argIsInterface
     *            �C���^�t�F�[�X�Ƃ��ēW�J���邩�ǂ����B
     */
    private void expandMethodBody(final String strClassName,
            final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines,
            final boolean argIsInterface) {
        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgMethod.getAccess()).length() > 0) {
            if (argIsInterface && cgMethod.getAccess().equals("public")) {
                // �C���^�t�F�[�X����public�̏ꍇ�ɂ͏o�͂�}�����܂��B
                // �����Checkstyle�΍�ƂȂ�܂��B
            } else {
                buf.append(cgMethod.getAccess() + " ");
            }
        }

        if (cgMethod.getAbstract() && argIsInterface == false) {
            // ���C���^�t�F�[�X�̏ꍇ�ɂ� abstract�͕t�^���܂���B
            buf.append("abstract ");
        }
        if (cgMethod.getStatic()) {
            buf.append("static ");
        }
        if (cgMethod.getFinal() && argIsInterface == false) {
            // ���C���^�t�F�[�X�̏ꍇ�ɂ� final�͕t�^���܂���B
            buf.append("final ");
        }

        // PHP�̏ꍇ�ɂ́A�R���X�g���N�^�̏ꍇ�ɂ��A�߂�l���o�͂����܂��B
        // ����� PHPLint�̌���̎d�l�ɑΉ������邽�߂̂��̂ł��B
        if (cgMethod.getReturn() != null
                && cgMethod.getReturn().getType() != null) {
            buf.append("/*."
                    + BlancoCgTypePhpSourceExpander
                            .toPhpLintType(BlancoCgTypePhpSourceExpander
                                    .toTypeString(cgMethod.getReturn()
                                            .getType())) + ".*/ ");
        } else {
            buf.append("/*.void.*/ ");
        }

        buf.append("function ");

        if (cgMethod.getConstructor()) {
            // �R���X�g���N�^�̏ꍇ�A���\�b�h���͗��p����܂���B
            buf.append("__construct(");
        } else {
            buf.append(cgMethod.getName() + "(");
        }

        for (int index = 0; index < cgMethod.getParameterList().size(); index++) {
            final BlancoCgParameter cgParameter = cgMethod.getParameterList()
                    .get(index);
            if (cgParameter.getType() == null) {
                throw new IllegalArgumentException("���\�b�h[" + cgMethod.getName()
                        + "]�̃p�����[�^[" + cgParameter.getName()
                        + "]�̌^��null���^�����܂����B");
            }

            if (index != 0) {
                buf.append(", ");
            }

            if (cgParameter.getFinal()) {
                // PHP5�ł̓p�����[�^��final�͂���܂���B
                // buf.append("final ");
            }
            buf.append("/*.");
            buf.append(BlancoCgTypePhpSourceExpander
                    .toPhpLintType(BlancoCgTypePhpSourceExpander
                            .toTypeString(cgParameter.getType())));
            buf.append(".*/ ");
            buf.append("$" + cgParameter.getName());
        }
        buf.append(")");

        // ��O�X���[��W�J�B
        expandThrowList(cgMethod, buf);

        if (cgMethod.getAbstract() || argIsInterface) {
            // ���ۃ��\�b�h�܂��̓C���^�t�F�[�X�̏ꍇ�ɂ́A���\�b�h�̖{�̂�W�J���܂���B
            buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
            argSourceLines.add(buf.toString());
        } else {
            // ���\�b�h�u���b�N�̊J�n�B
            buf.append(" {");

            // �����ł�������A�s���m��B
            argSourceLines.add(buf.toString());

            argSourceLines.add("/* �p�����[�^�̐��A�^�`�F�b�N���s���܂��B */");
            argSourceLines.add(BlancoCgLineUtil
                    .getIfBegin(TARGET_LANG, "func_num_args() !== "
                            + cgMethod.getParameterList().size()));

            // standard��import
            argSourceFile.getImportList().add("standard.Exception");
            argSourceLines.add("throw new Exception("
                    + BlancoCgLineUtil.getStringLiteralEnclosure(TARGET_LANG)
                    + "[ArgumentException]: " + strClassName + "."
                    + cgMethod.getName() + " �̃p�����[�^��["
                    + cgMethod.getParameterList().size()
                    + "]�ł���K�v������܂��B���������ۂɂ�["
                    + BlancoCgLineUtil.getStringLiteralEnclosure(TARGET_LANG)
                    + " . func_num_args() .  "
                    + BlancoCgLineUtil.getStringLiteralEnclosure(TARGET_LANG)
                    + "]�̃p�����[�^�𔺂��ČĂяo����܂����B"
                    + BlancoCgLineUtil.getStringLiteralEnclosure(TARGET_LANG)
                    + ");");
            argSourceLines.add(BlancoCgLineUtil.getIfEnd(TARGET_LANG));

            for (int indexParameter = 0; indexParameter < cgMethod
                    .getParameterList().size(); indexParameter++) {
                final BlancoCgParameter cgParameter = cgMethod
                        .getParameterList().get(indexParameter);
                if (BlancoCgTypePhpSourceExpander
                        .isLanguageReservedKeyword(BlancoStringUtil
                                .null2Blank(cgParameter.getType().getName()))) {
                    String typeName = cgParameter.getType().getName();
                    if (typeName.equals("float")) {
                        // PHP�͗��j�I�ȗ��R�ɂ�� float��double��Ԃ��Ƃ̂��ƁB
                        // �Q�l: http://www.php.net/manual/ja/function.gettype.php
                        typeName = "double";
                    }
                    argSourceLines
                            .add(BlancoCgLineUtil
                                    .getIfBegin(
                                            TARGET_LANG,
                                            "gettype($"
                                                    + cgParameter.getName()
                                                    + ") !== "
                                                    + BlancoCgLineUtil
                                                            .getStringLiteralEnclosure(TARGET_LANG)
                                                    + typeName
                                                    + BlancoCgLineUtil
                                                            .getStringLiteralEnclosure(TARGET_LANG)
                                                    + " && gettype($"
                                                    + cgParameter.getName()
                                                    + ") !== "
                                                    + BlancoCgLineUtil
                                                            .getStringLiteralEnclosure(TARGET_LANG)
                                                    + "NULL"
                                                    + BlancoCgLineUtil
                                                            .getStringLiteralEnclosure(TARGET_LANG)));
                } else {
                    argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG,
                            "$" + cgParameter.getName() + " instanceof "
                                    + cgParameter.getType().getName()
                                    + " === FALSE"));
                }
                argSourceLines.add("throw new Exception("
                        + BlancoCgLineUtil
                                .getStringLiteralEnclosure(TARGET_LANG)
                        + "[ArgumentException]: "
                        + strClassName
                        + "."
                        + cgMethod.getName()
                        + " ��"
                        + (indexParameter + 1)
                        + "�Ԗڂ̃p�����[�^��["
                        + cgParameter.getType().getName()
                        + "]�^�łȂ��Ă͂Ȃ�܂���B���������ۂɂ�["
                        + BlancoCgLineUtil
                                .getStringLiteralEnclosure(TARGET_LANG)
                        + " "
                        + BlancoCgLineUtil
                                .getStringConcatenationOperator(TARGET_LANG)
                        + " "
                        + (BlancoCgTypePhpSourceExpander
                                .isLanguageReservedKeyword(BlancoStringUtil
                                        .null2Blank(cgParameter.getType()
                                                .getName())) ? "gettype("
                                : "get_class(")
                        + "$"
                        + cgParameter.getName()
                        + ") "
                        + BlancoCgLineUtil
                                .getStringConcatenationOperator(TARGET_LANG)
                        + " "
                        + BlancoCgLineUtil
                                .getStringLiteralEnclosure(TARGET_LANG)
                        + "]�^���^�����܂����B"
                        + BlancoCgLineUtil
                                .getStringLiteralEnclosure(TARGET_LANG) + ");");
                argSourceLines.add(BlancoCgLineUtil.getIfEnd(TARGET_LANG));
            }

            argSourceLines.add("");

            // �e�N���X���\�b�h���s�@�\�̓W�J�B
            // �p�����[�^�`�F�b�N����ɓW�J�B
            if (BlancoStringUtil.null2Blank(cgMethod.getSuperclassInvocation())
                    .length() > 0) {
                // super(����) �Ȃǂ��܂܂�܂��B
                argSourceLines.add(cgMethod.getSuperclassInvocation()
                        + BlancoCgLineUtil.getTerminator(TARGET_LANG));
            }

            argSourceLines.add("");

            // �p�����[�^�̔�null����̓W�J�B
            expandParameterCheck(cgMethod, argSourceLines);

            // �s��W�J���܂��B
            expandLineList(cgMethod, argSourceLines);

            // ���\�b�h�u���b�N�̏I���B
            argSourceLines.add("}");
        }
    }

    /**
     * ��O�X���[��W�J���܂��B
     * 
     * @param cgMethod
     *            ���\�b�h�B
     * @param buf
     *            �o�̓o�b�t�@�B
     */
    private void expandThrowList(final BlancoCgMethod cgMethod,
            final StringBuffer buf) {
        for (int index = 0; index < cgMethod.getThrowList().size(); index++) {
            final BlancoCgException cgException = cgMethod.getThrowList().get(
                    index);

            if (index == 0) {
                buf.append(" throws ");
            } else {
                buf.append(", ");
            }
            // ����h�L�������g�����ɂ����ẮAblancoCg��Type�Ɋւ��鋤�ʏ����𗘗p���邱�Ƃ͂ł��܂���B
            // �ʂɋL�q���s���܂��B
            buf.append(BlancoNameUtil.trimJavaPackage(cgException.getType()
                    .getName()));
        }
    }

    /**
     * �A�m�e�[�V������W�J���܂��B
     * 
     * @param cgMethod
     *            ���\�b�h�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    private void expandAnnotationList(final BlancoCgMethod cgMethod,
            final List<java.lang.String> argSourceLines) {
        if (cgMethod.getOverride()) {
            // Java����ł� override�̓A�m�e�[�V�����ŕ\�����܂��B
            argSourceLines.add("@Override");
        }

        for (int index = 0; index < cgMethod.getAnnotationList().size(); index++) {
            final String strAnnotation = cgMethod.getAnnotationList()
                    .get(index);

            // Java�����Annotation�� @ ����L�q���܂��B
            argSourceLines.add("@" + strAnnotation);
        }
    }

    /**
     * �p�����[�^�̔�null����̓W�J�B
     * 
     * @param cgMethod
     *            ���\�b�h�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    private void expandParameterCheck(final BlancoCgMethod cgMethod,
            final List<java.lang.String> argSourceLines) {
        boolean isProcessed = false;
        for (int index = 0; index < cgMethod.getParameterList().size(); index++) {
            final BlancoCgParameter cgParameter = cgMethod.getParameterList()
                    .get(index);
            if (cgParameter.getNotnull()) {
                isProcessed = true;

                argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG, "$"
                        + cgParameter.getName() + " === null"));
                argSourceLines.add("throw new Exception('���\�b�h["
                        + cgMethod.getName() + "]�̃p�����[�^["
                        + cgParameter.getName()
                        + "]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B');");
                argSourceLines.add(BlancoCgLineUtil.getIfEnd(TARGET_LANG));
            }
        }

        if (isProcessed) {
            // �p�����[�^�`�F�b�N���W�J���ꂽ�ꍇ�ɂ͋�s��}�����܂��B
            argSourceLines.add("");
        }
    }

    /**
     * �s��W�J���܂��B
     * 
     * @param cgMethod
     *            ���\�b�h���B
     * @param argSourceLines
     *            �o�͍s���X�g�B
     */
    private void expandLineList(final BlancoCgMethod cgMethod,
            final List<java.lang.String> argSourceLines) {
        for (int indexLine = 0; indexLine < cgMethod.getLineList().size(); indexLine++) {
            final String strLine = cgMethod.getLineList().get(indexLine);
            argSourceLines.add(strLine);
        }
    }
}
