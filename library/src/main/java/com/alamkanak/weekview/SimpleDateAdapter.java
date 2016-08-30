package com.alamkanak.weekview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Simple {@link com.alamkanak.weekview.WeekView.HeaderAdapter} that displays date as a {@link TextView}
 * in the specified format.
 */
public class SimpleDateAdapter implements WeekView.HeaderAdapter<SimpleDateAdapter.DateHolder> {

    Context mContext;
    DateFormat mDateFormat;

    public SimpleDateAdapter(Context context, DateFormat dateFormat) {
        mDateFormat = dateFormat;
        mContext = context;
    }

    @NonNull
    @Override
    public DateHolder getHeader(Calendar date, @Nullable DateHolder convertView) {
        DateHolder holder = convertView;
        if (convertView == null) {
            holder = new DateHolder(new TextView(mContext));
        }
        holder.getView().setText(mDateFormat.format(date.getTime()));
        return holder;
    }

    public static class DateHolder implements WeekView.ViewHolder {

        TextView mView;

        public DateHolder(TextView view) {
            mView = view;
        }

        @Override
        public TextView getView() {
            return mView;
        }
    }
}
