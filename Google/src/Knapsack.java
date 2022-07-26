import java.util.LinkedList;
import java.util.List;

public class Knapsack {
	
	public static class Item{
		int weight;
		int value;
	}
	
	public static List<Item> knapsack(Item[] items, int totalWeight) {
		 List<List<Item>> result = new LinkedList<List<Item>>();
		 result.add(new LinkedList<Item>());
		 knapsack(items, 0, new LinkedList<Item>(), 0, totalWeight, result);
		 return result.get(0);
		}
	
	private static void knapsack(Item[] items, int i, List<Item> path,
			 int currentWeight, int totalWeight,
			 List<List<Item>> result) {
			 if (currentWeight > totalWeight) return;
			 if (i == items.length) {
			 if (itemsValue(result.get(0)) < itemsValue(path)) {
			 result.set(0, new LinkedList<Item>(path));
			 }
			 return;
			 }

			 knapsack(items, i+1, path, currentWeight, totalWeight, result);
			 path.add(items[i]);
			 knapsack(items, i+1, path, currentWeight+items[i].weight,
			 totalWeight, result);
			 path.remove(path.size() - 1);
			}
	
	private static int itemsValue(List<Item> l) {
		 int sum = 0;
		 for (Item i : l) sum +=i.value;
		 return sum;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
