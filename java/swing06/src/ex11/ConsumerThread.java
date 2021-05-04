package ex11;



public class ConsumerThread extends Thread{
	MyLabel label;
	public ConsumerThread(MyLabel label) {
		this.label = label;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				label.consume();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
