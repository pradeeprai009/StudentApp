package soft.gen.studentapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import soft.gen.studentapp.Adapters.FeesAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackground(getResources().getDrawable(R.color.colorPrimary));
        setSupportActionBar(toolbar);



        findViewById(R.id.bell_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppShare();
            }
        });


        PrimaryDrawerItem leave = new PrimaryDrawerItem().withName("Leave Application").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.fees);
        PrimaryDrawerItem profile = new PrimaryDrawerItem().withName("Profile").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.man);
        PrimaryDrawerItem fees = new PrimaryDrawerItem().withName("Fees").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.fees);
        PrimaryDrawerItem timeTable = new PrimaryDrawerItem().withName("Time Table").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.timetableicon);
        PrimaryDrawerItem homework = new PrimaryDrawerItem().withName("Home Work").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.homework);
        PrimaryDrawerItem download = new PrimaryDrawerItem().withName("Download Center").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.download);
        PrimaryDrawerItem attendance = new PrimaryDrawerItem().withName("Attendance").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.markattendance);
        PrimaryDrawerItem report_card = new PrimaryDrawerItem().withName("Report Card").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.reportcard);
        PrimaryDrawerItem exam_schedule = new PrimaryDrawerItem().withName("Exam Schedule").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.exam);
        PrimaryDrawerItem notice_board = new PrimaryDrawerItem().withName("Notice Board").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.email);
        PrimaryDrawerItem timeline = new PrimaryDrawerItem().withName("Timeline").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.timeline);
        PrimaryDrawerItem my_documents = new PrimaryDrawerItem().withName("My Documents").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.mydocuments);
        PrimaryDrawerItem subjects = new PrimaryDrawerItem().withName("Subjects").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.subject);
        PrimaryDrawerItem teachers = new PrimaryDrawerItem().withName("Teachers").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.teacher);
        PrimaryDrawerItem library = new PrimaryDrawerItem().withName("Library").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.library);
        PrimaryDrawerItem transport_route = new PrimaryDrawerItem().withName("Transport Route").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.transport);
        PrimaryDrawerItem hostel = new PrimaryDrawerItem().withName("Hostels").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.hostel);
        PrimaryDrawerItem about_school = new PrimaryDrawerItem().withName("About School").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.about);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withName("Logout").withTextColorRes(R.color.colorPrimaryDark).withIcon(R.drawable.logout);

        IProfile profile3 = new ProfileDrawerItem().withName("Pradeep Rai")
                .withEmail("12th B").withIcon(R.drawable.man).withIdentifier(102);

        SecondaryDrawerItem test = new SecondaryDrawerItem().withName("Test").withIcon(FontAwesome.Icon.faw_suitcase);

        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimaryLight)
                .withTextColorRes(R.color.colorPrimaryDark)
                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
                        if (profile != null) {
                            Intent intent = null;
                            if (profile == profile3) {
                                intent = new Intent(MainActivity.this, Profile_user.class);
                                startActivity(intent);
                            }
                        }
                        return false;
                    }

                    @Override
                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .addProfiles(
                        profile3
                )
                .build();

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                        leave, profile, fees, timeTable, homework, download, attendance, report_card,
                        exam_schedule, notice_board, timeline, my_documents, subjects, teachers,
                        library, transport_route, hostel, about_school, logout,
                        new DividerDrawerItem()

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem == leave) {
                                intent = new Intent(MainActivity.this, AddLeave.class);
                                startActivity(intent);
                            } else if (drawerItem == profile) {
                                intent = new Intent(MainActivity.this, Profile_user.class);
                                startActivity(intent);
                            } else if (drawerItem == fees) {
                                intent = new Intent(MainActivity.this, Fees.class);
                                startActivity(intent);
                            } else if (drawerItem == attendance) {
                                intent = new Intent(MainActivity.this, Attendance.class);
                                startActivity(intent);
                            }else if(drawerItem==teachers){
                                 intent=new Intent(MainActivity.this,Teachers.class);
                                 startActivity(intent);
                            }
                        }
                        return false;
                    }
                })
                .build();
        result.addStickyFooterItem(new PrimaryDrawerItem().withName("StudentApp"));


        findViewById(R.id.attendance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Attendance.class);
                startActivity(intent);
            }
        });
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;

                case R.id.navigation_homework:
                    return true;

                case R.id.navigation_fees:
                    Intent intent = new Intent(MainActivity.this, Fees.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_notice:
                    return true;

                case R.id.navigation_Exam:
                    return true;

            }
            return false;
        }
    };

    public void AppShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This app: https://vimeo.com/365209870");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Sharing Option"));
        // startActivity(sendIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
