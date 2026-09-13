package com.george.mapper;

import com.george.po.Account;
import com.george.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class AccountMapperTest {
    @Test
    public void testSelectAccountById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        //Account account1 = new Account(1, "朱晓明", 8000);
        //Account account2 = new Account(2, "张一山", 60000);
        //int count1 = accountMapper.insertAccount(account1);
        //System.out.println("影响了" + count1 + "条数据");
        //int count2 = accountMapper.insertAccount(account2);
        //System.out.println("影响了" + count2 + "条数据");
        //
        //
        //System.out.println(accountMapper.selectAccount(1));
        //System.out.println(accountMapper.selectAccount(2));
        List<Account> accounts = accountMapper.selectAllAccount();
        accounts.forEach(System.out::println);

        sqlSession.commit();
        sqlSession.close();
    }
}
