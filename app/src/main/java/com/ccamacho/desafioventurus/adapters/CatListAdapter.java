package com.ccamacho.desafioventurus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.model.GalleryData;
import com.ccamacho.desafioventurus.util.ImageUtil;

import java.util.List;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.CatListViewHolder> {

    List<GalleryData> galleryList;

    public CatListAdapter(List<GalleryData> galleryList) {
        this.galleryList = galleryList;
    }

    public void updateList(List<GalleryData> galleryList) {
        this.galleryList.clear();
        this.galleryList.addAll(galleryList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_list_item, parent, false);
        return new CatListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatListViewHolder holder, int position) {
        holder.bind(galleryList.get(position));
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    static class CatListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewTitle;

        public CatListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textView_title);
        }

        void bind(GalleryData gallery) {
            try {
                String url = gallery.getGalleryImageList().get(0).getLink();
                ImageUtil.setImageView(imageView, url);
                textViewTitle.setText(gallery.getTitle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
