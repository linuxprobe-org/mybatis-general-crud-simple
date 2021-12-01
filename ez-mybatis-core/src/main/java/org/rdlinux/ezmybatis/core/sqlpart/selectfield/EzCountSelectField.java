package org.rdlinux.ezmybatis.core.sqlpart.selectfield;

import org.apache.ibatis.session.Configuration;
import org.rdlinux.ezmybatis.core.content.EzEntityClassInfoFactory;
import org.rdlinux.ezmybatis.core.content.entityinfo.EntityClassInfo;
import org.rdlinux.ezmybatis.core.sqlgenerate.KeywordQMFactory;
import org.rdlinux.ezmybatis.core.sqlpart.EzTable;
import org.rdlinux.ezmybatis.core.utils.DbTypeUtils;

public class EzCountSelectField extends EzNormalSelectField {
    public EzCountSelectField(EzTable table, String field) {
        super(table, field);
    }

    public EzCountSelectField(EzTable table, String field, String alias) {
        super(table, field, alias);
    }

    @Override
    public String toSqlPart(Configuration configuration) {
        EntityClassInfo entityClassInfo = EzEntityClassInfoFactory.forClass(configuration, this.getTable().getEtType());
        String keywordQM = KeywordQMFactory.getKeywordQM(DbTypeUtils.getDbType(configuration));
        String sql = " COUNT(" + this.getTable().getAlias() + "." + keywordQM + entityClassInfo
                .getFieldInfo(this.getField()).getColumnName() + keywordQM + ") ";
        String alias = this.getAlias();
        if (alias != null && !alias.isEmpty()) {
            sql = sql + keywordQM + alias + keywordQM + " ";
        }
        return sql;
    }
}
