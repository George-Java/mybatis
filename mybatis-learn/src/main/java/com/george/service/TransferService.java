package com.george.service;

import com.george.mapper.AccountMapper;
import com.george.po.Account;
import com.george.util.SqlSessionUtil;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@RequiredArgsConstructor
public class TransferService {
    private final int fromAccountId;
    private final int toAccountId;
    private final double amount;
    SqlSession sqlSession;

    public int transfer() throws IOException {
        if (fromAccountId == toAccountId || fromAccountId < 1 || toAccountId < 1) {
            return -1;
        }

        sqlSession = SqlSessionUtil.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        Account fromAccount = accountMapper.selectAccount(fromAccountId);
        Account toAccount = accountMapper.selectAccount(toAccountId);

        if (fromAccount.balance < amount) {
            sqlSession.commit();
            sqlSession.close();
            return 1;
        } else {
            accountMapper.updateAccount(fromAccount.balance - amount, fromAccount.id);
            accountMapper.updateAccount(toAccount.balance + amount, toAccount.id);
            sqlSession.commit();
            sqlSession.close();
            return 0;
        }
    }
}