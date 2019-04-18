package com.example.savememoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.savememoney.ui.accountview.ListFragment;
import com.example.savememoney.ui.accountview.Accounts.AccountContent;

public class AccountView extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_view_activity);
    }

    @Override
    public void onListFragmentInteraction(AccountContent.AccountItem item) {

    }
}
