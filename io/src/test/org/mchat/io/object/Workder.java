package org.mchat.io.object;

import org.mchat.util.StringUtil;

/**
 * Created by jingli on 16/6/22.
 */
public class Workder extends Thread{

    @Override
    public void run() {
        StringBuilder sb = StringUtil.stringBuilder();
        System.out.println(sb.hashCode());
        for(int i = 0 ; i < 20 ; ++i){
            sb.append(i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        for(int i = 0 ; i < 5 ; ++i){
            new Workder().start();
        }
    }
}
