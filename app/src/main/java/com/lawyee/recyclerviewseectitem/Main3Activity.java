package com.lawyee.recyclerviewseectitem;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory {

    private ImageSwitcher image_switcher;
    private Gallery gallery;
    private Integer[] mThumbIds = { R.drawable.a1, R.drawable.a2,
            R.drawable.a3, R.drawable.a4, R.drawable.a5,
    };
    private Integer[] mImageIds = { R.drawable.a1, R.drawable.a2,
            R.drawable.a3, R.drawable.a4, R.drawable.a5, };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);
        image_switcher = (ImageSwitcher) findViewById(R.id.switcher);
        image_switcher.setFactory(this);
        image_switcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        image_switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemSelectedListener(this);
    }
    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setBackgroundColor(0xFF000000);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setLayoutParams(new ImageSwitcher.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return image;
    }
    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }
        public int getCount() {
            return mThumbIds.length;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView image = new ImageView(mContext);
            image.setImageResource(mThumbIds[position]);
            image.setAdjustViewBounds(true);
            image.setLayoutParams(new Gallery.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return image;
        }
        private Context mContext;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        ImageSwitcher image_switcher = (ImageSwitcher) findViewById(R.id.switcher);
        image_switcher.setImageResource(mImageIds[position]);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}