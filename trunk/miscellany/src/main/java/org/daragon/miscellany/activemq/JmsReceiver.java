package org.daragon.miscellany.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsReceiver {
	public static void main(String[] args) throws JMSException,
			InterruptedException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true,
				Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("my-queue");
		MessageConsumer consumer = session.createConsumer(destination);

		while (true) {
			TextMessage msg = (TextMessage) consumer.receive(1000);
			if (msg != null) {
				System.out.println(msg.getText());
			}
		}
//		session.commit();
//		session.close();
//		connection.close();

	}
}
