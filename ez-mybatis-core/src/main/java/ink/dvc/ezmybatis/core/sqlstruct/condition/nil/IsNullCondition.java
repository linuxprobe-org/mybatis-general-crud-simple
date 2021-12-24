package ink.dvc.ezmybatis.core.sqlstruct.condition.nil;

import ink.dvc.ezmybatis.core.sqlgenerate.MybatisParamHolder;
import ink.dvc.ezmybatis.core.sqlstruct.condition.Condition;
import ink.dvc.ezmybatis.core.sqlstruct.condition.Operator;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.Configuration;

/**
 * 是空条件
 */
public abstract class IsNullCondition implements Condition {
    @Getter
    protected Operator operator = Operator.isNull;
    @Getter
    @Setter
    protected LoginSymbol loginSymbol;

    protected abstract String getSqlField(Configuration configuration);

    @Override
    public String toSqlPart(Configuration configuration, MybatisParamHolder mybatisParamHolder) {
        return " " + this.getSqlField(configuration) + " " + this.operator.getOperator();
    }
}
