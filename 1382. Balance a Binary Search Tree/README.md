# LeetCode 1382 – Balance a Binary Search Tree

## Summary
Convert a given Binary Search Tree into a **height-balanced BST** using the same node values.

The goal is not to check balance, but to **rebuild the tree structure** so it becomes balanced.

---

## Approaches

### Brute Force Approach
- Traverse the BST and store all node values
- Sort the collected values
- Rebuild a balanced BST from the sorted list  
- Works, but sorting is unnecessary

---

### Optimal Approach
- Perform inorder traversal and store nodes directly (already sorted)
- Build a balanced BST using the middle node
- Avoids sorting and uses BST properties efficiently

---

## Complexity
- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Insights
- Inorder traversal of a BST always gives **sorted values**
- A balanced BST can be formed by choosing the **middle element as root**
- Recursively applying this idea ensures height balance
- Node values remain the same; only the structure changes

---

## Notes / Visual Explanation
Handwritten notes and diagrams for better understanding:

![Notes](./notes/1382.pdf)

---

## Final Takeaway
If you know that **inorder traversal gives sorted order**  
and **middle element ensures balance**,  
you can solve this problem confidently without memorizing code.
