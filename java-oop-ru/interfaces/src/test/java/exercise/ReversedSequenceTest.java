package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReversedSequenceTest {
    @Test
    public void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("fedcba", text.toString());
    }

    @Test
    public void testCharAt() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals('f', text.charAt(0));
        assertEquals('e', text.charAt(1));
        assertEquals('d', text.charAt(2));
        assertEquals('c', text.charAt(3));
        assertEquals('b', text.charAt(4));
        assertEquals('a', text.charAt(5));
    }

    @Test
    public void testLength() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals(6, text.length());
    }

    @Test
    public void testSubSequence() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("edc", text.subSequence(1, 4).toString());
    }

    @Test
    public void testEmptyString() {
        CharSequence text = new ReversedSequence("");
        assertEquals("", text.toString());
        assertEquals(0, text.length());
    }

    @Test
    public void testSingleCharacterString() {
        CharSequence text = new ReversedSequence("a");
        assertEquals("a", text.toString());
        assertEquals(1, text.length());
        assertEquals('a', text.charAt(0));
    }

    @Test
    public void testCharAtOutOfBounds() {
        CharSequence text = new ReversedSequence("abcdef");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            text.charAt(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            text.charAt(6);
        });
    }

    @Test
    public void testSubSequenceOutOfBounds() {
        CharSequence text = new ReversedSequence("abcdef");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            text.subSequence(-1, 2);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            text.subSequence(2, 7);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            text.subSequence(3, 2);
        });
    }
}
