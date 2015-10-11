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
 * ���\�b�h��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * ���|�C���g�F���\�b�h���̖��O�ό`�́AblancoCg�ɗ^����O�Ɏ��{����Ă���K�v������܂��B
 */
public class BlancoCgMethod {
    /**
     * ���̃��\�b�h�̖��O�ł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃��\�b�h�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̃��\�b�h�̃A�N�Z�X�R���g���[�����w�肵�܂��B
     *
     * public/protected/private�Ȃǂ��w�肵�܂��B
     * �t�B�[���h: [access]�B
     * �f�t�H���g: ["public"]�B
     */
    private String fAccess = "public";

    /**
     * ���ۃN���X���ǂ����B
     *
     * �t�B�[���h: [abstract]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fAbstract = false;

    /**
     * static���ǂ����B
     *
     * �t�B�[���h: [static]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fStatic = false;

    /**
     * �I�[�o���C�h���Ă��邩�ǂ����B
     *
     * �t�B�[���h: [override]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fOverride = false;

    /**
     * final���ǂ����B
     *
     * �t�B�[���h: [final]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fFinal = false;

    /**
     * �R���X�g���N�^���ǂ����B
     *
     * �t�B�[���h: [constructor]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fConstructor = false;

    /**
     * static initializer ���ǂ����B�����_(2009-05-18)�ł� Java ����ł̂ݗL���ł��B
     *
     * �t�B�[���h: [staticInitializer]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fStaticInitializer = false;

    /**
     * ���̃��\�b�h�̃p�����[�^�̃��X�g�ł��B
     *
     * �t�B�[���h: [parameterList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgParameter>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgParameter> fParameterList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgParameter>();

    /**
     * ���̃��\�b�h�̖߂�l�ł��B
     *
     * �t�B�[���h: [return]�B
     */
    private BlancoCgReturn fReturn;

    /**
     * ���̃��\�b�h�������������O�̈ꗗ�ł��B
     *
     * �t�B�[���h: [throwList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgException> fThrowList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>();

    /**
     * ���̃��\�b�h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B
     *
     * �t�B�[���h: [annotationList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * ���̃��\�b�h���Ŏg�p���郍�[�J���ϐ��̃��X�g�ł��BDelphi����ȂǁA�C�����C���Ń��[�J���ϐ���`���ł��Ȃ�����ł̂ݎg�p���܂��B
     *
     * �t�B�[���h: [localVariableList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLocalVariable>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgLocalVariable> fLocalVariableList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLocalVariable>();

    /**
     * ���̃��\�b�h�Ɋ܂܂��s�̃��X�g�ł��B
     *
     * �t�B�[���h: [lineList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fLineList = new java.util.ArrayList<java.lang.String>();

    /**
     * �R���X�g���N�^�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�AC#.NET���� base(����)�̕�����S�Ă��w�肵�܂��B��ʃ��\�b�h�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�̕�����S�Ă��w�肵�܂��B�Z�~�R�����͊܂݂܂���B
     *
     * �t�B�[���h: [superclassInvocation]�B
     */
    private String fSuperclassInvocation;

    /**
     * ����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B
     *
     * �t�B�[���h: [langDoc]�B
     */
    private BlancoCgLangDoc fLangDoc;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̖��O�ł��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̖��O�ł��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [access] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̃A�N�Z�X�R���g���[�����w�肵�܂��B]�B
     * public/protected/private�Ȃǂ��w�肵�܂��B
     *
     * @param argAccess �t�B�[���h[access]�ɐݒ肷��l�B
     */
    public void setAccess(final String argAccess) {
        fAccess = argAccess;
    }

    /**
     * �t�B�[���h [access] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̃A�N�Z�X�R���g���[�����w�肵�܂��B]�B
     * public/protected/private�Ȃǂ��w�肵�܂��B
     * �f�t�H���g: ["public"]�B
     *
     * @return �t�B�[���h[access]����擾�����l�B
     */
    public String getAccess() {
        return fAccess;
    }

    /**
     * �t�B�[���h [abstract] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���ۃN���X���ǂ����B]�B
     *
     * @param argAbstract �t�B�[���h[abstract]�ɐݒ肷��l�B
     */
    public void setAbstract(final boolean argAbstract) {
        fAbstract = argAbstract;
    }

    /**
     * �t�B�[���h [abstract] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���ۃN���X���ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[abstract]����擾�����l�B
     */
    public boolean getAbstract() {
        return fAbstract;
    }

    /**
     * �t�B�[���h [static] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [static���ǂ����B]�B
     *
     * @param argStatic �t�B�[���h[static]�ɐݒ肷��l�B
     */
    public void setStatic(final boolean argStatic) {
        fStatic = argStatic;
    }

    /**
     * �t�B�[���h [static] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [static���ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[static]����擾�����l�B
     */
    public boolean getStatic() {
        return fStatic;
    }

    /**
     * �t�B�[���h [override] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�I�[�o���C�h���Ă��邩�ǂ����B]�B
     *
     * @param argOverride �t�B�[���h[override]�ɐݒ肷��l�B
     */
    public void setOverride(final boolean argOverride) {
        fOverride = argOverride;
    }

    /**
     * �t�B�[���h [override] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�I�[�o���C�h���Ă��邩�ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[override]����擾�����l�B
     */
    public boolean getOverride() {
        return fOverride;
    }

    /**
     * �t�B�[���h [final] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [final���ǂ����B]�B
     *
     * @param argFinal �t�B�[���h[final]�ɐݒ肷��l�B
     */
    public void setFinal(final boolean argFinal) {
        fFinal = argFinal;
    }

    /**
     * �t�B�[���h [final] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [final���ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[final]����擾�����l�B
     */
    public boolean getFinal() {
        return fFinal;
    }

    /**
     * �t�B�[���h [constructor] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�R���X�g���N�^���ǂ����B]�B
     *
     * @param argConstructor �t�B�[���h[constructor]�ɐݒ肷��l�B
     */
    public void setConstructor(final boolean argConstructor) {
        fConstructor = argConstructor;
    }

    /**
     * �t�B�[���h [constructor] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�R���X�g���N�^���ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[constructor]����擾�����l�B
     */
    public boolean getConstructor() {
        return fConstructor;
    }

    /**
     * �t�B�[���h [staticInitializer] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [static initializer ���ǂ����B�����_(2009-05-18)�ł� Java ����ł̂ݗL���ł��B]�B
     *
     * @param argStaticInitializer �t�B�[���h[staticInitializer]�ɐݒ肷��l�B
     */
    public void setStaticInitializer(final boolean argStaticInitializer) {
        fStaticInitializer = argStaticInitializer;
    }

    /**
     * �t�B�[���h [staticInitializer] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [static initializer ���ǂ����B�����_(2009-05-18)�ł� Java ����ł̂ݗL���ł��B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[staticInitializer]����擾�����l�B
     */
    public boolean getStaticInitializer() {
        return fStaticInitializer;
    }

    /**
     * �t�B�[���h [parameterList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̃p�����[�^�̃��X�g�ł��B]�B
     *
     * @param argParameterList �t�B�[���h[parameterList]�ɐݒ肷��l�B
     */
    public void setParameterList(final List<blanco.cg.valueobject.BlancoCgParameter> argParameterList) {
        fParameterList = argParameterList;
    }

    /**
     * �t�B�[���h [parameterList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̃p�����[�^�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgParameter>()]�B
     *
     * @return �t�B�[���h[parameterList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgParameter> getParameterList() {
        return fParameterList;
    }

    /**
     * �t�B�[���h [return] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̖߂�l�ł��B]�B
     *
     * @param argReturn �t�B�[���h[return]�ɐݒ肷��l�B
     */
    public void setReturn(final BlancoCgReturn argReturn) {
        fReturn = argReturn;
    }

    /**
     * �t�B�[���h [return] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�̖߂�l�ł��B]�B
     *
     * @return �t�B�[���h[return]����擾�����l�B
     */
    public BlancoCgReturn getReturn() {
        return fReturn;
    }

    /**
     * �t�B�[���h [throwList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�������������O�̈ꗗ�ł��B]�B
     *
     * @param argThrowList �t�B�[���h[throwList]�ɐݒ肷��l�B
     */
    public void setThrowList(final List<blanco.cg.valueobject.BlancoCgException> argThrowList) {
        fThrowList = argThrowList;
    }

    /**
     * �t�B�[���h [throwList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�������������O�̈ꗗ�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>()]�B
     *
     * @return �t�B�[���h[throwList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgException> getThrowList() {
        return fThrowList;
    }

    /**
     * �t�B�[���h [annotationList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     *
     * @param argAnnotationList �t�B�[���h[annotationList]�ɐݒ肷��l�B
     */
    public void setAnnotationList(final List<java.lang.String> argAnnotationList) {
        fAnnotationList = argAnnotationList;
    }

    /**
     * �t�B�[���h [annotationList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[annotationList]����擾�����l�B
     */
    public List<java.lang.String> getAnnotationList() {
        return fAnnotationList;
    }

    /**
     * �t�B�[���h [localVariableList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h���Ŏg�p���郍�[�J���ϐ��̃��X�g�ł��BDelphi����ȂǁA�C�����C���Ń��[�J���ϐ���`���ł��Ȃ�����ł̂ݎg�p���܂��B]�B
     *
     * @param argLocalVariableList �t�B�[���h[localVariableList]�ɐݒ肷��l�B
     */
    public void setLocalVariableList(final List<blanco.cg.valueobject.BlancoCgLocalVariable> argLocalVariableList) {
        fLocalVariableList = argLocalVariableList;
    }

    /**
     * �t�B�[���h [localVariableList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h���Ŏg�p���郍�[�J���ϐ��̃��X�g�ł��BDelphi����ȂǁA�C�����C���Ń��[�J���ϐ���`���ł��Ȃ�����ł̂ݎg�p���܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLocalVariable>()]�B
     *
     * @return �t�B�[���h[localVariableList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgLocalVariable> getLocalVariableList() {
        return fLocalVariableList;
    }

    /**
     * �t�B�[���h [lineList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�Ɋ܂܂��s�̃��X�g�ł��B]�B
     *
     * @param argLineList �t�B�[���h[lineList]�ɐݒ肷��l�B
     */
    public void setLineList(final List<java.lang.String> argLineList) {
        fLineList = argLineList;
    }

    /**
     * �t�B�[���h [lineList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃��\�b�h�Ɋ܂܂��s�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[lineList]����擾�����l�B
     */
    public List<java.lang.String> getLineList() {
        return fLineList;
    }

    /**
     * �t�B�[���h [superclassInvocation] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�R���X�g���N�^�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�AC#.NET���� base(����)�̕�����S�Ă��w�肵�܂��B��ʃ��\�b�h�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�̕�����S�Ă��w�肵�܂��B�Z�~�R�����͊܂݂܂���B]�B
     *
     * @param argSuperclassInvocation �t�B�[���h[superclassInvocation]�ɐݒ肷��l�B
     */
    public void setSuperclassInvocation(final String argSuperclassInvocation) {
        fSuperclassInvocation = argSuperclassInvocation;
    }

    /**
     * �t�B�[���h [superclassInvocation] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�R���X�g���N�^�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�AC#.NET���� base(����)�̕�����S�Ă��w�肵�܂��B��ʃ��\�b�h�̏ꍇ�ɂ́AJava���ꂾ�� super(����)�̕�����S�Ă��w�肵�܂��B�Z�~�R�����͊܂݂܂���B]�B
     *
     * @return �t�B�[���h[superclassInvocation]����擾�����l�B
     */
    public String getSuperclassInvocation() {
        return fSuperclassInvocation;
    }

    /**
     * �t�B�[���h [langDoc] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B]�B
     *
     * @param argLangDoc �t�B�[���h[langDoc]�ɐݒ肷��l�B
     */
    public void setLangDoc(final BlancoCgLangDoc argLangDoc) {
        fLangDoc = argLangDoc;
    }

    /**
     * �t�B�[���h [langDoc] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B]�B
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
        buf.append("blanco.cg.valueobject.BlancoCgMethod[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",access=" + fAccess);
        buf.append(",abstract=" + fAbstract);
        buf.append(",static=" + fStatic);
        buf.append(",override=" + fOverride);
        buf.append(",final=" + fFinal);
        buf.append(",constructor=" + fConstructor);
        buf.append(",staticInitializer=" + fStaticInitializer);
        buf.append(",parameterList=" + fParameterList);
        buf.append(",return=" + fReturn);
        buf.append(",throwList=" + fThrowList);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append(",localVariableList=" + fLocalVariableList);
        buf.append(",lineList=" + fLineList);
        buf.append(",superclassInvocation=" + fSuperclassInvocation);
        buf.append(",langDoc=" + fLangDoc);
        buf.append("]");
        return buf.toString();
    }
}
