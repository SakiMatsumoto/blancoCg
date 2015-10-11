/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg;

import java.io.File;

import junit.framework.TestCase;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * C#.NET����p�̐��������B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerJsTest extends TestCase {
    /**
     * C#.NET�̎����B
     * 
     * @throws Exception
     */
    public void testTransformerJs() throws Exception {
        final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
                .getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B
        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                "Myprog", "�e�X�g�p�̃N���X");
        cgSourceFile.getLangDoc().getDescriptionList().add(
                "���̃N���X�� blanco Framework�ɂ���Ď����I�ɐ�������܂����B");

        // �N���X�𐶐����܂��B
        final BlancoCgClass cgClass = cgFactory.createClass("MyClass",
                "���̃N���X�́A�e�X�g�̂��߂̃N���X�ł��B");
        cgSourceFile.getClassList().add(cgClass);
        cgClass.getLangDoc().getTagList().add(
                cgFactory.createLangDocTag("author", null, "blanco Framework"));
        cgClass.getExtendClassList().add(
                cgFactory.createType("java.lang.Thread"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgFactory.createField("myField",
                "number", "���l�t�B�[���h�̎����ł��B");
        cgClass.getFieldList().add(cgField);
        cgField.setDefault("Number(1)");

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField2 = cgFactory.createField("myField2",
                "number", "���l�t�B�[���h�̎����ł��B");
        cgClass.getFieldList().add(cgField2);
        cgField2.setAccess("public");
        cgField2.setDefault("Number(3)");

        // ���\�b�h�𐶐����܂��B
        final BlancoCgMethod cgMethod = cgFactory.createMethod("myMethod",
                "���\�b�h�̎����ł��B");
        cgClass.getMethodList().add(cgMethod);

        cgMethod.setAccess("private");

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argString", "string", "����������B"));
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argDate", "Date", "���t�����B"));
        // �߂�l��ݒ肵�܂��B
        cgMethod.setReturn(cgFactory.createReturn("string", "������̕�����B"));

        cgMethod.getThrowList().add(
                cgFactory.createException("System.IO.IOException",
                        "���o�͗�O�����������ꍇ�B"));

        // ���\�b�h�̓��e��ǉ����܂��B
        cgMethod.getLineList().add("// �����̎����ł��B");
        cgMethod.getLineList().add("return argString + \", \" + argDate;");

        final BlancoCgTransformer cgTransformerJs = BlancoCgTransformerFactory
                .getJsSourceTransformer();
        cgTransformerJs.transform(cgSourceFile, new File("./tmp/blanco"));
    }
}
