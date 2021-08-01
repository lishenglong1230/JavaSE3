package Note0812_Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
使用定时器指定定时任务。
 */

public class TimerTest {
    public static void main(String[] args) throws Exception{
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);变成守护线程的方式

        //指定定时任务
        //timer.schedule(定时任务，第一次执行时间，间隔多久执行一次);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2021-1-11 17:33:00");
        timer.schedule(new LogTimerTask(),firstTime,1000*10);
        //还可以使用匿名内部类的方式

    }
}

//编写一个定时任务类
//假设这是一个记录日志的定时任务
class LogTimerTask extends TimerTask{

    @Override
    public void run() {
        //编写你需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + "：成功完成了一次数据备份!");
    }
}
