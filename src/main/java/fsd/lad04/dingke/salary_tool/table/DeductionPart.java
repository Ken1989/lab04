package fsd.lad04.dingke.salary_tool.table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.google.common.collect.Lists;

import fsd.lad04.dingke.salary_tool.entity.DeductionData;
import fsd.lad04.dingke.salary_tool.sysmanage.SystemInput;

public class DeductionPart extends PrintTableTool {

	public List<DeductionData> calculateData(SystemInput input) {
        List<DeductionData> deductionDataList = Lists.newArrayList();

        for (int i = 0; i < input.getYears(); i++) {

            // deductions
            BigDecimal start = input.getStartingSalary();
            if (i > 0) {
                DeductionData lastData = deductionDataList.get(i - 1);
                start = lastData.getSalary().subtract(lastData.getAmount());
            }

            int times = input.getDecFrequency().getValue();
            BigDecimal decOnIncome = input.getDeductionsOnIncome();
            BigDecimal amount = decOnIncome.multiply(new BigDecimal(times));

            boolean isZero = start.equals(BigDecimal.ZERO);
            double percent = isZero ? 0 : amount.multiply(new BigDecimal(100)).divide(start, 2, RoundingMode.HALF_UP).doubleValue();

            DeductionData deduction = new DeductionData();
            deduction.setYear(i + 1).setSalary(start).setTimes(times).setPercent(percent).setAmount(amount);
            deductionDataList.add(deduction);
        }
        return deductionDataList;
    }

    public void print(List<DeductionData> Datas) {
        section("b. Deduction Report");

        String format = "%-5s | %16s | %16s | %12s | %16s\n";
        System.out.format(format, "Year", "Starting Salary", "# of Deductions", "Deduction %", "Deduction Amount");

        for (DeductionData data : Datas) {
            System.out.format(format, data.getSalaryData());
        }

    }

}
