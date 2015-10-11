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

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.BlancoCgTransformer;
import blanco.cg.transformer.cpp11.BlancoCgCpp11SourceTransformer;
import blanco.cg.transformer.cs.BlancoCgCsSourceTransformer;
import blanco.cg.transformer.delphi.BlancoCgDelphiSourceTransformer;
import blanco.cg.transformer.java.BlancoCgJavaSourceTransformer;
import blanco.cg.transformer.js.BlancoCgJsSourceTransformer;
import blanco.cg.transformer.php.BlancoCgPhpSourceTransformer;
import blanco.cg.transformer.python.BlancoCgPythonSourceTransformer;
import blanco.cg.transformer.ruby.BlancoCgRubySourceTransformer;
import blanco.cg.transformer.vb.BlancoCgVbSourceTransformer;

/**
 * BlancoCgTransformer���擾���邽�߂̃t�@�N�g���ł��B
 * 
 * BlancoCgTransformer�́AblancoCg�̃o�����[�I�u�W�F�N�g���\�[�X�R�[�h�ɕϊ����܂��B
 * ���݂̎d�l�ł́A�ϊ����Ƀo�����[�I�u�W�F�N�g�̓��e���X�V����邽�߁A�\�[�X�R�[�h�ϊ��͂P�x�������s�ł��Ȃ��_�ɂ����Ӊ������B
 * 
 * @author IGA Tosiki
 */
public class BlancoCgTransformerFactory {
    /**
     * �w�肳�ꂽ�v���O���~���O����ɑΉ������g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @param targetLang
     *            �擾�������g�����X�t�H�[�}�̃v���O���~���O����BBlancoCgSupportedLang�Ŏw�肵�܂��B
     * @return �\�[�X�R�[�h�ϊ��̂��߂̃g�����X�t�H�[�}�[�B
     */
    public static final BlancoCgTransformer getSourceTransformer(
            final int targetLang) {
        switch (targetLang) {
        case BlancoCgSupportedLang.JAVA:
            return BlancoCgTransformerFactory.getJavaSourceTransformer();
        case BlancoCgSupportedLang.CS:
            return BlancoCgTransformerFactory.getCsSourceTransformer();
        case BlancoCgSupportedLang.JS:
            return BlancoCgTransformerFactory.getJsSourceTransformer();
        case BlancoCgSupportedLang.VB:
            return BlancoCgTransformerFactory.getVbSourceTransformer();
        case BlancoCgSupportedLang.PHP:
            return BlancoCgTransformerFactory.getPhpSourceTransformer();
        case BlancoCgSupportedLang.RUBY:
            return BlancoCgTransformerFactory.getRubySourceTransformer();
        case BlancoCgSupportedLang.PYTHON:
            return BlancoCgTransformerFactory.getPythonSourceTransformer();
        case BlancoCgSupportedLang.DELPHI:
            return BlancoCgTransformerFactory.getDelphiSourceTransformer();
        case BlancoCgSupportedLang.CPP11:
            return BlancoCgTransformerFactory.getCpp11SourceTransformer();
        default:
            throw new IllegalArgumentException(
                    "BlancoCgTransformerFactory.getSourceTransformer: �Ή����Ȃ��v���O���~���O����("
                            + targetLang + ")���w�肳��܂����B");
        }
    }

    /**
     * Java�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return Java����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getJavaSourceTransformer() {
        return new BlancoCgJavaSourceTransformer();
    }

    /**
     * C#.NET�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return C#.NET����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getCsSourceTransformer() {
        return new BlancoCgCsSourceTransformer();
    }

    /**
     * JavaScript�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return JavaScript����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getJsSourceTransformer() {
        return new BlancoCgJsSourceTransformer();
    }

    /**
     * VB.NET�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return VB.NET����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getVbSourceTransformer() {
        return new BlancoCgVbSourceTransformer();
    }

    /**
     * PHP�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return PHP����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getPhpSourceTransformer() {
        return new BlancoCgPhpSourceTransformer();
    }

    /**
     * 
     * Ruby�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return Ruby����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getRubySourceTransformer() {
        return new BlancoCgRubySourceTransformer();
    }

    /**
     * 
     * Python�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return Python����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getPythonSourceTransformer() {
        return new BlancoCgPythonSourceTransformer();
    }
 
    /**
     * Delphi�\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return Delphi����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getDelphiSourceTransformer() {
        return new BlancoCgDelphiSourceTransformer();
    }

    /**
     * C++11 �\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[���擾���܂��B
     * 
     * @return C++11 ����\�[�X�R�[�h�𐶐�����g�����X�t�H�[�}�[�B
     */
    public static BlancoCgTransformer getCpp11SourceTransformer() {
        return new BlancoCgCpp11SourceTransformer();
    }
}