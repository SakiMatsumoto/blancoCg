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
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * Java����p�̐��������B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerTest extends TestCase {
    /**
     * �N���X�̓W�J�����B
     * 
     * @throws Exception
     */
    public void testTransformer() throws Exception {
        final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
                .getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B
        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                "myprog", "�e�X�g�p�̃N���X");
        cgSourceFile.setEncoding("Windows-31J");
        cgSourceFile.getImportList().add("java.text.NumberFormat");
        // �����p�b�P�[�W�̃C���|�[�g�����B
        cgSourceFile.getImportList().add("myprog.MyClass2");

        // �N���X�𐶐����܂��B
        final BlancoCgClass cgClass = cgFactory.createClass("MyClass",
                "���̃N���X�́A�e�X�g�̂��߂̃N���X�ł��B");
        cgSourceFile.getClassList().add(cgClass);
        cgClass.getLangDoc().getTagList().add(
                cgFactory.createLangDocTag("author", null, "blanco Framework"));
        cgClass.getExtendClassList().add(
                cgFactory.createType("java.lang.Thread"));
        cgClass.getImplementInterfaceList().add(
                cgFactory.createType("java.lang.Runnable"));

        // �񋓑�
        final BlancoCgEnum cgEnum = cgFactory.createEnum("FavorColor",
                "�񋓑̂̎����B");
        cgClass.getEnumList().add(cgEnum);
        cgEnum.getElementList().add(cgFactory.createEnumElement("Red", "����"));
        cgEnum.getElementList().add(
                cgFactory.createEnumElement("Yerrow", "������"));
        cgEnum.getElementList().add(cgFactory.createEnumElement("Blue", "����"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgFactory.createField("myField",
                "java.util.Date", "���t�t�B�[���h�̎����ł��B");
        cgClass.getFieldList().add(cgField);
        cgField.setDefault("new Date()");

        final BlancoCgField cgField2 = cgFactory.createField("myField2",
                "java.util.Date", "���t�t�B�[���h�̎���v2�ł��B");
        cgClass.getFieldList().add(cgField2);
        cgField2.getType().setArray(true);
        cgField2.getType().setArrayDimension(2);

        // static initializer �̃e�X�g
        {
            // ���\�b�h�𐶐����܂��B
            final BlancoCgMethod cgMethod = cgFactory.createMethod("myStatic",
                    "static initializer �̎����ł��B");
            cgClass.getMethodList().add(cgMethod);
            cgMethod.setStaticInitializer(true);
            cgMethod.getLineList().add("System.out.println();");
        }

        // ���\�b�h�𐶐����܂��B
        final BlancoCgMethod cgMethod = cgFactory.createMethod("myMethod",
                "���\�b�h�̎����ł��B");
        cgClass.getMethodList().add(cgMethod);

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argString", "java.lang.String",
                        "����������B"));
        cgMethod.getParameterList()
                .add(
                        cgFactory.createParameter("argDate", "java.util.Date",
                                "���t�����B"));
        // �߂�l��ݒ肵�܂��B
        cgMethod.setReturn(cgFactory.createReturn("boolean", "�����Ȃ�true�B"));

        cgMethod.getThrowList().add(
                cgFactory.createException("java.io.IOException",
                        "���o�͗�O�����������ꍇ�B"));

        // �A�m�e�[�V�����̒ǉ��B
        cgMethod.getAnnotationList().add(
                "Copyright(value=\"blanco Framework\")");
        cgMethod.setOverride(true);

        // ���\�b�h�̓��e��ǉ����܂��B
        cgMethod.getLineList().add("// ����̎����ł��B");
        cgMethod.getLineList().add("int a = 0;");

        final BlancoCgTransformer cgTransformerJava = BlancoCgTransformerFactory
                .getJavaSourceTransformer();
        cgTransformerJava.transform(cgSourceFile, new File("./tmp/blanco"));
    }

    /**
     * �C���^�t�F�[�X�̓W�J�����B
     * 
     * @throws Exception
     */
    public void testTransformerInterface() throws Exception {
        final BlancoCgObjectFactory cgOf = BlancoCgObjectFactory.getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B
        final BlancoCgSourceFile cgSourceFile = cgOf.createSourceFile("myprog",
                "�e�X�g�p�̃C���^�t�F�[�X");
        cgSourceFile.getImportList().add("java.text.NumberFormat");

        // �N���X�𐶐����܂��B
        final BlancoCgInterface cgInterface = cgOf.createInterface(
                "MyInterface", "���̃C���^�t�F�[�X�́A�e�X�g�̂��߂̃C���^�t�F�[�X�ł��B");
        cgSourceFile.getInterfaceList().add(cgInterface);
        cgInterface.getLangDoc().getTagList().add(
                cgOf.createLangDocTag("author", null, "blanco Framework"));
        cgInterface.getExtendClassList().add(
                cgOf.createType("java.lang.Thread"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgOf.createField("myField",
                "java.util.Date", "���t�t�B�[���h�̎����ł��B");
        cgInterface.getFieldList().add(cgField);
        cgField.setDefault("new Date()");

        // ���\�b�h�𐶐����܂��B
        final BlancoCgMethod cgMethod = cgOf.createMethod("myMethod",
                "���\�b�h�̎����ł��B");
        cgInterface.getMethodList().add(cgMethod);

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList()
                .add(
                        cgOf.createParameter("argString", "java.lang.String",
                                "����������B"));
        cgMethod.getParameterList().add(
                cgOf.createParameter("argDate", "java.util.Date", "���t�����B"));
        // �߂�l��ݒ肵�܂��B
        cgMethod.setReturn(cgOf.createReturn("boolean", "�����Ȃ�true�B"));

        cgMethod.getThrowList().add(
                cgOf.createException("java.io.IOException", "���o�͗�O�����������ꍇ�B"));

        final BlancoCgTransformer cgTransformerJava = BlancoCgTransformerFactory
                .getJavaSourceTransformer();
        cgTransformerJava.transform(cgSourceFile, new File("./tmp/blanco"));
    }
}
