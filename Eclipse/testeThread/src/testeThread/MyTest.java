package testeThread;

//codigo exemplo de como fazer uma thread para dois contadores
public class MyTest {
	static int i=0;
	
	private static void increment(String threadName) {
		i++;
		System.out.println("Thread " + threadName + " i = " + i);
	}
	
	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					increment("t1");
				}
			} catch (Exception e) {
			
			}
		}
	};
	
	private static Runnable t2 = new Runnable() {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					increment("t2");
				}
			} catch (Exception e) {

			}
		}
	};
	
	public static void main(String[] args) {
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
