package com.refactor.schedule.feignFail.activity;

import com.refactor.mall.common.enums.ResponseCode;
import com.refactor.mall.common.msg.RestResponse;
import com.refactor.schedule.feign.activity.IActivityGroupStateService;
import com.refactor.schedule.feign.rent.IRentOrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project: RefactorMall
 *
 * File: ActivityGroupStateFailImpl
 *
 * Description: 
 *
 * @author: Jary
 *
 * @date: 2018/7/12 下午8:11
 *
 * Copyright ( c ) 2018
 *
 */
@Component
public class ActivityGroupStateFailImpl implements IActivityGroupStateService {


    @Override
    public RestResponse<Boolean> updateActivityGroupStateForEndTime(@RequestParam("timestamp") Long timestamp) {
        return RestResponse.response(ResponseCode.FEIGN_ERROR.getCode(), ResponseCode.FEIGN_ERROR.getName(), null);
    }
}
