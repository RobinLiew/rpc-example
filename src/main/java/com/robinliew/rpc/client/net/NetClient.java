package com.robinliew.rpc.client.net;

import com.robinliew.rpc.common.model.Service;
import com.robinliew.rpc.common.protocol.MessageProtocol;
import com.robinliew.rpc.common.model.RpcRequest;
import com.robinliew.rpc.common.model.RpcResponse;

/**
 *
 * 网络请求客户端，定义请求规范
 * @author 2YSP
 * @date 2020/7/25 20:11
 *
 */
public interface NetClient {

    byte[] sendRequest(byte[] data, Service service) throws InterruptedException;

    RpcResponse sendRequest(RpcRequest rpcRequest, Service service, MessageProtocol messageProtocol);
}
