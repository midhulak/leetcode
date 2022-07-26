package Google;
//take and array where each element in the array 
/*The array is indexed by the time : assume all time values at the previous mentioned granulairty inputtime values
we just divide them the appropriate value so that theu increment by time. */

public class ScheduleTasks {
	int[]arr  = new int[10];
	int previousTime = 0;
	public int getTime(int time) {
		return time % arr.length;
	}
	public void schedule(int task, int timeSchedule) {
		lock.lock();
		int currentTime = time.now();
		
		int bucket = 0;
		int i = 0;
		if(timeSchedule - currentTime < (arr.length - previousTime)) {
			bucket = arr[getTime(timeSchedule)];
			bucket[i] = task;
			i++;
		} else {
			oldScedhule(task, timeSchedule);
		}
		lock.unlock();
	}
	public void run() {
		lock.lock();
		int currentTimeSlice = getTime(time.now());
		while(previousTime < currentTimeSlice) {
			bucket = arr[previousTime];
			for(int task = 0; task < bucket; task++) {
				execute(task);
			}
			previousTime++;
			if(previousTime == arr.length) {
				repopulateArr(arr);
				previousTime = 0;
			}
		}
		lock.unlock();
	}
}
