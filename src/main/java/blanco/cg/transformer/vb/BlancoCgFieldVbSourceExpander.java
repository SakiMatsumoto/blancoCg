/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.vb;

import java.util.List;

import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.util.BlancoCgLineUtil;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoStringUtil;

/**
 * BlancoCgFieldをソースコードへと展開します。
 * 
 * このクラスはblancoCgのバリューオブジェクトからソースコードを自動生成するトランスフォーマーの個別の展開機能です。
 * 
 * @author IGA Tosiki
 */
class BlancoCgFieldVbSourceExpander {
    /**
     * このクラスが処理対象とするプログラミング言語。
     */
    protected static final int TARGET_LANG = BlancoCgSupportedLang.VB;

    /**
     * ここでフィールドを展開します。
     * 
     * @param cgField
     *            処理対象となるフィールド。
     * @param argSourceFile
     *            ソースファイル。
     * @param argSourceLines
     *            出力先行リスト。
     * @param argIsInterface
     *            インタフェースかどうか。クラスの場合にはfalse。インタフェースの場合にはtrue。
     */
    public void transformField(final BlancoCgField cgField,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines,
            final boolean argIsInterface) {
        if (BlancoStringUtil.null2Blank(cgField.getName()).length() == 0) {
            throw new IllegalArgumentException("フィールドの名前に適切な値が設定されていません。");
        }
        if (BlancoStringUtil.null2Blank(cgField.getType().getName()).length() == 0) {
            throw new IllegalArgumentException("フィールド[" + cgField.getName()
                    + "]の型が適切な値が設定されていません。");
        }

        // 有無をいわさず改行を付与します。
        argSourceLines.add("");

        // 最初にフィールド情報をLangDocに展開。
        if (cgField.getLangDoc() == null) {
            // LangDoc未指定の場合にはこちら側でインスタンスを生成。
            cgField.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgField.getLangDoc().getTitle() == null) {
            cgField.getLangDoc().setTitle(cgField.getDescription());
        }

        // 次に LangDocをソースコード形式に展開。
        new BlancoCgLangDocVbSourceExpander().transformLangDoc(cgField
                .getLangDoc(), argSourceLines);

        final StringBuffer buf = new StringBuffer();

        if (BlancoStringUtil.null2Blank(cgField.getAccess()).length() > 0) {
            if (argIsInterface && cgField.getAccess().equals("public")) {
                // インタフェース且つpublicの場合には出力を抑制します。
                // これはCheckstyle対策となります。
            } else {
                buf.append(BlancoNameAdjuster.toClassName(cgField.getAccess())
                        + " ");
            }
        }
        if (cgField.getStatic()) {
            // VB.NETではStaticに相当するものがありません。
            // buf.append("Static ");
        }
        if (cgField.getFinal()) {
            // VB.NETではフィールドへのfinal修飾は、Const修飾が該当します。
            buf.append("Const ");
        }

        // import文に型を追加。
        argSourceFile.getImportList().add(cgField.getType().getName());

        // フィールド生成の本体部分を展開します。
        buf.append(cgField.getName());
        buf.append(" As "
                + BlancoCgTypeVbSourceExpander.toTypeString(cgField.getType()));

        // デフォルト値の指定がある場合にはこれを展開します。
        if (BlancoStringUtil.null2Blank(cgField.getDefault()).length() > 0) {
            buf.append(" = " + cgField.getDefault());
        }
        // 実際には ; は付与されません。
        buf.append(BlancoCgLineUtil.getTerminator(TARGET_LANG));
        argSourceLines.add(buf.toString());
    }
}
