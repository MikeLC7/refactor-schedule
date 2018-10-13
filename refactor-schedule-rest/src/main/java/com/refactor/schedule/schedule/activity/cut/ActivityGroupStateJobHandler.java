package com.refactor.schedule.schedule.activity.cut;

import com.refactor.mall.common.enums.ResponseCode;
import com.refactor.mall.common.msg.RestResponse;
import com.refactor.schedule.feign.activity.IActivityGroupStateService;
import com.refactor.schedule.feign.rent.IRentOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Project: RefactorMall
 *
 * File: 活动定时任务状态
 *
 * Description:
 *
 * @author: Jary
 *
 * @date: 2018/7/12 下午7:33
 *
 * Copyright ( c ) 2018
 *
 */
@JobHandler(value="activityGroupStateJobHandler")
@Component
public class ActivityGroupStateJobHandler extends IJobHandler {

	@Autowired
	private IActivityGroupStateService iActivityGroupStateService;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("JOB_Begin ：activityGroupStateJobHandler");
		//
		Date nowDate = new Date();
		long timeStr = nowDate.getTime();
		RestResponse<Boolean> restResponse = this.iActivityGroupStateService.updateActivityGroupStateForEndTime(timeStr);
		if (restResponse.getCode() != ResponseCode.SUCCESS.getCode() || restResponse.getData() == null || restResponse.getData() != true){
			XxlJobLogger.log("JOB_Error ：activityGroupStateJobHandler");
			XxlJobLogger.log("JOB_Error ：" + restResponse.getMsg());
			return ReturnT.FAIL;
		} else {
			XxlJobLogger.log("JOB_Success ：" + restResponse.getMsg());
		}
		XxlJobLogger.log("JOB_End ：activityGroupStateJobHandler");
		return ReturnT.SUCCESS;
	}




}
