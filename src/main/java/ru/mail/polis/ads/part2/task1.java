package ru.mail.polis.ads.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class task1 {
    public static void merge(int[] array, int left, int mid, int right) {

        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;
        int leftArray[] = new int[sizeLeft];
        int rightArray[] = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = array[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < sizeLeft && rightIndex < sizeRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else {
                if (leftIndex < sizeLeft) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                        if (rightIndex < sizeRight) {
                        array[i] = rightArray[rightIndex];
                        rightIndex++;
                    }
                }
            }

        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int size = in.nextInt();
        int[] mas = new int[size];
        for (int j = 0; j < size; j++) {
            int nextInt = in.nextInt();
            mas[j] = nextInt;
        }
        mergeSort(mas, 0, size - 1);
        for (Integer e : mas) {
            out.print(e + " ");
        }
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
