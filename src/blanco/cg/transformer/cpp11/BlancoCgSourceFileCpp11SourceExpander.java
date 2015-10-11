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

import java.util.ArrayList;
import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.util.BlancoCgSourceFileUtil;
import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgSourceFile���\�[�X�R�[�h�ɓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgSourceFileCpp11SourceExpander {
    /**
     * ���̃N���X�������ΏۂƂ���v���O���~���O����B
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.CS;

    /**
     * ���͂ƂȂ�\�[�X�R�[�h�\���B
     */
    private BlancoCgSourceFile fCgSourceFile = null;

    /**
     * ���ԓI�ɗ��p����\�[�X�R�[�h������킷List�Bjava.lang.String�����X�g�Ɋi�[����܂��B(BlancoCgLine�ł͂���܂���B
     * )
     * 
     * �����ł͐��`�O�\�[�X�R�[�h�����ԓI�ɂ����킦���܂��B
     */
    private List<java.lang.String> fSourceLines = null;

    /**
     * SourceFile���琮�`�O�\�[�X�R�[�h���X�g�𐶐����܂��B
     * 
     * @param argSourceFile
     *            �\�[�X�R�[�h������킷�o�����[�I�u�W�F�N�g�B
     * @return �\�[�X�R�[�h�ɓW�J��̃��X�g�B
     */
    public List<java.lang.String> transformSourceFile(
            final BlancoCgSourceFile argSourceFile) {
        // �m���Ƀ\�[�X�s�̃��X�g�����������܂��B
        fSourceLines = new ArrayList<java.lang.String>();

        fCgSourceFile = argSourceFile;

        // �\�[�X�t�@�C���̃t�@�C���w�b�_�[���o�͏������܂��B
        expandSourceFileHeader();

        // �����̌㔼�ŃC���|�[�g����Ґ����Ȃ����܂����A���̍ۂɎQ�Ƃ���A���J�[�������ǉ����Ă����܂��B
        BlancoCgImportCpp11SourceExpander.insertAnchorString(fSourceLines);

        // �p�b�P�[�W�����̐����B
        if (BlancoStringUtil.null2Blank(fCgSourceFile.getPackage()).length() > 0) {
            fSourceLines.add("namespace " + fCgSourceFile.getPackage());
            fSourceLines.add("{");
        }

        if (fCgSourceFile.getImportList() == null) {
            throw new IllegalArgumentException("import�̃��X�g��null���^�����܂����B");
        }

        // �񋓑̂̓W�J�����{���܂��B
        for (BlancoCgEnum cgEnum : fCgSourceFile.getEnumList()) {
            new BlancoCgEnumCpp11SourceExpander().transformEnum(cgEnum,
                    argSourceFile, fSourceLines);
        }

        // �C���^�t�F�[�X�̓W�J�����{���܂��B
        if (fCgSourceFile.getInterfaceList() == null) {
            throw new IllegalArgumentException("�C���^�t�F�[�X�̃��X�g��null���^�����܂����B");
        }
        for (BlancoCgInterface cgInterface : fCgSourceFile.getInterfaceList()) {
            new BlancoCgInterfaceCpp11SourceExpander().transformInterface(
                    cgInterface, fCgSourceFile, fSourceLines);
        }

        // �N���X�̓W�J�����{���܂��B
        if (fCgSourceFile.getClassList() == null) {
            throw new IllegalArgumentException("�N���X�̃��X�g��null���^�����܂����B");
        }
        for (BlancoCgClass cgClass : fCgSourceFile.getClassList()) {
            new BlancoCgClassCpp11SourceExpander().transformClass(cgClass,
                    fCgSourceFile, fSourceLines);
        }

        if (BlancoStringUtil.null2Blank(fCgSourceFile.getPackage()).length() > 0) {
            fSourceLines.add("};");
        }

        // import�̓W�J�����܂��B
        // ���̏������A�N���X�W�J����Ɏ��{����Ă���̂ɂ͈Ӗ�������܂��B
        // �N���X�W�J�Ȃǂ��o�āA���߂ăC���|�[�g���̈ꗗ���m�肷�邩��ł��B
        new BlancoCgImportCpp11SourceExpander().transformImport(fCgSourceFile,
                fSourceLines);

        return fSourceLines;
    }

    /**
     * �\�[�X�t�@�C���̃t�@�C���w�b�_�[���o�͏������܂��B
     */
    private void expandSourceFileHeader() {
        // �\�[�X�t�@�C���w�b�_�[�̃R�����g�� �X���b�V���Q���Ó��ƍl�����܂��B

        if (BlancoStringUtil.null2Blank(fCgSourceFile.getDescription())
                .length() > 0) {
            fSourceLines.add(BlancoCgLineUtil
                    .getSingleLineCommentPrefix(TARGET_LANG)
                    + fCgSourceFile.getDescription());
        } else {
            // �w�肪�����ꍇ�ɂ̓f�t�H���g�̃R�����g�𗘗p���܂��B
            for (String line : BlancoCgSourceFileUtil.getDefaultFileComment()) {
                fSourceLines.add(BlancoCgLineUtil
                        .getSingleLineCommentPrefix(TARGET_LANG)
                        + line);
            }
        }

        // ����h�L�������g�̒��ԕ��𐶐����܂��B
        new BlancoCgLangDocCpp11SourceExpander().transformLangDocBody(
                fCgSourceFile.getLangDoc(), fSourceLines, true);
    }
}
