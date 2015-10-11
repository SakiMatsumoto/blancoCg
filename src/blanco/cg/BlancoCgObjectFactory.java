/*
 * blanco Framework
 * Copyright (C) 2004-2008 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg;

import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgEnumElement;
import blanco.cg.valueobject.BlancoCgException;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgLangDocTag;
import blanco.cg.valueobject.BlancoCgLocalVariable;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgParameter;
import blanco.cg.valueobject.BlancoCgReturn;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.cg.valueobject.BlancoCgType;

/**
 * blancoCg�̃o�����[�I�u�W�F�N�g���쐬���邽�߂̃t�@�N�g���N���X�ł��B
 * 
 * ���̃N���X�̓v���O���~���O����𒴂��ė��p����܂��B<br>
 * blancoCg�̃o�����[�I�u�W�F�N�g�́A���̃t�@�N�g���N���X���o�R���Đ������邱�Ƃ���������܂��B <br>
 * �Ƃ͂����ʂɃo�����[�I�u�W�F�N�g�𐶐����邱�Ƃ͋֎~���Ă��܂���B
 * 
 * �����̃N���X�� ��final�Ƃ��܂��B���p�҂����̃N���X���p�����Ċg�����邱�Ƃ�z�肵�܂��B
 * 
 * �ȑO createLine �Ƃ������\�b�h������܂������A�p�~����܂����B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgObjectFactory {

    /**
     * �I�u�W�F�N�g�t�@�N�g���̃R���X�g���N�^�B
     * 
     * private�����āA�t�@�N�g����ʂ��Ă����V�K�쐬�ł��Ȃ��悤�ɂ��Ă��܂��B
     */
    private BlancoCgObjectFactory() {
    }

    /**
     * BlancoCg�I�u�W�F�N�g�t�@�N�g���̃C���X�^���X���擾���܂��B
     * 
     * @return BlancoCg�I�u�W�F�N�g�t�@�N�g���̃C���X�^���X�B
     */
    public static BlancoCgObjectFactory getInstance() {
        return new BlancoCgObjectFactory();
    }

    /**
     * �\�[�X�t�@�C���C���X�^���X�𐶐����܂��B
     * 
     * �t�@�C�����͖����I�Ɏw�肵�Ă��Ȃ��Ƃ����_�ɒ��ӂ��ČĂяo���Ă��������B<br>
     * �\�[�X�t�@�C�����̓N���X�����瓱�o����܂��B
     * 
     * @param argPackageName
     *            �p�b�P�[�W���B���̃p�b�P�[�W�����玩���������̃f�B���N�g���\�������肳��܂��B
     * @param argDescription
     *            �\�[�X�t�@�C���̐����B
     * @return �\�[�X�t�@�C���C���X�^���X�B
     */
    public BlancoCgSourceFile createSourceFile(final String argPackageName,
            final String argDescription) {
        final BlancoCgSourceFile cgSourceFile = new BlancoCgSourceFile();
        cgSourceFile.setPackage(argPackageName);
        cgSourceFile.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgSourceFile.setLangDoc(new BlancoCgLangDoc());

        return cgSourceFile;
    }

    /**
     * �^�C���X�^���X�𐶐����܂��B
     * 
     * �z��t���O��W�F�l���N�X�w��ɂ��ẮA������̃I�u�W�F�N�g�ɃZ�b�g���Ă��������B
     * 
     * @param argTypeName
     *            �^���B�p�b�P�[�W�����܂񂾃N���X���E�C���^�t�F�[�X�����w�肷��_�ɒ��ӂ��Ă��������B
     * @return �^�C���X�^���X�B
     */
    public BlancoCgType createType(final String argTypeName) {
        final BlancoCgType cgType = new BlancoCgType();
        cgType.setName(getTypeNameWithoutGenerics(argTypeName));

        // Description�ɂ��ẮA�t�@�N�g������̐������ɂ̓Z�b�g���܂���B

        // �W�F�l���N�X������΂����ɂ́A������i�[
        cgType.setGenerics(getGenericsFromFullName(argTypeName));

        return cgType;
    }

    /**
     * �N���X�C���X�^���X�𐶐����܂��B
     * 
     * @param argClassName
     *            �N���X���B�p�b�P�[�W���������N���X�����w�肷��_�ɒ��ӂ��Ă��������B�p�b�P�[�W���̓\�[�X�t�@�C���C���X�^���X���Q�Ƃ�����œ��o����܂�
     *            �B
     * @param argDescription
     *            �N���X�̐����B
     * @return �N���X�C���X�^���X�B
     */
    public BlancoCgClass createClass(final String argClassName,
            final String argDescription) {
        final BlancoCgClass cgClass = new BlancoCgClass();
        cgClass.setName(argClassName);
        cgClass.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgClass.setLangDoc(new BlancoCgLangDoc());

        return cgClass;
    }

    /**
     * �C���^�t�F�[�X�C���X�^���X�𐶐����܂��B
     * 
     * @param argInterfaceName
     *            �C���^�t�F�[�X���B�p�b�P�[�W���������C���^�t�F�[�X�����w�肷��_�ɒ��ӂ��Ă��������B
     *            �p�b�P�[�W���̓\�[�X�t�@�C���C���X�^���X���Q�Ƃ�����œ��o����܂��B
     * @param argDescription
     *            �C���^�t�F�[�X�̐����B
     * @return �C���^�t�F�[�X�C���X�^���X�B
     */
    public BlancoCgInterface createInterface(final String argInterfaceName,
            final String argDescription) {
        final BlancoCgInterface cgInterface = new BlancoCgInterface();
        cgInterface.setName(argInterfaceName);
        cgInterface.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgInterface.setLangDoc(new BlancoCgLangDoc());

        return cgInterface;
    }

    /**
     * �t�B�[���h�C���X�^���X�𐶐����܂��B
     * 
     * @param argName
     *            �t�B�[���h�̕ϐ����B
     * @param argTypeNameWithPackage
     *            �p�b�P�[�W���t���̌^���B
     * @param argDescription
     *            �t�B�[���h�̐����B
     * @return �t�B�[���h�C���X�^���X�B
     */
    public BlancoCgField createField(final String argName,
            final String argTypeNameWithPackage, final String argDescription) {
        final BlancoCgField cgField = new BlancoCgField();
        cgField.setName(argName);
        cgField.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgField.setLangDoc(new BlancoCgLangDoc());

        // �^�I�u�W�F�N�g���쐬���āA�����Z�b�g���܂��B
        cgField.setType(createType(argTypeNameWithPackage));

        return cgField;
    }

    /**
     * ���\�b�h�C���X�^���X�𐶐����܂��B
     * 
     * @param methodName
     *            ���\�b�h���B
     * @param argDescription
     *            ���\�b�h�̐����B
     * @return ���\�b�h�C���X�^���X�B
     */
    public BlancoCgMethod createMethod(final String methodName,
            final String argDescription) {
        final BlancoCgMethod cgMethod = new BlancoCgMethod();
        cgMethod.setName(methodName);
        cgMethod.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgMethod.setLangDoc(new BlancoCgLangDoc());

        return cgMethod;
    }

    /**
     * �p�����[�^�C���X�^���X�𐶐����܂��B
     * 
     * @param argName
     *            �p�����[�^�̈������B
     * @param argFullTypeName
     *            �t���^���B
     * @param argDescription
     *            �����B
     * @return �p�����[�^�C���X�^���X�B
     */
    public BlancoCgParameter createParameter(final String argName,
            final String argFullTypeName, final String argDescription) {
        return createParameter(argName, argFullTypeName, argDescription, false);
    }

    /**
     * �p�����[�^�C���X�^���X�𐶐����܂��B
     * 
     * @param argName
     *            �p�����[�^�̈������B
     * @param argFullTypeName
     *            �t���^���B
     * @param argDescription
     *            �����B
     * @param argNotNull
     *            ��null���񂪕t�^����邩�ǂ����B
     * @return �p�����[�^�C���X�^���X�B
     */
    public BlancoCgParameter createParameter(final String argName,
            final String argFullTypeName, final String argDescription,
            final boolean argNotNull) {
        final BlancoCgParameter cgParameter = new BlancoCgParameter();
        cgParameter.setName(argName);
        cgParameter.setDescription(argDescription);
        cgParameter.setNotnull(argNotNull);

        // ����h�L�������g�̃C���X�^���X�́A�p�����[�^�C���X�^���X�ɂ͑��݂��܂���B

        // �^�I�u�W�F�N�g���쐬���āA�����Z�b�g���܂��B
        cgParameter.setType(createType(argFullTypeName));

        return cgParameter;
    }

    /**
     * ���[�J���ϐ���`�C���X�^���X�𐶐����܂��B
     * 
     */
    public BlancoCgLocalVariable createLocalVariable(final String argName,
            final String argType) {
        final BlancoCgLocalVariable cgLocalVariable = new BlancoCgLocalVariable();
        cgLocalVariable.setName(argName);

        // ����h�L�������g�̃C���X�^���X�́A���[�J���ϐ���`�C���X�^���X�ɂ͑��݂��܂���B

        // �^�I�u�W�F�N�g���쐬���āA�����Z�b�g���܂��B
        cgLocalVariable.setType(createType(argType));

        return cgLocalVariable;
    }

    /**
     * Return�C���X�^���X�𐶐����܂��B
     * 
     * @param argFullTypeName
     *            �t���^���B
     * @param argDescription
     *            �߂�l�̐����B
     * @return Return�C���X�^���X�B
     */
    public BlancoCgReturn createReturn(final String argFullTypeName,
            final String argDescription) {
        final BlancoCgReturn cgReturn = new BlancoCgReturn();
        cgReturn.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X�́AReturn�C���X�^���X�ɂ͑��݂��܂���B

        // �^�I�u�W�F�N�g���쐬���āA�����Z�b�g���܂��B
        cgReturn.setType(createType(argFullTypeName));

        return cgReturn;
    }

    /**
     * ��O�C���X�^���X�𐶐����܂��B
     * 
     * @param argFullTypeName
     *            �t���^���B
     * @param argDescription
     *            �����B
     * @return ��O�C���X�^���X�B
     */
    public BlancoCgException createException(final String argFullTypeName,
            final String argDescription) {
        final BlancoCgException cgException = new BlancoCgException();
        cgException.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X�́A��O�C���X�^���X�ɂ͑��݂��܂���B

        // �^�I�u�W�F�N�g���쐬���āA�����Z�b�g���܂��B
        cgException.setType(createType(argFullTypeName));

        return cgException;
    }

    /**
     * �񋓑̃C���X�^���X�𐶐����܂��B
     * 
     * @param argEnumName
     *            �񋓑̖̂��O�B
     * @param argDescription
     *            �񋓑̂̐����B
     * @return �񋓑̃C���X�^���X�B
     */
    public BlancoCgEnum createEnum(final String argEnumName,
            final String argDescription) {
        final BlancoCgEnum cgEnum = new BlancoCgEnum();
        cgEnum.setName(argEnumName);
        cgEnum.setDescription(argDescription);

        // ����h�L�������g�̃C���X�^���X���f�t�H���g�Ő������܂��B
        cgEnum.setLangDoc(new BlancoCgLangDoc());

        return cgEnum;
    }

    /**
     * �񋓑̗̂v�f�̃C���X�^���X�𐶐����܂��B
     * 
     * @param argEnumElementName
     *            �񋓑̗̂v�f�̖��O�B
     * @param argDescription
     *            �񋓑̗̂v�f�̐����B
     * @return �񋓑̗v�f�C���X�^���X�B
     */
    public BlancoCgEnumElement createEnumElement(
            final String argEnumElementName, final String argDescription) {
        final BlancoCgEnumElement cgEnumElement = new BlancoCgEnumElement();
        cgEnumElement.setName(argEnumElementName);
        cgEnumElement.setDescription(argDescription);

        return cgEnumElement;
    }

    /**
     * ����h�L�������g�̃^�O�𐶐����܂��B
     * 
     * @param argName
     *            �^�O�̖��O�B
     * @param argKey
     *            �^�O�̃L�[���B�w�肵���������ꍇ�ɂ�null��^���܂��B
     * @param argValue
     *            �^�O�̒l�B
     * @return �s�C���X�^���X�B
     */
    public BlancoCgLangDocTag createLangDocTag(final String argName,
            final String argKey, final String argValue) {
        final BlancoCgLangDocTag cgTag = new BlancoCgLangDocTag();
        cgTag.setName(argName);
        cgTag.setKey(argKey);
        cgTag.setValue(argValue);

        return cgTag;
    }

    private String getTypeNameWithoutGenerics(final String argFullType) {
        int find = argFullType.indexOf('<');
        if (find > 0) {
            return argFullType.substring(0, find);
        }
        return argFullType;
    }

    private String getGenericsFromFullName(final String argFullType) {
        int find = argFullType.indexOf('<');
        if (find > 0) {
            return argFullType.substring(find);
        }
        return null;
    }

}