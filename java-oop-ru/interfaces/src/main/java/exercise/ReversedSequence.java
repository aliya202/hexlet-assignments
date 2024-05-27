package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String original;
    String reversed;

    public ReversedSequence(String original) {
        this.original = original;
        this.reversed = new StringBuilder(original).reverse().toString();
    }

    @Override
    public int length() {
        return reversed.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= reversed.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return reversed.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > reversed.length() || start > end) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return reversed.subSequence(start, end);
    }

    @Override
    public String toString() {
        return reversed;
    }
}
// END
