package com.liceoatarraya.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.models.SubjectModel;

import java.util.List;

public class SubjectAdapter extends ArrayAdapter<SubjectModel> {
    public SubjectAdapter(Context context, List<SubjectModel> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.subject_item, parent, false);
        }

        TextView tvSubjectName = convertView.findViewById(R.id.tvSubjectName);

        SubjectModel model = getItem(position);
        tvSubjectName.setText(model.getName());

        return convertView;
    }
}
