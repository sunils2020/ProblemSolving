package Storage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));
    }
    public String simplifyPath(String A) {
        Deque<String> path = new LinkedList<>();
        String[] tags = A.split("/");
        for (int i=0;i<tags.length;i++){
            if(tags[i].equals("..")) {
                if(path.size()>0) path.removeLast();
            }
            else if (tags[i].equals(".")) continue;
            else if (tags[i].length()>0) path.add("/"+tags[i]);
        }
        StringBuilder unixPath = new StringBuilder();
        if (path.size()==0) return "/";
        while(path.size()!=0){
            unixPath.append(path.removeFirst());
        }
        return unixPath.toString();
    }
}
