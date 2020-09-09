package com.dgyt.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanrongjie
 * @date 2020/9/9 下午9:32
 */
public class ObserverDP {

    public static void main(String[] args) {

        Button btn = new Button();
        btn.pressed();
    }

}


class Button{
  List<ActionListener> observers = new ArrayList<>();

  Button(){
      observers.add(new ListenerA());
      observers.add(new ListenerB());
  }
  public void pressed(){
      ActionEvent actionEvent = new ActionEvent();
      actionEvent.when = System.currentTimeMillis();
      actionEvent.source = this;
      for (ActionListener al :observers){
          al.actionPerformed(actionEvent);
      }
  }



}
interface ActionListener{
    void actionPerformed(ActionEvent actionEvent);

}
class ListenerA implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.printf("A %s  %d ",actionEvent.source,actionEvent.when);
    }
}
class ListenerB implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.printf("B %s %d",actionEvent.source,actionEvent.when);
    }
}
class ActionEvent{
    long when;
    Object source;
}