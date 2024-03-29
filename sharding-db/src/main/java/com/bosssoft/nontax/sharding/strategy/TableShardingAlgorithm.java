package com.bosssoft.nontax.sharding.strategy;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * @desc 票据表分表算法
 * @author ly
 * @date 2019-10-24
 */
@Slf4j
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<String>, RangeShardingAlgorithm<String> {

    private static final String TABLENAME = "une_cbill_";

    private static final String SPLIT = "-";

    /**
     * 精确查找表，适用in 或者 =
     * @param availableTargetNames 可用表
     * @param shardingValue 分片值
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        log.info("collection:" + JSON.toJSONString(availableTargetNames) + ",preciseShardingValue:" + JSON.toJSONString(shardingValue));
        String logicTableName = shardingValue.getLogicTableName() + "_";
        StringBuilder tableName = new StringBuilder(logicTableName);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(shardingValue.getValue());
            String year = String.format("%tY", date);
            String mon  = String.format("%tm",date);
            String day  = String.format("%td",date);
            tableName.append(year).append(mon).append(day);
        } catch (Exception e) {
            log.error("根据日期分片获取物理表信息异常",e);
        }
        for (String targetNames : availableTargetNames) {
            if (targetNames.equals(tableName.toString())) {
                return targetNames;
            }
        }
        return null;
    }

    /**
     * 范围查询表，适用between
     * @param availableTargetNames 可用表
     * @param shardingValue 分片值
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        log.info("Range collection:" + JSON.toJSONString(availableTargetNames) + ",rangeShardingValue:" + JSON.toJSONString(shardingValue));
        Range<String> range = shardingValue.getValueRange();
        int startDate = Convert.toInt(StrUtil.removeAll(range.lowerEndpoint(),SPLIT));
        int endDate = Convert.toInt(StrUtil.removeAll(range.upperEndpoint(),SPLIT));
        Collection<String> targetNames = Lists.newLinkedList();
        for(String targetName : availableTargetNames){
            int tableDate = getTableDate(targetName);
            if(startDate <= tableDate && tableDate <= endDate){
                targetNames.add(targetName);
            }
        }
        return targetNames;
    }

    /**
     * 根据目标表名获取日期
     * @param targetNames
     * @return
     */
    private final int getTableDate(String targetNames){
        String date = StrUtil.removePrefix(targetNames,TABLENAME);
        return Convert.toInt(date);
    }
}
