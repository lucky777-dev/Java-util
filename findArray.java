public class findArray {

    /*
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ UNSORTED ARRAY
     */

    /**
     * Finds the index of a certain value in an unsorted array with a logical size
     * If not found, return -1
     * 
     * @param tab         The unsorted array
     * @param val         The value to find
     * @param logicalSize The logical size of the array
     * @return The index of the value in the array (-1 if !found)
     */
    public static int findIndexUnsortedArray(String[] tab, int logicalSize, String item) {
        int currentPos = 0;
        while (currentPos < logicalSize && tab[currentPos] != item) {
            currentPos++;
        }
        return currentPos < logicalSize ? currentPos : -1;
    }

    /*
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ SORTED ARRAY
     */

    /**
     * Finds the index of a certain value in a sorted array with a logical size If
     * not found, return -1
     * 
     * @param tab         The sorted array
     * @param val         The value to find
     * @param logicalSize The logical size of the array
     * @return The index of the value in the array (-1 if !found)
     */
    public static int findIndexSortedArray(int[] tab, int val, int logicalSize) {
        int currentPos = 0;
        while (currentPos < logicalSize && tab[currentPos] < val) {
            currentPos++;
        }
        if (currentPos < logicalSize && tab[currentPos] == val) {
            return currentPos;
        } else {
            return -1;
        }
    }

    /**
     * Dichotomy method Finds the index of a certain value in a sorted array with a
     * logical size If not found, return -1
     * 
     * @param tab         The sorted array
     * @param val         The value to find
     * @param logicalSize The logical size of the array
     * @return The index of the value in the array (-1 if !found)
     */
    public static int findIndexDichotomy(int[] tab, int val, int logicalSize) {
        int begin = 0, end = logicalSize - 1;
        while (begin <= end) {
            int midPos = (begin + end) / 2;
            if (tab[midPos] < val) {
                begin = midPos + 1;
            } else if (tab[midPos] > val) {
                end = midPos - 1;
            } else {
                return midPos;
            }
        }
        return -1;
    }
}