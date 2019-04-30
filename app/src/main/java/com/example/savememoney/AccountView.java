package com.example.savememoney;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.savememoney.ui.accountview.ListFragment;
import com.example.savememoney.ui.accountview.Accounts.AccountContent;
import com.example.savememoney.ui.budgetfragment.BudgetContent;
import com.example.savememoney.ui.reportfragment.ReportContent;

public class AccountView extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener, BudgetFragment.OnBudgetFragmentInteractionListener, ReportFragment.OnReportFragmentInteractionListener {

    private TextView mTextMessage;
    private Fragment listFragment = new ListFragment();
    private Fragment budgetFragment;
    private Fragment reportFragment = new ReportFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_accounts:
                    selectedFragment = listFragment;
                    break;
                case R.id.navigation_home:
                    selectedFragment = budgetFragment;
                    break;
                case R.id.navigation_reports:
                    selectedFragment = reportFragment;
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tabbed);
        setContentView(R.layout.account_view_activity);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        budgetFragment = new BudgetFragment();



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment()).commit();
    }

    @Override
    public void onListFragmentInteraction(AccountContent.AccountItem item) {

    }


    @Override
    public void onReportFragmentInteraction(ReportContent.ReportItem item) {

    }

    @Override
    public void OnBudgetFragmentInteractionListener(BudgetContent.BudgetItem item) {

    }
}
