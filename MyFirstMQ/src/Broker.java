import java.util.concurrent.LinkedBlockingQueue;

public class Broker {

    //保存消息数据的容器
    private static LinkedBlockingQueue<String> messageQuene = new LinkedBlockingQueue<>();

    //生产消息
    public static void produce(String msg){
        if(messageQuene.offer(msg)){
            System.out.println("成功向消息处理中心投递消息：" + msg + ",当前暂存的消息数量是：" + messageQuene.size());
        }else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("======================");
    }

    //消费消息
    public static String consume(){
        String msg = messageQuene.poll();  //如果队列没有数据就返回Null，与数据就取出来
        if(msg != null){
            //消费条件满足情况，从消息容器中取出一条消息
            System.out.println("已经消费消息：" + msg + ",当前暂存的消息数量是：" + messageQuene.size());
        }else {
            System.out.println("消息处理中心内没有消息可供消费！");
        }
        System.out.println("=======================");

        return msg;
    }

}