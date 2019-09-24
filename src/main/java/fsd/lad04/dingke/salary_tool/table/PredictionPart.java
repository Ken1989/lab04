package fsd.lad04.dingke.salary_tool.table;

import java.math.BigDecimal;
import java.util.List;
import com.google.common.collect.Lists;

import fsd.lad04.dingke.salary_tool.entity.DeductionData;
import fsd.lad04.dingke.salary_tool.entity.IncrementData;
import fsd.lad04.dingke.salary_tool.entity.PredictionData;

public class PredictionPart extends PrintTableTool {

	  public List<PredictionData> calculateData(List<IncrementData> incrementDatas, List<DeductionData> deductionDatas) {
		  List<PredictionData> predictionDataList = Lists.newArrayList();

	        for (int i = 0; i < predictionDataList.size(); i++) {
	            IncrementData incData = incrementDatas.get(i);
	            DeductionData decData = deductionDatas.get(i);

	            BigDecimal start = incData.getSalary();
	            if (i > 0) {
	                PredictionData lastData = predictionDataList.get(i - 1);
	                start = lastData.getSalary().add(lastData.getSalaryGrowth());
	            }

	            PredictionData predictionData = new PredictionData();
	            predictionData.setYear(incData.getYear());
	            predictionData.setSalary(start);
	            predictionData.setIncrementAmount(incData.getAmount());
	            predictionData.setDeductionAmount(decData.getAmount());
	            predictionData.setSalaryGrowth(incData.getAmount().subtract(decData.getAmount()));
	            predictionDataList.add(predictionData);

	            boolean noMoreSalary = predictionData.getSalary().add(predictionData.getSalaryGrowth()).compareTo(BigDecimal.ZERO) <= 0;
	            if (i != incrementDatas.size() - 1 && noMoreSalary) {
	                PredictionData endData = new PredictionData();
	                endData.setYear(incData.getYear() + 1);
	                endData.setSalary(BigDecimal.ZERO);
	                endData.setIncrementAmount(BigDecimal.ZERO);
	                endData.setDeductionAmount(BigDecimal.ZERO);
	                endData.setSalaryGrowth(BigDecimal.ZERO);
	                predictionDataList.add(endData);
	                break;
	            }

	        }
	        return predictionDataList;
    }
	
	  public void print(List<PredictionData> predictionData) {
	        section("c. Prediction");

	        String format = "%-5s | %16s | %16s | %16s | %16s\n";
	        System.out.format(format, "Year", "Starting Salary", "Increment Amount", "Deduction Amount", "Salary Growth");


	        for (PredictionData row : predictionData) {
	            System.out.format(format, row.getSalaryData());
	        }

	    }
}
