package timeman.timemanagement.DA;

/**
 * Created by manisha on 21/3/17.
 */
public class Task {
    private String taskItem,time,date;
    public Task(){

    }
    public Task(String taskItem,String date,String time){
        this.taskItem=taskItem;
        this.date=date;
        this.time=time;
    }


    public String getTaskItem() {
        return taskItem;
    }

    public void setTaskItem(String taskItem) {
        this.taskItem = taskItem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
