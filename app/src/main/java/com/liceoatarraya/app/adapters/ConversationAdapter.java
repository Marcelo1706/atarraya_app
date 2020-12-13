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
import com.liceoatarraya.app.models.ConversationModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConversationAdapter extends ArrayAdapter<ConversationModel> {
    public ConversationAdapter (Context context, List<ConversationModel> objects){
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ConversationModel model = getItem(position);
        if (convertView == null) {
            if (model.getUser().equals("juan")){
                convertView = inflater.inflate(R.layout.sender_message, parent, false);
            }else if ( model.getUser().equals("Luis")){
                convertView = inflater.inflate(R.layout.receiver_message, parent, false);
            }
        }

        ImageView icon;
        TextView user;
        TextView since;
        TextView content;

        if (model.getUser().equals("juan")){
            icon = convertView.findViewById(R.id.imgSnProfilePic);
            user = convertView.findViewById(R.id.tvSnUserName);
            since = convertView.findViewById(R.id.tvSnSince);
            content = convertView.findViewById(R.id.tvSnMessageContent);
            user.setText("Juan Perez");
        }else{
            icon = convertView.findViewById(R.id.imgRcProfilePic);
            user = convertView.findViewById(R.id.tvRcUserName);
            since = convertView.findViewById(R.id.tvRcSince);
            content = convertView.findViewById(R.id.tvRcMessageContent);
            user.setText("Luis Castellanos");
        }


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        content.setText(model.getContent());
        since.setText(sdf.format(model.getDatetimeSend()));
        //user.setText(model.getUser());


        return convertView;
    }
}
