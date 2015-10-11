/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.valueobject;

import java.util.List;

/**
 * �t�B�[���h��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * �v���O���~���O����ɂ���Ă̓v���p�e�B�ƌĂ΂�邱�Ƃ�����܂��B
 * ���|�C���g�F�N���X���̖��O�ό`�╶����̃G�X�P�[�v�����Ȃǂ́AblancoCg�ɗ^����O�Ɏ��{����Ă���K�v������܂��B
 */
public class BlancoCgField {
    /**
     * ���̃t�B�[���h�̖��O�ł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃t�B�[���h�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̃t�B�[���h�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [type]�B
     */
    private BlancoCgType fType;

    /**
     * �A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [access]�B
     * �f�t�H���g: ["private"]�B
     */
    private String fAccess = "private";

    /**
     * static���ǂ���������킵�܂��B
     *
     * �t�B�[���h: [static]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fStatic = false;

    /**
     * final���ǂ���������킵�܂��B
     *
     * �t�B�[���h: [final]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fFinal = false;

    /**
     * �f�t�H���g�l������킵�܂��B
     *
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     * �t�B�[���h: [default]�B
     */
    private String fDefault;

    /**
     * ���̃t�B�[���h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B
     *
     * �t�B�[���h: [annotationList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * ����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B
     *
     * �t�B�[���h: [langDoc]�B
     */
    private BlancoCgLangDoc fLangDoc;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̖��O�ł��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̖��O�ł��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [type] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @param argType �t�B�[���h[type]�ɐݒ肷��l�B
     */
    public void setType(final BlancoCgType argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [type] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @return �t�B�[���h[type]����擾�����l�B
     */
    public BlancoCgType getType() {
        return fType;
    }

    /**
     * �t�B�[���h [access] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B]�B
     *
     * @param argAccess �t�B�[���h[access]�ɐݒ肷��l�B
     */
    public void setAccess(final String argAccess) {
        fAccess = argAccess;
    }

    /**
     * �t�B�[���h [access] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B]�B
     * �f�t�H���g: ["private"]�B
     *
     * @return �t�B�[���h[access]����擾�����l�B
     */
    public String getAccess() {
        return fAccess;
    }

    /**
     * �t�B�[���h [static] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [static���ǂ���������킵�܂��B]�B
     *
     * @param argStatic �t�B�[���h[static]�ɐݒ肷��l�B
     */
    public void setStatic(final boolean argStatic) {
        fStatic = argStatic;
    }

    /**
     * �t�B�[���h [static] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [static���ǂ���������킵�܂��B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[static]����擾�����l�B
     */
    public boolean getStatic() {
        return fStatic;
    }

    /**
     * �t�B�[���h [final] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [final���ǂ���������킵�܂��B]�B
     *
     * @param argFinal �t�B�[���h[final]�ɐݒ肷��l�B
     */
    public void setFinal(final boolean argFinal) {
        fFinal = argFinal;
    }

    /**
     * �t�B�[���h [final] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [final���ǂ���������킵�܂��B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[final]����擾�����l�B
     */
    public boolean getFinal() {
        return fFinal;
    }

    /**
     * �t�B�[���h [default] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�f�t�H���g�l������킵�܂��B]�B
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     *
     * @param argDefault �t�B�[���h[default]�ɐݒ肷��l�B
     */
    public void setDefault(final String argDefault) {
        fDefault = argDefault;
    }

    /**
     * �t�B�[���h [default] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�f�t�H���g�l������킵�܂��B]�B
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     *
     * @return �t�B�[���h[default]����擾�����l�B
     */
    public String getDefault() {
        return fDefault;
    }

    /**
     * �t�B�[���h [annotationList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     *
     * @param argAnnotationList �t�B�[���h[annotationList]�ɐݒ肷��l�B
     */
    public void setAnnotationList(final List<java.lang.String> argAnnotationList) {
        fAnnotationList = argAnnotationList;
    }

    /**
     * �t�B�[���h [annotationList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[annotationList]����擾�����l�B
     */
    public List<java.lang.String> getAnnotationList() {
        return fAnnotationList;
    }

    /**
     * �t�B�[���h [langDoc] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B]�B
     *
     * @param argLangDoc �t�B�[���h[langDoc]�ɐݒ肷��l�B
     */
    public void setLangDoc(final BlancoCgLangDoc argLangDoc) {
        fLangDoc = argLangDoc;
    }

    /**
     * �t�B�[���h [langDoc] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B]�B
     *
     * @return �t�B�[���h[langDoc]����擾�����l�B
     */
    public BlancoCgLangDoc getLangDoc() {
        return fLangDoc;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.cg.valueobject.BlancoCgField[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",type=" + fType);
        buf.append(",access=" + fAccess);
        buf.append(",static=" + fStatic);
        buf.append(",final=" + fFinal);
        buf.append(",default=" + fDefault);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append(",langDoc=" + fLangDoc);
        buf.append("]");
        return buf.toString();
    }
}
