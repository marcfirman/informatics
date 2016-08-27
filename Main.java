import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import acsse.csc2b.server.server;

public class Main {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(1337);
			Thread[] clients = new Thread[10];
			for (int i = 0; i < 10; i++) {
				clients[i] = new server(ss, " ");
			}
			for (int i = 0; i <10; i++) {
				clients[i].run();
			}
			
			//ss.close();
		} catch (IOException e) {
			if (ss != null) {
				if (ss.isBound()) {
					e.printStackTrace();
				}
				else {
					try {
						ss.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.err.println("Couldn't bind. Re run");
				}
				e.printStackTrace();
			}
		}
	}

}
