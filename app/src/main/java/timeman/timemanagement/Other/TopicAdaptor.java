package timeman.timemanagement.Other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import timeman.timemanagement.R;

/**
 * Created by manisha on 3/4/17.
 */
public class TopicAdaptor extends BaseAdapter{
    LayoutInflater inflater;
    ArrayList<HashMap<String,String>> topicList;

    public TopicAdaptor(Context context,ArrayList<HashMap<String,String>>topicList,int baseadaptortype){
    this.topicList=topicList;
    inflater = LayoutInflater.from(context);
}

    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Object getItem(int position) {
        return topicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.ui_topics,null);
            TextView topicName= (TextView) convertView.findViewById(R.id.topicid);
            if(topicList.get(position).containsKey("topic")){
                String topic=topicList.get(position).get("topic");
                topicName.setText( topic);
            }

        }else{
            v=convertView;
        }


        return convertView
                ;
    }

    class GridViewHolder{
        public TextView topicName;

    }
}
