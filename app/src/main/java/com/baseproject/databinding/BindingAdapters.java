package com.baseproject.databinding;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.baseproject.R;
import com.baseproject.data.remote.model.Resource;
import com.baseproject.ui.base.BaseAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

/**
 * Binding adapters
 * <p>
 */
final class BindingAdapters {

    private BindingAdapters() {
        // Private Constructor to hide the implicit one
    }

    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        if (resource == null || resource.getData() == null)
            return;

        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).setData((List) resource.getData());
        }
    }

    @BindingAdapter(value = "imageUrl")
    public static void loadImage(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext()
        ).asBitmap()
                .apply(new RequestOptions().fitCenter())
                .placeholder(R.drawable.ic_profile_placeholder)
                .load(imgUrl)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(final Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(imageView.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }
}
