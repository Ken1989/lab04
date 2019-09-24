package fsd.lad04.dingke.salary_tool;

import fsd.lad04.dingke.salary_tool.sysmanage.SystemInput;
import fsd.lad04.dingke.salary_tool.util.SystemInputBuilder;
import fsd.lad04.dingke.salary_tool.util.TableGenerator;

/**
 * Hello world!
 *
 */
public class SalaryTools {
	
	
	public static void main(String[] args) {
		SalaryTools predictor = new SalaryTools();
		SystemInput input = predictor.getInputFromTerminal();
		predictor.predict(input);
	}

	private void predict(SystemInput input) {
		new TableGenerator(input).buildPart();
	}

	private SystemInput getInputFromTerminal() {
		return new SystemInputBuilder().collectStartingSalary().collectIncrementInPercent().collectIncrementFrequency()
				.collectDeductionsOnIncome().collectDeductionsFrequency().collectPredictionYears().build();
	}
}
