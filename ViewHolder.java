package com.turetop.weilinli.util;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by oylz on 2014/9/18.
 */
public class ViewHolder {
    // I added a generic return type to reduce the casting noise in TABLE_CLIENT code

    /**
     * @params convertView 每个item的视图
     * @id ResId 控件id
     */
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View convertView, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
