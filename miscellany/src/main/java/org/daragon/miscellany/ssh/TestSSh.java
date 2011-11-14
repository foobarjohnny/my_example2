package org.daragon.miscellany.ssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;
import com.sshtools.j2ssh.transport.InvalidHostFileException;

public class TestSSh {
	public static void main(String[] args) throws InvalidHostFileException,
			IOException {

		SshClient ssh = new SshClient();
		PasswordAuthenticationClient authentication = new PasswordAuthenticationClient();
		authentication.setUsername("paragon");
		authentication.setPassword("paragon");
		ssh.connect("172.16.9.81", 22, new IgnoreHostKeyVerification());
		if (ssh.authenticate(authentication) == AuthenticationProtocolState.COMPLETE) {
			SessionChannelClient session = ssh.openSessionChannel();
			// session.setEnvironmentVariable("TERM", "linux");
			// if (client.requestPseudoTerminal("vt0", 0, 0, 0, 0,
			// "")) {
			if (session.startShell()) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						session.getInputStream()));
				session.executeCommand("");
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
				OutputStream writer = session.getOutputStream();
				writer.write("cat /proc/cpuinfo|grep 'model name'\n".getBytes());
				writer.flush();
				in = new BufferedReader(new InputStreamReader(
						session.getInputStream()));
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}

				if (session != null) {
					session.close();
				}
			}

		}
	}
}
