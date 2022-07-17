package com.joseph.sharpknife.test.tasktype;

import com.joseph.sharpknife.blade.pool.MonitoredThreadPool;
import com.joseph.sharpknife.blade.unit.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joseph
 */
@Configuration
public class OneNodeTimeoutType extends TaskType {

    @Autowired
    private MonitoredThreadPool commonThreadPool;

    @Override
    public String getTypeName() {
        return "OneNodeTimeoutType";
    }

    @Override
    public MonitoredThreadPool getExecutorPool() {
        return commonThreadPool;
    }
}
