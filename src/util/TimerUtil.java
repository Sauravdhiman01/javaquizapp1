package util;

import javax.swing.Timer;

public class TimerUtil {
    private Timer timer;
    private int timeLeft;
    private Runnable onTick;
    private Runnable onFinish;

    public TimerUtil(int seconds, Runnable onTick, Runnable onFinish) {
        this.timeLeft = seconds;
        this.onTick = onTick;
        this.onFinish = onFinish;

        timer = new Timer(1000, e -> {
            timeLeft--;
            if (this.onTick != null) {
                this.onTick.run();
            }
            if (timeLeft <= 0) {
                timer.stop();
                if (this.onFinish != null) {
                    this.onFinish.run();
                }
            }
        });
    }

    public void start() {
        if(timer != null) timer.start();
    }

    public void stop() {
        if(timer != null) timer.stop();
    }

    public int getTimeLeft() {
        return timeLeft;
    }
    
    public void setTimeLeft(int seconds) {
        this.timeLeft = seconds;
    }
}
