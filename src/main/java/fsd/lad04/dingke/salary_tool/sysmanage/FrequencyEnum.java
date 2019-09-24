package fsd.lad04.dingke.salary_tool.sysmanage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum FrequencyEnum {
	
	QUARTERLY(4), HALF_YEARLY(2), ANNUALLY(1);

    private final int value;
    
    private static Map<Integer, FrequencyEnum> map = new HashMap<>();

    
    private FrequencyEnum(int value) {
        this.value = value;
    }

    
    static {
        for (FrequencyEnum frequency : FrequencyEnum.values()) {
            map.put(frequency.value, frequency);
        }
    }

    public static FrequencyEnum valueOf(Integer value) {
    	FrequencyEnum frequency = map.get(value);
        if (frequency == null) {
            throw new IllegalArgumentException("Incorrect frequency value.");
        }
        return frequency;
    }
    

    public int getValue() {
        return value;
    }

    
    public static Set<Integer> getValues() {
        return Arrays.stream(FrequencyEnum.values()).map(frequency -> frequency.getValue()).collect(Collectors.toSet());
    }
}
