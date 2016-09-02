package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import io.realm.RealmObject;
import jp.yitt.bluetoothlowenergytest.databinding.ListItemLengthBinding;
import jp.yitt.bluetoothlowenergytest.model.LengthData;

/**
 * Created by genm1023 on 8/31/16.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    public Context context;
    private List<RealmObject> items;

    public MainListAdapter(final Context context, List<RealmObject> items){
        this.context = context;
        this.items = items;
    }

    public MainListAdapter(List<RealmObject> items) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ListItemLengthBinding binding = ListItemLengthBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        View v;
        //0 l,1 a,2 C
        if (viewType == 0) {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_length, parent, false);

        } else if(viewType == 1){
            v = LayoutInflater.from(context).inflate(R.layout.list_item_area, parent, false);
        }else{
            v = LayoutInflater.from(context).inflate(R.layout.list_item_object, parent, false);
        }

        return new ViewHolder(v,binding, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(items.get(0) instanceof LengthData) {
            LengthData item = (LengthData) items.get(position);
            holder.listItemLengthBinding.setModel(item);
            holder.listItemLengthBinding.executePendingBindings();
        }else {
        }

        //holder.listItemLengthBinding.notifyPropertyChanged(position);



    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        final ListItemLengthBinding listItemLengthBinding;

        public ViewHolder(View v ,ListItemLengthBinding binding, int viewType){
            super(binding.getRoot());
            this.listItemLengthBinding = binding;
        }



    }



}
