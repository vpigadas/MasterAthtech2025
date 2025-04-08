package gr.athtech.course.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class CustomDiffUtil extends DiffUtil.ItemCallback<String> {
    @Override
    public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        if (oldItem.equals(newItem)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        if (oldItem.equals(newItem)) {
            return true;
        }
        return false;
    }
}
