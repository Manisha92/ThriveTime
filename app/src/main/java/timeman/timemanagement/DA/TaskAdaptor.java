package timeman.timemanagement.DA;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import timeman.timemanagement.CustomListener;
import timeman.timemanagement.R;
import timeman.timemanagement.helper.ItemTouchHelperAdaptor;
import timeman.timemanagement.helper.ItemViewHolder;
import timeman.timemanagement.helper.OnStartDragListener;

/**
 * Created by manisha on 21/3/17.
 */

//Recycler View Adaptor for every upcoming list.
public class TaskAdaptor extends RecyclerView.Adapter<TaskAdaptor.MyViewHolder> implements ItemTouchHelperAdaptor {
    private final OnStartDragListener startDragListener;
    private  ArrayList<HashMap<String,String>> taskList;
    CustomListener listener;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_singlerow, parent, false);
        final MyViewHolder viewHolder=new MyViewHolder(itemView);
           itemView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View v) {
                   listener.onItemClick(v,viewHolder.getPosition());
                   return true;
               }
           });
        return viewHolder;
    }
    public TaskAdaptor(ArrayList<HashMap<String,String>> taskList,CustomListener listener,OnStartDragListener startDragListener){
        this.taskList=taskList;
        this.listener=listener;
        this.startDragListener=startDragListener;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if(taskList.get(position).containsKey("topic")){
            String topic=taskList.get(position).get("topic");
            holder.title.setText( topic);

        }
        holder.doneDate.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    startDragListener.onStartDrag(holder);
                }
                return false;
            }

        });


    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(taskList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        taskList.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder {
        public TextView title;
        public TextView doneDate;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            //date = (TextView) view.findViewById(R.id.date);
            doneDate = (TextView) view.findViewById(R.id.donedate);
        }

        @Override
        public void onItemSelected() {
            //itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
           // itemView.setBackgroundColor(0);
        }
    }
}
