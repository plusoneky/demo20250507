package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RemoveConvertContentStrategyImpl implements IConvetContentStrategy {
    @Override
    public String performConvert(String paramStr) {
        return recuRemoveConsecutiveChar(paramStr);
    }

    public static final Logger logger = LoggerFactory.getLogger(RemoveConvertContentStrategyImpl.class);

    /**
     * if 3 or more consecutive characters of paramStr are identical, remove them from the string
     *
     * @param paramStr
     * @return
     */
    public static String removeConsecutiveChar(String paramStr) {
        StringBuilder returnValue = new StringBuilder();
        if (null != paramStr && paramStr.length() >= 1) {
            for (int i = 0; i < paramStr.length(); i++) {
                char currentChar = paramStr.charAt(i);
                int repeatCount = 1;  //默认出现1次

                //计算连续出现的次数
                for (int j = i + 1; j < paramStr.length(); j++) {
                    if (paramStr.charAt(j) == currentChar) {
                        repeatCount++;
                    } else {
                        break;
                    }
                }
                //有连续出现
                if (repeatCount > 1) {
                    //连续出现数量小于3，则原样追加。否则忽略掉重复的字符串
                    if (repeatCount < 3) {
                        returnValue = returnValue.append(paramStr.substring(i, i + repeatCount));
                    }
                    //不论连续数量是多少，下一次检查时都需要跳过本轮的连续字符
                    i = i + repeatCount - 1;
                } else {
                    //没有重复则原样追加
                    returnValue = returnValue.append(currentChar);
                }
            }
        }
        return returnValue.toString();
    }


    /**
     * Repeat removeConsecutiveChar process until there is no more than 3 identical characters sitting besides each other
     *
     * @param paramStr
     * @return
     */
    public static String recuRemoveConsecutiveChar(String paramStr) {
        String returnValue = "";
        if (null != paramStr && paramStr.length() >= 1) {
            returnValue = removeConsecutiveChar(paramStr);
            if (!paramStr.equals(returnValue)) {
                System.out.println("-> " + returnValue);
                return recuRemoveConsecutiveChar(returnValue);
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        recuRemoveConsecutiveChar("aabcccbbad");
    }
}
