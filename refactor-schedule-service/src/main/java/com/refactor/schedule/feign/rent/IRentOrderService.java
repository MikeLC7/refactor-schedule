package com.refactor.schedule.feign.rent;

import com.refactor.mall.common.msg.RestResponse;
import com.refactor.schedule.feignFail.rent.RentOrderFailImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project: RefactorMall
 *
 * File: IRentOrderService
 *
 * Description:
 *
 * @author: MikeLC
 *
 * @date: 2018/5/14 上午 11:59
 *
 * Copyright ( c ) 2018
 *
 */
@FeignClient(value = "refactor-mall-rent",fallback = RentOrderFailImpl.class)
public interface IRentOrderService {

    @RequestMapping(value = "/api/rentOrder/schedule/rpc/updateRentOrderCancelForPayTimeOut", method = RequestMethod.POST)
    RestResponse<Boolean> updateRentOrderCancelForPayTimeOut(@RequestParam("timestamp") Long timestamp);



}
