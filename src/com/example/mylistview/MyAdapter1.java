/*
 * MyAdapter1.java
 * classes : com.nolanlawson.customfastscrollviewdemo.MyAdapter1
 * @author  张奕
 * V 1.0.0
 * Create at 2015年8月19日 下午2:56:27
 */
package com.example.mylistview;


import com.example.mylistview.CustomFastScrollView.SectionIndexer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * com.nolanlawson.customfastscrollviewdemo.MyAdapter1
 * @author 张奕 <br/>
 * create at 2015年8月19日 下午2:56:27
 */
public class MyAdapter1 extends BaseAdapter implements SectionIndexer{
  private static final String TAG = "MyAdapter";

  private List<Model> countries;
  private Context context;
  private SectionIndexer sectionIndexer;

  public MyAdapter1(Context context, List<Model> countries) {

    this.context = context;
    this.countries = countries;

  }

  @Override
  public int getCount() {
    return countries.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    // 创建一个LinearLayout，并向其中添加2个组件
    LinearLayout line = new LinearLayout(context);
    line.setOrientation(0);
    ImageView image = new ImageView(context);
    image.setImageResource(R.drawable.ic_launcher);
    TextView text = new TextView(context);
    text.setText(countries.get(position).getKey());
    text.setTextSize(20);
    text.setTextColor(Color.RED);
    line.addView(image);
    line.addView(text);
    // 返回LinearLayout实例
    return line;

  }

  @Override
  public Object[] getSections() {
    return getSectionIndexer().getSections();
  }

  @Override
  public int getPositionForSection(int section) {
    return getSectionIndexer().getPositionForSection(section);
  }

  @Override
  public int getSectionForPosition(int position) {
    return getSectionIndexer().getSectionForPosition(position);
  }

  private SectionIndexer getSectionIndexer() {
    if (sectionIndexer == null) {
      sectionIndexer = createSectionIndexer(countries);
    }
    return sectionIndexer;
  }

  private SectionIndexer createSectionIndexer(List<Model> countries) {

    return createSectionIndexer(countries, new Function<Model, String>() {
      @Override
      public String apply(Model input) {
        // show just the first letter in the title
        //return input.getName().substring(0, 1);
        
        return input.getValue();
      }
    });
  }
  
  private SectionIndexer createSectionIndexer(List<Model> countries, Function<Model, String> sectionFunction) {

    List<String> sections = new ArrayList<String>();
    final List<Integer> sectionsToPositions = new ArrayList<Integer>();
    final List<Integer> positionsToSections = new ArrayList<Integer>();

    for (int i = 0; i < countries.size(); i++) {
      Model country = countries.get(i);
      String section = sectionFunction.apply(country);
      
      Log.i("TAG1", "section----" + section);
      
      if (sections.isEmpty() || !sections.get(sections.size() - 1).equals(section)) {
        sections.add(section);
        sectionsToPositions.add(i);
      }

      positionsToSections.add(sections.size() - 1);
    }

    final String[] sectionsArray = sections.toArray(new String[sections.size()]);

    return new SectionIndexer() {

      @Override
      public Object[] getSections() {
        return sectionsArray;
      }

      @Override
      public int getSectionForPosition(int position) {
        return positionsToSections.get(position);
      }

      @Override
      public int getPositionForSection(int section) {
        return sectionsToPositions.get(section);
      }
    };
  }
  
  
  
}
