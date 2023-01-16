import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class Leetcode {
    public static void main(String[] args) {
        Leetcode leetcode = new Leetcode();
//        [1,2,6,3,4,5,6]
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 1; i < 20; i++) {
            integers.add(i);
        }
        System.out.println(integers.size());
        LinkedList linkedList = leetcode.reverseList(integers);
        System.out.println(linkedList.toString());
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
//            sasdasda
            if (num == 1) {
                count1 += 1;
            } else {
                count2 = Math.max(count1, count2);
                count1 = 0;
            }
        }
        return Math.max(count1, count2);
    }

    public void moveZeroes(int[] nums) {
        int noZeroCounts = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noZeroCounts] = nums[i];
                noZeroCounts += 1;
            }
        }
        for (int i = noZeroCounts; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            IntPredicate intPredicate = (int j) -> j % val != 0;
            IntStream intStream = Arrays.stream(nums).filter(intPredicate);
            nums = intStream.toArray();
        }
        System.out.printf(Arrays.toString(nums));
        return nums.length;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public LinkedList reverseList(LinkedList<Integer> list) {
        int size = list.size()-1;
        for (int i = 0; i < list.size()/2; i++) {
            Integer integer = list.get(i);
            list.set(i,list.get(size));
            list.set(size,integer);
            size-=1;
        }
        return list;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 队列：最近的请求次数
     */

}
