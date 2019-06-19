package com.griftt.server.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioRead {
    public static void main(String[] args) {

        }
    /**
     * 单通道文件读写
     */
    public  void readFile(){
    RandomAccessFile file=null;
    try {
        //示例从FileChannel中读取数据到buffer中
        file = new RandomAccessFile("d:/a.txt","rw");
        FileChannel channel = file.getChannel();
        //定义一个255字节缓存区间
        ByteBuffer allocate = ByteBuffer.allocate(255);
        //将通道内容写进缓存区
        int read = channel.read(allocate);
        while (read!=-1){
            System.out.println("read:"+read);
            allocate.flip();//模式转换，由写变为读
            while (allocate.hasRemaining()){
                //每次拿一个字节
                System.out.println(allocate.getChar());
            }
            allocate.clear();
            read = channel.read(allocate);
        }
        file.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    /**
     * 多通道文件读写
     */
    public  void readFileByMoreChannel() throws IOException {
        //新建一个selector
        Selector selector = Selector.open();
        //新通道，绑定地址
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind( new InetSocketAddress(8888));
        //serverSocket.accept()
        //设为非阻塞状态
        //将通道加进选择器，并选择监听的类型
        SelectionKey register = channel.register(selector, SelectionKey.OP_ACCEPT);
        channel.configureBlocking(false);
        while (true){
            //自上次调用select()方法后有多少通道变成就绪状态
            SocketChannel accept = channel.accept();
            if(accept ==null ){
                continue;
            }
            //int readyChannel = selector.select();
//            if(readyChannel==0){
//                continue;
//            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){

                }if(key.isConnectable()){

                }if(key.isReadable()){

                }if(key.isWritable()){

                }
                //需要将处理完的channel移除就绪队列
                iterator.remove();
            }

        }


    }
}
