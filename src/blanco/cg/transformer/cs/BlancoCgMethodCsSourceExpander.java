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

import java.util.ArrayList;
import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgException;
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
class BlancoCgMethodCsSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.CS;

    /**
     * �����Ń��\�b�h��W�J���܂��B
     * 
     * @param cgMethod
     *            �����ΏۂƂȂ郁�\�b�h�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �o�͐�s���X�g�B
     * @param argIsInterface
     *            �C���^�t�F�[�X���ǂ����B�N���X�̏ꍇ�ɂ�false�B�C���^�t�F�[�X�̏ꍇ�ɂ�true�B
     */
    public void transformMethod(final BlancoCgMethod cgMethod,
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
        new BlancoCgLangDocCsSourceExpander().transformLangDoc(cgMethod
                .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgMethod, argSourceLines);

        // ���\�b�h�̖{�̕�����W�J�B
        expandMethodBody(cgMethod, argSourceFile, argSourceLines,
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
     * @param cgMethod
     *            ���\�b�h�I�u�W�F�N�g�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     * @param argIsInterface
     *            �C���^�t�F�[�X�Ƃ��ēW�J���邩�ǂ����B
     */
    private void expandMethodBody(final BlancoCgMethod cgMethod,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines,
            final boolean argIsInterface) {
        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgMethod.getAccess()).length() > 0) {
            if (argIsInterface && cgMethod.getAccess().equals("public")) {
                // �C���^�t�F�[�X����public�̏ꍇ�ɂ͏o�͂�}�����܂��B
                // Java�Ɠ��l�� C#�ł��o�͂͗}�����܂��B
            } else {
                buf.append(cgMethod.getAccess() + " ");
            }
        }

        if (cgMethod.getAbstract() && argIsInterface == false) {
            // ���C���^�t�F�[�X�̏ꍇ�ɂ� abstract�͕t�^���܂���B
            buf.append("abstract ");
        }
        if (cgMethod.getOverride()) {
            // C#.NET�ɂ� override �C�������݂��܂��B
            buf.append("override ");
        }
        if (isVirtual(cgMethod, argIsInterface)) {
            // ��koyak ����̍v���ӏ��B
            // C#.NET �ł́A�p���N���X�Ń��\�b�h���I�[�o�[���C�h����ɂ͕K�����N���X�̃��\�b�h�� virtual
            // �C������Ă���K�v������܂��B
            // ���̂��߁A���\�b�h�� override �łȂ���� virtual �Ƃ��܂��B
            buf.append("virtual ");
        }
        if (cgMethod.getStatic()) {
            buf.append("static ");
        }
        if (cgMethod.getFinal() && argIsInterface == false) {
            // ���C���^�t�F�[�X�̏ꍇ�ɂ� final�͕t�^���܂���B
            buf.append("final ");
        }

        if (cgMethod.getConstructor()) {
            // �R���X�g���N�^�̏ꍇ�ɂ́A�߂�l�͑��݂��܂���B
            // ���̂��߁A�����ł͉����o�͂��܂���B
        } else {
            if (cgMethod.getReturn() != null
                    && cgMethod.getReturn().getType() != null) {
                buf.append(BlancoCgTypeCsSourceExpander.toTypeString(cgMethod
                        .getReturn().getType())
                        + " ");
            } else {
                buf.append("void ");
            }
        }

        buf.append(cgMethod.getName() + "(");
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

            // �p�����[�^�̃A�m�e�[�V������W�J�B
            if (cgParameter.getAnnotationList() != null) {
                for (int indexAnnotation = 0; indexAnnotation < cgParameter
                        .getAnnotationList().size(); indexAnnotation++) {
                    // C#.NET�����Annotation�� []�ŋL�q���܂��B
                    final String strAnnotation = cgParameter
                            .getAnnotationList().get(indexAnnotation);

                    // C#.NET�����Annotation�� []�ŋL�q���܂��B
                    buf.append("[" + strAnnotation + "] ");
                }
            }

            if (cgParameter.getFinal()) {
                // C#.NET�ɂ�����final��readonly�\���ƂȂ�܂��B����������I�Ȃ̂ŁA�����_�ł͓W�J��}�����܂��B
                // buf.append("readonly ");
            }
            buf.append(BlancoCgTypeCsSourceExpander.toTypeString(cgParameter
                    .getType()));
            buf.append(" ");
            buf.append(cgParameter.getName());
        }
        buf.append(")");

        // C#.NET�ɂ� base()�L�q�����݂��܂��B
        if (BlancoStringUtil.null2Blank(cgMethod.getSuperclassInvocation())
                .length() > 0) {
            // getSuperclassInvocation�ɂ� base(message)�Ȃǂ̂悤�ȋL�ڂ������Ȃ��܂��B
            // TODO C#.NET�ł��̋L�ڂ��\�Ȃ̂̓R���X�g���N�^�����ł���͗l�ł��B
            buf.append(" : " + cgMethod.getSuperclassInvocation());
        }

        // C#.NET�ɂ͗�O�X���[�̃��\�b�h�C���͂���܂���B
        // TODO ��O�X���[���� ����h�L�������g�ɏo�͂��邱�Ƃɂ͈Ӌ`������ƍl���܂��B

        if (cgMethod.getAbstract() || argIsInterface) {
            // ���ۃ��\�b�h�܂��̓C���^�t�F�[�X�̏ꍇ�ɂ́A���\�b�h�̖{�̂�W�J���܂���B
            buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
            argSourceLines.add(buf.toString());
        } else {
            // �����ł�������A�s���m��B
            argSourceLines.add(buf.toString());

            // ���\�b�h�u���b�N�̊J�n�B
            argSourceLines.add("{");

            // �p�����[�^�̔�null����̓W�J�B
            expandParameterCheck(cgMethod, argSourceFile, argSourceLines);

            // �s��W�J���܂��B
            expandLineList(cgMethod, argSourceLines);

            // ���\�b�h�u���b�N�̏I���B
            argSourceLines.add("}");
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
        for (int index = 0; index < cgMethod.getAnnotationList().size(); index++) {
            final String strAnnotation = cgMethod.getAnnotationList()
                    .get(index);

            // C#.NET�����Annotation�� []�ŋL�q���܂��B
            argSourceLines.add("[" + strAnnotation + "]");
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
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        boolean isProcessed = false;
        for (int index = 0; index < cgMethod.getParameterList().size(); index++) {
            final BlancoCgParameter cgParameter = cgMethod.getParameterList()
                    .get(index);
            if (cgParameter.getNotnull()) {
                isProcessed = true;
                argSourceFile.getImportList().add("System.ArgumentException");

                argSourceLines.add(BlancoCgLineUtil.getIfBegin(TARGET_LANG,
                        cgParameter.getName() + " == null"));
                argSourceLines.add("throw new ArgumentException(\"���\�b�h["
                        + cgMethod.getName() + "]�̃p�����[�^["
                        + cgParameter.getName()
                        + "]��null���^�����܂����B�������A���̃p�����[�^��null��^���邱�Ƃ͂ł��܂���B\");");
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

    /**
     * ���\�b�h�� virtual �C�����邩�ǂ����𔻒f����B
     * 
     * @param cgMethod
     *            ���\�b�h���B
     * @param argIsInterface
     *            �C���^�t�F�[�X���ǂ����B
     * @return true�̏ꍇ�ɂ� virtual �C���������Ȃ��B
     */
    private boolean isVirtual(final BlancoCgMethod cgMethod,
            final boolean argIsInterface) {
        if (cgMethod.getAbstract() == false && cgMethod.getOverride() == false
                && cgMethod.getFinal() == false
                && cgMethod.getConstructor() == false
                && cgMethod.getStatic() == false && argIsInterface == false) {
            return true;
        }
        return false;
    }
}
