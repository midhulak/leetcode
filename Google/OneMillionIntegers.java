package Google;

import java.util.*;

public class OneMillionIntegers {
	//Overall scalability etc

	/*
	1. bucketize on thread pool.
	2. Shoot.
	*/

	// per thread num of file
	int bucket_size = 100;
	// assume list of files are here
	List<String>files = new ArrayList<>(); // yep, files as in like list of strings
	int num_files = files.size();
	public void process_files ( int start_inx ){
	  int end_inx = start_inx + bucket_size;
	  end_inx = end_inx > num_files ? num_files : end_inx;
	  sum ([start_inx : end_inx ] ) -&gt; { sumOfFile( files[$.o] ) }
	}
	int num_buckets = ceil(num_files / bucket_size );
	start_inx = 0;
	threads = list ( [0:num_buckets] ) -&gt; {
	  start_inx += bucket_size
	  thread( ) -&gt; { process_files( start_inx ) }
	}
	// do not get into a loop, ever
	succeeded = poll( 42, 300 ) :: { !exists( threads ) :: { $.o.alive } }
	// zoomba threads return value, proper they are option monad
	assert ( succeeded , "Why you fail in timeout???" )
	total_sum = sum ( threads ) -&gt; { $.o.value }
	println( total_sum ) // should be cool

/*Well, a million isn't so much anymore, so lets assume we're talking about several billion integers.

In that case, I would suggest that you hash them and partition them into 2^N buckets (separate files or preallocated parts of the same file) using the top N bits of their hash values.

You would choose N so that the resulting buckets were highly likely to be small enough to process in memory.

You would then process each bucket by counting the occurrences of each unique value in a hash table or similar.

In the unlikely event that a bucket has too many unique values to fit in RAM, repartition using the next N bits of the hash and try again.*/
}
