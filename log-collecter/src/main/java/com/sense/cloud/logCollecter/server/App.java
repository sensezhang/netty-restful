package com.sense.cloud.logCollecter.server;

import com.sense.cloud.logCollecter.handler.RestfulServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/3/29.
 */
public class App {

  private static Logger log = LoggerFactory.getLogger(App.class);
  private static ApplicationContext ctx;

  /**
   * @param args
   * @info 主函数，本应用程序入口程序；
   */
  public static void main(String[] args) {
    ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    RestfulServer server = ctx.getBean(RestfulServer.class);
    server.start();
    log.info("----------------------------start restful--------------------------");
  }

}
