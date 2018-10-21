package com.bootdo.lte.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LTE告警对象
 *
 * @author Roger Wang
 * @email 476410060@qq.com
 * @date 2018-10-21 10:17:07
 */

@Controller
@RequestMapping("/lte/lteAlarm")
public class LteAlarmController {

    /**
     * 告警面板
     * @return
     */
    @GetMapping()
    @RequiresPermissions("lte:lteAlarm:lteAlarmDesk")
    String CommonObject(){
        return "lte/lteAlarm/lteAlarmDesk";
    }


    @GetMapping("/detail")
    //@RequiresPermissions("lte:commonObject:add")
    String add(){
        return "lte/lteAlarm/lteAlarmDetail";
    }
}

