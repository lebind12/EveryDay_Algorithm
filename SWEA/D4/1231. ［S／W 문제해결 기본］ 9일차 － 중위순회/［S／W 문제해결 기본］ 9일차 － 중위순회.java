/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static class Node {
        int nodeNum;
        String value;
        int right;
        int left;

        Node() {

        }
        Node(int nodeNum, String value, int left, int right) {
            this.nodeNum = nodeNum;
            this.value = value;
            this.right = right;
            this.left = left;
        }

        @Override
        public String toString() {
            return String.format("%d, %s, %d, %d", nodeNum, value, left, right);
        }
    }

    static String midOrder(StringBuilder sb, Node[] tree, int nodeNum) {

        if (tree[nodeNum].left != -1)
            midOrder(sb, tree, tree[nodeNum].left);
        sb.append(tree[nodeNum].value);
        if (tree[nodeNum].right != -1)
            midOrder(sb, tree, tree[nodeNum].right);

        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int tc = 1; tc < 11; tc++) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());

            int nodeNum;
            String value;


            String[] input;

            Node[] tree = new Node[N+1];

            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                nodeNum = Integer.parseInt(input[0]);
                value = input[1];
                int right = -1;
                int left = -1;
                if (input.length > 2)
                    left = Integer.parseInt(input[2]);
                if (input.length > 3)
                    right = Integer.parseInt(input[3]);

                tree[nodeNum] = new Node(nodeNum, value, left, right);
            }

            String result = midOrder(new StringBuilder(), tree, 1);

            sb.append("#").append(tc).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }
}