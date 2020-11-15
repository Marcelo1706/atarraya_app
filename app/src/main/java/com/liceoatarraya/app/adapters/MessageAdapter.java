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
import com.liceoatarraya.app.models.MessageModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<MessageModel> {

    public MessageAdapter (Context context, List<MessageModel> objects){
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.message_item, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.messageIcon);
        TextView description = convertView.findViewById(R.id.messageDescription);
        TextView user = convertView.findViewById(R.id.messageUser);
        TextView timestamp = convertView.findViewById(R.id.messageTimestamp);

        MessageModel model = getItem(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        description.setText(model.getContent());
        timestamp.setText(sdf.format(model.getDatetime()));
        user.setText(model.getUser());


        return convertView;
    }
}
