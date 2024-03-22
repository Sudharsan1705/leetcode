/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool isPalindrome(struct ListNode* head){
struct ListNode *n=NULL,*temp,*r=head;
if(head==NULL){
    return true;
}
while(head!=NULL){
    temp=(struct ListNode*)malloc(sizeof(struct ListNode));
    temp->val=head->val;
    temp->next=n;
    n=temp;
    head=head->next;
}
while(r!=NULL){
    if(n->val==r->val){
        r=r->next;
    n=n->next;
        continue;
    }
    else{
        return false;
    }
}
return true;
}