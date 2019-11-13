package com.bosssoft.nontax.service;

import com.bosssoft.nontax.entity.Bill;

import java.util.List;
import java.util.Map;

public interface BillService {

    boolean insertBill(Bill bill);

    Bill queryBill(Bill bill);

    int updateBill(Bill bill);

    List<Bill> queryBills(Bill bill);

    Bill queryBillWithItems(Bill bill);

    Bill getBillWithNoShardingTable(Bill bill);

    Map getInfoUseDefaultDataSource(String fid);

}
