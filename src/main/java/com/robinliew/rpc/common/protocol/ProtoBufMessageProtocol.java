package com.robinliew.rpc.common.protocol;

import com.robinliew.rpc.annotation.MessageProtocolAno;
import com.robinliew.rpc.common.constants.RpcConstant;
import com.robinliew.rpc.common.model.RpcRequest;
import com.robinliew.rpc.common.model.RpcResponse;
import com.robinliew.rpc.util.SerializingUtil;

/**
 * Protobuf序列化协议
 * @author 2YSP
 * @date 2020/8/5 21:22
 */
@MessageProtocolAno(RpcConstant.PROTOCOL_PROTOBUF)
public class ProtoBufMessageProtocol implements MessageProtocol{

    @Override
    public byte[] marshallingRequest(RpcRequest request) throws Exception {
        return SerializingUtil.serialize(request);
    }

    @Override
    public RpcRequest unmarshallingRequest(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data,RpcRequest.class);
    }

    @Override
    public byte[] marshallingResponse(RpcResponse response) throws Exception {
        return SerializingUtil.serialize(response);
    }

    @Override
    public RpcResponse unmarshallingResponse(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data,RpcResponse.class);
    }
}
