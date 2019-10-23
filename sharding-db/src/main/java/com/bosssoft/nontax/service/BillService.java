package com.bosssoft.nontax.service;

import com.bosssoft.nontax.entity.Bill;

import java.util.List;

public interface BillService {

    boolean insertBill(Bill bill);

    Bill queryBill(Bill bill);

    int updateBill(Bill bill);

    List<Bill> queryBills(Bill bill);

}
