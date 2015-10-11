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

import java.util.ArrayList;
import java.util.List;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgException;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgParameter;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgMethod���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgMethodJsSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JS;

    /**
     * �����Ń��\�b�h��W�J���܂��B
     * 
     * @param cgMethod
     *            �����ΏۂƂȂ郁�\�b�h�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     */
    public void transformMethod(final BlancoCgClass cgClass,
            final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (BlancoStringUtil.null2Blank(cgMethod.getName()).length() == 0) {
            throw new IllegalArgumentException("���\�b�h�̖��O�ɓK�؂Ȓl���ݒ肳��Ă��܂���B");
        }
        if (cgMethod.getReturn() == null) {
            // ����͂��肦�܂��Bvoid�̏ꍇ�ɂ�null���w�肳���̂ł��B
        }

        // ���s��t�^�B
        argSourceLines.add("");

        prepareExpand(cgClass, cgMethod, argSourceFile);

        // ��񂪈ꎮ��������̂ŁA�\�[�X�R�[�h�̎��ۂ̓W�J���s���܂��B

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocJsSourceExpander().transformLangDoc(cgMethod
                .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgMethod, argSourceLines);

        // ���\�b�h�̖{�̕�����W�J�B
        expandMethodBody(cgClass, cgMethod, argSourceFile, argSourceLines);
    }

    /**
     * �N���X�Ɋ܂܂�� static �ȃt�B�[���h��W�J���܂��B
     * 
     * ���݂� �o�^���Ń\�[�X�R�[�h�W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    public void transformStaticFieldList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getFieldList() == null) {
            // �t�B�[���h�̃��X�g��null���^�����܂����B
            // ���Ȃ炸�t�B�[���h�̃��X�g�ɂ�List���Z�b�g���Ă��������B
            throw new IllegalArgumentException("�t�B�[���h�̃��X�g��null���^�����܂����B");
        }

        for (int index = 0; index < cgClass.getFieldList().size(); index++) {
            final BlancoCgField cgField = cgClass.getFieldList().get(index);

            if (cgField.getStatic()) {
                // �����ł̓N���X�̃t�B�[���h (static�ȃt�B�[���h) �݂̂�W�J���܂��B
                new BlancoCgFieldJsSourceExpander().transformField(cgClass,
                        cgField, argSourceFile, argSourceLines);
            }
        }
    }

    /**
     * �\�[�X�R�[�h�W�J�ɐ旧���A�K�v�ȏ��̎��W���s���܂��B
     * 
     * @param cgMethod
     *            ���\�b�h�I�u�W�F�N�g�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     */
    private void prepareExpand(final BlancoCgClass cgClass,
            final BlancoCgMethod cgMethod,
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

        if (cgMethod.getConstructor()) {
            // �t�@���N�V���������̂��̂�LangDoc�ɓW�J���܂��B
            cgMethod.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            "class", null, cgClass.getDescription()));

            cgMethod.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            "constructor", null, ""));
        } else {
            cgMethod.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            "addon", null, ""));
        }

        if (BlancoStringUtil.null2Blank(cgMethod.getAccess()).equals("private")) {
            cgMethod.getLangDoc().getTagList().add(
                    BlancoCgObjectFactory.getInstance().createLangDocTag(
                            "private", null, ""));
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
     * @param cgClass
     *            �N���X�I�u�W�F�N�g�B
     * @param cgMethod
     *            ���\�b�h�I�u�W�F�N�g�B
     * @param argSourceFile
     *            �\�[�X�R�[�h�B
     * @param argSourceLines
     *            �C���^�t�F�[�X�Ƃ��ēW�J���邩�ǂ����B
     */
    private void expandMethodBody(final BlancoCgClass cgClass,
            final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        final StringBuffer buf = new StringBuffer();

        if (cgMethod.getConstructor()) {
            // �R���X�g���N�^�̏ꍇ�ɂ� function����n�܂�܂��B
            buf.append("function " + cgClass.getName());
        } else {
            // �ʏ�̃��\�b�h�̏ꍇ�ɂ́A�R���X�g���N�^�� prototype�ւ�function�̒ǉ��ƂȂ�܂��B
            buf.append(cgClass.getName() + ".prototype." + cgMethod.getName()
                    + " = function");
        }

        // JavaScript�ɂ̓A�N�Z�X�t���O���̂��̂͑��݂��܂���B
        // JSDoc�̋L�q�Ƃ��ăA�N�Z�X��\�����Ă��܂��B

        // JavaScript�ł͌���Ƃ��Ă͖߂�l�͏o�͂��܂���BJSDoc�̋L�q�Ƃ��Ă̂ݕ\�����܂��B

        buf.append("(");
        for (int index = 0; index < cgMethod.getParameterList().size(); index++) {
            final BlancoCgParameter cgParameter = cgMethod.getParameterList()
                    .get(index);
            if (cgParameter.getType() == null) {
                throw new IllegalArgumentException("���\�b�h[" + cgMethod.getName()
                        + "]�̃p�����[�^[" + cgParameter.getName()
                        + "]�Ɍ^��null���^�����܂����B");
            }

            if (index != 0) {
                buf.append(", ");
            }

            // JavaScript�ł�final�C���͖����ł��B

            buf.append("/* "
                    + BlancoCgTypeJsSourceExpander.toTypeString(cgParameter
                            .getType()) + " */");
            buf.append(" ");
            buf.append(cgParameter.getName());
        }
        buf.append(")");

        // ��O�X���[�W�J��JavaScript�ɂ͑��݂��܂���B

        if (cgMethod.getAbstract()) {
            // ���ۃ��\�b�h�܂��̓C���^�t�F�[�X�̏ꍇ�ɂ́A���\�b�h�̖{�̂�W�J���܂���B
            buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
            argSourceLines.add(buf.toString());
        } else {
            // ���\�b�h�u���b�N�̊J�n�B
            buf.append(" {");

            // �����ł�������A�s���m��B
            argSourceLines.add(buf.toString());

            // �����`�F�b�N�̎����������s���܂��B
            argSourceLines.add("/* �p�����[�^�̐��A�^�`�F�b�N���s���܂��B */");
            argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG,
                    "arguments.length !== "
                            + cgMethod.getParameterList().size()));
            argSourceLines
                    .add("throw new Error(\"[ArgumentException]: "
                            + cgClass.getName()
                            + "."
                            + cgMethod.getName()
                            + " �̃p�����[�^��["
                            + cgMethod.getParameterList().size()
                            + "]�ł���K�v������܂��B���������ۂɂ�[\" + arguments.length +  \"]�̃p�����[�^�𔺂��ČĂяo����܂����B\");");
            argSourceLines.add(BlancoCgLineUtil.getIfEnd(TARGET_LANG));

            for (int indexParameter = 0; indexParameter < cgMethod
                    .getParameterList().size(); indexParameter++) {
                final BlancoCgParameter cgParameter = cgMethod
                        .getParameterList().get(indexParameter);
                if (BlancoCgTypeJsSourceExpander
                        .isLanguageReservedKeyword(BlancoStringUtil
                                .null2Blank(cgParameter.getType().getName()))) {
                    argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG,
                            "typeof(" + cgParameter.getName() + ") != \""
                                    + cgParameter.getType().getName() + "\""));
                } else {
                    argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG,
                            cgParameter.getName() + " instanceof "
                                    + cgParameter.getType().getName()
                                    + " == false"));
                }
                argSourceLines.add("throw new Error(\"[ArgumentException]: "
                        + cgClass.getName() + "." + cgMethod.getName() + " ��"
                        + (indexParameter + 1) + "�Ԗڂ̃p�����[�^��["
                        + cgParameter.getType().getName()
                        + "]�^�łȂ��Ă͂Ȃ�܂���B���������ۂɂ�[\" + typeof("
                        + cgParameter.getName() + ") + \"]�^���^�����܂����B\");");
                argSourceLines.add(BlancoCgLineUtil.getIfEnd(TARGET_LANG));
            }

            argSourceLines.add("");

            if (cgMethod.getConstructor()) {
                // �R���X�g���N�^�ł���̂Ńt�B�[���h��W�J���܂��B
                // JavaScript�̏ꍇ�ɂ́A�N���X�Ƀt�B�[���h��W�J����̂ł͂Ȃ��R���X�g���N�^�Ƀt�B�[���h�W�J�����݂��܂��B
                expandFieldList(cgClass, argSourceFile, argSourceLines);
            }

            // �e�N���X���\�b�h���s�@�\�̓W�J�B
            if (BlancoStringUtil.null2Blank(cgMethod.getSuperclassInvocation())
                    .length() > 0) {
                // super(����) �Ȃǂ��܂܂�܂��B
                argSourceLines.add(cgMethod.getSuperclassInvocation()
                        + BlancoCgLineUtil.getTerminator(TARGET_LANG));
            }

            // �s��W�J���܂��B
            expandLineList(cgMethod, argSourceLines);

            // ���\�b�h�u���b�N�̏I���B
            if (cgMethod.getConstructor()) {
                // �N���X�錾�ł͍Ō�ɃZ�~�R�������t�^���܂���B
                argSourceLines.add("}");
            } else {
                // JavaScript�ł͍Ō�ɃZ�~�R�������t�^����܂��B
                argSourceLines.add("};");
            }
        }
    }

    /**
     * �N���X�Ɋ܂܂��e�X�̃t�B�[���h��W�J���܂��B
     * 
     * ���݂� �o�^���Ń\�[�X�R�[�h�W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandFieldList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getFieldList() == null) {
            // �t�B�[���h�̃��X�g��null���^�����܂����B
            // ���Ȃ炸�t�B�[���h�̃��X�g�ɂ�List���Z�b�g���Ă��������B
            throw new IllegalArgumentException("�t�B�[���h�̃��X�g��null���^�����܂����B");
        }

        for (int index = 0; index < cgClass.getFieldList().size(); index++) {
            final BlancoCgField cgField = cgClass.getFieldList().get(index);

            if (cgField.getStatic() == false) {
                // �R���X�g���N�^�̒��ŁAstatic�ł͂Ȃ��t�B�[���h��W�J���܂��B
                new BlancoCgFieldJsSourceExpander().transformField(cgClass,
                        cgField, argSourceFile, argSourceLines);
            }
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
            // JavaScript����ł� override�\���͌����_�ł̓T�|�[�g�O�ł��B
            throw new IllegalArgumentException(
                    "���o�[�W������ blancoCg�� JavaScript����̍ۂɂ̓I�[�o�[���C�h�\�����T�|�[�g���܂���B");
            // argSourceLines.add("@Override");
        }

        for (int index = 0; index < cgMethod.getAnnotationList().size(); index++) {
            final String strAnnotation = cgMethod.getAnnotationList()
                    .get(index);
            throw new IllegalArgumentException(
                    "���o�[�W������ blancoCg�� JavaScript����̍ۂɂ̓A�m�e�[�V�������T�|�[�g���܂���B"
                            + strAnnotation);
            // JavaScript�����Annotation�͕s���ł��B
            // argSourceLines.add("@" + strAnnotation);
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
