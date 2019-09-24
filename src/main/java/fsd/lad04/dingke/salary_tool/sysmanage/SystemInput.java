package fsd.lad04.dingke.salary_tool.sysmanage;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SystemInput {

	private BigDecimal startingSalary;
    private double incInPercent;
    private FrequencyEnum incFrequency;
    private BigDecimal deductionsOnIncome;
    private FrequencyEnum decFrequency;
    private int years;

}
