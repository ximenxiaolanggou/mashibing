/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package top.damoncai.juc.c_003;

public class T {

	private int count = 10;
	
	public synchronized void m() { //��ͬ���ڷ����Ĵ���ִ��ʱҪsynchronized(this)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}


}
