package com.kari.love.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kari.love.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;


public class GridImageAdapter extends ArrayAdapter<String>{

    private Context mcontext;
    private LayoutInflater minflater;
    private int layoutResource;
    private String mappend;
    private ArrayList<String> imgURLs;

    public GridImageAdapter(Context mcontext, int layoutResource, String mappend, ArrayList<String> imgURLs) {
        super(mcontext, layoutResource, imgURLs);
        this.minflater = (LayoutInflater) mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
        this.mcontext = mcontext;
        this.layoutResource = layoutResource;
        this.mappend = mappend;
        this.imgURLs = imgURLs;
    }

   private static class ViewHolder{
        SquareImageView image;
        ProgressBar mprogressBar;
       SquareImageView image1;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;

        /*
        view holder build pattern (Similar to recycle view)
         */
        if(convertView == null){
            convertView = minflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();
            holder.mprogressBar = (ProgressBar) convertView.findViewById(R.id.gridImageProgressBar);
            holder.image = (SquareImageView) convertView.findViewById(R.id.gridImageView);
            //holder.image1 = (SquareImageView) convertView.findViewById(R.id.cover_photo);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        String imgURL = getItem(position);

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(mappend + imgURL, holder.image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(holder.mprogressBar != null){
                    holder.mprogressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(holder.mprogressBar != null){
                    holder.mprogressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(holder.mprogressBar != null){
                    holder.mprogressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(holder.mprogressBar != null){
                    holder.mprogressBar.setVisibility(View.GONE);
                }

            }
        });


        return convertView;
    }
}
