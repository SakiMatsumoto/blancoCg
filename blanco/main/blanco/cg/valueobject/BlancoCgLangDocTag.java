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
 * ����p�̃h�L�������g�̃^�O��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * Java����̏ꍇ�ɂ� JavaDoc�̃^�O��\���܂��B
 */
public class BlancoCgLangDocTag {
    /**
     * ���̌���h�L�������g�̃^�O�̖��O�ł��Bauthor, see�Ȃǂ�����܂��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * �^�O�ɕt������L�[���w�肵�܂��B�K�v�̖����ꍇ�ɂ͖��w��Ƃ��܂��B
     *
     * �t�B�[���h: [key]�B
     */
    private String fKey;

    /**
     * ���̃^�O�̒l�ł��B
     *
     * �t�B�[���h: [value]�B
     */
    private String fValue;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̃^�O�̖��O�ł��Bauthor, see�Ȃǂ�����܂��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̌���h�L�������g�̃^�O�̖��O�ł��Bauthor, see�Ȃǂ�����܂��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [key] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�^�O�ɕt������L�[���w�肵�܂��B�K�v�̖����ꍇ�ɂ͖��w��Ƃ��܂��B]�B
     *
     * @param argKey �t�B�[���h[key]�ɐݒ肷��l�B
     */
    public void setKey(final String argKey) {
        fKey = argKey;
    }

    /**
     * �t�B�[���h [key] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�^�O�ɕt������L�[���w�肵�܂��B�K�v�̖����ꍇ�ɂ͖��w��Ƃ��܂��B]�B
     *
     * @return �t�B�[���h[key]����擾�����l�B
     */
    public String getKey() {
        return fKey;
    }

    /**
     * �t�B�[���h [value] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃^�O�̒l�ł��B]�B
     *
     * @param argValue �t�B�[���h[value]�ɐݒ肷��l�B
     */
    public void setValue(final String argValue) {
        fValue = argValue;
    }

    /**
     * �t�B�[���h [value] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃^�O�̒l�ł��B]�B
     *
     * @return �t�B�[���h[value]����擾�����l�B
     */
    public String getValue() {
        return fValue;
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
        buf.append("blanco.cg.valueobject.BlancoCgLangDocTag[");
        buf.append("name=" + fName);
        buf.append(",key=" + fKey);
        buf.append(",value=" + fValue);
        buf.append("]");
        return buf.toString();
    }
}
