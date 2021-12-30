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

public class FeesAdapter extends RecyclerView.Adapter<FeesAdapter.Holder> {
    private JSONArray jsonArray;
    private Context context;
    private LayoutInflater layoutInflater;

    public FeesAdapter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Holder(layoutInflater.inflate(R.layout.fees_item_monthly, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.class_month.setText("Class-1 April Month Fees");
        holder.txtv_total_amount.setText("Rs 6000");
        holder.txtv_paid_or_not.setText("Paid");
        holder.txtv_pay_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Click Pay Fees", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView class_month;
        TextView txtv_total_amount,txtv_paid_or_not, txtv_pay_fees;

        public Holder(@NonNull View itemView) {
            super(itemView);
            this.class_month = itemView.findViewById(R.id.class_month);
            this.txtv_total_amount = itemView.findViewById(R.id.txtv_total_amount);
            this.txtv_paid_or_not = itemView.findViewById(R.id.txtv_paid_or_not);
            this.txtv_pay_fees = itemView.findViewById(R.id.txtv_pay_fees);

        }
    }
}
