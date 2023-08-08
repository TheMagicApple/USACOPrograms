//DONE & 6/9
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MovieFestival {
	private static int n;
	private static int[][] movies;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		movies=new int[n][2];
		for(int i=0;i<n;i++) {
			int[] movie=new int[2];
			movie[0]=s.nextInt();
			movie[1]=s.nextInt();
			movies[i]=movie;
		}
		int bigBegin=movies[0][0];
		for(int i=0;i<n;i++) {
			if(movies[i][0]>bigBegin) {
				bigBegin=movies[i][0];
			}
		}
		greedyquicksort(0, movies.length-1);
		int nMovies=0;
		int time=0;
		int oldI=0;
		while(time<=bigBegin) {
			for(int i=oldI;i<movies.length;i++) {
				if(time<=movies[i][0]) {
					time=movies[i][1];
					oldI=i;
					nMovies++;
					break;
				}
			}
		}
		System.out.println(nMovies);
	}
	private static void greedyquicksort(int low, int high) {
        int i = low, j = high;
        int pivot = movies[low + (high-low)/2][1];
        while (i <= j) {
            while (movies[i][1] < pivot) {
                i++;
            }
            while (movies[j][1] > pivot) {
                j--;
            }
            if (i <= j) {
            	int[] temp = movies[i];
                movies[i] = movies[j];
                movies[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            greedyquicksort(low, j);
        if (i < high)
            greedyquicksort(i, high);
    }

}
