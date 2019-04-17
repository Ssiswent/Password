package com.ssiswent.android.password;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AccountLab {
    private static AccountLab sAccountLab;

    private List<Account> mAccounts;

    public static AccountLab get(Context context){
        if(sAccountLab == null){
            sAccountLab = new AccountLab(context);
        }
        return sAccountLab;
    }

    private  AccountLab(Context context){
        mAccounts = new ArrayList<>();
        for(int i=0;i<100;i++){
            Account account = new Account();
            account.setId(i);
            account.setGroup(i%5);
            account.setTitle("Account #" + i);
            account.setUser("User #" + i);
            mAccounts.add(account);
        }
    }

    public List<Account> getAccounts(){
        return mAccounts;
    }

    public Account getAccount(int id){
        for(Account account : mAccounts){
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }
}
