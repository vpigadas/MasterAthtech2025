package gr.athtech.course.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athtech.course.R;
import gr.athtech.course.databinding.HolderItemBinding;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<String> arrayData;

    public CustomAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item, parent, false);
        HolderItemBinding view = HolderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String data = arrayData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
