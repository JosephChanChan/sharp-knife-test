package com.joseph.sharpknife.test.service.normal;

import com.joseph.sharpknife.blade.context.ExecutionResult;
import com.joseph.sharpknife.blade.context.ScheduleRequest;
import com.joseph.sharpknife.blade.scheduler.ConcurrentScheduler;
import com.joseph.sharpknife.blade.unit.TaskType;
import com.joseph.sharpknife.test.context.ProductListContext;
import com.joseph.sharpknife.test.context.SimpleContext;
import com.joseph.sharpknife.test.result.ProductListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joseph
 * @since 2022/7/11
 */
@Slf4j
@Service
public class ProductListService {

    @Autowired
    private TaskType productListType;

    @Autowired
    private ConcurrentScheduler concurrentScheduler;

    public void test() {
        ProductListContext context = new ProductListContext();
        ProductListResult result = new ProductListResult();
        ScheduleRequest<ProductListContext, ProductListResult> request = new ScheduleRequest<>(productListType, context, result);
        ExecutionResult executionResult = concurrentScheduler.scheduleSyn(request);
        if (executionResult.hasError()) {
            throw new RuntimeException("ProductListService execute error", executionResult.getError());
        }
        log.info("ProductListService done, res={}", result.sort());
    }
}
