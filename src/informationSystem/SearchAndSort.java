/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class SearchAndSort {

    public static void sort(ArrayList<String[]> list, int fieldIndex) {
        if (list.size() <= 1) {
            return;
        }

        ArrayList<String[]> first = new ArrayList();
        ArrayList<String[]> second = new ArrayList();

        for (int i = 0; i < list.size() / 2; i++) {
            first.add(list.get(i));
        }
        for (int i = 0; i < list.size() - first.size(); i++) {
            second.add(list.get(first.size() + i));
        }

        sort(first, fieldIndex);
        sort(second, fieldIndex);
        merge(first, second, list, fieldIndex);
    }

    private static void merge(ArrayList<String[]> first, ArrayList<String[]> second,
            ArrayList<String[]> originalList, int fieldIndex) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.size() && iSecond < second.size()) {
            if (Integer.valueOf(first.get(iFirst)[fieldIndex])
                    < Integer.valueOf(second.get(iSecond)[fieldIndex])) {

                originalList.set(j, first.get(iFirst));

                iFirst++;
            }
            else {
                originalList.set(j, second.get(iSecond));
                iSecond++;
            }
            j++;
        }
        while (iFirst < first.size()) {
            originalList.set(j, first.get(iFirst));
            iFirst++;
            j++;
        }
        while (iSecond < second.size()) {
            originalList.set(j, second.get(iSecond));
            iSecond++;
            j++;
        }
    }

    private static String[] binarySearch(ArrayList<String[]> arr, int index, int item) {

        if (arr.size() == 1) {
            //See if the item is the only element in the array.
            if (Integer.valueOf(arr.get(0)[index]) == item) {
                return arr.get(0);
            }
            else {
                return null;
            }

        }

        int midIndex = arr.size() / 2;

        if (Integer.valueOf(arr.get(midIndex)[index]) == item) {
            //See if the item is at the middle of the array.
            return arr.get(midIndex);
        }

        else {
            int startIndex;
            int endIndex;

            if (Integer.valueOf(arr.get(midIndex)[index]) > item) {
                startIndex = 0;
                endIndex = midIndex;

            }
            else {
                startIndex = midIndex;
                endIndex = arr.size();

            }
            // Call binary search recursively until you find the item.
            ArrayList<String[]> nextArray = new ArrayList();
            for (int i = startIndex; i < endIndex; i++) {
                nextArray.add(arr.get(i));
            }
            return binarySearch(nextArray, index, item);
        }

    }

    public static String[] search(ArrayList<String[]> arr, int index, int item) {
        //Binary sort works with sorted list.
            sort(arr, index);
            
            return binarySearch(arr, index, item);
        

    }

}
