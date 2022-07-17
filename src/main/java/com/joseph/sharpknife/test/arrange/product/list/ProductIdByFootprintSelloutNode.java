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
@DependsOn("productIdByFootprintNode")
@TaskConfig(taskName = "productIdByFootprintSelloutNode", taskType = "productListType", timeout = 200)
public class ProductIdByFootprintSelloutNode implements TaskNode<ProductListContext, ProductListResult> {

    @Override
    public BiPredicate<ProductListContext, ProductListResult> getPrediction() {
        return ((productListContext, productListResultExecutionResult) -> {return true;});
    }

    @Override
    public BiConsumer<ProductListContext, ProductListResult> getTask() {
        return (context, result) -> {
            int millis = ThreadKit.boundMillis(200);
            log.info("productIdByFootprintSelloutNode task will cost={}", millis);
            ThreadKit.sleep(millis);
            result.finishNode("productIdByFootprintSelloutNode", result.getOrder().getAndIncrement(), new String[]{"productIdByFootprintNode"});
        };
    }

    @Override
    public void onSuccess(ProductListContext executionContext, ProductListResult executionResult) {
        log.info("productIdByFootprintSelloutNode done");
    }

    @Override
    public void onError(ProductListContext executionContext, ProductListResult executionResult, Exception e) {
        log.error("productIdByFootprintSelloutNode error", e);
    }
}
