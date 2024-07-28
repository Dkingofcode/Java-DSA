package LeetcodeSolutions.Linkedlist;

public class MergetwoSortList {
    public ListNode mergeTwoLists(ListNode L1, ListNode L2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(L1 != null && L2 != null){
            if(L1.val < L2.val){
                p.next = L1;
                L1 = L1.next;
            }else {
                p.next = L2;
                L2 = L2.next;
            }
            p = p.next;
        }
        if(L1 != null) p.next = L1;
        if(L2 != null) p.next = L2;
         return dummyHead.next;
    }
}
