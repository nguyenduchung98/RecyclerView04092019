package nguyenduchung.ndh.recyclerview04092019;

import android.view.View;

import androidx.annotation.NonNull;

public interface OnItemClickListener {
    void onClick(View v ,@NonNull int position);
    void onLongClick(View v ,@NonNull int position);
}
