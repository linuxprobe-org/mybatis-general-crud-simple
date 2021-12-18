package org.rdlinux.ezmybatis.core.sqlgenerate.oracle;

import org.apache.ibatis.session.Configuration;
import org.rdlinux.ezmybatis.core.EzDelete;
import org.rdlinux.ezmybatis.core.sqlgenerate.AbstractEzDeleteToSql;
import org.rdlinux.ezmybatis.core.sqlgenerate.MybatisParamHolder;

import java.util.List;
import java.util.Map;

public class OracleEzDeleteToSql extends AbstractEzDeleteToSql {
    private static volatile OracleEzDeleteToSql instance;

    private OracleEzDeleteToSql() {
    }

    public static OracleEzDeleteToSql getInstance() {
        if (instance == null) {
            synchronized (OracleEzDeleteToSql.class) {
                if (instance == null) {
                    instance = new OracleEzDeleteToSql();
                }
            }
        }
        return instance;
    }


    @Override
    public String toSql(Configuration configuration, List<EzDelete> deletes, Map<String, Object> mybatisParam) {
        String sql = super.toSql(configuration, deletes, mybatisParam);
        return "BEGIN \n" + sql + "END;";
    }

    @Override
    protected StringBuilder joinsToSql(StringBuilder sqlBuilder, Configuration configuration, EzDelete delete,
                                       MybatisParamHolder mybatisParamHolder) {
        return sqlBuilder;
    }
}
