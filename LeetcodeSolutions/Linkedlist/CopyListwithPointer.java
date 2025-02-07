package LeetcodeSolutions.Linkedlist;


public class CopyListwithPointer {

    // HashTable
    public RandomListNode copyRandomList(RandomListNode head){
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode q = dummy;
        while(p != null) {
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while(p != null){
           q.next.random = map.get(p.random);
           p = p.next;
           q = q.next;
        }
        return dummy.next;
    }


    //  Change the Original structure
    public RandomListNode copyRandomListChange(RandomListNode head){

        RandomListNode p = head;
        while(p != null){
            RandomListNode next = p.next;
            RandomListNode copy = new RandomListNode(p.label);

            p.next = copy;
            copy.next = next;
            p = next;
        }
        p = head;
        while(p != null){
            p.next.random = (p.random != null) ? p.random.next : null;
            p = p.next.next;
        }
        p = head;
        RandomListNode headCopy = (p != null) ? p.next : null;
        while(p != null){
            RandomListNode copy = p.next;
            p.next = copy.next;
            p = p.next;
            copy.next = (p != null) ? p.next : null;
        }
        return headCopy;
    }









}
