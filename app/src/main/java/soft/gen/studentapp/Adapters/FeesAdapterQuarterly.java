package soft.gen.studentapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import soft.gen.studentapp.R;

public class FeesAdapterQuarterly extends RecyclerView.Adapter<FeesAdapterQuarterly.Holder> {
    private JSONArray jsonArray;
    private Context context;
    private LayoutInflater layoutInflater;

    public FeesAdapterQuarterly(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }


    @NonNull
    @Override
    public FeesAdapterQuarterly.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return  new Holder(layoutInflater.inflate(R.layout.item_fees_quarterly, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.class_month_quarterly.setText("Class-1 April-June Month's Fee");
        holder.txtv_total_amount_quarterly.setText("Rs 6000");
        holder.txtv_paid_or_not_quarterly.setText("Paid");
        holder.txtv_pay_fees_quarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Click Pay Fees", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class Holder extends RecyclerView.ViewHolder {
        TextView class_month_quarterly;
        TextView txtv_total_amount_quarterly,txtv_paid_or_not_quarterly, txtv_pay_fees_quarterly;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.class_month_quarterly = itemView.findViewById(R.id.class_month_quarterly);
            this.txtv_total_amount_quarterly = itemView.findViewById(R.id.txtv_total_amount_quarterly);
            this.txtv_paid_or_not_quarterly = itemView.findViewById(R.id.txtv_paid_or_not_quarterly);
            this.txtv_pay_fees_quarterly = itemView.findViewById(R.id.txtv_pay_fees_quarterly);

        }
    }
}
