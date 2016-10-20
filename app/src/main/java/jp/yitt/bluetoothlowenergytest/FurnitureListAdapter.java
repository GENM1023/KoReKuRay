package jp.yitt.bluetoothlowenergytest;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yaritakouhei on 2016/10/16.
 */
public class FurnitureListAdapter extends ArrayAdapter<FurnitureListItem> {
//public class FurnitureListAdapter extends  ArrayAdapter<String>{
        private LayoutInflater inflater;
        private List<FurnitureListItem> items;
        private int ListViewResourceId;
        // コンストラクタ
        public FurnitureListAdapter(Context context, int ListViewResourceId,  List<FurnitureListItem> fitems) {
            super(context, ListViewResourceId);
            //inflater = (LayoutInflater)super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.ListViewResourceId = ListViewResourceId;
            this.items = fitems;
            inflater = LayoutInflater.from(context);
            //item = newItem;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = inflater.inflate(R.layout.list_raw, parent, false);
            } else {
                view = convertView;
            }

            FurnitureListItem flt = this.items.get(position);
            TextView nameText = (TextView)view.findViewById(R.id.name);
            nameText.setText(flt.getName());

            nameText.setText(flt.getPrice());


            //String str = super.getItem(position);

//            // imageを取得
//            ImageView image = (ImageView)convertView.findViewById(R.id.imageId);
//            // 一旦仮の画像を入れておく
//            //Bitmap bmImg = BitmapFactory.decodeFile(R.drawable.ruler);
//            image.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ruler));
//            // 画像取得スレッド起動
//            ImageGetTask task = new ImageGetTask(image);
//            task.execute();

            return view;
        }


        // Image取得用スレッドクラス
        class ImageGetTask extends AsyncTask<String,Void,Bitmap> {
            private ImageView image;

            public ImageGetTask(ImageView _image) {
                image = _image;
            }
            @Override
            protected Bitmap doInBackground(String... params) {
                // ここでHttp経由で画像を取得します。取得後Bitmapで返します。
                return null;
            }
            @Override
            protected void onPostExecute(Bitmap result) {
                // 取得した画像をImageViewに設定します。
                image.setImageBitmap(result);
            }
        }

}
