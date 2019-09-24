package fsd.lad04.dingke.salary_tool.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class PredictionData extends BaseSalaryData{

    private BigDecimal incrementAmount = BigDecimal.ZERO;
    private BigDecimal deductionAmount = BigDecimal.ZERO;
    private BigDecimal salaryGrowth = BigDecimal.ZERO;

    @Override
    public Object[] getSalaryData() {
    	
        return new Object[]{this.getYear(), 
        		formatMoney(this.getSalary()), 
        		formatMoney(this.getIncrementAmount()), 
        		formatMoney(this.getDeductionAmount()), 
        		formatMoney(this.getSalaryGrowth())}
        ;
        
    }
}
