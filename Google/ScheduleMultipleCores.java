package Google;

import java.util.List;

/* time : O(n logn)
 *sort the input scehule by the start time
 *Iterate through the scehdule, maintaing an array of k cores. each item in scedhule 
 *  Delete any items from cores where item.start > core[x]
 *  Add item.start + ite,.duration to an empty space in cores array
 *  If item.start is inside the program to be added time range, see if there is space in cores. If not return false
 * Return true as soon as we deplete the scedhule of find an item whose start > start + duration of prgram to be added.
 */
public class ScheduleMultipleCores {
	public boolean canScehdule(List<List<Integer>> scehdule, List<List<Integer>> QueryTasks) {
		return true;
	}
}
