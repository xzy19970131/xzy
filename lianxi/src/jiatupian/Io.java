package jiatupian;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Io {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Socket s = new Socket();
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			try {
				DataOutputStream ds = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
