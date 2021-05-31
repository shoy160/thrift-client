package com.raveland.thrift.server.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.raveland.core.Constants;
import com.raveland.core.utils.ReflectUtils;
import com.raveland.thrift.annotation.ThriftService;
import com.raveland.thrift.config.ThriftConfig;
import com.raveland.thrift.server.ThriftServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * todo
 *
 * @author shay
 * @date 2021/5/28
 **/
@Slf4j
@RequiredArgsConstructor
public class DefaultThriftServer implements ThriftServer {
    private final ThriftConfig config;

    private List<TProcessor> findProcessors() {
        List<TProcessor> processorList = new ArrayList<>();
        try {
            Set<Class<?>> classSet = ReflectUtils.findClasses(Constants.BASE_PACKAGES, clz -> clz.getAnnotation(ThriftService.class) != null);
            for (Class<?> clazz : classSet) {
                Class<?> interfaces = clazz.getInterfaces()[0];
                String serviceClazz = interfaces.getSuperclass().getName();
                Class<?> processorClazz = Class.forName(String.format("%s.Processor", serviceClazz));
                TProcessor processor = (TProcessor) processorClazz.getConstructor(clazz).newInstance(clazz.newInstance());
                processorList.add(processor);
            }
        } catch (Exception ex) {
            log.error("加载Thrift服务异常", ex);
        } finally {

        }
        return processorList;
    }

    @Override
    public void start() {
        try {
            List<TProcessor> processorList = findProcessors();
            TServerTransport serverTransport = new TServerSocket(config.getPort());
            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serverTransport);
            for (TProcessor processor : processorList) {
                serverArgs.processor(processor);
            }
            TServer server = new TThreadPoolServer(serverArgs);
            System.out.printf("Starting thrift server at %s:%s...%n", config.getHost(), config.getPort());
            server.serve();
            // todo 服务注册
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
