二叉树
二叉树拥有天然的递归性质
每个节点的左子树和右子树都是二叉树
二叉树不一定是满的，左右子树不一定都需要有
一个节点也是二叉树，NULL也是二叉树

------------------------------
二分搜索树
二分搜索树是二叉树，拥有二叉树的所有性质
二分搜索树的每个节点的值：大于其左子树的所有节点的值，小于其右子树的所有节点的值
二分搜索树的每一棵子树也是二分搜索树


前序遍历：              中序遍历：              后序遍历：
1.当前节点              1.左子树               1.左子树
2.左子树                2.当前节点             2.右子树
3.右子树                3.右子树               3.当前节点
可以发现，就是看当前节点在哪个位置

深度优先遍历：通常使用递归，但可以参考系统栈的方式，模拟系统栈完成非递归的实现（见BST代码中前序遍历的非递归实现）
广度优先遍历（层序遍历）：使用队列方式，第一次将根节点放入队列，以后每次移出一个元素，就让它的左右子树入队


-------------------------
1.判断该二叉树是否是一棵二分搜索树
先中序遍历一遍将当前节点保存到ArrayList中，然后遍历一遍ArrayList是否是从小到大排列，是的话就是二叉搜索树。见AVLTree代码
