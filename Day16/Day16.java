/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Solution {
  public long countFairPairs(int[] nums, int lower, int upper) {
   
    Arrays.sort(nums);
    return countLess(nums, upper) - countLess(nums, lower - 1);
  }

  private long countLess(int[] nums, int sum) {
    long res = 0;
    for (int i = 0, j = nums.length - 1; i < j; ++i) {
      while (i < j && nums[i] + nums[j] > sum)
        --j;
      res += j - i;
    }
    return res;
  }
}

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static int intersectPoint(Node head1, Node head2) {
        int n1 = 0, n2 = 0;
        Node temp = null;

        // finding length of list1.
        for (temp = head1; temp != null; temp = temp.next) n1 += 1;

        // finding length of list2.
        for (temp = head2; temp != null; temp = temp.next) n2 += 1;

        // if list1 is longer, we ignore some of its starting
        // elements till it has as many elements as list2.
        for (; n1 > n2; n1 -= 1) head1 = head1.next;

        // similarly, if list2 is longer, we ignore some of its starting
        // elements till it has as many elements as list1.
        for (; n2 > n1; n2 -= 1) head2 = head2.next;

        // now we simply traverse ahead till we get the intersection point, if
        // there is none, this loop will break when both pointers point at NULL.
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        // if head1 is not NULL, we return its data otherwise we return -1.
        if (head1 != null) return head1.data;
        return -1;
    }
}