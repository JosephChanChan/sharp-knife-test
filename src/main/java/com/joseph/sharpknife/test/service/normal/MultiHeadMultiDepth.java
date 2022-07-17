package com.joseph.sharpknife.test.service.normal;

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
 * @since 2022/3/6 9:21 PM
 */
@Slf4j
@Service
public class MultiHeadMultiDepth {

    @Autowired
    private TaskType multiHeadMultiDepthType;
    @Autowired
    private ConcurrentScheduler concurrentScheduler;

    public void test() {
        SimpleContext context = new SimpleContext();
        SimpleResult result = new SimpleResult();
        ScheduleRequest<SimpleContext, SimpleResult> request = new ScheduleRequest<>(multiHeadMultiDepthType, context, result);

        ExecutionResult executionResult = concurrentScheduler.scheduleSyn(request);
        if (executionResult.hasError()) {
            throw new RuntimeException("MultiHeadMultiDepth execute error", executionResult.getError());
        }
        log.info("MultiHeadMultiDepth done, res={}", result);
    }

}
