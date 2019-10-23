package com.bosssoft.nontax.controller;

import com.bosssoft.nontax.entity.Bill;
import com.bosssoft.nontax.service.BillService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("/bill")
@RestController
public class BillController {

    @Resource
    private BillService billService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Bill saveBill(@RequestParam("agencode") String agencode){
        Bill bill = new Bill();
        bill.setId(1l);
        bill.setAgencode(agencode);
        bill.setDate("2018-01-01");
        billService.insertBill(bill);
        return bill;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Bill queryBill(){
        Bill bill = new Bill();
        bill.setAgencode("350518");
        bill.setDate("2018-01-01");
        return billService.queryBill(bill);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public int updateBill(){
        Bill bill = new Bill();
        bill.setAgencode("350518");
        bill.setDate("2018-01-02");
        return billService.updateBill(bill);
    }

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ResponseBody
    public List<Bill> queryBills(){
        Bill bill = new Bill();
        bill.setAgencode("350518");
        bill.setDate("2018-01-01");
        return billService.queryBills(bill);
    }
}