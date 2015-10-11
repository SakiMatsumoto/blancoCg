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
 * �߂�l��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 *
 * �Ȃ��A���\�b�h�̖߂�l��void�ł���ꍇ�ɂ́A�ݒ肷��K�v�͂���܂���B
 */
public class BlancoCgReturn {
    /**
     * ���̖߂�l�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̖߂�l�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [type]�B
     */
    private BlancoCgType fType;

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̖߂�l�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̖߂�l�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [type] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̖߂�l�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @param argType �t�B�[���h[type]�ɐݒ肷��l�B
     */
    public void setType(final BlancoCgType argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [type] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̖߂�l�̌^�ł��Bjava.lang.String�Ȃǂ��w�肵�܂��B]�B
     *
     * @return �t�B�[���h[type]����擾�����l�B
     */
    public BlancoCgType getType() {
        return fType;
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
        buf.append("blanco.cg.valueobject.BlancoCgReturn[");
        buf.append("description=" + fDescription);
        buf.append(",type=" + fType);
        buf.append("]");
        return buf.toString();
    }
}
