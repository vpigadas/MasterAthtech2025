package gr.athtech.course.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athtech.course.databinding.HolderItemBinding;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    private HolderItemBinding binding;

    public CustomViewHolder(@NonNull HolderItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String data) {
        binding.holderText.setText(data);
//        TextView textView = itemView.findViewById(R.id.holder_text);
//        textView.setText(data);
    }
}
