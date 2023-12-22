package org.rdlinux.ezmybatis.core.sqlstruct.converter;

import org.rdlinux.ezmybatis.constant.DbType;
import org.rdlinux.ezmybatis.core.EzMybatisContent;
import org.rdlinux.ezmybatis.core.EzQuery;
import org.rdlinux.ezmybatis.core.sqlstruct.*;
import org.rdlinux.ezmybatis.core.sqlstruct.arg.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.GroupCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.between.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.compare.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.nil.*;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalAliasCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalColumnCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.NormalFieldCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.normal.SqlCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.mysql.MySqlFormulaCompareArgConditionConverter;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.mysql.MySqlFunctionCompareArgConditionConverter;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.mysql.arg.*;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.oracle.*;
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
public class OracleConverterRegister {
    public static void register() {
        EzMybatisContent.addConverter(DbType.ORACLE, Where.class, OracleWhereConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Having.class, OracleHavingConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Join.class, OracleJoinConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, From.class, OracleFromConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, OrderBy.class, OracleOrderByConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, OrderBy.OrderItem.class, OracleOrderItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Select.class, OracleSelectConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, GroupBy.class, OracleGroupByConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, GroupBy.GroupItem.class, OracleGroupItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Limit.class, OracleLimitConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NormalPartition.class, OracleNormalPartitionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SubPartition.class, OracleSubPartitionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, DbTable.class, OracleDbTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, EntityTable.class, OracleEntityTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, EzQueryTable.class, OracleEzQueryTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SqlTable.class, OracleSqlTableConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, CaseWhen.class, OracleCaseWhenConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectCaseWhen.class, OracleSelectCaseWhenConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectAllItem.class, OracleSelectAllItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectAvgColumn.class, OracleSelectAvgColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectColumn.class, OracleSelectColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectAvgField.class, OracleSelectAvgFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectCountField.class, OracleSelectCountFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectCountColumn.class, OracleSelectCountColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectField.class, OracleSelectFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectMaxColumn.class, OracleSelectMaxColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectMaxField.class, OracleSelectMaxFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectMinColumn.class, OracleSelectMinColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectMinField.class, OracleSelectMinFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectSumColumn.class, OracleSelectSumColumnConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectSumField.class, OracleSelectSumFieldConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectTableAllItem.class, OracleSelectTableAllItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectKeywords.class, OracleSelectKeywordsConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, CaseWhenUpdateColumnItem.class, OracleCaseWhenUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, CaseWhenUpdateFieldItem.class, OracleCaseWhenUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, UpdateColumnItem.class, OracleUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, UpdateFieldItem.class, OracleUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FunctionUpdateFieldItem.class, OracleFunctionUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FunctionUpdateColumnItem.class, OracleFunctionUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FormulaUpdateFieldItem.class, OracleFormulaUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FormulaUpdateColumnItem.class, OracleFormulaUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, KeywordsUpdateFieldItem.class, OracleKeywordsUpdateFieldItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, KeywordsUpdateColumnItem.class, OracleKeywordsUpdateColumnItemConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, BetweenAliasCondition.class, OracleBetweenAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NotBetweenAliasCondition.class, OracleNotBetweenAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, BetweenColumnCondition.class, OracleBetweenColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NotBetweenColumnCondition.class, OracleNotBetweenColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, BetweenFieldCondition.class, OracleBetweenFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NotBetweenFieldCondition.class, OracleNotBetweenFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, AliasCompareCondition.class, OracleAliasCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ColumnCompareCondition.class, OracleColumnCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FieldCompareCondition.class, OracleFieldCompareConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ColumnCompareFieldCondition.class, OracleColumnCompareFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FieldCompareColumnCondition.class, OracleFieldCompareColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SqlCondition.class, OracleSqlConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, GroupCondition.class, OracleGroupConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNullAliasCondition.class, OracleIsNullAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNotNullAliasCondition.class, OracleIsNotNullAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNullFieldCondition.class, OracleIsNullFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNotNullFiledCondition.class, OracleIsNotNullFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNullColumnCondition.class, OracleIsNullColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, IsNotNullColumnCondition.class, OracleIsNotNullColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NormalFieldCondition.class, OracleNormalFieldConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NormalColumnCondition.class, OracleNormalColumnConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, NormalAliasCondition.class, OracleNormalAliasConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, EzQuery.class, OracleEzQueryConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Function.class, OracleFunctionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Formula.class, OracleFormulaConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, GroupFormulaElement.class, OracleGroupFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ColumnFormulaElement.class, OracleColumnFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FieldFormulaElement.class, OracleFieldFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FunFormulaElement.class, OracleFunFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FormulaFormulaElement.class, OracleFormulaFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, CaseWhenFormulaElement.class, OracleCaseWhenFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ValueFormulaElement.class, OracleValueFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, KeywordsFormulaElement.class, OracleKeywordsFormulaElementConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, Union.class, OracleUnionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectFormula.class, OracleSelectFormulaConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectFunction.class, OracleSelectFunctionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SelectValue.class, OracleSelectValueConverter.getInstance());
        //argConverter
        EzMybatisContent.addConverter(DbType.ORACLE, AliasArg.class, MySqlAliasArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, CaseWhenArg.class, MySqlCaseWhenArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ColumnArg.class, MySqlColumnArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FieldArg.class, MySqlFieldArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FormulaArg.class, MySqlFormulaArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FunctionArg.class, MySqlFunctionArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, KeywordsArg.class, MySqlKeywordsArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, ObjArg.class, MySqlObjArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, SqlArg.class, MySqlSqlArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, EzQueryArg.class, MySqlEzQueryArgConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FormulaCompareArgCondition.class, MySqlFormulaCompareArgConditionConverter.getInstance());
        EzMybatisContent.addConverter(DbType.ORACLE, FunctionCompareArgCondition.class, MySqlFunctionCompareArgConditionConverter.getInstance());
    }
}
