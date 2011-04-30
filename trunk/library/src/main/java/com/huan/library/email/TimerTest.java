package com.huan.library.email;

import java.util.List;
import java.util.Timer;


import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.domain.service.impl.BorrowReturnServiceImpl;

public class TimerTest {

	public static void main(String[] args){
	Timer timer = new Timer();
	timer.schedule(new MyTask(), 1000, 10*1000);//在1秒后执行此任务,每次间隔2秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
  }
    
	static class MyTask extends java.util.TimerTask{

	SendMailToSomeone sts=new SendMailToSomeone();
	@Override
	public void run() {
		BorrowReturnService borrowReturnService = new BorrowReturnServiceImpl();
		List<BorrowReturn> borrowReturns = borrowReturnService.aboutToDueBorrowReturns();
		for(BorrowReturn borrowReturn:borrowReturns){
			sts.send("aa", "hello", borrowReturn.getReader().getEmail(),
					"jacksnh@163.com", "huan10011099", "smtp.163.com");
		}
	  }
 	}
}