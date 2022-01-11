package subset_sum_problem;
import java.util.Arrays;

/**
 * SubsetSumProblem
 */
public class SubsetSumProblem {
    private boolean isExist;
    private int[] selection;
    private int searchCounter;

    public SubsetSumProblem() {}

    public boolean isExistWayOfSelection() {
        return isExist;
    }

    public int[] getWayOfSelection() {
        return Arrays.copyOf(selection, selection.length);
    }

    public int getSearchCount() {
        return searchCounter;
    }

    public void solveWithBackTrack(int[] input, int aim) {
        selection = new int[input.length];
        isExist = solveWithBackTrack(input, aim, -1, -1, selection);  // set -1 as dummy root
        // int[] selection = new int[input.length];
        // solveWithBackTrackV2(input, aim, 0, selection);
        // solveWithBackTrackV3(input, aim, 0, selection);
    }

    private boolean solveWithBackTrack(int[] input, int aim, int index, int select, int[] selection) {
        searchCounter++;
        if (index >= input.length) {
            return Arrays.stream(selection).sum() == aim;
        }
        if (index >= 0) {  // do nothing in branch from dummy root
            selection[index] = input[index] * select;
        }
        return solveWithBackTrack(input, aim, index+1, 1, selection) || solveWithBackTrack(input, aim, index+1, 0, selection);
    }

    // private void solveWithBackTrackV2(int[] input, int aim, int index, int[] selection) {
    //     searchCounter++;
    //     if (index >= input.length) {
    //         if (Arrays.stream(selection).sum() == aim) {
    //             this.selection = Arrays.copyOf(selection, selection.length);
    //             this.isExist = true;
    //         }
    //     } else {
    //         selection[index] = input[index];
    //         solveWithBackTrackV2(input, aim, index+1, selection);
    //         selection[index] = 0;
    //         solveWithBackTrackV2(input, aim, index+1, selection);
    //     }
    // }

    // private void solveWithBackTrackV3(int[] input, int sum, int index, int[] selection) {
    //     searchCounter++;
    //     if (index >= input.length) {
    //         if (sum == 0) {
    //             this.selection = Arrays.copyOf(selection, selection.length);
    //             this.isExist = true;
    //         }
    //     } else {
    //         selection[index] = input[index];
    //         solveWithBackTrackV3(input, sum - input[index], index+1, selection);
    //         selection[index] = 0;
    //         solveWithBackTrackV3(input, sum, index+1, selection);
    //     }
    // }

    public void solveWithBranchAndBound(int input[], int aim) {
        selection = new int[input.length];
        isExist = solveWithBranchAndBound(input, aim, -1, -1, selection);
    }

    private boolean solveWithBranchAndBound(int input[], int aim, int index, int select, int[] selection) {
        searchCounter++;
        if (index >= input.length) {
            return Arrays.stream(selection).sum() == aim;
        }
        if (index >= 0) {
            selection[index] = input[index] * select;
            int curr_sum = 0;  // sum of current selection
            for (int i = 0; i <= index; i++) {
                curr_sum += selection[i];
            }
            int max_sum = curr_sum;  // max sum based on current selection
            for (int i = index + 1; i < input.length; i++) {
                max_sum += input[i];
            }
            if (curr_sum > aim || max_sum < aim) {  // cut branch
                return false;
            }
        }
        return solveWithBranchAndBound(input, aim, index+1, 1, selection) || solveWithBranchAndBound(input, aim, index+1, 0, selection);
    }
}