package com.company;
/**
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 */

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);
        System.out.println(deleteDuplicates(a));
    }

    public static ListNode deleteDuplicates(ListNode a) {
        ListNode temp = a;
        while(temp != null && temp.next != null ){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return a;
    }
}
