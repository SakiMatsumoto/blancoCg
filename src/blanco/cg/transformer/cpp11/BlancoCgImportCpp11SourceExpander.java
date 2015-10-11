/*
 * blanco Framework
 * Copyright (C) 2004-2013 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.cpp11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * BlancoCgSourceFile�̂Ȃ��� import����W�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B<br>
 * import�W�J�͈ӊO�ɂ����G�ȏ����ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgImportCpp11SourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.CS;

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
        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�Bimport�Ώۂ̃N���X���I�[�ɕt�^����Ă���z��\�����������܂��B
        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�BtrimArraySuffix(argSourceFile.getImportList());

        // import(using)�̃��X�g����N���X�����������܂��B
        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�BtrimClassName(argSourceFile);

        // �ŏ���import�����\�[�g���ď������s���₷�����܂��B
        sortImport(argSourceFile.getImportList());

        // �d������import�����������܂��B
        trimRepeatedImport(argSourceFile.getImportList());

        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�Bimport����K�v�̂Ȃ��N���X���������܂�
        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�BtrimUnnecessaryImport(argSourceFile.getImportList());

        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�B���N���X����������p�b�P�[�W�ɑ΂���import��}�����܂��B
        // C++ �ɂ����ẮA���̕����ł͒ǉ��s�\�BtrimMyselfImport(argSourceFile, argSourceFile.getImportList());

        // �A���J�[��������������܂��B
        fFindReplaceImport = findAnchorString(argSourceLines);
        if (fFindReplaceImport < 0) {
            throw new IllegalArgumentException("import���̒u��������𔭌����邱�Ƃ��ł��܂���ł����B");
        }

        // �ŏ��ɁuSystem�v�p�b�P�[�W��W�J���܂��B
        expandImportWithTarget(argSourceFile, "System", argSourceLines);

        // �Ō�ɁuSystem�v�ȊO�̃p�b�P�[�W��W�J���܂��B
        expandImportWithTarget(argSourceFile, null, argSourceLines);

        // �A���J�[��������������܂��B
        removeAnchorString(argSourceLines);
    }

    /**
     * �W�J�ΏۂƂȂ�^�[�Q�b�g���ӎ����ăC���|�[�g��W�J���܂��B
     * 
     * @param argSourceFile
     * @param argTarget
     *            java. �܂��� javax. �܂��� null���w�肵�܂��B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandImportWithTarget(final BlancoCgSourceFile argSourceFile,
            final String argTarget, final List<java.lang.String> argSourceLines) {
        boolean isProcessed = false;
        for (int index = 0; index < argSourceFile.getImportList().size(); index++) {
            final String strImport = argSourceFile.getImportList().get(index);

            if (argTarget == null) {
                // System. �ȊO��W�J���܂��B
                if (strImport.startsWith("System")) {
                    // �����ΏۂƂ���p�b�P�[�W�ȊO�ł���̂ŁA�������X�L�b�v���܂��B
                    // ��System. �̓n�[�h�R�[�h����Ă���_�ɒ��ӂ��Ă��������B
                    continue;
                }
            } else {
                if (strImport.startsWith(argTarget) == false) {
                    // �����ΏۂƂ���p�b�P�[�W�ȊO�ł���̂ŁA�������X�L�b�v���܂��B
                    continue;
                }
            }

            isProcessed = true;
            argSourceLines.add(fFindReplaceImport++, "#include \"" + strImport+"\"");
        }

        if (isProcessed) {
            // import�W�J���������݂����ꍇ�ɂ̂݋󔒂�t�^���܂��B
            argSourceLines.add(fFindReplaceImport++, "");
        }
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
        argSourceLines.add(BlancoCgImportCpp11SourceExpander.REPLACE_IMPORT_HERE);
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

    /**
     * �^����ꂽimport���\�[�g���܂��B
     * 
     * �z�肳���m�[�h�̌^(java.lang.String)�ȊO���^������ƁA��O���������܂��B
     * 
     * @param argImport
     *            �C���|�[�g���X�g�B
     */
    private static final void sortImport(final List<java.lang.String> argImport) {
        Collections.sort(argImport, new Comparator<java.lang.String>() {
            public int compare(final String arg0, final String arg1) {
                if (arg0 instanceof String == false) {
                    throw new IllegalArgumentException("import�̃��X�g�̒l�ł����A["
                            + arg0 + "]�ł��� java.lang.String�ȊO�̌^["
                            + arg0.getClass().getName() + "]�ɂȂ��Ă��܂��B");
                }
                if (arg1 instanceof String == false) {
                    throw new IllegalArgumentException("import�̃��X�g�̒l�ł����A["
                            + arg1 + "]�ł��� java.lang.String�ȊO�̌^["
                            + arg1.getClass().getName() + "]�ɂȂ��Ă��܂��B");
                }
                final String str0 = (String) arg0;
                final String str1 = (String) arg1;
                return str0.compareTo(str1);
            }
        });
    }

    /**
     * �d������s�v��import���������܂��B
     * 
     * ���̃��\�b�h�́A�^����ꂽList�����Ƀ\�[�g�ς݂ł��邱�Ƃ�O��Ƃ��܂��B
     * 
     * @param argImport
     *            �C���|�[�g���X�g�B
     */
    private void trimRepeatedImport(final List<java.lang.String> argImport) {
        // �d������import�������B
        String pastImport = "";
        for (int index = argImport.size() - 1; index >= 0; index--) {
            final String strImport = argImport.get(index);
            if (pastImport.equals(strImport)) {
                // ���ɏ�������Ă���d������import�ł��B�s�v�Ȃ̂ł�����������܂��B
                argImport.remove(index);
            }
            // �����import��O��import�Ƃ��ċL�����܂��B
            pastImport = strImport;
        }
    }

    /**
     * ����̃p�b�P�[�W�ɂ��āA��������X�g���珜�����܂��B
     * 
     * ���N���X����������p�b�P�[�W�̏����ɗ��p����܂��B
     * 
     * @param argSpecificPackage
     *            �����ΏۂƂ���p�b�P�[�W�B
     * @param argImport
     *            �C���|�[�g�̃��X�g�B
     */
    private static void trimSpecificPackage(final String argSpecificPackage,
            final List<java.lang.String> argImport) {
        for (int index = argImport.size() - 1; index >= 0; index--) {
            // �\�[�g���_�Ō^�`�F�b�N�͎��{�ς݂ł��B
            final String strImport = argImport.get(index);

            // C#.NET�ł͖��O��Ԃ��i�[����Ă��܂��B���O��ԓ��m�𒼐ڔ�r���܂��B
            if (argSpecificPackage.equals(strImport)) {
                argImport.remove(index);
            }
        }
    }
}
