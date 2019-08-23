package com.zp.mango.common.utils;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * @创建人 zp
 * @创建时间 2019/8/22
 * @描述 自定义注解
 */
public class MyCommentGenerator implements CommentGenerator{

    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;
    private SimpleDateFormat dateFormat;

    public MyCommentGenerator(){
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.suppressDate = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        this.suppressAllComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    /**
     * 此方法添加自定义javadoc标记。但是，如果不包含Javadoc标记，则eclipse插件的Java合并功能将会崩溃
     * @param javaElement
     * @param markAsDoNotDelete
     */
    protected void addJavadocTag(JavaElement javaElement,boolean markAsDoNotDelete){
        javaElement.addJavaDocLine(" *");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" * ");
        stringBuilder.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            stringBuilder.append(" do_not_delete_during_merge"); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            stringBuilder.append(' ');
            stringBuilder.append(s);
        }
        javaElement.addJavaDocLine(stringBuilder.toString());
    }

    /**
     * 返回要包含在Javadoc标记中的格式化日期字符串
     * 和XML注释。如果不希望输入日期，可以返回null
     * 这些文档元素。
     * @return
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else if (dateFormat != null) {
            return dateFormat.format(new Date());
        } else {
            return new Date().toString();
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        field.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(stringBuilder.toString());

        //addJavadocTag(innerClass,b)

        stringBuilder.append(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        field.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(stringBuilder.toString());
        stringBuilder.append(" */");
    }

    /**
     * entity实体 注解
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        topLevelClass.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(stringBuilder.toString());
        stringBuilder.append(" */");
    }

    /**
     * Class类注解
     * @param innerClass
     * @param introspectedTable
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        stringBuilder.append(" ");
        stringBuilder.append(getDateString());
        innerClass.addJavaDocLine(stringBuilder.toString());
        innerClass.addJavaDocLine("*/");
    }

    /**
     * Class类注解
     * @param innerClass
     * @param introspectedTable
     * @param b
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(stringBuilder.toString());

        stringBuilder.setLength(0);
        stringBuilder.append(" * @author ");
        stringBuilder.append(systemPro.getProperty("user.name"));
        stringBuilder.append(" ");
        stringBuilder.append(currentDateStr);

        //addJavadocTag(innerClass,b)

        innerClass.addJavaDocLine(" */");
    }

    /**
     * 枚举类型注解
     * @param innerEnum
     * @param introspectedTable
     */
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if(suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        innerEnum.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(stringBuilder.toString());
        innerEnum.addJavaDocLine(" */");
    }

    /**
     * get方法注解
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        return;
    }

    /**
     * set方法注解
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        return;
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    /**
     * 默认情况下不添加任何文件级别的注释
     * @param compilationUnit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        return;
    }

    /**
     * 添加适当的注释，以警告用户该元素已生成，以及何时生成。
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        return;
    }

    /**
     * 默认情况下不添加文档级别的注释
     * @param xmlElement
     */
    @Override
    public void addRootComment(XmlElement xmlElement) {
        return;
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        return;
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
        return;
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        return;
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
        return;
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        return;
    }

    public static void main(String[] args) {
        System.out.println("start");
    }
}
