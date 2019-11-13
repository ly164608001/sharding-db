package com.bosssoft.nontax.dao;

import com.bosssoft.nontax.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillDao {

    boolean insertBill(Bill bill);

    Bill queryBill(Bill bill);

    int updateBill(Bill bill);

    List<Bill> queryBills(Bill bill);

    Bill queryBillWithItems(Bill bill);

    Bill getBillWithNoShardingTable(Bill bill);

    Map getInfoUseDefaultDataSource(String fid);

}
