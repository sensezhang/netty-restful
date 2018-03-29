package com.sense.cloud.logCollecter.api;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2018/3/29.
 */
@Path("base")
@Scope("prototype")
@Controller
public class BaseInfoHandler {

  @GET
  @Path("harbor/putInfo.do")
  @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
  public String helloWorld(String name){
    System.out.println("hello world "+ name);
    return "-----------";
  }
}
