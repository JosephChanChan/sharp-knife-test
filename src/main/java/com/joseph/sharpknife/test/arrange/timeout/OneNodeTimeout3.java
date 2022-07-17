package com.joseph.sharpknife.test.arrange.timeout;

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
 */
@Slf4j
@Component
@TaskConfig(taskName = "oneNodeTimeout3", taskType = "oneNodeTimeoutType")
public class OneNodeTimeout3 implements TaskNode<SimpleContext, Integer> {

    @Override
    public BiPredicate<SimpleContext, Integer> getPrediction() {
        return (context, result) -> {
            log.info("OneNodeTimeout3 prediction true");
            return true;
        };
    }

    @Override
    public BiConsumer<SimpleContext, Integer> getTask() {
        return (context, result) -> {
            int millis = ThreadKit.randomMillis();
            log.info("OneNodeTimeout3 task will cost={}", millis);
            ThreadKit.sleep(millis);
        };
    }

    @Override
    public void onSuccess(SimpleContext executionContext, Integer executionResult) {
        log.info("OneNodeTimeout3 task done");
    }

    @Override
    public void onError(SimpleContext executionContext, Integer executionResult, Exception e) {
        log.error("OneNodeTimeout3 task error", e);
    }
}
