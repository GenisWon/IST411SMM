package com.example.savememoney.ui.budgetfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetContent {

    public static final List<BudgetItem> BudgetList = new ArrayList<>();

    public static final Map<Integer, BudgetItem> ITEM_MAP = new HashMap<Integer, BudgetItem>();

    static {
        addItem(createBudgetItem(1, "Immediate Expenses", 200));
        addItem(createBudgetItem(2, "Debt Payments", 750));
        addItem(createBudgetItem(3, "Quality of Life Goals", 1000));
        addItem(createBudgetItem(4, "Fun Money", 150));
        addItem(createBudgetItem(5, "Subscriptions", 30));
        addItem(createBudgetItem(6, "Credit Card Payments", 230));
    }

    public static void addItem(BudgetItem item)
    {
        BudgetList.add(item);
        ITEM_MAP.put(item.intID, item);
    }

    private static BudgetItem createBudgetItem(int position, String strTitle, double dblBalance)
    {
        return new BudgetItem(position, strTitle, dblBalance);
    }

    public static class BudgetItem {
        public int intID;
        public String strTitle;
        public double dblBalance;

        public BudgetItem(int intID, String strTitle, double dblBalance)
        {
            this.intID = intID;
            this.strTitle = strTitle;
            this.dblBalance = dblBalance;
        }
    }
}
