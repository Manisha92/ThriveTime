package DA;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import timeman.timemanagement.R;

/**
 * Created by manisha on 21/3/17.
 */
public class TaskAdaptor extends RecyclerView.Adapter<TaskAdaptor.MyViewHolder> {
    private  List<Task> taskList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_singlerow, parent, false);

        return new MyViewHolder(itemView);
    }
    public TaskAdaptor(List<Task> taskList){
        this.taskList=taskList;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                Task task=taskList.get(position);
                holder.title.setText(task.getTaskItem());
                holder.date.setText(task.getDate());
                holder.time.setText(task.getTime());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, time;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            time = (TextView) view.findViewById(R.id.time);
        }
    }
}
