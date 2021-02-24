package top.damoncai.designattern.adapter.voltage;

/**
 * @author zhishun.cai
 * @date 2021/1/27 14:16
 */

public class Main {

    public static void main(String[] args) {
        //1.创建220V电压
        Voltage voltage220V = new Voltage220V();

        //2.创建5V适配器
        VoltageAdapter adapter5V = new Voltage5VAdapter(voltage220V);

        //3.创建手机
        Mobile mobile = new Mobile();
        mobile.charging(adapter5V);

    }
}
