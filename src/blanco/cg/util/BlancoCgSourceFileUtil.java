/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import blanco.cg.resourcebundle.BlancoCgResourceBundle;

/**
 * blancoCg �̃\�[�X�t�@�C���p�̃��[�e�B���e�B�E�N���X�B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgSourceFileUtil {
    /**
     * ���\�[�X�o���h���E���b�Z�[�W���������߂̃N���X�B
     */
    protected static final BlancoCgResourceBundle fBundle = new BlancoCgResourceBundle();

    /**
     * �f�t�H���g�̃t�@�C���E�R�����g�̎擾�B
     * 
     * <UL>
     * <LI>���΃p�X meta/program/fileheader.txt ������΁A�����D�旘�p���܂��B(UTF-8
     * �ŋL�ڂ���Ă���K�v������܂�)
     * <LI>���\�[�X�o���h���̎w��𗘗p���܂��B
     * </UL>
     * 
     * @return �f�t�H���g�̃t�@�C���E�R�����g�̔z��B
     */
    public static List<String> getDefaultFileComment() {
        final List<String> result = new ArrayList<String>();
        try {
            final File file = new File(fBundle.getFileHeaderPath());
            if (file.exists() == true && file.isFile() && file.canRead()) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(
                            new FileInputStream(file), "UTF-8"));
                    for (;;) {
                        final String line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        result.add(line);
                    }
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.size() == 0) {
            result.add(fBundle.getDefaultFileComment());
        }

        return result;
    }
}
