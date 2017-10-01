/**
 * 版权声明 网宿科技 版权所有,违者必究
 * <p>
 * <br> Copyright：Copyright (c)  2017
 * <br> Company: 网宿科技
 * <br> Author: lincc(lincc1@chinanetcenter.com)
 * <br> Date：2017-09-23
 * <br> Version： 1.0
 */
package com.spc.mvctest.service;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <br>
 * <b>功能描述:</b>
 * <p/>
 * <pre>
 *  //TODO
 * </pre>
 *
 * @author lincc(lincc1@chinanetcenter.com)
 * @since 1.0
 */
@Service("UserService")
public class UserService{
    private Logger logger = Logger.getLogger(UserService.class);
    public void print(String str){
        System.out.println(str);
    }
}