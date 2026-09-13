package com.george.mapper;

import com.george.po.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    Account selectAccount(int id);

    List<Account> selectAllAccount();

    //使用Param注解,arg0,arg1...失效
    int updateAccount(@Param("balance") double balance, @Param("id") int id);

    int insertAccount(Account account);

    int deleteAccount(int id);
}
