package org.rdlinux.ezmybatis;

import org.apache.ibatis.session.Configuration;
import org.rdlinux.ezmybatis.constant.MapRetKeyPattern;

/**
 * 配置
 */
public class EzMybatisConfig {
    private Configuration configuration;
    /**
     * 转义关键词
     */
    private boolean escapeKeyword = true;
    /**
     * 查询结果使用map接收的key格式
     */
    private MapRetKeyPattern mapRetKeyPattern;

    public EzMybatisConfig(Configuration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("mybatis configuration can not be null");
        }
        this.configuration = configuration;
        this.mapRetKeyPattern = MapRetKeyPattern.HUMP;
    }

    public boolean isEscapeKeyword() {
        return this.escapeKeyword;
    }

    public void setEscapeKeyword(boolean escapeKeyword) {
        this.escapeKeyword = escapeKeyword;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public MapRetKeyPattern getMapRetKeyPattern() {
        return this.mapRetKeyPattern;
    }

    public void setMapRetKeyPattern(MapRetKeyPattern mapRetKeyPattern) {
        this.mapRetKeyPattern = mapRetKeyPattern;
    }
}
