package com.trifork.service;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(Endpoint.class);
  }
}