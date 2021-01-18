public class sortingMethods {

    /*
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++ SELECTION
     */

    public static void selection(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            int posMin = findMin(tab, i);
            swap(tab, i, posMin);
        }
    }

    public static int findMin(int[] tab, int start) {
        int posMin = start;
        for (int i = start + 1; i < tab.length; i++) {
            if (tab[i] < tab[posMin]) {
                posMin = i;
            }
        }
        return posMin;
    }

    public static void swap(int[] tab, int pos1, int pos2) {
        if (pos1 != pos2) {
            int temp = tab[pos1];
            tab[pos1] = tab[pos2];
            tab[pos2] = temp;
        }
    }

    /*
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++ INSERTION
     */

    public static void insertion(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int nextValue = tab[i];
            int pos = i;
            while(pos>0 && tab[pos-1]>nextValue) {
                tab[pos] = tab[pos-1];
                pos--;
            }
            tab[pos] = nextValue;
        }
    }

    /*
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++ BULLE
     */

    public static void bulle(int[] tab) {
        for(int i=0; i<tab.length-1; i++) {
            for(int j=0; j< tab.length-i-1; j++) {
                if(tab[j]>tab[j+1]) {
                    swap(tab, j, j+1);
                }
            }
        }
    }
}
