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
 * Delphi����p�̐��������B
 * 
 * @author YAMAMOTO Koji
 */
public class BlancoCgTransformerDelphiTest extends TestCase {
    /**
     * Delphi�̎����B
     * 
     * @throws Exception
     */
    public void testTransformerDelphi() throws Exception {
        final BlancoCgObjectFactory cgFactory = BlancoCgObjectFactory
                .getInstance();

        // �\�[�X�t�@�C���𐶐����܂��B

        final BlancoCgSourceFile cgSourceFile = cgFactory.createSourceFile(
                "Unit1", "�e�X�g�p�̃N���X");
        cgSourceFile.setName("Unit1");

        cgSourceFile.getImportList().add("System.Text.DummyText");
        // �����p�b�P�[�W�̃C���|�[�g�����B
        cgSourceFile.getImportList().add("Myprog.MyClass2");

        // �N���X�𐶐����܂��B
        final BlancoCgClass cgClass = cgFactory.createClass("TMyClass",
                "���̃N���X�́A�e�X�g�̂��߂̃N���X�ł��B");
        cgSourceFile.getClassList().add(cgClass);
        // cgClass.getLangDoc().getTagList().add(
        // cgFactory.createLangDocTag("author", null, "blanco Framework"));
        cgClass.getExtendClassList().add(cgFactory.createType("TObject"));
        // cgClass.getImplementInterfaceList().add(
        // cgFactory.createType("System.WebException"));
        // cgClass.getImplementInterfaceList().add(
        // cgFactory.createType("System.WebException2"));

        // �񋓑�
        // final BlancoCgEnum cgEnum = cgFactory.createEnum("FavorColor",
        // "�񋓑̂̎����B");
        // cgClass.getEnumList().add(cgEnum);
        // final BlancoCgEnumElement cgEnumElementFirst = cgFactory
        // .createEnumElement("Red", "����");
        // cgEnumElementFirst.setDefault("1");
        // cgEnum.getElementList().add(cgEnumElementFirst);
        // cgEnum.getElementList().add(
        // cgFactory.createEnumElement("Yerrow", "������"));
        // cgEnum.getElementList().add(cgFactory.createEnumElement("Blue",
        // "����"));

        // �t�B�[���h�𐶐����܂��B
        final BlancoCgField cgField = cgFactory.createField("MyField",
                "String", "String�t�B�[���h�̎����ł��B");
        cgClass.getFieldList().add(cgField);
        // cgField.setDefault("new DateTime()");
        //
        // final BlancoCgField cgField2 = cgFactory.createField("myField2",
        // "java.util.Date", "���t�t�B�[���h�̎���v2�ł��B");
        // cgClass.getFieldList().add(cgField2);
        // cgField2.getType().setArray(true);

        // �v���V�[�W���𐶐����܂��B
        final BlancoCgMethod cgMethod = cgFactory.createMethod("MyMethod",
                "�v���V�[�W���̎����ł��B");
        cgClass.getMethodList().add(cgMethod);

        // �p�����[�^��ǉ����܂��B
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argString", "String", "����������B"));
        cgMethod.getParameterList().add(
                cgFactory.createParameter("argInt", "integer", "���������B"));

        // �t�@���N�V�����𐶐����܂��B
        final BlancoCgMethod cgFunction = cgFactory.createMethod("MyFunction",
                "���\�b�h�̎����ł��B");
        cgClass.getMethodList().add(cgFunction);

        // �p�����[�^��ǉ����܂��B
        cgFunction.getParameterList().add(
                cgFactory.createParameter("argString", "String", "����������B"));
        cgFunction.getParameterList().add(
                cgFactory.createParameter("argInt", "integer", "���������B"));

        // �߂�l��ݒ肵�܂��B
        cgFunction.setReturn(cgFactory.createReturn("boolean", "�����Ȃ�true�B"));

        // cgMethod.getThrowList().add(
        // cgFactory.createException("System.IO.IOException",
        // "���o�͗�O�����������ꍇ�B"));

        // �A�m�e�[�V�����̒ǉ��B
        // cgMethod.getAnnotationList().add(
        // "Copyright(value=\"blanco Framework\")");

        // ���\�b�h�̓��e��ǉ����܂��B
        // cgMethod.getLineList().add("// ����̎����ł��B");
        // cgMethod.getLineList().add("int a = 0;");

        final BlancoCgTransformer cgTransformerDelphi = BlancoCgTransformerFactory
                .getDelphiSourceTransformer();
        cgTransformerDelphi.transform(cgSourceFile, new File("./tmp/blanco"));
    }

}
