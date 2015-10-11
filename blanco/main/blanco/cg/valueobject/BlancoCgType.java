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

/**
 * �^��\�����邽�߂̃o�����[�I�u�W�F�N�g�B�����̃N���X���Q�Ƃ���ꍇ�ɗ��p����܂��B
 *
 * ���̃o�����[�I�u�W�F�N�g�ł́A�ΏۂƂȂ�^���N���X�Ȃ̂��C���^�t�F�[�X�Ȃ̂��͕\�����܂���B�N���X���C���^�t�F�[�X�Ȃ̂��ɂ��Ă͓��肵�Ȃ��̂ł��B
 * ���̃N���X�̑��݈Ӌ`�� generics��array�Ƃ������t�B�[���h�������Ă���_�ł��B������\�����邽�߂ɁA�^�͒P�Ȃ�java.lang.String�ł͂Ȃ��o�����[�I�u�W�F�N�g�ł���K�v������A�܂� BlancoCgClass�Ƃ������\�[�X�R�[�h�𐶐����邽�߂̌^�Ƃ͈�����悷��K�v���o�Ă���̂ł��B
 */
public class BlancoCgType {
    /**
     * ���̌^�̖��O�ł��Bjava.lang.String�Ȃǃp�b�P�[�W���t���Ŏw�肵�܂��B[]�͊܂ނ��Ƃ͏o���܂���B�z���\���ꍇ�ɂ� array�t�B�[���h�𗘗p���܂��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̌^�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̌^�ɒǉ������W�F�l���N�X���w�肵�܂��B
     *
     * �t�B�[���h: [generics]�B
     */
    private String fGenerics;

    /**
     * �^���z��Ȃ̂��ǂ����������܂��B
     *
     * �t�B�[���h: [array]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fArray = false;

    /**
     * �^�̔z��̎��������w�肵�܂��B�z��̏ꍇ�ɂ̂ݗ��p����܂��B��Java, C#.NET �őΉ��B����ȊO�̌���ł͖��Ή��B
     *
     * �t�B�[���h: [arrayDimension]�B
     * �f�t�H���g: [1]�B
     */
    private int fArrayDimension = 1;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌^�̖��O�ł��Bjava.lang.String�Ȃǃp�b�P�[�W���t���Ŏw�肵�܂��B[]�͊܂ނ��Ƃ͏o���܂���B�z���\���ꍇ�ɂ� array�t�B�[���h�𗘗p���܂��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌^�̖��O�ł��Bjava.lang.String�Ȃǃp�b�P�[�W���t���Ŏw�肵�܂��B[]�͊܂ނ��Ƃ͏o���܂���B�z���\���ꍇ�ɂ� array�t�B�[���h�𗘗p���܂��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌^�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌^�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [generics] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌^�ɒǉ������W�F�l���N�X���w�肵�܂��B]�B
     *
     * @param argGenerics �t�B�[���h[generics]�ɐݒ肷��l�B
     */
    public void setGenerics(final String argGenerics) {
        fGenerics = argGenerics;
    }

    /**
     * �t�B�[���h [generics] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌^�ɒǉ������W�F�l���N�X���w�肵�܂��B]�B
     *
     * @return �t�B�[���h[generics]����擾�����l�B
     */
    public String getGenerics() {
        return fGenerics;
    }

    /**
     * �t�B�[���h [array] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�^���z��Ȃ̂��ǂ����������܂��B]�B
     *
     * @param argArray �t�B�[���h[array]�ɐݒ肷��l�B
     */
    public void setArray(final boolean argArray) {
        fArray = argArray;
    }

    /**
     * �t�B�[���h [array] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�^���z��Ȃ̂��ǂ����������܂��B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[array]����擾�����l�B
     */
    public boolean getArray() {
        return fArray;
    }

    /**
     * �t�B�[���h [arrayDimension] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�^�̔z��̎��������w�肵�܂��B�z��̏ꍇ�ɂ̂ݗ��p����܂��B��Java, C#.NET �őΉ��B����ȊO�̌���ł͖��Ή��B]�B
     *
     * @param argArrayDimension �t�B�[���h[arrayDimension]�ɐݒ肷��l�B
     */
    public void setArrayDimension(final int argArrayDimension) {
        fArrayDimension = argArrayDimension;
    }

    /**
     * �t�B�[���h [arrayDimension] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�^�̔z��̎��������w�肵�܂��B�z��̏ꍇ�ɂ̂ݗ��p����܂��B��Java, C#.NET �őΉ��B����ȊO�̌���ł͖��Ή��B]�B
     * �f�t�H���g: [1]�B
     *
     * @return �t�B�[���h[arrayDimension]����擾�����l�B
     */
    public int getArrayDimension() {
        return fArrayDimension;
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
        buf.append("blanco.cg.valueobject.BlancoCgType[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",generics=" + fGenerics);
        buf.append(",array=" + fArray);
        buf.append(",arrayDimension=" + fArrayDimension);
        buf.append("]");
        return buf.toString();
    }
}
