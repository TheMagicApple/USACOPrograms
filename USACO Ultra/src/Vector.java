
public class Vector implements Comparable<Vector>{
	public int x;
	public int y;
	public Vector(int x,int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int hashCode() {
		return x*29+y*31;
	}
	@Override
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
	@Override
	public String toString() {
		return x+" "+y;
	}
	@Override
	public int compareTo(Vector other) {
		return x-other.x;
	}
}
