package top.damoncai.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zhishun.cai
 * @date 2021/1/21 15:31
 */

public class TankFrame extends Frame {

    int x = 200;
    int y = 200;
    int width = 50;
    int height = 50;

    @Override
    public void paint(Graphics g) {
        System.out.println("paint~~");
        g.fillRect(x,y,width,height);
    }

    public TankFrame() {
        setVisible(true);
        setSize(800,600);
        setResizable(false); //是否可以调节大小
        setTitle("Tank war");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
