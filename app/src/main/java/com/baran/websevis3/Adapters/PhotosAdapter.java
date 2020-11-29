package com.baran.websevis3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baran.websevis3.Models.PhotosModel;
import com.baran.websevis3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosAdapter extends BaseAdapter {

    List<PhotosModel> list;
    Context context;

    public PhotosAdapter(List<PhotosModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.layout_photos, parent, false);

        TextView userIdText, idText, titleText, imgText;
        ImageView thumImg;

        userIdText = convertView.findViewById(R.id.userId);
        idText = convertView.findViewById(R.id.id);
        titleText = convertView.findViewById(R.id.title);
        imgText = convertView.findViewById(R.id.image);
        thumImg = convertView.findViewById(R.id.thumbnailImg);

        userIdText.setText(list.get(position).getAlbumId() + "");
        idText.setText(list.get(position).getId() + "");
        titleText.setText(list.get(position).getTitle());
        imgText.setText(list.get(position).getUrl());
        Picasso.with(context).load(list.get(position).getThumbnailUrl()).into(thumImg);


        return convertView;
    }
}
