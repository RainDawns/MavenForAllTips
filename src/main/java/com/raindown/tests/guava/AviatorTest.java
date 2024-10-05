package com.raindown.tests.guava;


import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AviatorTest {

    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new StrCompareIgnoreCase());
        AviatorEvaluator.addFunction(new NumBetweenMinAndMax());
        AviatorEvaluator.addFunction(new StrContainsIgnoreCase());
        HashMap<String, Object> map = new HashMap<>();
        map.put("chanel","UPS_GROUND");
        map.put("adress","test123");
        map.put("product",80.50f);

        Instant start = Instant.now();

        Object execute = AviatorEvaluator.
                execute("(strCompareIgnoreCase(chanel, 'UPS_GROUND')) && (strContainsIgnoreCase(adress,'test')) && (numBetweenMinAndMax( '90',product,'120'))",
                        map, true);

//        System.out.println(execute);
        Object execute1 = AviatorEvaluator.
                execute("(numBetweenMinAndMax( '90',product,'120'))",
                        map, true);
//        System.out.println(execute1);

        Object execute2 = AviatorEvaluator.
                execute("(strContainsIgnoreCase(adress,'test'))",
                        map, true);


        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time in milliseconds: " + duration.toMillis());

    }





    public static class StrCompareIgnoreCase extends AbstractFunction {

        @Override
        public String getName() {
            return "strCompareIgnoreCase";
        }

        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            String num1 = FunctionUtils.getStringValue(arg1, env).toLowerCase();
            String num2 = FunctionUtils.getStringValue(arg2, env).toLowerCase();
            if(num1.compareTo(num2) == 0){
                return AviatorBoolean.TRUE;
            }
            return AviatorBoolean.FALSE;
        }

    }


    public static class NumBetweenMinAndMax extends AbstractFunction {

        @Override
        public String getName() {
            return "numBetweenMinAndMax";
        }

        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
            String minValue = FunctionUtils.getStringValue(arg1, env);
            Number numberValue = FunctionUtils.getNumberValue(arg2, env);
            String maxValue = FunctionUtils.getStringValue(arg3, env);
            if(Float.valueOf(numberValue.floatValue()) >= Float.valueOf(minValue)  && Float.valueOf(numberValue.floatValue()) <= Float.valueOf(maxValue) ){
                return AviatorBoolean.TRUE;
            }
            return AviatorBoolean.FALSE;
        }

    }


    public static class StrContainsIgnoreCase extends AbstractFunction {

        @Override
        public String getName() {
            return "strContainsIgnoreCase";
        }

        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            String value= FunctionUtils.getStringValue(arg1, env).toLowerCase();
            String key = FunctionUtils.getStringValue(arg2, env).toLowerCase();
            System.out.println("value:"+value);
            System.out.println("key:"+key);
            if(value.contains(key)){
                return AviatorBoolean.TRUE;
            }
            return AviatorBoolean.FALSE;
        }

    }
}
