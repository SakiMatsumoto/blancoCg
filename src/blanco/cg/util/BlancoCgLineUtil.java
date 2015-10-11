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
 * blancoCg�̍s�Ɋւ��郆�[�e�B���e�B�ł��B
 * 
 * ���̃N���X�̓v���O���~���O����𒴂��ė��p����܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgLineUtil {
    /**
     * �P�s�R�����g�̊J�n��\����������擾���܂��B
     * 
     * �R�����g�̊J�n��\��������ƁA����ɑ����󔒂�߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return �R�����g�̊J�n��\��������B
     */
    public static final String getSingleLineCommentPrefix(
            final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.DELPHI:
            return "// ";
        case BlancoCgSupportedLang.VB:
            return "' ";
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
            return "# ";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgLineUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * �����񃊃e�������͂ޕ�������擾���܂��B
     * 
     * �o�͑Ώۂ̃v���O���~���O����ɉ����āA�_�u���N�I�[�g�܂��� �V���O���N�I�[�g��߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return �����񃊃e�������͂ޕ�����
     */
    public static final String getStringLiteralEnclosure(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.VB:
            return "\"";
        case BlancoCgSupportedLang.PHP:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
        case BlancoCgSupportedLang.DELPHI:
            return "'";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgLineUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * �������A������I�y���[�^���擾���܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return �������A������I�y���[�^�B
     */
    public static final String getStringConcatenationOperator(
            final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        case BlancoCgSupportedLang.CS:
        case BlancoCgSupportedLang.JS:
        case BlancoCgSupportedLang.VB:
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
        case BlancoCgSupportedLang.DELPHI:
            return "+";
        case BlancoCgSupportedLang.PHP:
            return ".";
        default:
            throw new IllegalArgumentException(
                    "BlancoCgLineUtil: �T�|�[�g���Ȃ��v���O���~���O����(" + argTargetLang
                            + ")���^�����܂����B");
        }
    }

    /**
     * �ϐ��̃v���t�B�b�N�X���擾���܂��B
     * 
     * ���@�I�ɕϐ��Ƀv���t�B�b�N�X���K�v�ȏꍇ�A���̕������߂��܂��B�v���t�B�b�N�X���K�v�Ȃ�����ł́A����0�̕������߂��܂��B
     * PHP�̏ꍇ�A$��߂��܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return ���[�J���ϐ��̃v���t�B�b�N�X
     */
    public static final String getVariablePrefix(final int argTargetLang) {
        switch (argTargetLang) {
        case BlancoCgSupportedLang.PHP:
            return "$";
        default:
            return "";
        }
    }

    /**
     * �ϐ��錾��\����������擾���܂��B
     * 
     * �ϐ��錾�P�s��߂��܂��B�s�̏I�[��\�������iJava�̏ꍇ�A�Z�~�R�����j�� �܂܂�܂���B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argVariableName
     *            �ϐ����B
     * @param argTypeShortName
     *            �Z���^���B
     * @param argInitialValue
     *            �����l�Bnull�܂��͒���0�̏ꍇ�A�ϐ��̖����I�ȏ������͍s���܂���B
     * @return �ϐ��錾��\��������B
     */
    public static final String getVariableDeclaration(final int argTargetLang,
            final String argVariableName, final String argTypeShortName,
            final String argInitialValue) {
        String result = "";
        switch (argTargetLang) {
        case BlancoCgSupportedLang.JAVA:
        default:
            result = argTypeShortName + " " + argVariableName;
            break;
        case BlancoCgSupportedLang.CS:
            result = argTypeShortName + " " + argVariableName;
            break;
        case BlancoCgSupportedLang.JS:
            // �^���͗��p���܂���B
            result = "var " + argVariableName;
            break;
        case BlancoCgSupportedLang.VB:
            result = "Dim " + argVariableName + " As " + argTypeShortName;
            break;
        case BlancoCgSupportedLang.PHP:
            // �^���͗��p���܂���B
            result = BlancoCgLineUtil.getVariablePrefix(argTargetLang)
                    + argVariableName;
            break;
        case BlancoCgSupportedLang.RUBY:
        case BlancoCgSupportedLang.PYTHON:
            // �^���͗��p���܂���B
            result = argVariableName;
            break;
        }

        if (BlancoStringUtil.null2Blank(argInitialValue).length() > 0) {
            result += " = " + argInitialValue;
        }
        return result;
    }

    // �����ȍ~�̓t�@�T�[�h���\�b�h�B

    /**
     * if���̊J�n������\����������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getIfBegin(int, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr
     *            �������B
     * @return if���̊J�n������\��������
     */
    public static final String getIfBegin(final int argTargetLang,
            final String argExpr) {
        return BlancoCgStatementUtil.getIfBegin(argTargetLang, argExpr);
    }

    /**
     * if���̏I��������\����������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getIfEnd(int)}�ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return if���̏I��������\��������
     */
    public static final String getIfEnd(final int argTargetLang) {
        return BlancoCgStatementUtil.getIfEnd(argTargetLang);
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * Java, C#, JavaScript, PHP�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginJava(int, java.lang.String, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr1
     *            �����������B
     * @param argExpr2
     *            �p�������B
     * @param argExpr3
     *            ���[�v�̂ǎ��{���鏈���B
     * @return for���̊J�n������\��������
     */
    public static final String getForBeginJava(final int argTargetLang,
            final String argExpr1, final String argExpr2, final String argExpr3) {
        return BlancoCgStatementUtil.getForBeginJava(argTargetLang, argExpr1,
                argExpr2, argExpr3);
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * VB.NET�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginVb(int, java.lang.String, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCounter
     *            �\���B�u��: i As Integer = 1�v
     * @param argTo
     *            �I���ƂȂ邵�����l (�����ł͂���܂���)�B�u��: 10�v
     * @return for���̊J�n������\��������B
     */
    public static final String getForBeginVb(final int argTargetLang,
            final String argCounter, final String argTo) {
        return BlancoCgStatementUtil.getForBeginVb(argTargetLang, argCounter,
                argTo, null);
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * VB.NET�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginVb(int, java.lang.String, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCounter
     *            �\���B�u��: i As Integer = 1�v
     * @param argTo
     *            �I���ƂȂ邵�����l (�����ł͂���܂���)�B�u��: 10�v
     * @param argStep
     *            Step�ɗ��p�����l�B�u��: 2�v�Bnull�̏ꍇ�ɂ� Step�͏ȗ�����܂��B
     * @return for���̊J�n�����̕�����
     */
    public static final String getForBeginVb(final int argTargetLang,
            final String argCounter, final String argTo, final String argStep) {
        return BlancoCgStatementUtil.getForBeginVb(argTargetLang, argCounter,
                argTo, argStep);
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginRuby(int, java.lang.String, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
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
    public static final String getForBeginRuby(final int argTargetLang,
            final String argCounter, final String argFrom, final String argTo) {
        return BlancoCgStatementUtil.getForBeginRuby(argTargetLang, argCounter,
                argFrom, argTo);
    }

/**
     * for���̊J�n������\����������擾���܂��B
     * 
     * Delphi�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginDelphi(int , java.lang.String,java.lang.String, java.lang.String)
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argItem
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�̌��ݒl�B
     * @param argItems
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�B
     * @return for���̊J�n������\��������B
     */
    public static final String getForBeginDelphi(final int argTargetLang,
            final String argCounter, final String argFrom, final String argTo) {
        return BlancoCgStatementUtil.getForBeginDelphi(argTargetLang,
                argCounter, argFrom, argTo);
    }

    /**
     * for���̊J�n������\����������擾���܂��B
     * 
     * Python�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getForBeginPython(int, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argItem
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�̌��ݒl�B
     * @param argItems
     *            ���[�v�ΏۂƂȂ�I�u�W�F�N�g�B
     * @return for���̊J�n������\��������B
     */
    public static final String getForBeginPython(final int argTargetLang,
            final String argItem, final String argItems) {
        return BlancoCgStatementUtil.getForBeginPython(argTargetLang, argItem,
                argItems);
    }

    /**
     * each�u���b�N�̊J�n������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getEachBeginRuby(int, java.lang.String, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argObject
     *            each���\�b�h���Ăяo���ΏۂƂȂ�I�u�W�F�N�g�B
     * @param argVariable
     *            each���\�b�h�̌��ݒl�B
     * @return each�u���b�N�̊J�n������\��������B
     */
    public static final String getEachBeginRuby(final int argTargetLang,
            final String argObject, final String argVariable) {
        return BlancoCgStatementUtil.getEachBeginRuby(argTargetLang, argObject,
                argVariable);
    }

    /**
     * each�u���b�N�̏I��������\����������擾���܂��B
     * 
     * Ruby�ɑΉ����Ă��܂��B ���ۂ̏����́A{@link BlancoCgStatementUtil#getEachEnd(int)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return each�u���b�N�̏I��������\��������B
     */
    public static final String getEachEnd(final int argTargetLang) {
        return BlancoCgStatementUtil.getEachEnd(argTargetLang);
    }

    /**
     * for���̏I��������\����������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getForEnd(int)}�ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return for���̏I��������\��������B
     */
    public static final String getForEnd(final int argTargetLang) {
        return BlancoCgStatementUtil.getForEnd(argTargetLang);
    }

    /**
     * for���𔲂��镶��\�킷��������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getForExit(int)}�ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return break�܂��� Exit For���߂�܂��B
     */
    public static final String getForExit(final int argTargetLang) {
        return BlancoCgStatementUtil.getForExit(argTargetLang);
    }

    /**
     * ���̏I���������������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getTerminator(int)}�ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @return ���̏I�������������B
     */
    public static final String getTerminator(final int argTargetLang) {
        return BlancoCgStatementUtil.getTerminator(argTargetLang);
    }

    /**
     * while���̊J�n������\�킷��������擾���܂��B
     * 
     * Ruby, Python�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getWhileBeginRuby(int, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCon
     *            �������B
     * @return while���̊J�n������\�킷������B
     */
    public static final String getWhileBeginRuby(final int argTargetLang,
            final String argCon) {
        return BlancoCgStatementUtil.getWhileBeginRuby(argTargetLang, argCon);
    }

    /**
     * while���̊J�n������\�킷��������擾���܂��B
     * 
     * Delphi�ɑΉ����Ă��܂��B ���ۂ̏����́A
     * {@link BlancoCgStatementUtil#getWhileBeginDelphi(int, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argCon
     *            �������B
     * @return while���̊J�n������\�킷������B
     */
    public static final String getWhileBeginDelphi(final int argTargetLang,
            final String argCon) {
        return BlancoCgStatementUtil.getWhileBeginRuby(argTargetLang, argCon);
    }

    /**
     * return����\����������擾���܂��B
     * 
     * ���ۂ̏����́A{@link BlancoCgStatementUtil#getReturn(int, java.lang.String)}
     * �ɈϏ�����܂��B
     * 
     * @param argTargetLang
     *            �o�͑Ώۂ̃v���O���~���O����B
     * @param argExpr
     *            return����鎮�B
     * @return return����\��������B
     */
    public static final String getReturn(final int argTargetLang,
            final String argExpr) {
        return BlancoCgStatementUtil.getReturn(argTargetLang, argExpr);
    }
}