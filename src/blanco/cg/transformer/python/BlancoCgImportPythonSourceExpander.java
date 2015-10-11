/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.python;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoNameUtil;

/**
 * BlancoCgSourceFile�̂Ȃ��� import����W�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B<br>
 * import�W�J�͈ӊO�ɂ����G�ȏ����ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgImportPythonSourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.JAVA;

    /**
     * �\�[�g���ɗD�悵�ď��������p�b�P�[�W�ꗗ�B
     */
    private static final String[] PREFERRED_PACKAGE = { "java.", "javax.",
            "org.", "blanco.", "com." };

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
        // import�Ώۂ̃N���X���I�[�ɕt�^����Ă���z��\�����������܂��B
        trimArraySuffix(argSourceFile.getImportList());

        // �ŏ���import�����\�[�g���ď������s���₷�����܂��B
        sortImport(argSourceFile.getImportList());

        // �d������import�����������܂��B
        trimRepeatedImport(argSourceFile.getImportList());

        // import����K�v�̂Ȃ��N���X���������܂�
        trimUnnecessaryImport(argSourceFile.getImportList());

        // ���N���X����������p�b�P�[�W�ɑ΂���import��}�����܂��B
        trimMyselfImport(argSourceFile, argSourceFile.getImportList());

        // �A���J�[��������������܂��B
        fFindReplaceImport = findAnchorString(argSourceLines);
        if (fFindReplaceImport < 0) {
            throw new IllegalArgumentException("import���̒u��������𔭌����邱�Ƃ��ł��܂���ł����B");
        }

        for (int indexPreferredPackage = 0; indexPreferredPackage < PREFERRED_PACKAGE.length; indexPreferredPackage++) {
            // �D��p�b�P�[�W���ŏ��ɓW�J���܂��B
            expandImportWithTarget(argSourceFile,
                    PREFERRED_PACKAGE[indexPreferredPackage], argSourceLines);
        }

        // �Ō�ɗD��p�b�P�[�W�ȊO (�ujava.�v�ujavax.�v�ȂǈȊO)�̃p�b�P�[�W��W�J���܂��B
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
                // �D��p�b�P�[�W�ȊO (java. javax. �ȊO) ��W�J���܂��B
                if (isPreferredPackage(strImport)) {
                    // �����ΏۂƂ���p�b�P�[�W�ȊO�ł���̂ŁA�������X�L�b�v���܂��B
                    // ��java. ����� javax. �̓n�[�h�R�[�h����Ă���_�ɒ��ӂ��Ă��������B
                    continue;
                }
            } else {
                if (strImport.startsWith(argTarget) == false) {
                    // �����ΏۂƂ���p�b�P�[�W�ȊO�ł���̂ŁA�������X�L�b�v���܂��B
                    continue;
                }
            }

            isProcessed = true;
            argSourceLines.add(fFindReplaceImport++, "import " + strImport
                    + BlancoCgLineUtil.getTerminator(TARGET_LANG));
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
        argSourceLines
                .add(BlancoCgImportPythonSourceExpander.REPLACE_IMPORT_HERE);
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
                final String str0 = arg0;
                final String str1 = arg1;
                return str0.compareTo(str1);
            }
        });
    }

    /**
     * import�Ώۂ̃N���X���I�[�ɕt�^����Ă���z��\�����������܂��B
     * 
     * @param argImport
     *            �C���|�[�g���X�g�B
     */
    private void trimArraySuffix(final List<java.lang.String> argImport) {
        for (int index = 0; index < argImport.size(); index++) {
            String strImport = argImport.get(index);
            for (;;) {
                // �z��\���ŏI�����Ă������J��Ԃ��܂��B
                if (strImport.endsWith("[]")) {
                    strImport = strImport.substring(0, strImport.length() - 2);
                    argImport.set(index, strImport);
                } else {
                    break;
                }
            }
        }
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
     * import����K�v�̂Ȃ��N���X���������܂��B
     * 
     * ��̓I�ɂ� java.lang �� �v���~�e�B�u�^���s�v�Ɣ��f�����Ώۂł��B
     * 
     * @param argImport
     *            �C���|�[�g���X�g�B
     */
    private void trimUnnecessaryImport(final List<java.lang.String> argImport) {
        // �܂��̓v���~�e�B�u�^���������܂��B
        for (int index = argImport.size() - 1; index >= 0; index--) {
            // �\�[�g���_�Ō^�`�F�b�N�͎��{�ς݂ł��B
            final String strImport = argImport.get(index);

            if (BlancoCgTypePythonSourceExpander
                    .isLanguageReservedKeyword(strImport)) {
                argImport.remove(index);
            }
        }

        // ���� java.lang���������܂��B
        // ����� Java����ɂ����� java.lang�p�b�P�[�W�͈Öق̂����ɃC���|�[�g�����p�b�P�[�W�ł��邩��ł��B
        trimSpecificPackage("java.lang", argImport);
    }

    /**
     * �^����ꂽ�����񂪗D��p�b�P�[�W�ł��邩�ǂ������`�F�b�N���܂��B
     * 
     * @param argCheck
     *            �`�F�b�N������������B
     * @return �D��p�b�P�[�W�ɊY���������ǂ����B
     */
    private boolean isPreferredPackage(final String argCheck) {
        for (int index = 0; index < PREFERRED_PACKAGE.length; index++) {
            if (argCheck.startsWith(PREFERRED_PACKAGE[index])) {
                // ���̕�����͗D��p�b�P�[�W�ɊY�����܂��B
                return true;
            }
        }

        // �L�[���[�h�Ƀq�b�g���܂���ł����B���̕�����̓v���O���~���O����̗\���ł͂���܂���B
        return false;
    }

    /**
     * �������g����������p�b�P�[�W��import���������܂��B
     * 
     * @param argSourceFile
     *            �\�[�X�t�@�C���C���X�^���X�B
     * @param argImport
     *            �C���|�[�g���X�g�B
     */
    private void trimMyselfImport(final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argImport) {
        trimSpecificPackage(argSourceFile.getPackage(), argImport);
    }

    /**
     * ����̃p�b�P�[�W�ɂ��āA��������X�g���珜�����܂��B
     * 
     * java.lang�̏�������ю��N���X����������p�b�P�[�W�̏����ɗ��p����܂��B
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

            if (strImport.indexOf(".") < 0) {
                // �p�b�P�[�W�\���������Ȃ����߁A�폜��₩��͂����܂��B
                continue;
            }

            // import�����ɂ����ẮAblancoCg��Type�Ɋւ��鋤�ʏ����𗘗p���邱�Ƃ͂ł��܂���B
            // �ʂɋL�q���s���܂��B
            final String strImportWithoutPackage = BlancoNameUtil
                    .trimJavaPackage(strImport);
            final String strPackage = strImport.substring(0, strImport.length()
                    - strImportWithoutPackage.length());

            if ((argSpecificPackage + ".").equals(strPackage)) {
                // java.lang.String�Ȃǂ͏������܂��B
                argImport.remove(index);
            }
        }
    }
}
