package org.rdlinux.ezmybatis.core.classinfo.entityinfo.build;

import org.apache.ibatis.session.Configuration;
import org.rdlinux.ezmybatis.constant.DbType;
import org.rdlinux.ezmybatis.core.classinfo.entityinfo.DefaultEntityClassInfo;
import org.rdlinux.ezmybatis.core.classinfo.entityinfo.EntityClassInfo;
import org.rdlinux.ezmybatis.core.classinfo.entityinfo.EntityInfoBuildConfig;

public class OracleEntityInfoBuild implements EntityInfoBuild {
    private static volatile OracleEntityInfoBuild instance;

    protected OracleEntityInfoBuild() {
    }

    public static OracleEntityInfoBuild getInstance() {
        if (instance == null) {
            synchronized (OracleEntityInfoBuild.class) {
                if (instance == null) {
                    instance = new OracleEntityInfoBuild();
                }
            }
        }
        return instance;
    }

    @Override
    public EntityClassInfo buildInfo(Configuration configuration, Class<?> ntClass) {
        EntityInfoBuildConfig buildConfig;
        //如果配置下划线转驼峰
        if (configuration.isMapUnderscoreToCamelCase()) {
            buildConfig = new EntityInfoBuildConfig(EntityInfoBuildConfig.ColumnHandle.ToUnderAndUpper);
        } else {
            buildConfig = new EntityInfoBuildConfig(EntityInfoBuildConfig.ColumnHandle.ORIGINAL);
        }
        return new DefaultEntityClassInfo(ntClass, buildConfig);
    }

    @Override
    public DbType getSupportedDbType() {
        return DbType.ORACLE;
    }
}
