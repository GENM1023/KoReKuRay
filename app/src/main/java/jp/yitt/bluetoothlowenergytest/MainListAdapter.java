package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import jp.yitt.bluetoothlowenergytest.databinding.ListItemLengthBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainListAdapter extends BaseAdapter{
    private LayoutInflater layoutInflater = null;
    private Context context;
    private ArrayList<LengthData> lengthList;


    public  MainListAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<LengthData> getLengthList(){

        int size = getCount();
        ArrayList<LengthData> lengthList = new ArrayList<LengthData>(size);
        for (int i=0; i < size; i++){
            lengthList.add(getItem(i));
        }
        return lengthList;
    }

    public void setLengthList(ArrayList<LengthData> lengthList){
        this.lengthList = lengthList;
    }
    @Override
    public int getCount() {
        return lengthList.size();
    }

    @Override
    public LengthData getItem(int position) {
        return lengthList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return lengthList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemLengthBinding binding;

        if(convertView == null){
            binding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item_length, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }else{
            binding = (ListItemLengthBinding)convertView.getTag();

        }
        binding.setModel(getItem(position));

        return convertView;
    }


}
