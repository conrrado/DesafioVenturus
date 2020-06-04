package com.ccamacho.desafioventurus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.model.Cat;

import java.util.List;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.CatListViewHolder> {

    List<Cat> catList;

    public CatListAdapter(List<Cat> catList) {
        this.catList = catList;
    }

    @NonNull
    @Override
    public CatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_list_item, parent, false);
        return new CatListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatListViewHolder holder, int position) {
        holder.bind(catList.get(position));
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    static class CatListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewTitle;

        public CatListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textView_title);
        }

        void bind(Cat cat) {
            try {
                String url = cat.getCatImageList().get(0).getLink();
                Glide.with(itemView.getContext())
                        .load(url)
                        .into(imageView);
                textViewTitle.setText(cat.getTitle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
