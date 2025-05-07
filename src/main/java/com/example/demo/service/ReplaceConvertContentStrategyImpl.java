package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReplaceConvertContentStrategyImpl implements IConvetContentStrategy {

    @Override
    public String performConvert(String paramStr) {
        return recuReplaceConsecutiveChar(paramStr);
    }

    public static final Logger logger = LoggerFactory.getLogger(ReplaceConvertContentStrategyImpl.class);

    /**
     * if 3 or more consecutive characters of paramStr are identical, remove them from the string
     *
     * @param paramStr
     * @return
     */
    public static String replaceConsecutiveChar(String paramStr) {
        StringBuilder returnValue = new StringBuilder();
        String replacedStr = "";
        char newChar = 0;
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
                    }else{
                        //todo 追加前一个字母
                        newChar = 0;
                        if(currentChar>'a' && currentChar <='z'){
                            newChar = (char)(currentChar-1);
                            returnValue.append(newChar);
                        }
                        replacedStr = paramStr.substring(i, i + repeatCount);

                    }
                    //不论连续数量是多少，下一次检查时都需要跳过本轮的连续字符
                    i = i + repeatCount - 1;
                } else {
                    //没有重复则原样追加
                    returnValue = returnValue.append(currentChar);
                }
            }
        }

        if(replacedStr.length()>0 && newChar>0){
            System.out.println("-> " + returnValue.toString()+", "+replacedStr +" is replaced by "+ newChar);
        }else if(replacedStr.length()>0){
            System.out.println("-> " + returnValue.toString());
        }

        return returnValue.toString();
    }

    /**
     * Repeat removeConsecutiveChar process until there is no more than 3 identical characters sitting besides each other
     *
     * @param paramStr
     * @return
     */
    public static String recuReplaceConsecutiveChar(String paramStr) {
        String returnValue = "";
        if (null != paramStr && paramStr.length() >= 1) {
            returnValue = replaceConsecutiveChar(paramStr);
            if (!paramStr.equals(returnValue)) {
                return recuReplaceConsecutiveChar(returnValue);
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        recuReplaceConsecutiveChar("abcccbad");
    }

}
