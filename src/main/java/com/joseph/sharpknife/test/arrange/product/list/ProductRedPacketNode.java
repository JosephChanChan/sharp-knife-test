package com.joseph.sharpknife.test.arrange.product.list;

import com.joseph.sharpknife.blade.annotations.TaskConfig;
import com.joseph.sharpknife.blade.unit.TaskNode;
import com.joseph.sharpknife.test.context.ProductListContext;
import com.joseph.sharpknife.test.kit.ThreadKit;
import com.joseph.sharpknife.test.result.ProductListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

/**
 * @author Joseph
 */
@Slf4j
@Component
@DependsOn({"productIdAfterNode", "productBusinessLineNode"})
@TaskConfig(taskName = "productRedPacketNode", taskType = "productListType", timeout = 100)
public class ProductRedPacketNode implements TaskNode<ProductListContext, ProductListResult> {

    @Override
    public BiPredicate<ProductListContext, ProductListResult> getPrediction() {
        return ((productListContext, productListResultExecutionResult) -> {return true;});
    }

    @Override
    public BiConsumer<ProductListContext, ProductListResult> getTask() {
        return (context, result) -> {
            int millis = ThreadKit.boundMillis(105);
            log.info("productRedPacketNode task will cost={}", millis);
            ThreadKit.sleep(millis);
            result.finishNode("productRedPacketNode", result.getOrder().getAndIncrement(),
                    new String[]{
                            "productIdAfterNode",
                            "productBusinessLineNode"
                    });
        };
    }

    @Override
    public void onSuccess(ProductListContext executionContext, ProductListResult executionResult) {
        log.info("productRedPacketNode done");
    }

    @Override
    public void onError(ProductListContext executionContext, ProductListResult executionResult, Exception e) {
        log.error("productRedPacketNode error", e);
    }
}
