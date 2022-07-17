package com.joseph.sharpknife.test.service.timeout;

import com.joseph.sharpknife.blade.context.ExecutionResult;
import com.joseph.sharpknife.blade.context.ScheduleRequest;
import com.joseph.sharpknife.blade.scheduler.ConcurrentScheduler;
import com.joseph.sharpknife.blade.unit.TaskType;
import com.joseph.sharpknife.test.context.SimpleContext;
import com.joseph.sharpknife.test.result.SimpleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joseph
 */
@Slf4j
@Service
public class OneNodeTimeoutService {

    @Autowired
    private TaskType oneNodeTimeoutType;
    @Autowired
    private ConcurrentScheduler concurrentScheduler;

    public void test() {
        SimpleContext context = new SimpleContext();
        SimpleResult result = new SimpleResult();
        ScheduleRequest<SimpleContext, SimpleResult> request = new ScheduleRequest<>(oneNodeTimeoutType, context, result);

        ExecutionResult executionResult = concurrentScheduler.scheduleSyn(request);
        if (executionResult.hasError()) {
            throw new RuntimeException("SingleHeadMultiDepth execute error", executionResult.getError());
        }
        log.info("SingleHeadMultiDepth done, res={}", result);
    }
}
