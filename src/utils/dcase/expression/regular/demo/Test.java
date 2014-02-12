package utils.dcase.expression.regular.demo;

public class Test {

	public static void main(String[] args) {
        String[] strs = {
                "abc1232",  "wwwadsf",
                "awwwfas",  "wwadfsf",
                "", "ww", " ", "www"
            };
        String regex = "(?:(?!^www).)*";
        for(String str : strs) {
            System.out.printf("%-10s %s%n", str, str.matches(regex));
        }
        
        String pattern = ".*([0-9])\\1+.*";
        String str = "52225";
        
        System.out.println(str.matches(pattern));
        
        
        System.out.println(str);
        
        
    }


}
