/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.cg;

import java.io.File;

/**
 * blancoCg�̊e��N���X�������������邽�߂̃G���g���|�C���g�E�N���X�ł��B
 * 
 * �\�[�X�R�[�h�����������C�u���� blancoCg ���̂��̂̈ꕔ�������������܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgCg {
    /**
     * blancoCg�̊e��N���X�������������邽�߂̃G���g���|�C���g�B
     * 
     * @param args
     *            �N�������B���������̏����ł͖�������܂��B
     */
    public static final void main(final String[] args) {
        final File targetDirectory = new File("blanco/main");

        new BlancoCgTransformerCg().process(targetDirectory);
    }
}
