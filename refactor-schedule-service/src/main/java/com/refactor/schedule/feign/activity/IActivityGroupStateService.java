package com.refactor.schedule.feign.activity;

import com.refactor.mall.common.msg.RestResponse;
import com.refactor.schedule.feignFail.activity.ActivityGroupStateFailImpl;
import com.refactor.schedule.feignFail.rent.RentOrderFailImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description: 
 *
 * @param:
 *
 * @author: Jary
 * 
 * @date:  下午9:11
 */
@FeignClient(value = "refactor-mall-activity",fallback = ActivityGroupStateFailImpl.class)
public interface IActivityGroupStateService {

    @RequestMapping(value = "/api/activity/schedule/rpc/updateActivityGroupStateForEndTime", method = RequestMethod.POST)
    RestResponse<Boolean> updateActivityGroupStateForEndTime(@RequestParam("timestamp") Long timestamp);



}
