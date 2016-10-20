package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.yitt.bluetoothlowenergytest.databinding.ListItemLengthBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainListAdapter extends BaseAdapter {
    LayoutInflater layoutInflater = null;
    public Context context;
    private List<LengthData> lengthList;

    public MainListAdapter(final Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // this.items = items;
    }


//    public MainListAdapter(List<RealmObject> items) {
//    }

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
        //Log.d("CHANGE_BOTTUN_TEST", String.valueOf(position));
        return convertView;
    }
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        ListItemLengthBinding binding = ListItemLengthBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//
//        View v;
//        //0 l,1 a,2 C
//        if (viewType == 0) {
//            v = LayoutInflater.from(context).inflate(R.layout.list_item_length, parent, false);
//
//        } else if(viewType == 1){
//            v = LayoutInflater.from(context).inflate(R.layout.list_item_area, parent, false);
//        }else{
//            v = LayoutInflater.from(context).inflate(R.layout.list_item_object, parent, false);
//        }
//
//        return new ViewHolder(v,binding, viewType);
//    }

//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        if(items.get(0) instanceof LengthData) {
//            LengthData item = (LengthData) items.get(position);
//            holder.listItemLengthBinding.setModel(item);
//            holder.listItemLengthBinding.executePendingBindings();
//        }else {
//        }
//
//        //holder.listItemLengthBinding.notifyPropertyChanged(position);
//
//
//
//    }

//    @Override
//    public int getItemCount(){
//        return items.size();
//    }
//


}
