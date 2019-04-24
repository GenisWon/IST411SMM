package com.example.savememoney.ui.reportfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.savememoney.R;
import com.example.savememoney.ReportFragment.OnReportFragmentInteractionListener;
import com.jjoe64.graphview.GraphView;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.example.savememoney.ui.reportfragment.ReportContent.ReportItem} and makes a call to the
 * specified {@link OnReportFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyReportRecyclerViewAdapter extends RecyclerView.Adapter<MyReportRecyclerViewAdapter.ViewHolder> {

    private final List<ReportContent.ReportItem> mValues;
    private final OnReportFragmentInteractionListener mListener;

    public MyReportRecyclerViewAdapter(List<ReportContent.ReportItem> items, OnReportFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_report, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).strTitle);
        holder.mContentView.setText(Double.toString(mValues.get(position).dblBalance));
        holder.graph.addSeries(mValues.get(position).series);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onReportFragmentInteraction(holder.mItem);
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
        public final GraphView graph;
        public ReportContent.ReportItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
            graph = view.findViewById(R.id.card_graph);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
