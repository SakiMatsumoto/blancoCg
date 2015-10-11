/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.cg.transformer.delphi;

import java.util.ArrayList;
import java.util.List;

import blanco.cg.valueobject.BlancoCgClass;
import blanco.cg.valueobject.BlancoCgEnum;
import blanco.cg.valueobject.BlancoCgField;
import blanco.cg.valueobject.BlancoCgLangDoc;
import blanco.cg.valueobject.BlancoCgMethod;
import blanco.cg.valueobject.BlancoCgSourceFile;
import blanco.cg.valueobject.BlancoCgType;

/**
 * BlancoCgClass���\�[�X�R�[�h�ւƓW�J���܂��B
 * 
 * ���̃N���X��blancoCg�̃o�����[�I�u�W�F�N�g����\�[�X�R�[�h��������������g�����X�t�H�[�}�[�̌ʂ̓W�J�@�\�ł��B
 * 
 * @author IGA Tosiki
 */
class BlancoCgClassDelphiSourceExpander {

    /**
     * ������Class��W�J���܂��B
     * 
     * @param cgClass
     *            �����ΏۂƂȂ�N���X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    public void transformClass(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        // �ŏ��ɃN���X����LangDoc�ɓW�J�B
        if (cgClass.getLangDoc() == null) {
            // LangDoc���w��̏ꍇ�ɂ͂����瑤�ŃC���X�^���X�𐶐��B
            cgClass.setLangDoc(new BlancoCgLangDoc());
        }
        if (cgClass.getLangDoc().getTitle() == null) {
            cgClass.getLangDoc().setTitle(cgClass.getDescription());
        }

        // ���� LangDoc���\�[�X�R�[�h�`���ɓW�J�B
        new BlancoCgLangDocDelphiSourceExpander().transformLangDoc(cgClass
                .getLangDoc(), argSourceLines);

        // �A�m�e�[�V������W�J�B
        expandAnnotationList(cgClass, argSourceLines);

        final StringBuffer buf = new StringBuffer();

        // Delphi�ł�class���̂ɉ�����ݒ肵�܂���
        // if (BlancoStringUtil.null2Blank(cgClass.getAccess()).length() > 0) {
        // buf.append(cgClass.getAccess() + " ");
        // }
        // if (cgClass.getAbstract()) {
        // buf.append("abstract ");
        // }
        // if (cgClass.getFinal()) {
        // buf.append("final ");
        // }

        buf.append(cgClass.getName());

        // �e�N���X��W�J�B
        expandExtendClassList(cgClass, argSourceFile, buf);

        // �e�C���^�t�F�[�X��W�J�B
        expandImplementInterfaceList(cgClass, argSourceFile, buf);

        // �s���m�肵�ď����o�������{�B
        argSourceLines.add(buf.toString());

        // �N���X�̃u���b�N�̊J�n�B
        argSourceLines.add("");

        // �����ŗ񋓑̂�W�J�B
        // expandEnumList(cgClass, argSourceFile, argSourceLines);

        // �����Ńt�B�[���h��W�J�B
        expandFieldList(cgClass, argSourceFile, argSourceLines);

        // �����Ń��\�b�h�錾��W�J�B
        expandMethodDeclarationList(cgClass, argSourceFile, argSourceLines);

        // �N���X�̃u���b�N�̏I���B
        argSourceLines.add("end;");

        // implementation
        argSourceLines.add("implementation");

        // �����Ń��\�b�h��W�J�B
        expandMethodList(cgClass, argSourceFile, argSourceLines);

        // end.
        argSourceLines.add("end.");

    }

    /**
     * �A�m�e�[�V������W�J���܂��B
     * 
     * @param cgClass
     *            �N���X�B
     * @param argSourceLines
     *            �\�[�X�R�[�h�B
     */
    private void expandAnnotationList(final BlancoCgClass cgClass,
            final List<java.lang.String> argSourceLines) {
        for (int index = 0; index < cgClass.getAnnotationList().size(); index++) {
            final String strAnnotation = cgClass.getAnnotationList().get(index);
            // C#.NET�����Annotation�� []�ŋL�q���܂��B
            argSourceLines.add("[" + strAnnotation + "]");
        }
    }

    /**
     * �e�N���X��W�J���܂��B
     * 
     * ��BlancoCgInterface�W�J�̍ۂɁA���̃��\�b�h�����ʏ����Ƃ��ČĂяo���Ă͂Ȃ�܂���B
     * ���̋��ʉ��́A�������ė�����W����Ɣ��f���Ă��܂��B
     * 
     * @param cgClass
     *            �N���X�̃o�����[�I�u�W�F�N�g�B
     * @param argBuf
     *            �o�͐敶����o�b�t�@�B
     */
    private void expandExtendClassList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile, final StringBuffer argBuf) {
        if (cgClass.getExtendClassList().size() == 0) {
            argBuf.append(" = class(TObject)");
            return;
        }
        for (int index = 0; index < cgClass.getExtendClassList().size(); index++) {
            final BlancoCgType type = cgClass.getExtendClassList().get(index);

            // import���Ɍ^��ǉ��B
            // argSourceFile.getImportList().add(type.getName());

            if (index == 0) {
                argBuf.append(" = class("
                        + BlancoCgTypeDelphiSourceExpander.toTypeString(type)
                        + ")");
            } else {
                // TODO C#.NET�̌p������x���肾�������ǂ����m�F�����{���邱�ƁB
                // throw new
                // IllegalArgumentException("C#.NET����ł͌p���͈�񂵂����{�ł��܂���B");

                // TODO �����_�ł͑��d�p����OK�ł���Ƒz�肵�܂��B
                argBuf.append(", "
                        + BlancoCgTypeDelphiSourceExpander.toTypeString(type));
            }
        }
    }

    /**
     * �e�C���^�t�F�[�X��W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argBuf
     *            �o�͐敶����o�b�t�@�B
     */
    private void expandImplementInterfaceList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile, final StringBuffer argBuf) {
        for (int index = 0; index < cgClass.getImplementInterfaceList().size(); index++) {
            final BlancoCgType type = cgClass.getImplementInterfaceList().get(
                    index);

            // import���Ɍ^��ǉ��B
            // argSourceFile.getImportList().add(type.getName());

            if (index == 0 && cgClass.getExtendClassList().size() == 0) {
                // �ŏ��̃C���^�t�F�[�X�ŁA���p���������ꍇ�� : ���o�͂��܂��B
                argBuf.append(" : ");
            } else {
                argBuf.append(", ");
            }
            argBuf.append(BlancoCgTypeDelphiSourceExpander.toTypeString(type));
        }
    }

    /**
     * �N���X�Ɋ܂܂��e�X�̗񋓑̂�W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandEnumList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getEnumList() == null) {
            return;
        }

        for (BlancoCgEnum cgEnum : cgClass.getEnumList()) {
            new BlancoCgEnumDelphiSourceExpander().transformEnum(cgEnum,
                    argSourceFile, argSourceLines);
        }
    }

    /**
     * �N���X�Ɋ܂܂��e�X�̃t�B�[���h��W�J���܂��B
     * 
     * TODO �萔�錾��D�悵�ēW�J���A���̌�ϐ��錾��W�J����Ȃǂ̍H�v���K�v�ł��B<br>
     * ���݂� �o�^���Ń\�[�X�R�[�h�W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandFieldList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getFieldList() == null) {
            // �t�B�[���h�̃��X�g��null���^�����܂����B
            // ���Ȃ炸�t�B�[���h�̃��X�g�ɂ�List���Z�b�g���Ă��������B
            throw new IllegalArgumentException("�t�B�[���h�̃��X�g��null���^�����܂����B");
        }

        List<BlancoCgField> publishedList = new ArrayList<BlancoCgField>();
        List<BlancoCgField> publicList = new ArrayList<BlancoCgField>();
        List<BlancoCgField> privateList = new ArrayList<BlancoCgField>();

        for (int index = 0; index < cgClass.getFieldList().size(); index++) {
            final BlancoCgField cgField = cgClass.getFieldList().get(index);

            String access = cgField.getAccess();

            if (isPublished(access)) {
                publishedList.add(cgField);
            } else if (isPublic(access)) {
                publicList.add(cgField);
            } else if (isPrivate(access)) {
                privateList.add(cgField);
            } else {
                // �T�|�[�g����Ȃ�
            }
        }

        // published �t�B�[���h�̓W�J
        if (publishedList.size() > 0) {
            argSourceLines.add("published");
        }
        for (int index = 0; index < publishedList.size(); index++) {
            final BlancoCgField cgField = publishedList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgFieldDelphiSourceExpander().transformField(cgField,
                    argSourceFile, argSourceLines, false);
        }

        // public �t�B�[���h�̓W�J
        if (publicList.size() > 0) {
            argSourceLines.add("public");
        }
        for (int index = 0; index < publicList.size(); index++) {
            final BlancoCgField cgField = publicList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgFieldDelphiSourceExpander().transformField(cgField,
                    argSourceFile, argSourceLines, false);
        }

        // private �t�B�[���h�̓W�J
        if (privateList.size() > 0) {
            argSourceLines.add("private");
        }
        for (int index = 0; index < privateList.size(); index++) {
            final BlancoCgField cgField = privateList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgFieldDelphiSourceExpander().transformField(cgField,
                    argSourceFile, argSourceLines, false);
        }
    }

    /**
     * �N���X�Ɋ܂܂��e�X�̃��\�b�h�錾��W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandMethodDeclarationList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getMethodList() == null) {
            throw new IllegalArgumentException("���\�b�h�̃��X�g��null���^�����܂����B");
        }

        List<BlancoCgMethod> publishedList = new ArrayList<BlancoCgMethod>();
        List<BlancoCgMethod> publicList = new ArrayList<BlancoCgMethod>();
        List<BlancoCgMethod> privateList = new ArrayList<BlancoCgMethod>();

        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);
            String access = cgMethod.getAccess();

            if (isPublished(access)) {
                publishedList.add(cgMethod);
            } else if (isPublic(access)) {
                publicList.add(cgMethod);
            } else if (isPrivate(access)) {
                privateList.add(cgMethod);
            } else {
                // �T�|�[�g����Ȃ�
            }
        }

        // published ���\�b�h�̓W�J
        if (publishedList.size() > 0) {
            // ���s��t�^�B
            argSourceLines.add("");
            argSourceLines.add("published");
        }
        for (int index = 0; index < publishedList.size(); index++) {
            final BlancoCgMethod cgMethod = publishedList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgMethodDelphiSourceExpander()
                    .transformMethodDeclaration(cgMethod, argSourceFile,
                            argSourceLines, false);
        }

        // public ���\�b�h�̓W�J
        if (publicList.size() > 0) {
            // ���s��t�^�B
            argSourceLines.add("");
            argSourceLines.add("public");
        }
        for (int index = 0; index < publicList.size(); index++) {
            final BlancoCgMethod cgMethod = publicList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgMethodDelphiSourceExpander()
                    .transformMethodDeclaration(cgMethod, argSourceFile,
                            argSourceLines, false);
        }

        // private ���\�b�h�̓W�J
        if (privateList.size() > 0) {
            // ���s��t�^�B
            argSourceLines.add("");
            argSourceLines.add("private");
        }
        for (int index = 0; index < privateList.size(); index++) {
            final BlancoCgMethod cgMethod = privateList.get(index);
            // �N���X�̃t�B�[���h�Ƃ��ēW�J���s���܂��B
            new BlancoCgMethodDelphiSourceExpander()
                    .transformMethodDeclaration(cgMethod, argSourceFile,
                            argSourceLines, false);
        }

    }

    /**
     * �N���X�Ɋ܂܂��e�X�̃��\�b�h��W�J���܂��B
     * 
     * @param cgClass
     *            �������̃N���X�B
     * @param argSourceFile
     *            �\�[�X�t�@�C���B
     * @param argSourceLines
     *            �\�[�X�R�[�h�s���X�g�B
     */
    private void expandMethodList(final BlancoCgClass cgClass,
            final BlancoCgSourceFile argSourceFile,
            final List<java.lang.String> argSourceLines) {
        if (cgClass.getMethodList() == null) {
            throw new IllegalArgumentException("���\�b�h�̃��X�g��null���^�����܂����B");
        }
        for (int index = 0; index < cgClass.getMethodList().size(); index++) {
            final BlancoCgMethod cgMethod = cgClass.getMethodList().get(index);
            // �N���X�̃��\�b�h�Ƃ��ēW�J���s���܂��B
            new BlancoCgMethodDelphiSourceExpander().transformMethod(cgClass
                    .getName(), cgMethod, argSourceFile, argSourceLines, false);
        }
    }

    private boolean isPrivate(String access) {
        return "private".equals(access);
    }

    private boolean isPublic(String access) {
        return "public".equals(access);
    }

    private boolean isPublished(String access) {
        return "".equals(access) || "published".equals(access);
    }
}
