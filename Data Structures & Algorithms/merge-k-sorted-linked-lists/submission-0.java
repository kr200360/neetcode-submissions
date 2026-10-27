class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a.val, b.val));

        // Add the first node of every non-empty list
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            // Extract the smallest available node
            ListNode node = minHeap.poll();

            // Attach it to the merged list
            tail.next = node;
            tail = tail.next;

            // Add the next node from the same list
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
