package DataStructures.Strings;

import java.util.Stack;

public class CanonicalPath {
	public static void main(String[] args) {
		String path = "/a//b////c/d//././/..";
//		String path = "/a/../../b/../c//.//";
		System.out.println(getPath(path));
	}

	private static String getPath(String path) {
		path = path + "/";
		Stack<String> stack = new Stack<>();
		String fr = "";
		char ch;
		for (int i = 0; i < path.length(); i++) {
			ch = path.charAt(i);
			if (ch == '/' && fr.length() > 0) {
				// Case 1 : ./
				if (fr.equals(".")) {
					fr = "";
					continue;
				}
				if (fr.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else {
					stack.push(fr);
				}
				fr = "";
			} else if (ch != '/') {
				fr += ch;
			}
		}
		String cp = "/";
		while (!stack.isEmpty()) {
			cp = "/" + stack.pop() + cp;
		}
		return cp.substring(0, cp.length() - 1);
	}
}
