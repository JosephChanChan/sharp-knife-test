package com.joseph.sharpknife.test.result;

import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Joseph
 */
@Data
public class ProductListResult {

    public AtomicInteger order = new AtomicInteger(0);

    /**
     * 执行完成先后顺序排列Node
     */
    private Map<String, Integer> executedMap = new ConcurrentHashMap<>();

    public void finishNode(String node, int order, String[] predecessors) {
        if (null != predecessors) {
            for (String predecessor : predecessors) {
                if (!executedMap.containsKey(predecessor)) {
                    throw new RuntimeException(String.format(
                            "incorrect finish order node=%s order=%s predecessor=%s", node, order, predecessor));
                }
            }
        }
        executedMap.put(node, order);
    }

    public String sort() {
        List<Object[]> nodes = executedMap.entrySet().stream().map(e -> new Object[]{e.getKey(), e.getValue()}).collect(Collectors.toList());
        nodes.sort(Comparator.comparingInt(p -> (Integer) p[1]));
        StringBuilder b = new StringBuilder();
        for (Object[] obj : nodes) {
            b.append(obj[1]).append("=").append(obj[0]).append("\r\n");
        }
        return b.toString();
    }
}
