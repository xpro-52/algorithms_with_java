package test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import subset_sum_problem.SubsetSumProblem;

public class SubsetSumProblemTest {
    @Test
    public void testSSBWithBackTrack() {
        int[] input = {4, 11, 17, 1, 8, 1};
        int aim = 13;
        int[] ans = {4, 0, 0, 1, 8, 0};
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
        subsetSumProblem.solveWithBackTrack(input, aim);
        assertEquals(true, subsetSumProblem.isExistWayOfSelection());
        assertArrayEquals(ans, subsetSumProblem.getWayOfSelection());
        System.out.println(subsetSumProblem.getSearchCount());
    }

    @Test
    public void testSSBWithBranchAndBound() {
        int[] input = {4, 11, 17, 1, 8, 1};
        int aim = 13;
        int[] ans = {4, 0, 0, 1, 8, 0};
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
        subsetSumProblem.solveWithBranchAndBound(input, aim);
        assertEquals(true, subsetSumProblem.isExistWayOfSelection());
        assertArrayEquals(ans, subsetSumProblem.getWayOfSelection());
        System.out.println(subsetSumProblem.getSearchCount());
    }
}
