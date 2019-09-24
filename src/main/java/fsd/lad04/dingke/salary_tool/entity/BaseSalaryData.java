package fsd.lad04.dingke.salary_tool.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class BaseSalaryData {

	private int year;

	private BigDecimal salary = BigDecimal.ZERO;
	
	private BigDecimal amount = BigDecimal.ZERO;

	private int times;

	private double percent;

	/**
	 * Get the corresponding salary data
	 * If sub-class has another rule, it can override this function
	 * @return
	 */
	public Object[] getSalaryData() {
		return new Object[]{
                this.getYear(), formatMoney(this.getSalary()), this.getTimes(), this.getPercent(), formatMoney(this.getAmount())
        };
	}
	
	
	/**
	 * Format the money to standard data
	 * @param money
	 * @return
	 */
	protected  double formatMoney(BigDecimal money) {
        money = money.setScale(2, RoundingMode.HALF_UP);
        return money.doubleValue();
    };
}
