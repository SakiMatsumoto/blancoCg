/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.valueobject;

import java.util.List;

/**
 * パラメータを表現するためのバリューオブジェクト。言語によっては引数と呼ばれるものです。
 */
public class BlancoCgParameter {
    /**
     * このパラメータの名前です。argOrigialStringなどが指定されます。
     *
     * フィールド: [name]。
     */
    private String fName;

    /**
     * このパラメータの説明です。
     *
     * フィールド: [description]。
     */
    private String fDescription;

    /**
     * このパラメータの型です。java.lang.Stringなどを指定します。
     *
     * フィールド: [type]。
     */
    private BlancoCgType fType;

    /**
     * このフィールドがfinalかどうかです。
     *
     * フィールド: [final]。
     * デフォルト: [true]。
     */
    private boolean fFinal = true;

    /**
     * このフィールドにnullを与えられた際に引数例外を発生させるかどうか。
     *
     * フィールド: [notnull]。
     * デフォルト: [false]。
     */
    private boolean fNotnull = false;

    /**
     * このクラスに付与されているアノテーションのリストです。
     *
     * .NET Framework版の自動生成のみ対応しています。
     * フィールド: [annotationList]。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     */
    private List<java.lang.String> fAnnotationList = new java.util.ArrayList<java.lang.String>();

    /**
     * フィールド [name] の値を設定します。
     *
     * フィールドの説明: [このパラメータの名前です。argOrigialStringなどが指定されます。]。
     *
     * @param argName フィールド[name]に設定する値。
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * フィールド [name] の値を取得します。
     *
     * フィールドの説明: [このパラメータの名前です。argOrigialStringなどが指定されます。]。
     *
     * @return フィールド[name]から取得した値。
     */
    public String getName() {
        return fName;
    }

    /**
     * フィールド [description] の値を設定します。
     *
     * フィールドの説明: [このパラメータの説明です。]。
     *
     * @param argDescription フィールド[description]に設定する値。
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * フィールド [description] の値を取得します。
     *
     * フィールドの説明: [このパラメータの説明です。]。
     *
     * @return フィールド[description]から取得した値。
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * フィールド [type] の値を設定します。
     *
     * フィールドの説明: [このパラメータの型です。java.lang.Stringなどを指定します。]。
     *
     * @param argType フィールド[type]に設定する値。
     */
    public void setType(final BlancoCgType argType) {
        fType = argType;
    }

    /**
     * フィールド [type] の値を取得します。
     *
     * フィールドの説明: [このパラメータの型です。java.lang.Stringなどを指定します。]。
     *
     * @return フィールド[type]から取得した値。
     */
    public BlancoCgType getType() {
        return fType;
    }

    /**
     * フィールド [final] の値を設定します。
     *
     * フィールドの説明: [このフィールドがfinalかどうかです。]。
     *
     * @param argFinal フィールド[final]に設定する値。
     */
    public void setFinal(final boolean argFinal) {
        fFinal = argFinal;
    }

    /**
     * フィールド [final] の値を取得します。
     *
     * フィールドの説明: [このフィールドがfinalかどうかです。]。
     * デフォルト: [true]。
     *
     * @return フィールド[final]から取得した値。
     */
    public boolean getFinal() {
        return fFinal;
    }

    /**
     * フィールド [notnull] の値を設定します。
     *
     * フィールドの説明: [このフィールドにnullを与えられた際に引数例外を発生させるかどうか。]。
     *
     * @param argNotnull フィールド[notnull]に設定する値。
     */
    public void setNotnull(final boolean argNotnull) {
        fNotnull = argNotnull;
    }

    /**
     * フィールド [notnull] の値を取得します。
     *
     * フィールドの説明: [このフィールドにnullを与えられた際に引数例外を発生させるかどうか。]。
     * デフォルト: [false]。
     *
     * @return フィールド[notnull]から取得した値。
     */
    public boolean getNotnull() {
        return fNotnull;
    }

    /**
     * フィールド [annotationList] の値を設定します。
     *
     * フィールドの説明: [このクラスに付与されているアノテーションのリストです。]。
     * .NET Framework版の自動生成のみ対応しています。
     *
     * @param argAnnotationList フィールド[annotationList]に設定する値。
     */
    public void setAnnotationList(final List<java.lang.String> argAnnotationList) {
        fAnnotationList = argAnnotationList;
    }

    /**
     * フィールド [annotationList] の値を取得します。
     *
     * フィールドの説明: [このクラスに付与されているアノテーションのリストです。]。
     * .NET Framework版の自動生成のみ対応しています。
     * デフォルト: [new java.util.ArrayList<java.lang.String>()]。
     *
     * @return フィールド[annotationList]から取得した値。
     */
    public List<java.lang.String> getAnnotationList() {
        return fAnnotationList;
    }

    /**
     * このバリューオブジェクトの文字列表現を取得します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @return バリューオブジェクトの文字列表現。
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.cg.valueobject.BlancoCgParameter[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",type=" + fType);
        buf.append(",final=" + fFinal);
        buf.append(",notnull=" + fNotnull);
        buf.append(",annotationList=" + fAnnotationList);
        buf.append("]");
        return buf.toString();
    }
}