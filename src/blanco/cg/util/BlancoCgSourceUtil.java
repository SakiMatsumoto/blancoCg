/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import blanco.cg.BlancoCgSupportedLang;
import blanco.commons.util.BlancoJavaSourceUtil;
import blanco.commons.util.BlancoPhpSourceUtil;
import blanco.commons.util.BlancoVbSourceUtil;

/**
 * blancoCg�̃\�[�X�R�[�h�֘A���[�e�B���e�B�ł��B
 * 
 * ���̃N���X�̓v���O���~���O����𒴂��ė��p����܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgSourceUtil {
    /**
     * �^����ꂽ��������\�[�X�R�[�h������Ƃ��ďo�͂�����̂Ƃ��ăG�X�P�[�v�������܂��B
     * 
     * ��/�o�b�N�X���b�V���̃G�X�P�[�v����щ��s�R�[�h�̃G�X�P�[�v���s���܂��B<br>
     * ����ȊO�̏����͍s���܂���B���Ƃ��΃C���W�F�N�V�����U���Ȃǂւ̑ϐ��́A���̃��\�b�h�͈����܂���B
     * 
     * @param targetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param originalString
     *            ���͕�����B
     * @return �G�X�P�[�v�������s��ꂽ��̕�����B
     */
    public static String escapeStringAsSource(final int targetLang,
            final String originalString) {
        switch (targetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
            return BlancoJavaSourceUtil
                    .escapeStringAsJavaSource(originalString);
        case BlancoCgSupportedLang.VB:
            return BlancoVbSourceUtil.escapeStringAsVbSource(originalString);
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.RUBY: // TODO �Ó����̊m�F
        case BlancoCgSupportedLang.PYTHON: // TODO �Ó����̊m�F
            return BlancoPhpSourceUtil.escapeStringAsPhpSource(originalString);
        case BlancoCgSupportedLang.DELPHI: // TODO �Ó����̊m�F
            return escapeStringAsDelphiSource(originalString);
        default:
            throw new IllegalArgumentException(
                    "BlancoCgSourceUtil.escapeAsSourceString �ɃT�|�[�g����Ȃ�����("
                            + targetLang + ")�������Ƃ��ė^�����܂����B");
        }
    }

    /**
     * �^����ꂽ�����������h�L�������g������Ƃ��Ĉ������Ƃ��ł���悤�� �G�X�P�[�v�������܂��B
     * 
     * JavaDoc������Ƃ��ăG�X�P�[�v���s���܂��B HTML�Ƃ��ẴG�X�P�[�v�Ɠ����̏������s���܂��B�������h���G�X�P�[�v����܂��B
     * 
     * @param targetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param originalString
     *            ���͕�����
     * @return �G�X�P�[�v�������s��ꂽ��̕�����B
     */
    public static final String escapeStringAsLangDoc(final int targetLang,
            final String originalString) {
        switch (targetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.VB:
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
        case BlancoCgSupportedLang.DELPHI:
            return BlancoJavaSourceUtil.escapeStringAsJavaDoc(originalString);
        default:
            throw new IllegalArgumentException(
                    "BlancoCgSourceUtil.escapeStringAsLangDoc �ɃT�|�[�g����Ȃ�����("
                            + targetLang + ")�������Ƃ��ė^�����܂����B");
        }
    }
    
    /**
     * �^����ꂽ�������Delphi�\�[�X�R�[�h������Ƃ��ďo�͂��邽�߂̃G�X�P�[�v���������܂��B
     * 
     * ��/�o�b�N�X���b�V���̃G�X�P�[�v����щ��s�R�[�h�̃G�X�P�[�v���s���܂��B<br>
     * ����ȊO�̏����͍s���܂���B���Ƃ��΃C���W�F�N�V�����U���Ȃǂւ̑ϐ��́A���̃��\�b�h�͈����܂���B
     * 
     * @param originalString
     *            ���͕�����
     * @return �G�X�P�[�v�������s��ꂽ��̕�����
     */
    private static final String escapeStringAsDelphiSource(
            final String originalString) {
        if (originalString == null) {
            throw new IllegalArgumentException(
                    "BlancoCgSourceUtil.escapeStringAsDelphiSource�œ��͈ᔽ�������B���̃��\�b�h��null���p�����[�^�Ƃ��ė^�����܂����Bnull�ȊO�̒l����͂��Ă��������B");
        }

        final StringReader reader = new StringReader(originalString);
        final StringWriter writer = new StringWriter();
        try {
            for (;;) {
                final int iRead = reader.read();
                if (iRead < 0) {
                    break;
                }
                switch (iRead) {
                // Delphi����ł́A�o�b�N�X���b�V�����G�X�P�[�v����K�v������܂���B
//                case '\\':
//                    writer.write("\\");
//                    break;
                case '\n':
                    writer.write("\\n");
                    break;
                case '\'':
                    writer.write("\'\'");
                    break;
                default:
                    writer.write((char) iRead);
                    break;
                }
            }
            writer.flush();
        } catch (IOException e) {
            // �����ɓ����Ă��邱�Ƃ́A���肦�܂���B
            e.printStackTrace();
        }
        return writer.toString();
    }

}