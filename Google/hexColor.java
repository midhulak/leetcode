package Google;

import java.util.*;
import java.lang.Byte.toUnsignedInt;

public class hexColor {
	public static List<Byte> decompress(List<Byte>compressed) {
		List<Byte> list = new ArrayList<>();
		for(int i = 0; i < compressed.size(); i++) {
			if(compressed.get(i).toUnsignedInt() == 0xFE) {
				int len = compressed.get(i + 1).toUnsignedLong();
				int offset = compressed.get(i + 2).toUnsignedInt(0);
				int start = list.size() - offset - 1;
				for(int j = 0; j < len; j++) {
					list.add(list.get(start + j));
				}
				i += 2;
			} else {
				list.add(compressed.get(i));
			}
		}
		return list;
	}
}
