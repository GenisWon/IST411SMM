package com.example.savememoney.ui.budgetfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.savememoney.BudgetFragment.OnBudgetFragmentInteractionListener;
import com.example.savememoney.R;
import com.example.savememoney.ui.budgetfragment.BudgetContent.BudgetItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link BudgetItem} and makes a call to the
 * specified {@link OnBudgetFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBudgetRecyclerViewAdapter extends RecyclerView.Adapter<MyBudgetRecyclerViewAdapter.ViewHolder> {

    private final List<BudgetItem> mValues;
    private final OnBudgetFragmentInteractionListener mListener;

    public MyBudgetRecyclerViewAdapter(List<BudgetItem> items, OnBudgetFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).strTitle);
        holder.mContentView.setText((Double.toString(mValues.get(position).dblBalance)));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.OnBudgetFragmentInteractionListener(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public BudgetItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}