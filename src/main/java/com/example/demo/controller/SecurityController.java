package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.util.SignUtil;

/**
 * Created by zggdczfr on 2016/10/21.
 */
@Controller
@RequestMapping(value = "/wechat")
public class SecurityController {

    private static final long serialVersionUID = 4323197796926899691L;
    private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

    @RequestMapping("test")
    public String test(){
        System.out.println("test");
        return "index.html";
    }

    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void WetChatGet(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(value = "signature", required = true) String signature,
                        @RequestParam(value = "timestamp", required = true) String timestamp,
                        @RequestParam(value = "nonce", required = true) String nonce,
                        @RequestParam(value = "echostr", required = true) String echostr) throws IOException {
        try {
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            	System.out.println("连接微信公众号平台测试成功！");
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            }else {
            	System.out.println("连接微信公众号平台测试失败！");
			}
        } catch (Exception e){
            LOGGER.log(Level.ERROR, "连接微信公众号平台测试失败！");
        }
    }

    @RequestMapping(value = "security", method = RequestMethod.POST)
    public void WetChatPost(HttpServletRequest request, HttpServletResponse response){
        //业务逻辑处理
    }
}

