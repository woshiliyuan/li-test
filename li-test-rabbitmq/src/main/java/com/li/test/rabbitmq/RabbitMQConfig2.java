//package com.li.test.rabbitmq;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author yuan.li
// * 
// */
//@Configuration
//@ConfigurationProperties(prefix = "spring.rabbitmq")
//public class RabbitMQConfig2 {
//	private String host;
//	private int port;
//	private String userName;
//	private String password;
//	private String virtualHost;
//
//	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host, port);
//		cachingConnectionFactory.setUsername(userName);
//		cachingConnectionFactory.setPassword(password);
//		cachingConnectionFactory.setVirtualHost(virtualHost);
//		cachingConnectionFactory.setPublisherConfirms(true);
//		return cachingConnectionFactory;
//	}
//
//	@Bean
//	public RabbitTemplate rabbitTemplate() {
//		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
//		return rabbitTemplate;
//	}
//
//	public void setHost(String host) {
//		this.host = host;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public void setVirtualHost(String virtualHost) {
//		this.virtualHost = virtualHost;
//	}
//}
