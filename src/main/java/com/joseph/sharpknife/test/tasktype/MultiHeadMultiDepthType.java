package com.joseph.sharpknife.test.tasktype;

import com.joseph.sharpknife.blade.pool.MonitoredThreadPool;
import com.joseph.sharpknife.blade.unit.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joseph
 * @since 2022/3/20
 */
@Configuration
public class MultiHeadMultiDepthType extends TaskType {

    @Autowired
    private MonitoredThreadPool commonThreadPool;

    @Override
    public String getTypeName() {
        return "MultiHeadMultiDepthType";
    }

    @Override
    public MonitoredThreadPool getExecutorPool() {
        return commonThreadPool;
    }
}
