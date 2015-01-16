package com.vasiachess;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vasia-Lena on 28.12.2014.
 */
public class myFastAdapter extends BaseAdapter {

    String[] mName = { "Peter", "Alex", "Sam", "Kevin", "Sherlock", "John",
            "Roy", "Jack", "Bill", "Bob" };

    String[] mNumber = { "111111", "222222", "333333", "444444", "555555",
            "666666", "777777", "888888", "999999", "101010" };

    String[] mEmail = { "mail1@gmail.com", "mail2@gmail.com", "mail3@gmail.com", "mail4@gmail.com", "mail5@gmail.com",
            "mail6@gmail.com", "mail7@gmail.com", "mail8@gmail.com", "mail9@gmail.com", "mail10@gmail.com" };

    Integer[] mPhoto = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4,
            R.drawable.photo5, R.drawable.photo6, R.drawable.photo7, R.drawable.photo8, R.drawable.photo9,
            R.drawable.photo10,};


    private LayoutInflater mLayoutInflater;

    public myFastAdapter(Context ctx) {
        mLayoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String getString(int position) {
        return mName[position] + " ( " + mNumber[position]+ ", " + mEmail[position] +" )";
    }

    public String getName(int position) {
        return mName[position];
    }

    public String getNumber(int position) {
        return mNumber[position];
    }

    public String getEmail(int position) {
        return mEmail[position];
    }

    public String getInf(int position) {
        return "tel: " + mNumber[position]+ "\nemail: " + mEmail[position];
    }

    public Integer getPhoto(int position) {
        return mPhoto[position];
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

       ViewHolder viewHolder;

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_item_contact, null);

            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.name);
            viewHolder.tvPhone = (TextView) view.findViewById(R.id.number);
            viewHolder.tvEmail = (TextView) view.findViewById(R.id.email);
            viewHolder.ivPhoto = (ImageView) view.findViewById(R.id.photo);


            view.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvName.setText(mName[position]);
        viewHolder.tvPhone.setText(mNumber[position]);
        viewHolder.tvEmail.setText(mEmail[position]);
        viewHolder.ivPhoto.setImageResource(mPhoto[position]);

        return view;

    }


    public void SortbyName() {

        for(int i = mName.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (mName[j].compareTo(mName[j + 1])>0) {
                    ChangeCont(j);
                }
            }
        }
    }

    public void SortbyEmail() {

        for(int i = mEmail.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (mEmail[j].compareTo(mEmail[j + 1])>0) {
                    ChangeCont(j);
                }
            }
        }
    }

    public void SortbyNumber() {

        for(int i = mNumber.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (mNumber[j].compareTo(mNumber[j + 1])>0) {
                  ChangeCont(j);
                }
            }
        }
    }

    public void ChangeCont(int j) {
        String tmp = mName[j];
        mName[j] = mName[j + 1];
        mName[j + 1] = tmp;

        String nTmp = mNumber[j];
        mNumber[j] = mNumber[j + 1];
        mNumber[j + 1] = nTmp;

        String eTmp = mEmail[j];
        mEmail[j] = mEmail[j + 1];
        mEmail[j + 1] = eTmp;

        Integer pTmp = mPhoto[j];
        mPhoto[j] = mPhoto[j + 1];
        mPhoto[j + 1] = pTmp;
    }

    public void EditContact(int pos, String etName, String etNumber, String etEmail) {

        mName[pos]= etName;
        mNumber[pos]= etNumber;
        mEmail[pos]= etEmail;
    }

}
