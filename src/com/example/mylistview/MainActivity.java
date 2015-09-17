package com.example.mylistview;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

  /*
   * 
   * 1 ListView BaseAdapter DataSource 列表 适配器 数据源
   * 巨坑 外面只有包上线性布局才会显示
   * 
   */

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView listView = (ListView) findViewById(R.id.list);

    List<Model> models = new ArrayList<Model>();

    for (int i = 0; i < 400; i++) {

      Model model = new Model("key" + i, "2012" + i);
      models.add(model);
    }
    
    MyAdapter1 adapter = new MyAdapter1(getApplicationContext(), models);
    
    listView.setAdapter(adapter);
    
    
    

  }

}
