package timeman.timemanagement;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import DA.Task;
import DA.TaskAdaptor;

public class TaskActivity extends BaseActivity {
    private List<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TaskAdaptor mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        collapsingToolbarLayout.setTitle("Enter the title Here");



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter=new TaskAdaptor(taskList);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            recyclerView.setNestedScrollingEnabled(true);
        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

    }

    private void prepareMovieData() {
        Task task = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task1 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task2 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task3 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task4 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task5 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task); Task task6 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task); Task task7 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task); Task task8 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task9 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task10 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task11 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task12 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);
        Task task13 = new Task("Android and JAVA", "20-Mar-2017", "10A.M");
        taskList.add(task);





    }


}
