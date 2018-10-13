package com.refactor.schedule.schedule.rent;

import com.refactor.mall.common.enums.ResponseCode;
import com.refactor.mall.common.msg.RestResponse;
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
 * File: RentOrderTimeOutJobHandler
 *
 * Description: 租赁订单-支付超时回收
 *
 * @author: MikeLC
 *
 * @date: 2018/7/11 下午 07:43
 *
 * Copyright ( c ) 2018
 *
 */
@JobHandler(value="rentOrderPayTimeOutJobHandler")
@Component
public class RentOrderPayTimeOutJobHandler extends IJobHandler {

	@Autowired
	private IRentOrderService iRentOrderService;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("JOB_Begin ：rentOrderPayTimeOutJobHandler");
		//
		Date nowDate = new Date();
		long timeStr = nowDate.getTime();
		RestResponse<Boolean> restResponse = this.iRentOrderService.updateRentOrderCancelForPayTimeOut(timeStr);
		if (restResponse.getCode() != ResponseCode.SUCCESS.getCode() || restResponse.getData() == null || restResponse.getData() != true){
			XxlJobLogger.log("JOB_Error ：rentOrderPayTimeOutJobHandler");
			XxlJobLogger.log("JOB_Error ：" + restResponse.getMsg());
			return ReturnT.FAIL;
		} else {
			XxlJobLogger.log("JOB_Success ：" + restResponse.getMsg());
		}
		XxlJobLogger.log("JOB_End ：rentOrderPayTimeOutJobHandler");
		return ReturnT.SUCCESS;
	}




}
