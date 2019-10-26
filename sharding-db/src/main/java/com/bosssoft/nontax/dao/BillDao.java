package com.bosssoft.nontax.dao;

import com.bosssoft.nontax.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillDao {

    boolean insertBill(Bill bill);

    Bill queryBill(Bill bill);

    int updateBill(Bill bill);

    List<Bill> queryBills(Bill bill);

    Bill queryBillWithItems(Bill bill);
}
