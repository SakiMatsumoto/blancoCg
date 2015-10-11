/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import blanco.cg.BlancoCgTransformer;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * �v���O���~���O����̎�ނ��܂����钊�ۓI�ȃg�����X�t�H�[�}�[�ł��B
 * 
 * @author IGA Tosiki
 */
abstract class AbstractBlancoCgTransformer implements BlancoCgTransformer {
    /**
     * �R�}���h���C���ɕ\������ۂ̃��b�Z�[�W�v���t�B�b�N�X�B
     */
    protected static final String CMDLINE_PREFIX = "cg: ";

    /**
     * �\�[�X�t�@�C���̊g���q���擾���܂��B
     * 
     * @return �g���q�B
     */
    protected abstract String getSourceFileExt();

    /**
     * �t�@�C�������N���X���܂��̓C���^�t�F�[�X�����瓱�o���܂��B
     * 
     * ���̃��\�b�h�́A�܂��t�@�C�������m�肵�Ă��Ȃ��ꍇ�ɂ̂݌Ăяo���܂��B
     * 
     * @param argSourceFile
     *            �\�[�X�t�@�C���I�u�W�F�N�g�B
     */
    protected void decideFilenameFromClassOrInterfaceName(
            final BlancoCgSourceFile argSourceFile) {
        // �t�@�C���������ݒ�̏ꍇ�ɁABlancoCgSourceFile(�t�@�C��)�̒��Ɋ܂܂��N���X������t�@�C�����̉��������݂܂��B
        String className = null;
        for (int index = 0; index < argSourceFile.getClassList().size(); index++) {
            final BlancoCgClass cgClass = argSourceFile.getClassList().get(
                    index);

            className = cgClass.getName();
            break;
        }

        if (className == null) {
            // �܂��t�@�C���������肵�Ă��Ȃ��ꍇ�ɂ́A�C���^�t�F�[�X�̈ꗗ������N���X���̓��o�����݂܂��B
            for (int index = 0; index < argSourceFile.getInterfaceList().size(); index++) {
                final BlancoCgInterface cgInterface = argSourceFile
                        .getInterfaceList().get(index);

                className = cgInterface.getName();
                break;
            }
        }

        if (className == null) {
            // ����ł��N���X�����m�肵�Ȃ��ꍇ�ɂ͗�O�Ƃ��Ĉ����܂��B
            throw new IllegalArgumentException(
                    "�\�[�X�t�@�C�����̎w�肪�Ȃ������̂ŃN���X�̃��X�g����N���X���̊m������݂܂������A�N���X���͊m��ł��܂���ł����B");
        }

        // �\�[�X�t�@�C�����̊m��������Ȃ��܂��B
        // �o�����[�I�u�W�F�N�g�̃\�[�X�t�@�C�������X�V���Ă���_�ɒ��ӂ��Ă��������B
        argSourceFile.setName(className);
    }

    /**
     * �\�[�X�R�[�h�����C�^�[�֏o�͂��܂��B
     * 
     * java.lang.String�̃��X�g�����C�^�[�ւƏo�͂��܂��B
     * 
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     * @param writer
     *            �o�͐惉�C�^�B
     * @throws IOException
     *             ���o�͗�O�����������ꍇ�B
     */
    protected void source2Writer(final List<java.lang.String> argSourceLines,
            final BufferedWriter writer) throws IOException {
        boolean isPastLineBlank = false;
        boolean isPastBlockStart = false;
        for (int index = 0; index < argSourceLines.size(); index++) {
            final String line = argSourceLines.get(index);

            // �A�������s�̏o�͂�}�����܂��B
            if (line.length() == 0) {
                if (isPastLineBlank) {
                    // �O��Ɉ��������������s�ł��������� ����͏o�͂�������܂��B
                    continue;
                }
                // ����͋�s�ł����B
                isPastLineBlank = true;
            } else {
                // ����͋�s�ł͂���܂���B
                isPastLineBlank = false;
            }

            if (isPastBlockStart && line.length() == 0) {
                // �O�񂪃u���b�N�̃X�^�[�g�ŁA���񂪋�s�̏ꍇ�ɂ͏o�͂�������܂��B
                continue;
            }

            if (line.endsWith("{")) {
                isPastBlockStart = true;
            } else {
                isPastBlockStart = false;
            }

            // �s�� 1�s �o�͂��܂��B
            writer.write(line);
            writer.newLine();
        }
    }
}
