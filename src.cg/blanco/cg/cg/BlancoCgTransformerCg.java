/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.cg;

import java.io.File;
import java.util.List;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * blancoCg��BlancoCgTransformer�������������邽�߂̃N���X�ł��B
 * 
 * �\�[�X�R�[�h�����������C�u���� blancoCg ���̂��̂̈ꕔ�������������܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerCg {
    /**
     * blancoCg��̃I�u�W�F�N�g�𐶐����邽�߂̃t�@�N�g���B
     */
    private final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
            .getInstance();

    /**
     * �\�[�X�R�[�h�̓W�J���s���܂��B
     * 
     * @param targetDirectory
     *            �\�[�X�R�[�h�o�͐惋�[�g�f�B���N�g���B
     */
    public void process(final File targetDirectory) {
        // �\�[�X�t�@�C���w�b�_��W�J���܂��B
        final BlancoCgSourceFile cgSourceFile = expandSourceFileHeader("blanco.cg");

        // �C���^�t�F�[�X��W�J���܂��B
        final BlancoCgInterface cgInterface = expandInterface(cgSourceFile);

        // ���\�b�h��W�J���܂��B
        cgInterface.getMethodList().add(expandTransformMethod());
        cgInterface.getMethodList().add(expandTransform2Method());

        // �o�����[�I�u�W�F�N�g����͂Ƃ��āA�\�[�X�R�[�h���o�͂��܂��B
        BlancoCgTransformerFactory.getJavaSourceTransformer().transform(
                cgSourceFile, targetDirectory);
    }

    /**
     * �\�[�X�t�@�C���w�b�_�[��W�J���܂��B
     * 
     * @param argPackage
     *            �\�[�X�R�[�h����������p�b�P�[�W�B
     * @return �\�[�X�t�@�C���I�u�W�F�N�g�B
     */
    public BlancoCgSourceFile expandSourceFileHeader(final String argPackage) {
        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                argPackage, "blanco Framework");

        final List<java.lang.String> sourceDesc = cgSourceFile.getLangDoc()
                .getDescriptionList();

        sourceDesc.add("Copyright (C) 2004-2006 IGA Tosiki");
        sourceDesc.add("");
        sourceDesc
                .add("This library is free software; you can redistribute it and/or");
        sourceDesc
                .add("modify it under the terms of the GNU Lesser General Public");
        sourceDesc
                .add("License as published by the Free Software Foundation; either");
        sourceDesc
                .add("version 2.1 of the License, or (at your option) any later version.");

        return cgSourceFile;
    }

    /**
     * �C���^�t�F�[�X��W�J���܂��B
     * 
     * @param cgSourceFile
     *            �\�[�X�t�@�C���I�u�W�F�N�g�B
     * @return �C���^�t�F�[�X�I�u�W�F�N�g�B
     */
    private BlancoCgInterface expandInterface(
            final BlancoCgSourceFile cgSourceFile) {
        final BlancoCgInterface cgInterface = cgFactory.createInterface(
                "BlancoCgTransformer",
                "blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̃C���^�t�F�[�X�ł��B");
        cgSourceFile.getInterfaceList().add(cgInterface);

        cgInterface.getLangDoc().getTagList().add(
                cgFactory.createLangDocTag("author", null, "IGA Tosiki"));
        cgInterface.getLangDoc().getDescriptionList().add(
                "�ʂ̌���p�̃\�[�X�R�[�h�������������́A���̃C���^�t�F�[�X���������Ď�������܂��B");

        return cgInterface;
    }

    /**
     * transform���\�b�h��W�J���܂��B
     * 
     * @return ���\�b�h�I�u�W�F�N�g�B
     */
    private BlancoCgMethod expandTransformMethod() {
        final BlancoCgMethod cgMethod = cgFactory.createMethod("transform",
                "�\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g��Java�\�[�X�R�[�h�ɕϊ����ďo�͐�f�B���N�g���ɏo�͂��܂��B");

        cgMethod.getLangDoc().getDescriptionList().add(
                "����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ��čl�����܂��B");
        cgMethod.getParameterList().add(
                cgFactory.createParameter("sourceFile",
                        "blanco.cg.valueobject.BlancoCgSourceFile",
                        "�\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B"));
        cgMethod.getParameterList().add(
                cgFactory.createParameter("outputDirectory", "java.io.File",
                        "�o�͐惋�[�g�f�B���N�g���B"));

        return cgMethod;
    }

    /**
     * transform���\�b�h��W�J���܂��B
     * 
     * @return ���\�b�h�I�u�W�F�N�g�B
     */
    public BlancoCgMethod expandTransform2Method() {
        final BlancoCgMethod cgMethod = cgFactory.createMethod("transform",
                "�\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g���\�[�X�R�[�h�ɕϊ����ă��C�^�[�ɏo�͂��܂��B");

        cgMethod.getLangDoc().getDescriptionList().add(
                "����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ͍l�����܂���B");
        cgMethod.getParameterList().add(
                cgFactory.createParameter("sourceFile",
                        "blanco.cg.valueobject.BlancoCgSourceFile",
                        "�\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B"));
        cgMethod.getParameterList().add(
                cgFactory.createParameter("writer", "java.io.BufferedWriter",
                        "�o�͐�̃��C�^�[�B"));
        cgMethod.getThrowList().add(
                cgFactory.createException("java.io.IOException",
                        "���o�͗�O�����������ꍇ�B"));

        return cgMethod;
    }
}
