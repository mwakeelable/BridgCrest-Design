package com.trianglz.bridgecrestdesign.model.SortableTable;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.codecrafters.tableview.TableDataAdapter;

/**
 * Created by wakeel on 14/07/16.
 */
public class SleepTableDataAdapter extends TableDataAdapter<Sleep> {
    private static final int TEXT_SIZE = 17;
    Typeface tf;

    public SleepTableDataAdapter(final Context context, final List<Sleep> data) {
        super(context, data);
        tf = Typeface.createFromAsset(context.getAssets(), "fonts/FreeFont.ttf");

    }

    @Override
    public View getCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        final Sleep sleep = getRowData(rowIndex);
        View renderedView = null;
        switch (columnIndex) {
            case 0:
                renderedView = renderDay(sleep);
                break;
            case 1:
                renderedView = renderSleeping(sleep);
                break;
            case 2:
                renderedView = renderTotal(sleep);
                break;
            case 3:
                renderedView = renderInterrupts(sleep);
                break;
        }

        return renderedView;
    }

    private View renderDay(final Sleep sleep) {
        return renderString(sleep.getDay());
    }

    private View renderSleeping (final Sleep sleep){
        return renderQualityString(String.valueOf(sleep.getQuality()));
    }

    private View renderTotal (final Sleep sleep){
        return renderTotalString(String.valueOf(sleep.getTotalSlept()));
    }

    private View renderInterrupts(final Sleep sleep){
        return renderQualityString(String.valueOf(sleep.getInterrupts()));
    }

    private View renderString(final String value) {
        final TextView textView = new TextView(getContext());
        textView.setText(value);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        textView.setTypeface(tf);
        return textView;
    }

    private View renderTotalString(final String value){
        final TextView textView = new TextView(getContext());
        textView.setText(value +" H");
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTypeface(tf);
        return textView;
    }

    private View renderQualityString (final String value){
        final TextView textView = new TextView(getContext());
        textView.setText(value +" %");
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTypeface(tf);
        return textView;
    }
}
