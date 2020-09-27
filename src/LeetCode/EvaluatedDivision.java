package LeetCode;

import Commons.ArrayPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluatedDivision {
	public static void main(String[] args) {
		String[][] equationArray = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
		String[][] queriesArray = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
		double[] values = {1.5, 2.5, 5.0};
		List<List<String>> equations = new ArrayList<>(),
				queries = new ArrayList<>();
		List<String> temp;
		for (String[] equation : equationArray) {
			temp = new ArrayList<>();
			temp.add(equation[0]);
			temp.add(equation[1]);
			equations.add(temp);
		}

		for (String[] equation : queriesArray) {
			temp = new ArrayList<>();
			temp.add(equation[0]);
			temp.add(equation[1]);
			queries.add(temp);
		}

		new ArrayPrinter()
				.printArray(new EvaluatedDivision().calcEquation(equations, values, queries));
	}

	private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, List<Node>> map = new HashMap<>();
		for (int i = 0; i < values.length; i++) {
			String source = equations.get(i).get(0);
			String destination = equations.get(i).get(1);
			map.putIfAbsent(source, new ArrayList<>());
			map.putIfAbsent(destination, new ArrayList<>());
			map.get(source).add(new Node(destination, values[i]));
			map.get(destination).add(new Node(source, 1.0d / values[i]));
		}
		return map;
	}

	private double dfs(String source, String destination,
					   Set<String> visited, Map<String, List<Node>> graph) {
		if (!(graph.containsKey(source) && graph.containsKey(destination))) {
			return -1.0;
		}
		if (source.equals(destination)) {
			return 1.0;
		}

		visited.add(source);
		for (Node node : graph.get(source)) {
			if (!visited.contains(node.key)) {
				double answer = dfs(node.key, destination, visited, graph);
				if (answer != -1.0) {
					return answer * node.cost;
				}
			}
		}

		return -1.0;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<Node>> graph = buildGraph(equations, values);
		double[] result = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1),
					new HashSet<>(), graph);
		}
		return result;
	}

	private static class Node {
		String key;
		double cost;

		Node(String key, double cost) {
			this.key = key;
			this.cost = cost;
		}
	}
}
