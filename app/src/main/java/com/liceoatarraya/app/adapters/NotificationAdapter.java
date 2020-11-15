package com.liceoatarraya.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.models.NotificationModel;
import com.liceoatarraya.app.models.NotificationSingleton;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotificationAdapter extends ArrayAdapter<NotificationModel> {

    public NotificationAdapter(Context context, List<NotificationModel> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position,View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.notification_item, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.notificationIcon);
        TextView description = convertView.findViewById(R.id.notificationDescription);
        TextView timestamp = convertView.findViewById(R.id.notificationTimestamp);

        NotificationModel model = getItem(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        description.setText(model.getDescription());
        timestamp.setText(sdf.format(model.getDatetime()));


        return convertView;
    }
}
