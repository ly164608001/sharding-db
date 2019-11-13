package com.bosssoft.nontax.service.impl;

import com.bosssoft.nontax.dao.BillDao;
import com.bosssoft.nontax.entity.Bill;
import com.bosssoft.nontax.service.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillDao billDao;


    @Override
    public boolean insertBill(Bill bill) {
        return billDao.insertBill(bill);
    }

    @Override
    public Bill queryBill(Bill bill) {
        return billDao.queryBill(bill);
    }

    @Override
    public int updateBill(Bill bill) {
        return billDao.updateBill(bill);
    }

    @Override
    public List<Bill> queryBills(Bill bill) {
        return billDao.queryBills(bill);
    }

    @Override
    public Bill queryBillWithItems(Bill bill) {
        return billDao.queryBillWithItems(bill);
    }

    @Override
    public Bill getBillWithNoShardingTable(Bill bill) {
        return billDao.getBillWithNoShardingTable(bill);
    }

    @Override
    public Map getInfoUseDefaultDataSource(String fid) {
        return billDao.getInfoUseDefaultDataSource(fid);
    }
}
