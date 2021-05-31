package com.raveland.provider;

import com.raveland.client.UserCmd;
import com.raveland.client.UserService;
import com.raveland.thrift.annotation.ThriftService;
import org.apache.thrift.TException;

/**
 * @author shay
 * @date 2021/05/28
 */
@ThriftService
public class UserHandler implements UserService.Iface {
    @Override
    public int add(UserCmd cmd) throws TException {
        return 520;
    }
}
