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
 * �\�[�X�t�@�C����\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 */
public class BlancoCgSourceFile {
    /**
     * ���̃t�@�C���̃t�@�C�����ł��B
     *
     * �Ȃ��A���̒l�͖����I�Ɏw�肵�Ȃ��Ƃ��A�����̏ꍇ�̓N���X���E�C���^�t�F�[�X�����疼�̂����o�����悤�ɂȂ��Ă��܂��B
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̃t�@�C���̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * ���̃t�@�C������������p�b�P�[�W�ł��B
     *
     * �t�B�[���h: [package]�B
     */
    private String fPackage;

    /**
     * ���̃t�@�C���̕����G���R�[�f�B���O�ł��B
     *
     * �t�B�[���h: [encoding]�B
     */
    private String fEncoding;

    /**
     * ���̃t�@�C�����Q�Ƃ��鑼�̃p�b�P�[�W�̃��X�g�ł��Bjava.lang.String�̃��X�g�B
     *
     * �t�B�[���h: [importList]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     */
    private List<java.lang.String> fImportList = new java.util.ArrayList<java.lang.String>();

    /**
     * ���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B
     *
     * �t�B�[���h: [enumList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgEnum> fEnumList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>();

    /**
     * ���̃t�@�C���Ɋ܂܂��C���^�t�F�[�X�̃��X�g�ł��B
     *
     * �t�B�[���h: [interfaceList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgInterface>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgInterface> fInterfaceList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgInterface>();

    /**
     * ���̃t�@�C���Ɋ܂܂��N���X�̃��X�g�ł��B
     *
     * �t�B�[���h: [classList]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgClass>()]�B
     */
    private List<blanco.cg.valueobject.BlancoCgClass> fClassList = new java.util.ArrayList<blanco.cg.valueobject.BlancoCgClass>();

    /**
     * ����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B
     *
     * �Ȃ��A���̃o�����[�I�u�W�F�N�g�̓\�[�X�t�@�C���̌���h�L�������g�ɊY�����邽�߁A�����ŃZ�b�g�����l�����ۂ̃\�[�X�R�[�h�ɔ��f�����ꍇ�̉e���͈͂͌��肳��Ă��܂��ꍇ������܂��B
     * �t�B�[���h: [langDoc]�B
     */
    private BlancoCgLangDoc fLangDoc;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̃t�@�C�����ł��B]�B
     * �Ȃ��A���̒l�͖����I�Ɏw�肵�Ȃ��Ƃ��A�����̏ꍇ�̓N���X���E�C���^�t�F�[�X�����疼�̂����o�����悤�ɂȂ��Ă��܂��B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̃t�@�C�����ł��B]�B
     * �Ȃ��A���̒l�͖����I�Ɏw�肵�Ȃ��Ƃ��A�����̏ꍇ�̓N���X���E�C���^�t�F�[�X�����疼�̂����o�����悤�ɂȂ��Ă��܂��B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [package] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C������������p�b�P�[�W�ł��B]�B
     *
     * @param argPackage �t�B�[���h[package]�ɐݒ肷��l�B
     */
    public void setPackage(final String argPackage) {
        fPackage = argPackage;
    }

    /**
     * �t�B�[���h [package] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C������������p�b�P�[�W�ł��B]�B
     *
     * @return �t�B�[���h[package]����擾�����l�B
     */
    public String getPackage() {
        return fPackage;
    }

    /**
     * �t�B�[���h [encoding] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̕����G���R�[�f�B���O�ł��B]�B
     *
     * @param argEncoding �t�B�[���h[encoding]�ɐݒ肷��l�B
     */
    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * �t�B�[���h [encoding] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���̕����G���R�[�f�B���O�ł��B]�B
     *
     * @return �t�B�[���h[encoding]����擾�����l�B
     */
    public String getEncoding() {
        return fEncoding;
    }

    /**
     * �t�B�[���h [importList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C�����Q�Ƃ��鑼�̃p�b�P�[�W�̃��X�g�ł��Bjava.lang.String�̃��X�g�B]�B
     *
     * @param argImportList �t�B�[���h[importList]�ɐݒ肷��l�B
     */
    public void setImportList(final List<java.lang.String> argImportList) {
        fImportList = argImportList;
    }

    /**
     * �t�B�[���h [importList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C�����Q�Ƃ��鑼�̃p�b�P�[�W�̃��X�g�ł��Bjava.lang.String�̃��X�g�B]�B
     * �f�t�H���g: [new java.util.ArrayList<java.lang.String>()]�B
     *
     * @return �t�B�[���h[importList]����擾�����l�B
     */
    public List<java.lang.String> getImportList() {
        return fImportList;
    }

    /**
     * �t�B�[���h [enumList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B]�B
     *
     * @param argEnumList �t�B�[���h[enumList]�ɐݒ肷��l�B
     */
    public void setEnumList(final List<blanco.cg.valueobject.BlancoCgEnum> argEnumList) {
        fEnumList = argEnumList;
    }

    /**
     * �t�B�[���h [enumList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��񋓑̂̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgEnum>()]�B
     *
     * @return �t�B�[���h[enumList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgEnum> getEnumList() {
        return fEnumList;
    }

    /**
     * �t�B�[���h [interfaceList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��C���^�t�F�[�X�̃��X�g�ł��B]�B
     *
     * @param argInterfaceList �t�B�[���h[interfaceList]�ɐݒ肷��l�B
     */
    public void setInterfaceList(final List<blanco.cg.valueobject.BlancoCgInterface> argInterfaceList) {
        fInterfaceList = argInterfaceList;
    }

    /**
     * �t�B�[���h [interfaceList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��C���^�t�F�[�X�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgInterface>()]�B
     *
     * @return �t�B�[���h[interfaceList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgInterface> getInterfaceList() {
        return fInterfaceList;
    }

    /**
     * �t�B�[���h [classList] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��N���X�̃��X�g�ł��B]�B
     *
     * @param argClassList �t�B�[���h[classList]�ɐݒ肷��l�B
     */
    public void setClassList(final List<blanco.cg.valueobject.BlancoCgClass> argClassList) {
        fClassList = argClassList;
    }

    /**
     * �t�B�[���h [classList] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃t�@�C���Ɋ܂܂��N���X�̃��X�g�ł��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.cg.valueobject.BlancoCgClass>()]�B
     *
     * @return �t�B�[���h[classList]����擾�����l�B
     */
    public List<blanco.cg.valueobject.BlancoCgClass> getClassList() {
        return fClassList;
    }

    /**
     * �t�B�[���h [langDoc] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B]�B
     * �Ȃ��A���̃o�����[�I�u�W�F�N�g�̓\�[�X�t�@�C���̌���h�L�������g�ɊY�����邽�߁A�����ŃZ�b�g�����l�����ۂ̃\�[�X�R�[�h�ɔ��f�����ꍇ�̉e���͈͂͌��肳��Ă��܂��ꍇ������܂��B
     *
     * @param argLangDoc �t�B�[���h[langDoc]�ɐݒ肷��l�B
     */
    public void setLangDoc(final BlancoCgLangDoc argLangDoc) {
        fLangDoc = argLangDoc;
    }

    /**
     * �t�B�[���h [langDoc] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [����h�L�������g��~���܂��B�f�t�H���g�ȏ�̕\����ǉ�����ꍇ�ɂ́A�C���X�^���X�𐶐����Ēl���Z�b�g���Ă��玩���������܂��B]�B
     * �Ȃ��A���̃o�����[�I�u�W�F�N�g�̓\�[�X�t�@�C���̌���h�L�������g�ɊY�����邽�߁A�����ŃZ�b�g�����l�����ۂ̃\�[�X�R�[�h�ɔ��f�����ꍇ�̉e���͈͂͌��肳��Ă��܂��ꍇ������܂��B
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
        buf.append("blanco.cg.valueobject.BlancoCgSourceFile[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",package=" + fPackage);
        buf.append(",encoding=" + fEncoding);
        buf.append(",importList=" + fImportList);
        buf.append(",enumList=" + fEnumList);
        buf.append(",interfaceList=" + fInterfaceList);
        buf.append(",classList=" + fClassList);
        buf.append(",langDoc=" + fLangDoc);
        buf.append("]");
        return buf.toString();
    }
}
