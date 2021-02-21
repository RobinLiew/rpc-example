package com.robinliew.rpc.client.balance;

import com.robinliew.rpc.annotation.LoadBalanceAno;
import com.robinliew.rpc.common.constants.RpcConstant;
import com.robinliew.rpc.common.model.Service;

import java.util.List;

/**
 * 加权轮询
 */
@LoadBalanceAno(RpcConstant.BALANCE_WEIGHT_ROUND)
public class WeightRoundBalance implements LoadBalance{

    private volatile static int index;

    @Override
    public synchronized Service chooseOne(List<Service> services) {
        int allWeight = services.stream().mapToInt(Service::getWeight).sum();
        int number = (index++) % allWeight;
        for(Service service : services){
            if (service.getWeight() > number){
                return service;
            }
            number -= service.getWeight();
        }
        return null;
    }
}
