/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg;

/**
 * blancoCg���Ή����錾��̈ꗗ��ێ����܂��B
 */
public class BlancoCgSupportedLang {
    /**
     * No.1 ����:Java����B
     */
    public static final int JAVA = 1;

    /**
     * No.2 ����:C#.NET����B
     */
    public static final int CS = 2;

    /**
     * No.3 ����:JavaScript����B
     */
    public static final int JS = 3;

    /**
     * No.4 ����:VB.NET����B
     */
    public static final int VB = 4;

    /**
     * No.5 ����:PHP����B
     */
    public static final int PHP = 5;

    /**
     * No.6 ����:Ruby����B
     */
    public static final int RUBY = 6;

    /**
     * No.7 ����:Python����B
     */
    public static final int PYTHON = 7;

    /**
     * No.8 ����:Delphi����B
     */
    public static final int DELPHI = 8;

    /**
     * No.9 ����:C++11����B
     */
    public static final int CPP11 = 9;

    /**
     * ����`�B������O���[�v�ȊO�̕�����܂��͒萔������`�̂��́B
     */
    public static final int NOT_DEFINED = -1;

    /**
     * ������O���[�v�Ɋ܂܂�镶����ł��邩�ǂ����𔻒肵�܂��B
     *
     * @param argCheck �`�F�b�N���s������������B
     * @return ������O���[�v�Ɋ܂܂�Ă����ture�B�O���[�v�Ɋ܂܂�Ȃ�������ł����false�B
     */
    public boolean match(final String argCheck) {
        // No.1
        // ����:Java����B
        if ("java".equals(argCheck)) {
            return true;
        }
        // No.2
        // ����:C#.NET����B
        if ("cs".equals(argCheck)) {
            return true;
        }
        // No.3
        // ����:JavaScript����B
        if ("js".equals(argCheck)) {
            return true;
        }
        // No.4
        // ����:VB.NET����B
        if ("vb".equals(argCheck)) {
            return true;
        }
        // No.5
        // ����:PHP����B
        if ("php".equals(argCheck)) {
            return true;
        }
        // No.6
        // ����:Ruby����B
        if ("ruby".equals(argCheck)) {
            return true;
        }
        // No.7
        // ����:Python����B
        if ("python".equals(argCheck)) {
            return true;
        }
        // No.8
        // ����:Delphi����B
        if ("delphi".equals(argCheck)) {
            return true;
        }
        // No.9
        // ����:C++11����B
        if ("cpp11".equals(argCheck)) {
            return true;
        }
        return false;
    }

    /**
     * ������O���[�v�Ɋ܂܂�镶����ł��邩�ǂ������A�啶������������ʂ������肵�܂��B
     *
     * @param argCheck �`�F�b�N���s������������B
     * @return ������O���[�v�Ɋ܂܂�Ă����ture�B�O���[�v�Ɋ܂܂�Ȃ�������ł����false�B
     */
    public boolean matchIgnoreCase(final String argCheck) {
        // No.1
        // ����:Java����B
        if ("java".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.2
        // ����:C#.NET����B
        if ("cs".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.3
        // ����:JavaScript����B
        if ("js".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.4
        // ����:VB.NET����B
        if ("vb".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.5
        // ����:PHP����B
        if ("php".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.6
        // ����:Ruby����B
        if ("ruby".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.7
        // ����:Python����B
        if ("python".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.8
        // ����:Delphi����B
        if ("delphi".equalsIgnoreCase(argCheck)) {
            return true;
        }
        // No.9
        // ����:C++11����B
        if ("cpp11".equalsIgnoreCase(argCheck)) {
            return true;
        }
        return false;
    }

    /**
     * �����񂩂�萔�ɕϊ����܂��B
     *
     * �萔������`�̏ꍇ�� �^����ꂽ�����񂪕�����O���[�v�O�̏ꍇ�ɂ� NOT_DEFINED ��߂��܂��B
     *
     * @param argCheck �ϊ����s������������B
     * @return �萔�ɕϊ���̒l�B
     */
    public int convertToInt(final String argCheck) {
        // No.1
        // ����:Java����B
        if ("java".equals(argCheck)) {
            return JAVA;
        }
        // No.2
        // ����:C#.NET����B
        if ("cs".equals(argCheck)) {
            return CS;
        }
        // No.3
        // ����:JavaScript����B
        if ("js".equals(argCheck)) {
            return JS;
        }
        // No.4
        // ����:VB.NET����B
        if ("vb".equals(argCheck)) {
            return VB;
        }
        // No.5
        // ����:PHP����B
        if ("php".equals(argCheck)) {
            return PHP;
        }
        // No.6
        // ����:Ruby����B
        if ("ruby".equals(argCheck)) {
            return RUBY;
        }
        // No.7
        // ����:Python����B
        if ("python".equals(argCheck)) {
            return PYTHON;
        }
        // No.8
        // ����:Delphi����B
        if ("delphi".equals(argCheck)) {
            return DELPHI;
        }
        // No.9
        // ����:C++11����B
        if ("cpp11".equals(argCheck)) {
            return CPP11;
        }

        // �Y������萔��������܂���ł����B
        return NOT_DEFINED;
    }

    /**
     * �萔���當����ɕϊ����܂��B
     *
     * �萔�ƑΉ��Â�������ɕϊ����܂��B
     *
     * @param argCheck �ϊ����s�����������萔�B
     * @return ������ɕϊ���̒l�BNOT_DEFINED�̏ꍇ�ɂ͒���0�̕�����B
     */
    public String convertToString(final int argCheck) {
        // No.1
        // ����:Java����B
        if (argCheck == JAVA) {
            return "java";
        }
        // No.2
        // ����:C#.NET����B
        if (argCheck == CS) {
            return "cs";
        }
        // No.3
        // ����:JavaScript����B
        if (argCheck == JS) {
            return "js";
        }
        // No.4
        // ����:VB.NET����B
        if (argCheck == VB) {
            return "vb";
        }
        // No.5
        // ����:PHP����B
        if (argCheck == PHP) {
            return "php";
        }
        // No.6
        // ����:Ruby����B
        if (argCheck == RUBY) {
            return "ruby";
        }
        // No.7
        // ����:Python����B
        if (argCheck == PYTHON) {
            return "python";
        }
        // No.8
        // ����:Delphi����B
        if (argCheck == DELPHI) {
            return "delphi";
        }
        // No.9
        // ����:C++11����B
        if (argCheck == CPP11) {
            return "cpp11";
        }
        // ����`�B
        if (argCheck == NOT_DEFINED) {
            return "";
        }

        // ������ɂ��Y�����܂���ł����B
        throw new IllegalArgumentException("�^����ꂽ�l(" + argCheck + ")�͕�����O���[�v[BlancoCgSupportedLang]�ł͒�`����Ȃ��l�ł��B");
    }
}
