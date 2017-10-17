package de.hpi.data_change.imdb.parsing;

import de.hpi.data_change.data.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoExtractor {

    Map<Character,Character> attributeBorders;

    public InfoExtractor(){
        attributeBorders = new HashMap<>();
        attributeBorders.put('[',']');
        attributeBorders.put('(',')');
        attributeBorders.put('<','>');
        attributeBorders.put('{','}');
    }

    public List<Property> extractAdditionalInfo(String additionalInfo) {
        Map<Character,Integer>  attributeCounts = new HashMap<>();
        final int length = additionalInfo.length();
        int startChar = -1;
        boolean reading = false;
        List<Property> results = new ArrayList<>();
        int startOffset = -1;
        for (int offset = 0; offset < length; ) {
            final int codepoint = additionalInfo.codePointAt(offset);
            if(attributeBorders.containsKey((char)codepoint) && !reading){
                reading = true;
                startOffset = offset+1;
                startChar = codepoint;
            } else if(reading){
                if(codepoint == attributeBorders.get((char)startChar).charValue()){
                    int endOffset = offset;
                    String attributeVal = null;
                    try {
                        attributeVal = additionalInfo.substring(startOffset, endOffset);
                    } catch(StringIndexOutOfBoundsException e){
                        e.printStackTrace();
                        throw new AssertionError();
                    }
                    results.add(new Property(buildAttributeName(attributeCounts,startChar),attributeVal));
                    reading  =false;
                }
            }
            offset += Character.charCount(codepoint);
        }
        return results;
    }

    private String buildAttributeName(Map<Character, Integer> attributeCounts, int startChar) {
        int count;
        if(attributeCounts.containsKey((char) startChar)){
            count = attributeCounts.get((char)startChar) + 1;
        } else{
            count = 1;
        }
        attributeCounts.put((char)startChar,count);
        return buildAttributeName(startChar) + "_"+count;
    }

    private String buildAttributeName(int startChar) {
        switch(startChar){
            case '[': return "squareBracket";
            case '{': return "curlyBracket";
            case '(': return "roundBracket";
            case '<': return "angularBrackte";
            default: throw new AssertionError("unknown start char type");
        }
    }
}
