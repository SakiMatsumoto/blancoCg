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
 * enum��\�����邽�߂̃o�����[�I�u�W�F�N�g�B��Java, C#.NET �݂̂őΉ��B����ȊO�̌���ł͖��Ή��B
 */
public class BlancoCgEnum {
    /**
     * ���̗񋓑̖̂��O�ł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̗񋓑̂̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * �A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B
     *
     * �t�B�[���h: [access]�B
     */
    private String fAccess;

    /**
     * enum �G�������g������킵�܂��B
     *
     * �t�B�[���h: [elementList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnumElement>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgEnumElement> fElementList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnumElement>();

    /**
     * ����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B
     *
     * �t�B�[���h: [langDoc]�B
     */
    private BlancoCgLangDoc fLangDoc;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̖̂��O�ł��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̖̂��O�ł��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̂̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̂̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [access] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B]�B
     *
     * @param argAccess �t�B�[���h[access]�ɐݒ肷��l�B
     */
    public void setAccess(final String argAccess) {
        fAccess = argAccess;
    }

    /**
     * �t�B�[���h [access] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�A�N�Z�X�R���g���[�����w�肵�܂��Bpublic/protected/private�Ȃǂ��w�肵�܂��B]�B
     *
     * @return �t�B�[���h[access]����擾�����l�B
     */
    public String getAccess() {
        return fAccess;
    }

    /**
     * �t�B�[���h [elementList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [enum �G�������g������킵�܂��B]�B
     *
     * @param argElementList �t�B�[���h[elementList]�ɐݒ肷��l�B
     */
    public void setElementList(final List<blanco.cg.valueobject.BlancoCgEnumElement> argElementList) {
        fElementList = argElementList;
    }

    /**
     * �t�B�[���h [elementList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [enum �G�������g������킵�܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnumElement>()]�B
     *
     * @return �t�B�[���h[elementList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgEnumElement> getElementList() {
        return fElementList;
    }

    /**
     * �t�B�[���h [langDoc] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B]�B
     *
     * @param argLangDoc �t�B�[���h[langDoc]�ɐݒ肷��l�B
     */
    public void setLangDoc(final BlancoCgLangDoc argLangDoc) {
        fLangDoc = argLangDoc;
    }

    /**
     * �t�B�[���h [langDoc] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B�Ȃ�BlancoCgObjectFactory���o�R���ăC���X�^���X���擾�����ۂɂ́A���ɃI�u�W�F�N�g�̓Z�b�g�ς݂ł��B]�B
     *
     * @return �t�B�[���h[langDoc]����擾�����l�B
     */
    public BlancoCgLangDoc getLangDoc() {
        return fLangDoc;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.cg.valueobject.BlancoCgEnum[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",access=" + fAccess);
        buf.append(",elementList=" + fElementList);
        buf.append(",langDoc=" + fLangDoc);
        buf.append("]");
        return buf.toString();
    }
}
