package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8080)) {
			while (true) {
				try (Socket socket = server.accept();
						OutputStream os = socket.getOutputStream()) {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = br.readLine();
					while(!line.isEmpty()) {
						System.out.println(line);
						line = br.readLine();
					}
					String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n{'name':'Mehrab'}";
					os.write(response.getBytes("UTF-8"));
				}
			}

		} catch (IOException ex) {

		}

	}

}
