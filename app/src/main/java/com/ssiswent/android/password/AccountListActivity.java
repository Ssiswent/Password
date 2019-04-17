package com.ssiswent.android.password;

import androidx.fragment.app.Fragment;

public class AccountListActivity extends SingleFramentActivity {
    @Override
    protected Fragment createFragment() {
        return new AccountListFragment();
    }
}
