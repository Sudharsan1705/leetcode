/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head){
struct ListNode *n= NULL,*temp;
struct ListNode* res=head;
int c=1;
while(head!=NULL){
    // if(c==1){
    //     n=head;
    //     n->next=NULL;
    //     head=head->next;
    //     c++;
    // }
    // else{
        temp=(struct ListNode*)malloc(sizeof(struct ListNode));
        temp->val=head->val;
        //temp=head;
        temp->next=n;
        n=temp;
        head=head->next;
   // }
}
return n;
}