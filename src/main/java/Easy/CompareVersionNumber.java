package Easy;

/**
 * Created by yuwang on 6/13/16.
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) return 0; // same
        if (version1 == null || version2 == null) return version1 == null ? -1 : 1;
        String[] list1 = version1.split("\\."); // back slash
        String[] list2 = version2.split("\\.");
        int i = 0;
        while (i < list1.length || i < list2.length) {
            int a = i < list1.length ? Integer.valueOf(list1[i]) : 0;
            int b = i < list2.length ? Integer.valueOf(list2[i]) : 0;
            if (a < b) return -1;
            else if (a > b) return 1;
            i++; // update i
        }
        return 0;
    }
}
