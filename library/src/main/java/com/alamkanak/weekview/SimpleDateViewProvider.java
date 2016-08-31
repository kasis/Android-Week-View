package com.alamkanak.weekview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Simple {@link WeekView.DateViewProvider} that displays date as a {@link TextView}
 * in the specified format.
 */
public class SimpleDateViewProvider implements WeekView.DateViewProvider<SimpleDateViewProvider.DateHolder> {

    Context mContext;
    DateFormat mDateFormat;

    public SimpleDateViewProvider(Context context, DateFormat dateFormat) {
        mDateFormat = dateFormat;
        mContext = context;
    }

    @NonNull
    @Override
    public DateHolder getView(Calendar date, @Nullable DateHolder convertView) {
        DateHolder holder = convertView;
        if (convertView == null) {
            TextView view = new TextView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            holder = new DateHolder(view);
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
