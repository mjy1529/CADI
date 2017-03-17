package org.androidtown.week6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by User on 2017-03-11.
 */

public class StudentAdapter extends BaseAdapter{

    private ArrayList<Student> stuList;
    private Context context;
    private TextView name;
    private TextView number;
    private LayoutInflater mLayoutInflater = null;
    private int layout = 0;
    private Button button;

    public StudentAdapter(ArrayList<Student> stuList, Context context, int layout) {
        this.stuList = stuList;
        this.context = context;
        this.layout = layout;
        this.mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stuList.size();
    }

    @Override
    public Object getItem(int position) {
        return stuList.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final int position = i;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(this.layout, parent, false);
        }
        name = (TextView)convertView.findViewById(R.id.stuName);
        number = (TextView)convertView.findViewById(R.id.stuNum);
        button = (Button)convertView.findViewById(R.id.button1);

        name.setText(stuList.get(position).getName());
        number.setText(stuList.get(position).getNumber());

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context,stuList.get(position).getName()+" / " + stuList.get(position).getNumber(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

}