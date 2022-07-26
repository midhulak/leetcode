import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {
	/**
	 * Time Complexity: O(N)O(N), where NN is the length of cpdomains, and assuming the length of cpdomains[i] is fixed.

Space Complexity: O(N)O(N), the space used in our count.
	 * @param cpdomains
	 * @return
	 */
	public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
            	System.out.println("cur is="+cur);
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] str = {"9001 discuss.leetcode.com"};
SubDomainVisitCount ss =new SubDomainVisitCount();
ss.subdomainVisits(str);
	}

}
