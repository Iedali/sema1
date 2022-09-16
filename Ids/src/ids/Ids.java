

package ids;

import java.util.concurrent.Semaphore;

import controller.Ids;

public class Main {
	public static void main(String[] args) {
		int num = 3;
		Semaphore bd = new Semaphore(1);
		for (int i = 0; i < num; i++)
			new Ids(i, bd).start();
	}
}

