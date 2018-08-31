package com.vip.darker.system.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Auther: Darker
 * @Date: 2018/8/31 11:30
 * @Description: HttpSessionListener监听器统计
 */
@WebListener
public class SpringBootSessionListener implements HttpSessionListener {

    private int onLine = 0;

    private Logger logger = LoggerFactory.getLogger(SpringBootSessionListener.class);

    /**
     * 功能描述: 每当一个session会话建立,在线用户人数+1
     *
     * @param: [httpSessionEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onLine++;
        // 在线用户的数量存储到域对象ServletContext的number中
        httpSessionEvent.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionCreated", onLine);
    }

    /**
     * 功能描述: 每当一个session会话销毁,在线用户人数-1
     *
     * @param: [httpSessionEvent]
     * @auther: darker
     * @date: 2018/8/31 13:43
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onLine--;
        // 在线用户的数量存储到域对象ServletContext的number中
        httpSessionEvent.getSession().getServletContext().setAttribute("number", onLine);
        logger.info("{}:当前在线人数:{}", "sessionDestroyed", onLine);
    }
}
