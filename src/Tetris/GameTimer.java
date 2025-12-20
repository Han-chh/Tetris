
public class GameTimer implements Runnable{

	public void run() {
		while(true) {
			if (!ProcessControl.isPause) {
				try {
					Thread.sleep(10);
					Game.timer = (float) (Game.timer +0.01);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if(ProcessControl.isPause) {
				while(ProcessControl.isPause) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			} 
		}
	}
	
}
