import java.util.Arrays;
import java.util.Scanner;

public class BerryPicking {
	static int[] trees;
	static int k;
	static int bessieBerries=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		k=s.nextInt();
		trees=new int[n];
		for(int i=0;i<n;i++) {
			trees[i]=s.nextInt();
		}
		Arrays.sort(trees);
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=left+(right-left+1)/2;
			if(pickBerrys1(mid)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		
		int minPerBucket=(left+right)/2;
		int previousValue=-1;
		System.out.println(pickBerrys1(262));
		for(int i=0;i<k;i++) {
			if(pickBerrys2(minPerBucket,minPerBucket+1,i)) {
				previousValue=i;
			}else {
				break;
			}
		}
		int[] berriesPicked=new int[k];
		for(int i=0;i<previousValue;i++) {
			berriesPicked[i]=minPerBucket+1;
		}
		for(int i=previousValue;i<k;i++) {
			berriesPicked[i]=minPerBucket;
		}
		int sum=0;
		for(int i=berriesPicked.length/2;i<berriesPicked.length;i++) {
			sum+=berriesPicked[i];
		}
		System.out.println(sum);

	}
	public static boolean pickBerrys1(int berryPerBucket) {
		int bucketsFilled=0;
		for(int tree:trees) {
			bucketsFilled+=tree/berryPerBucket;
		}
		return bucketsFilled>=k;
	}
	public static boolean pickBerrys2(int minBerryPerBucket,int maxBerryPerBucket,int nMax) {
		bessieBerries=0;
		int bucketsFilled=0;
		int bucketsToFillWithMax=nMax;
		for(int tree:trees) {
			if(bucketsToFillWithMax>0) {
				
				int nBucketsFilled=tree/maxBerryPerBucket;
				int nBucketsFilledAlt=tree/minBerryPerBucket;
				if(nBucketsFilledAlt>nBucketsFilled) {
					bucketsFilled+=nBucketsFilledAlt;
				}else {
					bucketsFilled+=nBucketsFilled;
					bucketsToFillWithMax-=nBucketsFilled;
				}
				
				
			}else {
				bucketsFilled+=tree/minBerryPerBucket;
			}
			
		}
		if(bucketsToFillWithMax!=0)return false;
		return bucketsFilled>=k;
	}

}
