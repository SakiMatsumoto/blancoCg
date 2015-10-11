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
import blanco.cg.valueobject.BlancoCgEnumElement;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * C++11 ����p�̐��������B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerCpp11Test extends TestCase {
    /**
     * C++11�̎����B
     * 
     * @throws Exception
     */
    public void testTransformerCpp11() throws Exception {
        final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
                .getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B
        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                "Myprog", "�e�X�g�p�̃N���X");
        cgSourceFile.getImportList().add("stdio.h");

        // �N���X�𐶐����܂��B
        final BlancoCgClass cgClass = cgFactory.createClass("MyClass",
                "���̃N���X�́A�e�X�g�̂��߂̃N���X�ł��B");
        cgSourceFile.getClassList().add(cgClass);
        cgClass.getLangDoc().getTagList().add(
                cgFactory.createLangDocTag("author", null, "blanco Framework"));
        cgClass.getExtendClassList().add(
                cgFactory.createType("java.lang.Thread"));
        cgClass.getImplementInterfaceList().add(
                cgFactory.createType("System.WebException"));
        cgClass.getImplementInterfaceList().add(
                cgFactory.createType("System.WebException2"));

        // �񋓑�
        final BlancoCgEnum cgEnum = cgFactory.createEnum("FavorColor",
                "�񋓑̂̎����B");
        cgClass.getEnumList().add(cgEnum);
        final BlancoCgEnumElement cgEnumElementFirst = cgFactory
                .createEnumElement("Red", "����");
        cgEnumElementFirst.setDefault("1");
        cgEnum.getElementList().add(cgEnumElementFirst);
        cgEnum.getElementList().add(
                cgFactory.createEnumElement("Yerrow", "������"));
        cgEnum.getElementList().add(cgFactory.createEnumElement("Blue", "����"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgFactory.createField("myField",
                "java.util.Date", "���t�t�B�[���h�̎����ł��B");
        cgClass.getFieldList().add(cgField);
        cgField.setDefault("new DateTime()");

        final BlancoCgField cgField2 = cgFactory.createField("myField2",
                "java.util.Date", "���t�t�B�[���h�̎���v2�ł��B");
        cgClass.getFieldList().add(cgField2);
        cgField2.getType().setArray(true);

        // ���\�b�h�𐶐����܂��B
        final BlancoCgMethod cgMethod = cgFactory.createMethod("MyMethod",
                "���\�b�h�̎����ł��B");
        cgClass.getMethodList().add(cgMethod);

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argString", "System.String",
                        "����������B"));
        cgMethod.getParameterList()
                .add(
                        cgFactory.createParameter("argDate", "System.DateTime",
                                "���t�����B"));
        // �߂�l��ݒ肵�܂��B
        cgMethod.setReturn(cgFactory.createReturn("bool", "�����Ȃ�true�B"));

        cgMethod.getThrowList().add(
                cgFactory.createException("System.IO.IOException",
                        "���o�͗�O�����������ꍇ�B"));

        // �A�m�e�[�V�����̒ǉ��B
        cgMethod.getAnnotationList().add(
                "Copyright(value=\"blanco Framework\")");

        // ���\�b�h�̓��e��ǉ����܂��B
        cgMethod.getLineList().add("// ����̎����ł��B");
        cgMethod.getLineList().add("int a = 0;");

        final BlancoCgTransformer cgTransformerCpp11 = BlancoCgTransformerFactory
                .getCpp11SourceTransformer();
        cgTransformerCpp11.transform(cgSourceFile, new File("./tmp/blanco"));
    }

    /**
     * �C���^�t�F�[�X�̓W�J�����B
     * 
     * @throws Exception
     */
    public void testTransformerInterface() throws Exception {
        final BlancoCgObjectFactory cgOf = BlancoCgObjectFactory.getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B
        final BlancoCgSourceFile cgSourceFile = cgOf.createSourceFile("Myprog",
                "�e�X�g�p�̃C���^�t�F�[�X");
        cgSourceFile.getImportList().add("Myprog.Class2");
        cgSourceFile.getImportList().add("Myprog2.ClassOther");

        // �N���X�𐶐����܂��B
        final BlancoCgInterface cgInterface = cgOf.createInterface(
                "MyInterface", "���̃C���^�t�F�[�X�́A�e�X�g�̂��߂̃C���^�t�F�[�X�ł��B");
        cgSourceFile.getInterfaceList().add(cgInterface);
        cgInterface.getLangDoc().getTagList().add(
                cgOf.createLangDocTag("author", null, "blanco Framework"));
        cgInterface.getExtendClassList().add(
                cgOf.createType("System.IO.IOException"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgOf.createField("myField",
                "System.DateTime", "���t�t�B�[���h�̎����ł��B");
        cgInterface.getFieldList().add(cgField);
        cgField.setDefault("new DateTime()");

        // ���\�b�h�𐶐����܂��B
        final BlancoCgMethod cgMethod = cgOf.createMethod("MyMethod",
                "���\�b�h�̎����ł��B");
        cgInterface.getMethodList().add(cgMethod);

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList().add(
                cgOf.createParameter("argString", "System.String", "����������B"));
        cgMethod.getParameterList().add(
                cgOf.createParameter("argDate", "System.DateTime", "���t�����B"));
        // �߂�l��ݒ肵�܂��B
        cgMethod.setReturn(cgOf.createReturn("bool", "�����Ȃ�true�B"));

        cgMethod.getThrowList().add(
                cgOf.createException("System.IO.IOException", "���o�͗�O�����������ꍇ�B"));

        final BlancoCgTransformer cgTransformerCpp11 = BlancoCgTransformerFactory
                .getCpp11SourceTransformer();
        cgTransformerCpp11.transform(cgSourceFile, new File("./tmp/blanco"));
    }
}
