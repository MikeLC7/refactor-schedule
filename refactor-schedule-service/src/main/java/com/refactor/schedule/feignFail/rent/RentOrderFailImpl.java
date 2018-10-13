package com.refactor.schedule.feignFail.rent;

import com.refactor.mall.common.enums.ResponseCode;
import com.refactor.mall.common.msg.RestResponse;
import com.refactor.schedule.feign.rent.IRentOrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project: RefactorMall
 *
 * File: RentOrderFailImpl
 *
 * Description:
 *
 * @author: MikeLC
 *
 * @date: 2018/5/14 下午 12:01
 *
 * Copyright ( c ) 2018
 *
 */
@Component
public class RentOrderFailImpl implements IRentOrderService {


    @Override
    public RestResponse<Boolean> updateRentOrderCancelForPayTimeOut(@RequestParam("timestamp") Long timestamp) {
        return RestResponse.response(ResponseCode.FEIGN_ERROR.getCode(), ResponseCode.FEIGN_ERROR.getName(), null);
    }
}
