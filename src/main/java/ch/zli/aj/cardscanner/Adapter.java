package ch.zli.aj.cardscanner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private static final String TAG = "Adapter";

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static TextView textView;

        public TextView firstnameTextView;
        public TextView lastnameTextView;
        public TextView companyTextView;
        public TextView roleTextView;

        public ViewHolder(View view) {
            super(view);

            firstnameTextView = (TextView) view.findViewById(R.id.firstname);
            lastnameTextView = (TextView) view.findViewById(R.id.lastname);
            companyTextView = (TextView) view.findViewById(R.id.company);
            roleTextView = (TextView) view.findViewById(R.id.role);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked");
                }
            });

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public static TextView getTextView() {
            return textView;
        }
    }

    private List<Card> mCards;

    public Adapter(List<Card> cards) {
        mCards = cards;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recyclerView = inflater.inflate(R.layout.card_row_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(recyclerView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = mCards.get(position);

        TextView firstnameTextView = holder.firstnameTextView;
        TextView lastnameTextView = holder.lastnameTextView;
        TextView companyTextView = holder.companyTextView;
        TextView roleTextView = holder.roleTextView;
        firstnameTextView.setText(card.getFirstname());
        lastnameTextView.setText(card.getLastname());
        companyTextView.setText(card.getCompany());
        roleTextView.setText(card.getRole());
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }
}
