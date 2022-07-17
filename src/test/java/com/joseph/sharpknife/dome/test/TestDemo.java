package com.joseph.sharpknife.dome.test;

import com.joseph.sharpknife.test.Boot;
import com.joseph.sharpknife.test.kit.ThreadKit;
import com.joseph.sharpknife.test.service.normal.MultiHeadMultiDepth;
import com.joseph.sharpknife.test.service.normal.ProductListService;
import com.joseph.sharpknife.test.service.normal.SingleHead;
import com.joseph.sharpknife.test.service.normal.SingleHeadMultiDepth;
import com.joseph.sharpknife.test.service.timeout.OneNodeTimeoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Joseph
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class)
public class TestDemo {

    @Autowired
    private SingleHead singleHead;
    @Autowired
    private SingleHeadMultiDepth singleHeadMultiDepth;
    @Autowired
    private MultiHeadMultiDepth multiHeadMultiDepth;
    @Autowired
    private OneNodeTimeoutService oneNodeTimeoutService;
    @Autowired
    private ProductListService productListService;

    @Test
    public void singleHead() {
        singleHead.test();
    }

    @Test
    public void singleHeadMultiDepth() {
        singleHeadMultiDepth.test();
    }

    @Test
    public void multiHeadMultiDepth() {
        Thread t = new Thread(() -> multiHeadMultiDepth.test());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void timeoutTest() {
        Thread t = new Thread(() -> oneNodeTimeoutService.test());
        t.start();
        try {
            t.join();
            ThreadKit.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void productListTest() {
        Thread t = new Thread(() -> productListService.test());
        t.start();
        try {
            t.join();
            /*ThreadKit.sleep(10000);*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
