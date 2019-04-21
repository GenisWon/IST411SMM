package com.example.savememoney;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.savememoney.dummy.DummyContent;
import com.example.savememoney.ui.accountview.ListFragment;
import com.example.savememoney.ui.accountview.Accounts.AccountContent;

public class AccountView extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener, BudgetFragment.OnListFragmentInteractionListener, ReportFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_accounts:
                    selectedFragment = new ListFragment();
                    break;
                case R.id.navigation_home:
                    selectedFragment = new BudgetFragment();
                    break;
                case R.id.navigation_reports:
                    selectedFragment = new ReportFragment();
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

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListFragment()).commit();
    }

    @Override
    public void onListFragmentInteraction(AccountContent.AccountItem item) {

    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
