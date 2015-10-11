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
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * BlancoCgClass���\�[�X�R�[�h�ւƓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgClassJsSourceExpander {

    /**
     * ������Class��W�J���܂��B
     * 
     * @param cgClass
     *            �����ΏۂƂȂ�N���X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    public void transformClass(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        // �ŏ��ɃN���X����LangDoc�ɓW�J�B
        if (cgClass.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgClass.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgClass.getLangDoc().getTitle() == null) {
            cgClass.getLangDoc().setTitle(cgClass.getDescription());
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        // new BlancoCgLangDocJsSourceExpander().transformLangDoc(cgClass
        // .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgClass, argSourceLines);

        // �R���X�g���N�^�����݂��邩�A���邢�͂ЂƂ����݂��Ȃ����ǂ����`�F�b�N���܂��B
        boolean isConstructorExist = false;
        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);
            if (cgMethod.getConstructor()) {
                isConstructorExist = true;
                break;
            }
        }
        if (isConstructorExist == false) {
            // �N���X�̃R���X�g���N�^���ЂƂ����݂��Ȃ��ꍇ�ɂ́AblancoCg�̐Ӗ��Ƃ��ăf�t�H���g�R���X�g���N�^�����O�Ő�������K�v���o�Ă��܂��B
            // ����� JavaScript�̌���d�l�Ƃ��ẴN���X�̍\���̓��F�ɗR��������̂ł��B
            // ���e����̃��\�b�h�Ƃ��ăf�t�H���g�R���X�g���N�^�𐶐����܂��B
            final BlancoCgMethod cgMethod = BlancoCgObjectFactory.getInstance()
                    .createMethod(cgClass.getName(), "�f�t�H���g�R���X�g���N�^");
            cgMethod.setConstructor(true);
            cgClass.getMethodList().add(cgMethod);
        }

        // �N���X�̏��́A�N���X�̃R���X�g���N�^�ւƈڑ����܂��B
        // ����� JavaScript�̌���d�l�Ƃ��ẴN���X�̍\���̓��F�ɗR��������̂ł��B
        // �N���X�̐錾�����R���X�g���N�^���̂��̂ł���̂ŁA�R���X�g���N�^�ɃN���X�̏����ڑ�����K�v�����邩��ł��B
        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);
            if (cgMethod.getConstructor()) {
                // �N���X�̏����R���X�g���N�^�Ɉڑ����܂��B
                // �������^�C�g���͈ڑ����܂���B
                for (int indexClassLangDoc = 0; indexClassLangDoc < cgClass
                        .getLangDoc().getDescriptionList().size(); indexClassLangDoc++) {
                    cgMethod.getLangDoc().getDescriptionList().add(
                            cgClass.getLangDoc().getDescriptionList().get(
                                    indexClassLangDoc));
                }
                for (int indexClassLangDoc = 0; indexClassLangDoc < cgClass
                        .getLangDoc().getTagList().size(); indexClassLangDoc++) {
                    cgMethod.getLangDoc().getTagList().add(
                            cgClass.getLangDoc().getTagList().get(
                                    indexClassLangDoc));
                }
            }
        }

        // �����Ń��\�b�h��W�J�B
        expandMethodList(cgClass, argSourceFile, argSourceLines);

        argSourceLines.add("/* �N���X[" + cgClass.getName() + "]�錾�̏I���B */");
    }

    /**
     * �A�m�e�[�V������W�J���܂��B
     * 
     * @param cgClass
     *            �N���X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    private void expandAnnotationList(final BlancoCgClass cgClass,
            final List<java.lang.String> argSourceLines) {
        for (int index = 0; index < cgClass.getAnnotationList().size(); index++) {
            final String strAnnotation = cgClass.getAnnotationList().get(index);

            throw new IllegalArgumentException(
                    "���o�[�W������ blancoCg�� JavaScript����̍ۂɂ̓A�m�e�[�V�������T�|�[�g���܂���B"
                            + strAnnotation);
            // JavaScript�����Annotation�͕s���ł��B
            // argSourceLines.add("@" + strAnnotation);
        }
    }

    /**
     * �N���X�Ɋ܂܂��e�X�̃��\�b�h��W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandMethodList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getMethodList() == null) {
            throw new IllegalArgumentException("���\�b�h�̃��X�g��null���^�����܂����B");
        }

        // �ŏ��ɃR���X�g���N�^��W�J�B
        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);

            if (cgMethod.getConstructor()) {
                // �R���X�g���N�^�݂̂��ŏ��ɓW�J���܂��B
                new BlancoCgMethodJsSourceExpander().transformMethod(cgClass,
                        cgMethod, argSourceFile, argSourceLines);
            }
        }

        // �N���X�t�B�[���h (static�ȃt�B�[���h)��W�J���܂��B
        new BlancoCgMethodJsSourceExpander().transformStaticFieldList(cgClass,
                argSourceFile, argSourceLines);

        // ���Ɉ�ʂ̃��\�b�h��W�J�B
        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);

            if (cgMethod.getConstructor() == false) {
                // �R���X�g���N�^�ȊO��W�J���܂��B
                new BlancoCgMethodJsSourceExpander().transformMethod(cgClass,
                        cgMethod, argSourceFile, argSourceLines);
            }
        }
    }
}
