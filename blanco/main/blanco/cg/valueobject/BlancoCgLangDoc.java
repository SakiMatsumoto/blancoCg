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
 * ����p�̃h�L�������g��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * Java����̏ꍇ�ɂ� JavaDoc��\���܂��B�����������ɑ��́u�����v�t�B�[���h�⃁�\�b�h�̃p�����[�^�Ȃǂ����񂪍\�z�����ꍇ������܂��B
 * ���|�C���g�F�R�����g������̃G�X�P�[�v�����Ȃǂ́AblancoCg�ɗ^����O�Ɏ��{����Ă���K�v������܂��B
 */
public class BlancoCgLangDoc {
    /**
     * ���̌���h�L�������g�̃^�C�g�������ł��B���̌�����description���玩����������邱�Ƃ������ł��B
     *
     * �t�B�[���h: [title]�B
     */
    private String fTitle;

    /**
     * ���̌���h�L�������g�̏ڍא����ł��B(java.lang.String)�̃��X�g�ł��B
     *
     * �����ŗ^����ꂽ�����񂪂��̂܂܃h�L�������g�������ɓW�J����邽�߁A�ʏ�͕����Q�ƃG���R�[�f�B���O�����{�������Ƃ̒l���Z�b�g���܂��B(�G���R�[�f�B���O��̂��̂�^���邩�炱���A<pre>�Ȃǂ��������邱�Ƃ��ł���̂ł��B)
     * �t�B�[���h: [descriptionList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fDescriptionList = new java.util.ArrayList<java.lang.String>();

    /**
     * ��������Ȃ��ꍇ�ɁA�񐄏��̗��R���L�ڂ���܂��B
     *
     * �t�B�[���h: [deprecated]�B
     */
    private String fDeprecated;

    /**
     * �p�����[�^�̃��X�g�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B
     *
     * �t�B�[���h: [parameterList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgParameter>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgParameter> fParameterList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgParameter>();

    /**
     * ���̃��\�b�h�̖߂�l�ł��B
     *
     * �߂�l������ (void)�̏ꍇ�ɂ� null���Z�b�g���܂��B
     * �t�B�[���h: [return]�B
     */
    private BlancoCgReturn fReturn;

    /**
     * �����������O�̈ꗗ�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B
     *
     * �t�B�[���h: [throwList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgException> fThrowList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>();

    /**
     * ����h�L�������g�̃^�O�̃��X�g�BBlancoCgLangDocTag�����X�g�Ɋi�[����܂��B
     *
     * �t�B�[���h: [tagList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLangDocTag>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgLangDocTag> fTagList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLangDocTag>();

    /**
     * �t�B�[���h [title] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̃^�C�g�������ł��B���̌�����description���玩����������邱�Ƃ������ł��B]�B
     *
     * @param argTitle �t�B�[���h[title]�ɐݒ肷��l�B
     */
    public void setTitle(final String argTitle) {
        fTitle = argTitle;
    }

    /**
     * �t�B�[���h [title] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̃^�C�g�������ł��B���̌�����description���玩����������邱�Ƃ������ł��B]�B
     *
     * @return �t�B�[���h[title]����擾�����l�B
     */
    public String getTitle() {
        return fTitle;
    }

    /**
     * �t�B�[���h [descriptionList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̏ڍא����ł��B(java.lang.String)�̃��X�g�ł��B]�B
     * �����ŗ^����ꂽ�����񂪂��̂܂܃h�L�������g�������ɓW�J����邽�߁A�ʏ�͕����Q�ƃG���R�[�f�B���O�����{�������Ƃ̒l���Z�b�g���܂��B(�G���R�[�f�B���O��̂��̂�^���邩�炱���A<pre>�Ȃǂ��������邱�Ƃ��ł���̂ł��B)
     *
     * @param argDescriptionList �t�B�[���h[descriptionList]�ɐݒ肷��l�B
     */
    public void setDescriptionList(final List<java.lang.String> argDescriptionList) {
        fDescriptionList = argDescriptionList;
    }

    /**
     * �t�B�[���h [descriptionList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̏ڍא����ł��B(java.lang.String)�̃��X�g�ł��B]�B
     * �����ŗ^����ꂽ�����񂪂��̂܂܃h�L�������g�������ɓW�J����邽�߁A�ʏ�͕����Q�ƃG���R�[�f�B���O�����{�������Ƃ̒l���Z�b�g���܂��B(�G���R�[�f�B���O��̂��̂�^���邩�炱���A<pre>�Ȃǂ��������邱�Ƃ��ł���̂ł��B)
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[descriptionList]����擾�����l�B
     */
    public List<java.lang.String> getDescriptionList() {
        return fDescriptionList;
    }

    /**
     * �t�B�[���h [deprecated] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��������Ȃ��ꍇ�ɁA�񐄏��̗��R���L�ڂ���܂��B]�B
     *
     * @param argDeprecated �t�B�[���h[deprecated]�ɐݒ肷��l�B
     */
    public void setDeprecated(final String argDeprecated) {
        fDeprecated = argDeprecated;
    }

    /**
     * �t�B�[���h [deprecated] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��������Ȃ��ꍇ�ɁA�񐄏��̗��R���L�ڂ���܂��B]�B
     *
     * @return �t�B�[���h[deprecated]����擾�����l�B
     */
    public String getDeprecated() {
        return fDeprecated;
    }

    /**
     * �t�B�[���h [parameterList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�p�����[�^�̃��X�g�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B]�B
     *
     * @param argParameterList �t�B�[���h[parameterList]�ɐݒ肷��l�B
     */
    public void setParameterList(final List<blanco.cg.valueobject.BlancoCgParameter> argParameterList) {
        fParameterList = argParameterList;
    }

    /**
     * �t�B�[���h [parameterList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�p�����[�^�̃��X�g�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B]�B
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
     * �߂�l������ (void)�̏ꍇ�ɂ� null���Z�b�g���܂��B
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
     * �߂�l������ (void)�̏ꍇ�ɂ� null���Z�b�g���܂��B
     *
     * @return �t�B�[���h[return]����擾�����l�B
     */
    public BlancoCgReturn getReturn() {
        return fReturn;
    }

    /**
     * �t�B�[���h [throwList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����������O�̈ꗗ�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B]�B
     *
     * @param argThrowList �t�B�[���h[throwList]�ɐݒ肷��l�B
     */
    public void setThrowList(final List<blanco.cg.valueobject.BlancoCgException> argThrowList) {
        fThrowList = argThrowList;
    }

    /**
     * �t�B�[���h [throwList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����������O�̈ꗗ�ł��B���\�b�h�̏ꍇ�ɂ̂ݗ��p����܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgException>()]�B
     *
     * @return �t�B�[���h[throwList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgException> getThrowList() {
        return fThrowList;
    }

    /**
     * �t�B�[���h [tagList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g�̃^�O�̃��X�g�BBlancoCgLangDocTag�����X�g�Ɋi�[����܂��B]�B
     *
     * @param argTagList �t�B�[���h[tagList]�ɐݒ肷��l�B
     */
    public void setTagList(final List<blanco.cg.valueobject.BlancoCgLangDocTag> argTagList) {
        fTagList = argTagList;
    }

    /**
     * �t�B�[���h [tagList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g�̃^�O�̃��X�g�BBlancoCgLangDocTag�����X�g�Ɋi�[����܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgLangDocTag>()]�B
     *
     * @return �t�B�[���h[tagList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgLangDocTag> getTagList() {
        return fTagList;
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
        buf.append("blanco.cg.valueobject.BlancoCgLangDoc[");
        buf.append("title=" + fTitle);
        buf.append(",descriptionList=" + fDescriptionList);
        buf.append(",deprecated=" + fDeprecated);
        buf.append(",parameterList=" + fParameterList);
        buf.append(",return=" + fReturn);
        buf.append(",throwList=" + fThrowList);
        buf.append(",tagList=" + fTagList);
        buf.append("]");
        return buf.toString();
    }
}
