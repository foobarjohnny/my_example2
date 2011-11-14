package org.daragon.miscellany.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * JMS消息发送
 * 
 * @author paragon
 * 
 */
public class JmsSender {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(true,
				Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		sendMsg(session, producer);
		session.commit();
		session.close();
		connection.close();

	}

	private static void sendMsg(Session session, MessageProducer producer)
			throws JMSException {
		TextMessage msg = session.createTextMessage("hello activeMQ");
		producer.send(msg);

	}

}
