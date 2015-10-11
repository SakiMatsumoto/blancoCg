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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoFileUtil;
import blanco.commons.util.BlancoStringUtil;

/**
 * Delphi �X�^�C���̒��ۃg�����X�t�H�[�}�[�ł��B
 * 
 * @author YAMAMOTO Koji
 */
public abstract class AbstractBlancoCgDelphiStyleTransformer extends
        AbstractBlancoCgTransformer {
    /**
     * �f�o�b�O���[�h�œ��삳���邩�ǂ����B
     */
    private static final boolean IS_DEBUG = true;

    /**
     * �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g��Delphi�\�[�X�R�[�h�ɕϊ����ďo�͐�f�B���N�g���ɏo�͂��܂��B
     * 
     * ����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ��čl�����܂��B
     * 
     * @param argSourceFile
     *            �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B
     * @param outputDirectory
     *            �o�͐惋�[�g�f�B���N�g���B
     */
    public void transform(final BlancoCgSourceFile argSourceFile,
            final File outputDirectory) {
        if (argSourceFile == null) {
            throw new IllegalArgumentException("�\�[�X�t�@�C����null���^�����܂����B�������f���܂��B");
        }
        if (outputDirectory == null) {
            throw new IllegalArgumentException(
                    "�o�͐惋�[�g�f�B���N�g����null���^�����܂����B�������f���܂��B");
        }

        if (outputDirectory.exists() == false) {
            if (outputDirectory.mkdirs() == false) {
                throw new IllegalArgumentException("�o�͐惋�[�g�f�B���N�g��["
                        + outputDirectory.getAbsolutePath()
                        + "]�����݂��Ȃ������̂ō쐬���悤�Ƃ��܂������f�B���N�g���쐬�Ɏ��s���܂����B�������f���܂��B");
            }
        }
        if (outputDirectory.isDirectory() == false) {
            throw new IllegalArgumentException("�o�͐惋�[�g�f�B���N�g���Ƀf�B���N�g���ł͂Ȃ��t�@�C��["
                    + outputDirectory.getAbsolutePath() + "]���^�����܂����B�������f���܂��B");
        }

        if (argSourceFile.getName() == null) {
            // �t�@�C�������m�肵�Ă��Ȃ��̂ŁA�N���X���܂��̓C���^�t�F�[�X�����瓱�o���܂��B
            decideFilenameFromClassOrInterfaceName(argSourceFile);
        }

        try {
            // �p�b�P�[�W������f�B���N�g�����ւƕϊ��B
            String strSubdirectory = BlancoStringUtil.replaceAll(
                    BlancoStringUtil.null2Blank(argSourceFile.getPackage()),
                    '.', '/');
            if (strSubdirectory.length() > 0) {
                // �T�u�f�B���N�g�������݂���ꍇ�ɂ̂݃X���b�V����ǉ����܂��B
                strSubdirectory = "/" + strSubdirectory;
            }

            final File targetPackageDirectory = new File(outputDirectory
                    .getAbsolutePath()
                    + strSubdirectory);
            if (targetPackageDirectory.exists() == false) {
                if (targetPackageDirectory.mkdirs() == false) {
                    throw new IllegalArgumentException("�o�͐�̃p�b�P�[�W�f�B���N�g��["
                            + targetPackageDirectory.getAbsolutePath()
                            + "]�̐����Ɏ��s���܂����B");
                }
            }

            // �o�͐�̃t�@�C�����m�肵�܂��B
            final File fileTarget = new File(targetPackageDirectory
                    .getAbsolutePath()
                    + "/" + argSourceFile.getName() + getSourceFileExt());

            // ���ۂ̃\�[�X�R�[�h�o�͏������s���܂��B
            final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            // ������������\�[�X�R�[�h�̃G���R�[�f�B���O�w��@�\
            OutputStreamWriter streamWriter = null;
            if (BlancoStringUtil.null2Blank(argSourceFile.getEncoding())
                    .length() == 0) {
                streamWriter = new OutputStreamWriter(outStream);
            } else {
                streamWriter = new OutputStreamWriter(outStream, argSourceFile
                        .getEncoding());
            }

            final BufferedWriter writer = new BufferedWriter(streamWriter);
            try {
                transform(argSourceFile, writer);
                writer.flush();
                outStream.flush();

                switch (BlancoFileUtil.bytes2FileIfNecessary(outStream
                        .toByteArray(), fileTarget)) {
                case 0:
                    if (IS_DEBUG) {
                        // �f�o�b�O���̂݃X�L�b�v��W���o�́B
                        System.out.println(CMDLINE_PREFIX + "skip  : "
                                + fileTarget.getAbsolutePath());
                    }
                    break;
                case 1:
                    System.out.println(CMDLINE_PREFIX + "create: "
                            + fileTarget.getAbsolutePath());
                    break;
                case 2:
                    System.out.println(CMDLINE_PREFIX + "update: "
                            + fileTarget.getAbsolutePath());
                    break;
                }
            } finally {
                // ByteArrayOutputStream�̃C���X�^���X�� writer�̃N���[�Y�ɂ����
                // �X�g���[���`�F�C���̎d�g�ݏ� �����I�ɃN���[�Y����܂��B

                if (writer != null) {
                    writer.close();
                }
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("�\�[�X�R�[�h���o�͂���ߒ��ŗ�O���������܂����B"
                    + ex.toString());
        }
    }

    /**
     * �\�[�X�R�[�h�̃��X�g�𐮌`���܂��B
     * 
     * Delphi����p�̐��`���s���܂��B
     * 
     * �Ȃ��A���̏����̂Ȃ��� { �� } �͓��ʂȈӖ��������Ă��܂��B�s���R�����g�Ȃǂ�����Ɗ��҂��铮�삪�ł��܂���B<br>
     * TODO ���J�b�R�𕶖��ɕt�^����A�Ȃǂ̃t�H�[�}�b�g�Ȃǂ͖������ł��B
     * 
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    protected void formatSource(final List<java.lang.String> argSourceLines) {
        int sourceIndent = 0;
        boolean isInterface = false;
        boolean isImplementation = false;

        for (int index = 0; index < argSourceLines.size(); index++) {
            String strLine = argSourceLines.get(index);
            // �O��̋󔒂́A���炩���ߏ������܂��B
            strLine = strLine.trim();
            if (strLine.length() == 0) {
                // ��s�ł��B
            } else {
                boolean isBeginIndent = false;
                boolean isEndIndent = false;

                // �܂��͊J�n������̔�����s���܂��B
                // ���J�n������ƏI��������Ƃ͕ʌɔ��肷��K�v������܂��B
                if (strLine.startsWith("if ")) {
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                } else if (strLine.startsWith("for ")) {
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                } else if (strLine.startsWith("while ")) {
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                } else if (strLine.startsWith("begin")) {
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                } else if (strLine.startsWith("end")) {
                    // �u���b�N�I���ƌ��Ȃ��Ď��������܂��B
                    isEndIndent = true;
                } else if (strLine.startsWith("else")) {
                    // �u���b�N�I���ƌ��Ȃ��Ď��������܂��B
                    isEndIndent = true;
                } else if (strLine.equals("Next")
                        || strLine.startsWith("Next ")) {
                    // �u���b�N�I���ƌ��Ȃ��Ď��������܂��B
                    isEndIndent = true;
                } else if (strLine.indexOf("type") == 0
                        || strLine.indexOf("interface") == 0
                        || strLine.indexOf("implementation") == 0) {
                    // �u���b�N�I���ƌ��Ȃ��Ď��������܂��B
                    isBeginIndent = true;
                    isEndIndent = true;
                } else if (strLine.indexOf("unit ") >= 0
                        || strLine.indexOf("class(") >= 0
                        || strLine.indexOf("interface ") >= 0
                        || strLine.indexOf("implementation ") >= 0) {
                    // End����Ŕ��肵�Ă���̂��|�C���g�ł��B
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                } else if (strLine.equals("published")
                        || strLine.equals("public")
                        || strLine.equals("private")){
                    isBeginIndent = true;
                    isEndIndent = true;
                }

                // �r���ɋ��܂�ł��낤If�𔻒肵�܂��B
                if (strLine.indexOf(" if ") >= 0) {
                    // �u���b�N�J�n�ƌ��Ȃ��Ď�������\�񂵂܂��B
                    isBeginIndent = true;
                }

                if (isEndIndent) {
                    // �t���O���ɂ��A�C���f���g��𔽉f���܂��B
                    sourceIndent--;
                }

                // �C���f���g�����{���܂��B
                for (int indexIndent = 0; indexIndent < sourceIndent; indexIndent++) {
                    // 4�^�u�Ŏ��������܂��B
                    strLine = "    " + strLine;
                }
                if (isBeginIndent) {
                    sourceIndent++;
                }

                // �X�V��̍s�C���[�W�Ń��X�g���X�V���܂��B
                argSourceLines.set(index, strLine);
            }
        }
    }
}
