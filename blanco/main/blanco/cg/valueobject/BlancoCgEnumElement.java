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

/**
 * enum�̊e�v�f��\�����邽�߂̃o�����[�I�u�W�F�N�g�B
 */
public class BlancoCgEnumElement {
    /**
     * ���̗񋓑̗̂v�f�̖��O�ł��B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * ���̗񋓑̗̂v�f�̐����ł��B
     *
     * �t�B�[���h: [description]�B
     */
    private String fDescription;

    /**
     * (C#.NET�̂ݑΉ�) �f�t�H���g�l������킵�܂��B
     *
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     * �t�B�[���h: [default]�B
     */
    private String fDefault;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̗̂v�f�̖��O�ł��B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̗̂v�f�̖��O�ł��B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [description] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̗̂v�f�̐����ł��B]�B
     *
     * @param argDescription �t�B�[���h[description]�ɐݒ肷��l�B
     */
    public void setDescription(final String argDescription) {
        fDescription = argDescription;
    }

    /**
     * �t�B�[���h [description] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̗񋓑̗̂v�f�̐����ł��B]�B
     *
     * @return �t�B�[���h[description]����擾�����l�B
     */
    public String getDescription() {
        return fDescription;
    }

    /**
     * �t�B�[���h [default] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [(C#.NET�̂ݑΉ�) �f�t�H���g�l������킵�܂��B]�B
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     *
     * @param argDefault �t�B�[���h[default]�ɐݒ肷��l�B
     */
    public void setDefault(final String argDefault) {
        fDefault = argDefault;
    }

    /**
     * �t�B�[���h [default] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [(C#.NET�̂ݑΉ�) �f�t�H���g�l������킵�܂��B]�B
     * String�Ȃ� ""�Aint�Ȃ� 3 �Ȃǂ̂悤�Ɏ��ۂ̕����w�肵�܂��B
     * (�_�u���N�I�[�g�Ȃǂ��܂񂾌`�ŕ\�����܂��B)
     *
     * @return �t�B�[���h[default]����擾�����l�B
     */
    public String getDefault() {
        return fDefault;
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
        buf.append("blanco.cg.valueobject.BlancoCgEnumElement[");
        buf.append("name=" + fName);
        buf.append(",description=" + fDescription);
        buf.append(",default=" + fDefault);
        buf.append("]");
        return buf.toString();
    }
}
