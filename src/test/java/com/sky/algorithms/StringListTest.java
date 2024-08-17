package com.sky.algorithms;

import com.sky.algorithms.Exception.ItemIsNullException;
import com.sky.algorithms.Impl.ArrayStringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStringListTest {

    private ArrayStringList list;

    @BeforeEach
    void setUp() {
        list = new ArrayStringList(5); // создаем список с начальной емкостью 5
    }

    @Test
    void testAddAndSize() {
        list.add("First");
        list.add("Second");
        assertEquals(2, list.size());
        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
    }

    @Test
    void testAddAtIndex() {
        list.add("First");
        list.add("Second");
        list.add(1, "Inserted");
        assertEquals(3, list.size());
        assertEquals("Inserted", list.get(1));
    }

    @Test
    void testSet() {
        list.add("First");
        list.add("Second");
        list.set(0, "Replaced");
        assertEquals("Replaced", list.get(0));
    }

    @Test
    void testRemoveByItem() {
        list.add("First");
        list.add("Second");
        String removed = list.remove("First");
        assertEquals("First", removed);
        assertEquals(1, list.size());
        assertFalse(list.contains("First"));
    }

    @Test
    void testRemoveByIndex() {
        list.add("First");
        list.add("Second");
        String removed = list.remove(0);
        assertEquals("First", removed);
        assertEquals(1, list.size());
        assertEquals("Second", list.get(0));
    }

    @Test
    void testContains() {
        list.add("First");
        assertTrue(list.contains("First"));
        assertFalse(list.contains("Second"));
    }

    @Test
    void testIndexOf() {
        list.add("First");
        list.add("Second");
        assertEquals(1, list.indexOf("Second"));
        assertEquals(-1, list.indexOf("Third"));
    }

    @Test
    void testLastIndexOf() {
        list.add("First");
        list.add("Second");
        list.add("First");
        assertEquals(2, list.lastIndexOf("First"));
    }

    @Test
    void testEquals() {
        ArrayStringList otherList = new ArrayStringList(5);
        list.add("First");
        list.add("Second");
        otherList.add("First");
        otherList.add("Second");
        assertTrue(list.equals(otherList));
    }

    @Test
    void testToArray() {
        list.add("First");
        list.add("Second");
        String[] array = list.toArray();
        assertArrayEquals(new String[]{"First", "Second"}, array);
    }

    @Test
    void testAddNull() {
        assertThrows(ItemIsNullException.class, () -> list.add(null));
    }

    @Test
    void testSetNull() {
        list.add("First");
        assertThrows(ItemIsNullException.class, () -> list.set(0, null));
    }

    @Test
    void testRemoveNull() {
        assertThrows(ItemIsNullException.class, () -> list.remove((String) null));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "Item"));
    }

    @Test
    void testRemoveByIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }
}
