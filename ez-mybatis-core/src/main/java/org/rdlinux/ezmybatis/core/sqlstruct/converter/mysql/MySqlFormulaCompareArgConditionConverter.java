package org.rdlinux.ezmybatis.core.sqlstruct.converter.mysql;

import org.apache.ibatis.session.Configuration;
import org.rdlinux.ezmybatis.constant.DbType;
import org.rdlinux.ezmybatis.core.EzMybatisContent;
import org.rdlinux.ezmybatis.core.sqlgenerate.MybatisParamHolder;
import org.rdlinux.ezmybatis.core.sqlstruct.arg.Arg;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.Operator;
import org.rdlinux.ezmybatis.core.sqlstruct.condition.compare.FormulaCompareArgCondition;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.AbstractConverter;
import org.rdlinux.ezmybatis.core.sqlstruct.converter.Converter;
import org.rdlinux.ezmybatis.core.sqlstruct.formula.Formula;

public class MySqlFormulaCompareArgConditionConverter extends AbstractConverter<FormulaCompareArgCondition>
        implements Converter<FormulaCompareArgCondition> {
    private static volatile MySqlFormulaCompareArgConditionConverter instance;

    protected MySqlFormulaCompareArgConditionConverter() {
    }

    public static MySqlFormulaCompareArgConditionConverter getInstance() {
        if (instance == null) {
            synchronized (MySqlFormulaCompareArgConditionConverter.class) {
                if (instance == null) {
                    instance = new MySqlFormulaCompareArgConditionConverter();
                }
            }
        }
        return instance;
    }

    protected String getOperatorStr(Operator operator) {
        return operator.getOperator();
    }

    @Override
    protected StringBuilder doBuildSql(Type type, StringBuilder sqlBuilder, Configuration configuration,
                                       FormulaCompareArgCondition obj, MybatisParamHolder mybatisParamHolder) {
        Formula formula = obj.getFormula();
        Converter<? extends Formula> formulaConverter = EzMybatisContent.getConverter(configuration,
                formula.getClass());
        StringBuilder leftSql = new StringBuilder();
        leftSql.append(" ").append(formulaConverter.buildSql(type, new StringBuilder(), configuration, formula,
                mybatisParamHolder)).append(" ");
        return this.doBuildSql(leftSql, type, sqlBuilder, configuration, obj, mybatisParamHolder);
    }

    protected StringBuilder doBuildSql(StringBuilder leftSql, Type type, StringBuilder sqlBuilder,
                                       Configuration configuration, FormulaCompareArgCondition obj,
                                       MybatisParamHolder mybatisParamHolder) {
        Operator operator = obj.getOperator();
        if (operator == Operator.isNull || operator == Operator.isNotNull) {
            return this.isNullBuild(leftSql, sqlBuilder, obj);
        } else if (operator == Operator.between || operator == Operator.notBetween) {
            return this.isBetweenBuild(leftSql, type, sqlBuilder, configuration, obj, mybatisParamHolder);
        } else if (operator == Operator.in || operator == Operator.notIn) {
            return this.inBuild(leftSql, type, sqlBuilder, configuration, obj, mybatisParamHolder);
        } else {
            return this.normalBuild(leftSql, type, sqlBuilder, configuration, obj, mybatisParamHolder);
        }
    }

    private StringBuilder normalBuild(StringBuilder leftSql, Type type, StringBuilder sqlBuilder,
                                      Configuration configuration, FormulaCompareArgCondition obj,
                                      MybatisParamHolder mybatisParamHolder) {
        Arg value = obj.getValue();
        Converter<? extends Arg> argConverter = EzMybatisContent.getConverter(configuration,
                value.getClass());
        return sqlBuilder.append(" ")
                .append(leftSql)
                .append(" ")
                .append(this.getOperatorStr(obj.getOperator()))
                .append(" ")
                .append(argConverter.buildSql(type, new StringBuilder(), configuration, value, mybatisParamHolder))
                .append(" ");
    }

    private StringBuilder inBuild(StringBuilder leftSql, Type type, StringBuilder sqlBuilder,
                                  Configuration configuration, FormulaCompareArgCondition obj,
                                  MybatisParamHolder mybatisParamHolder) {
        Operator operator = obj.getOperator();
        if (obj.getValues().size() == 1) {
            if (operator == Operator.in) {
                operator = Operator.eq;
            } else {
                operator = Operator.ne;
            }
        }
        sqlBuilder.append(" ")
                .append(leftSql)
                .append(" ")
                .append(this.getOperatorStr(operator))
                .append(" ");
        if (operator == Operator.in || operator == Operator.notIn) {
            sqlBuilder.append("(");
        }
        for (int i = 0; i < obj.getValues().size(); i++) {
            Arg arg = obj.getValues().get(i);
            Converter<? extends Arg> argConverter = EzMybatisContent.getConverter(configuration,
                    arg.getClass());
            sqlBuilder.append(argConverter.buildSql(type, new StringBuilder(), configuration, arg,
                    mybatisParamHolder));
            if (i + 1 < obj.getValues().size()) {
                sqlBuilder.append(", ");
            }
        }
        if (operator == Operator.in || operator == Operator.notIn) {
            sqlBuilder.append(")");
        }
        sqlBuilder.append(" ");
        return sqlBuilder;
    }

    private StringBuilder isBetweenBuild(StringBuilder leftSql, Type type, StringBuilder sqlBuilder,
                                         Configuration configuration, FormulaCompareArgCondition obj,
                                         MybatisParamHolder mybatisParamHolder) {
        Converter<? extends Arg> minArgConverter = EzMybatisContent.getConverter(configuration,
                obj.getMinValue().getClass());
        Converter<? extends Arg> maxArgConverter = EzMybatisContent.getConverter(configuration,
                obj.getMaxValue().getClass());
        return sqlBuilder.append(" ")
                .append(leftSql)
                .append(" ")
                .append(this.getOperatorStr(obj.getOperator()))
                .append(" ")
                .append(minArgConverter.buildSql(type, new StringBuilder(), configuration, obj.getMinValue(),
                        mybatisParamHolder))
                .append(" AND ")
                .append(maxArgConverter.buildSql(type, new StringBuilder(), configuration, obj.getMaxValue(),
                        mybatisParamHolder)).append(" ");
    }

    private StringBuilder isNullBuild(StringBuilder leftSql, StringBuilder sqlBuilder, FormulaCompareArgCondition obj) {
        Operator operator = obj.getOperator();
        return sqlBuilder.append(" ")
                .append(leftSql)
                .append(" ")
                .append(this.getOperatorStr(operator))
                .append(" ");
    }

    @Override
    public DbType getSupportDbType() {
        return DbType.MYSQL;
    }
}
