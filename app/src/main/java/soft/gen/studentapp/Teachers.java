package soft.gen.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import soft.gen.studentapp.Adapters.FeesAdapter;
import soft.gen.studentapp.Adapters.TeacherAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;

public class Teachers extends AppCompatActivity {
    RecyclerView recyclerView_teacher;

    TeacherAdapter teacherAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        recyclerView_teacher=findViewById(R.id.recyclerView_teacher);
        recyclerView_teacher.setAdapter(teacherAdapter);
        loadTeacherDetails();

        findViewById(R.id.back_button_teacher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @SuppressLint("WrongConstant")
    private void loadTeacherDetails() {
        JSONArray jsonArray = new JSONArray();
        teacherAdapter = new TeacherAdapter(jsonArray, getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyclerView_teacher.setLayoutManager(layoutManager);
        recyclerView_teacher.setItemAnimator(new DefaultItemAnimator());

       /*  GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyler_subjects.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView*/
        this.recyclerView_teacher.setAdapter(teacherAdapter);
    }
}
