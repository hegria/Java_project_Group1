
public class SetIcon extends Thread{
	Yatch yatch;
	int player;
	int emoji;
	public SetIcon(Yatch yatch,int a, int b) {
		player = a;
		emoji = b;
		this.yatch =yatch;
		}
	
	public void run() {
		if(yatch.emoji[player] ==0) {
			yatch.emoji[player] = emoji;
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			yatch.emoji[player] = 0;
		}
	}

}
