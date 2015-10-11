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
 * �N���X��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * �N���X�����������������Ƃ��ɗ��p���܂��B
 * ���|�C���g�F�N���X���̖��O�ό`�╶����̃G�X�P�[�v�����Ȃǂ́AblancoCg�ɗ^����O�Ɏ��{����Ă���K�v������܂��B
 */
public class BlancoCgClass {
    /**
     * ���̃N���X�̖��O�ł��B�p�b�P�[�W���������N���X�����w�肷��_�ɒ��ӂ��Ă��������B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃N���X�̐����ł��BBlancoCgLangDoc�������ɂ́A���̒l�����p����܂��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * �W�F�l���N�X���w�肵�܂��B
     *
     * �t�B�[���h: [generics]�B
     */
    private String fGenerics;

    /**
     * �p�����N���X�̃��X�g�ł��B
     *
     * Java����ł͑��d�p�����֎~����Ă��邽�߁A�ЂƂ����w�肷��K�v������܂��B
     * �t�B�[���h: [extendClassList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgType> fExtendClassList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>();

    /**
     * �p�����C���^�t�F�[�X�̃��X�g�ł��B
     *
     * �t�B�[���h: [implementInterfaceList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgType> fImplementInterfaceList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>();

    /**
     * ���̃N���X�̃A�N�Z�X�R���g���[�����w�肵�܂��B
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
     * final���ǂ����B
     *
     * �t�B�[���h: [final]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fFinal = false;

    /**
     * ���̃N���X�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B
     *
     * �t�B�[���h: [annotationList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * ���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B
     *
     * �t�B�[���h: [enumList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgEnum> fEnumList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>();

    /**
     * ���̃N���X�Ɋ܂܂��t�B�[���h�̃��X�g�ł��B
     *
     * �t�B�[���h: [fieldList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgField>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgField> fFieldList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgField>();

    /**
     * ���̃N���X�Ɋ܂܂�郁�\�b�h�̃��X�g�ł��B
     *
     * �t�B�[���h: [methodList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgMethod>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgMethod> fMethodList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgMethod>();

    /**
     * ����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B
     *
     * �t�B�[���h: [langDoc]�B
     */
    private BlancoCgLangDoc fLangDoc;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�̖��O�ł��B�p�b�P�[�W���������N���X�����w�肷��_�ɒ��ӂ��Ă��������B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�̖��O�ł��B�p�b�P�[�W���������N���X�����w�肷��_�ɒ��ӂ��Ă��������B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�̐����ł��BBlancoCgLangDoc�������ɂ́A���̒l�����p����܂��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�̐����ł��BBlancoCgLangDoc�������ɂ́A���̒l�����p����܂��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [generics] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�W�F�l���N�X���w�肵�܂��B]�B
     *
     * @param argGenerics �t�B�[���h[generics]�ɐݒ肷��l�B
     */
    public void setGenerics(final String argGenerics) {
        fGenerics = argGenerics;
    }

    /**
     * �t�B�[���h [generics] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�W�F�l���N�X���w�肵�܂��B]�B
     *
     * @return �t�B�[���h[generics]����擾�����l�B
     */
    public String getGenerics() {
        return fGenerics;
    }

    /**
     * �t�B�[���h [extendClassList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�p�����N���X�̃��X�g�ł��B]�B
     * Java����ł͑��d�p�����֎~����Ă��邽�߁A�ЂƂ����w�肷��K�v������܂��B
     *
     * @param argExtendClassList �t�B�[���h[extendClassList]�ɐݒ肷��l�B
     */
    public void setExtendClassList(final List<blanco.cg.valueobject.BlancoCgType> argExtendClassList) {
        fExtendClassList = argExtendClassList;
    }

    /**
     * �t�B�[���h [extendClassList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�p�����N���X�̃��X�g�ł��B]�B
     * Java����ł͑��d�p�����֎~����Ă��邽�߁A�ЂƂ����w�肷��K�v������܂��B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>()]�B
     *
     * @return �t�B�[���h[extendClassList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgType> getExtendClassList() {
        return fExtendClassList;
    }

    /**
     * �t�B�[���h [implementInterfaceList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�p�����C���^�t�F�[�X�̃��X�g�ł��B]�B
     *
     * @param argImplementInterfaceList �t�B�[���h[implementInterfaceList]�ɐݒ肷��l�B
     */
    public void setImplementInterfaceList(final List<blanco.cg.valueobject.BlancoCgType> argImplementInterfaceList) {
        fImplementInterfaceList = argImplementInterfaceList;
    }

    /**
     * �t�B�[���h [implementInterfaceList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�p�����C���^�t�F�[�X�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgType>()]�B
     *
     * @return �t�B�[���h[implementInterfaceList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgType> getImplementInterfaceList() {
        return fImplementInterfaceList;
    }

    /**
     * �t�B�[���h [access] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�̃A�N�Z�X�R���g���[�����w�肵�܂��B]�B
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
     * �t�B�[���h�̐���: [���̃N���X�̃A�N�Z�X�R���g���[�����w�肵�܂��B]�B
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
     * �t�B�[���h [annotationList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�ɕt�^����Ă���A�m�e�[�V�����̃��X�g�ł��B]�B
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
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[annotationList]����擾�����l�B
     */
    public List<java.lang.String> getAnnotationList() {
        return fAnnotationList;
    }

    /**
     * �t�B�[���h [enumList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B]�B
     *
     * @param argEnumList �t�B�[���h[enumList]�ɐݒ肷��l�B
     */
    public void setEnumList(final List<blanco.cg.valueobject.BlancoCgEnum> argEnumList) {
        fEnumList = argEnumList;
    }

    /**
     * �t�B�[���h [enumList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>()]�B
     *
     * @return �t�B�[���h[enumList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgEnum> getEnumList() {
        return fEnumList;
    }

    /**
     * �t�B�[���h [fieldList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�Ɋ܂܂��t�B�[���h�̃��X�g�ł��B]�B
     *
     * @param argFieldList �t�B�[���h[fieldList]�ɐݒ肷��l�B
     */
    public void setFieldList(final List<blanco.cg.valueobject.BlancoCgField> argFieldList) {
        fFieldList = argFieldList;
    }

    /**
     * �t�B�[���h [fieldList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�Ɋ܂܂��t�B�[���h�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgField>()]�B
     *
     * @return �t�B�[���h[fieldList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgField> getFieldList() {
        return fFieldList;
    }

    /**
     * �t�B�[���h [methodList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�Ɋ܂܂�郁�\�b�h�̃��X�g�ł��B]�B
     *
     * @param argMethodList �t�B�[���h[methodList]�ɐݒ肷��l�B
     */
    public void setMethodList(final List<blanco.cg.valueobject.BlancoCgMethod> argMethodList) {
        fMethodList = argMethodList;
    }

    /**
     * �t�B�[���h [methodList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃N���X�Ɋ܂܂�郁�\�b�h�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgMethod>()]�B
     *
     * @return �t�B�[���h[methodList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgMethod> getMethodList() {
        return fMethodList;
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
        buf.append("blanco.cg.valueobject.BlancoCgClass[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",generics=" + fGenerics);
        buf.append(",extendClassList=" + fExtendClassList);
        buf.append(",implementInterfaceList=" + fImplementInterfaceList);
        buf.append(",access=" + fAccess);
        buf.append(",abstract=" + fAbstract);
        buf.append(",final=" + fFinal);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append(",enumList=" + fEnumList);
        buf.append(",fieldList=" + fFieldList);
        buf.append(",methodList=" + fMethodList);
        buf.append(",langDoc=" + fLangDoc);
        buf.append("]");
        return buf.toString();
    }
}
