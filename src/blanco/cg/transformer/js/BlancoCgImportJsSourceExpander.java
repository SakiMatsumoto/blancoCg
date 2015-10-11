/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.js;

import java.util.List;

import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * BlancoCgSourceFile�̂Ȃ��� import����W�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B<br>
 * import�W�J�͈ӊO�ɂ����G�ȏ����ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgImportJsSourceExpander {
    /**
     * import����W�J���邽�߂̃A���J�[������B
     */
    private static final String REPLACE_IMPORT_HERE = "/*replace import here*/";

    /**
     * �������ꂽ�A���J�[������̃C���f�b�N�X�B
     * 
     * ���̃N���X�̏����̉ߒ��� import�����ҏW����܂����A���̓s�x ���̒l���X�V����܂��B
     */
    private int fFindReplaceImport = -1;

    /**
     * import��W�J���܂��B
     * 
     * ���̃��\�b�h�̓N���X�W�J�E���\�b�h�W�J�Ȃǈꎮ���I��������ɌĂяo���悤�ɂ��܂��B
     * 
     * @param argSourceFile
     *            �\�[�X�t�@�C���C���X�^���X�B
     * @param argSourceLines
     *            �\�[�X�s�C���[�W�B(java.lang.String���i�[����܂�)
     */
    public void transformImport(final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        // �A���J�[��������������܂��B
        fFindReplaceImport = findAnchorString(argSourceLines);
        if (fFindReplaceImport < 0) {
            throw new IllegalArgumentException("import���̒u��������𔭌����邱�Ƃ��ł��܂���ł����B");
        }

        // �A���J�[��������������܂��B
        removeAnchorString(argSourceLines);
    }

    /**
     * �u���A���J�[������̍s��(0�I���W��)���������܂��B
     * 
     * @return ���������A���J�[������̈ʒu(0�I���W��)�B�����ł��Ȃ������ꍇ�ɂ�-1�B
     * @param argSourceLines
     *            �\�[�X���X�g�B
     */
    private static final int findAnchorString(
            final List<java.lang.String> argSourceLines) {
        for (int index = 0; index < argSourceLines.size(); index++) {
            final String line = argSourceLines.get(index);
            if (line.equals(REPLACE_IMPORT_HERE)) {
                // �������܂����B
                return index;
            }
        }

        // �����ł��܂���ł����B�����ł��Ȃ��������Ƃ����� -1 ��߂��܂��B
        return -1;
    }

    /**
     * �A���J�[�������}�����܂��B
     * 
     * �����̌㔼�ŃC���|�[�g����Ґ����Ȃ����܂����A���̍ۂɎQ�Ƃ���A���J�[�������ǉ����Ă����܂��B<br>
     * ���̃��\�b�h�͑��̃N���X����Ăяo����܂��B
     * 
     * @param argSourceLines
     *            �\�[�X���X�g�B
     */
    public static final void insertAnchorString(
            final List<java.lang.String> argSourceLines) {
        argSourceLines.add(BlancoCgImportJsSourceExpander.REPLACE_IMPORT_HERE);
    }

    /**
     * �A���J�[��������������܂��B
     * 
     * @param argSourceLines
     *            �\�[�X���X�g�B
     */
    private static final void removeAnchorString(
            final List<java.lang.String> argSourceLines) {
        // �Ō�ɃA���J�[�����񂻂̂��̂������B
        int findReplaceImport2 = findAnchorString(argSourceLines);
        if (findReplaceImport2 < 0) {
            throw new IllegalArgumentException("import���̒u��������𔭌����邱�Ƃ��ł��܂���ł����B");
        }
        argSourceLines.remove(findReplaceImport2);
    }
}
