/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.swift;

import java.util.List;

import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgInterface;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.cg.valueobject.BlancoCgType;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgInterfaceをソースコードに展開します。
 * 
 * このクラスはblancoCgのバリューオブジェクトからソースコードを自動生成するトランスフォーマーの個別の展開機能です。
 * 
 * @author IGA Tosiki
 */
class BlancoCgInterfaceSwiftSourceExpander {

    /**
     * ここでinterfaceを展開します。
     * 
     * C#.NETには Java言語と同様なインタフェースが存在します。
     * 
     * @param cgInterface
     *            処理対象となるインタフェース。
     * @param argSourceLines
     *            ソースコード。
     */
    public void transformInterface(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        // インタフェースの場合には Java言語同様にフィールドやメソッドからpublicが除外されます。

        // 最初にインタフェース情報をLangDocに展開。
        if (cgInterface.getLangDoc() == null) {
            // LangDoc未指定の場合にはこちら側でインスタンスを生成。
            cgInterface.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgInterface.getLangDoc().getTitle() == null) {
            cgInterface.getLangDoc().setTitle(cgInterface.getDescription());
        }

        // 次に LangDocをソースコード形式に展開。
        new BlancoCgLangDocSwiftSourceExpander().transformLangDoc(cgInterface
                .getLangDoc(), argSourceLines);

        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgInterface.getAccess()).length() > 0) {
            buf.append(cgInterface.getAccess() + " ");
        }
        // staticやfinalは展開しません。
        buf.append("interface " + cgInterface.getName());

        // ここで親クラスを展開。
        expandExtendClassList(cgInterface, buf);

        // ※ポイント: 親インタフェース展開は interfaceには存在しません。

        argSourceLines.add(buf.toString());

        argSourceLines.add("{");

        // ここでフィールドを展開。
        expandFieldList(cgInterface, argSourceFile, argSourceLines);

        // ここでメソッドを展開。
        expandMethodList(cgInterface, argSourceFile, argSourceLines);

        argSourceLines.add("}");
    }

    /**
     * 親クラスを展開します。
     * 
     * @param cgClass
     * @param buf
     */
    private void expandExtendClassList(final BlancoCgInterface cgClass,
            final StringBuffer buf) {
        for (int index = 0; index < cgClass.getExtendClassList().size(); index++) {
            final BlancoCgType type = cgClass.getExtendClassList().get(index);

            if (index == 0) {
                buf.append(" : "
                        + BlancoCgTypeSwiftSourceExpander.toTypeString(type));
            } else {
                // TODO C#.NETで継承が一度きりという制限があるかどうか確認すること。
                buf.append(", "
                        + BlancoCgTypeSwiftSourceExpander.toTypeString(type));
            }
        }
    }

    /**
     * 含まれる各々のフィールドを展開します。
     * 
     * @param cgInterface
     * @param argSourceFile
     * @param argSourceLines
     */
    private void expandFieldList(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgInterface.getFieldList() == null) {
            // フィールドのリストにnullが与えられました。
            // かならずフィールドのリストにはListをセットしてください。
            throw new IllegalArgumentException("フィールドのリストにnullが与えられました。");
        }

        for (int index = 0; index < cgInterface.getFieldList().size(); index++) {
            final BlancoCgField cgField = cgInterface.getFieldList().get(index);
            new BlancoCgFieldSwiftSourceExpander().transformField(cgField,
                    argSourceFile, argSourceLines, true);
        }
    }

    /**
     * 含まれる各々のメソッドを展開します。
     * 
     * @param cgInterface
     * @param argSourceFile
     * @param argSourceLines
     */
    private void expandMethodList(final BlancoCgInterface cgInterface,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgInterface.getMethodList() == null) {
            throw new IllegalArgumentException("メソッドのリストにnullが与えられました。");
        }
        for (int index = 0; index < cgInterface.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgInterface.getMethodList().get(
                    index);
            new BlancoCgMethodSwiftSourceExpander().transformMethod(cgMethod,
                    argSourceFile, argSourceLines, true);
        }
    }
}
