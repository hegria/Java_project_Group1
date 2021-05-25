
public class SetIcon extends Thread{
	Yatch yatch;
	int player;
	int imoji;
	public SetIcon(Yatch yatch,int a, int b) {
		player = a;
		imoji = b;
		this.yatch =yatch;
		}
	
	public void run() {
		if(yatch.imoji[player] ==0) {
			yatch.imoji[player] = imoji;
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			yatch.imoji[player] = 0;
		}
	}

}
