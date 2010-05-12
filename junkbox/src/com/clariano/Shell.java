package com.clariano;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Shell {
	public static void main(String[] arg) {

		String host = System.getProperty("host");
		String user = System.getProperty("user");
		String pass = System.getProperty("pass");

		try {
			JSch jsch = new JSch();
			jsch.setKnownHosts("/home/psp/.ssh/known_hosts");

			Session session = jsch.getSession(user, host, 22);
			session.setPassword(pass);
			session.connect(30000); // make a connection with timeout.

			Channel channel = session.openChannel("shell");
			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			channel.connect(3 * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
