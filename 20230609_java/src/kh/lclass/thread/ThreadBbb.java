package kh.lclass.thread;

public class ThreadBbb extends Thread {
	@Override
	public void run() {
		for (int dan=2; dan<101; dan++) {
			for(int su=1; su<10; su++) {
				System.out.printf("%3d*%2d=%3d\n", dan, su, dan*su);
			}
			System.out.println("=====");
			try {
				sleep(10L); //한단이 끝날때마다 쉬기
				interrupt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return;
		
	}
}
