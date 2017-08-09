package com.lauzy.freedom.librarys.imageload.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lauzy.freedom.librarys.imageload.IBaseImageStrategy;
import com.lauzy.freedom.librarys.imageload.ImageConfig;

/**
 * Desc : Glide Loader
 * Author : Lauzy
 * Date : 2017/6/30
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
public class GlideImageLoaderStrategy implements IBaseImageStrategy {

    @Override
    public void display(Context context, ImageConfig imageConfig) {

        RequestOptions options = new RequestOptions()
                .placeholder(imageConfig.getDefaultRes())
                .error(imageConfig.getErrorRes());
        if (imageConfig.isRound()) {
            if (imageConfig.getCornerSize() == 0) {
                options.transform(new GlideCornerTransformation(context));
            } else {
                options.transform(new GlideCornerTransformation(context, imageConfig.getCornerSize()));
            }
        }
        Glide.with(context).load(imageConfig.getUrl())
                .apply(options)
                .into(imageConfig.getImageView());
    }

    @Override
    public void clean(Context context, ImageConfig imageConfig) {
        Glide.with(context).clear(imageConfig.getImageView());
    }
}