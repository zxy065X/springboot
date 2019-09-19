package com.boshuo.task;

import java.util.Date;

import com.boshuo.mongodb.MongoDBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boshuo.util.DateUtils;

@EnableScheduling // 启动定时任务
@Component
public class CheckTask {

    private static Logger logger = LoggerFactory.getLogger(CheckTask.class);

    @Autowired
    MongoDBService mongoDBService;

    @Scheduled(cron = "0 0 2 * * ?") // 半夜两点统计
    public void timingStatistics() {

        try {

            logger.info("开始定时任务");
            // 今天开始时间
            Date dayBegin = DateUtils.getDayBegin();
            // 今天结束时间
            Date dayEnd = DateUtils.getDayEnd();

            mongoDBService.companyrecords();
            mongoDBService.wechat();
            mongoDBService.wxsigns();
            mongoDBService.suggests();
            mongoDBService.offerjobs();
            mongoDBService.companytickets();
            mongoDBService.companynews();
            mongoDBService.companies();
            mongoDBService.accountInfo();
            mongoDBService.test();

			logger.info("结束定时任务");
        } catch (Exception e) {
        	logger.error("任务异常");
        }

    }
}
