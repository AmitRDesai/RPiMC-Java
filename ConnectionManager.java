package rpimc;

import java.io.IOException;
import java.net.Socket;

public class ConnectionManager {
	public static void initialize() {
	}

	public static Connection connect() {
		try {
			return new Connection(new Socket("192.168.43.1", 9090));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void disconnect() {
	}
}
