/*
 * Copyright 2011 Phil Spencer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
