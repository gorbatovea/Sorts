package Structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger extends Object implements Interfaces.Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    private final Integer data;
    private final int length;
    private final int[] digits;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        String tempBuilder = data.toString();
        this.data = data;
        this.length = tempBuilder.length();
        digits = new int[length];
        for(int i = 0; i < length; i++) digits[i] = Integer.parseInt("" + tempBuilder.charAt(i));
    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {
            return digits[index];
        }
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return length;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return 0;
    }
}
