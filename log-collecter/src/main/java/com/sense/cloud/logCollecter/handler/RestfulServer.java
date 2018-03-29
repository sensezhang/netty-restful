package com.sense.cloud.logCollecter.handler;

import com.sense.cloud.logCollecter.util.LogPropertiesUtil;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.ext.Provider;
import java.util.Collection;

@Component
public class RestfulServer {
  public Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ApplicationContext context;

  // 得到服务器的配置参数
  private String host = LogPropertiesUtil.getStr("logCollecter.host", "0.0.0.0");
  private String rootResourcePath = LogPropertiesUtil.getStr("logCollecter.rootResourcePath", "/log-collecter");
  private int port = LogPropertiesUtil.getInt("logCollecter.port", 58045);
  private int executorThreadCount = LogPropertiesUtil.getInt("logCollecter.executorThreadCount", 16);
  private NettyJaxrsServer nettyServer = null;

  public void start() {

    ResteasyDeployment deployment = new ResteasyDeployment();
    Collection<Object> providers = context.getBeansWithAnnotation(Provider.class).values();
    Collection<Object> controllers = context.getBeansWithAnnotation(Controller.class).values();

    deployment.getProviders().addAll(providers);
    deployment.getResources().addAll(controllers);

    // 创建服务
    nettyServer = new NettyJaxrsServer();
    nettyServer.setDeployment(deployment);
    nettyServer.setHostname(host);
    nettyServer.setPort(port);
    nettyServer.setRootResourcePath(rootResourcePath);
    nettyServer.setSecurityDomain(null);
    nettyServer.setExecutorThreadCount(executorThreadCount);
    nettyServer.start();
    log.info("server start port " + port);
  }
}
