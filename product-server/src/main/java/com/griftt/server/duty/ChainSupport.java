package com.griftt.server.duty;

import com.griftt.server.duty.proceschain.CopyRight;
import com.griftt.server.duty.proceschain.Process;
import com.griftt.server.duty.proceschain.TypeChain;

import java.util.ArrayList;
import java.util.List;

/**
 * 链条的入口
 */
public class ChainSupport {
                List<Process> chainList =new ArrayList<>();

    /**
     * 添加链条环节
     * @param process
     * @return
     */
    public ChainSupport addChain(Process process){
            chainList.add(process);
            return this;
        }

    /**
     * 执行
     * @param msg
     * @return
     */

    public String go( String msg){
            for (Process process:chainList) {
                process.doProcess(msg);
            }
            return msg;
        }

    public static void main(String[] args) {
        ChainSupport chainSupport = new ChainSupport().addChain(new TypeChain())
                .addChain(new CopyRight());
        String hello = chainSupport.go("hello");
        System.out.println(hello);
    }

}
