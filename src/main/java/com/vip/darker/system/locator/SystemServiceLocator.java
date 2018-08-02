package com.vip.darker.system.locator;

import com.vip.darker.service.*;
import com.vip.darker.service.impl.*;
import com.vip.darker.system.SpringBootApplicationContent;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 16:34
 * @Description: 基础服务serviceBean
 */
public class SystemServiceLocator {

    /**
     * 功能描述: 资源service
     *
     * @param: []
     * @return: com.vip.darker.service.ResourceService
     * @auther: darker
     * @date: 2018/7/26 17:43
     */
    public static ResourceService getResourceService() {
        return (ResourceService) SpringBootApplicationContent.getBean(ResourceServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 回收service
     *
     * @param: []
     * @return: com.vip.darker.service.TrashService
     * @auther: darker
     * @date: 2018/7/26 17:44
     */
    public static TrashService getTrashService() {
        return (TrashService) SpringBootApplicationContent.getBean(TrashServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 用户service
     *
     * @param: []
     * @return: com.vip.darker.service.UserService
     * @auther: darker
     * @date: 2018/7/26 18:00
     */
    public static UserService getUserService() {
        return (UserService) SpringBootApplicationContent.getBean(UserServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 角色service
     *
     * @param: []
     * @return: com.vip.darker.service.RoleService
     * @auther: darker
     * @date: 2018/7/26 18:01
     */
    public static RoleService getRoleService() {
        return (RoleService) SpringBootApplicationContent.getBean(RoleServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 权限service
     *
     * @param: []
     * @return: com.vip.darker.service.PermissionService
     * @auther: darker
     * @date: 2018/7/26 18:03
     */
    public static PermissionService getPermissionService() {
        return (PermissionService) SpringBootApplicationContent.getBean(PermissionServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 用户角色service
     *
     * @param: []
     * @return: com.vip.darker.service.URRelationService
     * @auther: darker
     * @date: 2018/7/26 18:15
     */
    public static URRelationService getURRelationService() {
        return (URRelationService) SpringBootApplicationContent.getBean(URRelationServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 角色权限service
     *
     * @param: []
     * @return: com.vip.darker.service.RPRelationService
     * @auther: darker
     * @date: 2018/7/26 18:16
     */
    public static RPRelationService getRPRelationService() {
        return (RPRelationService) SpringBootApplicationContent.getBean(RPRelationServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 日记service
     *
     * @param: []
     * @return: com.vip.darker.service.DiaryService
     * @auther: darker
     * @date: 2018/7/26 18:05
     */
    public static DiaryService getDiaryService() {
        return (DiaryService) SpringBootApplicationContent.getBean(DiaryServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 文章service
     *
     * @param: []
     * @return: com.vip.darker.service.ArticleService
     * @auther: darker
     * @date: 2018/7/26 18:05
     */
    public static ArticleService getArticleService() {
        return (ArticleService) SpringBootApplicationContent.getBean(ArticleServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 图片service
     *
     * @param: []
     * @return: com.vip.darker.service.PhotoService
     * @auther: darker
     * @date: 2018/7/26 18:06
     */
    public static PhotoService getPhotoService() {
        return (PhotoService) SpringBootApplicationContent.getBean(PhotoServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 留言板service
     *
     * @param: []
     * @return: com.vip.darker.service.MessageService
     * @auther: darker
     * @date: 2018/7/26 18:07
     */
    public static MessageService getMessageService() {
        return (MessageService) SpringBootApplicationContent.getBean(MessageServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 统计service
     *
     * @param: []
     * @return: com.vip.darker.service.StatisticsService
     * @auther: darker
     * @date: 2018/7/26 18:09
     */
    public static StatisticsService getStatisticsService() {
        return (StatisticsService) SpringBootApplicationContent.getBean(StatisticsServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 监控service
     *
     * @param: []
     * @return: com.vip.darker.service.MonitorService
     * @auther: darker
     * @date: 2018/7/26 18:10
     */
    public static MonitorService getMonitorService() {
        return (MonitorService) SpringBootApplicationContent.getBean(MonitorServiceImpl.BEAN_NAME);
    }
}