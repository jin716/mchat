package org.mchat.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingli on 16/7/4.
 */
public class Time {

    List<Long> times = new ArrayList<Long>();
    private int index = 0;


    public void reset(){
        this.times.clear();
    }

    public void point(){
        times.add(System.currentTimeMillis());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(100);
        for(int i = times.size() - 1 ; i > 0 ; --i ){
            long interval = times.get(i)-times.get(i-1);
            sb.append(interval).append(" Millis \r\n");
        }
        return sb.toString();
    }

    public String toString(int part){
        StringBuilder sb = new StringBuilder(100);
        for(int i = times.size() - 1 ; i > 0 ; --i ){
            long interval = times.get(i)-times.get(i-1);
            sb.append(interval).append(" Millis")
            .append(" each part").append(interval/part).append("\r\n");
        }
        return sb.toString();
    }



}
