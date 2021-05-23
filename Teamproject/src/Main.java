
public class Main {
	public static void main(String[] args) {
		Layout layout = new Layout();
		Thread draw = new Thread(layout);
		draw.start();
	}
}
