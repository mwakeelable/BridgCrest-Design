package com.trianglz.bridgecrestdesign.model.SortableTable;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.trianglz.bridgecrestdesign.R;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.SortStateViewProviders;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

/**
 * Created by wakeel on 14/07/16.
 */
public class SortableSleepTableView extends SortableTableView<Sleep> {
    Typeface tf;

    public SortableSleepTableView(final Context context) {
        this(context, null);
        tf = Typeface.createFromAsset(context.getAssets(), "fonts/Comfortaa-Light.ttf");
    }

    public SortableSleepTableView(final Context context, final AttributeSet attributes) {
        this(context, attributes, android.R.attr.listViewStyle);
    }

    public SortableSleepTableView(final Context context, final AttributeSet attributes, final int styleAttributes) {
        super(context, attributes, styleAttributes);
        final SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(context, "Date", "Quality", "Slept", "Interrupts");
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context, R.color.table_header_text));
        simpleTableHeaderAdapter.setTextSize(12);
        setHeaderAdapter(simpleTableHeaderAdapter);

        final int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        final int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());
        setMinimumHeight(15);

        setColumnWeight(0, 3);
        setColumnWeight(1, 2);
        setColumnWeight(2, 2);
        setColumnWeight(3, 2);

        setColumnComparator(0, SleepComparators.getSleepDateComparator());
        setColumnComparator(1, SleepComparators.getSleepRatioComparator());
        setColumnComparator(2, SleepComparators.getSleepTotalComparator());
        setColumnComparator(3, SleepComparators.getSleepRatingsComparator());
    }
}
