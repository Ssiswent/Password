package com.ssiswent.android.password;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AccountListFragment extends Fragment {

    private RecyclerView mAccountRecyclerView;
    private AccountAdapter mAdapter;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_list,container,false);

        mAccountRecyclerView =  view.findViewById(R.id.account_recycler_view);
        mAccountRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        AccountLab accountLab = AccountLab.get(getActivity());
        List<Account> accounts = accountLab.getAccounts();

        mAdapter = new AccountAdapter(accounts);
        mAccountRecyclerView.setAdapter(mAdapter);
    }

    private class AccountHolder extends RecyclerView.ViewHolder{

        private TextView mTitleTextView;
        private TextView mUserTextVIew;
        private Account mAccount;

        public AccountHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_account,parent,false));

            mTitleTextView = (TextView) itemView.findViewById(R.id.account_title);
            mUserTextVIew = (TextView) itemView.findViewById(R.id.account_username);
        }

        public void bind(Account account){
            mAccount = account;
            mTitleTextView.setText(mAccount.getTitle());
            mUserTextVIew.setText(mAccount.getUser());
        }
    }

    private class AccountAdapter extends RecyclerView.Adapter<AccountHolder>{
        private List<Account> mAccounts;

        public AccountAdapter(List<Account> accounts){
            mAccounts = accounts;
        }


        @Override
        public AccountHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AccountHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder( AccountHolder holder, int position) {
            Account account = mAccounts.get(position);
            holder.bind(account);

        }

        @Override
        public int getItemCount() {
            return mAccounts.size();
        }
    }
}
