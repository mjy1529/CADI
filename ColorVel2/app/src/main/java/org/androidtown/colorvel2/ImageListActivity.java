package org.androidtown.colorvel2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        private Integer[] images = {R.drawable.image_03};

        public ImageAdapter(Context con) {
            this.context = con;
        }

        public int getCount() {
            return images.length;
        }

        public Object getItem(int pos) {
            return null;
        }

        public long getItemId(int pos) {
            return 0;
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView != null) {
                imageView = (ImageView)convertView;
            } else {

                //Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), images[pos]);
                //bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);

                imageView = new ImageView(context);
                imageView.setAdjustViewBounds(true);
                //imageView.setImageBitmap(bmp);

                ImageClickListener imageViewClickListener = new ImageClickListener(context, images[pos]);
                imageView.setOnClickListener(imageViewClickListener);
            }
            return imageView;
        }
    }

    public class ImageClickListener implements View.OnClickListener{
        Context context;
        int images;

        public ImageClickListener(Context context, int images){
            this.context = context;
            this.images = images;
        }

        public void onClick(View v){
            Intent intent2 = new Intent(context, ColoringActivity.class);
            intent2.putExtra("images", images);
            context.startActivity(intent2);
        }
    }
}