package com.vasiachess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vasia-Lena on 28.12.2014.
 */
public class myAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;

    String[] mName = { "Name1", "Name2", "Name3", "Name4", "Name5", "Name6",
            "Name7", "Name8", "Name9", "Name10" };

    String[] mNumber = { "111111", "222222", "333333", "444444", "555555",
            "666666", "777777", "888888", "999999", "101010" };

    String[] mEmail = { "mail1@gmail.com", "mail2@gmail.com", "mail3@gmail.com", "mail4@gmail.com", "mail5@gmail.com",
            "mail6@gmail.com", "mail7@gmail.com", "mail8@gmail.com", "mail9@gmail.com", "mail10@gmail.com" };

    Integer[] mPhoto = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4,
            R.drawable.photo5, R.drawable.photo6, R.drawable.photo7, R.drawable.photo8, R.drawable.photo9,
            R.drawable.photo10,};


    public myAdapter(Context ctx) {
        mLayoutInflater = LayoutInflater.from(ctx);
    }

    public int getCount() {
        return mName.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public String getString(int position) {
        return mName[position] + " ( " + mNumber[position]+ ", " + mEmail[position] +" )";
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.list_item_contact, null);

        ImageView image = (ImageView) convertView.findViewById(R.id.photo);
        image.setImageResource(mPhoto[position]);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(mName[position]);

        TextView number = (TextView) convertView.findViewById(R.id.number);
        number.setText(mNumber[position]);

        TextView email = (TextView) convertView.findViewById(R.id.email);
        email.setText(mEmail[position]);

        return convertView;
    }
}
