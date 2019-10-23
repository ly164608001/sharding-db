package com.bosssoft.nontax.sharding.strategy;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Slf4j
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<String>, RangeShardingAlgorithm<String> {

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

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return null;
    }
}
