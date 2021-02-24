package top.damoncai.designattern.adapter.voltage;

/**
 * @author zhishun.cai
 * @date 2021/1/27 14:04
 */

public class Voltage5VAdapter implements VoltageAdapter{

    Voltage voltage;

    Voltage5VAdapter(Voltage voltage) {
        this.voltage = voltage;
    }

    @Override
    public void adapter() {
        System.out.println(voltage.getVoltage() + "V电压转换为5V");
    }
}
