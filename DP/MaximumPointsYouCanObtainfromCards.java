/**
 * MaximumPointsYouCanObtainfromCards
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaximumPointsYouCanObtainfromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < k; i++) {
           leftSum += cardPoints[i];
           maxSum = leftSum;
           
        }
        int rightIdx = cardPoints.length - 1;
        for(int i = k-1; i >= 0; i--){
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightIdx];
            rightIdx--;

            maxSum = Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println(maxScore(cardPoints, k));
    }
}