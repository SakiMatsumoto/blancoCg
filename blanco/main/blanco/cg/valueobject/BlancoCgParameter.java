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
 * �p�����[�^��\�����邽�߂̃o�����[�I�u�W�F�N�g�B����ɂ���Ă͈����ƌĂ΂����̂ł��B
 */
public class BlancoCgParameter {
    /**
     * ���̃p�����[�^�̖��O�ł��BargOrigialString�Ȃǂ��w�肳��܂��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃p�����[�^�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̃p�����[�^�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [type]�B
     */
    private BlancoCgType fType;

    /**
     * ���̃t�B�[���h��final���ǂ����ł��B
     *
     * �t�B�[���h: [final]�B
     * �f�t�H���g: [true]�B
     */
    private boolean fFinal = true;

    /**
     * ���̃t�B�[���h��null��^����ꂽ�ۂɈ�����O�𔭐������邩�ǂ����B
     *
     * �t�B�[���h: [notnull]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fNotnull = false;

    /**
     * ���̃N���X�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B
     *
     * .NET Framework�ł̎��������̂ݑΉ����Ă��܂��B
     * �t�B�[���h: [annotationList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̖��O�ł��BargOrigialString�Ȃǂ��w�肳��܂��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̖��O�ł��BargOrigialString�Ȃǂ��w�肳��܂��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [type] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @param argType �t�B�[���h[type]�ɐݒ肷��l�B
     */
    public void setType(final BlancoCgType argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [type] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃p�����[�^�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @return �t�B�[���h[type]����擾�����l�B
     */
    public BlancoCgType getType() {
        return fType;
    }

    /**
     * �t�B�[���h [final] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h��final���ǂ����ł��B]�B
     *
     * @param argFinal �t�B�[���h[final]�ɐݒ肷��l�B
     */
    public void setFinal(final boolean argFinal) {
        fFinal = argFinal;
    }

    /**
     * �t�B�[���h [final] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h��final���ǂ����ł��B]�B
     * �f�t�H���g: [true]�B
     *
     * @return �t�B�[���h[final]����擾�����l�B
     */
    public boolean getFinal() {
        return fFinal;
    }

    /**
     * �t�B�[���h [notnull] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h��null��^����ꂽ�ۂɈ�����O�𔭐������邩�ǂ����B]�B
     *
     * @param argNotnull �t�B�[���h[notnull]�ɐݒ肷��l�B
     */
    public void setNotnull(final boolean argNotnull) {
        fNotnull = argNotnull;
    }

    /**
     * �t�B�[���h [notnull] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�B�[���h��null��^����ꂽ�ۂɈ�����O�𔭐������邩�ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[notnull]����擾�����l�B
     */
    public boolean getNotnull() {
        return fNotnull;
    }

    /**
     * �t�B�[���h [annotationList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     * .NET Framework�ł̎��������̂ݑΉ����Ă��܂��B
     *
     * @param argAnnotationList �t�B�[���h[annotationList]�ɐݒ肷��l�B
     */
    public void setAnnotationList(final List<java.lang.String> argAnnotationList) {
        fAnnotationList = argAnnotationList;
    }

    /**
     * �t�B�[���h [annotationList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     * .NET Framework�ł̎��������̂ݑΉ����Ă��܂��B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[annotationList]����擾�����l�B
     */
    public List<java.lang.String> getAnnotationList() {
        return fAnnotationList;
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
        buf.append("blanco.cg.valueobject.BlancoCgParameter[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",type=" + fType);
        buf.append(",final=" + fFinal);
        buf.append(",notnull=" + fNotnull);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append("]");
        return buf.toString();
    }
}
