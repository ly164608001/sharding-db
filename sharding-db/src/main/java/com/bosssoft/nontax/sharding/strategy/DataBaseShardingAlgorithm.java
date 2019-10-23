package com.bosssoft.nontax.sharding.strategy;

import com.alibaba.fastjson.JSON;
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

@Slf4j
public class DataBaseShardingAlgorithm implements PreciseShardingAlgorithm<String>, RangeShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        log.info("collection:" + JSON.toJSONString(availableTargetNames) + ",preciseShardingValue:" + JSON.toJSONString(shardingValue));
        StringBuilder dataBaseName = new StringBuilder("db");
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(shardingValue.getValue());
            String year = String.format("%tY", date);
            dataBaseName.append(year) ;
        } catch (Exception e) {
            log.error("根据日期分片获取数据库信息异常",e);
        }
        for (String targetNames : availableTargetNames) {
            if (targetNames.equals(dataBaseName.toString())) {
                return targetNames;
            }
        }
        return null;
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        log.info("Range collection:" + JSON.toJSONString(availableTargetNames) + ",rangeShardingValue:" + JSON.toJSONString(shardingValue));
        Collection<String> dbs = new LinkedHashSet<>(availableTargetNames.size());
        Range<String> range = (Range<String>) shardingValue.getValueRange();

        return dbs;
    }
}
