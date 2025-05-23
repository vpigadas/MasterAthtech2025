package gr.athtech.course.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athtech.course.databinding.HolderItemBinding;
import gr.athtech.course.databinding.HolderSecondItemBinding;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> arrayData;

    public CustomAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            HolderItemBinding view = HolderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new CustomViewHolder(view);
        } else if (viewType == 1) {
            HolderSecondItemBinding view = HolderSecondItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SecondViewHolder(view);
        } else {
            HolderItemBinding view = HolderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new CustomViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String data = arrayData.get(position);
        if (holder instanceof CustomViewHolder) {
            ((CustomViewHolder) holder).bind(data);
        } else if (holder instanceof SecondViewHolder) {
            ((SecondViewHolder) holder).bind(data);
        }
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return 1;
        }

        return super.getItemViewType(position);
    }
}
