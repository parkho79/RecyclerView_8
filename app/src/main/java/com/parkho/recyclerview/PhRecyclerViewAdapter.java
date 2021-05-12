package com.parkho.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PhRecyclerViewAdapter extends RecyclerView.Adapter<PhRecyclerViewHolder> {

    public interface OnItemClickEventListener {
        void onItemClick(View a_view, int a_position);
    }

    private List<PhRecyclerItem> mItemList;

    private OnItemClickEventListener mItemClickListener;

    public PhRecyclerViewAdapter(List<PhRecyclerItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public PhRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_viewType) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.content_recycler_item, a_viewGroup, false);
        return new PhRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhRecyclerViewHolder a_viewHolder, int a_position) {
        final PhRecyclerItem item = mItemList.get(a_position);
        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}