/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * blancoCg �̃��\�[�X�o���h���B
 *
 * ���\�[�X�o���h����`: [BlancoCg]�B<BR>
 * ���̃N���X�̓��\�[�X�o���h����`�����玩���������ꂽ���\�[�X�o���h���N���X�ł��B<BR>
 * ���m�̃��P�[��<BR>
 * <UL>
 * <LI>ja
 * </UL>
 */
public class BlancoCgResourceBundle {
    /**
     * ���\�[�X�o���h���I�u�W�F�N�g�B
     *
     * �����I�Ɏ��ۂɓ��͂��s�����\�[�X�o���h�����L�����܂��B
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoCgResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoCg]�A�f�t�H���g�̃��P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     */
    public BlancoCgResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/cg/resourcebundle/BlancoCg");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoCgResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoCg]�A�w�肳�ꂽ���P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     */
    public BlancoCgResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/cg/resourcebundle/BlancoCg", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoCgResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoCg]�A�w�肳�ꂽ���P�[���A�w�肳�ꂽ�N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     * @param loader �N���X���[�_�̎w��
     */
    public BlancoCgResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/cg/resourcebundle/BlancoCg", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g���擾���܂��B
     *
     * @return �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g�B
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoCg], key[DEFAULT_FILE_COMMENT]
     *
     * [���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B] (ja)<br>
     *
     * @return key[DEFAULT_FILE_COMMENT]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getDefaultFileComment() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("DEFAULT_FILE_COMMENT");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }

    /**
     * bundle[BlancoCg], key[FILE_HEADER_PATH]
     *
     * [./meta/program/fileheader.txt] (ja)<br>
     *
     * @return key[FILE_HEADER_PATH]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getFileHeaderPath() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "./meta/program/fileheader.txt";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("FILE_HEADER_PATH");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }
}
