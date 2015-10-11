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

import blanco.cg.BlancoCgSupportedLang;
import blanco.commons.util.BlancoStringUtil;

/**
 * blancoCg�̃X�e�[�g�����g�Ɋւ��郆�[�e�B���e�B�ł��B
 * 
 * ���̃N���X�̓v���O���~���O����𒴂��ė��p����܂��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgStatementUtil {
    /**
     * if���̊J�n������\����������擾���܂��B
     * 
     * �u���b�N�J�n��\��������iJava�̏ꍇ�A�����ʁj���܂݂܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr
     *            �������B
     * @return if���̊J�n������\��������B
     */
    public static final String getIfBegin(final int argTargetLang,
            final String argExpr) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
            return "if (" + argExpr + ") {";
        case BlancoCgSupportedLang.VB:
            return "If (" + argExpr + ") Then";
        case BlancoCgSupportedLang.RUBY:
            return "if " + argExpr;
        case BlancoCgSupportedLang.PYTHON:
            return "if " + argExpr + ":";
        case BlancoCgSupportedLang.DELPHI:
            return "if " + argExpr + " then begin";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * if���̏I��������\����������擾���܂��B
     * 
     * Python�ł́Aif���̏I�������͕��@�I�ɕK�v����܂��񂪁A �����������ꂽ�\�[�X�R�[�h�𐮌`���邽�߂ɁA�R�����g������ ��߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return if���̏I��������\��������B
     */
    public static final String getIfEnd(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
            return "}";
        case BlancoCgSupportedLang.VB:
            return "End If";
        case BlancoCgSupportedLang.RUBY:
            return "end";
        case BlancoCgSupportedLang.DELPHI:
            return "end;";
        case BlancoCgSupportedLang.PYTHON:
            return "#end";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * Java, C#, JavaScript, PHP�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr1
     *            �����������B
     * @param argExpr2
     *            �p�������B
     * @param argExpr3
     *            ���[�v�̂ǎ��{���鏈���B
     * @return for���̊J�n������\��������B
     */
    public static final String getForBeginJava(final int argTargetLang,
            final String argExpr1, final String argExpr2, final String argExpr3) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
            return "for (" + argExpr1 + "; " + argExpr2 + "; " + argExpr3
                    + ") {";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getForBeginJava: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * VB.NET�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCounter
     *            ���[�v�J�E���^�B�u��: i As Integer = 1�v
     * @param argTo
     *            �I���ƂȂ邵�����l (�����ł͂���܂���)�B�u��: 10�v
     * @param argStep
     *            Step�ɗ��p�����l�B�u��: 2�v�Bnull�̏ꍇ�ɂ� Step�͏ȗ�����܂��B
     * @return for���̊J�n������\��������B
     */
    public static final String getForBeginVb(final int argTargetLang,
            final String argCounter, final String argTo, final String argStep) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.VB:
            break;
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getForBeginVb: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }

        String argLine = "For " + argCounter + " To " + argTo;
        if (BlancoStringUtil.null2Blank(argStep).length() > 0) {
            argLine += " Step " + argStep;
        }

        return argLine;
    }

    /**
     * 
     * for���̊J�n������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCounter
     *            ���[�v�J�E���^�B
     * @param argFrom
     *            �J�n�l (�����ł͂���܂���)�B�u��: 1�v
     * @param argTo
     *            �I���l (�����ł͂���܂���)�B�u��: 10�v
     * @return for���̊J�n������\��������B
     */
    public static String getForBeginRuby(int argTargetLang, String argCounter,
            String argFrom, String argTo) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.RUBY:
            break;
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getForBeginRuby: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }

        String argLine = "for " + argCounter + " in " + argFrom + ".." + argTo;

        return argLine;
    }

    /**
     * 
     * for���̊J�n������\����������擾���܂��B
     * 
     * Python�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argItem
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�̌��ݒl�B
     * @param argItems
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�B
     * @return for���̊J�n������\��������B
     */
    public static String getForBeginPython(int argTargetLang, String argItem,
            String argItems) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.PYTHON:
            break;
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getForBeginRuby: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }

        String argLine = "for " + argItem + " in " + argItems + ":";

        return argLine;
    }

    /**
     * 
     * for���̊J�n������\����������擾���܂��B
     * 
     * Delphi�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argItem
     *            ���[�v�J�E���^�B
     * @param argStart
     *            ���[�v�̊J�n�l�B
     * @param argEnd
     *            ���[�v�̏I���l�B
     * @return for���̊J�n������\��������B
     */
    public static String getForBeginDelphi(int argTargetLang,
            final String argCounter, final String argFrom, final String argTo) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.DELPHI:
            break;
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getForBeginRuby: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }

        String argLine = "for " + argCounter + " := " + argFrom + " to "
                + argTo + " do begin";

        return argLine;
    }

    /**
     * for���̏I��������\����������擾���܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return for���̏I��������\��������B
     */
    public static final String getForEnd(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
            return "}";
        case BlancoCgSupportedLang.VB:
            // ���[�v�ϐ��͏ȗ����܂��B
            return "Next";
        case BlancoCgSupportedLang.RUBY:
            return "end";
        case BlancoCgSupportedLang.PYTHON:
            return "#end";
        case BlancoCgSupportedLang.DELPHI:
            return "end;";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * for���𔲂��镶��\�킷��������擾���܂��B
     * 
     * ���̏I������������(Java�̏ꍇ�A�Z�~�R����)�͊܂݂܂���B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return for���𔲂��镶��\�킷������B
     */
    public static final String getForExit(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
        case BlancoCgSupportedLang.DELPHI:
            return "break";
        case BlancoCgSupportedLang.VB:
            return "Exit For";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * while���̊J�n������\�킷��������擾���܂��B
     * 
     * Ruby, Python�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCon
     *            �������B
     * @return while���̊J�n������\�킷������B
     */
    public static String getWhileBeginRuby(int argTargetLang, String argCon) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.RUBY:
            return "while " + argCon;
        case BlancoCgSupportedLang.PYTHON:
            return "while " + argCon + ":";
        case BlancoCgSupportedLang.DELPHI:
            return "while " + argCon + " do begin";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getWhileBeginRuby: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }
    }

    /**
     * while���̊J�n������\�킷��������擾���܂��B
     * 
     * Delphi�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCon
     *            �������B
     * @return while���̊J�n������\�킷������B
     */
    public static String getWhileBeginDelphi(int argTargetLang, String argCon) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.DELPHI:
            return "while " + argCon + " do begin";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil.getWhileBeginRuby: �T�|�[�g���Ȃ��v���O���~���O����("
                            + argTargetLang + ")���^�����܂����B");
        }
    }

    /**
     * while���̏I��������\����������擾���܂��B
     * 
     * Ruby, Python�ɑΉ����Ă��܂��B Python�ł́Awhile���̏I�������͕��@�I�ɕK�v����܂��񂪁A
     * �����������ꂽ�\�[�X�R�[�h�𐮌`���邽�߂ɁA�R�����g������ ��߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return while���̏I��������\��������B
     */
    public static final String getWhileEnd(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.RUBY:
            return "end";
        case BlancoCgSupportedLang.PYTHON:
            return "#end";
        case BlancoCgSupportedLang.DELPHI:
            return "end;";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * each�u���b�N�̊J�n������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argObject
     *            each���\�b�h���Ăяo���ΏۂƂȂ�I�u�W�F�N�g�B
     * @param argVariable
     *            each���\�b�h�̌��ݒl�B
     * @return each�u���b�N�̊J�n������\��������B
     */
    public static String getEachBeginRuby(int argTargetLang, String argObject,
            String argVariable) {
        // argArray.each do |arg|
        switch (argTargetLang) {
        case BlancoCgSupportedLang.RUBY:
            return argObject + ".each do |" + argVariable + "|";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * each�u���b�N�̏I��������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return each�u���b�N�̏I��������\��������B
     */
    public static final String getEachEnd(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.RUBY:
            return "end";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * ���̏I���������������擾���܂��B
     * 
     * Java�ȂǑ����̌���ł́A�Z�~�R������߂��܂��B Ruby�ȂǕ��̏I���������������K�v�Ȃ�����ł́A����0�̕������ �߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return ���̏I�������������B
     */
    public static final String getTerminator(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.DELPHI:
            return ";";
        case BlancoCgSupportedLang.VB:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
            return "";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * return����\����������擾���܂��B
     * 
     * ���̏I������������(Java�̏ꍇ�A�Z�~�R����)�͊܂݂܂���B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr
     *            return����鎮�B
     * @return return����\��������B
     */
    public static final String getReturn(final int argTargetLang,
            final String argExpr) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
        case BlancoCgSupportedLang.DELPHI:
            // ���ӁB�Z�~�R�����͊܂݂܂���B
            return "return " + argExpr;
        case BlancoCgSupportedLang.VB:
            // ���[�v�ϐ��͏ȗ����܂��B
            return "Return " + argExpr;
        default:
            throw new IllegalArgumentException(
                    "BlancoCgStatementUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

}