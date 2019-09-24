package fsd.lad04.dingke.salary_tool.table;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

import fsd.lad04.dingke.salary_tool.entity.IncrementData;
import fsd.lad04.dingke.salary_tool.sysmanage.SystemInput;

public class IncrementPart extends PrintTableTool{
	
	 public List<IncrementData> calculateData(SystemInput input) {
	        List<IncrementData> incrementDataList = Lists.newArrayList();
	        for (int i = 0; i < input.getYears(); i++) {

	            // increment
	            BigDecimal start = input.getStartingSalary();
	            if (i > 0) {
	                IncrementData lastData = incrementDataList.get(i - 1);
	                start = lastData.getSalary().add(lastData.getAmount());
	            }

	            int times = input.getIncFrequency().getValue();
	            double percent = input.getIncInPercent();
	            BigDecimal nextStart = new BigDecimal(start.toString());
	            for (int j = 0; j < times; j++) {
	                nextStart = nextStart.multiply(new BigDecimal(1 + percent / 100));
	            }
	            BigDecimal amount = nextStart.subtract(start);


	            IncrementData incrementData = new IncrementData();
	            incrementData.setYear(i + 1).setSalary(start).setTimes(times).setPercent(percent).setAmount(amount);
	            incrementDataList.add(incrementData);
	        }
	        return incrementDataList;
	    }

	    public void print(List<IncrementData> Datas) {
	        section("a. Increment Report");

	        String format = "%-5s | %16s | %16s | %12s | %16s\n";
	        System.out.format(format, "Year", "Starting Salary", "# of Increments", "Increment %", "Increment Amount");


	        for (IncrementData Data : Datas) {
	            System.out.format(format, Data.getSalaryData());
	        }

	    }
}
