public class sortedArray {

    /**
     * Shows an array with a logical size
     * 
     * @param tab         The array
     * @param logicalSize The logical size of the array
     */
    public static void showArray(String[] tab, int logicalSize) {
        for (int i = 0; i < logicalSize; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    /**
     * Add an item in a sorted array with a logical size
     * 
     * @param tab         The sorted array
     * @param logicalSize The logical size of the array
     * @param item        The item we want to add in the array
     * @return The new logical size of the array
     */
    public static int addItem(int[] tab, int logicalSize, int item) {
        if (logicalSize == tab.length) {
            throw new IllegalArgumentException("<error> No free place in the array !");
        }
        if (alreadyExist(tab, logicalSize, item)) {
            System.out.println("Item already exists in the array !");
            return logicalSize;
        }
        int pos = findNewPos(tab, logicalSize, item);
        rightShift(tab, logicalSize, pos);
        tab[pos] = item;
        return logicalSize + 1;
    }

    /**
     * Remove an item from a sorted array with a logical size
     * 
     * @param tab         The sorted array
     * @param logicalSize THe logical size of the array
     * @param item        The item we want to remove from the array
     * @return The new logical size of the array
     */
    public static int removeItem(int[] tab, int logicalSize, int item) {
        int pos = findIndex(tab, logicalSize, item);
        if (pos < 0) {
            throw new IllegalArgumentException("<error> The item doesn't exist in the array !");
        }
        leftShift(tab, logicalSize, pos);
        return logicalSize - 1;
    }

    /**
     * Figures out if an item already exists in a sorted array
     * 
     * @param tab         The sorted array
     * @param logicalSize The logical size of the array
     * @param item        The item we are looking for
     * @return True or false if the item exists in the array or not
     */
    public static boolean alreadyExist(int[] tab, int logicalSize, int item) {
        int currentPos = 0;
        while (currentPos < logicalSize && tab[currentPos] < item) {
            currentPos++;
        }
        return currentPos < logicalSize && tab[currentPos] == item;
    }

    /**
     * Finds the index of a certain value in a sorted array with a logical size If
     * not found, return -1
     * 
     * @param tab         The sorted array
     * @param val         The value to find
     * @param logicalSize The logical size of the array
     * @return The index of the value in the array (-1 if !exist)
     */
    public static int findIndex(int[] tab, int logicalSize, int item) {
        int currentPos = 0;
        while (currentPos < logicalSize && tab[currentPos] < item) {
            currentPos++;
        }
        return currentPos < logicalSize ? currentPos : -1;
    }

    /**
     * Find the index where we want to begin the rightShift() method, in a sorted
     * array with a logical size
     * 
     * @param tab         The sorted array
     * @param logicalSize The logical size of the array
     * @param item        The item we want to insert in the sorted array
     * @return The first index for the rightShift() method
     */
    public static int findNewPos(int[] tab, int logicalSize, int item) {
        int pos = 0;
        while (pos < logicalSize && tab[pos] < item) {
            pos++;
        }
        return pos;
    }

    /**
     * Shift items to the right in a sorted array with a logical size, from an index
     * to the logical size
     * 
     * @param tab         The sorted array
     * @param logicalSize The logical size of the array
     * @param pos         The index we want to start with
     */
    public static void rightShift(int[] tab, int logicalSize, int pos) {
        for (int i = logicalSize; i > pos; i--) {
            tab[i] = tab[i - 1];

        }
    }

    /**
     * Shft items to the left in a sorted array with a logical size, from an index
     * to the logical size
     * 
     * @param tab         The sorted array
     * @param logicalSize The logical size of the array
     * @param pos         The index we want to start with
     */
    public static void leftShift(int[] tab, int logicalSize, int pos) {
        for (int i = pos + 1; i <= logicalSize; i++) {
            tab[i - 1] = tab[i];
        }
    }
}
