package org.rdlinux.ezmybatis.core.sqlstruct.converter.dm;

import org.rdlinux.ezmybatis.constant.DbType;
import org.rdlinux.ezmybatis.core.EzMybatisContent;
import org.rdlinux.ezmybatis.core.EzQuery;
import org.rdlinux.ezmybatis.core.sqlstruct.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.GroupCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.between.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.compare.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.nil.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalAliasCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalColumnCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalFieldCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.SqlCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.formula.*;
import org.rdlinux.ezmybatis.core.sqlstruct.selectitem.*;
import org.rdlinux.ezmybatis.core.sqlstruct.table.DbTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.EntityTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.EzQueryTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.SqlTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.partition.NormalPartition;
import org.rdlinux.ezmybatis.core.sqlstruct.table.partition.SubPartition;
import org.rdlinux.ezmybatis.core.sqlstruct.update.*;

/**
 * mysql转换器注册
 */
public class DmConverterRegister {
    public static void register() {
        EzMybatisContent.addConverter(DbType.DM, Where.class, DmWhereConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, Having.class, DmHavingConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, Join.class, DmJoinConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, From.class, DmFromConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, OrderBy.class, DmOrderByConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, Select.class, DmSelectConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, GroupBy.class, DmGroupByConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, Limit.class, DmLimitConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NormalPartition.class, DmNormalPartitionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SubPartition.class, DmSubPartitionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, DbTable.class, DmDbTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, EntityTable.class, DmEntityTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, EzQueryTable.class, DmEzQueryTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SqlTable.class, DmSqlTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, CaseWhen.class, DmCaseWhenConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectAllItem.class, DmSelectAllItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectAvgColumn.class, DmSelectAvgColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectColumn.class, DmSelectColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectAvgField.class, DmSelectAvgFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectCountField.class, DmSelectCountFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectCountColumn.class, DmSelectCountColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectField.class, DmSelectFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectMaxColumn.class, DmSelectMaxColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectMaxField.class, DmSelectMaxFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectMinColumn.class, DmSelectMinColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectMinField.class, DmSelectMinFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectSumColumn.class, DmSelectSumColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectSumField.class, DmSelectSumFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SelectTableAllItem.class, DmSelectTableAllItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, CaseWhenUpdateColumnItem.class, DmCaseWhenUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, CaseWhenUpdateFieldItem.class, DmCaseWhenUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SyntaxUpdateColumnItem.class, DmSyntaxUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SyntaxUpdateFieldItem.class, DmSyntaxUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, UpdateColumnItem.class, DmUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, UpdateFieldItem.class, DmUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, BetweenAliasCondition.class, DmBetweenAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NotBetweenAliasCondition.class, DmNotBetweenAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, BetweenColumnCondition.class, DmBetweenColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NotBetweenColumnCondition.class, DmNotBetweenColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, BetweenFieldCondition.class, DmBetweenFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NotBetweenFieldCondition.class, DmNotBetweenFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, AliasCompareCondition.class, DmAliasCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, ColumnCompareCondition.class, DmColumnCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, FieldCompareCondition.class, DmFieldCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, ColumnCompareFieldCondition.class, DmColumnCompareFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, FieldCompareColumnCondition.class, DmFieldCompareColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, SqlCondition.class, DmSqlConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, GroupCondition.class, DmGroupConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNullAliasCondition.class, DmIsNullAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNotNullAliasCondition.class, DmIsNotNullAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNullFieldCondition.class, DmIsNullFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNotNullFiledCondition.class, DmIsNotNullFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNullColumnCondition.class, DmIsNullColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, IsNotNullColumnCondition.class, DmIsNotNullColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NormalFieldCondition.class, DmNormalFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NormalColumnCondition.class, DmNormalColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, NormalAliasCondition.class, DmNormalAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, EzQuery.class, DmEzQueryConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, Function.class, DmFunctionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, GroupFormulaElement.class, DmGroupFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, ColumnFormulaElement.class, DmColumnFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, FieldFormulaElement.class, DmFieldFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, FunFormulaElement.class, DmFunFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.DM, ValueFormulaElement.class, DmValueFormulaElementConverter.getInstance());
    }
}
