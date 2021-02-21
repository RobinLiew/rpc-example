package com.robinliew.rpc.client.balance;

import com.robinliew.rpc.annotation.LoadBalanceAno;
import com.robinliew.rpc.common.constants.RpcConstant;
import com.robinliew.rpc.common.model.Service;

import java.util.List;
import java.util.Random;

/**
 * 随机算法
 */
@LoadBalanceAno(RpcConstant.BALANCE_RANDOM)
public class RandomBalance implements LoadBalance{

    private static Random random = new Random();

    @Override
    public Service chooseOne(List<Service> services) {
        return services.get(random.nextInt(services.size()));
    }
}
