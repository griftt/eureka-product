package com.griftt.server.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class NioRead {

   static Selector selector;

    static {
        try {
            selector = SelectorProvider.provider().openSelector();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public  static  void readFileByMoreChannel() throws Exception {
        //新建一个selector
         //selector = Selector.open();
        //新通道，绑定地址
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(8888));
        //serverSocket.accept()
        //设为非阻塞状态
        //将通道加进选择器，并选择监听的类型
        channel.configureBlocking(false);
        SelectionKey register = channel.register(selector, SelectionKey.OP_ACCEPT|SelectionKey.OP_READ);
        while (true){
            //自上次调用select()方法后有多少通道变成就绪状态，此方法会阻塞
            System.out.println("已启动");
            int readyChannel = selector.select(1000);
            if(readyChannel==0){
                System.out.println("查询中");
                continue;
            }
            //获取已就绪的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //将当前已处理的key移除
                iterator.remove();
                if(key.isAcceptable()){
                    ServerSocketChannel  socketChannel =(ServerSocketChannel ) key.channel();
                    //accept非阻塞状态
                    SocketChannel accept =socketChannel.accept();
                    if(accept ==null ){
                        continue;
                    }


                    //accept.configureBlocking(false);
                    //accept.write(ByteBuffer.wrap("发送给客户端：".getBytes()));
                    //socketChannel.register(selector,SelectionKey.OP_WRITE);
                }if(key.isConnectable()){
                    SocketChannel socketChannel =(SocketChannel) key.channel();
                    System.out.println("开始读取信息");
                    Object attachment = key.attachment();
                    System.out.println("attch："+attachment);
                    myReadKey(socketChannel);
                }if(key.isReadable()){
                }if(key.isWritable()){
                    //readKey(key);
                }
                //需要将处理完的channel移除就绪队列
            }

        }
    }

    public static void myReadKey(SocketChannel channel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(40);
        int read = channel.read(allocate);
        StringBuffer stringBuffer = new StringBuffer();
        if(read>0) {
            allocate.flip();
            byte[] array = allocate.array();
            String line = new String(array);
            stringBuffer.append(line);
            System.out.println("每次收到的信息：" + stringBuffer);
            allocate.clear();
        }
    }


    /**
     * 处理读取客户端发来的信息 的事件
     * @param key
     * @throws IOException
     */
    public static  void readKey(SelectionKey key) throws IOException{
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端收到信息："+msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        // 将消息回送给客户端,
        buffer.flip();// 这一步必须有
        channel.write(outBuffer);
    }

    /**
     * 客户端发送信息
     * @throws IOException
     */
    public  static  void sendMsg() throws IOException {
        Selector selector = NioRead.selector;
        SocketChannel socketChannel = SocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
        socketChannel.configureBlocking(false);
       // socketChannel.register(selector,SelectionKey.OP_WRITE,"hello");
        ByteBuffer allocate = ByteBuffer.allocate(255);
        socketChannel.connect(socketAddress);
        allocate.put("1".getBytes());
        allocate.flip();// 这一步必须有
        socketChannel.write(allocate);
        System.out.println("启动客户端并发送信息");
        socketChannel.close();
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readFileByMoreChannel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(4000);
            sendMsg();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
