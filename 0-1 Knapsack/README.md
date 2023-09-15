we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).
