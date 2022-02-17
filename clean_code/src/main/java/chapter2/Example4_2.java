package chapter2;

/**
 * 이 클래스는 사용자가 지정한 최대 값까지 소수를 생성한다.
 * 사용된 알고리즘은 에라스토테네스의 체다.
 */
public class Example4_2 {
    private static boolean[] givenArr;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        //maxValue > 2해서 로직 이어나가는 것보다, 줄이 적은 분기 먼저 수행하고 early return 하는 것이 깔끔해보임
        if (maxValue < 2) {
            return new int[0];
        }
        initGivenArray(maxValue);


        findPrimeNumber();

        int count = countPrimes();
        createResultArray(count);

        return result;
    }

    public static void initGivenArray(int maxValue) {
        givenArr = new boolean[maxValue + 1];
        for (int i = 0; i < givenArr.length; i++)
            givenArr[i] = true;

        setKnownPrimNumber();
    }

    public static void setKnownPrimNumber() {
        givenArr[0] = givenArr[1] = false;
    }

    public static void findPrimeNumber() {
        int limit = determineIterationLimit();
        for (int i = 2; i < limit; i++) {
            if (givenArr[i]) {
                // 2의 배수를 모두 제거한다.
                // 다음으로 남은 정수를 찾아 이 정수의 배수를 모두 지운다.
                removeMutiples(i);
            }
        }
    }

    // for문 내부에 연산을 직접 넣지 않고 limit을 알 수 있는 메소드로 빼는게 좋아보임
    public static int determineIterationLimit() {
        double iterationLimit = Math.sqrt(givenArr.length);
        return (int) iterationLimit;
    }

    public static void removeMutiples(int i) {
        for (int j = 2 * i; j < givenArr.length; j += i) {
            givenArr[j] = false;
        }
    }

    public static int countPrimes() {
        int count = 0;
        for (int i = 0; i < givenArr.length + 1; i++) {
            if (givenArr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void createResultArray(int count) {
        result = new int[count];
        int i, j;

        for (i = 0, j = 0; i < givenArr.length; i++) {
            if (givenArr[i]) {
                result[j++] = i;
            }
        }
    }
}
