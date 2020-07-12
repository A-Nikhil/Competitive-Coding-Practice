package DataStructures.Arrays.Misc;

import java.util.ArrayList;

public class SnapshotArray {
	ArrayList<int[]> list = new ArrayList<>();
	int count = 0;
	int length;

	SnapshotArray(int length) {
		list.add(new int[length]);
		this.length = length;
	}

	public static void main(String[] args) {
		SnapshotArray array = new SnapshotArray(3);
		array.set(0, 5);
		array.snap();
		array.set(0, 6);
		System.out.println(array.get(0, 0));

	}

	public void set(int index, int val) {
		list.get(count)[index] = val;
	}

	public int snap() {
		int[] temp = new int[length];
		System.arraycopy(list.get(count), 0, temp, 0, length);
		list.add(temp);
		count++;
		return count - 1;
	}

	public int get(int index, int snap_id) {
		return list.get(snap_id)[index];
	}
}
