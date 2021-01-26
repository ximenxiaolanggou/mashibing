package top.damoncai.designattern.proxy.staticproxy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * @author zhishun.cai
 * @date 2021/1/25 16:00
 */
@AllArgsConstructor
public class PlaneTimeProxy implements Movable {

    private Plane plane;

    @Override
    public void move() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        plane.move();
        Thread.sleep((int)(Math.random()*1000));
        Long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime -startTime));
    }
}
