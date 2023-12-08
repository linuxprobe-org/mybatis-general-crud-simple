package org.rdlinux.oracle;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.rdlinux.ezmybatis.core.EzQuery;
import org.rdlinux.ezmybatis.core.EzUpdate;
import org.rdlinux.ezmybatis.core.mapper.EzMapper;
import org.rdlinux.ezmybatis.core.sqlstruct.formula.Formula;
import org.rdlinux.ezmybatis.core.sqlstruct.table.DbTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.EntityTable;
import org.rdlinux.ezmybatis.core.sqlstruct.table.EzQueryTable;
import org.rdlinux.ezmybatis.expand.oracle.update.Merge;
import org.rdlinux.ezmybatis.java.entity.User;
import org.rdlinux.ezmybatis.java.mapper.UserMapper;
import org.rdlinux.ezmybatis.utils.StringHashMap;

import java.util.LinkedList;
import java.util.List;

@Log4j2
public class OracleUpdateTest extends OracleBaseTest {
    @Test
    public void update() {
        User user = new User();
        user.setId("016cdcdd76f94879ab3d24850514812b");
        user.setName("王二");
        user.setName("王");
        user.setUserAge(27);
        user.setSex(User.Sex.MAN);
        int insert = OracleBaseTest.sqlSession.getMapper(UserMapper.class).update(user);
        OracleBaseTest.sqlSession.commit();
        System.out.println(insert);
    }

    @Test
    public void batchUpdate() {
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId("016cdcdd76f94879ab3d24850514812b");
            user.setName("芳" + i + 1);
            if (i == 0) {
                user.setSex(User.Sex.MAN);
            } else {
                user.setUserAge(i);
            }
            users.add(user);
        }
        int insert = OracleBaseTest.sqlSession.getMapper(UserMapper.class).batchUpdate(users);
        OracleBaseTest.sqlSession.commit();
        System.out.println(insert);
    }

    @Test
    public void replace() {
        User user = new User();
        user.setId("016cdcdd76f94879ab3d24850514812b");
        user.setName("王二");
        int insert = OracleBaseTest.sqlSession.getMapper(UserMapper.class).replace(user);
        OracleBaseTest.sqlSession.commit();
        System.out.println(insert);
    }

    @Test
    public void batchReplace() {
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId("016cdcdd76f94879ab3d24850514812b");
            user.setName("芳" + i + 1);
            if (i == 0) {
                user.setSex(User.Sex.MAN);
            } else {
                user.setUserAge(i);
            }
            users.add(user);
        }
        int insert = OracleBaseTest.sqlSession.getMapper(UserMapper.class).batchReplace(users);
        OracleBaseTest.sqlSession.commit();
        System.out.println(insert);
    }

    @Test
    public void updateByEzParam() {
        EzMapper mapper = OracleBaseTest.sqlSession.getMapper(EzMapper.class);
        EzUpdate ezUpdate = EzUpdate.update(EntityTable.of(User.class))
                .set().setField("userAge", 1).done()
                .where().addFieldCondition("id", "1").done()
                .build();
        int ret = mapper.ezUpdate(ezUpdate);
        OracleBaseTest.sqlSession.commit();
        log.info("更新条数{}", ret);
    }

    @Test
    public void batchUpdateByEzParam() {
        List<EzUpdate> updates = new LinkedList<>();
        EzMapper mapper = OracleBaseTest.sqlSession.getMapper(EzMapper.class);
        EzUpdate ezUpdate = EzUpdate.update(EntityTable.of(User.class))
                .set().setField("userAge", 1).done()
                .where().addFieldCondition("id", "1").done()
                .build();
        updates.add(ezUpdate);
        ezUpdate = EzUpdate.update(EntityTable.of(User.class))
                .set().setField("userAge", 2).done()
                .where().addFieldCondition("id", "2").done()
                .build();
        updates.add(ezUpdate);
        mapper.batchUpdate(updates);
        OracleBaseTest.sqlSession.commit();
    }

    @Test
    public void unionUpdate() {
        DbTable listTable = DbTable.of("A");
        EzQuery<StringHashMap> query = EzQuery.builder(StringHashMap.class).from(DbTable.of("B"))
                .select().addColumn("NAME", "T1PN").done()
                .select(listTable).addColumn("NAME", "T2PN").done()
                .join(listTable)
                .addColumnCompareCondition("CODE", "CODE").done().build();
        EzQueryTable queryTable = EzQueryTable.of(query);
        EzUpdate ezUpdate = EzUpdate.update(queryTable)
                .set().setColumn("T2PN", "T1PN")
                .done()
                .build();
        EzMapper mapper = OracleBaseTest.sqlSession.getMapper(EzMapper.class);
        mapper.ezUpdate(ezUpdate);
    }

    @Test
    public void mergeUpdate() {
        DbTable mergeTable = DbTable.of("PYA_INFO");
        DbTable recordTable = DbTable.of("PAY_RECORD");
        EzQuery<StringHashMap> useQuery = EzQuery.builder(StringHashMap.class)
                .from(mergeTable)
                .select()
                .addColumnMax("ID", "ID")
                .done()

                .select(recordTable)
                .addColumnSum("AMT", "AMT")
                .done()

                .join(recordTable)
                .addColumnCompareCondition("CODE", "CODE")
                .done()
                .where()
                .addColumnCondition("CODE", "1")
                .done()

                .groupBy(recordTable)
                .addColumn("CODE")
                .done()

                .build();
        EzQueryTable useTable = EzQueryTable.of(useQuery);
        Merge merge = Merge.into(mergeTable).using(useTable)
                .on()
                .addColumnCompareCondition("ID", "ID")
                .done()
                .set()
                .setColumn("PAY_AMT", Formula.builder(useTable).withColumn("PAY_AMT").done().build())
                .done().build();
        EzMapper mapper = OracleBaseTest.sqlSession.getMapper(EzMapper.class);
        Integer integer = mapper.expandUpdate(merge);
        System.out.println(integer);
    }
}
