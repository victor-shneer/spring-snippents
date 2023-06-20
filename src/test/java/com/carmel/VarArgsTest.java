package com.carmel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VarArgsTest {
    public String appendString(String...s){
        StringBuffer stringBuffer = new StringBuffer();
        for(String str : s){
            stringBuffer.append(str); // Use String buffer for concatenation if performance matters
        }
        return stringBuffer.toString();
    }

    @Test
    void varArgs(){
        assertThat(appendString("1", "2", "3")).isEqualTo("123");
    }
}
