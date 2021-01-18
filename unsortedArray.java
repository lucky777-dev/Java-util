public class unsortedArray {

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
     * Add an item in an unsorted array
     * 
     * @param tab         The unsorted array
     * @param logicalSize The logical size of the array
     * @param item        The item we want to add in the array
     * @return The new logical size of the array
     */
    public static int addItem(String[] tab, int logicalSize, String item) {
        if (logicalSize == tab.length) {
            throw new IllegalArgumentException("<error> No free place in the array !");
        }
        if (alreadyExist(tab, logicalSize, item)) {
            System.out.println("Item already exists in the array !");
        } else {
            tab[logicalSize] = item;
            logicalSize++;
        }
        return logicalSize;
    }

    /**
     * Remove an item from an unsorted array
     * 
     * @param tab         The unsorted array
     * @param logicalSize The logical size of the array
     * @param item        THe item we want to remove from the array
     * @return The new logical size of the array
     */
    public static int removeItem(String[] tab, int logicalSize, String item) {
        int pos = findIndex(tab, logicalSize, item);
        if (pos < 0) {
            throw new IllegalArgumentException("<error> The item doesn't exist in the array !");
        }
        tab[pos] = tab[logicalSize - 1];
        return logicalSize - 1;
    }

    /**
     * Figures out if an item already exists in an unsorted array
     * 
     * @param tab         The unsorted array
     * @param logicalSize The logical size of the array
     * @param item        The item we are looking for
     * @return True or false if the item exists in the array or not
     */
    public static boolean alreadyExist(String[] tab, int logicalSize, String item) {
        int currentPos = 0;
        while (currentPos < logicalSize && !tab[currentPos].equals(item)) {
            currentPos++;
        }
        return currentPos < logicalSize;
    }

    /**
     * Finds the index of a certain value in an unsorted array with a logical size
     * If not found, return -1
     * 
     * @param tab         The unsorted array
     * @param val         The value to find
     * @param logicalSize The logical size of the array
     * @return The index of the value in the array (-1 if !exist)
     */
    public static int findIndex(String[] tab, int logicalSize, String item) {
        int currentPos = 0;
        while (currentPos < logicalSize && !tab[currentPos].equals(item)) {
            currentPos++;
        }
        return currentPos < logicalSize ? currentPos : -1;
    }
}
