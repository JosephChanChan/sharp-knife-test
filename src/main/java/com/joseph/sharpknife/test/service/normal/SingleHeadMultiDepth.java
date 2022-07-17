package com.joseph.sharpknife.test.service.normal;

import com.joseph.sharpknife.blade.context.ExecutionResult;
import com.joseph.sharpknife.blade.context.ScheduleRequest;
import com.joseph.sharpknife.blade.scheduler.ConcurrentScheduler;
import com.joseph.sharpknife.test.context.SimpleContext;
import com.joseph.sharpknife.test.result.SimpleResult;
import com.joseph.sharpknife.test.tasktype.SingleDepthTaskType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joseph
 * @since 2022/3/6 9:20 PM
 */
@Slf4j
@Service
public class SingleHeadMultiDepth {

    @Autowired
    private SingleDepthTaskType taskType;
    @Autowired
    private ConcurrentScheduler concurrentScheduler;

    public void test() {
        SimpleContext context = new SimpleContext();
        SimpleResult result = new SimpleResult();
        ScheduleRequest<SimpleContext, SimpleResult> request = new ScheduleRequest<>(taskType, context, result);

        ExecutionResult executionResult = concurrentScheduler.scheduleSyn(request);
        if (executionResult.hasError()) {
            throw new RuntimeException("SingleHeadMultiDepth execute error", executionResult.getError());
        }
        log.info("SingleHeadMultiDepth done, res={}", result);
    }

}
