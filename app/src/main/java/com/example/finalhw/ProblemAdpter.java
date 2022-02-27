package com.example.finalhw;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProblemAdpter extends ArrayAdapter<Problem> {
    Context context;
    List<Problem> problems;

    public ProblemAdpter(Context context, int resource,
                         int textViewResourceId, List<Problem> problems) {
        super(context, resource, textViewResourceId, problems);

        this.context = context;
        this.problems = problems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.row_listview_problems,
                parent, false);

        TextView tv_date = view.findViewById(R.id.tv_date_row);
        TextView tv_type = view.findViewById(R.id.tv_type_row);
        TextView tv_status = view.findViewById(R.id.tv_staus_row);

        Problem temp = problems.get(position);
        tv_date.setText(temp.getDate());
        tv_type.setText(temp.getType());
        tv_status.setText(""+temp.isStatus());
        return view;


    }
}
