/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̃C���^�t�F�[�X�ł��B
 *
 * �ʂ̌���p�̃\�[�X�R�[�h�������������́A���̃C���^�t�F�[�X���������Ď�������܂��B
 *
 * @author IGA Tosiki
 */
public interface BlancoCgTransformer {
    /**
     * �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g��Java�\�[�X�R�[�h�ɕϊ����ďo�͐�f�B���N�g���ɏo�͂��܂��B
     *
     * ����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ��čl�����܂��B
     *
     * @param sourceFile �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B
     * @param outputDirectory �o�͐惋�[�g�f�B���N�g���B
     */
    void transform(final BlancoCgSourceFile sourceFile, final File outputDirectory);

    /**
     * �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g���\�[�X�R�[�h�ɕϊ����ă��C�^�[�ɏo�͂��܂��B
     *
     * ����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ͍l�����܂���B
     *
     * @param sourceFile �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B
     * @param writer �o�͐�̃��C�^�[�B
     * @throws IOException ���o�͗�O�����������ꍇ�B
     */
    void transform(final BlancoCgSourceFile sourceFile, final BufferedWriter writer) throws IOException;
}
