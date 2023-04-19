package org.workshop.api.generators;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomData {

    private final Random random = new Random();
    private static final int STRING_LENGTH = 10;
    private static final int MAX_VALUE_FOR_INT = 214748365;
    public String getString(){
        return "test" + RandomStringUtils.randomAlphanumeric(STRING_LENGTH);
    }

    public Boolean getBoolean(){
        return random.nextBoolean();
    }

    public int getInteger(){
        return random.nextInt(MAX_VALUE_FOR_INT);
    }

}
