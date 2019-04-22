package com.example.savememoney.ui.accountview.Accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountContent {

    public static final List<AccountItem> AccountList = new ArrayList<>();

    public static final Map<Integer, AccountItem> ITEM_MAP = new HashMap<Integer, AccountItem>();

    static {
        addItem(createAccountItem(1, "USAA Checking", 2000));
        addItem(createAccountItem(2, "Ally Savings", 500));
        addItem(createAccountItem(3, "Sallie Mae Student Loan A", -10000));
        addItem(createAccountItem(4, "Sallie Mae Student Loan B", -10000));
        addItem(createAccountItem(5, "Sallie Mae Student Loan C", -10000));
        addItem(createAccountItem(6, "Sallie Mae Student Loan D", -10000));
    }

    public static void addItem(AccountItem item)
    {
        AccountList.add(item);
        ITEM_MAP.put(item.intID, item);
    }

    private static AccountItem createAccountItem(int position, String strName, double dblBalance)
    {
        return new AccountItem(position, strName, dblBalance);
    }

    public static class AccountItem {
        public int intID;
        public String strName;
        public double dblBalance;

        public AccountItem(int intID, String strName, double dblBalance)
        {
            this.intID = intID;
            this.strName = strName;
            this.dblBalance = dblBalance;
        }
    }
}
