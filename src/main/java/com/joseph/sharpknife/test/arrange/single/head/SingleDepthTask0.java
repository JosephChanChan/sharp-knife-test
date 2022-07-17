package com.joseph.sharpknife.test.arrange.single.head;

import com.joseph.sharpknife.blade.annotations.TaskConfig;
import com.joseph.sharpknife.blade.context.ExecutionResult;
import com.joseph.sharpknife.blade.unit.TaskNode;
import com.joseph.sharpknife.test.context.SimpleContext;
import com.joseph.sharpknife.test.kit.ThreadKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

/**
 * @author Joseph
 * @since 2022/3/6
 */
@Slf4j
@Component
@TaskConfig(taskName = "singleDepthTask0", taskType = "singleDepthTaskType")
public class SingleDepthTask0 implements TaskNode<SimpleContext, Integer> {



    @Override
    public BiPredicate<SimpleContext, Integer> getPrediction() {
        return (simpleContext, integerExecutionResult) -> {
            log.info("SingleDepthTask0 prediction executing");
            return true;
        };
    }

    @Override
    public BiConsumer<SimpleContext, Integer> getTask() {
        return (simpleContext, integerExecutionResult) -> {
            int millis = ThreadKit.randomMillis();
            log.info("SingleDepthTask0 sleeping! millis={}", millis);
            ThreadKit.sleep(millis);
        };
    }

    @Override
    public void onSuccess(SimpleContext executionContext, Integer executionResult) {
        log.info("SingleDepthTask0 onSuccess! context={}", executionContext);
    }

    @Override
    public void onError(SimpleContext executionContext, Integer executionResult, Exception e) {
        log.error("SingleDepthTask0 onError! e=", e);
    }
}
