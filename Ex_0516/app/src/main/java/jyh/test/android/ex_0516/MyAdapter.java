package jyh.test.android.ex_0516;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jyh.test.android.ex_0516.R;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> arr;
    int resource;

    public MyAdapter(@NonNull Context context, int resource, ArrayList<String> arr) {
        super(context, resource, arr);
        this.context = context;
        this.arr = arr;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater linf = (LayoutInflater)context.getSystemService(
                                            Context.LAYOUT_INFLATER_SERVICE );
        convertView = linf.inflate( resource, null );

        String str = arr.get(position);

        TextView txt_form = convertView.findViewById(R.id.list_form_txt);
        txt_form.setText( str );

        return convertView;
    }
}














