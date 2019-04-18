package com.example.savememoney;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.savememoney.ui.accountview.ListFragment;
import com.example.savememoney.ui.accountview.Accounts.AccountContent;

public class AccountView extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //add navigation here
                    return true;
                case R.id.navigation_dashboard:
                    //add navigation here
                    return true;
                case R.id.navigation_notifications:
                    //add navigation here
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tabbed);
        setContentView(R.layout.account_view_activity);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(AccountContent.AccountItem item) {

    }


}
