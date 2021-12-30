package soft.gen.studentapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONArray;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import soft.gen.studentapp.R;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.Holder> {
    private JSONArray jsonArray;
    private Context context;
    private LayoutInflater layoutInflater;

    public TeacherAdapter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new Holder(layoutInflater.inflate(R.layout.item_teacher, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.teacher_name.setText("Pradeep Rai");
        holder.teacher_email.setText("raipradeep009@gmail.com");
        holder.teacher_phone_number.setText("7905307223");
        holder.teacher_subject.setText("English");

    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public class Holder extends RecyclerView.ViewHolder {
        TextView teacher_name;
        TextView teacher_email;
        TextView teacher_phone_number;
        TextView teacher_subject;
        public Holder(@NonNull View itemView) {
            super(itemView);
            this.teacher_name = itemView.findViewById(R.id.teacher_name);
            this.teacher_email = itemView.findViewById(R.id.teacher_email);
            this.teacher_phone_number = itemView.findViewById(R.id.teacher_phone_number);
            this.teacher_subject = itemView.findViewById(R.id.teacher_subject);

        }
    }
}
