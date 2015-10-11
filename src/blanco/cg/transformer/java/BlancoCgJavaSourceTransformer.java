/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import blanco.cg.transformer.AbstractBlancoCgJavaStyleTransformer;
import blanco.cg.valueobject.BlancoCgSourceFile;

/**
 * blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̃G���g���|�C���g�ł��B
 * 
 * BlancoCgTransformerFactory���o�R���Đ������邱�Ƃ𐄏����܂��B<br>
 * ���̃g�����X�t�H�[�}�[�ł̓o�����[�I�u�W�F�N�g��Java�\�[�X�R�[�h�ւƕϊ����܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgJavaSourceTransformer extends
        AbstractBlancoCgJavaStyleTransformer {

    /**
     * �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g��Java�\�[�X�R�[�h�ɕϊ����ă��C�^�[�ɏo�͂��܂��B
     * 
     * ����API�ł̓p�b�P�[�W�\�����f�B���N�g���\���Ƃ͍l�����܂���B���̏����̒��ł̓��C�^�[�Ɍ����ďo�͂��邾���ł��B
     * 
     * @param argSourceFile
     *            �\�[�X�t�@�C���E�o�����[�I�u�W�F�N�g�B
     * @param argWriter
     *            �o�͐�̃��C�^�[�B
     * @throws ���o�͗�O�����������ꍇ
     *             �B
     */
    public void transform(final BlancoCgSourceFile argSourceFile,
            final BufferedWriter argWriter) throws IOException {
        if (argSourceFile == null) {
            throw new IllegalArgumentException("�\�[�X�t�@�C����null���^�����܂����B�������f���܂��B");
        }
        if (argWriter == null) {
            throw new IllegalArgumentException("�o�͐惉�C�^�[��null���^�����܂����B�������f���܂��B");
        }

        final List<java.lang.String> sourceLines = new BlancoCgSourceFileJavaSourceExpander()
                .transformSourceFile(argSourceFile);

        // �\�[�X�R�[�h�𐮌`���܂��B
        formatSource(sourceLines);

        // �\�[�X�R�[�h�����C�^�ւƏo�͂��܂��B
        source2Writer(sourceLines, argWriter);

        // �O�̂��߃t���b�V�������{�B
        argWriter.flush();
    }

    /**
     * �\�[�X�R�[�h�ɕt������g���q���擾���܂��B
     * 
     * @return �\�[�X�R�[�h�ɕt������g���q�B
     */
    protected String getSourceFileExt() {
        return ".java";
    }
}
