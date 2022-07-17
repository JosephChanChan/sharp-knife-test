package com.joseph.sharpknife.test.arrange.multi.head;

import com.joseph.sharpknife.blade.annotations.TaskConfig;
import com.joseph.sharpknife.blade.context.ExecutionResult;
import com.joseph.sharpknife.blade.unit.TaskNode;
import com.joseph.sharpknife.test.context.SimpleContext;
import com.joseph.sharpknife.test.kit.ThreadKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

/**
 * @author Joseph
 * @since 2022/3/20
 */
@Slf4j
@Component("mMD7")
@DependsOn({"mMD5", "mMD6"})
@TaskConfig(taskName = "mMD7", taskType = "multiHeadMultiDepthType")
public class MMD7 implements TaskNode<SimpleContext, Integer> {
    @Override
    public BiPredicate<SimpleContext, Integer> getPrediction() {
        return (simpleContext, integerExecutionResult) -> true;
    }

    @Override
    public BiConsumer<SimpleContext, Integer> getTask() {
        return (simpleContext, integerExecutionResult) -> {
            int millis = ThreadKit.randomMillis();
            log.info("mMD7 sleeping! millis={}", millis);
            ThreadKit.sleep(millis);
        };
    }

    @Override
    public void onSuccess(SimpleContext executionContext, Integer executionResult) {
        log.info("mMD7 onSuccess! context={}", executionContext);
    }

    @Override
    public void onError(SimpleContext executionContext, Integer executionResult, Exception e) {
        log.error("mMD7 onError! e=", e);
    }
}
