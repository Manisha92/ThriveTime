package timeman.timemanagement.Other;

import android.os.Bundle;

import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.StackedBarChart;

import java.util.ArrayList;
import java.util.List;

import timeman.timemanagement.BaseActivity;
import timeman.timemanagement.R;

/**
 * Created by manisha on 24/3/17.
 */
public class Statistics extends BaseActivity {
    StackedBarChart stackBarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_layout);
        StackedBarChart stackBarChart = (StackedBarChart) findViewById(R.id.chart);
        List<ChartData> value = new ArrayList<>();

        Float[] value1 = {2f,3f,6f,5f };
        Float[] value2 = {3f,5f,7f,9f };

        value.add(new ChartData(value1, "Jone"));
        value.add(new ChartData(value2, "Joe"));

        List<String> h_lables = new ArrayList<>();
        h_lables.add("sun");
        h_lables.add("mon");
        h_lables.add("tue");
        h_lables.add("wed");

        stackBarChart.setLabels(h_lables);

        stackBarChart.setData(value);

        stackBarChart.setDescription("Stacked bar Chart");


    }
public void setYaxisLabels(){
    List labels=new ArrayList();
    labels.add("Mon");
    labels.add("Tue");
    labels.add("Wed");
    labels.add("Thur");
    stackBarChart.setLabels(labels);
    
}
    public void setDataRange( ){
                Float[] value3 = {1f,0f,1.5f,2f,3f };

        stackBarChart.setRange(value3);
    }
    public List getChartData() {
        List  value = new ArrayList();
                Float[] value1 = {2f,3f,6f,5f,5f };
                Float[] value2 = {3f,5f,7f,9f,2f };
        value.add(value1);
                value.add(value2);
        return value;
    }
}
