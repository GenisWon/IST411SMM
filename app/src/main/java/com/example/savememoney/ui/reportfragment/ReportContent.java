package com.example.savememoney.ui.reportfragment;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportContent {

    public static final List<ReportItem> ReportList = new ArrayList<>();

    public static final Map<Integer, ReportItem> ITEM_MAP = new HashMap<Integer, ReportItem>();

    static {
        addItem(createReportItem(1, "Expenses", 0, new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        })));
        addItem(createReportItem(2, "Net Worth", 0, new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        })));
        addItem(createReportItem(3, "3rd", 0, new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        })));
        //addItem(createReportItem(2, "Income", 0));
        //addItem(createReportItem(3, "Debt", 0));
        //addItem(createReportItem(4, "Net Worth", 0));
    }

    public static void addItem(ReportItem item)
    {
        ReportList.add(item);
        ITEM_MAP.put(item.intID, item);
    }

    private static ReportItem createReportItem(int position, String strTitle, double dblBalance, LineGraphSeries<DataPoint> series)
    {
        return new ReportItem(position, strTitle, dblBalance, series);
    }

    public static class ReportItem {
        public int intID;
        public String strTitle;
        public double dblBalance;
        public LineGraphSeries<DataPoint> series;

        public ReportItem(int intID, String strTitle, double dblBalance, LineGraphSeries<DataPoint> series)
        {
            this.intID = intID;
            this.strTitle = strTitle;
            this.dblBalance = dblBalance;
            this.series = series;
        }
    }
}
