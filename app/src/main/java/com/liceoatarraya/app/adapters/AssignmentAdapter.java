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
import com.liceoatarraya.app.models.AssignmentModel;

import java.util.List;

public class AssignmentAdapter extends ArrayAdapter<AssignmentModel> {
    public AssignmentAdapter(Context context, List<AssignmentModel> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.assignent_item, parent, false);
        }

        TextView tvAssignmentName = convertView.findViewById(R.id.tvAssignmentName);

        AssignmentModel model = getItem(position);

        tvAssignmentName.setText(model.getName());

        return convertView;
    }
}
