package fsd.lad04.dingke.salary_tool.util;

import java.util.List;

import fsd.lad04.dingke.salary_tool.entity.DeductionData;
import fsd.lad04.dingke.salary_tool.entity.IncrementData;
import fsd.lad04.dingke.salary_tool.entity.PredictionData;
import fsd.lad04.dingke.salary_tool.sysmanage.SystemInput;
import fsd.lad04.dingke.salary_tool.table.DeductionPart;
import fsd.lad04.dingke.salary_tool.table.IncrementPart;
import fsd.lad04.dingke.salary_tool.table.PredictionPart;


public class TableGenerator {
	
	
	private SystemInput input;

    public TableGenerator(SystemInput input) {
        this.input = input;
    }

    public void buildPart() {
        IncrementPart Part = new IncrementPart();
        List<IncrementData> incrementData = Part.calculateData(input);
        Part.print(incrementData);

        DeductionPart deductionPart = new DeductionPart();
        List<DeductionData> deductionData = deductionPart.calculateData(input);
        deductionPart.print(deductionData);


        PredictionPart predictionPart = new PredictionPart();
        List<PredictionData> predictionData = predictionPart.calculateData(incrementData, deductionData);
        predictionPart.print(predictionData);
    }


}
