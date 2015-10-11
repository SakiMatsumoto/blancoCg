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
 * ���[�J���ϐ���\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * Delphi�ȂǁA���[�J���ϐ����C�����C���Œ�`�ł��Ȃ��v���O���~���O����Ŏg�p���܂��B
 * ���|�C���g�F�N���X���̖��O�ό`�╶����̃G�X�P�[�v�����Ȃǂ́AblancoCg�ɗ^����O�Ɏ��{����Ă���K�v������܂��B
 */
public class BlancoCgLocalVariable {
    /**
     * ���̃t�B�[���h�̖��O�ł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃t�B�[���h�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [type]�B
     */
    private BlancoCgType fType;

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
        buf.append("blanco.cg.valueobject.BlancoCgLocalVariable[");
        buf.append("name=" + fName);
        buf.append(",type=" + fType);
        buf.append(",final=" + fFinal);
        buf.append(",default=" + fDefault);
        buf.append("]");
        return buf.toString();
    }
}
