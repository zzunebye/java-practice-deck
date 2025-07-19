package com.junyoungbang.study_deck.java.string_compression;

public class App {
    public static void main( String[] args )
    {
        // 다양한 테스트 케이스
        String[] testCases = {
            "AAABBCDDDA",
            "ABCD",
            "AAAA",
            "A",
            ""
        };
        
        for (String input : testCases) {
            String compressed = compress(input);
            System.out.println("Original: '" + input + "'");
            System.out.println("Compressed: '" + compressed + "'");
            System.out.println("---");
        }
    }

    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        StringBuilder sb = new StringBuilder();
        int len = input.length();

        for (int i = 0; i < len;) {
            char currentChar = input.charAt(i);
            int count = 0;
            
            // 현재 문자와 같은 연속된 문자들의 개수를 세기
            int j = i;
            while (j < len && input.charAt(j) == currentChar) {
                count++;
                j++;
            }

            // 문자와 개수를 StringBuilder에 추가
            sb.append(currentChar);
            sb.append(count);

            // 다음 반복을 위해서 이미 처리된 문자를 건너뛰고 i를 j로 건너뜀. 
            i = j;
        }
        return sb.toString();
    }
}
