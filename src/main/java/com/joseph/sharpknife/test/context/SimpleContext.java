package com.joseph.sharpknife.test.context;

import com.joseph.sharpknife.blade.context.ExecutionContext;
import lombok.Data;

import java.util.List;

/**
 * @author Joseph
 * @since 2022/3/8 9:10 PM
 */
@Data
public class SimpleContext extends ExecutionContext {

    private List<Integer> list;


}
