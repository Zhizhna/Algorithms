package com.sky.algorithms.Impl;

import com.sky.algorithms.Exception.ItemIsNullException;
import com.sky.algorithms.Exception.ListFullException;
import com.sky.algorithms.Service.StringList;

import java.util.Arrays;

    public class ArrayStringList implements StringList  {
        private final String[] items;
        private int size;

        public ArrayStringList(int initialCapacity) {
            if (initialCapacity <= 0) {
                throw new IllegalArgumentException("Initial capacity must be greater than zero.");
            }
            items = new String[initialCapacity];
            size = 0;
        }

        @Override
        public String add(String item) {
            checkNull(item);
            ensureCapacity();
            items[size++] = item;
            return item;
        }

        @Override
        public String add(int index, String item) {
            checkNull(item);
            checkIndexForAdd(index);
            ensureCapacity();
            System.arraycopy(items, index, items, index + 1, size - index);
            items[index] = item;
            size++;
            return item;
        }

        @Override
        public String set(int index, String item) {
            checkNull(item);
            checkIndex(index);
            String oldItem = items[index];
            items[index] = item;
            return oldItem;
        }

        @Override
        public String remove(String item) {
            checkNull(item);
            int index = indexOf(item);
            if (index == -1) {
                throw new ItemIsNullException("Item not found in the list.");
            }
            return remove(index);
        }

        @Override
        public String remove(int index) {
            checkIndex(index);
            String removedItem = items[index];
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(items, index + 1, items, index, numMoved);
            }
            items[--size] = null; // освобождаем последний элемент
            return removedItem;
        }

        @Override
        public boolean contains(String item) {
            checkNull(item);
            return indexOf(item) != -1;
        }

        @Override
        public int indexOf(String item) {
            checkNull(item);
            for (int i = 0; i < size; i++) {
                if (items[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(String item) {
            checkNull(item);
            for (int i = size - 1; i >= 0; i--) {
                if (items[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public String get(int index) {
            checkIndex(index);
            return items[index];
        }

        @Override
        public boolean equals(StringList otherList) {
            if (otherList == null) {
                throw new NullPointerException("The other list must not be null.");
            }
            if (this == otherList) {
                return true;
            }
            if (size() != otherList.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!items[i].equals(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty(String item) {
            return item != null;
        }

        @Override
        public void clear() {
            Arrays.fill(items, 0, size, null);
            size = 0;
        }

        @Override
        public String[] toArray() {
            return Arrays.copyOf(items, size);
        }

        // Вспомогательные методы
        private void checkNull(String item) {
            if (item == null) {
                throw new ItemIsNullException("Null items are not allowed.");
            }
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + index);
            }
        }

        private void checkIndexForAdd(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index out of bounds for add: " + index);
            }
        }

        private void ensureCapacity() {
            if (size == items.length) {
                throw new ListFullException("List is full.");
            }
        }
    }
