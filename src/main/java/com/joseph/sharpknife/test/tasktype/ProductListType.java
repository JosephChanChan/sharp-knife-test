package com.joseph.sharpknife.test.tasktype;

import com.joseph.sharpknife.blade.pool.MonitoredThreadPool;
import com.joseph.sharpknife.blade.unit.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joseph
 */
@Configuration
public class ProductListType extends TaskType {

    @Autowired
    private MonitoredThreadPool productListThreadPool;

    @Override
    public String getTypeName() {
        return "ProductListType";
    }

    @Override
    public MonitoredThreadPool getExecutorPool() {
        return productListThreadPool;
    }
}
