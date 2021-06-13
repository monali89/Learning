package ltcd_2;

public class MaxPointsFromCards_1423 {

    public int maxScore(int[] cardPoints, int k) {

        int maxScore = 0;
        for (int cardPoint : cardPoints) {
            maxScore = maxScore + cardPoint;
        }

        if (k >= cardPoints.length) return maxScore;

        int minScore = Integer.MAX_VALUE;
        int w = cardPoints.length - k;
        int currSum = 0;

        for (int i=0; i < cardPoints.length - w + 1; i++) {
            int j = i + w;


            if (minScore == Integer.MAX_VALUE) {
                for (int x=i; x < j; x++) {
                    currSum = currSum  + cardPoints[x];
                }
            } else {
                currSum = currSum - cardPoints[i-1] + cardPoints[j-1];
            }
            minScore = Math.min(minScore, currSum);
        }
        return maxScore - minScore;
    }

    public static void main(String[] args) {
        MaxPointsFromCards_1423 object = new MaxPointsFromCards_1423();
        int[] cardPoints;
        int k;

        cardPoints = new int[] {1,2,3,4,5,6,1};
        k = 3;
        System.out.println("Expected:  12, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {2,2,2};
        k = 2;
        System.out.println("Expected:   4, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {9,7,7,9,7,7,9};
        k = 7;
        System.out.println("Expected:  55, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {1,1000,1};
        k = 1;
        System.out.println("Expected:   1, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {1,79,80,1,1,1,200,1};
        k = 3;
        System.out.println("Expected: 202, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {11,49,100,20,86,29,72};
        k = 4;
        System.out.println("Expected: 232, " + object.maxScore(cardPoints, k));

        cardPoints = new int[] {96,90,41,82,39,74,64,50,30};
        k = 8;
        System.out.println("Expected: 536, " + object.maxScore(cardPoints, k));
    }

}
