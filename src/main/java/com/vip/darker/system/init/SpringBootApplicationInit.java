package com.vip.darker.system.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Auther: Darker
 * @Date: 2018/8/28 14:30
 * @Description: springboot初始化后, 获取tomcat配置参数
 */
@Component
public class SpringBootApplicationInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        // 内容不能涉及到bean,报NullPointerException
    }
}
