package gr.athtech.course.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athtech.course.databinding.HolderSecondItemBinding;

public class SecondViewHolder extends RecyclerView.ViewHolder {

    private HolderSecondItemBinding binding;

    public SecondViewHolder(@NonNull HolderSecondItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String data) {
        binding.holderText.setText(data);
    }
}
