package com.vip.darker.controller.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.StatisticsModel;
import com.vip.darker.model.UserModel;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.ConstantUtil;
import com.vip.darker.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 15:18
 * @Description: 重定向controller
 */
@Controller
public class RedirectController {
    // 标识浏览量PV是否已初始化
    private boolean init = true;

    private Logger logger = LoggerFactory.getLogger(RedirectController.class);

    /**
     * 功能描述: 博客首页
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/", "/index", "/index/", "/index/home", "/home"})
    @SuppressWarnings(value = "unchecked")
    public String defaultIndex(HttpServletRequest request) {
        // 加锁防止并发
        synchronized (this) {
            // 1.网站浏览量PV初始化
            if (init) {
                // 查询数据库,若值存在,则重置浏览量
                Map<String, Object> map = SpringBootService.getStatisticsService().selectMap(new EntityWrapper<StatisticsModel>().where("classify={0}", "pv"));

                if (map != null) {
                    if (map.containsKey("amount")) {
                        SpringBootService.getSpringBootPropertiesLoad().setCountPV((int) map.get("amount"));
                    }
                }
                init = false;
            }
            // 2.网站访问人数
            List<UserModel> userList = (List<UserModel>) request.getServletContext().getAttribute("userList");
            if (userList == null) {
                userList = new ArrayList<>();
            }
            // 获得用户sessionId
            String sessionId = request.getSession().getId();
            // 若游客不存在用户列表中
            if (SessionUtil.getUserBySessionId(userList, sessionId) == null) {
                UserModel user = new UserModel();
                user.setSessionId(sessionId);
                user.setIp(request.getRemoteAddr());
                user.setLoginTime(new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date()));
                user.setName("陌生人");
                userList.add(user);
                // 持久化到DB
                SpringBootService.getUserService().insert(user);
            }
            // 重置用户列表
            request.getServletContext().setAttribute("userList", userList);
            // 3.缓存操作,获取文章信息
            try {
                Object cacheObj = SpringBootService.getRedisService().get(ConstantUtil.REDIS_KEY_ARTICLE);
                // 判断缓存是否命中
                if (cacheObj == null) {
                    // 设置缓存
                    SpringBootService.getRedisService().set(ConstantUtil.REDIS_KEY_ARTICLE, SpringBootService.getArticleService().selectList(new EntityWrapper<>()));
                }
            } catch (Exception e) {
                logger.info("redis服务启动异常!");
            }
        }
        return "index/welcome";
    }

    /**
     * 功能描述: 关于我
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/about", "/about/"})
    public String defaultAbout() {
        return "redirect:index/about";
    }

    /**
     * 功能描述: 相册
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/photo", "/photo/"})
    public String defaultPhoto() {
        return "redirect:index/photo";
    }

    /**
     * 功能描述: 留言板
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/8/22 15:06
     */
    @RequestMapping(value = {"/message", "/message/"})
    public String defaultMessage() {
        return "redirect:index/message";
    }

    /**
     * 功能描述: 后台登录
     *
     * @param: []
     * @return: java.lang.String
     * @auther: darker
     * @date: 2018/10/12 12:11
     */
    @RequestMapping(value = {"/admin", "/admin/home", "/login"})
    public String defaultAdmin() {
        return "redirect:admin/login";
    }
}