package io.vividcode.rsocketstarter.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeTypeUtils;

import io.rsocket.transport.netty.client.TcpClientTransport;

abstract class AbstractTest {

  @Value("${spring.rsocket.server.port}")
  private int serverPort;
  @Autowired
  private RSocketRequester.Builder builder;

  RSocketRequester createRSocketRequester() {
    return builder.dataMimeType(MimeTypeUtils.TEXT_PLAIN)
        .connect(TcpClientTransport.create(serverPort)).block();
  }
}
